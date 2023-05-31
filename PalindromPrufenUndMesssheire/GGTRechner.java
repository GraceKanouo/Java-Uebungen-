
/**
 * Eine Klasse, die mit Hilfe des euklidischen Algorithmus,den groeßten gemeinsamen 
 * Teiler (ggT) berechnet, indem sie wiederholt den Modulowert von a und b berechnet,
 * bis der kleinere Wert b Null wird und der groeßere Wert a dem ggT entspricht.
 * 
 * @author  (Grace D. Ntiwa Kanou & Sandra R. Hussong) 
 * @version (20.04.23)
 */
public class GGTRechner
{
    //_______________FEHLERMELDUNGEN_____________________________

    private static final String KEINE_NATUeRLICHE_ZAHL =
        "\nDie Eingabe muss aus zwei natuerlichen Zahlen (1, 2, 3, 4,...) bestehen.\n" +
        "Bitte ueberpruefen Sie Ihre Eingabe: \n";

    //_______________KONSTRUKTOR_____________________________
    /**
     * Konstruktor, der die Instanziierung eines GGT-Objekts verhindert.
     */
    private GGTRechner()
    {
    }

    //_______________GGT_BERECHNEN_____________________________
    /**
     * Berechnet mit Hilfe des euklidischen Algorithmus den groeßten gemeinsamen
     * Teiler (ggT) zweier natuerlicher Zahlen a und b.
     *
     * @param a Die erste  natuerliche Zahl
     * @param b Die zweite natuerliche Zahl
     * 
     * @return Der groeßte gemeinsame Teiler von a und b
     * 
     * @throws IllegalArgumentException, 
     *         wenn a oder b keine natuerlichen Zahlen (d.h. <= 0) sind
     */
    public static int berechneGgt(int a, int b) throws GGTException 
    {
        int tempspeicher;

        // Ueberprueft, ob a und b in IN enthalten sind
        if (a <= 0 || b <= 0) 
        {
            throw new GGTException(KEINE_NATUeRLICHE_ZAHL + "a = " + a + "\n" + "b = " + b);
        }

        // Abbruchbedingung
        if (b == 0) 
        {
            return a;
        }

        // Vertauscht a und b, falls a kleiner b 
        if (a < b) 
        {
            tempspeicher = a;
            a = b;
            b = tempspeicher;
        }

        // Berechnet Modulowert von a und b und speichert Ergebnis in tempspeicher,
        // a wird auf alten Wert von b und b auf Modulowert (= tempspeicher) gesetzt
        // Vorgang wird wiederholt, bis b = 0 ist
        while (b != 0) 
        {
            tempspeicher = b;
            b = a % b;
            a = tempspeicher;
        }

        return a;
    }
}
