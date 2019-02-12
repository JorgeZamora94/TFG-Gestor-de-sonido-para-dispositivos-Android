package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.CalendarEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.ManualEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.PeriodicEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.WifiEvent;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;


public class DeleteEventFragment extends Fragment {

    private Realm realm = Realm.getDefaultInstance();
    private RealmResults<WifiEvent> wifi = realm.where(WifiEvent.class).findAll();
    private RealmResults<ManualEvent> manual = realm.where(ManualEvent.class).findAll();
    private RealmResults<PeriodicEvent> periodic = realm.where(PeriodicEvent.class).findAll();
    private RealmResults<CalendarEvent> calendar = realm.where(CalendarEvent.class).findAll();
    private RealmResults<GPSEvent> gps = realm.where(GPSEvent.class).findAll();



    private Spinner spinner = null;
    private TextView textoInfo = null;

    public DeleteEventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button button = null;
        View view = inflater.inflate(R.layout.fragment_delete_event, container, false);



        List<Iterator> itList = new ArrayList<>();
        itList.add(wifi.listIterator());
        itList.add(manual.listIterator());
        itList.add(periodic.listIterator());
        itList.add(calendar.listIterator());
        itList.add(gps.listIterator());

        List<RealmObject> lista = new ArrayList<>();
        for(Iterator it : itList) {
            while (it.hasNext()) {
                RealmObject s = (RealmObject) it.next();
                lista.add(s);
            }
        }

        ArrayAdapter adaptador =
                new ArrayAdapter( getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_item, lista);

        spinner = (Spinner) view.findViewById(R.id.listEventSpinner);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adaptador);

        button = (Button) view.findViewById(R.id.deleteButton);
        textoInfo = (TextView) view.findViewById(R.id.eventoSeleccionadoText);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                RealmObject evento = (RealmObject) spinner.getSelectedItem();
                textoInfo.setText(evento.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                RealmObject object = (RealmObject) spinner.getSelectedItem();
                if(object != null){
                    realm.beginTransaction();
                    object.deleteFromRealm();
                    realm.commitTransaction();
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, new DeleteEventFragment()).commit();
                }

            }
        });

        return view;
    }


}
