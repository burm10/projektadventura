package com.gitlab.fisvse.burm10.projektadventura;
/**
 * Instance třídy věc představují jednotlivé předměty.
 * 
 * Tato třída je součástí jednoduché textové hry.
 *  
 * 
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class Vec {
    
    private String nazev;
    
    /**
     * Konstuktor třídy
     */
    
    public Vec(String nazev)
    {
        this.nazev = nazev;
    }

    /**
     * Metoda vrací název věci
     */ 
    
    public String getNazev() {
        return nazev;
    }
    
    /**
     * Metoda vratí "null" pokud je věc odebrána.
     */
    
    public String odebranaVec(){
        return null;
    }
}
