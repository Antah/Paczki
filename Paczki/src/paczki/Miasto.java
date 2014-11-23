/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

import java.util.LinkedList;

/**
 *
 * @author Antah
 */
public class Miasto {
    private String nazwa;
    private int numer;    //numer porzadkowy wierzcholka.
    private LinkedList<Droga> drogi = new LinkedList<Droga>();    //lista krawędzi wychodzacych z wierzcholka
 
    private Miasto(){}
 
    /**
     * @param i numer porzadkowy tworzonego wierzcholka
     */
    public Miasto(String n, int i)
    {
        nazwa = n;
        numer = i;
    }
 
    public String toString()
    {
        if(drogi.size() == 0)
            return "";
 
        String out = new String();
        for(Droga e : drogi)
            out = out + e.toString() + "\n";
        return out;
    }
 
    /**
     * Zwraca numer porzadkowy wierzcholka
     * @return 
     */
    public int getNumer() 
    {
        return numer;
    }
 
    /**
     * Zwraca <b>kopie</b> listy krawedzi wychodzacych z wierzcholka
     * @return 
     */
    public LinkedList<Droga> getListaDrog()
    {
        return new LinkedList<Droga>(drogi);
    }
 
    /**
     * Usuwa krawedzie biegnace do i-tego wierzcholka (jezeli istnieje)
     * @param i numer wierzcholka do ktorego biegnie usuwana krawedz
     */
    public void usunDroge(int i)
    {
        int e = drogi.size()-1;    //liczba krawedzi do sprawdzenia
        while( e>=0 )
        {
            if(drogi.get(e).getKoniec().getNumer() == i)
                drogi.remove(e);
            e--;
        }
    }
 
    /**
     * Usuwa krawedzie biegnace do wierzcholka v
     * @param v wierzcholek do ktorego biegnie kasowana krawedz
     */
    public void usunDroge(Miasto v)
    {
        usunDroge(v.getNumer());        
    }
 
    /**
     * Dodaje nowa krawedz do wierzcholka
     * @param e dodawana krawedz
     */
    public void dodajDroge(Droga e)
    {
        drogi.add(e);
    }
 
    /**
     * Zwraca krawedz biegnaca do wierzcholka o numerze porzadkowym n (jezeli istnieje)
     * @param n numer wierzcholka do ktorego biegnie szukana krawedz
     * @return 
     */
    public Droga getDroga(int n)
    {
        for(Droga e : drogi)
        if(e.getKoniec().getNumer() == n)
            return e;
        return null;
    } 
 
    /**
     * Zwraca n-ta w kolejnosci krawedz wychodzaca z tego wierzcholka (jezeli istnieje)
     * @param n numer szukanej krawedzi
     */
    public Droga getDrogaAt(int n)
    {
        if(n>=0 && n<drogi.size())
            return drogi.get(n);
        else
            return null;
    }
}
