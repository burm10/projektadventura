package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída PrikazBatoh implementuje pro hru příkaz batoh, který slouží k "nahlédnutí" do uložiště.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class PrikazBatoh implements IPrikaz {
    
    private static final String NAZEV = "batoh";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     * 
     * @param plan herní plán, ve kterém se bude ve hře zobrazovat obsah batohu.
     */
    
    public PrikazBatoh(HerniPlan plan)
    {
        this.plan = plan;
    }

    /**
     * Metoda slouží pro vypsání obsahu batohu po zadání příkazu batoh.
     */

    @Override
    public String proved(String... parametry) {
        String result = "";
        if (parametry.length > 0) {
            return "Tento příkaz nemůže mít žádný parametr.";
        } else {
            result = plan.getBatoh().toString();     
        }
        return result; 
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    
    public String getNazev() {
        return NAZEV;
    }

}
