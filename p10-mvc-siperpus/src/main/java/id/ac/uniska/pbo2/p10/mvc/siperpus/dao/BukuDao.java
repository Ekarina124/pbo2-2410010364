/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p10.mvc.siperpus.dao;

import id.ac.uniska.pbo2.p10.mvc.siperpus.model.Buku;
import java.util.List;

/**
* Kontrak akses data buku. Controller hanya mengenal interface ini, sehingga
* penyimpanan di memori dapat diganti database tanpa mengubah controller dan tampilan.
*/
public interface BukuDao {
    List<Buku> semua();
    
    /** Buku yang kode, judul, atau penulisnya mengandung kata kunci. */
    List<Buku> cari(String kataKunci);
    
    /** Mengembalikan null jika tidak ditemukan. */
    Buku cariId(int id);
    
    /** Mengembalikan null jika tidak ditemukan. */
    Buku cariKode(String kode);
    
    /** Menyimpan buku baru dan mengembalikan buku dengan id yang sudah terisi. */
    Buku tambah(Buku buku);
    
    void ubah(Buku buku);
    
    void hapus(int id);
}
