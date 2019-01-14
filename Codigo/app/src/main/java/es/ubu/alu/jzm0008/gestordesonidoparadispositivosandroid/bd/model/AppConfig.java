package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class AppConfig extends RealmObject {

    @PrimaryKey
    private int id;

    private int distance;
    private boolean calendar;
    private boolean wifi;
    private boolean manual;
    private boolean periodic;
    private boolean gps;

    public AppConfig() {
    }

    public AppConfig(int id, int distance, boolean calendar, boolean wifi, boolean manual, boolean periodic, boolean gps) {
        this.id = id;
        this.distance = distance;
        this.calendar = calendar;
        this.wifi = wifi;
        this.manual = manual;
        this.periodic = periodic;
        this.gps = gps;
    }

    public int getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isCalendar() {
        return calendar;
    }

    public void setCalendar(boolean calendar) {
        this.calendar = calendar;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean isPeriodic() {
        return periodic;
    }

    public void setPeriodic(boolean periodic) {
        this.periodic = periodic;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }
}
