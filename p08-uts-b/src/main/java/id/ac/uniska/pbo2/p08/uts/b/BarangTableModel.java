/*Nama  : Siti Ekarina Septianor
 * NPM   : 2410010364
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vivobook
 */
public class BarangTableModel extends AbstractTableModel {
    private static final String[] KOLOM = {
        "Nama Barang",
        "Kategori",
        "Harga",
        "Jumlah",
        "Subtotal"
    };

    // Aturan diskon (sesuaikan dengan lembar soal): 10% jika total minimal Rp100.000
    private static final double BATAS_DISKON = 100_000;
    private static final double PERSEN_DISKON = 0.10;

    private final List<Barang> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {

        Barang b = daftar.get(baris);

        return switch (kolom) {
            case 0 -> b.getNama();
            case 1 -> b.getKategori();
            case 2 -> Rupiah.format(b.getHarga());
            case 3 -> b.getJumlah();
            case 4 -> Rupiah.format(b.hitungSubtotal());
            default -> null;
        };
    }

    // Mengambil objek barang berdasarkan baris
    public Barang get(int baris) {
        return daftar.get(baris);
    }

    // Menambahkan barang
    public void tambah(Barang barang) {
        daftar.add(barang);

        int baris = daftar.size() - 1;

        fireTableRowsInserted(baris, baris);
    }

    // Menghapus barang
    public void hapus(int baris) {
        daftar.remove(baris);

        fireTableRowsDeleted(baris, baris);
    }

    // Mengosongkan seluruh data
    public void bersihkan() {
        int jumlahBaris = daftar.size();

        if (jumlahBaris > 0) {
            daftar.clear();
            fireTableRowsDeleted(0, jumlahBaris - 1);
        }
    }

    // Cek data ganda; baris "kecuali" dilewati (dipakai saat mengubah data sendiri)
    public boolean ada(String nama, int kecuali) {
        for (int i = 0; i < daftar.size(); i++) {
            if (i != kecuali && daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public void ubah(int baris, Barang barang) {
        daftar.set(baris, barang);
        fireTableRowsUpdated(baris, baris);
    }

    public double total() {
        double jumlah = 0;
        for (Barang b : daftar) {
            jumlah += b.hitungSubtotal();
        }
        return jumlah;
    }

    public double diskon() {
        return total() >= BATAS_DISKON ? total() * PERSEN_DISKON : 0;
    }

    public double bayar() {
        return total() - diskon();
    }
}
