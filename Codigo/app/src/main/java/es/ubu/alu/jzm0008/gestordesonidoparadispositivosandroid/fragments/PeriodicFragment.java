package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.PeriodicEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.SettingControl;
import io.realm.Realm;
import io.realm.RealmResults;


public class PeriodicFragment extends Fragment {

    private Button selectoHora1;
    private Button selectoHora2;
    private Button savePeriodico;
    private Spinner diaSemana;
    private Spinner spinner;

    private EditText nombre;

    private Calendar inicio = null;
    private Calendar fin = null;

    private Realm realm = Realm.getDefaultInstance();
    private RealmResults<SettingControl> settingsControls = realm.where(SettingControl.class).findAll();



    public PeriodicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_periodic, container, false);

        nombre = (EditText) view.findViewById(R.id.eventPeriodicNameEditText);

        selectoHora1 = (Button) view.findViewById(R.id.selectTimePeriodico1Button);


        selectoHora1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        inicio = Calendar.getInstance();
                        inicio.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        inicio.set(Calendar.MINUTE, minute);
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                        selectoHora1.setText(sdf.format(inicio.getTime()));
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                timePickerDialog.show();
            }

        });






        selectoHora2 = (Button) view.findViewById(R.id.selectTimePeriodico2Button);

        selectoHora2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        fin = Calendar.getInstance();
                        fin.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        fin.set(Calendar.MINUTE, minute);
                        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                        selectoHora2.setText(sdf.format(fin.getTime()));
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                timePickerDialog.show();
            }

        });

        final List<String> diasSemana = new ArrayList();
        diasSemana.add(getString(R.string.lunes));
        diasSemana.add(getString(R.string.martes));
        diasSemana.add(getString(R.string.miercoles));
        diasSemana.add(getString(R.string.jueves));
        diasSemana.add(getString(R.string.viernes));
        diasSemana.add(getString(R.string.sabado));
        diasSemana.add(getString(R.string.domingo));

        ArrayAdapter adaptadorDias =
                new ArrayAdapter( getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_item, diasSemana);

        diaSemana = (Spinner) view.findViewById(R.id.periodicoDiaSpinner);
        adaptadorDias.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        diaSemana.setAdapter(adaptadorDias);

        Iterator it = settingsControls.listIterator();
        List lista = new ArrayList<>();
        while(it.hasNext()){
            SettingControl s = (SettingControl) it.next();
            lista.add(s);
        }
        ArrayAdapter adaptadorConfig =
                new ArrayAdapter( getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_item, lista);

        spinner = (Spinner) view.findViewById(R.id.periodicoConfigSpinner);
        adaptadorConfig.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adaptadorConfig);


        savePeriodico = (Button) view.findViewById(R.id.savePeriodicoButton);


        savePeriodico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(inicio == null ||
                    fin == null ||
                    nombre.getText() == null || nombre.getText().toString().equals("") ||
                    spinner.getSelectedItem() == null) {
                MainActivityDemo.alertaCamposSinRellenar(getContext());
            } else {
                realm.beginTransaction();
                int id1= AppConfigBd.periodicId.get();
                int i = diaSemana.getSelectedItemPosition();
                switch (diaSemana.getSelectedItem().toString()){
                    case "Lunes":
                        i = 2;
                        break;
                    case "Martes":
                        i = 3;
                        break;
                    case "Miercoles":
                        i = 4;
                        break;
                    case "Jueves":
                        i = 5;
                        break;
                    case "Viernes":
                        i = 6;
                        break;
                    case "Sábado":
                        i = 7;
                        break;
                    case "Domingo":
                        i = 1;
                        break;
                    case "Monday":
                        i = 2;
                        break;
                    case "Tuesday":
                        i = 3;
                        break;
                    case "Wednesday":
                        i = 4;
                        break;
                    case "Thursday":
                        i = 5;
                        break;
                    case "Friday":
                        i = 6;
                        break;
                    case "Saturday":
                        i = 7;
                        break;
                    case "Sunday":
                        i = 1;
                        break;

                }
                inicio.set(Calendar.DAY_OF_WEEK,i);
                PeriodicEvent periodicEvent = new PeriodicEvent(nombre.getText().toString(), inicio.getTimeInMillis(), fin.getTimeInMillis(), diaSemana.getSelectedItem().toString(), (SettingControl) spinner.getSelectedItem());
                int id2=AppConfigBd.periodicId.get();
                if(id1!=id2)
                    MainActivityDemo.alertaGuardado(getContext());
                realm.copyToRealm(periodicEvent);
                realm.commitTransaction();
            }

            }
        });
        return view;
    }


}
