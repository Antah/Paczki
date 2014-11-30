/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Antah
 */
public class Samochod {
    private ArrayList<Paczka> paczki;
    private String nazwa;
    private int maxPaczek;
    private int iloscPaczek;
    public ArrayList<Miasto> trasa;
    public ArrayList<Double> trasaOdleglosci;
    public double czas;
    
    public Samochod(String n, int m){
        this.maxPaczek = m;
        this.paczki = new ArrayList<Paczka>();
        this.trasa = new ArrayList<Miasto>();
        this.trasaOdleglosci = new ArrayList<Double>();
        this.nazwa = n;
        this.czas = 0;
    }
    public String getNazwa(){
        return this.nazwa;
    }
    public boolean dodajPaczke(Paczka p){
        if(iloscPaczek >= maxPaczek){
            return false;
        }
        paczki.add(p);
        iloscPaczek++;
        System.out.println("\tpaczka - " + p.getNazwa() + " - została dodana do listy samochodu - " + nazwa);
        return true;
    }
    public void usunPaczke(Paczka p){
        for(Paczka pp: paczki){
            if(pp.equals(p)) paczki.remove(p);
        }
    }

    public void ustawTrase(ArrayList<Miasto> trasa) {
        this.trasa = new ArrayList<Miasto>(trasa);
        this.trasaOdleglosci = new ArrayList<Double>();
        for (Miasto miasto: this.trasa){
            for(Droga d: miasto.wychodzaceDrogi){
                if(d.getCel().equals(miasto.poprzednie)) trasaOdleglosci.add(d.getWaga());
            }
        }
    }

    public void usunPrzystanek() {
        czas += trasaOdleglosci.get(0);
        System.out.println("\t" + czas + " - " + nazwa + " - dojechał do miasta - " + trasa.get(0).getNazwa());
        for(Paczka p: paczki){
            if(p.getMiastoOdbioru().equals(trasa.get(0)) && p.getStan().equals("OCZEKUJE")){
                p.setStanWDrodze();
                System.out.println("\t" + czas + " - " + nazwa + " - paczka - " + p.getNazwa() + " - została odebrana");
            }
            if(p.getMiastoDocelowe().equals(trasa.get(0)) && p.getStan().equals("WDRODZE")){
                p.setStanDostarczona();
                System.out.println("\t" + czas + " - " + nazwa + " - paczka - " + p.getNazwa() + " - została dostarczona");
                paczki.remove(p);
            }
        }
        Miasto mtmp = trasa.get(0);
        trasa.remove(0);
        trasaOdleglosci.remove(0);
        int maxPrio = 0;
        Paczka nowaPaczka = null;
        if(trasa.get(0) == null){
            for(Paczka p: paczki){
                if(p.getPriorytet() > maxPrio){
                    maxPrio = p.getPriorytet();
                    nowaPaczka = p;
                }
            }
            SzukanieTrasy.wyznaczTrasy(mtmp);
            ustawTrase(SzukanieTrasy.getNajkrotszaTrase(nowaPaczka.getMiastoDocelowe()));
        }
    }
    
    public boolean equals(Samochod s){
        return this.nazwa.equals(s.nazwa) && this.maxPaczek == s.maxPaczek;
    }
}
