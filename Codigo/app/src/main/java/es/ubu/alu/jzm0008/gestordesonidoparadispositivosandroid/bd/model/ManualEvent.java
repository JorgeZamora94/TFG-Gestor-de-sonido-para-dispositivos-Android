package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import java.util.Calendar;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class ManualEvent extends RealmObject {

    @PrimaryKey
    private int id;

    private long inicio;
    private long fin;

    private String mensaje;

    public ManualEvent() {
    }

    public ManualEvent(long inicio, long fin, String mensaje) {
        this.id = AppConfigBd.manualId.incrementAndGet();
        this.inicio = inicio;
        this.fin = fin;
        this.mensaje = mensaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getInicio() {
        return inicio;
    }

    public void setInicio(long inicio) {
        this.inicio = inicio;
    }

    public long getFin() {
        return fin;
    }

    public void setFin(long fin) {
        this.fin = fin;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ManualEvent{" +
                "id=" + id +
                ", inicio=" + inicio +
                ", fin=" + fin +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
