/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        daneMiasto.minDystans = 0;
        PriorityQueue<Miasto> miastaQueue = new PriorityQueue<Miasto>();
      	miastaQueue.add(daneMiasto);

	while (!miastaQueue.isEmpty()) {
	    Miasto m = miastaQueue.poll();

            // Visit each edge exiting u
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
    public static List<Miasto> getNajkrotszaTrase(Miasto cel)
    {
        List<Miasto> path = new ArrayList<Miasto>();
        for (Miasto miasto = cel; miasto != null; miasto = miasto.poprzednie)
            path.add(miasto);
        Collections.reverse(path);
        return path;
    }
}
