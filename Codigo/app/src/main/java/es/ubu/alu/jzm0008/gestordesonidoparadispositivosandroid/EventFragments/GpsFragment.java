package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.GPSListener.GPSListener;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import io.realm.Realm;


public class GpsFragment extends Fragment {


    private Button button;
    Realm realm = Realm.getDefaultInstance();

    public GpsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gps, container, false);





        button = (Button) view.findViewById(R.id.gpsButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GPSListener gps = new GPSListener(getContext());

                realm.beginTransaction();
                int id1= AppConfigBd.gpsId.get();

                GPSEvent gpsEvent = new GPSEvent(gps.getLocation().getLongitude(), gps.getLocation().getLatitude(),"gpsEvent");
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
