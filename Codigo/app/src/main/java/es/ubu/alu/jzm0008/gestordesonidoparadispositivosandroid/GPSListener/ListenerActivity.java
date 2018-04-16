package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.GPSListener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;

public class ListenerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listener);
        GPSListener gpsListener = new GPSListener(this);
        System.out.println("Listener");
        System.out.println(gpsListener.getLocation());

        if(gpsListener.getLocation()!=null){
            Toast.makeText(this,gpsListener.getLocation().toString(),Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this,"nada",Toast.LENGTH_SHORT).show();
        }
    }
}
