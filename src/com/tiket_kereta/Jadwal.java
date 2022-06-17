package com.tiket_kereta;

import java.util.LinkedHashMap;
import java.util.Set;

public class Jadwal {

    private LinkedHashMap<String, Jadwal> schedules = new LinkedHashMap<>();
    private String train, src, dest, date, time;
    private int cost;

    public void tambahJadwal(String id, String kereta , String asal, String tujuan,String tanggal, String waktu, int tarif) {
        schedules.put(id, new Jadwal());
        schedules.get(id).train = kereta;
        schedules.get(id).src = asal;
        schedules.get(id).dest = tujuan;
        schedules.get(id).date = tanggal;
        schedules.get(id).time = waktu;
        schedules.get(id).cost = tarif;
    }

    public Boolean isEmpty() {
        return schedules.isEmpty();
    }

    public int size() {
        return schedules.size();
    }

    public Boolean isContains(String id) {
        return schedules.containsKey(id);
    }


    Set<String> scheduleKeys = schedules.keySet();
    public void printJadwal() {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* J A D W A L  *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("|     Kereta     |      Asal      |     Tujuan     |    Tanggal    |     Waktu     |     Tarif     |");
        System.out.println("____________________________________________________________________________________________________");
        for (String id : scheduleKeys) {
            System.out.printf("|%-16s|%-16s|%-16s|%-15s|%-15s|%-15s|\n",getKereta(id), getAsal(id), getTujuan(id), getTanggal(id), getWaktu(id), getTarif(id));
        }
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }


    //All about Getter
    public Set getJadwal() {
        return scheduleKeys;
    }

    public String getKereta(String id) {
        return schedules.get(id).train;
    }

    public String getAsal(String id) {
        return schedules.get(id).src;
    }

    public String getTujuan(String id) {
        return schedules.get(id).dest;
    }

    public String getTanggal(String id) {
        return schedules.get(id).date;
    }

    public String getWaktu(String id) {
        return schedules.get(id).time;
    }

    public int getTarif(String id) {
        return schedules.get(id).cost;
    }




    //All about Setter
    public void setKereta(String id, String kereta) {
        train = kereta;
    }

    public void setAsal(String id, String asal) {
        src = asal;
    }

    public void setTujuan(String id, String tujuan) {
        dest = tujuan;
    }

    public void setTanggal(String id, String tanggal) {
        date = tanggal;
    }

    public void setWaktu(String id, String waktu) {
        time = waktu;
    }

    public void setTarif(String id, int tarif) {
        cost = tarif;
    }
}
