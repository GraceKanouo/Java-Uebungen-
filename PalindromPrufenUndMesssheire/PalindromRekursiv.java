/**
 * Die Klasse implementiert das Palindrom-Interface und ueberprueft,
 * ob ein uebergebener String ein Palindrom ist, 
 * indem sie eine rekursive Methode verwendet.
 * 
 * @author (Grace  D. Ntiwa Kanou)
 * @author (Sandra R. Hussong)
 * 
 * @version (23.04.23)
 */
public class PalindromRekursiv implements Palindrom
{
    //_________________FEHLERMELDUNGEN_______________________
        
    private static final String IST_NULL =
                         "Keine Eingabe!";
    
    /**
     * Zunaechst prueft die Methode, ob der String weniger als 2 Zeichen hat. 
     * Ist das der Fall, handelt es sich um ein Palindrom.
     * Hat der String mehr als 2 Zeichen, werden das erste und letzte Zeichen 
     * auf Gleichheit geprueft.
     * Sind sie gleich, wird der restliche String rekursiv geprueft. 
     * Sind sie nicht gleich, ist der String kein Palindrom.
     * 
     * @param wort Der zu ueberpruefende String
     * 
     * @return true,  wenn der String ein  Palindrom ist
     * @return false, wenn der String kein Palindrom ist
     * 
     */
    @Override
    public boolean istPalindrom(String wort)
    {
        if(wort == null) 
        {
            throw new IllegalArgumentException(IST_NULL);
        }
        wort = wort.replaceAll("\\s", ""); // Leerzeichen entfernen
        if(wort.length() == 0 || wort.length() ==1)
        {
            return true; // ist der String gleich 0 oder 1 -> Palindrom
        }
        else if(wort.charAt(0) == wort.charAt(wort.length() -1))
        {
            String innerString = wort.substring(1,wort.length() - 1);
            return istPalindrom(innerString); // rekursiver Aufruf
        }
        else
        {
            return false;
        }
    }
    
    // HINWEISE
    // Bei Wörtern mit Groß- und Kleinbuchstaben werden Palindrome nicht erkannt
    // Bei Leerzeichen am Anfang/ Ende oder Mitte eines Wortes werden Palindrome nicht erkannt
    // Palindromsätze werden nicht erkannt
}