import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Die Test-Klasse WeissweinTest.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 07.05.23
 */
public class WeissweinTest
{
    //______________KONSTRUKTOR______________________________

    @Test
    public void testKonstruktorMitParametern_erwartetRichtigGesetzt() 
    {
        float alkoholgehalt = 7.5f;
        String weingut = "Château Latour";
        Weisswein weisswein = new Weisswein(alkoholgehalt, weingut);
        assertEquals(weisswein.getAlkoholgehalt(), alkoholgehalt);
        assertEquals(weisswein.getWeingut(), weingut);
    }

    @Test
    public void testKonstruktorMitNegAlkgehalt_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Weisswein weisswein = new Weisswein(-1.0f, "Château Latour");
            });
    }

    @Test
    public void testKonstruktorMitLeeremString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Weisswein weisswein = new Weisswein(12.0f, "");
            });
    }

    @Test
    public void testKonstruktorMitNullString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Weisswein weisswein = new Weisswein(9.5f, null);
            });
    }

    //______________SETTER___________________________________
    @Test
    public void testSetWeissweingut_erwartetRichtigGesetzt() 
    {
        String weissweingut = "Château Latour";
        Weisswein weisswein = new Weisswein();
        weisswein.setWeingut(weissweingut);
        assertEquals(weisswein.getWeingut(), weissweingut);
    }

    @Test
    public void testSetWeissweingutMitNull_erwartetException() 
    {
        Weisswein weisswein = new Weisswein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    weisswein.setWeingut(null);
            });
    }

    @Test
    public void testSetWeissweingutMitLeeremString_erwartetException() 
    {
        Weisswein weisswein = new Weisswein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    weisswein.setWeingut("");
            });
    }

    @Test
    public void testSetAlkoholgehaltMitNegativemWert_erwartetException() 
    {
        Weisswein weisswein = new Weisswein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    weisswein.setAlkoholgehalt(-1.0f);
            });
    }

    @Test
    public void testSetAlkoholgehaltMit0Komma0_erwartetException() 
    {
        Weisswein weisswein = new Weisswein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    weisswein.setAlkoholgehalt(0.0f);
            });
    }

    //______________EQUALS_____________________________________
    @Test
    public void testEqualsMitIdentischenObjekten_erwartetTrue() 
    {
        Weisswein weisswein1 = new Weisswein(7.5f, "Anselmann");
        Weisswein weisswein2 = weisswein1;
        assertEquals(weisswein1, weisswein2);
    }

    @Test
    public void testEqualsMitUngleichenObjekten_erwartetFalse() 
    {
        Weisswein weisswein1 = new Weisswein(7.5f, "Anselmann");
        Weisswein weisswein2 = new Weisswein(7.5f, "Schloss Proschwitz Prinz zur Lippe");
        Assertions.assertNotEquals(weisswein1, weisswein2);
    }

    @Test
    public void testEqualsMitGleichenObjekten_erwartetFalse() 
    {
        Weisswein weisswein1 = new Weisswein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        Weisswein weisswein2 = new Weisswein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        Assertions.assertNotEquals(weisswein1, weisswein2);
    }

    //______________TO_STRING______________________________
    @Test
    public void testWeissweinToString() 
    {
        Weisswein weisswein = new Weisswein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        assertEquals("Getraenk 8.0 % Vol. vom Weingut Schloss Proschwitz Prinz zur Lippe, weiss", weisswein.toString());
    }

}