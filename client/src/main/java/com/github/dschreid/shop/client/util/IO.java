package com.github.dschreid.shop.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/* Nicht dokumentierte Klasse, um direkt Eingaben von der Tastatur/
 * Konsole zu lesen. Die Methoden fangen Fehler ab und geben bei
 * falschen Eingaben "Standardwerte" zurueck.
 * @author kleuker
 */
public class IO {

    /**
     * Gebe line aus.
     *
     * @param text    the text
     * @param objects the objects
     */
    public void gebeLineAus(String text, Object... objects) {
        System.out.printf(text + "\n", objects);
    }

    /**
     * Gebe aus.
     *
     * @param text    the text
     * @param objects the objects
     */
    public void gebeAus(String text, Object... objects) {
        System.out.printf(text, objects);
    }

    /**
     * Lese string string.
     *
     * @param ueberschrift the ueberschrift
     * @return the string
     */
    public String leseString(String ueberschrift) {
        gebeAus(ueberschrift);
        return leseString();
    }

    /**
     * Lese string string.
     *
     * @return the string
     */
    public String leseString() {
        String ergebnis;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            ergebnis = in.readLine();
        } catch (IOException e) {
            ergebnis = "";
        }
        return ergebnis;
    }

    /**
     * Lese int int.
     *
     * @param ueberschrift the ueberschrift
     * @return the int
     */
    public int leseInt(String ueberschrift) {
        gebeAus(ueberschrift);
        return leseInt();
    }

    /**
     * Lese int int.
     *
     * @return the int
     */
    public int leseInt() {
        int ergebnis;
        try {
            ergebnis = Integer.decode(leseString());
        } catch (NumberFormatException e) {
            ergebnis = 0;
        }

        return ergebnis;
    }

    /**
     * Lese float float.
     *
     * @return the float
     */
    public float leseFloat() {
        float ergebnis;
        try {
            ergebnis = Float.parseFloat(leseString());
        } catch (NumberFormatException e) {
            ergebnis = 0f;
        }

        return ergebnis;
    }

    /**
     * Lese double double.
     *
     * @return the double
     */
    public double leseDouble() {
        double ergebnis;
        try {
            ergebnis = Double.parseDouble(leseString());
        } catch (NumberFormatException e) {
            ergebnis = 0d;
        }

        return ergebnis;
    }

    /**
     * Lese boolean boolean.
     *
     * @return the boolean
     */
    public boolean leseBoolean() {
        boolean ergebnis;
        try {
            ergebnis = Boolean.parseBoolean(leseString());
        } catch (NumberFormatException e) {
            ergebnis = false;
        }

        return ergebnis;
    }

}
