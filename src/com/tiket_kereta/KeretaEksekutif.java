package com.tiket_kereta;

public class KeretaEksekutif extends Kereta {
    public String name;
    public int maxSeat = 40;
    public int cost = 70000;

    KeretaEksekutif(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost += biayaTambahan;
    }
}