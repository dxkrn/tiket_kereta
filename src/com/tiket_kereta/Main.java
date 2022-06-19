package com.tiket_kereta;

import java.util.*;

//import poi : untuk export data ke excel
import java.io.File;

import org.apache.logging.log4j.core.config.AwaitCompletionReliabilityStrategy;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;

public class Main {

    static User user = new User();
    static Jadwal jadwal = new Jadwal();
    static VoucherQueue voucherQueue = new VoucherQueue();
//    static int totalStasiun = 10;
//    static Stasiun stasiun = new Stasiun(totalStasiun);
//    static List<List<Node>> adjacent = new ArrayList<List<Node>>();

    static Scanner input = new Scanner(System.in);
    static char pilihan;
    static String inpUsername, inpPassword, inpCPassword, activeUsername;

    //daftar stasiun
    static String[] daftarStasiun = {
            "Soekarno-Hatta",
            "Gambir",
            "Cimahi",
            "Bandung",
            "Tegal",
            "Semarang Tawang",
            "Yogyakarta",
            "Solo Balapan",
            "Surabaya Kota",
            "Malang",
    };

    //daftar kereta
    static KeretaEkonomi[] daftarKeretaEkonomi = {
            new KeretaEkonomi("Malabaraja Ekonomi", 0),
            new KeretaEkonomi("Ranggajati Ekonomi", 1000),
            new KeretaEkonomi("Purwosari Ekonomi", 2000)
    };
    static KeretaBisnis[] daftarKeretaBisnis = {
            new KeretaBisnis("Malabaraja Bisnis", 0),
            new KeretaBisnis("Ranggajati Bisnis", 2000),
            new KeretaBisnis("Purwosari Bisnis", 4000)
    };
    static KeretaEksekutif[] daftarKeretaEksekutif = {
            new KeretaEksekutif("Malabaraja Eksekutif", 0),
            new KeretaEksekutif("Ranggajati Eksekutif", 5000),
            new KeretaEksekutif("Purwosari Eksekutif", 8000)
    };





    //NOTE : Method Main
    public static void main(String[] args) {

        //menambahkan data dummy admin
        user.addUser("admin", "admin123");

        //Memanggil method halamanAwal
        halamanAwal();
    }


    //NOTE : Halaman Awal
    public static void halamanAwal() {
        do {
            System.out.println("\nHalo, Selamat Datang!\n");
            System.out.println("-*-*-  Menu -*-*-");
            System.out.println("|  [1] Masuk    |");
            System.out.println("|  [2] Daftar   |");
            System.out.println("|  [3] Keluar   |");
            System.out.println("-*-*-*-*-*-*-*-*-\n");
            System.out.print("Pilihan [1/2/3] : ");
            pilihan = input.next().charAt(0);
            input.nextLine();

            switch (pilihan) {
                case '1' -> {
                    System.out.println("Panggil method halamanMasuk");
                    halamanMasuk();
                }
                case '2' -> {
                    System.out.println("Panggil method halamanDaftar");
                    halamanDaftar();
                }
                case '3' -> {
                    System.out.println("\n*Alert : Terima kasih :)\n");
                    System.exit(0);
                }
                default -> System.out.println("\n*Alert : Pilihan Menu tidak tersedia!\n");
            }
        } while (pilihan != '1' && pilihan != '2' && pilihan != '3');
    }

    //NOTE : halamanDaftar
    public static void halamanDaftar() {
        System.out.println("\n\n\n");
        System.out.println("--* Daftar *--");

        //input username , passwd, dan confirm passwd
        System.out.print("Username : ");
        inpUsername = input.nextLine();
        System.out.print("Password : ");
        inpPassword = input.nextLine();
        System.out.print("Confirm Password : ");
        inpCPassword = input.nextLine();

        //pengecekan
        if (inpPassword.equals(inpCPassword)) {
            if (user.isEmpty()) {
                user.addUser(inpUsername, inpPassword);
                System.out.println("Alert! Registrasi Berhasil!");
            } else {
                if (user.isContains(inpUsername)) {
                    System.out.println("Alert! Username tidak tersedia!");
                } else {
                    user.addUser(inpUsername, inpPassword);
                    System.out.println("Alert! Registrasi Berhasil!");
                }
            }
        } else {
            System.out.println("Alert! Password tidak cocok!");
        }
        halamanAwal();
    }


