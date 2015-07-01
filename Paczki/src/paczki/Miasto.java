package paczki;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Antah
 */
class Miasto implements Comparable<Miasto>{
    private final String nazwa;
    private int numer;
    public ArrayList<Droga> wychodzaceDrogi;    
    public double minDystans = Double.POSITIVE_INFINITY;
    public Miasto poprzednie;

    public Miasto(int p, String n){
        this.wychodzaceDrogi = new ArrayList<Droga>();
        numer = p;
        nazwa = n;
    }
 
    @Override
    public String toString(){
        return numer + " " + nazwa;
    }
 
    public int getNumer() {
        return numer;
    }
    
    public String getNazwa(){
        return nazwa;
    }
    public void dodajDroge(Miasto cel, int waga){
        wychodzaceDrogi.add(new Droga(cel, waga));
    }
    @Override
    public int compareTo(Miasto m){
        return Double.compare(minDystans, m.minDystans);
    }
    
    
}
