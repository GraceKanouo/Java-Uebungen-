import java.util.*;
/**
 * Die Klasse PersonQueue ermoeglicht die Erzeugung einer
 * Warteschlange.
 * Personen koennen zur Queue hinzugefuegt und wieder entfernt, 
 * einzelne Person-Objekte ausgegeben und die Person, mit
 * dem lexikalisch kleinsten Namen ermittelt werden.
 * Zudem kann geprueft werden, ob das Array voll oder leer und
 * die Arraygroeße wiedergegeben werden.
 * 
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
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
        "Das uebergebene Objekt ist keine Person";

        
    //________________________Konstanten___________________________________
    
    private static final int KAPAZITAET = 10;
    
    
    //________________________Attribute____________________________________

    private Person[] personArray;
    private int anzahlPersonen;

    
    //________________________INNERE_KLASSE________________________________
    
    private class InternerIterator implements PersonIterator
    {
        private int currentIndex = 0;

        /**
         * hasNext Gibt true zurueck, wenn der Iterator weitere 
         *         Elemente enthaelt. Ansonsten false.
         * 
         * @return true, wenn der Iterator weitere Elemente enthaelt.
         */
        @Override
        public boolean hasNext() 
        {
            return currentIndex < anzahlPersonen;
        }

        /**
         * next Gibt das naechste Person−Objekt zurueck
         * 
         * @return Das naechste Person−Objekt.
         */
        @Override
        public Person next() 
        {
            if (!hasNext()) 
            {
                throw new NoSuchElementException();
            }
            return personArray[currentIndex++];
        }
    }

    
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
     * addLast Ermoeglicht es ein Objekt hinten an die 
     *         Queue anzufuegen.
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
        if ( o == null )
        {
            throw new RuntimeException("Objekt ist Null");
        }

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
     *             eine Referenz darauf zurueck.  
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
            if(personArray[i] != null)
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
            throw new NoSuchElementException(ARRAY_LEER);
        }

        if(i < 0 || i >= personArray.length) 
        {
            throw new IllegalArgumentException(UNGUELTIGER_INDEX);
        }

        if(personArray[i] == null) 
        {
            throw new NoSuchElementException(NULL_ELEMENT_IN_ARRAY);
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
        return anzahlPersonen == 0;
    }

    
    //_______________________full____________________________________
    
    /**
     * full Testet, ob die Queue voll ist.
     */
    @Override
    public boolean full() 
    {
        return anzahlPersonen == personArray.length;
    }

    
    //_______________________size_____________________________________
    
    /**
     * size Ermittelt die Anzahl eingefuegter Elemente.
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

    
    //_______________________print_____________________________________
    
    /**
     * print Iteriert durch die Queue und gibt diese
     *       auf der Konsole aus.
     *
     */
    public void print() 
    {
        InternerIterator iterator = new InternerIterator();
        while (iterator.hasNext()) 
        {
            System.out.println(iterator.next());
        }
    }

    
    //_______________________smallest_____________________________________
    
    /**
     * smallest Ermittelt den Namen der Person, mit dem lexikalisch
     *          kleinsten Namen.
     *
     * @return Der Name der Person, mit dem lexikalisch
     *         kleinsten Namen.
     */
    public String smallest() 
    {
        if(empty())
        {
            throw new IllegalArgumentException(ARRAY_LEER);
        }

        PersonIterator iterator = new InternerIterator();

        Person firstPerson  = iterator.next();
        String smallestName = firstPerson.getNachname() + 
            " " + firstPerson.getVorname();

        while (iterator.hasNext()) 
        {
            Person currentPerson    = iterator.next();
            String currentNachname  = currentPerson.getNachname();
            String currentVorname   = currentPerson.getVorname();
            String currentName      = currentNachname + 
                " " + currentVorname;

            if (currentName.compareToIgnoreCase(smallestName) < 0) 
            {
                smallestName = currentName;
            }
        }
        return smallestName;
    }

    
    //________________________toString-Methode______________________________
    
    /**
     * toString Ermoeglicht es eine String-Repraesentation des Objekts
     *          PersonQueue zu liefern.
     */
    @Override
    public String toString() 
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < anzahlPersonen; ++i) 
        {
            sb.append(personArray[i]).append('\n');
        }
        return sb.toString();
    }
}