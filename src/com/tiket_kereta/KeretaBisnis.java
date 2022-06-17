package com.tiket_kereta;

public class KeretaBisnis extends Kereta {
    String name;
    int maxSeat = 60;
    int cost = 50000;

    KeretaBisnis(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost += biayaTambahan;
    }
}
