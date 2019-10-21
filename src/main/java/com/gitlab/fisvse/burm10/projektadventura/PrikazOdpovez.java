package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz odpovez, který slouží k odpovídání na otázky.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 * @author     Martin Bureš
 * @version    2.0
 * @created    květen 2019 pro LS 2018/2019
 */

public class PrikazOdpovez implements IPrikaz {
    
    private static final String NAZEV = "odpovez";
    private HerniPlan plan;
    private Hra hra; 

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "odpovídat"
     */
    
    public PrikazOdpovez(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     * Metoda, která slouží k vyhodnocení, zda bylo na otázku odpovězeno ve správném prostoru a správně.
     */
    
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "Musíš zadat svoji odpoveď.";
        }
        
        if (parametry.length == 1) {
            if (plan.getAktualniProstor().getNazev().equals("koupelna")) {
                if ((parametry[0].equals("1024") || parametry[0].equals("1000") && plan.getPokus() < 3)) {
                    plan.spravnaOdpoved();
                    plan.vynulujPokusy();
                    return "Správně, nyní můžeš sebrat lopatka.";
                } else {
                    if (plan.getPokus() >= 2) {
                        hra.setKonecHry(true);
                        return "Už nemáš odpovědi, hra končí. Prohrál jsi!";
                    } else {
                        plan.spatnaOdpoved();
                        return "Špatná odpověď, můžeš hádat ještě " + (3 - plan.getPokus()) + "krat";
                    }
                }
            }
            
            if (plan.getAktualniProstor().getNazev().equals("jidelna")) {
                if ((parametry[0].equals("8") && plan.getPokus() < 3)) {
                    plan.spravnaOdpoved();
                    plan.vynulujPokusy();
                    return "Spravně, nyní můžeš sebrat nuz.";
                } else {
                    if (plan.getPokus() >= 2) {
                        hra.setKonecHry(true);
                        return "Už nemáš odpovědi, hra končí. Prohrál jsi!";
                    } else {
                        plan.spatnaOdpoved();
                        return "Špatná odpověď, můžeš hádat ještě " + (3 - plan.getPokus()) + "krat";
                    }
                }
            }
            
            if (plan.getAktualniProstor().getNazev().equals("chodba")) {
                if ((parametry[0].equals("7") && plan.getPokus() < 3)) {
                    plan.spravnaOdpoved();
                    plan.vynulujPokusy();
                    return "Spravně, nyní můžeš sebrat klic.";
                } else {
                    if (plan.getPokus() >= 2) {
                        hra.setKonecHry(true);
                        return "Už nemáš odpovědi, hra končí. Prohrál jsi!";
                    } else {
                        plan.spatnaOdpoved();
                        return "Špatná odpověď, můžeš hádat ještě " + (3 - plan.getPokus()) + "krat";
                    }
                }
            }
            
            if (plan.getAktualniProstor().getNazev().equals("dilna")) {
                if ((parametry[0].equals("128") && plan.getPokus() < 3)) {
                    plan.spravnaOdpoved();
                    plan.vynulujPokusy();
                    return "Spravně, nyní můžeš sebrat pilka.";
                } else {
                    if (plan.getPokus() >= 2) {
                        hra.setKonecHry(true);
                        return "Už nemáš odpovědi, hra končí. Prohrál jsi!";
                    } else {
                        plan.spatnaOdpoved();
                        return "Špatná odpověď, můžeš hádat ještě " + (3 - plan.getPokus()) + "krat";
                    }
                }
            }
            
            if (plan.getAktualniProstor().getNazev().equals("pradelna")) {
                if ((parametry[0].equals("4") && plan.getPokus() < 3)) {
                    plan.spravnaOdpoved();
                    plan.vynulujPokusy();
                    return "Spravně, nyní můžeš sebrat lano.";
                } else {
                    if (plan.getPokus() >= 2) {
                        hra.setKonecHry(true);
                        return "Už nemáš odpovědi, hra končí. Prohrál jsi!";
                    } else {
                        plan.spatnaOdpoved();
                        return "Špatná odpověď, můžeš hádat ještě " + (3 - plan.getPokus()) + "krat";
                    }
                }
            }
            else {
                    return "Tady se tě nikdo na nic neptá.";
                }

        }
        
        return "Odpověď může mít pouze 1 parametr!";
            
     }

     /**
      *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
      *
      *  @ return nazev prikazu
      */
     
     public String getNazev(){
            return NAZEV;
    }
}


