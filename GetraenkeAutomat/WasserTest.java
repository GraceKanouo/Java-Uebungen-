import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Die Test-Klasse WasserTest.
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 07.05.23
 */
public class WasserTest
{
    //______________KONSTRUKTOR______________________________

    @Test
    public void testKonstruktorMitParametern_erwartetRichtigGesetzt() 
    {
        String quelle = "Chaîne des Puys - Limagne";
        String hersteller = "Volvic";
        Wasser wasser = new Wasser(hersteller, quelle);

        assertEquals(wasser.getHersteller(), hersteller);
        assertEquals(wasser.getQuelle(), quelle);
    }

    
    @Test
    public void testKonstruktorMitNullQuelle_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wasser wasser = new Wasser("Volvic", null);
            });
    }
    
    @Test
    public void testKonstruktorMitLeererQuelle_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wasser wasser = new Wasser("Volvic", "");
            });
    }

    
    @Test
    public void testKonstruktorMitLeeremString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wasser wasser = new Wasser("", "Chaîne des Puys - Limagne");
            });
    }

    @Test
    public void testKonstruktorMitNullString_erwartetException() 
    {
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    Wasser wasser = new Wasser(null, "Chaîne des Puys - Limagne");
            });
    }

    
    
    //______________SETTER___________________________________
    
    @Test
    public void testSetHersteller_erwartetRichtigGesetzt() 
    {
        String hersteller = "Volvic";
        Wasser wasser = new Wasser();
        wasser.setHersteller(hersteller);
        assertEquals(wasser.getHersteller(), hersteller);
    }

    
    @Test
    public void testSetHerstellerMitNull_erwartetException() 
    {
        Wasser wasser = new Wasser();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wasser.setHersteller(null);
            });
    }

    @Test
    public void testSetHerstellerMitLeeremString_erwartetException() 
    {
        Wasser wasser = new Wasser();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wasser.setHersteller("");
            });
    }

    
    @Test
    public void testSetQuelleMitNull_erwartetException() 
    {
        Wasser wasser = new Wasser();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wasser.setQuelle(null);
            });
    }
    
    @Test
    public void testSetQuelleMitLeeremString_erwartetException() 
    {
        Wasser wasser = new Wasser();
        Assertions.assertThrows(GetraenkException.class, () 
            -> {
                    wasser.setQuelle("");
            });
    }


    
    //______________EQUALS_____________________________________
    
    @Test
    public void testEqualsMitIdentischenObjekten_erwartetTrue() 
    {
        Wasser wasser1 = new Wasser("Volvic", "Chaîne des Puys - Limagne");
        Wasser wasser2 = wasser1;
        assertEquals(wasser1, wasser2);
    }

    
    @Test
    public void testEqualsMitUngleichenObjekten_erwartetFalse() 
    {
        Wasser wasser1 = new Wasser("Hochwald", "Steinau-Quelle");
        Wasser wasser2 = new Wasser("Volvic", "Chaîne des Puys - Limagne");
        Assertions.assertNotEquals(wasser1, wasser2);
    }

    @Test
    public void testEqualsMitGleichenObjekten_erwartetFalse() 
    {
        Wasser wasser1 = new Wasser("Volvic", "Chaîne des Puys - Limagne");
        Wasser wasser2 = new Wasser("Volvic", "Chaîne des Puys - Limagne");
        Assertions.assertNotEquals(wasser1, wasser2);
    }

    
    
    //______________TO_STRING______________________________
    
    @Test
    public void testWasserToString() 
    {
        Wasser wasser = new Wasser("Volvic", "Chaîne des Puys - Limagne");
        assertEquals("Getraenk Volvic, alkoholfrei, Quelle: Chaîne des Puys - Limagne", wasser.toString());
    }
}
