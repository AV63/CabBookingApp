package org.cabBookingApp.Service;

import org.cabBookingApp.exceptions.CabDriverNotFoundException;
import org.cabBookingApp.exceptions.UserNotFoundException;
import org.cabBookingApp.model.Location;

public interface ICabBookingService {

    void findRide(String userName, Location source, Location destination) throws UserNotFoundException, CabDriverNotFoundException;

    void chooseRide(String userName, String driverName) throws CabDriverNotFoundException;

}
