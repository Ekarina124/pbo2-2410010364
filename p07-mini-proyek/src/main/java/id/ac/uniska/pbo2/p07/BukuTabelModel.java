/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Vivobook
 */
public class BukuTabelModel extends AbstractTableModel {
    private static final String[] KOLOM = {"Kode", "Judul", "Penulis", "Tahun Terbit", "Status"};

    private final List<Buku> daftar = new ArrayList<>();

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
    public Class<?> getColumnClass(int kolom) {
        // Kolom tahun bertipe Integer agar diurutkan sebagai angka, bukan teks
        return kolom == 3 ? Integer.class : Object.class;
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku b = daftar.get(baris);
        return switch (kolom) {
            case 0 -> b.kode();
            case 1 -> b.judul();
            case 2 -> b.penulis();
            case 3 -> b.tahun();
            default -> b.status();
        };
    }

    public Buku get(int baris) {
        return daftar.get(baris);
    }

    public void tambah(Buku buku) {
        daftar.add(buku);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public void ubah(int baris, Buku buku) {
        daftar.set(baris, buku);
        fireTableRowsUpdated(baris, baris);
    }

    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }

    /** Menghitung jumlah buku berstatus Tersedia (untuk label status). */
    public int jumlahTersedia() {
        int n = 0;
        for (Buku b : daftar) {
            if (b.status() == StatusBuku.TERSEDIA) {
                n++;
            }
        }
        return n;
    }

    /** Memeriksa apakah kode sudah dipakai buku lain (abaikan satu baris saat mengubah). */
    public boolean kodeSudahAda(String kode, int barisDiabaikan) {
        for (int i = 0; i < daftar.size(); i++) {
            if (i != barisDiabaikan && daftar.get(i).kode().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    }
}
