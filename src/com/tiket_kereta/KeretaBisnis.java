package com.tiket_kereta;

public class KeretaBisnis extends Kereta {
    //Contructor
    KeretaBisnis(String namaKereta, int biayaTambahan) {
        name = namaKereta;
        cost = 50000 + biayaTambahan;
        maxSeat = 60;
    }
}