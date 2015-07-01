package paczki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
    public Miasto miastoPobytu;
    
    public Samochod(String n, int m){
        this.maxPaczek = m;
        this.paczki = new ArrayList<Paczka>();
        this.trasa = new ArrayList<Miasto>();
        this.trasaOdleglosci = new ArrayList<Double>();
        this.nazwa = n;
        this.czas = 0;
        this.miastoPobytu = BazaDanych.miasta.get(BazaDanych.getBaza());
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
        System.out.println("\tpaczka - " + p.getNazwa() + "(" + p.getMiastoOdbioru() +"-"+ p.getMiastoDocelowe() +")"+ "- została dodana do listy samochodu - " + nazwa);
        return true;
    }

    public void ustawTrase(ArrayList<Miasto> trasa) {
        this.trasa = new ArrayList<Miasto>();
        this.trasaOdleglosci = new ArrayList<Double>();
            this.trasa = trasa;
            for (Miasto miasto: this.trasa){
                for(Droga d: miasto.wychodzaceDrogi){
                    if(d.getCel().equals(miasto.poprzednie)) trasaOdleglosci.add(d.getWaga());
                }
            }
            czas += trasaOdleglosci.get(0);
    }
    
    public void wypiszTrase(){
        for(Double d: trasaOdleglosci){
            System.out.println(d);
        }
    }

    public void usunPrzystanek() {
        this.miastoPobytu = trasa.get(0);
        System.out.println("\t" + czas + " - " + nazwa + " - dojechał do miasta - " + miastoPobytu.getNazwa());
        Iterator<Paczka> pp = paczki.iterator();
        while(pp.hasNext()){
            Paczka p = pp.next();
            if(p.getMiastoOdbioru().equals(miastoPobytu) && p.getStan().equals("OCZEKUJE")){
                p.setStanWDrodze();
                System.out.println("\t" + czas + " - " + nazwa + " - paczka - " + p.getNazwa() + " - została odebrana");
            }
            if(p.getMiastoDocelowe().equals(miastoPobytu) && p.getStan().equals("WDRODZE")){
                p.setStanDostarczona();
                System.out.println("\t" + czas + " - " + nazwa + " - paczka - " + p.getNazwa() + " - została dostarczona");
                p.setStanDostarczona();
                pp.remove();
                iloscPaczek--;
            }
        }
        trasa.remove(0);
        trasaOdleglosci.remove(0);
        if(!trasa.isEmpty()){
            czas += trasaOdleglosci.get(0);
        } else if(!paczki.isEmpty()){
            int maxPrio = (int)Double.NEGATIVE_INFINITY;
            Paczka nowaPaczka = null;
            for(Paczka p: paczki){
                if(p.getPriorytet() > maxPrio){
                    maxPrio = p.getPriorytet();
                    nowaPaczka = p;
                }
            }
            SzukanieTrasy.wyznaczTrasy(miastoPobytu);
            ustawTrase(SzukanieTrasy.getNajkrotszaTrase(nowaPaczka.getMiastoDocelowe()));
            trasa.remove(0);
        }else if(!miastoPobytu.equals(BazaDanych.miasta.get(BazaDanych.getBaza()))){
            SzukanieTrasy.wyznaczTrasy(miastoPobytu);
            ustawTrase(SzukanieTrasy.getNajkrotszaTrase(BazaDanych.miasta.get(BazaDanych.getBaza())));
            trasa.remove(0);
        } else {
            RozWozonko.przydzielPaczki(this);
        }
    }
    
    public boolean equals(Samochod s){
        return this.nazwa.equals(s.nazwa) && this.maxPaczek == s.maxPaczek;
    }
    
    public boolean czyPelny(){
        if(this.maxPaczek <= this.iloscPaczek) return true;
        return false;
    }
}
