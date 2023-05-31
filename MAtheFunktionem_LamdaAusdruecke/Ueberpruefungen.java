/**
 * Die Klasse beinhaltet verschiedene Ueberpruefungen
 * die in anderen Klassen aufgerufen werden koennen.
 * 
 * Man kann beispielsweise testen, ob eine Zahl natuerlich
 * ist.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class Ueberpruefungen 
{
    /**
     * istNatuerlicheZahl Prueft, ob eine Zahl natuerlich ist.
     * 
     * @param zahl Die Zahl, die ueberprueft werden soll.
     */
    public static boolean istNatuerlicheZahl(int zahl)
    {
        return zahl >= 1;
    } 

    /**
     * istZahlImBereich Prueft, ob die Eingabe einer Zahl den 
     *                          maximalen INPUT-Wert 
     *                          ueberschreitet
     *                          
     *                  
     * @param zahl    Die eingegebene Zahl
     * @param maxWert Der maximale INPUT-Wert, der berechnet
     *                werden kann.
     * @return        true, wenn Zahl kleiner als maxWert, 
     *                ansinsten false
     */
    public static boolean istZahlImBereich(int zahl, int maxWert)
    {
        return zahl <= maxWert;
    }

    /**
     * getMaxInputFakultaet Ermittelt, bei welchem Input es zu 
     *                      einem Overflow kommt.
     *
     * @return Der maximal moegliche INPUT-Wert, der ohne 
     *         Overflow berechnet werden kann.
     */
    public static int getMaxInputFakultaet() 
    {
        int result = 1;
        int i = 1;
        while (result <= Integer.MAX_VALUE / i) 
        {
        result *= i;
        i++;
        }
        return i - 1;
    }

    /**
     * getMaxInputQuadrat Ermittelt, bei welchem Input es zu 
     *                      einem Overflow kommt.
     *
     * @return Der maximal moegliche INPUT-Wert, der ohne 
     *         Overflow berechnet werden kann.
     */
    public static int getMaxInputQuadrat() 
    {
        int i = (int) Math.sqrt(Integer.MAX_VALUE);
        return i;
    }

    /**
     * getMaxInputZahlHochZahlPlus1 Ermittelt, bei welchem 
     *                              Input es zu einem 
     *                              Overflow kommt.
     *
     * @return Der maximal moegliche INPUT-Wert, der ohne 
     *         Overflow berechnet werden kann.
     */
    public static int getMaxInputZahlHochZahlPlus1() 
    {
        int i = 0;
        while (Math.pow(i, i + 1) <= Integer.MAX_VALUE) 
        {
            i++;
        }
        // Reduziere den Wert um 1, um den maximalen 
        // gueltigen Eingabewert zu erhalten
        return i - 1;
    }

    /**
     * getMaxInputFibonacci Ermittelt, bei welchem Input es zu 
     *                      einem Overflow kommt.
     *
     * @return Der maximal moegliche INPUT-Wert, der ohne 
     *         Overflow berechnet werden kann.
     */
    public static int getMaxInputFibonacci() 
    {
        int fib = 1;
        int prev1 = 1;
        int prev2 = 1;
        int i = 2;

        while (fib >= 0) 
        {
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;
            i++;
        }

        return i - 1;
    }
}
