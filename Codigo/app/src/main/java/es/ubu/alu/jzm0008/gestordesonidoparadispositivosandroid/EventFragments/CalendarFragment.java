package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.CalendarEvent;
import io.realm.Realm;

public class CalendarFragment extends Fragment {

    private Button button;
    private TextView nameEvent;

    Realm realm = Realm.getDefaultInstance();

    public CalendarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calendar, container, false);



        button = (Button) view.findViewById(R.id.calendarButton);

        nameEvent = (TextView) view.findViewById(R.id.calendarEditText);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                realm.beginTransaction();
                int id1= AppConfigBd.calendarId.get();

                CalendarEvent calendarEvent = new CalendarEvent(nameEvent.getText().toString(), "calendar event");
                int id2=AppConfigBd.calendarId.get();
                if(id1!=id2)
                    MainActivityDemo.alertaGuardado(getContext());
                realm.copyToRealm(calendarEvent);
                realm.commitTransaction();
            }
        });

        return view;
    }


}
