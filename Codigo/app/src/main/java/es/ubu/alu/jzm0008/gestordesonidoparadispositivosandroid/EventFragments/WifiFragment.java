package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.WifiEvent;
import io.realm.Realm;


public class WifiFragment extends Fragment {

    private EditText editText;
    private Spinner spinner;
    private Button button;
    private EditText nombre;

    Realm realm = Realm.getDefaultInstance();

    public WifiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wifi, container, false);

        editText = (EditText) view.findViewById(R.id.wiffiEditText);
        button = (Button) view.findViewById(R.id.wiffiButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realm.beginTransaction();
                int id1=AppConfigBd.wifiId.get();
                WifiEvent wifiEvent = new WifiEvent(nombre.getText().toString(),editText.getText().toString());
                int id2=AppConfigBd.wifiId.get();
                if(id1!=id2)
                    MainActivityDemo.alertaGuardado(getContext());
                realm.copyToRealm(wifiEvent);
                realm.commitTransaction();

            }
        });
        return view;
    }


}
