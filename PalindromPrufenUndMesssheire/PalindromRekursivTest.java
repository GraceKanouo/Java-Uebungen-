import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Die Test-Klasse PalindromRekursivTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PalindromRekursivTest
{
    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Kleinbuchstaben_lagerregal() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("lagerregal");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Kleinbuchstaben_radar() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("radar");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Großbuchstaben_RADAR() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("RADAR");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindrom_nur_Kleinbuchstaben_und_einfachem_BS_in_Mitte_kajak() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("kajak");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindrom_Gross_und_Kleinbuchstaben_und_einfachem_BS_in_Mitte_Uhu() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("Uhu");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindrom_Gross_und_Kleinbuchstaben_und_doppeltem_BS_in_Mitte_Ebbe() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("Ebbe");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_leerem_Wort() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindom_und_Leerzeichen_in_Mitte() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("ra dar");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindom_und_Leerzeichen_am_Anfang() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom(" radar");
        assertEquals(true, istPalindrom);
    }
    
    @Test
    public void testIstPalindrom_mit_Palindom_und_Leerzeichen_am_Ende() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("radar ");
        assertEquals(true, istPalindrom);
    }

    @Test
    public void testIstPalindrom_mit_Palindromsatz() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        String satz = "Eine Horde bedrohe nie";
        boolean istPalindrom = palindrom.istPalindrom(satz);
        assertEquals(true, istPalindrom);
    }
    
    
    
    @Test
    public void testIstPalindrom_mit_nicht_Palindrom() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        boolean istPalindrom = palindrom.istPalindrom("hallo");
        assertEquals(false, istPalindrom);
    }
    
    

    @Test
    public void testIstPalindrom_mit_null_sollte_exception_werfen() 
    {
        PalindromRekursiv palindrom = new PalindromRekursiv();
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
                {
                    palindrom.istPalindrom(null);
            });
    }
}
