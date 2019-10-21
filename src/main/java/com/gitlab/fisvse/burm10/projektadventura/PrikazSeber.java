package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída PrikazSeber implementuje pro hru příkaz seber, který slouží k sebrání předmětu v místnosti.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class PrikazSeber implements IPrikaz {
    
    private static final String NAZEV = "seber";
    private HerniPlan plan;

    /**
     * Konstuktor třídy
     * 
     * @param plan herní plán, ve kterém se bude ve hře "sbírat" 
     */
    
    public PrikazSeber(HerniPlan plan)
    {
        this.plan = plan;
    }
   
    /**
     * Provádí příkaz seber. Zkouší sebrat věci z prostoru a vkládá je do batohu.
     */
    
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Co mám vzít? Musíš zadat předmět v prostoru.";
        } else {
            
                if (plan.getOdpoved() < 1 && plan.getAktualniProstor().getNazev().equals("vychodZVezeni")){
                    
                   return "V prostoru vychodZVezeni není žádný předmět.";
                }
                
                if (plan.getOdpoved() >= 1 ) {
                           
                    if (parametry.length == 1 && plan.getAktualniProstor().obsahujeVec(parametry[0])) {
                        plan.getBatoh().vlozVec(plan.getAktualniProstor().odeberVec(parametry[0]));
                        plan.snizOdpovedi();
                        return "Vložil jsi do batohu " + parametry[0] + ".";
                    }  
                    
                    return "Tento předmět neexistuje a nebo není v tomto prostoru.";
                }
                return "Neodpověděl jsi na otázku!";
        }
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
