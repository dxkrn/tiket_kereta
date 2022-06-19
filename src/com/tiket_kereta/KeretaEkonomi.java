package com.tiket_kereta;

public class KeretaEkonomi extends Kereta {
    public String name;
    public int maxSeat = 100;
    public int cost = 30000;

    KeretaEkonomi(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost += biayaTambahan;
    }
}
