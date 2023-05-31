

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Eine Klasse zum Testen der CD-Klasse.
 *
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class CDTest
{
    //_________________Korrekte-Fälle______________________________

    
    //_________________GetInterpret________________________________

    @Test
    public void testGetInterpret_erwarte_interpret_wird_ausgegeben() 
    {
        CD cd = new CD(1234, 10, 20.0, "Interpret", "Album", 10);
        assertEquals("Interpret", cd.getInterpret());
    }

    
    //_________________GetTitel___________________________________
    
    @Test
    public void testGetTitel_erwarte_titel_wird_ausgegeben() 
    {
        CD cd = new CD(1234, 10, 20.0, "Interpret", "Album", 10);
        assertEquals("Album", cd.getTitel());
    }

    
    //_________________GetAnzahlTitel______________________________
    
    @Test
    public void testGetAnzahlTitel_erwarte_titelanzahl_wird_ausgegeben() 
    {
        CD cd = new CD(1234, 10, 20.0, "Interpret", "Album", 10);
        assertEquals(10, cd.getAnzahlTitel());
    }

    
    //_________________GetBeschreibung______________________________
    
    @Test
    public void testGetBeschreibung_erwarte_beschreibung_wird_ausgegeben() 
    {
        CD cd = new CD(1234, 10, 20.0, "Interpret", "Album", 10);
        assertEquals("CD: Interpret: Album", cd.getBeschreibung());
    }

    
    //_________________equals-Methode (true)__________________________
    
    @Test
    public void testEquals_gleiche_Attribute_erwartet_true() 
    {
        CD cd1 = new CD(1234, 10, 20.0, "Interpret", "Album", 10);
        CD cd2 = new CD(2345, 10, 20.0, "Interpret", "Album", 10);
        assertTrue(cd1.equals(cd2));
    }

    
    //_________________equals-Methode (false)_________________________
    
    @Test
    public void testEquals_verschiedene_Attribute_erwartet_false() 
    {
        CD cd1 = new CD(1234, 10, 20.0, "Interpret", "Album", 10);
        CD cd2 = new CD(2345, 10, 20.0, "Interpret 2", "Album", 10);
        assertFalse(cd1.equals(cd2));
    }

    
    //_________________Fehler-Fälle___________________________________
    
    //________________Interpret fehlt_________________________________
    
    @Test
    public void testSetInterpret_interpret_fehlt_erwarte_exception()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{
                    CD cd = new CD(1234, 10, 20.0, "", "Album", 10);
            });
    }

    
    //________________Albumtitel fehlt________________________________
    
    @Test
    public void testSetTitel_albumtitel_fehlt_erwarte_exception() 
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    CD cd = new CD(1234, 10, 20.0, "Interpret", "", 10);
            });
    }

    
    //________________Titelanzahl fehlt_______________________________
    
    @Test
    public void testSetAnzahlTitel_titelanzahl_fehlt_erwarte_exception() 
    {

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    CD cd = new CD(1234, 10, 20.0, "Interpret", "Album", 0);
            });
    }
}