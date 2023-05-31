//import java.util.*;

/**
 * Die Klasse erweitert die Klasse Getraenk und dient 
 * als Basis fuer konkrete Klassen alkoholischer 
 * Getraenke (Bsp.: Wein, Bier).
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
abstract class AlkoholischesGetraenk extends Getraenk 
{
    //_______________KONSTANTEN__________________________

    private static final float EPSILON = 0.00000000000001f;


    //_______________FEHLERMELDUNGEN_____________________

    private static final String ALKOHOL_GEHALT_UNGUELTIG =
            "Es wurde kein Hersteller angegeben.";

    private static final String WARNHINWEIS =
            "Der Vertrieb alkohlischer Getraenke mit mehr " +
            "als 55% Vol. ist in Deutschland untersagt.";


    //_______________ATTRIBUTE___________________________

    private float alkoholgehalt;


    //_______________KONSTRUNKTOREN______________________

    /**
     * Konstruktor fuer ein alkoholischen Getraenks 
     * ohne Hersteller.
     */
    public AlkoholischesGetraenk() {}

    /**
     * Konstruktor fuer ein alkoholisches Getraenks mit 
     * Angabe des Alkoholgehalts.
     * 
     * @param alkoholgehalt Der Alkoholgehalt des Getraennks
     */
    public AlkoholischesGetraenk(float alkoholgehalt)
    {
        setAlkoholgehalt(alkoholgehalt);
    }


    //_______________GETTER_____________________________

    public float getAlkoholgehalt() 
    {
        return alkoholgehalt;
    }


    //_______________SETTER_____________________________

    /**
     * Setzt den Alkoholgehalt des Getraenks 
     * 
     * 
     *         
     * @throws IllegalArgumentException, 
     *         wenn der uebergebene Alkoholgehalt unter
     *         dem Vergleivhswert EPSILON liegt.
     */
    public void setAlkoholgehalt(float alkoholgehalt)
    {
        if(alkoholgehalt <= EPSILON)
        {
            throw new GetraenkException(ALKOHOL_GEHALT_UNGUELTIG);  
        }

        if(alkoholgehalt <= 55.0f)
        {
            System.out.print(WARNHINWEIS);  
        }

        this.alkoholgehalt = alkoholgehalt;
    }


    //_______________TO_STRING__________________________

    /**
     * Gibt eine String Repraesentation des alkoholischen 
     * Getraenks zurueck.
     * 
     * @return Eine String-Darstellung des Getraenks, 
     *         ink. Hersteller und dem Alkoholgehalt
     *         in Volumenprozent.
     */
    @Override
    public String toString() 
    {
        return super.toString() + alkoholgehalt
                                + " % Vol.";
    }

    //_______________EQUALS_____________________________

   /*  @Override
    public boolean equals(Object obj) 
    {   
        // prueft, ob uebergebenes Objekt null o. keine Instanz 
        // von AlkoholischesGetraenk ist
        if (obj == null || getClass() != obj.getClass()) 
        {
            return false; // ---> Objekte ungleich
        }
        if (this == obj) // prueft, ob uebergebenes Objekt dieselbe Instanz ist
        {
            return true; // , falls selbe Instanz ---> Objekte gleich
        }
        if (!(obj instanceof AlkoholischesGetraenk)) 
        {
            return false;
        }
        // wenn uebergebenes Objekt Instanz von AlkoholischesGetraenk,
        // Cast (= Datentypsaenderung, hier Object zu AlkoholischesGetraenk) 
        // durchfuehren und Ergebnis in Variable 'other'speichern
        AlkoholischesGetraenk other = (AlkoholischesGetraenk) obj;
        
        // vergleichen der 'alkoholgehalt'-Attribute beider Objekte mit 
        // 'Objects.equals()'-Methode 
        // wenn die Attribute gleich ---> 'true'
        return Objects.equals(alkoholgehalt, other.alkoholgehalt);
    } */
}