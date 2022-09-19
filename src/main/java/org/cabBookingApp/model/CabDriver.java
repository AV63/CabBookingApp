package org.cabBookingApp.model;

import org.springframework.lang.NonNull;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CabDriver {

    @Id @GeneratedValue
    Integer DriverId;
    @NonNull String name;
    @NonNull Character gender;
    @NonNull Integer age;
    @NonNull String carName;
    @NonNull String carNo;

    @Embedded Location location;

    boolean isAvailable = true;

    public CabDriver() {
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Location getLocation() {
        return location;
    }


    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public CabDriver(@NonNull String name, @NonNull Character gender, @NonNull Integer age, @NonNull String carName, @NonNull String carNo, @NonNull Location location) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.carName = carName;
        this.carNo = carNo;
        this.location = location;
    }

}
