/**
 * Tragen Sie hier eine Beschreibung des Interface Queue ein.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

 public interface Queue
 {
     public void addLast (Object o); // Objekt hinten anfuegen
     
     public Object removeFirst();    // erstes Element entfernen und
                                     // eine Referenz darauf zurückgeben.
     
     public Object get(int i);       // Das i-te Element zurueckgeben
     
     public boolean empty();         // Testen, ob die Queue leer ist
     
     public boolean full();          // Testen, ob noch Elemente einfuegbar sind
     
     public int size();              // Anzahl eingefuegter Elemente
 }
 