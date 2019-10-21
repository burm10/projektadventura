package com.gitlab.fisvse.burm10.projektadventura;

/**
 * Třída Start slouží ke spouštění aplikace. 
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class Start{

    /**
     * Main metoda hry. Spuští se s ní celá aplikace.
     */

    public static void main(String [] args) {
        TextoveRozhrani tr = new TextoveRozhrani();
        tr.hraj();
    }
}
