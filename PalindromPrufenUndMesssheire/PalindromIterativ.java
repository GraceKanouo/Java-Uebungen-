/**
 * Die Klasse implementiert das Palindrom-Interface und ueberprueft,
 * ob ein uebergebener String ein Palindrom ist, 
 * indem sie eine iterative Methode verwendet.
 * 
 * @author (Grace  D. Ntiwa Kanou)
 * @author (Sandra R. Hussong)
 * 
 * @version (23.04.23)
 */
public class PalindromIterativ implements Palindrom
{
    //_________________FEHLERMELDUNGEN_______________________

    private static final String IST_NULL =
        "Keine Eingabe!";

    /**
     * Zwei Zeiger werden auf den Anfang und das Ende des Strings gesetzt. 
     * Die Methode vergleicht in jeder Iteration das erste (i) und das 
     * letzte (j) Zeichen des Strings. 
     *      
     * @param wort Der zu ueberpruefende String
     * 
     * @return true,  wenn alle Paare von Anfang und Ende gleich sind
     * @return false, wenn zwei Zeichen nicht uebereinstimmen
     * 
     */
    @Override
    public  boolean istPalindrom(String wort)
    {
        if(wort == null)
        {
            throw new IllegalArgumentException(IST_NULL);
        }
        wort = wort.replaceAll("\\s", ""); // Leerzeichen entfernen
        for(int i = 0, j = wort.length() -1; i < j;  i++, j--)
        {
            if(wort.charAt(i) != wort.charAt(j))
            {
                return false;
            }
        }
        return true;
    }
    
    // HINWEISE
    // Bei Wörtern mit Groß- und Kleinbuchstaben werden Palindrome nicht erkannt
    // Bei Leerzeichen am Anfang/ Ende oder Mitte eines Wortes werden Palindrome nicht erkannt
    // Palindromsätze werden nicht erkannt
}