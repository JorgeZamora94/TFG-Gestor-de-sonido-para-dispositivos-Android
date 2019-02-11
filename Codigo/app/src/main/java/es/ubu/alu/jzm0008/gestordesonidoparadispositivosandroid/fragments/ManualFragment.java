package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
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
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.ManualEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.SettingControl;
import io.realm.Realm;
import io.realm.RealmResults;

public class ManualFragment extends Fragment {

    private Realm realm = Realm.getDefaultInstance();
    private RealmResults<SettingControl> settingsControls = realm.where(SettingControl.class).findAll();


    private Spinner spinner = null;

    private Button buttonSelectDate;
    private Button buttonSelectTime1;
    private Button buttonSelectTime2;
    private Button buttonsaveManual;

    private Calendar dia = null;
    private Calendar inicio = null;
    private Calendar fin = null;
    private EditText nombre;



    public ManualFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manual, container, false);

        nombre = (EditText) view.findViewById(R.id.eventManualNameEditText);


        Iterator it = settingsControls.listIterator();
        List lista = new ArrayList<>();
        while(it.hasNext()){
            SettingControl s = (SettingControl) it.next();
            lista.add(s);
        }

        ArrayAdapter adaptador =
                new ArrayAdapter( getActivity().getBaseContext(),
                        android.R.layout.simple_spinner_item, lista);

        spinner = (Spinner) view.findViewById(R.id.spinnerConfManual);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adaptador);


        buttonSelectDate = (Button) view.findViewById(R.id.buttonSelectDiaManual);

        buttonSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int mYear = calendar.get(Calendar.YEAR);
                final int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dia = Calendar.getInstance();
                                dia.set(year, monthOfYear, dayOfMonth);
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                buttonSelectDate.setText(sdf.format(dia.getTime()));
                            }
                        }, mYear, mMonth, mDay);

                dpd.show();
            }
        });

        buttonSelectTime1 = (Button) view.findViewById(R.id.buttonSelectHInicioManual);

        buttonSelectTime1.setOnClickListener(new View.OnClickListener() {
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
                        buttonSelectTime1.setText(sdf.format(inicio.getTime()));
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                timePickerDialog.show();

            }
        });


        buttonSelectTime2 = (Button) view.findViewById(R.id.buttonSelectHFinManual);

        buttonSelectTime2.setOnClickListener(new View.OnClickListener() {
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
                        buttonSelectTime2.setText(sdf.format(fin.getTime()));
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);
                timePickerDialog.show();

            }
        });


        buttonsaveManual = (Button) view.findViewById(R.id.buttonSaveManual);
        buttonsaveManual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nombre.getText() == null || nombre.getText().toString().equals("") ||
                        dia == null ||
                        inicio == null ||
                        fin == null ||
                        spinner.getSelectedItem() == null) {
                    MainActivityDemo.alertaCamposSinRellenar(getContext());
                } else {
                    inicio.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH));

                    fin.set(dia.get(Calendar.YEAR), dia.get(Calendar.MONTH), dia.get(Calendar.DAY_OF_MONTH));


                    realm.beginTransaction();
                    int id1= AppConfigBd.manualId.get();
                    ManualEvent manualEvent = new ManualEvent(nombre.getText().toString(), inicio.getTimeInMillis(), fin.getTimeInMillis(), "evento manual", (SettingControl) spinner.getSelectedItem());
                    int id2=AppConfigBd.manualId.get();
                    if(id1!=id2)
                        MainActivityDemo.alertaGuardado(getContext());
                    realm.copyToRealm(manualEvent);
                    realm.commitTransaction();
                }



            }
        });

        return view;
    }
}
