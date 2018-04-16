package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.transicionesActivityFragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;

public class Activity1 extends AppCompatActivity {

    Button boton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        boton = (Button) findViewById(R.id.button1);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity1.this, Activity2.class));
            }
        });
    }
}
