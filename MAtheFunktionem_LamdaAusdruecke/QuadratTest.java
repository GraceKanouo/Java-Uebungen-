import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Die Klasse tetest die Funktionalitaet der 
 * Quadrat-Funktionen.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class QuadratTest
{
    @Test
    public void testApply_quadratAnonym_mit_1_erwartet__1()
    {
        MatheFunktionen quadrat = new MatheFunktionen();
        MyFunction quadratAnonym = quadrat.quadratAnonym;
        int result = quadratAnonym.apply(1);
        assertEquals(1, result);
    }

    @Test
    public void testApply_quadratAnonym_mit_12_erwartet__144()
    {
        MatheFunktionen quadrat = new MatheFunktionen();
        MyFunction quadratAnonym = quadrat.quadratAnonym;
        int result = quadratAnonym.apply(12);
        assertEquals(144, result);
    }

    @Test
    public void testApply_quadratAnonym_mit_46340_erwartet__2147395600()
    {
        MatheFunktionen quadrat = new MatheFunktionen();
        MyFunction quadratAnonym = quadrat.quadratAnonym;
        int result = quadratAnonym.apply(46340);
        assertEquals(2147395600, result);
    }

    @Test
    public void Apply_quadratAnonym_mit_46340_erwartet_Exception() 
    {
        MatheFunktionen quadrat = new MatheFunktionen();
        MyFunction quadratAnonym = quadrat.quadratAnonym;
        Assertions.assertThrows(MatheException.class, ()-> 
            {
                    quadratAnonym.apply(46341);
            });
    }

    
    //______________FAKULTAET_LAMBDA________________________

    @Test
    public void testApply_quadratLambda_mit_1_erwartet_1() 
    {
        MatheFunktionen mf = new MatheFunktionen();
        MyFunction quadratLambda = mf.quadratLambda;
        int result = quadratLambda.apply(1);
        assertEquals(1, result);
    }

    @Test
    public void testApply_quadratLambda_mit_12_erwartet_144() 
    {
        MatheFunktionen mf = new MatheFunktionen();
        MyFunction quadratLambda = mf.quadratLambda;
        int result = quadratLambda.apply(12);
        assertEquals(144, result);
    }

    @Test
    public void testApply_quadratLambda_mit_5_erwartet_25() 
    {
        MatheFunktionen mf = new MatheFunktionen();
        MyFunction quadratLambda = mf.quadratLambda;
        int result = quadratLambda.apply(5);
        assertEquals(25, result);
    }

    @Test
    public void Apply_quadratLambda_mit_46340_erwartet_Exception() 
    {
        MatheFunktionen mf = new MatheFunktionen();
        MyFunction quadratLambda = mf.quadratLambda;
        assertThrows(MatheException.class, () -> 
            {
                    quadratLambda.apply(46341);
            });
    }
}
