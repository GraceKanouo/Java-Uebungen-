import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Video.
 * 
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class Video extends Artikel 
{
    //________________________Exceptions____________________________________
    
    private final String JAHR_UNGUELTIG = 
            "Erscheinungsjahr muss zwischen 1900 und 2022 liegen.";
            
    private final String TITEL_LEER = 
            "Titel des Videos fehlt.";
            
    private final String KEINE_SPIELDAUER = 
            "Das Spiel muss mehr als null munuten dauern.";
    
    
    //________________________Attribute____________________________________
    
    private int    jahr;
    private String titel;
    private double spieldauer;

    
    //________________________Konstruktoren________________________________
    
    /**
     * @param artikelNr
     * @param bestand
     * @param preis
     * @param titel
     * @param jahr
     * @param spieldauer
     */
    public Video (int artikelNr, int bestand, double preis, String titel, int jahr, double spieldauer) 
    {
        super(artikelNr, "medien", bestand, preis);

        setJahr(jahr);
        setTitel(titel);
        setSpieldauer(spieldauer);

    } 
        
    
    //______________________________Getter_________________________________
    
    public int getJahr() 
    {
        return this.jahr;
    }

    public String getTitel() 
    {
        return this.titel;
    }

    public double getSpieldauer() 
    {
        return this.spieldauer;
    }

    public String getBeschreibung() 
    {
        return "Video: "+ titel; 
    }

    
    //______________________________Setter_________________________________
    
    /**
     * 
     */
    public void setJahr(int jahr) 
    {
        if(jahr <1900 || jahr > 2022)
        {
            throw new IllegalArgumentException(JAHR_UNGUELTIG);
        }
        this.jahr = jahr;
    }

    /**
     * 
     */
    public void setTitel(String titel) 
    {
        if(titel.strip().isEmpty())
        {
            throw new IllegalArgumentException(TITEL_LEER);
        }
        this.titel= titel;
    }

    /**
     * 
     */
    public void setSpieldauer(double spieldauer) 
    {
        if(spieldauer <= 0)
        {
            throw new IllegalArgumentException(KEINE_SPIELDAUER);
        }

        this.spieldauer = spieldauer;
    }
    
    
    //________________________toString-Methode______________________________
    
    @Override
    public String toString() 
    {
        return ("Titel: "              + titel + 
                "\nVideolaufzeit: "    + spieldauer + 
                "\nErscheinungsjahr: " + jahr);
    }
    
    
    //________________________equals-Methode________________________________
    
    public boolean equals (Object videoObjekt) 
    {
        if (this == videoObjekt) 
        {
            return true;
        }
        
        if (videoObjekt == null)
        {
            return false;
        }
        
        if (getClass() != videoObjekt.getClass()) 
        {
            return false;       
        }
        
        Video video = (Video)videoObjekt;
        
        return (Objects.equals(titel,video.titel) && 
                Objects.equals(jahr, video.jahr) &&
                Objects.equals(spieldauer, video.spieldauer));
    }
}
