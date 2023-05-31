
/**
 * Beschreiben Sie hier die Klasse Exception.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MatheException extends RuntimeException
{
    /**
     * Konstruktor für Objekte der Klasse Exception
     */
    public MatheException()
    {

    }
    /**
     * Konstruktor für Objekte der Klasse Exception
     */
    public MatheException(String message)
    {
        super(message);

    }
    public MatheException(String message, Throwable cause)
    {
        super(message,cause);

    }
    public MatheException(Throwable cause)
    {
        super(cause);

    } 
   
}
