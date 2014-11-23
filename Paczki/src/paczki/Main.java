/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paczki;

import java.util.List;

/**
 *
 * @author Antah
 */
public class Main {

    public static void main(String[] args)
    {
        Miasto v0 = new  Miasto("Redvile");
	 Miasto v1 = new  Miasto("Blueville");
	 Miasto v2 = new  Miasto("Greenville");
	 Miasto v3 = new  Miasto("Orangeville");
	 Miasto v4 = new  Miasto("Purpleville");

	v0.wychodzaceDrogi = new Droga[]{ new Droga(v1, 5),
	                             new Droga(v2, 10),
                               new Droga(v3, 8) };
	v1.wychodzaceDrogi = new Droga[]{ new Droga(v0, 5),
	                             new Droga(v2, 3),
	                             new Droga(v4, 7) };
	v2.wychodzaceDrogi = new Droga[]{ new Droga(v0, 10),
                               new Droga(v1, 3) };
	v3.wychodzaceDrogi = new Droga[]{ new Droga(v0, 8),
	                             new Droga(v4, 2) };
	v4.wychodzaceDrogi = new Droga[]{ new Droga(v1, 7),
                               new Droga(v3, 2) };
	 Miasto[] vertices = { v0, v1, v2, v3, v4 };
        SzukanieTrasy.wyznaczTrasy(v0);
        for ( Miasto v : vertices)
	{
	    System.out.println("Distance to " + v + ": " + v.minDystans);
	    List< Miasto> path = SzukanieTrasy.getNajkrotszaTrase(v);
	    System.out.println("Path: " + path);
	}
    }
    
}
