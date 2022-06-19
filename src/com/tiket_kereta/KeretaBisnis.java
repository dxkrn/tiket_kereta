package com.tiket_kereta;

public class KeretaBisnis extends Kereta {
    public String name;
    public int maxSeat = 60;
    public int cost = 50000;

    KeretaBisnis(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost += biayaTambahan;
    }
}
