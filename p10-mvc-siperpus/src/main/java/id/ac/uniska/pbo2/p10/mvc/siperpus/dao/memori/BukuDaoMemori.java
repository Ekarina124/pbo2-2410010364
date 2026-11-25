/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p10.mvc.siperpus.dao.memori;

import id.ac.uniska.pbo2.p10.mvc.siperpus.dao.BukuDao;
import id.ac.uniska.pbo2.p10.mvc.siperpus.model.Buku;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Implementasi BukuDao yang menyimpan data di memori. Data hilang saat aplikasi ditutup. */
public class BukuDaoMemori implements BukuDao {
    private final List<Buku> daftar = new ArrayList<>();
    private int idTerakhir = 0;
    
    /** DAO berisi beberapa buku contoh. */
    public static BukuDaoMemori denganContoh() {
        BukuDaoMemori dao = new BukuDaoMemori();
        dao.tambah(new Buku(0, "PBO-001", "Core Java Fundamentals", "Cay S. Horstmann", 2024, 2));
        dao.tambah(new Buku(0, "PBO-002", "Java How to Program", "Paul Deitel", 2017, 1));
        dao.tambah(new Buku(0, "RPL-001", "UML Distilled", "Martin Fowler", 2003, 2));
        dao.tambah(new Buku(0, "HCI-001", "Don't Make Me Think", "Steve Krug", 2014, 1));
        dao.tambah(new Buku(0, "GIT-001", "Pro Git", "Scott Chacon", 2014, 3));
        return dao;
    }
    
    @Override
    public List<Buku> semua() {
        return daftar.stream().sorted(Comparator.comparing(Buku::kode)).toList();
    }
    
    @Override
    public List<Buku> cari(String kataKunci) {
        String kata = kataKunci.toLowerCase();
        return daftar.stream()
                .filter(b -> b.kode().toLowerCase().contains(kata)
                        || b.judul().toLowerCase().contains(kata)
                        || b.penulis().toLowerCase().contains(kata))
                .sorted(Comparator.comparing(Buku::kode))
                .toList();
    }
    
    @Override
    public Buku cariId(int id) {
        for (Buku b : daftar) {
            if (b.id() == id) {
                return b;
            }
        }
        return null;
    }
    
    @Override
    public Buku cariKode(String kode) {
        for (Buku b : daftar) {
            if (b.kode().equalsIgnoreCase(kode)) {
                return b;
            }
        }
        return null;
    }
    
    @Override
    public Buku tambah(Buku buku) {
        idTerakhir++;
        Buku baru = buku.denganId(idTerakhir);
        daftar.add(baru);
        return baru;
    }
    
    @Override
    public void ubah(Buku buku) {
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).id() == buku.id()) {
                daftar.set(i, buku);
                return;
            }
        }
    }
    
    @Override
    public void hapus(int id) {
        daftar.removeIf(b -> b.id() == id);
    }
}