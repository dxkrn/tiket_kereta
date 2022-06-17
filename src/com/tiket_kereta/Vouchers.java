package com.tiket_kereta;

import java.util.ArrayList;

public class Vouchers {

    //inner class voucher
    static class Voucher {
        private String code;
        private int discount;

        Voucher(String kode, int potongan) {
            code = kode;
            discount = potongan;
        }
    }

    //arrayList untuk menyimpan data voucher
    private ArrayList<Voucher> voucher = new ArrayList<>();

    //inputVoucher
    public void inputVoucher(String kode, int potongan) {
        voucher.add(new Voucher(kode, potongan));
    }

    //get Size
    public int getSize() {
        return voucher.size();
    }

    //method untuk mengembalikan daftar kode voucher
    public ArrayList<String> getCode() {
        ArrayList<String> voucherCodes = new ArrayList<>();
        for (Voucher i : voucher) {
            voucherCodes.add(i.code);
        }
        return voucherCodes;
    }

    //method untuk mengembalikan daftar potongan
    public ArrayList<Integer> getDiscount() {
        ArrayList<Integer> discounts = new ArrayList<>();
        for (Voucher i : voucher) {
            discounts.add(i.discount);
        }
        return discounts;
    }


}
