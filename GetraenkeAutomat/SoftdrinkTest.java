import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Die Test-Klasse SoftdrinkTest.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 07.05.23
 */
public class SoftdrinkTest
{
    //______________KONSTRUKTOR______________________________

    @Test
    public void testKonstruktorMitParametern_erwartetRichtigGesetzt() 
    {
        float zuckergehalt = 5.0f;
        String hersteller = "Schweppes";
        Softdrink softdrink = new Softdrink(hersteller, zuckergehalt);

        assertEquals(softdrink.getHersteller(), hersteller);
        assertEquals(softdrink.getZuckergehalt(), zuckergehalt);
    }

    
    @Test
    public void testKonstruktorMitNegZuckergehalt_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Softdrink softdrink = new Softdrink("Schweppes", -1.0f);
            });
    }

    @Test
    public void testKonstruktorMitLeeremString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Softdrink softdrink = new Softdrink("", 7.0f);
            });
    }

    @Test
    public void testKonstruktorMitNullString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Softdrink softdrink = new Softdrink(null, 7.0f);
            });
    }

    
    
    //______________SETTER___________________________________
    
    @Test
    public void testSetHersteller_erwartetRichtigGesetzt() 
    {
        String hersteller = "Schweppes";
        Softdrink softdrink = new Softdrink();
        softdrink.setHersteller(hersteller);
        assertEquals(softdrink.getHersteller(), hersteller);
    }

    
    @Test
    public void testSetHerstellerMitNull_erwartetException() 
    {
        Softdrink softdrink = new Softdrink();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    softdrink.setHersteller(null);
            });
    }

    @Test
    public void testSetHerstellerMitLeeremString_erwartetException() 
    {
        Softdrink softdrink = new Softdrink();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    softdrink.setHersteller("");
            });
    }

    
    @Test
    public void testSetZuckergehaltMitNegativemWert_erwartetException() 
    {
        Softdrink softdrink = new Softdrink();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    softdrink.setZuckergehalt(-1.0f);
            });
    }


    
    //______________EQUALS_____________________________________
    
    @Test
    public void testEqualsMitIdentischenObjekten_erwartetTrue() 
    {
        Softdrink softdrink1 = new Softdrink("Schweppes", 7.0f);
        Softdrink softdrink2 = softdrink1;
        assertEquals(softdrink1, softdrink2);
    }

    
    @Test
    public void testEqualsMitUngleichenObjekten_erwartetFalse() 
    {
        Softdrink softdrink1 = new Softdrink("Bionade", 10.0f);
        Softdrink softdrink2 = new Softdrink("Schweppes", 7.0f);
        Assertions.assertNotEquals(softdrink1, softdrink2);
    }

    @Test
    public void testEqualsMitGleichenObjekten_erwartetFalse() 
    {
        Softdrink softdrink1 = new Softdrink("Schweppes", 7.0f);
        Softdrink softdrink2 = new Softdrink("Schweppes", 7.0f);
        Assertions.assertNotEquals(softdrink1, softdrink2);
    }

    
    
    //______________TO_STRING______________________________
    
    @Test
    public void testSoftdrinkToString() 
    {
        Softdrink softdrink = new Softdrink("Schweppes", 7.0f);
        assertEquals("Getraenk Schweppes, alkoholfrei 7.0% Zucker", softdrink.toString());
    }
}
