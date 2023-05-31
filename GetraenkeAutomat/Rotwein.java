import java.util.*;
/**
 * Die Klasse ermoeglicht die Erzeugung einenes Rotwein-Objekts.
 * Ein Rotwein hat einen alkoholgehalt und ein weingut Attribut.
 * Die Klasse enthaelt außerdem eine ueberschriebene equals-Methode,
 * die Rotweine anhand ihres Alkoholgehalts und Weinguts vergleicht.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public class Rotwein extends Wein
{
    //_______________KONSTRUNKTOREN______________________

    /**
     * Konstruktor ohne Parameter, der den Konstruktor 
     * der Oberklasse aufruft.
     */
    public Rotwein() 
    {
        super();
    }

    /**
     * Konstruktor mit Parameter fuer den Alkoholgehalt 
     * und das Weingut.
     * 
     * @param alkoholgehalt Der Alkoholgehalt des Weins
     * @param weingut       Das Weingut des Weins
     */
    public Rotwein(float alkoholgehalt, String weingut)
    {
        super(alkoholgehalt, weingut);
    }


    //_______________TO_STRING__________________________

    /**
     * Gibt eine String-Repraesentation des Rotweins zurueck.
     * 
     * @return Die String-Repraesentation des Rotweins
     */
    @Override
    public String toString() 
    {
        return super.toString() + ", rot";
    }

    //_______________EQUALS_____________________________

    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        if (!super.equals(obj)) 
        {
            return false;
        }
        if(!(obj instanceof Rotwein))
        {
            return false;
        }

        Rotwein other = (Rotwein) obj;

        return Float.compare(this.getAlkoholgehalt(), 
               other.getAlkoholgehalt()) == 0 && 
               Objects.equals(this.getWeingut(), 
               other.getWeingut());
    }
}

