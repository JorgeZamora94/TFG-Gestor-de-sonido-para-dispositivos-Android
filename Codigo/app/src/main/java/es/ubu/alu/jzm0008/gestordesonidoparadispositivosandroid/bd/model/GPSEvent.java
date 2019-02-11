package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import android.location.Location;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class GPSEvent extends RealmObject {
    @PrimaryKey
    private int id;
    private int distancia;
    private String nombre;
    private double lon,lat;
    private String mensaje;
    private SettingControl settingControl;

    public GPSEvent() {
    }

    public GPSEvent(String nombre,int distancia, double lon, double lat, String mensaje, SettingControl settingControl) {
        this.id = AppConfigBd.gpsId.incrementAndGet();
        this.distancia = distancia;
        this.nombre = nombre;
        this.lon = lon;
        this.lat = lat;
        this.mensaje = mensaje;
        this.settingControl = settingControl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public SettingControl getSettingControl() {
        return settingControl;
    }

    public void setSettingControl(SettingControl settingControl) {
        this.settingControl = settingControl;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Evento gps\n Nombre: " + nombre + "\n Longitud: " + lon + "\n Latitud: " + lat + "\n Distancia: " + distancia + "\n Perfil de sonido: " + settingControl;
    }
}
