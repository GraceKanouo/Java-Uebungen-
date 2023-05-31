import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * Die Klasse tetest die Funktionalitaet der 
 * ZahlHochZahlPlus1-Funktionen.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class ZahlHochZahlPlus1Test
{
    private MatheFunktionen matheFunktionen = new MatheFunktionen();

    @Test
    public void testApply_zahlHochZahlPlus1Anonym() 
    {
        MyFunction zahlHochZahlPlus1Anonym = matheFunktionen.zahlHochZahlPlus1Anonym;
        assertEquals(1, zahlHochZahlPlus1Anonym.apply(1));
        assertEquals(16, zahlHochZahlPlus1Anonym.apply(2));
        assertEquals(1073741824, zahlHochZahlPlus1Anonym.apply(8));

        assertThrows(MatheException.class, () -> zahlHochZahlPlus1Anonym.apply(9));
        assertThrows(MatheException.class, () -> zahlHochZahlPlus1Anonym.apply(0));
        assertThrows(MatheException.class, () -> zahlHochZahlPlus1Anonym.apply(-1));
    }

    @Test
    public void testApply_zahlHochZahlPlus1Lambda() 
    {
        MyFunction zahlHochZahlPlus1Lambda = matheFunktionen.zahlHochZahlPlus1Lambda;
        assertEquals(1, zahlHochZahlPlus1Lambda.apply(1));
        assertEquals(16, zahlHochZahlPlus1Lambda.apply(2));
        assertEquals(1073741824, zahlHochZahlPlus1Lambda.apply(8));

        assertThrows(MatheException.class, () -> zahlHochZahlPlus1Lambda.apply(9));
        assertThrows(MatheException.class, () -> zahlHochZahlPlus1Lambda.apply(0));
        assertThrows(MatheException.class, () -> zahlHochZahlPlus1Lambda.apply(-1));
    }
}
