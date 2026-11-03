/*Nama  : Siti Ekarina Septianor
 * NPM   : 2410010364
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

/**
 *
 * @author Vivobook
 */
public class Barang {
    private String nama;
    private KategoriBarang kategori;
    private double harga;
    private int jumlah;

    // Constructor kosong
    public Barang() {
    }

    // Constructor dengan parameter
    public Barang(String nama, KategoriBarang kategori,
                  double harga, int jumlah) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public KategoriBarang getKategori() {
        return kategori;
    }

    public void setKategori(KategoriBarang kategori) {
        this.kategori = kategori;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    // Menghitung subtotal
    public double hitungSubtotal() {
        return harga * jumlah;
    }
}
