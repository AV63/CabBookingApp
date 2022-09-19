package org.cabBookingApp.Driver;

import org.cabBookingApp.Service.ICabBookingService;
import org.cabBookingApp.Service.IOnBoardingService;
import org.cabBookingApp.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppDriver {

    @Autowired
    IOnBoardingService onBoardingService;

    @Autowired
    ICabBookingService cabBookingService;

    public void test()  {
        try {
            onBoardingService.addUser("Abhishek", 'M', 23);
            onBoardingService.addUser("Rahul", 'M', 29);
            onBoardingService.addUser("Nandini", 'F', 22);
            onBoardingService.addDriver("Neil", 'M', 22, "Swift", "KA-01-12345", new Location(10,1));
            onBoardingService.addDriver("Nitin", 'M', 29, "Swift", "KA-01-12345", new Location(11,10));
            onBoardingService.addDriver("Mukesh", 'M', 24, "Swift", "KA-01-12345", new Location(5,3));
            cabBookingService.findRide("Abhishek" ,new Location(0,0),new Location(
                   20,1));
            cabBookingService.findRide("Rahul" ,new Location(10,0),new Location(
                    15,3));
            cabBookingService.findRide("Nandini", new Location(15, 6),
                    new Location(20, 4));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
