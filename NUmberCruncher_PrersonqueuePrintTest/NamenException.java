/**
 * Die NamenException kann bei ungueltigen Eingaben bezueglich
 * des Namens einer Person verwendet werden.
 * Beispiele für eine ungueltige Eingabe sind:
 * Emily486, -Laura, Louisa-, usw.
 * 
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */
public class NamenException extends RuntimeException 
{
    public NamenException(String message) 
    {
        super(message);
    }
}
