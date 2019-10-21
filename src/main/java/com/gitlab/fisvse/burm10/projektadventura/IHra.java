package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída implementující toto rozhraní ve hře implementuje jednotlivé metody.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *
 *@author     Martin Bureš
 *@version    2.0
 *@created    květen 2019 pro LS 2018/2019
 */

public interface IHra{
    
    /**
     *  Vrátí úvodní zprávu pro hráče.
     *  
     *  @return  vrací se řetězec, který se má vypsat na obrazovku
     */
    
    public String vratUvitani();

    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     *
     *  @return  vrací se řetězec, který se má vypsat na obrazovku
     */
    
    public String vratEpilog();

    /**
     * Vrací informaci o tom, zda hra již skončila, je jedno zda výhrou, prohrou nebo příkazem konec.
     *
     * @return   vrací true, pokud hra skončila
     */
    
    public boolean konecHry();

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
    
    public String zpracujPrikaz(String radek);

    /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *
     *  @return     odkaz na herní plán
     */
    
    public HerniPlan getHerniPlan();

}

