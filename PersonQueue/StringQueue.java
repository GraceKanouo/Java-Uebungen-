
/**
 * Beschreiben Sie hier die Klasse StringQueue.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class StringQueue implements Queue
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
            
    private static final String KEIN_STRING_OBJEKT =        
            "Das übergebene Objekt ist kein String";
            
            
    //________________________Konstanten___________________________________
    
    private static final int KAPAZITAET = 10;
    
        
    //________________________Attribute____________________________________
      
    private String[] stringArray;
    private int anzahlStrings;
    private int pointer = 0;
    
    //________________________Konstruktoren________________________________
    
    /**
     * Der Konstruktor versetzt das Objekt StringQueue  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * Die Kapazitaet des stringArrays ist bei diesem
     * Konstruktor frei waehlbar.
     * 
     * @param size Die Groesse des Arrays.
     * 
     * @throws Eine Exception wird geworfen, wenn die 
     *         Groesse des stringArrays kleiner 0 ist.
     */
    public StringQueue(int size) 
    {
        stringArray = new String[size];
        if(size <= 0)
        {
            throw new IllegalArgumentException(UNGUELTIGE_ARRAYGROESSE);
        }
        stringArray = new String[size];
    }
    
    /**
     * Der Konstruktor versetzt das Objekt StringQueue  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * Die Kapazitaet des stringArrays ist bei diesem
     * Konstruktor bereits festgelegt.
     */
    public StringQueue()
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
     *         kein String-Objekt ist.
     */
    @Override
    
    public void addLast(Object o) 
    {
        if(full()) 
        {
            throw new IllegalArgumentException(ARRAY_VOLL);
        }
        
        if(o instanceof String) 
        {
            if(anzahlStrings < stringArray.length) 
            {
                stringArray[anzahlStrings++] = (String) o;
            }
        } 
        else 
        {
            throw new IllegalArgumentException(KEIN_STRING_OBJEKT);
        }
    }
    
    
    //_______________________removeFirst___________________________________
    
    /**
     * removeFirst Entfernt das erste Element und gibt
     *             eine Referenz darauf zurück.  
     *             
     * @throws Eine Exception wird geworfen, wenn die 
     *         Queue leer ist.        
     */
    @Override
    
    public String removeFirst() 
    {
        if(empty())
        {
            throw new IllegalArgumentException(ARRAY_LEER);
        }
        
        String firstString = stringArray[0];
        for (int i = 0; i < anzahlStrings - 1; i++) 
        {
            if(stringArray[i] == null) 
            {
                throw new IllegalArgumentException(NULL_ELEMENT_IN_ARRAY);
            }
            else if(stringArray[i] != null)
            {
                stringArray[anzahlStrings - 1] = null;
                --anzahlStrings;
            }
        }
        
        stringArray[stringArray.length - 1] = null;
        
        return firstString;
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
    
    public String get(int i) 
    {
        if(empty())
        {
            throw new IllegalArgumentException(ARRAY_LEER);
        }
        
        if(i < 0 || i > stringArray.length) 
        {
            throw new IllegalArgumentException(UNGUELTIGER_INDEX);
        }
        
        if(stringArray[i] == null) 
        {
            throw new IllegalArgumentException(NULL_ELEMENT_IN_ARRAY);
        }
        
        return stringArray[i];
    }
    
    
    //_______________________empty___________________________________
    
    /**
     * empty Testet, ob die Queue leer ist.
     */
    @Override
    
    public boolean empty() 
    {
        return stringArray[0] == null;
    }
    
    
    //_______________________full____________________________________
    
    /**
     * full Testet, ob noch Elemente einfuegbar sind.
     */
    @Override
    
    public boolean full() 
    {
        return anzahlStrings == stringArray.length;
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
        for (int i = 0; i < stringArray.length; i++) 
        {
            if(stringArray[i] != null)
            {
                anzahlElementeInArray++;
            }
        }
        return anzahlElementeInArray;
    }
    
    
    //________________________toString-Methode______________________________

    /**
     * toString Ermoeglicht es eine String-Repraesentation des Objekts
     *          StringQueue zu liefern.
     */
    @Override
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder("\nWarteliste");
        sb.append("\n" + "" + "\n");

        for (int i = 0; i < anzahlStrings; ++i) 
        {
            sb.append(stringArray[i]).append('\n');
        }
        return sb.toString();
    }
}
