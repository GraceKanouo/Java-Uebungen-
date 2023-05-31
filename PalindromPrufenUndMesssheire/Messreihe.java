import java.io.PrintWriter;
import java.io.*;

/**
 * Beschreiben Sie hier die Klasse Messreihen.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Messreihe

{
    //_________________FEHLERMELDUNGEN_________________

    public static final String NULL_INPUT = 
           "Das Array darf nicht leer sein!";
    
           
    //_________________ATTRIBUTE_______________________

    protected String[] data;
    
    /**
     * Konstruktor für die Messreihe.
     *
     * @param strings Die Liste von Strings, die von der 
     *                Messreihe verwaltet werden soll.
     */
    public Messreihe(String[] data) 
    {
        if (data == null) 
        {
            throw new IllegalArgumentException(NULL_INPUT);
        }
    
        this.data = data;
    }
    
    
    /**
     * Ermittelt die Länge jedes Wortes in der Messreihe.
     *
     * @return ein Array mit den Längen der Wörter.
     * 
     */
    public abstract int[] countWortlaenge();

    
    /**
     * Gibt die Anzahl der Strings in der Messreihe zurück.
     *
     * @return die Anzahl der Strings.
     */
    public int size() 
    {
        return data.length;
    }
}
