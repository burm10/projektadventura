package com.gitlab.fisvse.burm10.projektadventura;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy Batoh.
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */
public class BatohTest{
    
    private Batoh batoh1;
    private Vec vec1;
   
    /**
     * Testuje obsah batohu.
     */

    @Test
    public void obsahBatohu() {
        Batoh batoh1 = new Batoh();
        
        Vec vec1 = new Vec("lopatka");
        Vec vec2 = new Vec ("pilka");
        Vec vec3 = new Vec("lano");
        Vec vec4 = new Vec ("nuz");
        Vec vec5 = new Vec("klic");
        
        batoh1.vlozVec(vec1);
        batoh1.vlozVec(vec2);
        batoh1.vlozVec(vec3);
        batoh1.vlozVec(vec4);
        batoh1.vlozVec(vec5);

        assertEquals(true, batoh1.obsahujeVec("lopatka"));
        assertEquals(true, batoh1.obsahujeVec("pilka"));
        assertEquals(true, batoh1.obsahujeVec("lano"));
        assertEquals(true, batoh1.obsahujeVec("nuz"));
        assertEquals(true, batoh1.obsahujeVec("klic"));
    }
    
    /**
     * Testuje obsah batohu.
     */
    @Test
    public void obsahBatohu2(){
        Batoh batoh1 = new Batoh();
        
        Vec vec1 = new Vec("lopatka");
        Vec vec2 = new Vec ("pilka");
        Vec vec3 = new Vec("lano");
        Vec vec4 = new Vec ("nuz");
        Vec vec5 = new Vec("klic");
        
        batoh1.vlozVec(vec1);
        batoh1.vlozVec(vec2);
        batoh1.vlozVec(vec3);
        batoh1.vlozVec(vec4);
        batoh1.vlozVec(vec5);
        
        assertEquals(true, batoh1.obsahujeVec("lopatka"));
        assertEquals(true, batoh1.obsahujeVec("pilka"));
        assertEquals(true, batoh1.obsahujeVec("lano"));
        assertEquals(true, batoh1.obsahujeVec("nuz"));
        assertEquals(true, batoh1.obsahujeVec("klic"));
        
        batoh1.odeberVec("lopatka");
        batoh1.odeberVec("pilka");
        batoh1.odeberVec("lano");
        batoh1.odeberVec("nuz");
        batoh1.odeberVec("klic");
        
        assertEquals(null, batoh1.odebranaVec(vec1));
        assertEquals(null, batoh1.odebranaVec(vec2)); 
        assertEquals(null, batoh1.odebranaVec(vec3));
        assertEquals(null, batoh1.odebranaVec(vec4)); 
        assertEquals(null, batoh1.odebranaVec(vec5));
    }
}
