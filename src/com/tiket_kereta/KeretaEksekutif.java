package com.tiket_kereta;

public class KeretaEksekutif extends Kereta {
    String name;
    int maxSeat = 40;
    int cost = 70000;

    KeretaEksekutif(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost += biayaTambahan;
    }
}