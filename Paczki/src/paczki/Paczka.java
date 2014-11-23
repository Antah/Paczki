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
    
    public Paczka(int id, String n, int p){
        this.numerID = id;
        this.nazwa = n;
        this.priorytet = p;
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
    
}
