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
public class Samochod {
    private int[] paczki;
    private String nazwa;
    private int maxPaczek;
    private int iloscPaczek;
    
    public Samochod(int m, String n){
        this.maxPaczek = m;
        this.paczki = new int[m];
        this.nazwa = n;
    }
    public String getNazwa(){
        return this.nazwa;
    }
    public boolean dodajPaczke(int p){
        if(iloscPaczek >= maxPaczek){
            return false;
        }
        paczki[iloscPaczek] = p;
        iloscPaczek++;
        return true;
    }
    public boolean usunPaczke(int p){
        for(int i = 0; i < maxPaczek-1; i++){
            if(paczki[i] == p){
                for(int j = i; j < maxPaczek; j++){
                    paczki[j] = paczki[j+1];
                }
                return true;
            }
        }
        return false;
    }
}
