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

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
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
                if (distanciaCoord(event.getLat(), event.getLon(), location.getLatitude(), location.getLongitude(), event.getDistancia())) {
                    AudioController audioController = new AudioController(context);
                    audioController.cambiaSonido(event.getSettingControl());
                    MainActivityDemo.infoConfig = event.getSettingControl().toString();
                    MainActivityDemo.sendNotification(context);
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

    /**
     * Función auxiliar que nos permite saber si la localización actual gps esta a x distancia del punto guardado en base de datos
     * Código del algoritmo: https://donnierock.com/2015/03/16/calculando-la-distancia-entre-doos-coordenadas-en-java/
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @param distanciaPermitida
     * @return
     */
    public static boolean distanciaCoord(double lat1, double lng1, double lat2, double lng2, int distanciaPermitida) {

        double radioTierra = 6371;//en kilómetros
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;

        return distanciaPermitida >= distancia*1000;
    }

}
