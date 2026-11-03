/*Nama  : Siti Ekarina Septianor
 * NPM   : 2410010364
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

/**
 *
 * @author Vivobook
 */
public enum KategoriBarang {
    ALAT_TULIS("Alat Tulis"),
    MAKANAN("Makanan"),
    MINUMAN("Minuman"),
    LAINNYA("Lainnya");

    private final String label;

    KategoriBarang(String label) {
        this.label = label;
    }
}
