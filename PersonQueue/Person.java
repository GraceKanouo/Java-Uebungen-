import java.util.*;

/**
 * Beschreiben Sie hier die Klasse Person.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Person
{
    //________________________Exceptions____________________________________
    
    private static final String KEIN_VORNAME = 
            "Vorname fehlt.";
            
    private static final String KEIN_NACHNAME = 
            "Nachname fehlt.";

            
    
    //________________________Attribute____________________________________

    private String vorname;
    private String nachname;
    
    
    
    //________________________Konstruktoren________________________________
    
    /**
     * Der Konstruktor mit 2 Parametern versetzt das Objekt Person  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * 
     * @param vorname  Der Vorname einer Person.
     * @param nachname Der Nachname einer Person.
     */
    public Person (String vorname, String nachname) 
    {
        setVorname(vorname);
        setNachname(nachname);
    } 
    
    
    //______________________________Getter_________________________________
    
    public String getVorname() 
    {
        return vorname;
    }

    public String getNachname() 
    {
        return nachname;
    }

    
    //______________________________Setter_________________________________
    
    /**
     * setVorname Ermoeglicht es Aenderungen am Vornamen vorzunehmen.
     * 
     * @param vorname  Der Vorname einer Person.
     * 
     * @throws Eine Exception wird geworfen, wenn kein Wert 
     *         eingegeben wurde oder der Wert des
     *         Vornamens gleich null ist.
     */
    public void setVorname(String vorname) 
    {
        if(vorname == null || vorname.strip().isEmpty()) 
        {
            throw new IllegalArgumentException(KEIN_VORNAME);
        }
        this.vorname = vorname.strip();
    }

    /**
     * setNachname Ermoeglicht es Aenderungen am Nachnamen vorzunehmen.
     * 
     * @param nachname Der Nachname einer Person.
     * 
     * @throws Eine Exception wird geworfen, wenn kein Wert 
     *         eingegeben wurde oder der Wert des
     *         Nachnamens gleich null ist.
     */
    public void setNachname(String nachname) 
    {
        if(nachname == null || nachname.strip().isEmpty())
        {
            throw new IllegalArgumentException(KEIN_NACHNAME);
        }
        this.nachname= nachname.strip();
    }
    
    
    //________________________toString-Methode______________________________
   
    /**
     * toString Ermoeglicht es eine String-Repraesentation des Objekts
     *          Person zu liefern.
     */
    
    public String toString() 
    {
        return ("Nachname: "  + nachname +
                "\nVorname: " + vorname);
    }
}

