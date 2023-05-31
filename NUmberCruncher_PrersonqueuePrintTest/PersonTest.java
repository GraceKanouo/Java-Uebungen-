import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert.*;
import org.junit.jupiter.api.*;
/**
 * Die Test-Klasse PersonTest, testen die Funktionalitaet 
 * der Methoden aus der Klasse Person.
 *
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */
public class PersonTest
{
    //_______________KONSTRUKTOR_________________________________

    @Test
    public void testeKonstruktor_GueltigerNamen_einfach() 
    {
        Person p = new Person("Emily", "Bronte");
        assertEquals("Emily", p.getVorname());
        assertEquals("Bronte", p.getNachname());
    }

    @Test
    public void testeKonstruktor_GueltigerNamenMitUmlauten() 
    {
        Person p = new Person("Sören", "Jäger");
        assertEquals("Sören", p.getVorname());
        assertEquals("Jäger", p.getNachname());
    }

    @Test
    public void testeKonstruktor_GueltigerNamen_GrossUndKleinbuchstaben() 
    {
        Person p = new Person("VoRnaMe", "nacHnamE");
        assertEquals("VoRnaMe", p.getVorname());
        assertEquals("nacHnamE", p.getNachname());
    }

    
    //_______________MIT_LEERZEICHEN_________________________________

    @Test
    public void testeKonstruktorMitLZ_MehrereVorUndNachnamen() 
    {
        Person p = new Person("Heinrich Friedrich Karl", "vom und zum Stein");
        assertEquals("Heinrich Friedrich Karl", p.getVorname());
        assertEquals("vom und zum Stein", p.getNachname());
    }

    @Test
    public void testeKonstruktorMitLZ_MehrereVornamen() 
    {
        Person p = new Person("Edward Louis", "Vedder");
        assertEquals("Edward Louis", p.getVorname());
        assertEquals("Vedder", p.getNachname());
    }

    @Test
    public void testeKonstruktorMitLZ_MehrereNachnamen() 
    {
        Person p = new Person("Laura", "Ingalls Wilder");
        assertEquals("Laura", p.getVorname());
        assertEquals("Ingalls Wilder", p.getNachname());
    }

    //_______________MIT_BINDESTRICH_________________________________

    @Test
    public void testeKonstruktorMitBS_MehrereVorUndNachnamen() 
    {
        Person p = new Person("Heinrich Friedrich Karl", "vom und zum Stein");
        assertEquals("Heinrich Friedrich Karl", p.getVorname());
        assertEquals("vom und zum Stein", p.getNachname());
    }

    @Test
    public void testeKonstruktorMitBS_MehrereVornamen() 
    {
        Person p = new Person("Laura-Elizabeth", "Ingalls");
        assertEquals("Laura-Elizabeth", p.getVorname());
        assertEquals("Ingalls", p.getNachname());
    }

    @Test
    public void testeKonstruktorMitBS_MehrereNachnamen() 
    {
        Person p = new Person("Laura", "Ingalls-Wilder");
        assertEquals("Laura", p.getVorname());
        assertEquals("Ingalls-Wilder", p.getNachname());
    }

    //_______________FEHLERFAELLE_________________________________

    @Test
    public void testeKonstruktorMitNullNamen() 
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
                {
                    new Person(null, null);
            });
    }

    @Test
    public void testeKonstruktorMitLeeremNamen()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
                {
                    new Person("", "");
            });
    }

    @Test
    public void testeKonstruktorMitUngueltigemNamen()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
                {
                    new Person("Emily123", "Bronte");
            });
    }

    //_______________SETTER_________________________________

    @Test
    public void testeSetVornameMitGueltigemNamen() 
    {
        Person p = new Person("Laura", "Ingalls");
        p.setVorname("Mary");
        assertEquals("Mary", p.getVorname());
        assertEquals("Ingalls", p.getNachname());
    }

    @Test
    public void testeSetVornameMitLeerzeichenAmEnde() 
    {
        Person p = new Person("Emily", "Bronte");
        assertThrows(IllegalArgumentException.class, () -> p.setVorname("Emily "));
    }

    @Test
    public void testeSetVornameMitLeerzeichenAmAnfang() 
    {
        Person p = new Person("Emily", "Bronte");
        assertThrows(IllegalArgumentException.class, () -> p.setVorname(" Emily"));
    }

    @Test
    public void testeSetVornameMitMehrerenLeerzeichenAmEnde() 
    {
        Person p = new Person("Emily", "Bronte");
        assertThrows(IllegalArgumentException.class, () -> p.setVorname("Emily  "));
    }

    @Test
    public void testeSetVornameMitLeerzeichenAmAnfangUndEnde() 
    {
        Person p = new Person("Emily", "Bronte");
        assertThrows(IllegalArgumentException.class, () -> p.setVorname(" Emily "));
    }

    @Test
    public void testeSetVornameMitBindestrichAmAnfang() 
    {
        Person p = new Person("Emily", "Bronte");
        assertThrows(IllegalArgumentException.class, () -> p.setVorname("-Emily"));
    }

    @Test
    public void testeSetVornameMitBindestrichAmEnde() 
    {
        Person p = new Person("Emily", "Bronte");
        assertThrows(IllegalArgumentException.class, () -> p.setVorname("Emily-"));
    }

    @Test
    public void testeSetNachnameMitGueltigemNamen() 
    {
        Person p = new Person("Laura", "Ingalls");
        p.setNachname("Wilder");
        assertEquals("Laura", p.getVorname());
        assertEquals("Wilder", p.getNachname());
    }

    //________________TO_STRING____________________________

    @Test
    public void testToString() 
    {
        Person p = new Person("Heinrich Friedrich Karl", "Vom und zum Stein");
        assertEquals("Vom und zum Stein, Heinrich Friedrich Karl", p.toString());
    }
}
