/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

/**
 *
 * @author Antah
 */
public class Paczka {
    private int numerID;
    private String nazwa;
    private int priorytet;
    private String stan;
    private Miasto miastoOdbioru;
    private Miasto miastoDocelowe;
    
    public Paczka(int numer, Miasto poczatek, Miasto koniec, String nazwa, int priorytet){
        this.numerID = numer;
        this.nazwa = nazwa;
        this.priorytet = priorytet;
        this.miastoOdbioru = poczatek;
        this.miastoDocelowe = koniec;
        this.stan = "NIEODEBRANA";
    }
    // gety ---------------------------------------------------------
    public int getNumerID() {
        return this.numerID;
    }
    public String getNazwa(){
        return this.nazwa;
    }
    public int getPriorytet(){
        return this.priorytet;
    }
    public Miasto getMiastoOdbioru(){
        return miastoOdbioru;
    }
    public Miasto getMiastoDocelowe(){
        return miastoDocelowe;
    }
    
    // zmiana stanów ------------------------------------------------
    public void setStanOczekuje(){
        this.stan = "OCZEKUJE";
    }
    public void setStanWDrodze(){
        this.stan = "WDRODZE";
    }
    public void setStanDostarczona(){
        this.stan = "DOSTARCZONA";
    }
    public String getStan(){
        return stan;
    }
    
    
    @Override
    public String toString(){
        String s = numerID + " - " + miastoOdbioru.getNazwa() + " " + miastoDocelowe.getNazwa() + " " + nazwa + " " + priorytet;
        return s;
    }
    
    public boolean equals(Paczka p){
        return this.nazwa.equals(p.nazwa) && this.numerID == p.numerID && this.priorytet == p.priorytet;
    }
}
