package utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.maps.model.LatLng;

import model.User;

/**
 * Created by Pierre on 13/04/2017.
 */

public class UserLocationListener implements LocationListener {

    private static UserLocationListener instance = null;

    private UserLocationListener(){
    }

    public static UserLocationListener getInstance(){
        if(instance == null)
        {
            instance = new UserLocationListener();
        }
        return instance;
    }

    private static final String TAG = "Debug";
    private Context context;
    private User user;

    public User getUser() {
        return user;
    }
    public LatLng getUserLatLng() {
        return new LatLng(user.getLat(), user.getLng()) ;
    }
    public Location getUserLocation() {
        Location loc = new Location("");
        loc.setLatitude(user.getLat());
        loc.setLongitude(user.getLng());
        return loc;
    }


    public UserLocationListener setMyLocationListener(Context context, User user){
        this.context = context;
        this.user = user;

        LocationManager locationManager = (LocationManager)
                this.context.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this.context, Manifest.permission.ACCESS_COARSE_LOCATION)
                ==PackageManager.PERMISSION_GRANTED)
        {
           locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
        }

        Location loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        this.user.setLat(loc.getLatitude());
        this.user.setLng(loc.getLongitude());
        return this;
    }


    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
