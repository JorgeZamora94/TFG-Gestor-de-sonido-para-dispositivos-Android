package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.AppConfig;
import io.realm.Realm;



public class ConfigurationFragment extends Fragment {


    private Switch activoPeriodico;
    private Switch activoManual;
    private Switch activoWifi;
    private Switch activoGps;
    private Switch activoCalendario;
    private Button boton;

    public ConfigurationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_configuration, container, false);

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.commitTransaction();
        AppConfig config = realm.where(AppConfig.class).findFirst();

        activoPeriodico = view.findViewById(R.id.periodico_activado);
        activoPeriodico.setChecked(config.isPeriodic());
        activoManual = view.findViewById(R.id.manual_activado);
        activoManual.setChecked(config.isManual());
        activoWifi = view.findViewById(R.id.wifi_activado);
        activoWifi.setChecked(config.isWifi());
        activoGps = view.findViewById(R.id.gps_activado);
        activoGps.setChecked(config.isGps());
        activoCalendario = view.findViewById(R.id.calendario_activado);
        activoCalendario.setChecked(config.isCalendar());
        boton = view.findViewById(R.id.guarda_config_bd);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                realm.commitTransaction();
                AppConfig config = realm.where(AppConfig.class).findFirst();

                realm.beginTransaction();

                config.setCalendar(activoCalendario.isChecked());
                config.setGps(activoGps.isChecked());
                config.setWifi(activoWifi.isChecked());
                config.setManual(activoManual.isChecked());
                config.setPeriodic(activoPeriodico.isChecked());
                realm.copyToRealmOrUpdate(config);
                realm.commitTransaction();
                MainActivityDemo.alertaGuardadoSetting(getContext());
            }
        });

        return view;
    }

}