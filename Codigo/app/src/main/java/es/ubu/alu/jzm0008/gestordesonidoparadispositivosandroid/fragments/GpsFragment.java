package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.SettingControl;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observergps.GPSObserver;
import io.realm.Realm;
import io.realm.RealmResults;


public class GpsFragment extends Fragment {


    private Spinner spinner;
    private Button button;
    private EditText nombre;
    private Realm realm = Realm.getDefaultInstance();
    private RealmResults<SettingControl> settingsControls = realm.where(SettingControl.class).findAll();

    public GpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_gps, container, false);

            nombre = (EditText) view.findViewById(R.id.eventGPSNameEditText);
            Iterator it = settingsControls.listIterator();
            List lista = new ArrayList<>();
            while(it.hasNext()){
                SettingControl s = (SettingControl) it.next();
                lista.add(s);
            }
            ArrayAdapter adaptador =
                    new ArrayAdapter( getActivity().getBaseContext(),
                            android.R.layout.simple_spinner_item, lista);

            spinner = (Spinner) view.findViewById(R.id.gpsSpinner);
            adaptador.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adaptador);



            button = (Button) view.findViewById(R.id.gpsButton);



            button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GPSObserver gps = new GPSObserver(getContext());

                realm.beginTransaction();
                int id1= AppConfigBd.gpsId.get();

                GPSEvent gpsEvent = new GPSEvent(nombre.getText().toString(), gps.getLocation().getLongitude(), gps.getLocation().getLatitude(),"gpsEvent", (SettingControl) spinner.getSelectedItem());
                int id2=AppConfigBd.gpsId.get();
                if(id1!=id2)
                    MainActivityDemo.alertaGuardado(getContext());

                realm.copyToRealm(gpsEvent);
                realm.commitTransaction();

            }
        });
        return view;
    }


}
