/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajtokjatek;

import java.util.ArrayList;
import java.util.Collections;


public class Jatek {
    
    private ArrayList<Ajto> ajtok;
    private int valasztottAjto;
    private int megmutatottAjto;
    private int korSzam;
    private int cserevelNyeres;
    private int csereNelkulNyeres;

    public Jatek() {
        this.ajtok = new ArrayList<>();
        this.korSzam = 0;
        this.cserevelNyeres = 0;
        this.csereNelkulNyeres = 0;
        ujJatek();
    }

    public void ujJatek() {
        ajtok.clear();
        ajtok.add(new Ajto(true));  
        ajtok.add(new Ajto(false)); 
        ajtok.add(new Ajto(false));
        Collections.shuffle(ajtok);
        valasztottAjto = -1;
        megmutatottAjto = -1;
    }

    public void valasztAjtot(int ajtoIndex) {
        valasztottAjto = ajtoIndex;
        megmutatMegmutatottAjtot(); 
    }

   private void megmutatMegmutatottAjtot() {
        for (int i = 0; i < ajtok.size(); i++) {
            if (i != valasztottAjto && !ajtok.get(i).vanBenneErtek()) {
                megmutatottAjto = i;
                break;
            }
        }
    }
   
    public boolean ellenorizCserevel() {
        korSzam++;
        int ujValasztottAjto = 3 - valasztottAjto - megmutatottAjto; 
        boolean nyert = ajtok.get(ujValasztottAjto).vanBenneErtek();
        if (nyert) {
            cserevelNyeres++;
        }
        return nyert;
    }

    public boolean ellenorizCsereNelkul() {
        korSzam++;
        boolean nyert = ajtok.get(valasztottAjto).vanBenneErtek();
        if (nyert) {
            csereNelkulNyeres++;
        }
        return nyert;
    }

    public int getKorSzam() {
        return korSzam;
    }

    public int getCserevelNyeres() {
        return cserevelNyeres;
    }

    public int getCsereNelkulNyeres() {
        return csereNelkulNyeres;
    }
}
