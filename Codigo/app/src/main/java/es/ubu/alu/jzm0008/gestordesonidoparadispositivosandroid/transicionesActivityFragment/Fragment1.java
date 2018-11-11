package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.transicionesactivityfragment;

import android.app.Fragment;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;


public class Fragment1 extends Fragment {

    Button boton;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        boton = (Button) view.findViewById(R.id.botonFragment1);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.content_frame, new Fragment2()).commit();
            }
        });
        return view;
    }

}
