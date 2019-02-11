package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class CalendarEvent extends RealmObject {
    @PrimaryKey
    private int id;

    private String nombre;
    private String idCalendarEvent;
    private String mensaje;
    private SettingControl settingControl;

    public CalendarEvent() {
    }

    public CalendarEvent(String nombre, String idCalendarEvent, String mensaje, SettingControl settingControl) {
        this.id = AppConfigBd.calendarId.incrementAndGet();
        this.nombre = nombre;
        this.idCalendarEvent = idCalendarEvent;
        this.mensaje = mensaje;
        this.settingControl = settingControl;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdCalendarEvent() {
        return idCalendarEvent;
    }

    public void setIdCalendarEvent(String idCalendarEvent) {
        this.idCalendarEvent = idCalendarEvent;
    }

    public SettingControl getSettingControl() {
        return settingControl;
    }

    public void setSettingControl(SettingControl settingControl) {
        this.settingControl = settingControl;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Evento de calendario:" +
                "\n Nombre: " + nombre + "\n Nombre evento: " + idCalendarEvent + "\n Perfil de sonido " + settingControl;
    }
}
