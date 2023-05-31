import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Lager.
 * 
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class Lager
{
    //________________________Konstanten____________________________________

    public static final int    MAX_ANZAHL  = 10;
    public static final double PROZENTWERT = 100.0;

    
    //________________________Exceptions____________________________________
    
    private static final String UNGUELTIGE_LAGERGROESSE = 
        "Das Lager muss mindestens einen Artikel aufnehmen koennen.";

    private static final String LAGER_VOLL = 
        "Das Lager ist bereits komplett belegt.";

    private static final String ARTIKEL_EXISTIERT_NICHT = 
        "Kein Artikel im Lager vorhanden.";

    private static final String ARTIKEL_EXISTIERT_BEREITS = 
        "Der Artikel befindet sich bereits im Lager.";

    private static final String ZUGANGSWERT_ZU_NIEDRIG = 
        "Es wurde kein Zugang gebucht.";

    private static final String ABGANGSWERT_ZU_HOCH = 
        "Der Abgangswert darf den Bestand nicht überschreiten.";

    private static final String NEGATIVER_PREIS = 
        "Der Preis darf nicht kleiner als 0 oder 0 sein.";

    private static final String UNGUELTIGER_INDEX = 
        "Der Index darf nicht kleiner 0 oder groesser" +
        MAX_ANZAHL + " sein";

        
    //________________________Attribute____________________________________

    private Artikel[] lager;
    private int       artikelAnzahl;
    private int       lagerGroesse;
    

    //______________________Konstruktoren__________________________________
    
    /**
     * Konstruktor, der die Maximalgroesse 10 fuer Artikelarrays angibt
     * @param groesse 10
     */
    public Lager()
    {
        this(MAX_ANZAHL);
    }

    /** 
     * Konstruktor
     * 
     * @param lagerGroesse Dimension des zu erzeugenden Artikel-arrays
     * 
     * @throws Exception wird geworfen, wenn die lagerGroesse kleiner/
     *         gleich 0 oder groesser als die MAX_ANZAHL ist.
     */

    public Lager(int lagerGroesse)
    {
        if (lagerGroesse <= 0)
        {
            throw new IllegalArgumentException(UNGUELTIGE_LAGERGROESSE);
        }
        lager = new Artikel[lagerGroesse];
        artikelAnzahl = -1;

        for(int i = 0; i < lagerGroesse; i++)
        {
            lager[i] = null;
        }
    }

    
    //________________________Methoden_____________________________

    //_________________Artikel anlegen_____________________________

    /**
     * 
     */
    public void legeAnArtikel(Artikel artikel)
    {
        if(artikelAnzahl >= lager.length -1)
        {
            throw new IllegalArgumentException(LAGER_VOLL);
        }
        else if(artikelNrVorhanden(artikel.getArtikelNr()) == true)
        {
            throw new IllegalArgumentException(ARTIKEL_EXISTIERT_BEREITS);
        }
        
        lager[++artikelAnzahl] = artikel;
    }

    
    //_____________________Artikel entfernen_________________________________
    
    /**
     * 
     */
    public void entferneArtikel(int artikelNr)
    {
        if(artikelNrVorhanden(artikelNr) == false)
        {
            throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }

        int anzahlAufzurueckenderPlaetze;
        // sucht nach Artikel
        int indexVonArtikel = sucheArtikel(artikelNr);

        // löscht Artikel
        lager[indexVonArtikel] = null;
        artikelAnzahl--;

        // verschiebt die Indexe der Artikel, um etwaige Lücken zu schließen
        for(anzahlAufzurueckenderPlaetze = indexVonArtikel; anzahlAufzurueckenderPlaetze 
        <= artikelAnzahl; anzahlAufzurueckenderPlaetze++)
        {
            lager[anzahlAufzurueckenderPlaetze] = lager[anzahlAufzurueckenderPlaetze + 1];
        }

        if(anzahlAufzurueckenderPlaetze + 1 < lager.length)
        {
            lager[anzahlAufzurueckenderPlaetze + 1] = null;
        }
    }

    
    //_____________________Zugang buchen_________________________________
    
    /**
     * 
     */
    public void bucheZugang(int artikelNr, int zugang)
    { 
        if(artikelNrVorhanden(artikelNr) == false)
        {
            throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }

        if(zugang <= 0)
        {
            throw new IllegalArgumentException(ZUGANGSWERT_ZU_NIEDRIG);
        }

        int indexVonArtikel = sucheArtikel(artikelNr);
        Artikel artikel = lager[indexVonArtikel];
        artikel.bucheZugang(zugang);
        lager[indexVonArtikel] = artikel;
    }

    
    //_____________________Abgang buchen_________________________________
    
    /**
     * 
     */
    void bucheAbgang(int artikelNr, int abgang)
    {
        if(abgang > lagerGroesse)
        {
            throw new IllegalArgumentException(ABGANGSWERT_ZU_HOCH);
        }

        int indexVonArtikel = sucheArtikel(artikelNr);
        Artikel artikel = lager[indexVonArtikel];
        artikel.bucheAbgang(abgang);
        lager[indexVonArtikel] = artikel;
    }

    
    //______________Preis eines Artikels aendern________________________
    
    /**
     * 
     */
    void aenderePreisEinesArtikels(int artikelNr, double prozent)
    {
        if(artikelNrVorhanden(artikelNr) == false)
        {
            throw new IllegalArgumentException(ARTIKEL_EXISTIERT_NICHT);
        }
        else if ( prozent < - PROZENTWERT)
        {
            throw new IllegalArgumentException(NEGATIVER_PREIS);
        }
        
        int indexVonArtikel = sucheArtikel(artikelNr);
        lager[indexVonArtikel].aenderePreis(prozent);
    }

    
    //_______________Preis aller Artikels aendern________________________
    
    /**
     * 
     */
    void aenderePreisAllerArtikel(double prozent)
    {
        int lagerGroesse = sucheArtikel(artikelAnzahl);
        lager[lagerGroesse].aenderePreis(prozent);
    }

    
    //________________________Hilfsmethoden______________________________
    
    //_____________Pruefung, ob Artikelnr schon vergeben ist_____________
    
    /**
     * 
     */
    public boolean artikelNrVorhanden(int artikelNr)
    {
        for(int i = 0; i < artikelAnzahl; i++)
        {
            Artikel artikel = lager[i];
            if(artikel.getArtikelNr() == artikelNr)
            {
                return true;
            }
        }
        return false;
    }

    
    //______________Artikel anhand von Artikelnr. finden_________________
    
    /**
     * 
     */
    private int sucheArtikel(int artikelNr)
    {
        for(int i = 0; i <= artikelAnzahl; i++)
        {
            if(lager[i].getArtikelNr() == artikelNr)
            {
                return i;
            }
        }
        return -1;
    }


    //_____________________Index von Artikel finden______________________
    
    /**
     * 
     */
    Artikel getArtikel(int index)
    {
        if(index >= getLagerGroesse() || index < 0)
        {
            throw new IllegalArgumentException(UNGUELTIGER_INDEX);
        }
        return lager[index];
    }

    
    //____________________Bestandsliste ausgeben____________________

    /**
     * 
     */
    public String ausgebenBestandsListe() 
    {
        String liste ="---";
        for (Artikel artikel : lager) 
        {
            for (int i =0; i < lager.length; i++)
            {
                if(artikel != null)
                {
                    int first= artikel.getArtikelNr();
                    String beschreibung = artikel.getBeschreibung();
                    double preisA = artikel.getPreis();
                    int bestandA = artikel.getBestand();
                    double gesamt = preisA * bestandA;
                    liste = first + "/t" + beschreibung + "/t" + preisA + "/t" + bestandA + "/t" + gesamt + "/t" ;
                }
            }
        }
        return liste + 1;
    }
    
    
    //________________________toString-Methode______________________________
    
    /**
     * 
     */
    public String toString()
    {
        String lagerDaten = new String ("Im Lager sind von " + lager.length + 
                                        " Lagerplaetzen " + (artikelAnzahl + 1) +
                                        " belegt. " +
                                        "\nFolgende Artikel befinden sich im Lager:\n");

        for (int i = 0; i <= artikelAnzahl; i++)
        {
            lagerDaten +=  "\n\t " + i + "\t-> " + lager[i];
        }
        
        return lagerDaten;
    }

    
    //______________________________Getter_________________________________
    
    public int getArtikelAnzahl()
    {
        return artikelAnzahl + 1;
    }

    public int getLagerGroesse()
    {
        return lager.length;
    }
}
