/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antah
 */
public class Main {

    public static void main(String[] args) {
        Miasto v0 = new Miasto(0, "Redvile");
        Miasto v1 = new Miasto(1, "Blueville");
        Miasto v2 = new Miasto(2, "Greenville");
        Miasto v3 = new Miasto(3, "Orangeville");
        Miasto v4 = new Miasto(4, "Purpleville");

        v0.wychodzaceDrogi.add(new Droga(v1, 5));
            v0.wychodzaceDrogi.add(new Droga(v2, 10));
            v0.wychodzaceDrogi.add(new Droga(v3, 8));
        v1.wychodzaceDrogi.add(new Droga(v0, 5));
            v1.wychodzaceDrogi.add(new Droga(v2, 3));
            v1.wychodzaceDrogi.add(new Droga(v4, 7));
        v2.wychodzaceDrogi.add(new Droga(v0, 10));
            v2.wychodzaceDrogi.add(new Droga(v1, 3));
        v3.wychodzaceDrogi.add(new Droga(v0, 8));
            v3.wychodzaceDrogi.add(new Droga(v4, 2));
        v4.wychodzaceDrogi.add(new Droga(v1, 7));
            v4.wychodzaceDrogi.add(new Droga(v3, 2));
        Miasto[] vertices = {v0, v1, v2, v3, v4};
        SzukanieTrasy.wyznaczTrasy(v0);
        for (Miasto v : vertices) {
            System.out.println("Distance to " + v + ": " + v.minDystans);
            List< Miasto> path = SzukanieTrasy.getNajkrotszaTrase(v);
            System.out.println("Path: " + path);
        }

        int i = 0, j = 0;
        String arg;
        String plikZMapa = "";
        String plikZeZleceniami = "";
        int liczbaSamochodow = 5;
        int maxPaczekNaSamochod = 5;

        while (i < args.length && args[i].startsWith("-")) {
            arg = args[i];
            i++;

            switch (arg) {
                case "-mapa":
                    if (i < args.length) {
                        plikZMapa = args[i];
                        i++;
                        j++;
                    } else {
                        System.err.println("-mapa requires a filename");
                    }
                    break;
                case "-paczki":
                    if (i < args.length) {
                        plikZeZleceniami = args[i];
                        i++;
                        j++;
                    } else {
                        System.err.println("-paczki requires a filename");
                    }
                    break;
                case "-s":
                    if (i < args.length) {
                        liczbaSamochodow = Integer.parseInt(args[i]);
                        i++;
                    } else {
                        System.err.println("-s requires an int");
                    }
                    break;
                case "-p":
                    if (i < args.length) {
                        maxPaczekNaSamochod = Integer.parseInt(args[i]);
                        i++;
                    } else {
                        System.err.println("-mapa requires an int");
                    }
                    break;
            }
        }
        if (j == 2) {
            System.out.println("Success!");
        } else {
            System.err.println("Usage: -mapa filename -paczki filename [-s] int [-p] int");
        }
        try {
            Wczytywacz.wczytajMape("dane\\mapa.txt");
            Wczytywacz.wczytajPaczki("dane\\paczki.txt");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        //BazaDanych.wypiszPaczki();
        //BazaDanych.wypiszMiasta();
        //BazaDanych.wypiszDrogi();
        
        BazaDanych.dodajSamochod("Samochod0", 0);
        BazaDanych.dodajSamochod("Samochod1", 1);
        RozWozonko.przydzielPaczki(BazaDanych.samochody.get(0));
        RozWozonko.przydzielPaczki(BazaDanych.samochody.get(1));
        RozWozonko.nastepnyKrok();
    }
}
