/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Antah
 */
public class Wczytywacz {
    public static int wczytajMape(String nazwaPliku) throws FileNotFoundException, IOException{
      File plik;
      Scanner odczyt;

      plik = new File(nazwaPliku);
      odczyt = new Scanner(plik);
          
      
      String s;
      while(odczyt.hasNextLine()){
          s = odczyt.nextLine();
          if(s.contains("# miasta") == true){
              System.out.println("# - miasta");
              break;
          }
      }

      while(odczyt.hasNextLine()){
          s = odczyt.nextLine();
          if(s.equals("") || s.equals(" ")){
              continue;
          }
          if(s.contains("#") == true){
              System.out.println("# - połączenia");
              break;
          }
          String numer = "", nazwa = "";
          Scanner odczyt2 = new Scanner(s);
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            numer = s;
          }
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            nazwa = s;
          }
          System.out.println(numer + " - " + nazwa);
          BazaDanych.utworzMiasto(numer, nazwa);
      }
      
      while(odczyt.hasNextLine()){
          s = odczyt.nextLine();
          if(s.equals("") || s.equals(" ")){
              continue;
          }
          String poczatek = "", koniec = "", waga = "";
          Scanner odczyt2 = new Scanner(s);
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            poczatek = s;
          }
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            koniec = s;
          }
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            waga = s;
          }
          //String poczatek = s.substring(0, s.indexOf(" "));
          //String koniec = s.substring(s.indexOf(" ")+1, s.indexOf(" ", s.indexOf(" ")+1));
          //String waga = s.substring(s.indexOf(" ", s.indexOf(" ")+1)+1);
          System.out.println(poczatek + " " + koniec + " " + waga);
          BazaDanych.utworzDroge(poczatek, koniec, waga);
      }
      return 1;
    }
    public static int wczytajPaczki(String nazwaPliku) throws FileNotFoundException, IOException{
        File plik;
      Scanner odczyt;

      plik = new File(nazwaPliku);
      odczyt = new Scanner(plik);
          
      
      String s = "";
      if(odczyt.hasNextLine()){
          s = odczyt.nextLine();
          System.out.println(s.substring(1));
          BazaDanych.ustawBaze(s.substring(1));
      }
      while(odczyt.hasNextLine()){
          s = odczyt.nextLine();
          if(s.equals("") || s.equals(" ")){
              continue;
          }
          String numer = "",  poczatek = "", koniec = "", nazwa = "", priorytet = "";
          Scanner odczyt2 = new Scanner(s);
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            numer = s;
          }
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            poczatek = s;
          }
          if(odczyt2.hasNext()){
            s = odczyt2.next();
            koniec = s;
          }
          if(odczyt2.hasNext()){
            s = odczyt2.next();
                while(odczyt2.hasNext()){
                    nazwa = nazwa + s + " ";
                    s = odczyt2.next();
                }
            nazwa = nazwa.substring(0, nazwa.length() -1);
            priorytet = s;
          }
          System.out.println(numer + " - " + poczatek + " - " + koniec + " - " + nazwa + " - " + priorytet);
          BazaDanych.dodajPaczke(numer, poczatek, koniec, nazwa, priorytet);
      }
      
        return 1;
    }   
}
