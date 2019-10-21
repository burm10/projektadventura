package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída PrikazKonec implementuje pro hru příkaz konec, který slouží k ukončení hry.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 *  
 */

class PrikazKonec implements IPrikaz {
    
    private static final String NAZEV = "konec";
    private Hra hra;

    /**
     *  Konstruktor třídy.
     *  
     *  @param hra odkaz na hru, která má být příkazem konec ukončena
     */    
    public PrikazKonec(Hra hra) {
        this.hra = hra;
    }

    /**
     * V případě, že příkaz má jen jedno slovo "konec" hra končí(volá se metoda setKonecHry(true))
     * jinak pokračuje např. při zadání "konec a".
     * 
     * @return zpráva, kterou vypíše hra hráči
     */

    @Override
    public String proved(String... parametry) {        
        if (parametry.length > 0) {
            return "Ukončit co? Nechapu, proč jsi zadal druhé slovo.";
        }
        else {
            hra.setKonecHry(true);
            return "Hra ukončena příkazem konec.";
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
