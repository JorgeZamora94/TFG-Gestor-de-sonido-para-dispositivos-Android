package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.modificadorsonido;


import android.content.Context;
import android.media.AudioManager;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model.SettingControl;

public class AudioController
{
    private SettingControl settingControl = new SettingControl();
    private Context context = null;

    public AudioController(Context context){
        this.context = context;
    }


    public void cambiaSonido(SettingControl settingControl) {
        if (!this.settingControl.equals(settingControl)) {
            AudioManager audioManager;
            audioManager = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);

            int musica = settingControl.getVolumenMusic() * audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC) / 100;
            int alarma = settingControl.getVolumenAlarm() * audioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM) / 100;
            int sistema = settingControl.getVolumenMainSound() * audioManager.getStreamMaxVolume(AudioManager.STREAM_RING) / 100;
            int llamada = settingControl.getVolumenCall() * audioManager.getStreamMaxVolume(AudioManager.STREAM_VOICE_CALL) /100;
            int notificacion = settingControl.getVolumenNotification() * audioManager.getStreamMaxVolume(AudioManager.STREAM_NOTIFICATION) /100;

            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, musica, AudioManager.FLAG_SHOW_UI);
            if(notificacion != 0) {
                audioManager.setStreamVolume(AudioManager.STREAM_RING, sistema, AudioManager.FLAG_SHOW_UI);
            } else
                audioManager.setStreamVolume(AudioManager.STREAM_RING, AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);

            audioManager.setStreamVolume(AudioManager.STREAM_ALARM, alarma, AudioManager.FLAG_SHOW_UI);
            audioManager.setStreamVolume(AudioManager.STREAM_VOICE_CALL, llamada, AudioManager.FLAG_SHOW_UI);
            if(notificacion != 0) {
                audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, notificacion, AudioManager.FLAG_SHOW_UI);
            } else
                audioManager.setStreamVolume(AudioManager.STREAM_NOTIFICATION, AudioManager.ADJUST_MUTE, AudioManager.ADJUST_MUTE);

        }

    }
}
