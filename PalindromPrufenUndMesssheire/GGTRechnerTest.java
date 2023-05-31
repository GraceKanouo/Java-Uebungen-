
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
/**
 * Eine Klasse zum Testen der Methoden in der GGTRechner-Klasse.
 *
 * @author  (Grace D. Ntiwa Kanou & Sandra R. Hussong) 
 * @version (20.04.23)
 */
public class GGTRechnerTest
{
    @Test
    public void testBerechneGgt_mit_15_und_20_erwartet_5() 
    {
        int ergebnis = GGTRechner.berechneGgt(15, 20);
        Assertions.assertEquals(5, ergebnis);
    }

    @Test
    public void testBerechneGgt_mit_12_und_18_erwartet_6() 
    {
        int ergebnis = GGTRechner.berechneGgt(12, 18);
        Assertions.assertEquals(6, ergebnis);
    }

    @Test
    public void testBerechneGgt_mit_10_und_25_erwartet_5() 
    {
        int ergebnis = GGTRechner.berechneGgt(10, 25);
        Assertions.assertEquals(5, ergebnis);
    }

    @Test
    public void testBerechneGgt_mit_17_und_19_erwartet_1()
    {
        int ergebnis = GGTRechner.berechneGgt(17, 19);
        Assertions.assertEquals(1, ergebnis);
    }

    
    
    @Test
    public void testBerechneGgt_mit_0_und_12_erwartet_exception()
    {
        Assertions.assertThrows(GGTException.class, () -> 
        {
            GGTRechner.berechneGgt(0, 12);
        });
    }

    @Test
    public void testBerechneGgt_mit_7_und_0_erwartet_exception() 
    {
        Assertions.assertThrows(GGTException.class, () -> 
        {
            GGTRechner.berechneGgt(7, 0);
        });
    }

    @Test
    public void testBerechneGgt_mit_minus5_und_10_erwartet_exception() 
    {
        Assertions.assertThrows(GGTException.class, () -> 
        {
            GGTRechner.berechneGgt(-5, 10);
        });
    }
}
