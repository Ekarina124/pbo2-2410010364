//Nama  : Siti Ekarina Septianor
//NPM   : 2410010364

package id.ac.uniska.pbo2.p08.uts.b;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vivobook
 */
public final class Validator {

    private static final long HARGA_MIN = 100;
    private static final long HARGA_MAKS = 10_000_000;

    private Validator() {
        // kelas utilitas, tidak perlu dibuat object-nya
    }

    public static String wajibDiisi(String nilai, String namaIsian) {
        if (nilai == null || nilai.isBlank()) {
            return namaIsian + " wajib diisi";
        }
        return null;
    }

    public static String namaBarang(
        String nama, BarangTableModel model, int kecuali) {

        String kosong = wajibDiisi(nama, "Nama barang");

        if (kosong != null) {
            return kosong;
        }

        if (model.ada(nama.trim(), kecuali)) {
            return "Barang " + nama.trim() + " sudah ada di daftar";
        }

        return null;
    }

    public static String harga(String teks) {
        String kosong = wajibDiisi(teks, "Harga");
        if (kosong != null) {
            return kosong;
        }
        if (!teks.trim().matches("\\d{1,9}")) {
            return "Harga harus angka 1 sampai 10000000";
        }
        long nilai = Long.parseLong(teks.trim());
        if (nilai < HARGA_MIN || nilai > HARGA_MAKS) {
            return "Harga harus berisi angka tanpa titik, contoh: 15000";
        }
        return null;
    }
}