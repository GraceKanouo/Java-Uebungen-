
/**
 * Beschreiben Sie hier die Klasse MessreiheRekursiv.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MessreiheRekursiv extends Messreihe
{
    //_________________KONSTANTEN______________________

    public static final String STRING_REGEX = "\\s*";

    //_________________FEHLERMELDUNGEN_________________

    //_________________ATTRIBUTE_______________________

    /**
     * Konstruktor für die rekursive Messreihe.
     *
     * @param strings die Liste von Strings, die von der Messreihe verwaltet werden soll.
     */
    public MessreiheRekursiv(String[] data) 
    {
        super(data);
    }

    /**
     * Ermittelt die Länge jedes Wortes in der Messreihe rekursiv.
     *
     * @return ein Array mit den Längen der Wörter.
     */
    @Override
    public int[] countWortlaenge() 
    {
        int[] wortlaenge = new int[data.length];
        return countWortlaengeRec(0, wortlaenge);
    }

    private int[] countWortlaengeRec(int i, int[] wortlaenge) 
    {
        if (i == data.length) 
        {
            return wortlaenge;
        }

        String[] woerter = data[i].split(STRING_REGEX); // teile String in Wörter auf
        int sum = 0;
        for (String wort : woerter) 
        {
            sum += wort.length(); // zähle Länge jedes Wortes
        }
        wortlaenge[i] = sum;

        return countWortlaengeRec(i + 1, wortlaenge);
    }

    @Override
    public String toString()
    {
        return "rekursiv";
    }
}
