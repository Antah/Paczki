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
public class Droga {
    private Miasto poczatek;
    private Miasto koniec;
    private double waga;

    private Droga(){}
 
    /**
     * @param b wierzcholek poczatkowy
     * @param e wierzcholek koncowy
     * @param w waga krawedzi
     */
    public Droga(Miasto b, Miasto e, double w)
    {
        poczatek = b;
        koniec = e;
        waga = w;
    }
 
    @Override
    public String toString()
    {
        return Integer.toString( poczatek.getNumer() ) + " ---( "
               + Double.toString( waga ) + " )---> "
               + Integer.toString( koniec.getNumer() );
    }
 
    /**
     * Zwraca wierzcholek poczatkowy krawedzi
     * @return 
     */
    public Miasto getPoczatek()
    {
        return poczatek;
    }
 
    /**
     * Zwraca wierzcholek koncowy krawedzi
     * @return 
     */
    public Miasto getKoniec()
    {
        return koniec;
    }
 
    /**
     * Zwraca wage krawedzi
     * @return 
     */
    public double getWaga()
    {
        return waga;
    }
}

