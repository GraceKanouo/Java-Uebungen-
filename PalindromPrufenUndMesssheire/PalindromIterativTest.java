import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Die Test-Klasse PalindromIterativTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PalindromIterativTest
{
    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Kleinbuchstaben_lagerregal() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("lagerregal");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Kleinbuchstaben_radar() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("radar");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Großbuchstaben_RADAR() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("RADAR");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Kleinbuchstaben_und_einfachem_BS_in_Mitte_kajak() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("kajak");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindrom_Gross_und_Kleinbuchstaben_und_einfachem_BS_in_Mitte_Uhu() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("Uhu");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindrom_Gross_und_Kleinbuchstaben_und_doppeltem_BS_in_Mitte_Ebbe() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("Ebbe");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_leerem_Wort() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindom_und_Leerzeichen_in_Mitte() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("ra dar");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindom_und_Leerzeichen_am_Anfang() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom(" radar");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindom_und_Leerzeichen_am_Ende() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("radar ");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindromsatz() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        String satz = "Eine Horde bedrohe nie";
        boolean istPalindrom = palindrom.istPalindrom(satz);
        assertEquals(true, istPalindrom);
    }
    
    
    
     @Test
    public void testIstPalindrom_mit_nicht_Palindrom() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        boolean istPalindrom = palindrom.istPalindrom("hallo");
        assertEquals(false, istPalindrom);
    }
    
    

    @Test
    public void testIstPalindrom_mit_null_sollte_exception_werfen() 
    {
        PalindromIterativ palindrom = new PalindromIterativ();
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            {
                    palindrom.istPalindrom(null);
            });
    }
}
