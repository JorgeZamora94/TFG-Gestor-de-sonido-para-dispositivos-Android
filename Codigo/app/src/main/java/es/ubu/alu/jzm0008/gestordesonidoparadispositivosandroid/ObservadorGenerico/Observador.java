package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico;

import android.content.Context;
import android.util.Log;

import java.util.TimerTask;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import io.realm.Realm;

public class Observador extends TimerTask {
    private Context context;

    public Observador(Context context) {
        this.context = context;
    }

    public void run() {
        try {
            MainActivityDemo.controlador(context);
        } catch (Exception e) {
            Log.e("Timer", "Error en el controlador genético");
        }


    }

}
