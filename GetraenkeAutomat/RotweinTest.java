import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Die Test-Klasse RotweinTest.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 07.05.23
 */
public class RotweinTest
{
    //______________KONSTRUKTOR______________________________

    @Test
    public void testKonstruktorMitParametern_erwartetRichtigGesetzt() 
    {
        float alkoholgehalt = 7.5f;
        String rotweingut = "Château Latour";
        Rotwein rotwein = new Rotwein(alkoholgehalt, rotweingut);
        assertEquals(rotwein.getAlkoholgehalt(), alkoholgehalt);
        assertEquals(rotwein.getWeingut(), rotweingut);
    }

    @Test
    public void testKonstruktorMitNegAlkgehalt_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Rotwein rotwein = new Rotwein(-1.0f, "Château Latour");
            });
    }

    @Test
    public void testKonstruktorMitLeeremString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Rotwein rotwein = new Rotwein(12.0f, "");
            });
    }

    @Test
    public void testKonstruktorMitNullString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Rotwein rotwein = new Rotwein(9.5f, null);
            });
    }

    //______________SETTER___________________________________
    @Test
    public void testSetRotweingut_erwartetRichtigGesetzt() 
    {
        String weingut = "Château Latour";
        Rotwein rotwein = new Rotwein();
        rotwein.setWeingut(weingut);
        assertEquals(rotwein.getWeingut(), weingut);
    }

    @Test
    public void testSetRotweingutMitNull_erwartetException() 
    {
        Rotwein rotwein = new Rotwein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    rotwein.setWeingut(null);
            });
    }

    @Test
    public void testSetRotweingutMitLeeremString_erwartetException() 
    {
        Rotwein rotwein = new Rotwein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    rotwein.setWeingut("");
            });
    }

    @Test
    public void testSetAlkoholgehaltMitNegativemWert_erwartetException() 
    {
        Rotwein rotwein = new Rotwein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    rotwein.setAlkoholgehalt(-1.0f);
            });
    }

    @Test
    public void testSetAlkoholgehaltMit0Komma0_erwartetException() 
    {
        Rotwein rotwein = new Rotwein();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    rotwein.setAlkoholgehalt(0.0f);
            });
    }

    //______________EQUALS_____________________________________
    @Test
    public void testEqualsMitIdentischenObjekten_erwartetTrue() 
    {
        Rotwein rotwein1 = new Rotwein(7.5f, "Anselmann");
        Rotwein rotwein2 = rotwein1;
        assertEquals(rotwein1, rotwein2);
    }

    @Test
    public void testEqualsMitUngleichenObjekten_erwartetFalse() 
    {
        Rotwein rotwein1 = new Rotwein(7.5f, "Anselmann");
        Rotwein rotwein2 = new Rotwein(7.5f, "Schloss Proschwitz Prinz zur Lippe");
        Assertions.assertNotEquals(rotwein1, rotwein2);
    }

    @Test
    public void testEqualsMitGleichenObjekten_erwartetFalse() 
    {
        Rotwein rotwein1 = new Rotwein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        Rotwein rotwein2 = new Rotwein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        Assertions.assertNotEquals(rotwein1, rotwein2);
    }

    //______________TO_STRING______________________________
    @Test
    public void testRotweinToString() 
    {
        Rotwein rotwein = new Rotwein(8.0f, "Schloss Proschwitz Prinz zur Lippe");
        assertEquals("Getraenk 8.0 % Vol. vom Weingut Schloss Proschwitz Prinz zur Lippe, rot", rotwein.toString());
    }

}