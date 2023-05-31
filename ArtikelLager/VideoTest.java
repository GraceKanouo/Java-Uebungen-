import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Eine Klasse zum Testen der Video-Klasse.
 *
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class VideoTest
{
    //_________________Korrekte-Fälle______________________________

    //_________________SetJahr________________________________

    @Test
    public void testSetJahr_erwarte_interpret_wird_ausgegeben() 
    {
        Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
        video.setJahr(2010);
        assertEquals(2010, video.getJahr());
    }

    
    //_________________SetTitel___________________________________
    
    @Test
    public void testSetTitel_erwarte_titel_wird_ausgegeben() 
    {
        Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
        video.setTitel("New Title");
        assertEquals("New Title", video.getTitel());
    }

    
    //_________________SetSpieldauer_______________________________
    
    @Test
    public void testSetSpieldauer_erwarte_spieldauer_wird_ausgegeben() 
    {
        Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
        video.setSpieldauer(120.0);
        assertEquals(120.0, video.getSpieldauer(), 0.001);
    }

    
    //_________________GetBeschreibung______________________________
    
    @Test
    public void testGetBeschreibung_erwarte_beschreibung_wird_ausgegeben() 
    {
        Video video = new Video(1234, 1, 1.0, "Test Video", 2020, 120.0);
        assertEquals("Video: Test Video", video.getBeschreibung());
    }

    //_________________equals-Methode (true)__________________________
    
    @Test
    public void testEquals_gleiche_Attribute_erwartet_true() 
    {
        Video video1 = new Video(1234, 1, 1.0, "Test", 2000, 1.0);
        Video video2 = new Video(2345, 1, 1.0, "Test", 2000, 1.0);
        assertTrue(video1.equals(video2));
    }
    
    
    //_________________equals-Methode (false)_________________________
    
    @Test
    public void testEquals_verschiedene_Attribute_erwartet_false() 
    {
        Video video1 = new Video(1234, 1, 1.0, "Test", 2000, 1.0);
        Video video2 = new Video(2345, 1, 1.0, "Test 2", 2001, 2.0);
        assertFalse(video1.equals(video2));
    }
    
    
    //_________________Fehler-Fälle___________________________________
    
    //__________fehlerhafte Eingabe beim Jahr (zu niedrig)____________
    
    @Test
    public void testSetJahr_mit_1899_erwarte_exception()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
                    video.setJahr(1899);
              });
    }

    
    //__________fehlerhafte Eingabe beim Jahr (zu hoch)_______________
    
    @Test
    public void testSetJahr_mit_2023_erwarte_exception()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
                    video.setJahr(2023);
              });
    }
    
    
    //________________Albumtitel fehlt________________________________
    
    @Test
    public void testSetTitel_albumtitel_fehlt_erwarte_exception() 
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
                    video.setTitel("");
              });
    }

    
    //________________Spieldauer fehlt_______________________________
    
    @Test
    public void testSetSpieldauer_keine_spieldauer_erwarte_exception()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
                    video.setSpieldauer(0.0);
              });
    }

    @Test
    public void testSetJahr_tooHighInput_shouldThrowException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () 
            ->{ 
                    Video video = new Video(1234, 1, 1.0, "TestVideo", 2000, 1.0);
                    video.setJahr(2023);
              });
    }
}