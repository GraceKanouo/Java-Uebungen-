import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Die Test-Klasse WeinTest.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 07.05.23
 */
public class WeinTest
{
    //______________KONSTRUKTOR______________________________

    @Test
    public void testKonstruktorMitParametern_erwartetRichtigGesetzt() 
    {
        float alkoholgehalt = 7.5f;
        String weingut = "Château Latour";
        Wein wein = new Wein(alkoholgehalt, weingut);
        assertEquals(wein.getAlkoholgehalt(), alkoholgehalt);
        assertEquals(wein.getWeingut(), weingut);
    }

    @Test
    public void testKonstruktorMitNegAlkgehalt_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wein wein = new Wein(-1.0f, "Château Latour");
            });
    }

    @Test
    public void testKonstruktorMitLeeremString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wein wein = new Wein(12.0f, "");
            });
    }

    @Test
    public void testKonstruktorMitNullString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wein wein = new Wein(9.5f, null);
            });
    }

    //______________SETTER___________________________________
    @Test
    public void testSetWeingut_erwartetRichtigGesetzt() 
    {
        String weingut = "Château Latour";
        Wein wein = new Wein();
        wein.setWeingut(weingut);
        assertEquals(wein.getWeingut(), weingut);
    }

    @Test
    public void testSetWeingutMitNull_erwartetException() 
    {
        Wein wein = new Wein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wein.setWeingut(null);
            });
    }

    @Test
    public void testSetWeingutMitLeeremString_erwartetException() 
    {
        Wein wein = new Wein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wein.setWeingut("");
            });
    }

    @Test
    public void testSetAlkoholgehaltMitNegativemWert_erwartetException() 
    {
        Wein wein = new Wein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wein.setAlkoholgehalt(-1.0f);
            });
    }

    @Test
    public void testSetAlkoholgehaltMit0Komma0_erwartetException() 
    {
        Wein wein = new Wein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wein.setAlkoholgehalt(0.0f);
            });
    }

    //______________EQUALS_____________________________________
    @Test
    public void testEqualsMitIdentischenObjekten_erwartetTrue() 
    {
        Wein wein1 = new Wein(7.5f, "Anselmann");
        Wein wein2 = wein1;
        assertEquals(wein1, wein2);
    }

    @Test
    public void testEqualsMitUngleichenObjekten_erwartetFalse() 
    {
        Wein wein1 = new Wein(7.5f, "Anselmann");
        Wein wein2 = new Wein(7.5f, "Schloss Proschwitz Prinz zur Lippe");
        Assertions.assertNotEquals(wein1, wein2);
    }

    @Test
    public void testEqualsMitGleichenObjekten_erwartetFalse() 
    {
        Wein wein1 = new Wein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        Wein wein2 = new Wein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        Assertions.assertNotEquals(wein1, wein2);
    }

    //______________TO_STRING______________________________
    @Test
    public void testWeinToString() 
    {
        Wein wein = new Wein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        assertEquals("Getraenk 8.0 % Vol. vom Weingut Schloss Proschwitz Prinz zur Lippe", wein.toString());
    }

}