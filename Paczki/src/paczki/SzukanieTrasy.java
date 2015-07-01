package paczki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Antah
 */
public class SzukanieTrasy {
    public static void wyznaczTrasy(Miasto daneMiasto)
    {
        wyczyscDaneTymczasowe();
        daneMiasto.minDystans = 0;
        PriorityQueue<Miasto> miastaQueue = new PriorityQueue<Miasto>();
      	miastaQueue.add(daneMiasto);

	while (!miastaQueue.isEmpty()) {
	    Miasto m = miastaQueue.poll();

            for (Droga d : m.wychodzaceDrogi)
            {
                Miasto n = d.getCel();
                double waga = d.getWaga();
                double dystansPrzezM = m.minDystans + waga;
		if (dystansPrzezM < n.minDystans) {
		    miastaQueue.remove(n);
		    n.minDystans = dystansPrzezM ;
		    n.poprzednie = m;
		    miastaQueue.add(n);
		}
            }
        }
    }
    public static ArrayList<Miasto> getNajkrotszaTrase(Miasto cel)
    {
        ArrayList<Miasto> path = new ArrayList<Miasto>();
        for (Miasto miasto = cel; miasto != null; miasto = miasto.poprzednie)
            path.add(miasto);
        Collections.reverse(path);
        return path;
    }
    public static void wyczyscDaneTymczasowe(){
        for(Miasto m: BazaDanych.miasta){
            m.minDystans = Double.POSITIVE_INFINITY;
            m.poprzednie = null;
        }
    }
}
