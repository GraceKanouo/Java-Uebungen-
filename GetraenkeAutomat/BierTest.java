import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Die Test-Klasse BierTest.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 07.05.23
 */
public class BierTest
{
    //______________KONSTRUKTOR______________________________

    @Test
    public void testKonstruktorMitParametern_erwartetRichtigGesetzt() 
    {
        float alkoholgehalt = 5.0f;
        String brauerei = "Karlsberg";
        Bier bier = new Bier(alkoholgehalt, brauerei);
        assertEquals(bier.getAlkoholgehalt(), alkoholgehalt);
        assertEquals(bier.getBrauerei(), brauerei);
    }

    @Test
    public void testKonstruktorMitNegAlkgehalt_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                Bier bier = new Bier(-1.0f, "Karlsberg");
            });
    }
    
    @Test
    public void testKonstruktorMitLeeremString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                Bier bier = new Bier(-1.0f, "");
            });
    }
    
    @Test
    public void testKonstruktorMitNullString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                Bier bier = new Bier(-1.0f, null);
            });
    }
    
    
    //______________SETTER___________________________________
    
    @Test
    public void testSetBrauerei_erwartetRichtigGesetzt() 
    {
        String brauerei = "Karlsberg";
        Bier bier = new Bier();
        bier.setBrauerei(brauerei);
        assertEquals(bier.getBrauerei(), brauerei);
    }

    
    @Test
    public void testSetBrauereiMitNull_erwartetException() 
    {
        Bier bier = new Bier();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    bier.setBrauerei(null);
            });
    }

    @Test
    public void testSetBrauereiMitLeeremString_erwartetException() 
    {
        Bier bier = new Bier();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    bier.setBrauerei("");
            });
    }

    
    @Test
    public void testSetAlkoholgehaltMitNegativemWert_erwartetException() 
    {
        Bier bier = new Bier();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    bier.setAlkoholgehalt(-1.0f);
            });
    }
    
    @Test
    public void testSetAlkoholgehaltMit0Komma0_erwartetException() 
    {
        Bier bier = new Bier();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    bier.setAlkoholgehalt(0.0f);
            });
    }
    
    
    //______________EQUALS_____________________________________
    
    @Test
    public void testEqualsMitIdentischenObjekten_erwartetTrue() 
    {
        Bier bier1 = new Bier(5.0f, "Augustiner");
        Bier bier2 = bier1;
        assertEquals(bier1, bier2);
    }

    
    @Test
    public void testEqualsMitUngleichenObjekten_erwartetFalse() 
    {
        Bier bier1 = new Bier(5.0f, "Augustiner");
        Bier bier2 = new Bier(5.0f, "Karlsberg");
        Assertions.assertNotEquals(bier1, bier2);
    }
    
    @Test
    public void testEqualsMitGleichenObjekten_erwartetFalse() 
    {
        Bier bier1 = new Bier(5.0f, "Karlsberg");
        Bier bier2 = new Bier(5.0f, "Karlsberg");
        Assertions.assertNotEquals(bier1, bier2);
    }

    
    //______________TO_STRING______________________________
    
    @Test
    public void testBierToString() 
    {
        Bier bier = new Bier(4.8f, "Karlsberg");
        assertEquals("Getraenk 4.8 % Vol. gebraut von Karlsberg", bier.toString());
    }
}
