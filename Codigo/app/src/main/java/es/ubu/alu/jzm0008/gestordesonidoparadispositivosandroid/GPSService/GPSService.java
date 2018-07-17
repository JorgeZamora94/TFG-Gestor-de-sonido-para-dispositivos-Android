package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.GPSService;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.GPSListener.GPSListener;

public class GPSService extends IntentService {

    public GPSService() {
        super("GPSService");
    }

    public static void startGetGPS(Context context) {
        Intent intent = new Intent(context, GPSService.class);
        context.startService(intent);

        GPSListener gpsListener = new GPSListener(context);
        System.out.println("Service");
        System.out.println(gpsListener.getLocation());

        if(gpsListener.getLocation()!=null){
            Toast.makeText(context,gpsListener.getLocation().toString(),Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(context,"nada",Toast.LENGTH_SHORT).show();
        }
    }

    public static void startHiloGPS(final Context context) {
        final GPSListener gpsListener = new GPSListener(context);
        new Thread(new Runnable() {

            public void run() {
                while(true) {
                    try {
                        Thread.sleep(1000);
                        Toast.makeText(context,gpsListener.getLocation().toString(),Toast.LENGTH_SHORT).show();
                        System.out.println(gpsListener.getLocation());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

}
