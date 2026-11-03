//Nama  : Siti Ekarina Septianor
//NPM   : 2410010364
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p08.uts.b;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Vivobook
 */
public class Rupiah {
    private static final NumberFormat FORMAT =
            NumberFormat.getIntegerInstance(Locale.forLanguageTag("id-ID"));

    private Rupiah() {
    }

    public static String format(double nilai) {
        return "Rp" + FORMAT.format(nilai);
    }
}
