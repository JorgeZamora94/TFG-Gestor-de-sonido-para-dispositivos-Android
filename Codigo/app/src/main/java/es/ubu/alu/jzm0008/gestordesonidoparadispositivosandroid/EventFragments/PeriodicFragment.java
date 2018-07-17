package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments;

import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.PeriodicEvent;
import io.realm.Realm;


public class PeriodicFragment extends Fragment {

    private Button selectoHora1;
    private Button selectoHora2;
    private Button savePeriodico;
    private Spinner diaSemana;

    private EditText nombre;

    private Calendar inicio;
    private Calendar fin;

    Realm realm = Realm.getDefaultInstance();


    public PeriodicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_periodic, container, false);

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
                        selectoHora1.setText(hourOfDay+":"+minute);
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
                        selectoHora2.setText(hourOfDay+":"+minute);
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                timePickerDialog.show();
            }

        });

        final List<String> diasSemana = new ArrayList();
        diasSemana.add("Lunes");
        diasSemana.add("Martes");
        diasSemana.add("Miercoles");
        diasSemana.add("Jueves");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Domingo");

        ArrayAdapter adaptadorDias =
                new ArrayAdapter( getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_item, diasSemana);

        diaSemana = (Spinner) view.findViewById(R.id.periodicoDiaSpinner);
        adaptadorDias.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        diaSemana.setAdapter(adaptadorDias);

        savePeriodico = (Button) view.findViewById(R.id.savePeriodicoButton);

        savePeriodico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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
                    case "Sabado":
                        i = 7;
                        break;
                    case "Domingo":
                        i = 1;
                        break;

                }
                inicio.set(Calendar.DAY_OF_WEEK,i);
                PeriodicEvent periodicEvent = new PeriodicEvent(inicio.getTimeInMillis(), fin.getTimeInMillis(), "evento periodico");
                int id2=AppConfigBd.periodicId.get();
                if(id1!=id2)
                    MainActivityDemo.alertaGuardado(getContext());
                realm.copyToRealm(periodicEvent);
                    realm.commitTransaction();



            }
        });
        return view;
    }


}
