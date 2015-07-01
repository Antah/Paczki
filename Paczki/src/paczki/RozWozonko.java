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
            if (p.getStan().equals("NIEODEBRANA")) {
                if (s.dodajPaczke(p)) {
                    p.setStanOczekuje();
                }
                SzukanieTrasy.wyznaczTrasy(s.miastoPobytu);
                s.ustawTrase(SzukanieTrasy.getNajkrotszaTrase(p.getMiastoDocelowe()));
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
                }
            }
        }
        
        if (!s.trasa.isEmpty()) {
            s.trasa.remove(0);
        }
    }

    public static boolean nastepnyKrok() {
        double czas = Double.POSITIVE_INFINITY;
        Samochod sam = null;
        for (Samochod s : BazaDanych.samochody) {
            if (!s.trasaOdleglosci.isEmpty() && s.czas < czas) {
                czas = s.czas;
                sam = s;
            }
        }
        if (sam != null) {
            sam.usunPrzystanek();
            return true;
        }
        return false;
    }
}
