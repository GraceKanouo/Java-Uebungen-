/**
 * Die Klasse berechnet die Fakultaet
 * einer Zahl.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 09.05.23
 */
public class FakultaetTL implements MyFunction
{
     //_______________KONSTANTEN_________________________________

    public static final int MAX_EINGABEWERT = Ueberpruefungen.getMaxInputFakultaet(); 

    
    //_______________FEHLERMELDUNGEN___________________________
       
    public static final String UNGUELTIGE_EINGABE = 
           "Die Zahl darf nicht kleiner als 1 oder groesser " +
           MAX_EINGABEWERT + " sein!";

    

    /**
     * Der Konstrunkter verhindert die Erzeugung eines
     * FakultaetTL-Objekts.
     */
    public FakultaetTL() {}

    /**
     * apply Berechnet die Fakultaet einer Zahl i.
     *
     * @param i Eine Zahl
     * @return  Das Ergebnis der Berechnung
     *          mit dem Wert i.
     */
    @Override
    public int apply(int i) 
    {
        if(!Ueberpruefungen.istNatuerlicheZahl(i) || 
           !Ueberpruefungen.istZahlImBereich(i,MAX_EINGABEWERT))
        {
            throw new MatheException(UNGUELTIGE_EINGABE);
        }

        int result = 1;
        for (int j = 2; j <= i; j++)
        {
            result *= j;
        }
        return result;
    }
}
