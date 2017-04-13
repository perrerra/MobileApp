package model;

import android.location.Location;

/**
 * Created by Pierre on 12/04/2017.
 */

public class Adress {

    private String country;
    private String city;
    private String adress;
    private Double lat;
    private Double lng;

    public Adress(String country, String city, String adress, Double lat, Double lng) {
        this.country = country;
        this.city = city;
        this.adress = adress;
        this.lat = lat;
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
