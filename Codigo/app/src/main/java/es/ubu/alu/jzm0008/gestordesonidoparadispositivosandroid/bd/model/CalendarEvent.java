package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class CalendarEvent extends RealmObject {
    @PrimaryKey
    private int id;

    String idCalendarEvent;
    String mensaje;

    public CalendarEvent() {
    }

    public CalendarEvent(String idCalendarEvent, String mensaje) {
        this.id = AppConfigBd.calendarId.incrementAndGet();
        this.idCalendarEvent = idCalendarEvent;
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCalendarEvent() {
        return idCalendarEvent;
    }

    public void setIdCalendarEvent(String idCalendarEvent) {
        this.idCalendarEvent = idCalendarEvent;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "CalendarEvent{" +
                "id=" + id +
                ", idCalendarEvent='" + idCalendarEvent + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
