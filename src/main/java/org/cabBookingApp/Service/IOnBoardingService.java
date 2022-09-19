package org.cabBookingApp.Service;

import org.cabBookingApp.exceptions.InvalidAgeException;
import org.cabBookingApp.exceptions.InvalidGenderException;
import org.cabBookingApp.exceptions.InvalidNameException;
import org.cabBookingApp.model.Location;

public interface IOnBoardingService {

    void addUser(String name, Character gender, int age) throws InvalidGenderException, InvalidNameException, InvalidAgeException;

    void addDriver(String name, Character gender, int age, String vehicleName, String vehicleNo, Location location) throws InvalidGenderException, InvalidNameException, InvalidAgeException;
}
