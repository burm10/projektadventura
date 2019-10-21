package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída implementující toto rozhraní ve hře implementuje jednotlivé metody.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public interface ISeznamVeci {
    
    /**
     * Metoda vraci true pokud je věc v batohu.
     */
   
    public boolean obsahujeVec(String nazev);
    
    /**
     * Metoda odebere věc v batohu.
     */
    
    public Vec odeberVec(String nazev);

}
