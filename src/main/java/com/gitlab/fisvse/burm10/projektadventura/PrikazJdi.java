package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi, který slouží k průchodu mezi prostory.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

class PrikazJdi implements IPrikaz {

    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private Hra hra;

    /**
     * Konstruktor třídy.
     */
    
    public PrikazJdi(Hra hra) {
        this.plan = hra.getHerniPlan();
        this.hra = hra;
    }

    /**
     * Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     * existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     * (východ) není, vypíše se chybové hlášení.
     *
     * @param parametry - jako  parametr obsahuje jméno prostoru, do kterého se má jít.
     * @return zpráva, kterou vypíše hra hráči
     */
    
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam chceš jít? Musíš zadat název místnosti.";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru

        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null) {
            return "Tam se odsud jit nedá!";
        } else {
            plan.snizOdpovedi();
            plan.setAktualniProstor(sousedniProstor);
            return sousedniProstor.dlouhyPopis();
        }

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
