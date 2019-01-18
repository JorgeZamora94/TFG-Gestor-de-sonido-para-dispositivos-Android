package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.SettingControl;
import io.realm.Realm;


public class SettingControlFragment extends Fragment {

    private TextView nameConfiguration;
    private Button button;
    private SeekBar sysVolBar;
    private SeekBar appVolBar;
    private SeekBar alarmVolBar;
    private SeekBar callVolBar;
    private SeekBar notificationVolBar;


    private Realm realm;

    public SettingControlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_control, container, false);

        nameConfiguration = (TextView) view.findViewById(R.id.editTextName);
        sysVolBar = (SeekBar) view.findViewById(R.id.seekBarMain);
        appVolBar = (SeekBar) view.findViewById(R.id.seekBarMusic);
        alarmVolBar = (SeekBar) view.findViewById(R.id.seekBarAlarm);
        callVolBar = (SeekBar) view.findViewById(R.id.seekBarCall);
        notificationVolBar = (SeekBar) view.findViewById(R.id.seekBarNotification);

        realm = Realm.getDefaultInstance();
        sysVolBar.setProgress(50);
        appVolBar.setProgress(50);
        alarmVolBar.setProgress(50);
        callVolBar.setProgress(50);
        notificationVolBar.setProgress(50);


        button = (Button) view.findViewById(R.id.buttonSaveConfig);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nameConfiguration.getText() == null || nameConfiguration.getText().toString().equals("")) {
                    MainActivityDemo.alertaCamposSinRellenarConfig(getContext());
                } else {
                    String nameConf = nameConfiguration.getText().toString();
                    int sysVol = sysVolBar.getProgress();
                    int appVol = appVolBar.getProgress();
                    int alarmVol = alarmVolBar.getProgress();
                    int callVol = callVolBar.getProgress();
                    int notificationVol = notificationVolBar.getProgress();

                    realm.beginTransaction();
                    SettingControl setting = new SettingControl(nameConf, sysVol, alarmVol, appVol, callVol, notificationVol);
                    realm.copyToRealm(setting);
                    realm.commitTransaction();

                    nameConfiguration.setText("");
                    sysVolBar.setProgress(50);
                    appVolBar.setProgress(50);
                    alarmVolBar.setProgress(50);
                    callVolBar.setProgress(50);
                    notificationVolBar.setProgress(50);
                    getFragmentManager().beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
                    NavigationView navigationView = getActivity().findViewById(R.id.navview);
                    MenuItem item = navigationView.getMenu().getItem(0);
                    item.setChecked(true);
                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.inicio);
                }

            }
        });



        return view;
    }


}
