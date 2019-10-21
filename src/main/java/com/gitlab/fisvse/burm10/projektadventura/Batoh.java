package com.gitlab.fisvse.burm10.projektadventura;

import java.util.Map;
import java.util.HashMap;
/**
 *  Třída Batoh je součástí jednoduché textové hry.
 *  
 *  "Batoh" reprezentuje úložný prostor hráče. Do obsahu batohu lze nahlédnout příkazem batoh.
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class Batoh implements ISeznamVeci {

    private final int KAPACITA = 5;
    private Map<String, Vec> veci;

    /**
     * Konstruktor třídy.
     */

    public Batoh(){
        veci = new HashMap<>(); //vytvořená nová mapa, do které se vkládají předměty
    }

    /**
     * Metoda která vypíše obsah batohu.
     */

    public String toString(){     
        if(veci.size() == 0) { //pokud je počet prvků uložených v mapě nula.
            return "V batohu ještě nic nemáš.";
        }
        String result = "";
        for(String s : veci.keySet()) { //procházení mapy, vrací klíče uložené v mapě.
            result += s + " ";
        }
        return result;
    }

    /**
     * Metoda rozhodne, zda v batohu daná věc je.
     */

    public boolean obsahujeVec(String nazev) {
        return veci.containsKey(nazev);  //vrací true, pokud je klíč obsažen v mapě.
    }

    /**
     * Metoda vloží věc do batohu.
     */

    public Vec vlozVec(Vec vec) {
        veci.put(vec.getNazev(),vec); //vkládá klíč a hodnotu do mapy.
        if(veci.containsKey(vec.getNazev()))
            return vec;
        return null;
    }

    /**
     * Metoda odebere věc z batohu.
     */

    public Vec odeberVec(String nazev) {
        return veci.remove(nazev); 
    }

    /**
     * Metoda odebere věc z batohu.
     */

    public Vec odeberVec(Vec vec) {
        return null;
    }

    /**
     * Metoda vrátí "null", byla-li věc odebrána z batohu.
     */

    public Vec odebranaVec(Vec vec) {
        return null;
    }

}
