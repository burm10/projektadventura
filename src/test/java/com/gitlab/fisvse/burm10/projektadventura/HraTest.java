package com.gitlab.fisvse.burm10.projektadventura;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testovací třída HraTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */
public class HraTest {
    
    private Hra hraTest;

    /**
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */

    @Before
    public void setUp()
    {
         hraTest = new Hra();
    }
    
    /**
     * Testuje možnost průběhu hry s výhrou.
     */

    @Test
    public void povedenyUtek() {
        hraTest.zpracujPrikaz("jdi koupelna");
        hraTest.zpracujPrikaz("odpovez 1024");
        hraTest.zpracujPrikaz("seber lopatka");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("odpovez 7");
        hraTest.zpracujPrikaz("seber klic");
        hraTest.zpracujPrikaz("jdi dilna");
        hraTest.zpracujPrikaz("odpovez 128");
        hraTest.zpracujPrikaz("seber pilka");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("jdi jidelna");
        hraTest.zpracujPrikaz("odpovez 8");
        hraTest.zpracujPrikaz("seber nuz");
        hraTest.zpracujPrikaz("jdi pradelna");
        hraTest.zpracujPrikaz("odpovez 4");
        hraTest.zpracujPrikaz("seber lano");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("jdi vychodZVezeni");
        hraTest.zpracujPrikaz("utec");

        assertEquals(true, hraTest.konecHry());
    }
    
    /**
     * Testuje možnost průběhu hry s prohrou, nejsou sebrány všechny předměty.
     */

    @Test
    public void nepovedenyUtek() {
        hraTest.zpracujPrikaz("jdi koupelna");
        hraTest.zpracujPrikaz("odpovez 1024");
        hraTest.zpracujPrikaz("seber lopatka");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("odpovez 7");
        hraTest.zpracujPrikaz("seber klic");
        hraTest.zpracujPrikaz("jdi dilna");
        hraTest.zpracujPrikaz("odpovez 128");
        hraTest.zpracujPrikaz("seber pilka");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("jdi jidelna");
        hraTest.zpracujPrikaz("odpovez 8");
        hraTest.zpracujPrikaz("seber nuz");
        hraTest.zpracujPrikaz("jdi pradelna");
        hraTest.zpracujPrikaz("odpovez 4");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("jdi vychodZVezeni");
        hraTest.zpracujPrikaz("utec");
        
        assertEquals(true, hraTest.konecHry());
       
    }
    
    /**
     * Testuje konec hry z důvodu špatných odovědí.
     */
    
    @Test
    public void spatneOdpovedi() {
        hraTest.zpracujPrikaz("jdi koupelna");
        hraTest.zpracujPrikaz("odpovez 1022");
        hraTest.zpracujPrikaz("odpovez 1021");
        hraTest.zpracujPrikaz("odpovez 999");
        
        assertEquals(true, hraTest.konecHry());

    }
    
    /**
     * Testuje pokus o útěk ze špatné mistnosti.
     */
    
    @Test
    public void utekSpatnaMistnost(){
        hraTest.zpracujPrikaz("jdi koupelna");
        hraTest.zpracujPrikaz("odpovez 1024");
        hraTest.zpracujPrikaz("seber lopatka");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("odpovez 7");
        hraTest.zpracujPrikaz("seber klic");
        hraTest.zpracujPrikaz("jdi dilna");
        hraTest.zpracujPrikaz("odpovez 128");
        hraTest.zpracujPrikaz("seber pilka");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("jdi jidelna");
        hraTest.zpracujPrikaz("odpovez 8");
        hraTest.zpracujPrikaz("seber nuz");
        hraTest.zpracujPrikaz("jdi pradelna");
        hraTest.zpracujPrikaz("odpovez 4");
        hraTest.zpracujPrikaz("seber lano");
        hraTest.zpracujPrikaz("jdi chodba");
        hraTest.zpracujPrikaz("utec");
        
        assertEquals (false, hraTest.konecHry());
        
    }
    
}




