package org.cabBookingApp.model;

import com.sun.istack.NotNull;


public class Location {

    @NotNull int latitude;
    @NotNull int longitude;

    public Location() {
    }

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

}
