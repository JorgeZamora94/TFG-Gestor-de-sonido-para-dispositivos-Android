package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities;

import android.Manifest;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;



import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.AppConfig;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.CalendarFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.ConfigurationFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.DeleteEventFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.GpsFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.MainFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.ManualFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.PeriodicFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.SettingControlFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.fragments.WifiFragment;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpfragments.ConfigHelp;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico.Observador;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico.ProveedorWifi;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.R;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.CalendarEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.ManualEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.PeriodicEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.WifiEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpfragments.CalendarHelp;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpfragments.GPSHelp;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpfragments.ManualHelp;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpfragments.PeriodicHelp;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.helpfragments.WifiHelp;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.modificadorsonido.AudioController;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observergps.GPSObserver;
import io.realm.Realm;
import io.realm.RealmResults;
import me.everything.providers.android.calendar.CalendarProvider;
import me.everything.providers.android.calendar.Event;
import me.everything.providers.core.Data;

public class MainActivityDemo extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    MenuItem lastItem = null;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        verifyPermission();

        setContentView(R.layout.activity_main_demo);
        setToolbar();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        generaConfiguracion();
        cargaPantallaInicial();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;


                switch (item.getItemId()) {
                    case R.id.inicio_app:
                        fragment = new MainFragment();
                        fragmentTransaction = true;
                        break;
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
                        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                                fragment = new GpsFragment();
                                fragmentTransaction = true;
                            }
                        }
                        break;
                    case R.id.nuevo_calendario:
                        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            if (checkSelfPermission(Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                                fragment = new CalendarFragment();
                                fragmentTransaction = true;
                            }
                        }
                        break;
                    case R.id.ayuda_manual:
                        fragment = new ManualHelp();
                        fragmentTransaction = true;
                        break;
                    case R.id.ayuda_periodico:
                        fragment = new PeriodicHelp();
                        fragmentTransaction = true;
                        break;
                    case R.id.ayuda_wifi:
                        fragment = new WifiHelp();
                        fragmentTransaction = true;
                        break;
                    case R.id.ayuda_gps:
                        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                                fragment = new GPSHelp();
                                fragmentTransaction = true;
                            }
                        }

                        break;
                    case R.id.ayuda_calendario:
                        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                            if (checkSelfPermission(Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                                fragment = new CalendarHelp();
                                fragmentTransaction = true;
                            }
                        }
                        break;
                    case R.id.ayuda_configuracion:
                        fragment = new ConfigHelp();
                        fragmentTransaction = true;
                        break;
                    case R.id.nueva_configuracion:
                        fragment = new SettingControlFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.elimina_evento:
                        fragment = new DeleteEventFragment();
                        fragmentTransaction = true;
                        break;
                    case R.id.configuracion_aplicacion:
                        fragment = new ConfigurationFragment();
                        fragmentTransaction = true;
                        break;
                    default:
                        break;


                }

                if (fragmentTransaction) {
                    if(lastItem != null)
                        lastItem.setChecked(false);
                    lastItem = item;
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
                    item.setChecked(true);
                    getSupportActionBar().setTitle(item.getTitle());
                    drawerLayout.closeDrawers();
                }
                return true;
            }
        });

        activaHilo();
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                GPSObserver gpsObserver = new GPSObserver(this);
            }
        }

    }

    public void cargaPantallaInicial() {
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
        MenuItem item = navigationView.getMenu().getItem(0);
        item.setChecked(true);
        getSupportActionBar().setTitle(R.string.inicio);
    }

    /**
     * Método que se encarga de setear el toolbar de la aplicación
     */
    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Método que se encarga de cambiar los fragmentos de nuestra aplicación.
     * @param item fragmento a cambiar.
     * @return confirmación de si se ha cambiado o no el fragmento.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Método que se encarga de verificar si hay un evento lanzado o no.
     * @param context contexto de la aplicación.
     */
    public static void controlador(Context context){

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.commitTransaction();
        RealmResults<ManualEvent> manuales = realm.where(ManualEvent.class).findAll();
        RealmResults<PeriodicEvent> periodicos = realm.where(PeriodicEvent.class).findAll();
        RealmResults<CalendarEvent> calendarEvents = realm.where(CalendarEvent.class).findAll();
        AppConfig config = realm.where(AppConfig.class).findFirst();
        RealmResults<AppConfig> configList = realm.where(AppConfig.class).findAll();


        Calendar ahora = Calendar.getInstance();
        if(config.isManual())
            for(ManualEvent eventoManual : manuales) {
                Calendar inicio = Calendar.getInstance(); inicio.setTimeInMillis(eventoManual.getInicio());
                Calendar fin = Calendar.getInstance();fin.setTimeInMillis(eventoManual.getFin());

                if(inicio.before(ahora) && fin.after(ahora)){
                    AudioController audioController = new AudioController(context);
                    audioController.cambiaSonido(eventoManual.getSettingControl());
                }
            }

        ahora = Calendar.getInstance();
        if(config.isPeriodic())
            for(PeriodicEvent eventoPeriodico : periodicos) {
                Calendar inicio = Calendar.getInstance();inicio.setTimeInMillis(eventoPeriodico.getInicio());
                Calendar fin = Calendar.getInstance();fin.setTimeInMillis(eventoPeriodico.getFin());
                ahora = Calendar.getInstance();
                int in = inicio.get(Calendar.HOUR)*60 + inicio.get(Calendar.MINUTE);
                int fn = fin.get(Calendar.HOUR)*60 + fin.get(Calendar.MINUTE);
                int ah = ahora.get(Calendar.HOUR)*60 + ahora.get(Calendar.MINUTE);
                int diaSemana = inicio.get(Calendar.DAY_OF_WEEK);
                if(in < ah && fn > ah && ahora.get(Calendar.DAY_OF_WEEK) == diaSemana){
                    AudioController audioController = new AudioController(context);
                    audioController.cambiaSonido(eventoPeriodico.getSettingControl());
                }
            }
        if(config.isCalendar())
            if(ActivityCompat.checkSelfPermission( context, Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED ) {
                CalendarProvider provider = new CalendarProvider(context);
                for (int y = 0; y <= 50; y++) {
                    Data<Event> events = provider.getEvents(y);
                    for (Event event : events.getList()) {
                        Calendar inicio = Calendar.getInstance();
                        Calendar fin = Calendar.getInstance();
                        inicio.setTimeInMillis(event.dTStart);
                        fin.setTimeInMillis(event.dTend);
                        if (inicio.before(ahora) && fin.after(ahora)) {
                            for (CalendarEvent calendarEvent : calendarEvents) {
                                if (calendarEvent.getIdCalendarEvent().equals(event.title)) {
                                    AudioController audioController = new AudioController(context);
                                    audioController.cambiaSonido(calendarEvent.getSettingControl());
                                }
                            }

                        }
                    }
                }
            }

        RealmResults<WifiEvent> wifiEvents = realm.where(WifiEvent.class).findAll();

        ProveedorWifi proveedorWifi = new ProveedorWifi(context);
        String ssidLeido = proveedorWifi.getSSID();

        if(config.isWifi())
            for (WifiEvent wifiEvent : wifiEvents) {
                if(wifiEvent.getSsid().equals(ssidLeido)) {

                    AudioController audioController = new AudioController(context);
                    audioController.cambiaSonido(wifiEvent.getSettingControl());

                }
            }
    }

    /**
     * Método que se encarga de crear un hilo de ejecución Timer, y de arrancarlo.
     */
    public void activaHilo(){
        Timer timerObj = new Timer();
        TimerTask observador = new Observador(this);
        timerObj.schedule(observador, 5000, 15000);
    }

    /**
     * Método que se encarga de sacar un texto por pantalla de manera informativa.
     * @param context Contexto de la aplicación.
     */
    public static void alertaGuardado(Context context) {
        Toast.makeText(context, R.string.confirmacion_guardado, Toast.LENGTH_SHORT).show();
    }

    public static void alertaGps(Context context) {
        Toast.makeText(context, R.string.alerta_gps, Toast.LENGTH_LONG).show();
    }

    public static void alertaCamposSinRellenar(Context context) {
        Toast.makeText(context, R.string.alerta_campos, Toast.LENGTH_LONG).show();
    }

    public static void alertaCamposSinRellenarConfig(Context context) {
        Toast.makeText(context, R.string.alerta_campos_perfil, Toast.LENGTH_LONG).show();
    }

    /**
     * Método que se encarga de verificar la concesión de permisos en nuestra aplicación.
     */
    private void verifyPermission() {
        Log.i("VerificacionPermisos", "Comprobación de permisos");
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            int permsRequestCode = 100;
            String[] perms = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CALENDAR};
            int readCalendarPermission = checkSelfPermission(Manifest.permission.READ_CALENDAR);
            int fineLocationPermission = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);

            if (!(fineLocationPermission == PackageManager.PERMISSION_GRANTED && readCalendarPermission == PackageManager.PERMISSION_GRANTED))
                requestPermissions(perms, permsRequestCode);
        }
    }


    /**
     * Método que se encarga de generar una nueva configuración para la app si esta no tiene ninguna
     */
    private void generaConfiguracion() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.commitTransaction();
        AppConfig config = realm.where(AppConfig.class).findFirst();
        if(config == null) {
            realm.beginTransaction();
            int id1= AppConfigBd.configurationId.get();
            AppConfig configBean = new AppConfig(id1, 100, true, true, true, true, true);
            realm.copyToRealm(configBean);
            realm.commitTransaction();
        }
    }

    public static void alertaGuardadoSetting(Context context) {
        Toast.makeText(context, R.string.confirmacion_guardado_config, Toast.LENGTH_SHORT).show();
    }
}
