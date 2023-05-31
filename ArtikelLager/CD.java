import java.util.*;
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class CD extends Artikel 
{
    //________________________Exceptions____________________________________
    
    private final String INTERPRET_LEER = 
            "Name des Interpreten fehlt.";
            
    private final String TITEL_LEER = 
            "Albumname fehlt.";
            
    private final String CD_LEER = 
            "Es befinden sich keine Musiktitel auf der CD";
            
    
    //________________________Attribute____________________________________

    private String interpret;
    private String titel;
    private int anzahlTitel;
    
    
    //________________________Konstruktoren________________________________
    
    /**
     * 
     */
    public CD (int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) 
    {
        super(artikelNr, "medien", bestand, preis);

        setInterpret(interpret);
        setTitel( titel);
        setAnzahlTitel( anzahlTitel);

    } 
    
    
    //______________________________Getter_________________________________
    
    public String getInterpret() 
    {
        return this.interpret;
    }

    public String getTitel() 
    {
        return this.titel;
    }

    public int getAnzahlTitel() 
    {
        return this.anzahlTitel;
    }

    public String getBeschreibung() 
    {
        return "CD: " + interpret + 
               ": " + titel; 
    }

    
    //______________________________Setter_________________________________
    
    public void setInterpret(String interpret) 
    {
        if(interpret.strip().isEmpty()) 
        {
            throw new IllegalArgumentException(INTERPRET_LEER);
        }
        this.interpret = interpret;
    }

    /**
     * 
     */
    public void setTitel(String titel) 
    {
        if(titel == null || titel.strip().isEmpty())
        {
            throw new IllegalArgumentException(TITEL_LEER);
        }
        this.titel= titel;
    }

    /**
     * 
     */
    public void setAnzahlTitel(int anzahlTitel) 
    {
        if(anzahlTitel <= 0)
        {
            throw new IllegalArgumentException(CD_LEER);
        }

        this.anzahlTitel= anzahlTitel;
    }
    
    
    //________________________toString-Methode______________________________
    
    @Override
    public String toString() 
    {
        return ("Titel: "                 + titel +
                "\nInterpret: "           + interpret +
                "\nAnzahl der Musiktitel" + anzahlTitel);
    }
    
    //________________________equals-Methode________________________________
    
    public boolean equals (Object cdObjekt) 
    {
        if (this == cdObjekt) 
        {
            return true;
        }
            
        if (cdObjekt == null)
        {
            return false;
        }
        
        if (getClass() != cdObjekt.getClass()) 
        {
            return false;       
        }
        
        CD cd = (CD)cdObjekt;
        
        return (Objects.equals(titel, cd.titel) && 
                Objects.equals(interpret, cd.interpret) &&
                Objects.equals(anzahlTitel, cd.anzahlTitel));
    }
}



