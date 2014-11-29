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
public class BazaDanych {
    private static ArrayList<Paczka> paczki;
    private static ArrayList<Miasto> miasta;
    //private static ArrayList<Droga> drogi;
    private static int baza;

    public static void utworzMiasto(String numer, String nazwa) {
        if(miasta == null) miasta = new ArrayList<Miasto>();
        Miasto noweMiasto = new Miasto(Integer.parseInt(numer), nazwa);
        miasta.add(noweMiasto);
    }

    public static void utworzDroge(String poczatek, String koniec, String waga) {
        int p = Integer.parseInt(poczatek), k = Integer.parseInt(koniec);
        Miasto mp = null, mk = null;
        for(Miasto m : miasta){
            if(m.getNumer() == p) mp = m;
            if(m.getNumer() == k) mk = m;
        }
        mp.dodajDroge(mk, Integer.parseInt(waga));
        mk.dodajDroge(mp, Integer.parseInt(waga));
    }

    public static void ustawBaze(String substring) {
        baza = Integer.parseInt(substring);
    }

    public static void dodajPaczke(String numer, String poczatek, String koniec, String nazwa, String priorytet) {
        int p = Integer.parseInt(poczatek), k = Integer.parseInt(koniec);
        Miasto mp = null, mk = null;
        for(Miasto m : miasta){
            if(m.getNumer() == p) mp = m;
            if(m.getNumer() == k) mk = m;
        }
        Paczka nowaPaczka = new Paczka(Integer.parseInt(numer), mp, mk, nazwa, Integer.parseInt(priorytet));
        if(paczki == null) paczki = new ArrayList<Paczka>();
        paczki.add(nowaPaczka);
    }
    
    public static int getBaza(){
        return baza;
    }
    public static void wypiszPaczki(){
        for(Paczka p : paczki){
            System.out.println(p.toString());
        }
    }
    public static void wypiszMiasta(){
        for(Miasto m: miasta){
            System.out.println(m.toString());
        }
    }
    public static void wypiszDrogi(){
        for(Miasto m: miasta){
            System.out.println(m.toString());
            for(Droga d: m.wychodzaceDrogi){
                System.out.println("\t" + d.toString());
            }
        }
    }
}
