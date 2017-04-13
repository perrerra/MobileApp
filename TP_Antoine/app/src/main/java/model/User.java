package model;

import android.location.Location;

import java.util.Date;

/**
 * Created by Pierre on 12/04/2017.
 */

public class User {

    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private Double lat;
    private Double lng;

    public User(){}

    public User(String firstname, String lastname, String username, String password, Double lat, Double lng) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.lat = lat;
        this.lng = lng;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
