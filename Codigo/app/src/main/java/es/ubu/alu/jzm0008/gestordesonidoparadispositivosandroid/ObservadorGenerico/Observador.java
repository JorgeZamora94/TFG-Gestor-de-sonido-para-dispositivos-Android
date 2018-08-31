package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorGenerico;

import android.content.Context;

import java.util.TimerTask;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.activities.MainActivityDemo;
import io.realm.Realm;

public class Observador extends TimerTask {
    Context context;
    Realm realm;

    public Observador(Context context) {
        this.context = context;
        realm = Realm.getDefaultInstance();
    }

    public void run() {

        MainActivityDemo.controlador(context, Realm.getDefaultInstance());

    }

//    private void controlaCalendarios(){
//
//        Calendar ahora = Calendar.getInstance();
//
//        RealmResults<CalendarEvent> calendarEvents = realm.where(CalendarEvent.class).findAll();
//        CalendarProvider provider = new CalendarProvider(context);
//        List<me.everything.providers.android.calendar.Calendar> calendars = provider.getCalendars().getList();
//        for(int y = 0; y <= 50;y++) {
//            Data<Event> events = provider.getEvents(y);
//            for (Event event : events.getList()) {
//                Calendar inicio = Calendar.getInstance();
//                Calendar fin = Calendar.getInstance();
//                inicio.setTimeInMillis(event.dTStart);
//                fin.setTimeInMillis(event.dTend);
//                if(inicio.before(ahora) && fin.after(ahora)){
//                    for(CalendarEvent calendarEvent : calendarEvents){
//                        if (calendarEvent.getIdCalendarEvent().equals(event.title)){
//                            Handler handler = new Handler(Looper.getMainLooper());
//
//                            handler.post(new Runnable() {
//
//                                @Override
//                                public void run() {
//                                    MainActivityDemo.alertaEventoCalendario(context);
//                                }
//                            });
//                        }
//                    }
//
//                }
//            }
//        }
//    }
//
//    private void controlaManuales() {
//        RealmResults<ManualEvent> manuales = realm.where(ManualEvent.class).findAll();
//        Calendar ahora = Calendar.getInstance();
//        for(ManualEvent eventoManual : manuales) {
//            Calendar inicio = Calendar.getInstance(); inicio.setTimeInMillis(eventoManual.getInicio());
//            Calendar fin = Calendar.getInstance();fin.setTimeInMillis(eventoManual.getFin());
//
//            if(inicio.before(ahora) && fin.after(ahora)){
//                Handler handler = new Handler(Looper.getMainLooper());
//
//                handler.post(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        MainActivityDemo.alertaEventoManual(context);
//                    }
//                });
//            }
//        }
//    }
//
//    private void controlaPeriodicos() {
//        RealmResults<PeriodicEvent> periodicos = realm.where(PeriodicEvent.class).findAll();
//        Calendar ahora = Calendar.getInstance();
//        for(PeriodicEvent eventoPeriodico : periodicos) {
//            Calendar inicio = Calendar.getInstance();inicio.setTimeInMillis(eventoPeriodico.getInicio());
//            Calendar fin = Calendar.getInstance();fin.setTimeInMillis(eventoPeriodico.getFin());
//            ahora = Calendar.getInstance();
//            int in = inicio.get(Calendar.HOUR)*60 + inicio.get(Calendar.MINUTE);
//            int fn = fin.get(Calendar.HOUR)*60 + fin.get(Calendar.MINUTE);
//            int ah = ahora.get(Calendar.HOUR)*60 + ahora.get(Calendar.MINUTE);
//            int diaSemana = inicio.get(Calendar.DAY_OF_WEEK);
//            if(in < ah && fn > ah && ahora.get(Calendar.DAY_OF_WEEK) == diaSemana){
//                Handler handler = new Handler(Looper.getMainLooper());
//
//                handler.post(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        MainActivityDemo.alertaEventoPeriodico(context);
//                    }
//                });
//            }
//        }
//    }

//    private void controlaWifi() {
//        RealmResults<WifiEvent> wifiEvents = realm.where(WifiEvent.class).findAll();
//
//        ProveedorWifi proveedorWifi = new ProveedorWifi(context);
//        String ssidLeido = proveedorWifi.getSSID();
//
//        for (WifiEvent wifiEvent : wifiEvents) {
//            if(wifiEvent.getSsid().equals(ssidLeido)) {
//                Handler handler = new Handler(Looper.getMainLooper());
//
//                handler.post(new Runnable() {
//
//                    @Override
//                    public void run() {
//                        MainActivityDemo.alertaEventoWifi(context);
//                    }
//                });
//            }
//        }
//    }

}
