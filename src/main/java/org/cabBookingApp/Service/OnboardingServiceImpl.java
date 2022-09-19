package org.cabBookingApp.Service;

import org.cabBookingApp.Repository.CabDriverRepository;
import org.cabBookingApp.Repository.UserRepository;
import org.cabBookingApp.constants.Constant;
import org.cabBookingApp.exceptions.InvalidAgeException;
import org.cabBookingApp.exceptions.InvalidGenderException;
import org.cabBookingApp.exceptions.InvalidNameException;
import org.cabBookingApp.model.CabDriver;
import org.cabBookingApp.model.Location;
import org.cabBookingApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnboardingServiceImpl implements IOnBoardingService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    CabDriverRepository cabDriverRepository;

    private void validate(String name, Character gender, int age) throws InvalidGenderException, InvalidNameException, InvalidAgeException {
        if(!gender.equals(Constant.MALE) && !gender.equals(Constant.FEMALE)){
            throw new InvalidGenderException(Constant.INVALID_GENDER_PROVIDED);
        }
        if(age <= 0){
            throw new InvalidAgeException(Constant.INVALID_AGE_PROVIDED);
        }
        for(Character ch: name.toCharArray()){
            if(Character.isDigit(ch)){
                throw new InvalidNameException(Constant.INVALID_NAME_PROVIDED);
            }
        }
    }

    @Override
    public void addUser(String name, Character gender, int age) throws InvalidGenderException, InvalidNameException, InvalidAgeException {
        validate(name, gender, age);
        User user = new User( name, gender, age);
        userRepository.save(user);
        System.out.println(Constant.SUCCESSFUL_USER_REGISTRATION);
    }

    @Override
    public void addDriver(String name, Character gender, int age, String vehicleName, String vehicleNo, Location location) throws InvalidGenderException, InvalidNameException, InvalidAgeException {
        validate(name, gender, age);
        CabDriver cabDriver = new CabDriver(name, gender, age, vehicleName, vehicleNo, location);
        cabDriverRepository.save(cabDriver);
        System.out.println(Constant.SUCCESSFUL_DRIVER_REGISTRATION);
    }
}
