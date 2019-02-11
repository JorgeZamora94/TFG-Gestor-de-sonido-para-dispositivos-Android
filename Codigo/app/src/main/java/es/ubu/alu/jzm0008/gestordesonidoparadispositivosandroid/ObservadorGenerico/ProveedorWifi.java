package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.observadorgenerico;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class ProveedorWifi  {

    private WifiManager wifiManager;
    public ProveedorWifi(Context context){
        wifiManager= (WifiManager) context.getSystemService(context.WIFI_SERVICE);
    }
    public String getSSID(){

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String ssid = wifiInfo.getSSID();

        wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo.getSupplicantState() == SupplicantState.COMPLETED) {
            ssid = wifiInfo.getSSID();
        }

        return  ssid;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

}
