package com.tiket_kereta;

public class KeretaBisnis extends Kereta {
    KeretaBisnis(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost = 50000 + biayaTambahan;
        maxSeat = 60;
    }
}