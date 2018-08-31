package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;


public class ConfigHelp extends Fragment {


    public ConfigHelp() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_config_help, container, false);
        return view;
    }
}
