//Nama  : Siti Ekarina Septianor
//NPM   : 2410010364
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

/**
 *
 * @author Vivobook
 */
public class UjiValidator {
    private static int gagal = 0;

    private static void cek(String nama, String hasil, boolean harusValid) {
        boolean valid = (hasil == null);
        if (valid != harusValid) {
            gagal++;
        }
        String status = (valid == harusValid) ? "SESUAI " : "SALAH ";
        System.out.println(status + nama + ": " + (valid ? "valid" : hasil));
    }

    public static void main(String[] args) {
        BarangTableModel model = new BarangTableModel();
        model.tambah(new Barang("Pulpen", KategoriBarang.ALAT_TULIS, 3500, 4));
        model.tambah(new Barang("Spidol", KategoriBarang.ALAT_TULIS, 12500, 2));

        cek("Nama kosong", Validator.namaBarang("", model, -1), false);
        cek("Nama dobel", Validator.namaBarang("pulpen", model, -1), false);
        cek("Nama benar", Validator.namaBarang("Penghapus", model, -1), true);
        cek("Ubah tanpa ganti nama", Validator.namaBarang("Pulpen", model, 0), true);
        cek("Ubah jadi nama yang sudah ada", Validator.namaBarang("Pulpen", model, 1), false);

        cek("Harga kosong", Validator.harga(""), false);
        cek("Harga berisi huruf", Validator.harga("abc"), false);
        cek("Harga terlalu kecil", Validator.harga("50"), false);
        cek("Harga terlalu besar", Validator.harga("20000000"), false);
        cek("Harga benar", Validator.harga("15000"), true);

        System.out.println();
        System.out.println(gagal == 0
                ? "Semua aturan bekerja sesuai harapan"
                : gagal + " aturan belum sesuai");
    }
}
