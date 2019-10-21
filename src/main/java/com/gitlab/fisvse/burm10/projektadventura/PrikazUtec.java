package com.gitlab.fisvse.burm10.projektadventura;
/**
 * Třída PrikazUtec implementuje pro hru příkaz utec, který slouží k útěku z vězení.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class PrikazUtec implements IPrikaz {

    private static final String NAZEV= "utec";
    private HerniPlan plan;
    private Hra hra;
    private Batoh batoh;

    /**
     * Konstruktor
     * @param plan, herní plán, po kterém se ve hře prochází
     */
    
    public PrikazUtec(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Metoda rozhodne zda má hráč všechny předměty v batohu, pokud ano ukončí hru výhrou.
     */
    
    @Override
    public String proved(String... parametry) {
        Prostor aktualniProstor = plan.getAktualniProstor();
        Batoh batoh = plan.getBatoh();

        //Pokud jsou v batohu všechny předměty a hráč se nachází v místnosti ze které může utéct. Hra končí výhrou. Jinak prohrou.
        
        if (aktualniProstor.getNazev().equals("vychodZVezeni")) {          
            if (batoh.obsahujeVec("lano") && batoh.obsahujeVec("klic")
                && batoh.obsahujeVec("lopatka") && batoh.obsahujeVec("nuz") && batoh.obsahujeVec("pilka")) {
                hra.setKonecHry(true);
                return "Utekl jsi a nyní můžeš očistit své jméno! Gratuluji.";
                    }
            else {
                hra.setKonecHry(true);
                return "Nesmíš se pokusit utéct bez všech předmětů. Tvoje hra končí. Prohrál jsi!";
            }        
        }
       return "Nejste v prostoru vychodZVezeni. Nemůžete utéct.";
    }

    /**
     *  Metoda vrací název příkazu
     *
     *  @ return nazev prikazu
     */

    public String getNazev() {
        return NAZEV;
    }
}



