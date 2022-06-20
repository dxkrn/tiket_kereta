package com.tiket_kereta;

import java.util.LinkedHashMap;
import java.util.Set;

@SuppressWarnings("unused")
public class Jadwal {

    @SuppressWarnings("FieldMayBeFinal")
    private LinkedHashMap<String, Jadwal> schedules = new LinkedHashMap<>();
    private String train, src, dest, date, time;
    private int seat;
    private double cost;

    public void tambahJadwal(String id, String kereta , String asal, String tujuan,String tanggal, String waktu, double tarif, int kursi) {
        schedules.put(id, new Jadwal());
        schedules.get(id).train = kereta;
        schedules.get(id).src = asal;
        schedules.get(id).dest = tujuan;
        schedules.get(id).date = tanggal;
        schedules.get(id).time = waktu;
        schedules.get(id).cost = tarif;
        schedules.get(id).seat = kursi;
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
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-* J A D W A L  *-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("|     ID Jadwal      |       Kereta       |      Asal      |     Tujuan     |    Tanggal    |     Waktu     |     Tarif     | Kursi |");
        System.out.println("_____________________________________________________________________________________________________________________________________");
        for (String id : scheduleKeys) {
            System.out.printf("|%-20s|%-20s|%-16s|%-16s|%-15s|%-15s|Rp%-13.2f|  %-3d  |\n", id, getKereta(id), getAsal(id), getTujuan(id), getTanggal(id), getWaktu(id), getTarif(id), getKursi(id));
        }
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--**-*-*-*-*-*-*-*-*-");

    }

    public void removeJadwal(String id) {
        schedules.remove(id);
    }


    //All about Getter
    @SuppressWarnings("rawtypes")
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

    public double getTarif(String id) {
        return schedules.get(id).cost;
    }

    public int getKursi(String id) {
        return schedules.get(id).seat;
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

    public void setKursi(String id, int sisaKursi) {
        schedules.get(id).seat = sisaKursi;
    }
}
