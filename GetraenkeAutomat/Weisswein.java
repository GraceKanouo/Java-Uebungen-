import java.util.*;
/**
 * Die Klasse ermoeglicht die Erzeugung einenes Weisswein-Objekts.
 * Ein Weisswein hat einen alkoholgehalt und ein weingut Attribut.
 * Die Klasse enthaelt außerdem eine ueberschriebene equals-Methode,
 * die Weissweine anhand ihres Alkoholgehalts und Weinguts vergleicht.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public class Weisswein extends Wein
{
    //_______________KONSTRUNKTOREN______________________

    /**
     * Konstruktor ohne Parameter, der den Konstruktor 
     * der Oberklasse aufruft.
     */
    public Weisswein() 
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
    public Weisswein(float alkoholgehalt, String weingut)
    {
        super(alkoholgehalt, weingut);
    }


    //_______________TO_STRING__________________________

    /**
     * Gibt eine String-Repraesentation des Weissweins zurueck.
     * 
     * @return eine String-Repraesentation des Weissweins
     */
    @Override
    public String toString() 
    {
        return super.toString() + ", weiss";
    }

    //_______________EQUALS_____________________________

    //_______________EQUALS_____________________________

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(this == obj)
        {
            return true;
        }
        if (!super.equals(obj)) 
        {
            return false;
        }
        if(!(obj instanceof Weisswein))
        {
            return false;
        }

        Weisswein other = (Weisswein) obj;
        
        return Float.compare(this.getAlkoholgehalt(), 
               other.getAlkoholgehalt()) == 0 && 
               Objects.equals(this.getWeingut(), 
               other.getWeingut());
    }
}
