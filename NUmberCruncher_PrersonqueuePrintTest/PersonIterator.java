/**
 * Das Interface PersonIterator definiert Methoden 
 * zum Iterieren durch eine Liste von Personen.
 * 
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */

public interface PersonIterator
{
    /**
     * hasNext Gibt true zurueck, wenn der Iterator weitere Elemente enthaelt.
     *         Ansonsten false.
     * 
     * @return true, wenn der Iterator weitere Elemente enthaelt.
     */
    public boolean hasNext();

    /**
     * next Gibt das naechste Person−Objekt zurueck
     * 
     * @return Das naechste Person−Objekt.
     */
    public Person next();
}
