import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Eine Klasse zum Testen der Buch-Klasse.
 *
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class BuchTest
{
    //_________________Korrekte-Fälle______________________________

    
    //_________________GetAutor________________________________

    @Test
    public void testGetAutor_erwarte_autor_wird_ausgegeben() 
    {
        Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
        assertEquals("Autor", buch.getAutor());
    }

    
    //_________________GetTitel___________________________________
    
    @Test
    public void testGetTitel_erwarte_titel_wird_ausgegeben() 
    {
        Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
        assertEquals("Titel", buch.getTitel());
    }

    
    //_________________GetVerlag______________________________
    
    @Test
    public void testGetVerlag_erwarte_verlag_wird_ausgegeben() 
    {
        Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
        assertEquals("Verlag", buch.getVerlag());
    }

    
    //_________________GetBeschreibung______________________________
    
    @Test
    public void testGetBeschreibung_erwarte_beschreibung_wird_ausgegeben() 
    {
        Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
        assertEquals("Buch: Autor: Titel", buch.getBeschreibung());
    }

    
    //_________________equals-Methode (true)__________________________
    
    @Test
    public void testEquals_gleiche_Attribute_erwartet_true() 
    {
        Buch buch1 = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
        Buch buch2 = new Buch(2345, 5, 20.0, "Titel", "Autor", "Verlag");
        assertTrue(buch1.equals(buch2));
    }

    
    //_________________equals-Methode (false)_________________________
    
    @Test
    public void testEquals_verschiedene_Attribute_erwartet_false() 
    {
        Buch buch1 = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
        Buch buch2 = new Buch(2345, 5, 20.0, "Titel 2", "Autor", "Verlag");
        assertFalse(buch1.equals(buch2));
    }

    
    //_________________Fehler-Fälle___________________________________
    
    //_________________Autor fehlt____________________________________
    
    @Test
    public void testSetAutor_autor_fehlt_erwarte_exception()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
                    buch.setAutor("");
            });
    }

    
    //________________Buchtitel fehlt__________________________________

    @Test
    public void testSetTitel_buchtitel_fehlt_erwarte_exception() 
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
                    buch.setTitel("");
            });
    }

    
    //________________Verlag fehlt_______________________________
    
    @Test
    public void testSetVerlag_verlag_fehlt_erwarte_exception() 
    {

        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Buch buch = new Buch(1234, 5, 20.0, "Titel", "Autor", "Verlag");
                    buch.setVerlag("");
            });
    }
}