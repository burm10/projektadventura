package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Martin Bureš
 *@version    2.0
 *@created    květen 2019 pro LS 2018/2019
 */

public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;
    private int pokus;  //číslo pokusu při odpovědi na otázky
    private int odpoved; //číslo odpovedi (přidává 1 při správné)

    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();
        pokus = 0;
        odpoved = 0;
    }
    
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví rozcestí.
     */

    private void zalozProstoryHry() {

        // vytvářejí se jednotlivé prostory a jejich popisy
     
        Prostor cela = new Prostor("cela","\n"+"Není tu žádný předmět. Máš dvě možnosti, kam se vydat, ale nezapomeň,\n"
                +"že navštívit musíš všechny místnosti, abys nalezl všechny předměty.\n");

        Prostor koupelna = new Prostor("koupelna", "\n" + "V koupelně jsi potkal člena drsného gangu.\n"
                + "Pokud mu správně odpovíš na jednu otázku, můžeš si vzít předmět lopatka, který potřebuješ k útěku.\n"
                + "Jeho otázka zní: Kolik kilobytů má jeden megabyte?.\n"
                + "Maš 3 pokusy na správnou odpoveď. Odpovídej příkazem odpovez a číslem.\n");

        Prostor dilna = new Prostor("dilna","\n" + "V dílně jsi potkal krutého dělníka.\n"
                + "Pokud mu správně odpovíš na jednu otázku, můžeš si vzít předmět pilka, který potřebuješ k útěku.\n"
                + "Jeho otázka zní: Kolik zařízení můžeš připojit do podsítě s prefixem /25 ?\n"
                + "Maš 3 pokusy na správnou odpoveď. Odpovídej příkazem odpovez a číslem.\n");

        Prostor jidelna = new Prostor("jidelna","\n" + "V jidelně jsi potkal masakrální kuchařku.\n"
                + "Pokud ji správně odpovíš na jednu otázku, můžeš si vzít předmět nuz, který potřebuješ k útěku.\n"
                + "Její otázka zní: Kolik bitů má jeden byte?\n"
                + "Maš 3 pokusy na správnou odpoveď. Odpovídej příkazem odpovez a číslem.\n");

        Prostor chodba = new Prostor("chodba","\n" + "Na chodbě jsi potkal podplatitelného člena ostrahy.\n"
                + "Pokud mu správně odpovíš na jednu otázku, můžeš si vzít předmět klic, který potřebuješ k útěku.\n"
                + "Jeho otázka zní: Za kolik kreditů je předmět 4IT101 - Programování v Javě?\n"
                + "Maš 3 pokusy na správnou odpoveď. Odpovídej příkazem odpovez a číslem.\n"
                +"\n"
                + "Pokud už budeš mít všechny předměty, je jich 5, můžeš jít do místnosti vychodZVezeni a  příkazem utec utéct.\n"
                + "Pokud ještě nemáš všechny předměty, hledej dál. Příkazem batoh se můžeš podívat, které už máš.\n");
             
        Prostor pradelna = new Prostor ("pradelna", "\n" + "V prádelně jsi potkal pradlenu vražedkyni.\n"
                + "Pokud ji správně odpovíš na jednu otázku, můžeš si vzít předmět lano, které potřebuješ k útěku.\n"
                + "Její otázka zní: Jaký je počet hlavních budov VŠE na Žižkově?\n"
                + "Maš 3 pokusy na správnou odpoveď. Odpovídej příkazem odpovez a číslem.\n");

        Prostor vychodZVezeni = new Prostor("vychodZVezeni", "\n" + "Pokud máš všechny předměty můžeš utéct příkazem utec.\n"
                + "Poud ještě nemáš všechny předměty, nepokoušej se o útěk. Prohraješ!\n");
     
        // přiřazují se průchody mezi prostory (sousedící prostory)
        cela.setVychod(koupelna);
        cela.setVychod(jidelna);
        koupelna.setVychod(chodba);
        dilna.setVychod(chodba);
        jidelna.setVychod(chodba);
        jidelna.setVychod(pradelna);
        chodba.setVychod(koupelna);
        chodba.setVychod(dilna);
        chodba.setVychod(jidelna);
        chodba.setVychod(pradelna);
        chodba.setVychod(vychodZVezeni);
        pradelna.setVychod(chodba);
        pradelna.setVychod(jidelna);
        vychodZVezeni.setVychod(chodba);
        
        //věci, které lze vložit do batohu v jednotlivých místnostech
        koupelna.vlozVec(new Vec("lopatka"));
        dilna.vlozVec(new Vec("pilka"));
        jidelna.vlozVec(new Vec("nuz"));
        chodba.vlozVec(new Vec("klic"));
        pradelna.vlozVec(new Vec("lano"));
     
        aktualniProstor = cela;  // hra začíná v místnosti cela
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *  @return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory.
     * @param  prostor nový aktuální prostor
     */
    
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
    }
    
    /**
     * Metoda nastaví špatnou odpoveď a přidáva 1 k pokusu.
     */
    
    public void spatnaOdpoved(){
        pokus++;
    }
    
    /**
     * Metoda vrací počet zbývajících pokusů při odpovídání na otázku.
     */
    
    public int getPokus(){
        return pokus;
    }

    /**
     * Metoda vynuluje pokusy, aby měl hráč na další otázku zase 3.
     */

    public int vynulujPokusy() {
        return pokus = 0;
    }
       
    /**
     * Metoda vrací obsah batohu.
     */
    
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     * Metoda vrací odpoveď.
     */

    public int getOdpoved() {
        return odpoved;
    }

    /**
     * Metoda nastaví správnou odpoveď. (přičtě 1 při správné odpovědi)
     */

    public void spravnaOdpoved() {
        odpoved ++;
    }

    /**
     * Metoda nastaví správnou odpoveď. (vynuluje např. při průchodu místností.)
     */

    public void snizOdpovedi() {
        odpoved = 0;
    }

}

