package es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.bd.model;

import es.ubu.alu.jzm0008.gestordesonidoparadispositivosandroid.app.AppConfigBd;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SettingControl extends RealmObject {

    @PrimaryKey
    private int id;
    private String nameConfiguration;
    private int volumenMainSound;
    private int volumenAlarm;
    private int volumenMusic;
    private int volumenCall;
    private int volumenNotification;

    public SettingControl(){

    }
    public SettingControl(String nameConfiguration, int volumenMainSound, int volumenAlarm, int volumenMusic, int volumenCall, int volumenNotification) {
        this.id = AppConfigBd.settingsId.incrementAndGet();
        this.nameConfiguration = nameConfiguration;
        this.volumenMainSound = volumenMainSound;
        this.volumenAlarm = volumenAlarm;
        this.volumenMusic = volumenMusic;
        this.volumenCall = volumenCall;
        this.volumenNotification = volumenNotification;

    }

    public String getNameConfiguration() {
        return this.nameConfiguration;
    }

    public void setNameConfiguration() {
        this.nameConfiguration = nameConfiguration;
    }
    public int getVolumenMainSound() {
        return volumenMainSound;
    }

    public void setVolumenMainSound(int volumenMainSound) {
        this.volumenMainSound = volumenMainSound;
    }

    public int getVolumenAlarm() {
        return volumenAlarm;
    }

    public void setVolumenAlarm(int volumenAlarm) {
        this.volumenAlarm = volumenAlarm;
    }

    public int getVolumenMusic() {
        return volumenMusic;
    }

    public void setVolumenMusic(int volumenMusic) {
        this.volumenMusic = volumenMusic;
    }

    public int getVolumenCall() {
        return volumenCall;
    }

    public void setVolumenCall(int volumenMusic) {
        this.volumenCall = volumenCall;
    }

    public int getVolumenNotification() {
        return volumenNotification;
    }

    public void setVolumenNotification(int volumenMusic) {
        this.volumenNotification = volumenNotification;
    }

    public int getId() {return id;}

    public String toString(){
            return getNameConfiguration() ;
        }

    }
