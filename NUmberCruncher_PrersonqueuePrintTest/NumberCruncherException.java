

/**
 *Die Klasse NumberCruncherException ist ein benutzer Definierte Ausnahme Klasse
 *@throws Exception wenn eine Falsche Eingabe irgendwo bemerkt wird
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class NumberCruncherException extends RuntimeException
{
    public NumberCruncherException(String message)
    {
        super(message);
    }
    
    
    public NumberCruncherException()
    {
    
    }
}
