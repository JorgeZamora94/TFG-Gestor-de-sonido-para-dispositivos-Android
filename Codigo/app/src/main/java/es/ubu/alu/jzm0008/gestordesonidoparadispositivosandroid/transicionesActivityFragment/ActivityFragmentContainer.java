package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.transicionesActivityFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;

public class ActivityFragmentContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new Fragment1()).commit();
    }
}
