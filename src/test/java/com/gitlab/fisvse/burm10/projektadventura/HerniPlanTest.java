package com.gitlab.fisvse.burm10.projektadventura;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testovací třída HerniPlanTest slouží ke komplexnímu otestování třídy HerniPlan.
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class HerniPlanTest{
    
    private HerniPlan herniPlan1;
    private Prostor mistnost1;
    private int odpoved;
    private int pokus;
    
    /**
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */

    @Before
    public void setUp(){
         herniPlan1 = new HerniPlan();
         Prostor mistnost1 = new Prostor("dilna","popis");
         odpoved = 0;
         pokus = 0;
     }
    
    /**
     * Testuje jak herni plán zvyšuje odpoved při správně odpovědi.
     */

    @Test
    public void testZvyyseniOdpovedi() {
        herniPlan1.spravnaOdpoved();
        
        assertEquals(1, herniPlan1.getOdpoved());
        
        herniPlan1.snizOdpovedi();
        
        assertEquals(0, herniPlan1.getOdpoved());
     }
    
    /**
     * Testuje jak herni plán počitá počet pokusu při odpovědi.
     */

    @Test
    public void testPoctuPokusu() {
        herniPlan1.spatnaOdpoved();
        herniPlan1.spatnaOdpoved();
        
        assertEquals(2, herniPlan1.getPokus());
        
        herniPlan1.vynulujPokusy();
        
        assertEquals(0, herniPlan1.getPokus());
     }
    
    /**
     * Testuje getter a setter aktualni polohy hráče.
     */

    @Test
    public void testAktualniMistnost() {
        herniPlan1.setAktualniProstor(mistnost1);
   
        assertEquals(mistnost1, herniPlan1.getAktualniProstor());
     
      }

}
