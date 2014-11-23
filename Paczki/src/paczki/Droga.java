
package paczki;

/**
 *
 * @author Antah
 */
public class Droga {
    private final Miasto cel;
    private final double waga;

    public Droga(Miasto cel, double waga){
        this.cel = cel;
        this.waga = waga;
    }
 
    public Miasto getCel()
    {
        return cel;
    }

    public double getWaga()
    {
        return waga;
    }
}

