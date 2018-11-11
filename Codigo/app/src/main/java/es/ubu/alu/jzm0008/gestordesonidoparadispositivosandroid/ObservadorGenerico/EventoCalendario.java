package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico;


import java.io.Serializable;

public class EventoCalendario implements Serializable {

    private String id;
    private String textoEvento;

    public EventoCalendario(String id, String textoEvento) {
        this.id = id;
        this.textoEvento = textoEvento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextoEvento() {
        return textoEvento;
    }

    public void setTextoEvento(String textoEvento) {
        this.textoEvento = textoEvento;
    }
}
