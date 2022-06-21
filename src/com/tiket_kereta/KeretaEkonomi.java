package com.tiket_kereta;

public class KeretaEkonomi extends Kereta {
    KeretaEkonomi(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost = 30000 + biayaTambahan;
        maxSeat = 100;
    }
}
