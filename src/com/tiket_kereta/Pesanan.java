package com.tiket_kereta;

import java.util.LinkedHashMap;
import java.util.Set;

public class Pesanan {
    private LinkedHashMap<String, Pesanan> pesanan = new LinkedHashMap<>();
    private String username, name, telp, train, src, dest, date, time;
    private int numSeat;
    private double totalCost;

    public void tambahPesanan(String id, String username, String name, String telp, String train, String src, String dest, String date, String time, int numSeat, double totalCost) {
        pesanan.put(id, new Pesanan());

        pesanan.get(id).username = username;
        pesanan.get(id).name = name;
        pesanan.get(id).telp = telp;
        pesanan.get(id).train = train;
        pesanan.get(id).src = src;
        pesanan.get(id).dest = dest;
        pesanan.get(id).date = date;
        pesanan.get(id).time = time;
        pesanan.get(id).numSeat = numSeat;
        pesanan.get(id).totalCost = totalCost;
    }

    public Boolean isEmpty() {
        return pesanan.isEmpty();
    }

    public int size() {
        return pesanan.size();
    }

    public Boolean isContains(String id) {
        return pesanan.containsKey(id);
    }



    //cetak daftar pesanan untuk Admin
    Set<String> pesananKeys = pesanan.keySet();
    public void printPesanan() {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*- D A F T A R   P E S A N A N  -*-*-*--*-*-*-*-*--*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("|     ID Pesanan     |      Username      |        Nama        |      Telp.     |       Kereta       |      Asal      |     Tujuan     |    Tanggal    |     Waktu     | Jml Kursi | Total Pesanan |");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________");
        for (String id : pesananKeys) {
            System.out.printf("|%-20s|%-20s|%-20s|%-16s|%-20s|%-16s|%-16s|%-15s|%-15s|    %-3d    |Rp%-15.2f|\n", id, getUsername(id), getName(id), getTelp(id), getKereta(id), getAsal(id), getTujuan(id), getTanggal(id), getWaktu(id), getNumSeat(id), getTotalCost(id));
        }
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-");

    }

    //cetak daftar pesanan untuk User biasa
    public void printPesananUser(String username) {
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*- D A F T A R   P E S A N A N  -*-*-*--*-*-*-*-*--*-*-*--*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("|       ID Pesanan       |        Nama        |      Telp.     |       Kereta       |      Asal      |     Tujuan     |    Tanggal    |     Waktu     | Jml Kursi | Total Pesanan |");
        System.out.println("___________________________________________________________________________________________________________________________________________________________________________________");
        for (String id : pesananKeys) {
            if (getUsername(id).equals(username)) {
                System.out.printf("|%-24s|%-20s|%-16s|%-20s|%-16s|%-16s|%-15s|%-15s|    %-3d    |Rp%-15.2f|\n", id, getName(id), getTelp(id), getKereta(id), getAsal(id), getTujuan(id), getTanggal(id), getWaktu(id), getNumSeat(id), getTotalCost(id));
            }

        }
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*-*-*-*-");

    }






    //All about Getter
    public Set getPesanan() {
        return pesananKeys;
    }

    public String getUsername(String id) {
        return pesanan.get(id).username;
    }

    public String getName(String id) {
        return pesanan.get(id).name;
    }

    public String getTelp(String id) {
        return pesanan.get(id).telp;
    }

    public String getKereta(String id) {
        return pesanan.get(id).train;
    }

    public String getAsal(String id) {
        return pesanan.get(id).src;
    }

    public String getTujuan(String id) {
        return pesanan.get(id).dest;
    }

    public String getTanggal(String id) {
        return pesanan.get(id).date;
    }

    public String getWaktu(String id) {
        return pesanan.get(id).time;
    }

    public int getNumSeat(String id) {
        return pesanan.get(id).numSeat;
    }

    public double getTotalCost(String id) {
        return pesanan.get(id).totalCost;
    }


}