    //NOTE : halamanMasuk
    public static void halamanMasuk() {
        System.out.println("\n\n\n");
        System.out.println("--* Masuk *--");

        //input username dan passwd
        System.out.print("Username : ");
        inpUsername = input.nextLine();
        System.out.print("Password : ");
        inpPassword = input.nextLine();

        //pengecekan
        if (user.isContains(inpUsername)) {
            if (user.getPassword(inpUsername).equals(inpPassword)) {
                System.out.println("Alert! Login Berhasil!");
                activeUsername = inpUsername;
                if (activeUsername.equals("admin")) {
                    halamanDashboardAdmin(activeUsername);
                } else {
                    halamanUtama(activeUsername);
                }

            } else  {
                System.out.println("Alert! Username atau Password salah!");
                halamanAwal();
            }
        } else {
            System.out.println("Alert! User belum terdaftar!");
            halamanAwal();
        }
    }


    //NOTE : halamanUtama
    public static void halamanUtama(String username) {
        do {
            System.out.println("\n\n===========================");
            System.out.println(" Halo, " + username);
            System.out.println(" Mau kemana hari ini?");
            System.out.println("---------------------------");
            System.out.println("-*-*-*-*-  Menu -*-*-*-*-*-");
            System.out.println("|  [1] Jadwal Bus         |");
            System.out.println("|  [2] Pesan Tiket        |");
            System.out.println("|  [3] Pesanan Anda       |");
            System.out.println("|  [4] Dapatkan Voucher   |");
            System.out.println("|  [5] Keluar             |");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
            System.out.print("Pilihan [1/2/3/4/5] : ");
            pilihan = input.next().charAt(0);
            input.nextLine();

            switch (pilihan) {
                case '1' -> {
                    System.out.println("Panggil method printJadwal");
                    jadwal.printJadwal();
                    halamanUtama(activeUsername);
                }

                case '2' -> {
                    System.out.println("Panggil method pesanTiket");
                }
                case '3' -> {
                    System.out.println("Panggil method pesananAnda");
                }
                case '4' -> {
                    System.out.println("Panggil method cariVoucher");
                    lihatVoucher();
                    halamanUtama(activeUsername);
                }
                case '5' -> {
                    halamanAwal();
                }
                default -> System.out.println("\nAlert! Pilihan Menu tidak tersedia!\n");
            }
        } while (pilihan != '1' && pilihan != '2' && pilihan != '3' && pilihan != '4' && pilihan != '5');
    }

    //NOTE : halamanPesanTiket
    public static void halamanPesanTiket() {

    }


    //NOTE : halamanPesananAnda
    public static void halamanPesananAnda() {

    }


    //NOTE : lihatVoucher
    public static void lihatVoucher() {
        //Dari Kelas Vouchers
//        ArrayList<String> kodeVoucher = new ArrayList<>(voucher.getCode());
//        ArrayList<Double> potonganTarif = new ArrayList<>(voucher.getDiscount());
//
//        System.out.println("-*-*-*- V O U C H E R -*-*-*-");
//        System.out.println("|       Kode       | Diskon |");
//        System.out.println("_____________________________");
//        for (int i = 0; i < kodeVoucher.size(); i++) {
//            System.out.printf("|%-18s|   %-2.0f%%  |", kodeVoucher.get(i), (potonganTarif.get(i)*100),"%");
//            System.out.println();
//        }
//        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

        //Dari kelas VoucherQueue
        ArrayList<String> kodeVoucher = new ArrayList<>(voucherQueue.getCode());
        ArrayList<Double> potonganTarif = new ArrayList<>(voucherQueue.getDiscount());

        System.out.println("-*-*-*- V O U C H E R -*-*-*-");
        System.out.println("|       Kode       | Diskon |");
        System.out.println("_____________________________");
        for (int i = 0; i < kodeVoucher.size(); i++) {
            System.out.printf("|%-18s|   %-2.0f%%  |", kodeVoucher.get(i), (potonganTarif.get(i)*100),"%");
            System.out.println();
        }
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

    }










    //======== ADMIN IN YOUR AREA =========
    //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv

