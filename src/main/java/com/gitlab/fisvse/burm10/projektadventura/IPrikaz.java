package com.gitlab.fisvse.burm10.projektadventura;
/**
 *  Třída implementující toto rozhraní bude ve hře zpracovávat jeden konkrétní příkaz.
 *  Toto rozhraní je součástí jednoduché textové hry.
 *  
 *@author     Martin Bureš
 *@version    2.0
 *@created    květen 2019 pro LS 2018/2019
 *  
 */

interface IPrikaz {
    
    /**
     *  Metoda pro provedení příkazu ve hře.
     *  Počet parametrů je závislý na konkrétním příkazu,
     *  např. příkazy konec a napoveda nemají parametry
     *  a příkazy jdi, seber, polož mají jeden parametr.
     *  
     *  @param parametry počet parametrů závisí na konkrétním příkazu.
     */
    
    public String proved(String... parametry);
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @return nazev prikazu
     */
    
    public String getNazev();
	
}
