package org.cabBookingApp.model;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue int userId;
    @NonNull String name;
    @NonNull Character gender;
    @NonNull int age;

    List<CabDriver> availableDrivers;

    public List<CabDriver> getAvailableDrivers() {
        return availableDrivers;
    }

    public void setAvailableDrivers(List<CabDriver> availableDrivers) {
        this.availableDrivers = availableDrivers;
    }

    public User() {
    }

    public User(@NonNull String name, @NonNull Character gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

}
