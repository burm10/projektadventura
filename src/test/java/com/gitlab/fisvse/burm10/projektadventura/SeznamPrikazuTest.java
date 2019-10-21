package com.gitlab.fisvse.burm10.projektadventura;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testovací třída SeznamPrikazuTest slouží ke komplexnímu otestování třídy SeznamPrikazu.
 * 
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */
public class SeznamPrikazuTest{
    
    private Hra hraTest;
    private PrikazKonec prikazKonec1;
    private PrikazJdi prikazJdi1;
    private PrikazUtec prikazUtec1;
    
    /**
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */

    @Before
    public void setUp() {
        hraTest = new Hra();
        prikazKonec1 = new PrikazKonec(hraTest);
        prikazJdi1 = new PrikazJdi(hraTest);
        prikazUtec1 = new PrikazUtec(hraTest.getHerniPlan(),hraTest);
    }

    /**
     * Testuje vložení příkazů.
     */
    
    @Test
    public void testVlozeniPrikazu() {
        SeznamPrikazu seznamPrikazu = new SeznamPrikazu();
        seznamPrikazu.vlozPrikaz(prikazKonec1);
        seznamPrikazu.vlozPrikaz(prikazJdi1);
        seznamPrikazu.vlozPrikaz(prikazUtec1);
        
        assertEquals(prikazKonec1, seznamPrikazu.vratPrikaz("konec"));
        assertEquals(prikazJdi1, seznamPrikazu.vratPrikaz("jdi"));
        assertEquals(prikazUtec1, seznamPrikazu.vratPrikaz("utec"));
        assertEquals(null, seznamPrikazu.vratPrikaz("napoveda"));
    }
    
    /**
     * Testuje platnost příkazů.
     */
    
    @Test
    public void testJePlatnyPrikaz() {
        SeznamPrikazu seznamPrikazu = new SeznamPrikazu();
        seznamPrikazu.vlozPrikaz(prikazKonec1);
        seznamPrikazu.vlozPrikaz(prikazJdi1);
        seznamPrikazu.vlozPrikaz(prikazUtec1);
        
        assertEquals(true, seznamPrikazu.jePlatnyPrikaz("konec"));
        assertEquals(true, seznamPrikazu.jePlatnyPrikaz("utec"));
        assertEquals(true, seznamPrikazu.jePlatnyPrikaz("jdi"));
        assertEquals(false, seznamPrikazu.jePlatnyPrikaz("napoveda"));
        assertEquals(false, seznamPrikazu.jePlatnyPrikaz("seber"));
        assertEquals(false, seznamPrikazu.jePlatnyPrikaz("nechod"));
    }
    
    /**
     * Testuje názvy příkazů.
     */
    
    @Test
    public void testNazvyPrikazu() {
        SeznamPrikazu seznamPrikazu = new SeznamPrikazu();
        seznamPrikazu.vlozPrikaz(prikazKonec1);
        seznamPrikazu.vlozPrikaz(prikazJdi1);
        seznamPrikazu.vlozPrikaz(prikazUtec1);
        
        String nazvy = seznamPrikazu.vratNazvyPrikazu();
        assertEquals(true, nazvy.contains("konec"));
        assertEquals(true, nazvy.contains("jdi"));
        assertEquals(true, nazvy.contains("utec"));
        assertEquals(false, nazvy.contains("napoveda"));
        assertEquals(false, nazvy.contains("seber"));
        assertEquals(false, nazvy.contains("nechod"));
    }
    
}
