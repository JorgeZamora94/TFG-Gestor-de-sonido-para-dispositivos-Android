package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.CalendarEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.SettingControl;
import io.realm.Realm;
import io.realm.RealmResults;

public class CalendarFragment extends Fragment {

    private Spinner spinner;
    private Button button;
    private TextView nameEvent;
    private TextView nameCalendarEvent;
    private Realm realm = Realm.getDefaultInstance();
    private RealmResults<SettingControl> settingsControls = realm.where(SettingControl.class).findAll();



    public CalendarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        Iterator it = settingsControls.listIterator();
        List lista = new ArrayList<>();
        while(it.hasNext()){
            SettingControl s = (SettingControl) it.next();
            lista.add(s);
        }
        ArrayAdapter adaptador =
                new ArrayAdapter( getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_item, lista);

        button = (Button) view.findViewById(R.id.calendarButton);

        nameEvent = (TextView) view.findViewById(R.id.calendarEditText);

        nameCalendarEvent = (TextView) view.findViewById(R.id.eventCalendarNameEditText);

        spinner = (Spinner) view.findViewById(R.id.calendarSpinner);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adaptador);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nameCalendarEvent.getText() == null || nameCalendarEvent.getText().toString().equals("") ||
                        nameEvent.getText() == null || nameEvent.getText().toString().equals("") ||
                        spinner.getSelectedItem() == null) {
                    MainActivityDemo.alertaCamposSinRellenar(getContext());
                } else {
                    realm.beginTransaction();
                    int id1= AppConfigBd.calendarId.get();

                    CalendarEvent calendarEvent = new CalendarEvent(nameCalendarEvent.getText().toString(), nameEvent.getText().toString(),  "calendar event", (SettingControl) spinner.getSelectedItem());
                    int id2=AppConfigBd.calendarId.get();
                    if(id1!=id2)
                        MainActivityDemo.alertaGuardado(getContext());
                    realm.copyToRealm(calendarEvent);
                    realm.commitTransaction();
                }

            }
        });

        return view;
    }


}
