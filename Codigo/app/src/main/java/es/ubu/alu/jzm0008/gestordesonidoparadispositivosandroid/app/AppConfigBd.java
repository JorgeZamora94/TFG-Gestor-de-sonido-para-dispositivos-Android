package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.CalendarEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.GPSEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.ManualEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.PeriodicEvent;
import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.WifiEvent;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class AppConfigBd extends Application {

    public static AtomicInteger manualId;
    public static AtomicInteger periodicId;
    public static AtomicInteger gpsId;
    public static AtomicInteger wifiId;
    public static AtomicInteger calendarId;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        manualId = getIdByTable(realm, ManualEvent.class);
        periodicId = getIdByTable(realm, PeriodicEvent.class);
        gpsId = getIdByTable(realm, GPSEvent.class);
        wifiId = getIdByTable(realm, WifiEvent.class);
        calendarId = getIdByTable(realm, CalendarEvent.class);
        realm.close();
    }

    private void setUpRealmConfig() {
            Realm.init(getApplicationContext());
            RealmConfiguration configuration = new RealmConfiguration
                            .Builder().deleteRealmIfMigrationNeeded().build();
            Realm.setDefaultConfiguration(configuration);

    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> theClass){

        RealmResults<T> results = realm.where(theClass).findAll();
        return(results.size()>0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
    }
}
