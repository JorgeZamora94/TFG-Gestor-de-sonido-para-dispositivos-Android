package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico;

import java.io.Serializable;
import java.util.Calendar;

public class EventoPeriodico implements Serializable {

    private Calendar incio;
    private Calendar fin;
    private int diaSemana;

    private String textoEvento;

    public EventoPeriodico(Calendar incio, Calendar fin, int diaSemana, String textoEvento) {
        this.incio = incio;
        this.fin = fin;
        this.diaSemana = diaSemana;
        this.textoEvento = textoEvento;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Calendar getIncio() {
        return incio;
    }

    public void setIncio(Calendar incio) {
        this.incio = incio;
    }

    public Calendar getFin() {
        return fin;
    }

    public void setFin(Calendar fin) {
        this.fin = fin;
    }

    public String getTextoEvento() {
        return textoEvento;
    }

    public void setTextoEvento(String textoEvento) {
        this.textoEvento = textoEvento;
    }
}
