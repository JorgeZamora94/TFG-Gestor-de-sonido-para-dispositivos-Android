package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico;

import android.content.Context;

import java.util.TimerTask;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import io.realm.Realm;

public class Observador extends TimerTask {
    private Context context;
    private Realm realm;

    public Observador(Context context) {
        this.context = context;
        realm = Realm.getDefaultInstance();
    }

    public void run() {

        MainActivityDemo.controlador(context, Realm.getDefaultInstance());

    }

}