    //NOTE : halamanDashboardAdmin
    public static void halamanDashboardAdmin(String username) {
        do {
            System.out.println("\n\n===========================");
            System.out.println(" Halo, " + username);
            System.out.println("---------------------------");
            System.out.println("-*-*-*-*-*-  Menu -*-*-*-*-*-");
            System.out.println("|  [1] Lihat Jadwal Bus     |");
            System.out.println("|  [2] Input Jadwal Bus     |");
            System.out.println("|  [3] Hapus Jadwal Bus     |");
            System.out.println("|  [4] Daftar Pesanan       |");
            System.out.println("|  [5] Input Voucher        |");
            System.out.println("|  [6] Hapus Voucher        |");
            System.out.println("|  [7] Cetak Jadwal         |");
            System.out.println("|  [8] Cetak Daftar Pesanan |");
            System.out.println("|  [9] Cetak Daftar Voucher |");
            System.out.println("|  [e] Keluar               |");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
            System.out.print("Pilihan [1/2/3/4/5/6/7/8/9/10] : ");
            pilihan = input.next().charAt(0);
            input.nextLine();

            switch (pilihan) {
                case '1' -> {
                    System.out.println("Panggil method lihatJadwal");
                    halamanLihatJadwal();
                }

                case '2' -> {
                    System.out.println("Panggil method inputJadwal");
                    halamanInputJadwal();
                }
                case '3' -> {
                    System.out.println("Panggil method hapusJadwal");
                    //ntaran ya
                }
                case '4' -> {
                    System.out.println("Panggil method daftarPesanan");
//                    halamanDaftarPesanan();
                }
                case '5' -> {
                    System.out.println("Panggil method inputVoucher");
                    halamanInputVoucher();
                }
                case '6' -> {
                    System.out.println("Panggil method hapusVoucher");
                    voucherQueue.removeVoucher();
                    halamanDashboardAdmin(activeUsername);
                }
                case '7' -> {
                    System.out.println("Panggil method cetakJadwal");
                    try {
                        cetakJadwal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case '8' -> {
                    System.out.println("Panggil method cetakDaftarPesanan");
//                    cetakDaftarPesanan();
                }
                case '9' -> {
                    System.out.println("Panggil method cetakDaftarVoucher");
//                    cetakDaftarVoucher();
                }
                case 'e' -> {
                    halamanAwal();
                }
                default -> System.out.println("\nAlert! Pilihan Menu tidak tersedia!\n");
            }
        } while (pilihan != '1' && pilihan != '2' && pilihan != '3' && pilihan != '4' && pilihan != '5' && pilihan != '6');
    }

    //NOTE : halamanLihatJadwal
    public static void halamanLihatJadwal() {
        jadwal.printJadwal();
        halamanDashboardAdmin(activeUsername);
    }

    //NOTE : halamanInputJadwal
    public static void halamanInputJadwal() {
        String namaKereta = "";
        String inpTanggal, inpWaktu;
        String autoID = "";
        int inpKereta, inpAsal, inpTujuan;
        double autoTarif = 0;
        double persentaseTarif = 0;

        System.out.println("\n\n\n");
        System.out.println("---- Daftar Kereta ----");
        System.out.println("| [0] Malabaraja Ekonomi   |");
        System.out.println("| [1] Ranggajati Ekonomi   |");
        System.out.println("| [2] Purwosari Ekonomi    |");
        System.out.println("| [3] Malabaraja Bisnis    |");
        System.out.println("| [4] Ranggajati Bisnis    |");
        System.out.println("| [5] Purwosari Bisnis     |");
        System.out.println("| [6] Malabaraja Eksekutif |");
        System.out.println("| [7] Ranggajati Eksekutif |");
        System.out.println("| [8] Purwosari Eksekutif  |");
        System.out.println("-----------------------\n");

        System.out.println("---- Daftar Stasiun ---");
        System.out.println("| [0] Soekarno-Hatta  |");
        System.out.println("| [1] Gambir          |");
        System.out.println("| [2] Cimahi          |");
        System.out.println("| [3] Bandung         |");
        System.out.println("| [4] Tegal           |");
        System.out.println("| [5] Semarang Tawang |");
        System.out.println("| [6] Yogyakarta      |");
        System.out.println("| [7] Solo Balapan    |");
        System.out.println("| [8] Surabaya Kota   |");
        System.out.println("| [9] Malang          |");
        System.out.println("-----------------------\n");

        System.out.println("--* Input Jadwal *--");
        //input asal, tujuan, tanggal, waktu, tarif
        System.out.print("Nama Kereta : [0 - 8] : ");
        inpKereta = input.nextInt();
        System.out.print("Kota Asal [0 - 9] : ");
        inpAsal = input.nextInt();
        input.nextLine();
        System.out.print("Kota Tujuan [0 - 9] : ");
        inpTujuan = input.nextInt();
        input.nextLine();
        System.out.print("Tanggal [ddmmyy] : ");
        inpTanggal = input.nextLine();
        System.out.print("Waktu [hh.mm] : ");
        inpWaktu = input.nextLine();

        //menghitung persentase tarif berdasarkan jarak antar stasiun

        int totalStasiun = 10;
        Stasiun stasiun = new Stasiun(totalStasiun);
        List<List<Node>> adjacent = new ArrayList<List<Node>>();
        //menambahkan adj jalur
        for (int i = 0; i < totalStasiun; i++) {
            List<Node> itm = new ArrayList<Node>();
            adjacent.add(itm);
        }
        adjacent.get(0).add(new Node(1, 20));
        adjacent.get(1).add(new Node(0, 20));
        adjacent.get(1).add(new Node(2, 50));
        adjacent.get(2).add(new Node(1, 50));
        adjacent.get(2).add(new Node(3, 20));
        adjacent.get(3).add(new Node(2, 20));
        adjacent.get(3).add(new Node(4, 60));
        adjacent.get(3).add(new Node(6, 100));
        adjacent.get(4).add(new Node(3, 60));
        adjacent.get(4).add(new Node(5, 50));
        adjacent.get(5).add(new Node(4, 50));
        adjacent.get(5).add(new Node(7, 40));
        adjacent.get(6).add(new Node(3, 100));
        adjacent.get(6).add(new Node(7, 30));
        adjacent.get(7).add(new Node(5, 40));
        adjacent.get(7).add(new Node(6, 30));
        adjacent.get(7).add(new Node(8, 90));
        adjacent.get(7).add(new Node(9, 80));
        adjacent.get(8).add(new Node(7, 90));
        adjacent.get(8).add(new Node(9, 40));
        adjacent.get(9).add(new Node(7, 80));
        adjacent.get(9).add(new Node(8, 40));

        stasiun.dijkstra(adjacent, inpAsal);
        persentaseTarif = ((double) stasiun.getDistance(inpTujuan) / 100);


        //generate ID
        if (inpKereta == 0 || inpKereta == 1 || inpKereta == 2) {
            namaKereta = daftarKeretaEkonomi[inpKereta].name;
            for (int i = 0; i < 1; i++) {
                autoID = autoID + daftarKeretaEkonomi[inpKereta].name.charAt(i);
            }
            autoID = autoID + "E";
            autoTarif = daftarKeretaEkonomi[inpKereta].cost * persentaseTarif;
        }
        if (inpKereta == 3 || inpKereta == 4 || inpKereta == 5) {
            namaKereta = daftarKeretaBisnis[inpKereta-3].name;
            for (int i = 0; i < 1; i++) {
                autoID = autoID + daftarKeretaBisnis[inpKereta-3].name.charAt(i);
            }
            autoID = autoID  + "B";
            autoTarif = daftarKeretaBisnis[inpKereta-3].cost * persentaseTarif;
        }
        if (inpKereta == 6 || inpKereta == 7 || inpKereta == 8) {
            namaKereta = daftarKeretaEksekutif[inpKereta-6].name;
            for (int i = 0; i < 1; i++) {
                autoID = autoID + daftarKeretaEksekutif[inpKereta-6].name.charAt(i);
            }
            autoID = autoID + "X";
            autoTarif = daftarKeretaEksekutif[inpKereta-6].cost * persentaseTarif;
        }

        for (int i = 0; i < 3; i++) {
            autoID = autoID + daftarStasiun[inpAsal].charAt(i);
        }
        for (int i = 0; i < 3; i++) {
            autoID = autoID + daftarStasiun[inpTujuan].charAt(i);
        }
        for (int i = 0; i < 4; i++) {
            autoID = autoID + inpTanggal.charAt(i);
        }
        for (int i = 0; i < 2; i++) {
            autoID = autoID + inpWaktu.charAt(i);
        }


        //inputJadwal
        if (!(jadwal.isContains(autoID))) {
            jadwal.tambahJadwal(autoID, namaKereta, daftarStasiun[inpAsal], daftarStasiun[inpTujuan], inpTanggal, inpWaktu, autoTarif);

            System.out.println("Alert! Input Jadwal " + autoID + " berhasil!");

            halamanDashboardAdmin(activeUsername);
        } else {
            System.out.println("Alert! Jadwal sudah terdaftar sebelumnya!");
            halamanDashboardAdmin(activeUsername);
        }

    }

    //NOTE : halamanInputVoucher
    public static void halamanInputVoucher() {
        String kodeVC;
        double potongan;

        System.out.println("\n\n\n");
        System.out.println("--* Input Voucher *--");

        //input asal, tujuan, tanggal, waktu, tarif
        System.out.print("Kode Voucher: ");
        kodeVC = input.nextLine();
        System.out.print("Potongan (%) : ");
        potongan = (input.nextDouble() / 100);

        //Dari kelas VoucherQueue
        ArrayList<String> kodeVoucher = new ArrayList<>(voucherQueue.getCode());
        ArrayList<Double> potonganTarif = new ArrayList<>(voucherQueue.getDiscount());
        if (kodeVoucher.isEmpty()) {
            voucherQueue.inputVoucher(kodeVC, potongan);
            System.out.println("Alert! Input Kode Voucher berhasil!");
            halamanDashboardAdmin(activeUsername);
        } else {
            for (String i : kodeVoucher) {
                if (kodeVC.equals(i)) {
                    System.out.println("Alert! Kode Voucher telah diinputkan sebelumnya!");
                    halamanDashboardAdmin(activeUsername);
                } else {
                    voucherQueue.inputVoucher(kodeVC, potongan);
                    System.out.println("Alert! Input Kode Voucher berhasil!");
                    halamanDashboardAdmin(activeUsername);
                }
            }
        }

    }


    //NOTE : halaman daftarPesanan
    public static void daftarPesanan() {

    }


    //NOTE : cetakJadwal
    public static void cetakJadwal() throws Exception {
        //membuat objek Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //membuat objek spreadsheet
        XSSFSheet spreadsheet = workbook.createSheet("Jadwal Kereta");

        //membuat objek baris
        XSSFRow row;


        //mengambil data jadwal dan memasukkan ke sheet
        Set<String> scheduleKeys = jadwal.getJadwal();

        //membuat tabel header
        int rowIndex = 0;
        Cell cell;
        row = spreadsheet.createRow(rowIndex++);
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("Kereta");
        cell = row.createCell(2);
        cell.setCellValue("Asal");
        cell = row.createCell(3);
        cell.setCellValue("Tujuan");
        cell = row.createCell(4);
        cell.setCellValue("Tanggal");
        cell = row.createCell(5);
        cell.setCellValue("Waktu");
        cell = row.createCell(6);
        cell.setCellValue("Tarif");

        //memasukkan data ke sheet
        for (String id : scheduleKeys) {
            row = spreadsheet.createRow(rowIndex++);
            cell = row.createCell(0);
            cell.setCellValue(id);
            cell = row.createCell(1);
            cell.setCellValue(jadwal.getKereta(id));
            cell = row.createCell(2);
            cell.setCellValue(jadwal.getAsal(id));
            cell = row.createCell(3);
            cell.setCellValue(jadwal.getTujuan(id));
            cell = row.createCell(4);
            cell.setCellValue(jadwal.getTanggal(id));
            cell = row.createCell(5);
            cell.setCellValue(jadwal.getWaktu(id));
            cell = row.createCell(6);
            cell.setCellValue(jadwal.getTarif(id));

        }

        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream("D:/JadwalKereta.xlsx");

        workbook.write(out);
        out.close();

        halamanDashboardAdmin(activeUsername);


    }


}
