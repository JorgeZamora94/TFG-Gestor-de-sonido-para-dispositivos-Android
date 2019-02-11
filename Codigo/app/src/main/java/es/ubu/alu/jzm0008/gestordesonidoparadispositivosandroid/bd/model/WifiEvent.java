package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class WifiEvent extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombre;
    private String ssid;
    private String mensaje;
    private SettingControl settingControl;

    public WifiEvent() {
    }

    public WifiEvent(String nombre, String ssid, String mensaje, SettingControl settingControl) {
        this.nombre = nombre;
        this.id = AppConfigBd.wifiId.incrementAndGet();
        this.ssid = ssid;
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

    public SettingControl getSettingControl() {
        return settingControl;
    }

    public void setSettingControl(SettingControl settingControl) {
        this.settingControl = settingControl;
    }

    @Override
    public String toString() {
        return "Evento wifi\n Nombre: " + nombre + "\n Nombre red wifi: " + getSsid() + "\n Perfil de sonido: " + settingControl;
    }
}
