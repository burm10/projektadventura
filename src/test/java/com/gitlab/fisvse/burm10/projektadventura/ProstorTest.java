package com.gitlab.fisvse.burm10.projektadventura;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testovací třída ProstorTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class ProstorTest {

    private Vec vec1;
    private Prostor mistnost1;
    private Prostor mistnost2;

    /**
     * Testuje jestli spolu místnostni sousedí.
     */

    @Test
    public void testProstoru() {
        Prostor mistnost1 = new Prostor ("koupelna","popis");
        Prostor mistnost2 = new Prostor ("chodba", "popis");
        mistnost1.setVychod(mistnost2);
        mistnost2.setVychod(mistnost1);
        assertEquals(mistnost2, mistnost1.vratSousedniProstor("chodba"));
        assertEquals(mistnost1, mistnost2.vratSousedniProstor("koupelna"));
        assertNull(mistnost1.vratSousedniProstor("samotka"));
    }

    /**
     * Testuje, zda lze správně vložit věci a zda se nacházejí ve správném prostoru.
     */

    @Test
    public void testVkladaniVeci() {
        Prostor mistnost1 = new Prostor("chodba", "popis");
        Vec vec1 = new Vec("klic");
        mistnost1.vlozVec(vec1);
        assertTrue(mistnost1.obsahujeVec("klic"));
        assertFalse(mistnost1.obsahujeVec("lano"));
    }
}



