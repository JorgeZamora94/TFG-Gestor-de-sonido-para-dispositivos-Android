package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.gpsservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        GPSService s = new GPSService();
        s.startHiloGPS(this);
    }
}
