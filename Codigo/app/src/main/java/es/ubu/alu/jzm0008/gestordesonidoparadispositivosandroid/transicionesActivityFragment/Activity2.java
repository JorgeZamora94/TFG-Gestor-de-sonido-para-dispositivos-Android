package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.transicionesactivityfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;

public class Activity2 extends AppCompatActivity {

    Button boton1;
    Button boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        boton1 = (Button) findViewById(R.id.button2);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Activity1 = new Intent(getApplicationContext(), Activity1.class);
                startActivity(Activity1);
            }
        });

        boton2 = (Button) findViewById(R.id.buttonFragment);

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent FragmentContainerActivity = new Intent(getApplicationContext(), ActivityFragmentContainer.class);
                startActivity(FragmentContainerActivity);
            }
        });
    }
}
