

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Eine Klasse zum Testen der Artikel-Klasse.
 *
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class ArtikelTest
{
    private static final double EPSILON = 0.0000000001;

    //_________________Korrekte-Fälle______________________________
    

    //_________________Konstruktoren_______________________________
    
    //_________________Vollkonstruktor_____________________________
    
    @Test
    public void testKonstruktorVoll_erwarte_erfolgreiche_erzeugung_eines_artikels() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        assertEquals(1234, artikel.getArtikelNr());
        assertEquals("Artikel", artikel.getArt());
        assertEquals(10, artikel.getBestand());
        assertEquals(199.99, artikel.getPreis(), EPSILON);
    }

    
    //_________________Teilkonstruktor_____________________________
    
    @Test
    public void testKonstruktorTeil_erwarte_erfolgreiche_erzeugung_eines_artikels() 
    {
        Artikel artikel = new Artikel(5678, "Artikel", 999.99);
        assertEquals(5678, artikel.getArtikelNr());
        assertEquals("Artikel", artikel.getArt());
        assertEquals(0, artikel.getBestand());
        assertEquals(999.99, artikel.getPreis(), EPSILON);
    }

    
    //_________________Zugang buchen_____________________________
    
    @Test
    public void testBucheZugang_erwarte_erfolgreichen_zugang() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        artikel.bucheZugang(5);
        assertEquals(15, artikel.getBestand());
    }
    
    
    //_________________Abgang buchen_____________________________
    
    @Test
    public void testBucheAbgang_erwarte_erfolgreichen_abgang() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        artikel.bucheAbgang(5);
        assertEquals(5, artikel.getBestand());
    }
    
    
    //________________________toString-Methode_____________________
    
    @Test
    public void testToString_erwarte_string_repraesentation_von_artikel_objekt() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        String expected = "Artikel{Artikel: 1234, Art: Artikel, Bestand: 10, Preis: 199.99}";
        assertEquals(expected, artikel.toString());
    }
    
    
    //_________________Fehler-Fälle________________________________
    
    
    //_________________Zugang buchen_____________________________
    
    @Test
    public void testBucheZugang_negativ_erwarte_exception() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        assertThrows(IllegalArgumentException.class, () 
        -> artikel.bucheZugang(-5));
    }
    
    
    //_________________Abgang buchen_____________________________
    
    @Test
    public void testBucheAbgang_zu_hoch_erwarte_exception() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        assertThrows(IllegalArgumentException.class, () 
        -> artikel.bucheAbgang(15));
    }
    
    
    //_________________Negativer Preis____________________________
    
    @Test
    public void testSetPreis_negativ_erwarte_exception() 
    {
        Artikel artikel = new Artikel(1234, "Artikel", 10, 199.99);
        assertThrows(IllegalArgumentException.class, () 
        -> artikel.setPreis(-199.99));
    }
}
