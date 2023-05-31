
/**
 * Das Interface Queue definiert Methoden zum Einfuegen, Entfernen und Zugreifen auf
 * Elemente in einer Warteschlange.
 * Objekte koennen hinten angehaengt und das erste Element entfernt werden.
 * Zudem kann auf Elemente an bestimmten Positionen zugegriffen werden.
 * Es ist moeglich, die Queue auf Vollstaendigkeit und Leere zu testen und die
 * Anzahl der Elemente in der Queue zu ermitteln.
 * 
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */

public interface Queue
{
    /**
     * addLast Ermoeglicht das Anhaengen von Objekten an eine Queue,
     *         sofern diese nicht ihre maximale Kapazitaet erreicht 
     *         hat.
     *
     * @param o Das Objekt, das angehaengt werden soll
     */
    public void addLast (Object o); // Objekt hinten anfuegen

    /**
     * removeFirst Entfernt das erste Objekt in der Queue und gibt 
     *             dieses zurueck, sofern die Queue nicht leer ist.
     *
     * @return Das entfernte Objekt
     */
    public Object removeFirst();    // erstes Element entfernen und
                                    // eine Referenz darauf zurueckgeben.

    /**
     * get Gibt das Element an der Stelle i zurueck, sofern die Queue
     *     nicht leer ist.
     *
     * @param i Der Index eines Elementes in der Queue
     * 
     * @return Das i'te Element
     */
    public Object get(int i);       // Das i-te Element zurueckgeben

    /**
     * empty Testet, ob die Queue leer ist.
     *
     * @return true, wenn die Queue leer ist, ansonsten false
     */
    public boolean empty();         // Testen, ob die Queue leer ist

    /**
     * full Testet, ob die Queue voll ist.
     *
     * @return true, wenn die Queue voll ist, ansonsten false
     */
    public boolean full();          // Testen, ob noch Elemente einfuegbar sind

    /**
     * size Ermittel die Anzahl der Elemente in der Queue.
     *
     * @return Die Anzahl der Elemente
     */
    public int size();              // Anzahl eingefuegter Elemente
}
