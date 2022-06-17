package com.tiket_kereta;

public class KeretaEkonomi extends Kereta {
    String name;
    int maxSeat = 100;
    int cost = 30000;

    KeretaEkonomi(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost += biayaTambahan;
    }
}
