import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlascheTest 
{
    //___________________IST_GEFUELLT____________________
    @Test
    public void testIstGefuellt_leere_Flasche() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());
    }
    
    
    //___________________LEEREN_______________________
    @Test
    public void testLeerenWennBereitsLeer() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, ()
            ->{
                    flasche.leeren();
            });
    }
    
    
    
    
    //___________________BIER__________________________

    //___________________FUELLEN_______________________
    @Test
    void testFuellen_mit_gueltigen_Werten_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Bier bier = new Bier();
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(bier);
        assertTrue(flasche.istGefuellt());
        assertEquals(flasche.getInhalt(), bier);
    }

    @Test
    void testFuellenMitFehler_erwartet_Exception_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Bier bier1 = new Bier();
        Bier bier2 = new Bier();
        flasche.fuellen(bier1);
        assertTrue(flasche.istGefuellt());
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.fuellen(bier2);
            });
    }
    


    //___________________LEEREN_______________________
    @Test
    void testLeeren_mit_gueltigen_Werten_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Bier bier = new Bier();
        flasche.fuellen(bier);
        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());
    }

    @Test
    void testLeerenMitFehler_erwartet_Exception_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, ()
            -> {
                    flasche.leeren();
            });

        // Flasche füllen    
        Bier bier = new Bier();
        flasche.fuellen(bier);
        // Prüfen, ob Flasche gefüllt ist
        assertTrue(flasche.istGefuellt());
        // Flasche leeren
        flasche.leeren();
        // Prüfen, ob Flasche leer ist
        assertFalse(flasche.istGefuellt());
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.leeren();
            });
    }


    //___________________IST_GEFUELLT____________________
    @Test
    void testIstGefuellt__true_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();

        Bier bier = new Bier();
        flasche.fuellen(bier);
        assertTrue(flasche.istGefuellt());
    }

    @Test
    void testIstGefuellt_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());

        Bier bier = new Bier();
        flasche.fuellen(bier);
        assertTrue(flasche.istGefuellt());

        flasche.leeren();
        assertFalse(flasche.istGefuellt());
    }

    //___________________TO_STRING_______________________
    @Test
    void testToString_Bier() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, () -> flasche.toString());
        Bier bier = new Bier();
        flasche.fuellen(bier);
        assertEquals(flasche.toString(), "Die Flasche enthaelt " + bier.toString());
    }

    //___________________EQUALS_______________________
    @Test
    void testEquals_Bier() 
    {
        Flasche<Getraenk> flasche1 = new Flasche<>();
        Flasche<Getraenk> flasche2 = new Flasche<>();
        assertTrue(flasche1.equals(flasche2));
        Bier bier = new Bier();
        flasche1.fuellen(bier);
        assertFalse(flasche1.equals(flasche2));
        flasche2.fuellen(bier);
        assertTrue(flasche1.equals(flasche2));
    }
    
    
    
    //___________________WEIN__________________________

    //___________________FUELLEN_______________________
    @Test
    void testFuellen_mit_gueltigen_Werten_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Wein wein = new Wein();
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(wein);
        assertTrue(flasche.istGefuellt());
        assertEquals(flasche.getInhalt(), wein);
    }

    @Test
    void testFuellenMitFehler_erwartet_Exception_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Wein wein1 = new Wein();
        Wein wein2 = new Wein();
        flasche.fuellen(wein1);
        assertTrue(flasche.istGefuellt());
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.fuellen(wein2);
            });
    }


    //___________________LEEREN_______________________
    @Test
    void testLeeren_mit_gueltigen_Werten_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Wein wein = new Wein();
        flasche.fuellen(wein);
        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());
    }

    @Test
    void testLeerenMitFehler_erwartet_Exception_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, ()
            -> {
                    flasche.leeren();
            });

        // Flasche füllen    
        Wein wein = new Wein();
        flasche.fuellen(wein);
        // Prüfen, ob Flasche gefüllt ist
        assertTrue(flasche.istGefuellt());
        // Flasche leeren
        flasche.leeren();
        // Prüfen, ob Flasche leer ist
        assertFalse(flasche.istGefuellt());
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.leeren();
            });
    }


    //___________________IST_GEFUELLT____________________
    @Test
    void testIstGefuellt__true_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();

        Wein wein = new Wein();
        flasche.fuellen(wein);
        assertTrue(flasche.istGefuellt());
    }

    @Test
    void testIstGefuellt_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());

        Wein wein = new Wein();
        flasche.fuellen(wein);
        assertTrue(flasche.istGefuellt());

        flasche.leeren();
        assertFalse(flasche.istGefuellt());
    }

    //___________________TO_STRING_______________________
    @Test
    void testToString_Wein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, () -> flasche.toString());
        Wein wein = new Wein();
        flasche.fuellen(wein);
        assertEquals(flasche.toString(), "Die Flasche enthaelt " + wein.toString());
    }

    //___________________EQUALS_______________________
    @Test
    void testEquals_Wein() 
    {
        Flasche<Getraenk> flasche1 = new Flasche<>();
        Flasche<Getraenk> flasche2 = new Flasche<>();
        assertTrue(flasche1.equals(flasche2));
        Wein wein = new Wein();
        flasche1.fuellen(wein);
        assertFalse(flasche1.equals(flasche2));
        flasche2.fuellen(wein);
        assertTrue(flasche1.equals(flasche2));
    }
    
    
    
    //___________________ROTWEIN__________________________

    //___________________FUELLEN_______________________
    @Test
    void testFuellen_mit_gueltigen_Werten_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Rotwein rotwein = new Rotwein();
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(rotwein);
        assertTrue(flasche.istGefuellt());
        assertEquals(flasche.getInhalt(), rotwein);
    }

    @Test
    void testFuellenMitFehler_erwartet_Exception_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Rotwein rotwein1 = new Rotwein();
        Rotwein rotwein2 = new Rotwein();
        flasche.fuellen(rotwein1);
        assertTrue(flasche.istGefuellt());
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.fuellen(rotwein2);
            });
    }
    


    //___________________LEEREN_______________________
    @Test
    void testLeeren_mit_gueltigen_Werten_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Rotwein rotwein = new Rotwein();
        flasche.fuellen(rotwein);
        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());
    }

    @Test
    void testLeerenMitFehler_erwartet_Exception_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, ()
            -> {
                    flasche.leeren();
            });

        // Flasche füllen    
        Rotwein rotwein = new Rotwein();
        flasche.fuellen(rotwein);
        // Prüfen, ob Flasche gefüllt ist
        assertTrue(flasche.istGefuellt());
        // Flasche leeren
        flasche.leeren();
        // Prüfen, ob Flasche leer ist
        assertFalse(flasche.istGefuellt());
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.leeren();
            });
    }

    //___________________IST_GEFUELLT____________________
    @Test
    void testIstGefuellt__true_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();

        Rotwein rotwein = new Rotwein();
        flasche.fuellen(rotwein);
        assertTrue(flasche.istGefuellt());
    }

    @Test
    void testIstGefuellt_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());

        Rotwein rotwein = new Rotwein();
        flasche.fuellen(rotwein);
        assertTrue(flasche.istGefuellt());

        flasche.leeren();
        assertFalse(flasche.istGefuellt());
    }

    //___________________TO_STRING_______________________
    @Test
    void testToString_Rotwein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, () -> flasche.toString());
        Rotwein rotwein = new Rotwein();
        flasche.fuellen(rotwein);
        assertEquals(flasche.toString(), "Die Flasche enthaelt " + rotwein.toString());
    }

    //___________________EQUALS_______________________
    @Test
    void testEquals_Rotwein() 
    {
        Flasche<Getraenk> flasche1 = new Flasche<>();
        Flasche<Getraenk> flasche2 = new Flasche<>();
        assertTrue(flasche1.equals(flasche2));
        Rotwein rotwein = new Rotwein();
        flasche1.fuellen(rotwein);
        assertFalse(flasche1.equals(flasche2));
        flasche2.fuellen(rotwein);
        assertTrue(flasche1.equals(flasche2));
    }
    
    
    //___________________WEISSWEIN__________________________

    //___________________FUELLEN_______________________
    @Test
    void testFuellen_mit_gueltigen_Werten_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Weisswein weisswein = new Weisswein();
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(weisswein);
        assertTrue(flasche.istGefuellt());
        assertEquals(flasche.getInhalt(), weisswein);
    }

    @Test
    void testFuellenMitFehler_erwartet_Exception_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Weisswein weisswein1 = new Weisswein();
        Weisswein weisswein2 = new Weisswein();
        flasche.fuellen(weisswein1);
        assertTrue(flasche.istGefuellt());
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.fuellen(weisswein2);
            });
    }
    


    //___________________LEEREN_______________________
    @Test
    void testLeeren_mit_gueltigen_Werten_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Weisswein weisswein = new Weisswein();
        flasche.fuellen(weisswein);
        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());
    }

    @Test
    void testLeerenMitFehler_erwartet_Exception_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, ()
            -> {
                    flasche.leeren();
            });

        // Flasche füllen    
        Weisswein weisswein = new Weisswein();
        flasche.fuellen(weisswein);
        // Prüfen, ob Flasche gefüllt ist
        assertTrue(flasche.istGefuellt());
        // Flasche leeren
        flasche.leeren();
        // Prüfen, ob Flasche leer ist
        assertFalse(flasche.istGefuellt());
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.leeren();
            });
    }

    //___________________IST_GEFUELLT____________________
    @Test
    void testIstGefuellt__true_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();

        Weisswein weisswein = new Weisswein();
        flasche.fuellen(weisswein);
        assertTrue(flasche.istGefuellt());
    }

    @Test
    void testIstGefuellt_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());

        Weisswein weisswein = new Weisswein();
        flasche.fuellen(weisswein);
        assertTrue(flasche.istGefuellt());

        flasche.leeren();
        assertFalse(flasche.istGefuellt());
    }

    //___________________TO_STRING_______________________
    @Test
    void testToString_Weisswein() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, () -> flasche.toString());
        Weisswein weisswein = new Weisswein();
        flasche.fuellen(weisswein);
        assertEquals(flasche.toString(), "Die Flasche enthaelt " + weisswein.toString());
    }

    //___________________EQUALS_______________________
    @Test
    void testEquals_Weisswein() 
    {
        Flasche<Getraenk> flasche1 = new Flasche<>();
        Flasche<Getraenk> flasche2 = new Flasche<>();
        assertTrue(flasche1.equals(flasche2));
        Weisswein weisswein = new Weisswein();
        flasche1.fuellen(weisswein);
        assertFalse(flasche1.equals(flasche2));
        flasche2.fuellen(weisswein);
        assertTrue(flasche1.equals(flasche2));
    }
    
    
    //___________________SOFTDRINK__________________________

    //___________________FUELLEN_______________________
    @Test
    void testFuellen_mit_gueltigen_Werten_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Softdrink softdrink = new Softdrink();
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(softdrink);
        assertTrue(flasche.istGefuellt());
        assertEquals(flasche.getInhalt(), softdrink);
    }

    @Test
    void testFuellenMitFehler_erwartet_Exception_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Softdrink softdrink1 = new Softdrink();
        Softdrink softdrink2 = new Softdrink();
        flasche.fuellen(softdrink1);
        assertTrue(flasche.istGefuellt());
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.fuellen(softdrink2);
            });
    }
    


    //___________________LEEREN_______________________
    @Test
    void testLeeren_mit_gueltigen_Werten_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Softdrink softdrink = new Softdrink();
        flasche.fuellen(softdrink);
        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());
    }

    @Test
    void testLeerenMitFehler_erwartet_Exception_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, ()
            -> {
                    flasche.leeren();
            });

        // Flasche füllen    
        Softdrink softdrink = new Softdrink();
        flasche.fuellen(softdrink);
        // Prüfen, ob Flasche gefüllt ist
        assertTrue(flasche.istGefuellt());
        // Flasche leeren
        flasche.leeren();
        // Prüfen, ob Flasche leer ist
        assertFalse(flasche.istGefuellt());
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.leeren();
            });
    }

    //___________________IST_GEFUELLT____________________
    @Test
    void testIstGefuellt__true_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();

        Softdrink softdrink = new Softdrink();
        flasche.fuellen(softdrink);
        assertTrue(flasche.istGefuellt());
    }

    @Test
    void testIstGefuellt_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());

        Softdrink softdrink = new Softdrink();
        flasche.fuellen(softdrink);
        assertTrue(flasche.istGefuellt());

        flasche.leeren();
        assertFalse(flasche.istGefuellt());
    }

    //___________________TO_STRING_______________________
    @Test
    void testToString_Softdrink() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, () -> flasche.toString());
        Softdrink softdrink = new Softdrink();
        flasche.fuellen(softdrink);
        assertEquals(flasche.toString(), "Die Flasche enthaelt " + softdrink.toString());
    }

    //___________________EQUALS_______________________
    @Test
    void testEquals_Softdrink() 
    {
        Flasche<Getraenk> flasche1 = new Flasche<>();
        Flasche<Getraenk> flasche2 = new Flasche<>();
        assertTrue(flasche1.equals(flasche2));
        Softdrink softdrink = new Softdrink();
        flasche1.fuellen(softdrink);
        assertFalse(flasche1.equals(flasche2));
        flasche2.fuellen(softdrink);
        assertTrue(flasche1.equals(flasche2));
    }
    
    
    
    //___________________WASSER__________________________

    //___________________FUELLEN_______________________
    @Test
    void testFuellen_mit_gueltigen_Werten_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Wasser wasser = new Wasser();
        assertFalse(flasche.istGefuellt());
        flasche.fuellen(wasser);
        assertTrue(flasche.istGefuellt());
        assertEquals(flasche.getInhalt(), wasser);
    }

    @Test
    void testFuellenMitFehler_erwartet_Exception_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Wasser wasser1 = new Wasser();
        Wasser wasser2 = new Wasser();
        flasche.fuellen(wasser1);
        assertTrue(flasche.istGefuellt());
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.fuellen(wasser2);
            });
    }
    


    //___________________LEEREN_______________________
    @Test
    void testLeeren_mit_gueltigen_Werten_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        Wasser wasser = new Wasser();
        flasche.fuellen(wasser);
        assertTrue(flasche.istGefuellt());
        flasche.leeren();
        assertFalse(flasche.istGefuellt());
        assertNull(flasche.getInhalt());
    }

    @Test
    void testLeerenMitFehler_erwartet_Exception_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, ()
            -> {
                    flasche.leeren();
            });

        // Flasche füllen    
        Wasser wasser = new Wasser();
        flasche.fuellen(wasser);
        // Prüfen, ob Flasche gefüllt ist
        assertTrue(flasche.istGefuellt());
        // Flasche leeren
        flasche.leeren();
        // Prüfen, ob Flasche leer ist
        assertFalse(flasche.istGefuellt());
        // leeren() auf leere Flasche anwenden
        assertThrows(FlascheException.class, () 
            -> {
                    flasche.leeren();
            });
    }

    //___________________IST_GEFUELLT____________________
    @Test
    void testIstGefuellt__true_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();

        Wasser wasser = new Wasser();
        flasche.fuellen(wasser);
        assertTrue(flasche.istGefuellt());
    }

    @Test
    void testIstGefuellt_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertFalse(flasche.istGefuellt());

        Wasser wasser = new Wasser();
        flasche.fuellen(wasser);
        assertTrue(flasche.istGefuellt());

        flasche.leeren();
        assertFalse(flasche.istGefuellt());
    }

    //___________________TO_STRING_______________________
    @Test
    void testToString_Wasser() 
    {
        Flasche<Getraenk> flasche = new Flasche<>();
        assertThrows(FlascheException.class, () -> flasche.toString());
        Wasser wasser = new Wasser();
        flasche.fuellen(wasser);
        assertEquals(flasche.toString(), "Die Flasche enthaelt " + wasser.toString());
    }

    //___________________EQUALS_______________________
    @Test
    void testEquals_Wasser() 
    {
        Flasche<Getraenk> flasche1 = new Flasche<>();
        Flasche<Getraenk> flasche2 = new Flasche<>();
        assertTrue(flasche1.equals(flasche2));
        Wasser wasser = new Wasser();
        flasche1.fuellen(wasser);
        assertFalse(flasche1.equals(flasche2));
        flasche2.fuellen(wasser);
        assertTrue(flasche1.equals(flasche2));
    }
}