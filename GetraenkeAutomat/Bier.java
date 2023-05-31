import java.util.Objects;

/**
 * Die Klasse Bier repraesentiert ein alkoholisches 
 * Getraenk vom Typ Bier. 
 * Ein Bier-Objekt enthaelt Informationen ueber den 
 * Alkoholgehalt und die Brauerei.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public class Bier extends AlkoholischesGetraenk
{
    //_______________FEHLERMELDUNGEN_____________________

    private static final String BRAUEREI_LEER =
        "Es wurde keine Brauerei angegeben.";

    //_______________ATTRIBUTE___________________________
    private String brauerei;

    //_______________KONSTRUNKTOREN______________________

    /**
     * Ein Konstruktor ohne Parameter.
     */
    public Bier() 
    {
        super();
    }

    /**
     * Ein Konstruktor mit Parametern.
     *
     * @param alkoholgehalt Der Alkoholgehalt des Biers
     * @param brauerei      Die Brauerei des Biers
     */
    public Bier(float alkoholgehalt, String brauerei)
    {
        super(alkoholgehalt);
        setBrauerei(brauerei);
    }

    //_______________GETTER_____________________________
    public String getBrauerei() 
    {
        return brauerei;
    }

    //_______________SETTER_____________________________
    /**
     * Setzt die Brauerei des Biers.
     *
     * @param brauerei Die Brauerei des Biers
     * 
     * @throws IllegalArgumentException, 
     *         wenn die uebergebene Brauerei null oder leer ist
     */
    public void setBrauerei(String brauerei)
    {
        if(brauerei == null || brauerei.isBlank())
        {
            throw new GetraenkException(BRAUEREI_LEER);  
        }

        this.brauerei = brauerei;
    }

    //_______________TO_STRING__________________________
    @Override
    public String toString() 
    {
        return super.toString() + " gebraut von " + brauerei;
    }

    //_______________EQUALS_____________________________
    @Override
    public boolean equals(Object obj) 
    {
        // prüft, ob übergebenes Objekt null oder 
        // keine Instanz von Bier ist
        if (obj == null || getClass() != obj.getClass()) 
        {
            return false; // , wenn Objekte ungleich
        }
        if (this == obj) 
        {
            return true; // , wenn dasselbe Objekt
        }
        // Aufruf der equals-Methode der Superklasse 
        // AlkoholischesGetraenk
        if (!super.equals(obj)) 
        {
            return false;
        }
        // wenn uebergebenes Objekt Instanz von Bier ist,   
        // Cast durchfuehren und Ergebnis in Variable 
        // 'other' speichern
        Bier other = (Bier) obj;
        // 'brauerei'-Attribute beider Objekte mit 
        // 'Objects.equals()'-Methode vergleichen
        return Objects.equals(brauerei, other.brauerei);
    }
}