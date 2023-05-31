   
import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Artikel.
 * 
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class Artikel
{
    //________________________Konstanten____________________________________
    
    private static final double EPSILON = 0.0000000001;
    private static final int    MIN_ARTIKEL_NR = 1000;
    private static final int    MAX_ARTIKEL_NR = 9999;
    
    
    //________________________Exceptions____________________________________
    
    private static final String ARTIKELNUMMER_UNGUELITIG = 
            "Die Artikelnummer muss eine vierstellige Zahl zwischen 1000 und 9999 sein.";
            
    private static final String ARTIKELART_FEHLT = 
            "Bitte geben Sie die Art des Artikels an.";
            
    private static final String BESTANDSWERT_UNZULAESSIG = 
            "Der Bestand darf nicht weniger als 0 sein.";
            
    private static final String ZUGANGSWERT_ZU_NIEDRIG = 
            "Es wurde kein Zugang gebucht.";
            
    private static final String ABGANGSWERT_ZU_HOCH = 
            "Der Abgangswert darf den Bestand nicht überschreiten.";
            
    private static final String NEGATIVER_PREIS = 
            "Der Preis darf nicht im negativen Bereich liegen.";
    
    
    //________________________Attribute____________________________________
    
    private int    artikelNr; // Artikelnummer
    private String art;       // Artikelart
    private int    bestand;   // Aktueller Artikelbestand in Stück
    private double preis;     // Preis
   
    
    

    //________________________Konstruktoren____________________________________
    
    /**
     * Der Vollkonstruktor mit 4 Parametern versetzt das Objekt Patient  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * 
     * @param artikelNr Die vierstellige Artikelnummer des Artikels
     * @param art       Die Art des Artikels
     * @param bestand   Die Menge vorhandener Artikel
     * @param preis     Der Preis des Artikels
     */
    public Artikel(int artikelNr, String art, int bestand, double preis)
    {
        ueberpruefeArtikelNr(artikelNr);
        ueberpruefeBestand(bestand);
        
        setArt(art);
        setPreis(preis);

        this.artikelNr = artikelNr;
        this.bestand   = bestand;
    }

    /**
     * Teilkonstruktor mit 3 Parametern versetzt das Objekt Patient  
     * nach seiner Erzeugung in einen gueltigen Zustand.
     * 
     * @param artikelNr Die vierstellige Artikelnummer des Artikels
     * @param art       Die Art des Artikels
     * @param preis     Der Preis des Artikels
     */
    public Artikel(int artikelNr, String art, double preis)
    {
        this(artikelNr, art, 0, preis);
    }

    
    //______________________________Methoden_________________________________
    
    //__________________________Zugang buchen_______________________________
    
    /**
     * bucheZugang Bucht eine Erhöhung der Stückzahl eines Artikels.
     * 
     * @param menge   Die Menge, die dem Bestand hizugefügt wird
     * @param bestand Die Anzahl vorhandener Artikel
     * @param zugang  Die Summe von Bestand und Menge
     */
    public void bucheZugang(int zugang)
    {
        if(zugang <= 0)
        {
            throw new IllegalArgumentException(ZUGANGSWERT_ZU_NIEDRIG);
        }
        else 
        {
            bestand += zugang; 
        }
    }

    
    //__________________________Abgang buchen_______________________________
    
    /**
     * bucheAbgang Bucht eine Verminderung der Stückzahl eines Artikels.
     * 
     * @param menge   Die Menge, die dem Bestand abgezogen wird
     * @param bestand Die Anzahl vorhandener Artikel
     * @param abgang  Die Differenz von Bestand und Menge
     */
    public void bucheAbgang(int abgang) 
    { 
        if(bestand < abgang)
        {
            throw new IllegalArgumentException(ABGANGSWERT_ZU_HOCH);
        }
        else 
        {
            bestand -= abgang;
        }  
    }

    
    //________________________Ändere Preis____________________________________
    
    /**
     * aenderePreis Aendert den Preis eines Artikels.
     * 
     * @param prozent Der Prozentwert, um den der Preis des Artikels
     *                veraendert werden soll.
     */
    public void aenderePreis(double prozent)
    {
        if(preis < EPSILON)
        {
            throw new IllegalArgumentException(NEGATIVER_PREIS);
        }
        preis += preis * prozent/100.0;
    }

    
    //________________________Hilfsmethoden____________________________________
    
    //____________________Überprüfung der Artikelnummer________________________
    
    /**
     * ueberpruefeArtikelNr Ueberprueft, ob die Artikel-Nr. vierstellig ist.
     * 
     * @param artikelNr Die vierstellige Artikelnummer des Artikels
     * 
     * @throws Eine Exception wird geworfen, wenn die Artikel-Nr.
     *         kleiner als MIN_ARTIKEL_NR (->z.Z. 1000) oder
     *         grösser als MAX_ARTIKEL_NR (->z.Z. 9999) ist.
     */
    private void ueberpruefeArtikelNr(int artikelNr)
    {
        if(artikelNr < MIN_ARTIKEL_NR || artikelNr > MAX_ARTIKEL_NR)
        {
            throw new IllegalArgumentException(ARTIKELNUMMER_UNGUELITIG);
        }   
    }

    //___________________Überprüfung des Bestandes____________________________
    
    /**
     * ueberpruefeBestand
     */
    private void ueberpruefeBestand(int bestand)
    {
        if(bestand < 0)
        {
            throw new IllegalArgumentException(BESTANDSWERT_UNZULAESSIG);
        }
    }
    
    
    //______________________________Getter_________________________________
    
    public int getArtikelNr()
    {
        return artikelNr;
    }

    public String getArt()
    {
        return art;
    }

    public int getBestand()
    {   
        return bestand;
    }

    public double getPreis()
    {
        return preis;
    }
    
    public String getBeschreibung() 
    {
        return "Artikel: " + art; 
    }
    
    //______________________________Setter_________________________________
    
    /**
     * Ändert (wenn gewünscht) nachträglich die Art des Artikels
     * 
     * @throws Exception wird geworfen, wenn keine Artikelart angegeben wurde.
     */
    public void setArt(String art)
    {
        if(art.strip().isEmpty())
        {
            throw new IllegalArgumentException(ARTIKELART_FEHLT);
        }
        this.art = art;
    } 

    public void setPreis(double preis)
    {
        if(preis < EPSILON)
        {
            throw new IllegalArgumentException(NEGATIVER_PREIS);
        }
        this.preis = preis;
    }
    
    
    //________________________toString-Methode______________________________
    
    /**
     * Gibt eine String-Repräsentation des Artikels zurück.
     */
    public String toString() 
    {
        return ("Artikel: "   + artikelNr + 
                ", Art: "     + art + 
                ", Bestand: " + bestand  + 
                ", Preis: "   + preis);
    }
}