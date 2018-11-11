package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico;

import java.io.Serializable;
import java.util.Calendar;

public class EventoManual implements Serializable {

    private Calendar inicio;
    private Calendar fin;

    private String textoEevento;

    public EventoManual(Calendar inicio, Calendar fin, String textoEevento) {

        this.inicio = inicio;
        this.fin = fin;
        this.textoEevento = textoEevento;
    }

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getFin() {
        return fin;
    }

    public void setFin(Calendar fin) {
        this.fin = fin;
    }

    public String getTextoEevento() {
        return textoEevento;
    }

    public void setTextoEevento(String textoEevento) {
        this.textoEevento = textoEevento;
    }


}
