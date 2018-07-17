package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import java.util.Calendar;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class PeriodicEvent extends RealmObject {
    @PrimaryKey
    private int id;
    private long inicio;
    private long fin;
    private String calendario;

    public PeriodicEvent() {
    }

    public PeriodicEvent(long inicio, long fin, String calendario) {
        this.id = AppConfigBd.periodicId.incrementAndGet();
        this.inicio = inicio;
        this.fin = fin;
        this.calendario = calendario;
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

    public String getCalendario() {
        return calendario;
    }

    public void setCalendario(String calendario) {
        this.calendario = calendario;
    }
}
