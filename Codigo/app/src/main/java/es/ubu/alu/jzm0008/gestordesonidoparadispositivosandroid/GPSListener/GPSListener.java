package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.gpslistener;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.modificadorsonido.AudioController;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.content.Context.LOCATION_SERVICE;

public class GPSListener implements LocationListener {
    private final Context context;

    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;

    private Location location;
    protected LocationManager locationManager;

    public GPSListener(Context context){
        boolean isGPSEnabled =false;
        this.context=context;
        if (ActivityCompat.checkSelfPermission( context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
        locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        isGPSEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);

        if(isGPSEnabled && location==null) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
            if (locationManager != null) {
                this.location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
        }
    }

    public Location getLocation(){
        //Toast.makeText(context,location.toString(),Toast.LENGTH_SHORT).show();
        return this.location;
    }
    
    public void onLocationChanged(Location location){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<GPSEvent> manuales = realm.where(GPSEvent.class).findAll();
        for(final GPSEvent eventoGps : manuales) {
            if(location.getLongitude()==eventoGps.getLon() && location.getLatitude() == eventoGps.getLat()){
                Handler handler = new Handler(Looper.getMainLooper());

                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        AudioController audioController = new AudioController(context);
                        audioController.cambiaSonido(eventoGps.getSettingControl());
                    }
                });
            }
        }
        this.location = location;
    }

    public void onStatusChanged(String Provider, int status, Bundle extras){
        Log.i("GPSListener", "StatusChanged");
    }
    public void onProviderEnabled(String Provider){
        Log.i("GPSListener", "Enabled");
    }
    public void onProviderDisabled(String Provider){
        Log.i("GPSListener", "Disabled");
    }
    public IBinder onBind(Intent arg0){
        return null;
    }

}

