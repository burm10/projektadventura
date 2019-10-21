
package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda, který slouží k zobrazení nápovědy hráči.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 *  
 */

class PrikazNapoveda implements IPrikaz {

    private static final String NAZEV = "napoveda";
    private SeznamPrikazu platnePrikazy;
        
    /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů, které je možné ve hře použít, aby je nápověda mohla zobrazit uživateli. 
    */    
   
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "napoveda". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return napoveda ke hre
     */
    
    @Override
    public String proved(String... parametry) {
        return "\nTvůj úkol je dostat se z vězení.\n"
        + "Z vězení se dostaneš pouze tak, že nalezneš všechny potřebně předměty:\n" 
        + "lopatka, nuz, klic, lano, pilka.\n"
        + "a následně utečeš příkazem utec z místnosti vychodZVezeni.\n"
        + "\n"
        + "Muzes zadat tyto prikazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    
     @Override
      public String getNazev() {
         return NAZEV;
    }

}
