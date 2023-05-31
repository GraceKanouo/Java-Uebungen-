import java.io.*;
/**
 * Beschreiben Sie hier die Klasse MessreiheIterativ.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MessreiheIterativ extends Messreihe
{
    //_________________KONSTANTEN______________________

    private static final String STRING_REGEX = "\\s*";

    //_________________FEHLERMELDUNGEN_________________

    //_________________ATTRIBUTE_______________________

    /**
     * Konstruktor für die iterative Messreihe.
     *
     * @param strings die Liste von Strings, die von der Messreihe verwaltet werden soll.
     */
    public MessreiheIterativ(String[] data) 
    {
        super(data);
    }

    /**
     * Ermittelt die Länge jedes Wortes in der Messreihe iterativ.
     *
     * @return ein Array mit den Längen der Wörter.
     */
    @Override
    public int[] countWortlaenge() 
    {
        int[] wortlaenge = new int[data.length];
        for (int i = 0; i < data.length; i++) 
        {
            String[] woerter = data[i].split(STRING_REGEX); // teile String in Wörter auf
            int sum = 0;
            for (String wort : woerter) 
            {
                sum += wort.length(); // zähle Länge jedes Wortes
            }
            wortlaenge[i] = sum;

        }
        return wortlaenge;
    }

    @Override
    public String toString()
    {
        return "iterativ";
    }
}
