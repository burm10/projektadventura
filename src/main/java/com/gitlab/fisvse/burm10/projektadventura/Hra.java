package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Martin Bureš
 *@version    2.0
 *@created    květen 2019 pro LS 2018/2019
 */

public class Hra implements IHra {
    
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam platných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazUtec(this.getHerniPlan(), this));
        platnePrikazy.vlozPrikaz(new PrikazBatoh(this.getHerniPlan()));
        platnePrikazy.vlozPrikaz(new PrikazOdpovez(this.getHerniPlan(),this));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    
    public String vratUvitani() { 
        return  "\n"+"Vitej!\n" +
        "Jsi ve vězení za vraždu, kterou jsi nespáchal/a!\n" +
        "Jediná možnost, jak obhájit svou nevinu, je útéct z vězení!\n" +
        "Útěk je možný pouze z místnosti vychodZVezeni a pouze, pokud máš v batohu všechny předměty!\n"+
        "K útěku musíš v různých místnostech nálezt a získat následující předměty:\n"+
        "\nlopatka klic lano nuz pilka \n"+
                "\n" +
        "Napiš 'napoveda', pokud si během hry nebudeš vědět rady. \n" +
         "\n" +"======================================================================\n"
        + herniPlan.getAktualniProstor().dlouhyPopis();
    }

    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    
    public String vratEpilog() {
        return "Díky, že sis zahrál/a!";
    }

    /** 
     * Vrací true, pokud hra skončila.
     */
    
    public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *  @param  radek  text, který zadal uživatel jako příkaz do hry.
     *  @return  vrací se řetězec, který se má vypsat na obrazovku
     */
    
    public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
            parametry[i]= slova[i+1];   
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);

        }
        else {
            textKVypsani= "Tento příkaz neexistuje, zkus jiný nebo použij nápovědu!";
        }
        return textKVypsani;
    }

    /**
     *  Nastaví konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.  
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }

    /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  @return     odkaz na herní plán
     */
    
    public HerniPlan getHerniPlan(){
        return herniPlan;
    }

}

