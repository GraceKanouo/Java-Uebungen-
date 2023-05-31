import java.util.*;
/**
 * Die Klasse repraesentiert eine Person mit Vor- und Nachnamen.
 * Sie enthaelt Methoden zum Setzen und Auslesen der Attribute 
 * sowie zur Ueberpruefung der Eingaben.
 * 
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23) 
 */
public class Person
{
    //_________________________KONSTANTEN__________________________

    public static final String NAME_REGEX = 
        "^[a-zA-ZÄäÖöÜü][a-zA-ZÄäÖöÜü\\s\\-]*[a-zA-ZÄäÖöÜü]$";

    //________________________Exceptions____________________________________
    
    private static final String NAME_LEER = 
        "\nDas Eingabefeld darf nicht leer sein.\n";

    private static final String UNGUELITIGER_NAME = 
        "\nVor- und Nachname duerfen nur aus Buchstaben bestehen.\n" +
        "Bitte ueberpruefen Sie Ihre Eingabe:\n";

        
    //________________________Attribute____________________________________
    
    
    private String vorname;
    private String nachname;

    
    //________________________Konstruktoren________________________________
    
    /**
     * Erzeugt eine neue Person.
     * 
     * @param vorname  Der Vorname der Person
     * @param nachname Der Nachname der Person
     * 
     * @throws IllegalArgumentException, 
     *         wenn Vor- oder Nachname leer sind 
     *         oder ungueltige Zeichen enthalten  
     *         
     */
    public Person(String vorname,String nachname) 
    {
        if( ((vorname == null)  || (vorname.trim().length()  <= 0) ||
            (nachname == null)  || (nachname.trim().length() <= 0)) )
        {
            throw new IllegalArgumentException
            (NAME_LEER);
        }

        if (!istGueltigerName(vorname, nachname)) 
        {
            throw new IllegalArgumentException
            (UNGUELITIGER_NAME + vorname + " " + nachname);
        }

        this.vorname = vorname;
        this.nachname = nachname;
    }

    
    //_________________________UEBERPRUEFUNG_DER_ATTRIBUTE__________________________
    
    /**
     * Ueberprueft, ob der Vor- und Nachname gueltige Zeichen enthaelt.
     * 
     * @param vorname  Der Vorname der Person
     * @param nachname Der Nachname der Person
     * 
     * @return true, wenn Vor- und Nachname gueltige Zeichen enthalten, 
     *         ansonsten false
     *         
     */
    public boolean istGueltigerName(String vorname,String nachname)
    {
        if(!vorname.matches(NAME_REGEX) || !nachname.matches(NAME_REGEX))
        {
            return false;
        }
        return true;
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
        if (!istGueltigerName(vorname, this.nachname)) 
        {
            throw new IllegalArgumentException(UNGUELITIGER_NAME + vorname);
        }
        this.vorname = vorname;
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
        if (!istGueltigerName(this.vorname, nachname)) 
        {
            throw new NamenException(UNGUELITIGER_NAME + nachname);
        }
        this.nachname = nachname;
    }

    
    //________________________toString-Methode______________________________
    
    /**
     * toString Ermoeglicht es eine String-Repraesentation des Objekts
     *          Person zu liefern.
     */
    @Override
    public String toString() 
    {
        return (nachname + ", " + vorname);
    }

    
    //_________________________EQUALS_______________________________________

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }    
        if (!(obj instanceof Person))
        {
            return false;
        }

        Person other = (Person) obj;
        return Objects.equals(vorname,  other.vorname) && 
        Objects.equals(nachname, other.nachname);
    }
}
