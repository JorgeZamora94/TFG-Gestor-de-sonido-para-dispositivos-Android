package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments.CalendarFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments.GpsFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments.ManualFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments.PeriodicFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.EventFragments.WifiFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.GPSListener.GPSListener;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.ObservadorGenerico.Observador;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.CalendarEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.ManualEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.PeriodicEvent;
import io.realm.Realm;
import io.realm.RealmResults;
import me.everything.providers.android.calendar.CalendarProvider;
import me.everything.providers.android.calendar.Event;
import me.everything.providers.core.Data;

public class MainActivityDemo extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_demo);
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navview);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.nuevo_manual:
                        fragment = new ManualFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.nuevo_periodico:
                        fragment = new PeriodicFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.nuevo_wifi:
                        fragment = new WifiFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.nuevo_gps:
                        fragment = new GpsFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.nuevo_calendario:
                        fragment = new CalendarFragment();
                        fragmentTransaction = true;
                }

                if (fragmentTransaction) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        GPSListener gps = new GPSListener(this);
        Timer timerObj = new Timer();
        TimerTask observador = new Observador(this);
        timerObj.schedule(observador, 500, 15000);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static void alertaGuardado(Context context){
        Toast.makeText(context, "Evento guardado", Toast.LENGTH_SHORT).show();
    }

    public static void alertaEventoGPS(Context context){
        Toast.makeText(context, "Evento gps detectado", Toast.LENGTH_SHORT).show();
    }
    public static void alertaEventoWifi(Context context){
        Toast.makeText(context, "Evento wifi detectado", Toast.LENGTH_SHORT).show();
    }
    public static void alertaEventoPeriodico(Context context){
        Toast.makeText(context, "Evento periodico detectado", Toast.LENGTH_SHORT).show();
    }
    public static void alertaEventoManual(Context context){
        Toast.makeText(context, "Evento manual detectado", Toast.LENGTH_SHORT).show();
    }
    public static void alertaEventoCalendario(Context context){
        Toast.makeText(context, "Evento calendario detectado", Toast.LENGTH_SHORT).show();
    }


    public static void controlador(Context context){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<ManualEvent> manuales = realm.where(ManualEvent.class).findAll();
        RealmResults<PeriodicEvent> periodicos = realm.where(PeriodicEvent.class).findAll();
        RealmResults<CalendarEvent> calendarEvents = realm.where(CalendarEvent.class).findAll();



        Calendar ahora = Calendar.getInstance();
        for(ManualEvent eventoManual : manuales) {
            Calendar inicio = Calendar.getInstance(); inicio.setTimeInMillis(eventoManual.getInicio());
            Calendar fin = Calendar.getInstance();fin.setTimeInMillis(eventoManual.getFin());

            if(inicio.before(ahora) && fin.after(ahora)){
                MainActivityDemo.alertaEventoManual(context);
            }
        }

        for(PeriodicEvent eventoPeriodico : periodicos) {
            Calendar inicio = Calendar.getInstance();inicio.setTimeInMillis(eventoPeriodico.getInicio());
            Calendar fin = Calendar.getInstance();inicio.setTimeInMillis(eventoPeriodico.getFin());
            Calendar inicio1 = Calendar.getInstance();
            inicio1.set(Calendar.HOUR, inicio.get(Calendar.HOUR));
            inicio1.set(Calendar.MINUTE, inicio.get(Calendar.MINUTE));
            Calendar fin1 = Calendar.getInstance();
            fin1.set(Calendar.HOUR, fin1.get(Calendar.HOUR));
            fin1.set(Calendar.MINUTE, fin1.get(Calendar.MINUTE));
            int diaSemana = inicio.get(Calendar.DAY_OF_WEEK);
            if(inicio1.before(ahora) && fin1.after(ahora) && ahora.get(Calendar.DAY_OF_WEEK) == diaSemana){
                MainActivityDemo.alertaEventoPeriodico(context);
            }
        }

        CalendarProvider provider = new CalendarProvider(context);
        List<me.everything.providers.android.calendar.Calendar> calendars = provider.getCalendars().getList();
        for(int y = 0; y <= 50;y++) {
            Data<Event> events = provider.getEvents(y);
            for (Event event : events.getList()) {
                Calendar inicio = Calendar.getInstance();
                Calendar fin = Calendar.getInstance();
                inicio.setTimeInMillis(event.dTStart);
                fin.setTimeInMillis(event.dTend);
                if(inicio.before(ahora) && fin.after(ahora)){
                    MainActivityDemo.alertaEventoCalendario(context);
                }
            }
        }
    }

}
