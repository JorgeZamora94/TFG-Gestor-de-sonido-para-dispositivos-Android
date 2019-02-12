package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import java.text.SimpleDateFormat;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class PeriodicEvent extends RealmObject {
    @PrimaryKey
    private int id;
    private String nombre;
    private long inicio;
    private long fin;
    private String calendario;
    private SettingControl settingControl;

    public PeriodicEvent() {
    }

    public PeriodicEvent(String nombre, long inicio, long fin, String calendario, SettingControl settingControl) {
        this.id = AppConfigBd.periodicId.incrementAndGet();
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.calendario = calendario;
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

    public SettingControl getSettingControl() {
        return settingControl;
    }

    public void setSettingControl(SettingControl settingControl) {
        this.settingControl = settingControl;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return "Evento periódico\n Nombre:" + nombre + "\n Inicio: " + sdf.format(inicio) + "\n Fin: " + sdf.format(fin) + "\n Día de la semana: " + calendario + "\n Perfil de sonido: " + settingControl;
    }
}
