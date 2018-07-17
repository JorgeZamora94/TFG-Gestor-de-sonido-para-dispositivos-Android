package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import android.location.Location;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class GPSEvent extends RealmObject {
    @PrimaryKey
    private int id;
    private double lon,lat;
    private String mensaje;

    public GPSEvent() {
    }

    public GPSEvent(double lon, double lat, String mensaje) {
        this.id = AppConfigBd.gpsId.incrementAndGet();
        this.lon = lon;
        this.lat = lat;
        this.mensaje = mensaje;
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

    @Override
    public String toString() {
        return "GPSEvent{" +
                "id=" + id +
                ", lon=" + lon +
                ", lat=" + lat +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
