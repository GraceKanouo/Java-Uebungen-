//import java.util.*;

/**
 * Die Klasse erweitert die Klasse Getraenk und dient 
 * als Basis fuer konkrete Klassen alkoholfreier 
 * Getraenke (Bsp.: Wasser, Softdrink).
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public abstract class AlkoholfreiesGetraenk extends Getraenk 
{
    //_______________FEHLERMELDUNGEN_____________________

    private static final String KEIN_HERSTELLER =
            "Kein Hersteller gefunden";


    //_______________ATTRIBUTE___________________________

    private String hersteller;


    //_______________KONSTRUNKTOREN______________________

    /**
     * Konstruktor fuer ein alkoholfreies Getraenks 
     * ohne Hersteller.
     */
    public AlkoholfreiesGetraenk() {}

    /**
     * Konstruktor fuer ein alkoholfreies Getraenks mit 
     * Angabe eines Herstellers. 
     * 
     * @param hersteller Der Hersteller des Getraenks.
     */
    public AlkoholfreiesGetraenk(String hersteller)
    {
        setHersteller(hersteller);
    }


    //_______________GETTER_____________________________

    public String getHersteller() 
    {
        return hersteller;
    }


    //_______________SETTER_____________________________

    /**
     * Setzt den Hersteller des Getraenks.
     * 
     * @param hersteller Der Hersteller des Getraenks.
     * 
     * @throws IllegalArgumentException, 
     *         wenn der uebergebene Hersteller null oder 
     *         leer ist.
     */
    public void setHersteller(String hersteller)
    {
        if(hersteller == null || hersteller.isBlank())
        {
            throw new GetraenkException(KEIN_HERSTELLER);  
        }

        this.hersteller = hersteller;
    }


    //_______________TO_STRING__________________________

    /**
     * Gibt eine String Repraesentation des alkoholfreien 
     * Getraenks zurueck.
     * 
     * @return Eine String-Darstellung des Getraenks, 
     *         ink. Hersteller und dem Hinweis, 
     *         dass es alkoholfrei ist.
     */
    @Override
    public String toString() 
    {
        return super.toString() + hersteller
                                + ", alkoholfrei";
    }


    //_______________EQUALS_____________________________

   /*  @Override
    public boolean equals(Object obj) 
    {   
        // prueft, ob uebergebenes Objekt null o. keine Instanz 
        // von AlkoholfreiesGetraenk ist
        if (obj == null || getClass() != obj.getClass()) 
        {
            return false; // ---> Objekte ungleich
        }
        if (this == obj) // prueft, ob uebergebenes Objekt dieselbe Instanz ist
        {
            return true; // , falls selbe Instanz ---> Objekte gleich
        }
        if (!(obj instanceof AlkoholfreiesGetraenk)) 
        {
            return false;
        }
        // wenn uebergebenes Objekt Instanz von AlkoholfreiesGetraenk,
        // Cast (= Datentypsaenderung, hier Object zu AlkoholfreiesGetraenk) 
        // durchfuehren und Ergebnis in Variable 'other'speichern
        AlkoholfreiesGetraenk other = (AlkoholfreiesGetraenk) obj;
        
        // vergleichen der 'hersteller'-Attribute beider Objekte mit 
        // 'Objects.equals()'-Methode 
        // wenn die Attribute gleich ---> 'true'
        return Objects.equals(hersteller, other.hersteller);
    } */

}