package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observergps;


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

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.AppConfig;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.modificadorsonido.AudioController;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.content.Context.LOCATION_SERVICE;

public class GPSObserver implements LocationListener {

    private final Context context;


    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    private Location location;
    protected LocationManager locationManager;

    public GPSObserver(Context context){
        boolean isGPSEnabled;
        this.context=context;
        if (ActivityCompat.checkSelfPermission( context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);

        if(isGPSEnabled && location==null) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,50, this);
            if (locationManager != null) {
                this.location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
        }
    }

    public Location getLocation(){
        return this.location;
    }

    public void onLocationChanged(Location location){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.commitTransaction();
        RealmResults<GPSEvent> gps = realm.where(GPSEvent.class).findAll();
        AppConfig config = realm.where(AppConfig.class).findFirst();
        if(config.isGps())
            for(GPSEvent event : gps) {
                if (event.getLat() == location.getLatitude() && event.getLon() == location.getLongitude()) {
                    AudioController audioController = new AudioController(context);
                    audioController.cambiaSonido(event.getSettingControl());
                }
            }
        this.location = location;
    }

    public void onStatusChanged(String Provider, int status, Bundle extras){
        //OnStatusChanged
    }
    public void onProviderEnabled(String Provider){
        //OnProviderEnabled
    }
    public void onProviderDisabled(String Provider){
        //OnProviderDisabled
    }
    public IBinder onBind(Intent arg0){
        return null;
    }

}
