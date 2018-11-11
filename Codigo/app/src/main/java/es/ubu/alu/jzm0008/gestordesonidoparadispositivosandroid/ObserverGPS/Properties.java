package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observergps;



public class Properties {
    // Distancia que recorrerá el ususario para que lance evento.
    private int distancia = 50; // 100 metros

    private int distanciaMax = 100; // 100 metros

    private int distanciaMin = 20; // 100 metros

    // Tiempo que pasará para que se lance evento
    private int tiempo = 60000; // 1 minuto.

    private int tiempoMax = 3600000; // 1 minuto.

    private int tiempoMin = 30000; // 1 minuto.

    public int getDistancia() {
        return distancia;
    }

    public int getTiempo(){
        return tiempo;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getDistanciaMax() {
        return distanciaMax;
    }

    public void setDistanciaMax(int distanciaMax) {
        this.distanciaMax = distanciaMax;
    }

    public int getDistanciaMin() {
        return distanciaMin;
    }

    public void setDistanciaMin(int distanciaMin) {
        this.distanciaMin = distanciaMin;
    }

    public int getTiempoMax() {
        return tiempoMax;
    }

    public int getTiempoMin() {
        return tiempoMin;
    }

}