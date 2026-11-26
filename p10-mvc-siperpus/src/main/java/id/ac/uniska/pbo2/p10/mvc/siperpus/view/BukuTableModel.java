/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p10.mvc.siperpus.view;

import id.ac.uniska.pbo2.p10.mvc.siperpus.model.Buku;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/** Menampilkan daftar Buku di JTable. Seluruh data diganti setiap kali dimuat ulang. */
public class BukuTableModel extends AbstractTableModel {
    private static final String[] KOLOM = {"Kode", "Judul", "Penulis", "Tahun", "Stok"};
    private List<Buku> data = List.of();
    
    public void setData(List<Buku> dataBaru) {
        data = List.copyOf(dataBaru);
        fireTableDataChanged();
    }
    
    public Buku get(int baris) {
        return data.get(baris);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
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
        return kolom >= 3 ? Integer.class : String.class;
    }
    
    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku b = data.get(baris);
        return switch (kolom) {
            case 0 -> b.kode();
            case 1 -> b.judul();
            case 2 -> b.penulis();
            case 3 -> b.tahun();
            default -> b.stok();
        };
    }
}
