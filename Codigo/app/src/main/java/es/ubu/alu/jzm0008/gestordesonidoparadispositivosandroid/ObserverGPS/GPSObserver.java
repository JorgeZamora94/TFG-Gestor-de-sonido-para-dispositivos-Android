package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.ObserverGPS;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.ManualEvent;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.content.Context.LOCATION_SERVICE;

public class GPSObserver implements LocationListener {

    private final Context context;
    boolean isGPSEnabled =false;
    boolean isNetworkEnabled =false;
    boolean canGetLocation = false;

    static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    Location location;
    protected LocationManager locationManager;

    private Properties properties;
    public GPSObserver(Context context){
        this.properties = new Properties();
        this.context=context;
        if (ActivityCompat.checkSelfPermission( context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);

        if(isGPSEnabled){
            if(location==null) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,properties.getTiempo(),properties.getDistancia(), this);
                if (locationManager != null) {
                    this.location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                }
            }
        }
    }

    public Location getLocation(){
        return this.location;
    }

    public void onLocationChanged(Location location){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<GPSEvent> gps = realm.where(GPSEvent.class).findAll();
        for(GPSEvent event : gps) {
            if (event.getLat() == location.getLatitude() && event.getLon() == location.getLongitude()) {
                MainActivityDemo.alertaEventoGPS(context);
            }
        }
        this.location = location;
    }

    public void onStatusChanged(String Provider, int status, Bundle extras){

    }
    public void onProviderEnabled(String Provider){

    }
    public void onProviderDisabled(String Provider){

    }
    public IBinder onBind(Intent arg0){
        return null;
    }

}
