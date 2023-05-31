import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * Die Klasse testet die Funktionalitat der 
 * Fakultaet-Funktionen.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class FakultaetTest
{
    private MatheFunktionen matheFunktionen = new MatheFunktionen();

    @Test
    public void testApply_fakultaetAnonym() 
    {
        MyFunction fakultaetAnonym = matheFunktionen.fakultaetAnonym;
        assertEquals(1, fakultaetAnonym.apply(1));
        assertEquals(479001600, fakultaetAnonym.apply(12));
        assertEquals(120, fakultaetAnonym.apply(5));

        assertThrows(MatheException.class, () -> fakultaetAnonym.apply(13));
        assertThrows(MatheException.class, () -> fakultaetAnonym.apply(0));
        assertThrows(MatheException.class, () -> fakultaetAnonym.apply(-1));
    }

    @Test
    public void testApply_fakultaetLambda() 
    {
        MyFunction fakultaetLambda = matheFunktionen.fakultaetLambda;
        assertEquals(1, fakultaetLambda.apply(1));
        assertEquals(479001600, fakultaetLambda.apply(12));
        assertEquals(120, fakultaetLambda.apply(5));

        assertThrows(MatheException.class, () -> fakultaetLambda.apply(13));
        assertThrows(MatheException.class, () -> fakultaetLambda.apply(0));
        assertThrows(MatheException.class, () -> fakultaetLambda.apply(-1));
    }

    @Test
    public void testApply_fakultaetTL() 
    {
        FakultaetTL fakultaetTL = new FakultaetTL();
        assertEquals(1, fakultaetTL.apply(1));
        assertEquals(479001600, fakultaetTL.apply(12));
        assertEquals(120, fakultaetTL.apply(5));
        
        assertThrows(MatheException.class, () -> fakultaetTL.apply(13));
        assertThrows(MatheException.class, () -> fakultaetTL.apply(0));
        assertThrows(MatheException.class, () -> fakultaetTL.apply(-1));
    }
}
