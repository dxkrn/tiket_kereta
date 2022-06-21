package com.tiket_kereta;

public class KeretaEksekutif extends Kereta {
    KeretaEksekutif(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost = 70000 + biayaTambahan;
        maxSeat = 40;
    }
}