/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Antah
 */
public class RozWozonko {

    public static int czas = 0;

    public static void przydzielPaczki(Samochod s) {
        Paczka ptmp = null;
        for (Paczka p : BazaDanych.paczki) {
            //System.out.println("pierwsza paczkafor");
            if (p.getStan().equals("NIEODEBRANA")) {
                //System.out.println("pierwsza paczka");
                //System.out.println(p.getMiastoDocelowe().toString() + p.toString());
                if (s.dodajPaczke(p)) {
                    p.setStanOczekuje();
                }
                //System.out.println(BazaDanych.miasta.get(BazaDanych.getBaza()).toString());
                SzukanieTrasy.wyczyscDaneTymczasowe();
                SzukanieTrasy.wyznaczTrasy(s.miastoPobytu);
                s.ustawTrase(SzukanieTrasy.getNajkrotszaTrase(p.getMiastoDocelowe()));
                SzukanieTrasy.wyczyscDaneTymczasowe();
                if (p.getMiastoOdbioru().equals(s.trasa.get(0))) {
                    p.setStanWDrodze();
                }
                break;
            }
        }
        for (Miasto m : s.trasa) {
            
            for (Paczka pp : BazaDanych.paczki) {
                if(s.czyPelny()) break;
                if (m.equals(pp.getMiastoOdbioru()) && pp.getStan().equals("NIEODEBRANA")) {
                    if(s.dodajPaczke(pp)) pp.setStanOczekuje();
                    if(pp.getMiastoOdbioru().equals(s.trasa.get(0))) pp.setStanWDrodze();
                    //SzukanieTrasy.wyznaczTrasy(s.trasa.get(s.trasa.size()-1));
                    //s.ustawTrase(SzukanieTrasy.getNajkrotszaTrase(ptmp.getMiastoDocelowe()));
                    //SzukanieTrasy.wyczyscDaneTymczasowe();
                }
            }
        }
        
        if (!s.trasa.isEmpty()) {
            s.trasa.remove(0);
        }
    }

    public static void nastepnyKrok() {
        double waga = 1000;
        Samochod sam = null;
        for (Samochod s : BazaDanych.samochody) {
            // System.out.println("jestem w forze");
            //s.wypiszTrase();
            if (s.trasaOdleglosci.isEmpty()) {
                //System.out.println("pusto");
            }
            if (!s.trasaOdleglosci.isEmpty() && s.czas < waga) {
                //System.out.println("jestem w ifie");
                waga = s.czas;
                sam = s;
            }
        }
        if (sam != null) {
            sam.usunPrzystanek();
        }
    }
}
