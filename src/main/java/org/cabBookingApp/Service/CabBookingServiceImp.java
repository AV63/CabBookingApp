package org.cabBookingApp.Service;

import org.cabBookingApp.Repository.CabDriverRepository;
import org.cabBookingApp.Repository.UserRepository;
import org.cabBookingApp.constants.Constant;
import org.cabBookingApp.exceptions.CabDriverNotFoundException;
import org.cabBookingApp.exceptions.UserNotFoundException;
import org.cabBookingApp.model.CabDriver;
import org.cabBookingApp.model.Location;
import org.cabBookingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CabBookingServiceImp implements ICabBookingService{

    @Autowired
    CabDriverRepository cabDriverRepository;

    @Autowired
    UserRepository userRepository;

    boolean isDistanceWithinRange(Location source, Location destination) {
        int sourceLatitude = source.getLatitude();
        int sourceLongitude = source.getLongitude();
        int destinationLatitude = destination.getLatitude();
        int destinationLongitude = destination.getLongitude();


        double distance = Math.sqrt(Math.pow(destinationLatitude - sourceLatitude, 2) +
                Math.pow(destinationLongitude - sourceLongitude, 2));

        return !(distance > Constant.MAX_DISTANCE_RANGE);
    }

    private void allocateAvailableDrivers(User user, Location source, List<CabDriver> drivers, List<CabDriver> availableDrivers) {
        for(CabDriver cabDriver: drivers){
            if(cabDriver.isAvailable() && isDistanceWithinRange(source, cabDriver.getLocation())){
                user.getAvailableDrivers().add(cabDriver);
            }
        }
        if(!drivers.isEmpty() && availableDrivers.isEmpty()) System.out.println(Constant.RIDE_NOT_FOUND);
        else if(drivers.isEmpty()) {
            System.out.println(Constant.CAB_DRIVER_UNAVAILABLE);
        }
        else {
            for(CabDriver cabDriver: availableDrivers){
                System.out.println(cabDriver.getName());
            }
        }
    }

    @Override
    public void findRide(String userName, Location source, Location destination) throws UserNotFoundException {
        List<User> users = userRepository.findByName(userName);
        List<CabDriver> drivers = cabDriverRepository.findAll();
        List<CabDriver> availableDrivers = new ArrayList<>();
        if(users.isEmpty()) throw new UserNotFoundException(String.format(Constant.USER_UNAVAILABLE, userName));
        User user = users.get(0);
        allocateAvailableDrivers(user, source, drivers, availableDrivers);
    }

    @Override
    public void chooseRide(String userName, String driverName) throws CabDriverNotFoundException {
        List<User> users = userRepository.findByName(userName);
        List<CabDriver> cabDrivers = cabDriverRepository.findByName(driverName);
        if(cabDrivers.isEmpty()) throw new CabDriverNotFoundException(Constant.CAB_DRIVER_NOT_FOUND);
        CabDriver cabDriver = cabDrivers.get(0);
        User user = users.get(0);
        if(user.getAvailableDrivers().contains(cabDriver)){
            cabDriver.setAvailable(false);
            System.out.println(Constant.RIDE_SELECTED);
        }
        else System.out.println(Constant.CAB_DRIVER_UNAVAILABLE);
    }


}
