/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

import java.util.ArrayList;

/**
 *
 * @author Antah
 */
public class RozWozonko {
    public static int czas = 0;
    
    public static void przydzielPaczki(Samochod s){
        Paczka p = null;
        for(Paczka pp: BazaDanych.paczki){
            if(pp.getStan().equals("NIEODEBRANA")){
                p = pp;
                break;
            }
        }
        if(s.dodajPaczke(p)) p.setStanOczekuje();
        SzukanieTrasy.wyznaczTrasy(p.getMiastoOdbioru());
        s.ustawTrase(SzukanieTrasy.getNajkrotszaTrase(p.getMiastoDocelowe()));
        for(Miasto m: s.trasa){
            for(Paczka pp: BazaDanych.paczki){
                if(m.equals(pp.getMiastoOdbioru()) && pp.getStan().equals("NIEODEBRANA")){
                    if(s.dodajPaczke(pp)) pp.setStanOczekuje();
                }
            }
        }
    }
    
    public static void nastepnyKrok(){
        double waga = BazaDanych.samochody.get(0).trasaOdleglosci.get(0);
        Samochod sam = null;
        for(Samochod s: BazaDanych.samochody){
            if(s.trasaOdleglosci.get(0) < waga){
                waga = s.trasaOdleglosci.get(0);
                sam = s;
            }
        }
        sam.usunPrzystanek();
    }
}
