package model;

import android.provider.BaseColumns;

import model.base.EntityBase;

/**
 * Created by Pierre on 12/04/2017.
 */

public class Address {

    private long id;



    private String country;
    private String city;
    private String adress;
    private Double lat;
    private Double lng;

    public Address(String country, String city, String adress, Double lat, Double lng) {
        this.country = country;
        this.city = city;
        this.adress = adress;
        this.lat = lat;
        this.lng = lng;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
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

    public static class AddressEntry implements BaseColumns {
        public static final String TABLE_NAME = "address";
        public static final String COLUMN_NAME_COUNTRY = "country";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_ADRESS = "adress";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LNG = "lng";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + AddressEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        AddressEntry.COLUMN_NAME_COUNTRY + " TEXT," +
                        AddressEntry.COLUMN_NAME_ADRESS + " TEXT," +
                        AddressEntry.COLUMN_NAME_CITY + " TEXT," +
                        AddressEntry.COLUMN_NAME_LAT + " REAL," +
                        AddressEntry.COLUMN_NAME_LNG + " REAL);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + AddressEntry.TABLE_NAME + ";";
    }
}
