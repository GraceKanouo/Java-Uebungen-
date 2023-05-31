import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

/**
 * Die Klasse tetest die Funktionalitaet der 
 * Fibonacci-Funktionen.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class FibonacciTest
{
    private MatheFunktionen matheFunktionen = new MatheFunktionen();

    @Test
    public void testApply_fibonacciAnonym() 
    {
        MyFunction fibonacciAnonym = matheFunktionen.fibonacciAnonym;
        assertEquals(1, fibonacciAnonym.apply(1));
        assertEquals(1, fibonacciAnonym.apply(2));
        assertEquals(55, fibonacciAnonym.apply(10));

        assertThrows(MatheException.class, () -> fibonacciAnonym.apply(47));
        assertThrows(MatheException.class, () -> fibonacciAnonym.apply(0));
        assertThrows(MatheException.class, () -> fibonacciAnonym.apply(-1));
    }

    @Test
    public void testApply_fibonacciLambda() 
    {
        MyFunction fibonacciLambda = matheFunktionen.fibonacciLambda;
        assertEquals(1, fibonacciLambda.apply(1));
        assertEquals(1, fibonacciLambda.apply(2));
        assertEquals(55, fibonacciLambda.apply(10));

        assertThrows(MatheException.class, () -> fibonacciLambda.apply(47));
        assertThrows(MatheException.class, () -> fibonacciLambda.apply(0));
        assertThrows(MatheException.class, () -> fibonacciLambda.apply(-1));
    }

}
