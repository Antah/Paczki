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
class Miasto implements Comparable<Miasto>{
    private final String nazwa;
    private int numer;    //numer porzadkowy wierzcholka.
    public Droga[] wychodzaceDrogi;    //lista krawędzi wychodzacych z wierzcholka
    public double minDystans = Double.POSITIVE_INFINITY;
    public Miasto poprzednie;
    /**
     * @param i numer porzadkowy tworzonego wierzcholka
     */
    public Miasto(String n){
        nazwa = n;
    }
 
    @Override
    public String toString(){
        return nazwa;
    }
 
    public int getNumer() {
        return numer;
    }
    
    public String getNazwa(){
        return nazwa;
    }
    
    @Override
    public int compareTo(Miasto m){
        return Double.compare(minDystans, m.minDystans);
    }
}
