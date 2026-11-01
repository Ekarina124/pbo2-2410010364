/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

/**
 *
 * @author Vivobook
 */
public enum StatusBuku {
    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    private final String label;

    StatusBuku(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
