package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class WifiEvent extends RealmObject {
    @PrimaryKey
    private int id;
    private String ssid;
    private String mensaje;

    public WifiEvent() {
    }

    public WifiEvent(String ssid, String mensaje) {
        this.id = AppConfigBd.wifiId.incrementAndGet();
        this.ssid = ssid;
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "WifiEvent{" +
                "id=" + id +
                ", ssid='" + ssid + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
