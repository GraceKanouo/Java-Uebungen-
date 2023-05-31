
/**
 * Beschreiben Sie hier die Klasse PersonQueue.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PersonQueue implements Queue 
{   
    //________________________Exceptions____________________________________
    
    private static final String UNGUELTIGE_ARRAYGROESSE = 
        "Die Warteschlange muss groesser 0 sein.";

    private static final String ARRAY_VOLL = 
        "Die Warteschlange ist voll.";

    private static final String ARRAY_LEER = 
        "Die Warteschlange ist leer.";

    private static final String NULL_ELEMENT_IN_ARRAY = 
        "Das Element an der gesuchten Stelle ist leer.";
        
    private static final String UNGUELTIGER_INDEX = 
            "Der angegebene Index ist ungueltig.";
            
    private static final String KEIN_PERSON_OBJEKT = 
            "Das übergebene Objekt ist keine Person";
        

    //________________________Konstanten___________________________________
    
    private static final int KAPAZITAET = 10;
    

    //________________________Attribute____________________________________
    
    private Person[] personArray;
    private int anzahlPersonen;

    
    //________________________Konstruktoren________________________________
    
    /**
     * Der Konstruktor versetzt das Objekt PersonQueue  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * Die Kapazitaet des personArrays ist bei diesem
     * Konstruktor frei waehlbar.
     * 
     * @param size Die Groesse des Arrays.
     * 
     * @throws Eine Exception wird geworfen, wenn die 
     *         Groesse des personArrays kleiner 0 ist.
     */
    public PersonQueue(int size) 
    {
        personArray = new Person[size];
        if(size <= 0)
        {
            throw new IllegalArgumentException(UNGUELTIGE_ARRAYGROESSE);
        }
        personArray = new Person[size];
    }

    /**
     * Der Konstruktor versetzt das Objekt PersonQueue  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * Die Kapazitaet des personArrays ist bei diesem
     * Konstruktor bereits festgelegt.
     */
    public PersonQueue()
    {
        this(KAPAZITAET);
    }
    
    
    //________________________Methoden_____________________________________
    
    //________________________addLast______________________________________
    
    /**
     * addLast Ermoeglicht es ein Objekt hinten anzufuegen.
     * 
     * @throws Eine Exception wird geworfen, wenn die 
     *         Queue bereits voll ist.
     * @throws Eine Exception wird geworfen, wenn die 
     *         das Objekt, das hinzugefuegt werden soll
     *         kein Person-Objekt ist.
     */
    @Override
    
    public void addLast(Object o) 
    {
        if(full()) 
        {
            throw new IllegalArgumentException(ARRAY_VOLL);
        }
        
        if(o instanceof Person) 
        {
            if (anzahlPersonen < personArray.length) 
            {
                personArray[anzahlPersonen++] = (Person) o;
            }
        } 
        else 
        {
            throw new IllegalArgumentException(KEIN_PERSON_OBJEKT);
        }
    }
    
    
    //_______________________removeFirst___________________________________
    
    /**
     * removeFirst Entfernt das erste Element und gibt
     *             eine Referenz darauf zurück.  
     *             
     * @throws Eine Exception wird geworfen, wenn die 
     *         Queue leer ist.        
     * @throws Eine Exception wird geworfen, wenn der 
     *         Wert des Elements an der  ist. 
     */
    @Override
    
    public Person removeFirst() 
    {
        if(empty())
        {
            throw new IllegalArgumentException(ARRAY_LEER);
        }

        Person firstPerson = personArray[0];
        for (int i = 0; i < anzahlPersonen - 1; i++) 
        {
            if(personArray[i] == null)
            {
                throw new IllegalArgumentException(ARRAY_LEER);
            }
             else if(personArray[i] != null)
            {
                personArray[anzahlPersonen - 1] = null;
                --anzahlPersonen;
            }
        }
        
        return firstPerson;
    }

    
    //______________________________get___________________________________
    
    /**
     * get Das i-te Element wird zurueckgegeben.
     * 
     * @param i Der Index eines Elements im Array 
     *          an der Stelle i.
     *          
     * @throws Eine Exception wird geworfen, wenn die 
     *         Queue leer ist.        
     * @throws Eine Exception wird geworfen, wenn der 
     *         Wert des Indexes kleiner Null oder 
     *         groesser als die Laenge des Arrays ist. 
     */
    @Override
    
    public Person get(int i) 
    {
        if(empty())
        {
            throw new IllegalArgumentException(ARRAY_LEER);
        }

        if(i < 0 || i > personArray.length) 
        {
            throw new IllegalArgumentException(UNGUELTIGER_INDEX);
        }
        
        if(personArray[i] == null) 
        {
            throw new IllegalArgumentException(NULL_ELEMENT_IN_ARRAY);
        }
        
        return personArray[i];
    }
    
    
    //_______________________empty___________________________________
    
    /**
     * empty Testet, ob die Queue leer ist.
     */
    @Override
    
    public boolean empty() 
    {
        return personArray[0] == null;
    }

    
    //_______________________full____________________________________
    
    /**
     * full Testet, ob noch Elemente einfuegbar sind.
     */
    @Override
    
    public boolean full() 
    {
        return anzahlPersonen == personArray.length;
    }

    
    //_______________________size_____________________________________
    
    /**
     * size Anzahl eingefuegter Elemente.
     * 
     * @param anzahlElementeInArray Die Anzahl der im Array
     *                              enthaltenen Elemente.
     * 
     * @throws Eine Exception wird geworfen, wenn die 
     *         Queue leer ist.        
     */
    @Override
    
    public int size() 
    {
        if(empty())
        {
            throw new IllegalArgumentException(ARRAY_LEER);
        }

        int anzahlElementeInArray = 0;
        for (int i = 0; i < personArray.length; i++) 
        {
            if(personArray[i] != null)
            {
                anzahlElementeInArray++;
            }
        }
        return anzahlElementeInArray;
    }

    
    //________________________toString-Methode______________________________

    /**
     * toString Ermoeglicht es eine String-Repraesentation des Objekts
     *          PersonQueue zu liefern.
     */
    @Override
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("\nWarteliste");
        sb.append("\nVorname     Nachame\n");

        for (int i = 0; i < anzahlPersonen; ++i) 
        {
            sb.append(personArray[i]).append('\n');
        }
        return sb.toString();
    }
}
