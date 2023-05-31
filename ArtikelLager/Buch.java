import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class Buch extends Artikel 
{
    //________________________Exceptions____________________________________
    
    private final String AUTOR_LEER  = 
        "Name des Autors fehlt.";

    private final String TITEL_LEER  = 
        "Titel des Buches fehlt.";

    private final String VERLAG_LEER = 
        "Name des Verlags fehlt";
    
        
    //________________________Attribute____________________________________

    private String autor;
    private String titel;
    private String verlag;

    
    //________________________Konstruktoren________________________________
    
    /**
     * 
     */
    public Buch (int artikelNr, int bestand, double preis, String titel, String autor, String verlag) 
    {
        super(artikelNr, "medien", bestand, preis);

        setAutor(autor);
        setTitel(titel);
        setVerlag(verlag);

    } 
    
    
    //___________________________Getter____________________________________
    
    public String getAutor() 
    {
        return this.autor;
    }

    public String getTitel() 
    {
        return this.titel;
    }

    public String getVerlag() 
    {
        return this.verlag;
    }

    public String getBeschreibung() 
    {
        return ("Buch: " + autor +
                ": " + titel); 
    }

    
    //______________________________Setter_________________________________
    
    public void setVerlag(String verlag) 
    {
        if(verlag.strip().isEmpty() || verlag == null)
        {
            throw new IllegalArgumentException(VERLAG_LEER);
        }
        this.verlag = verlag;
    }

    public void setTitel(String titel) 
    {
        if(titel.strip().isEmpty() || titel == null)
        {
            throw new IllegalArgumentException(TITEL_LEER);
        }
        this.titel= titel;
    }

    public void setAutor(String autor) 
    {
        if(autor.strip().isEmpty() || autor == null)
        {
            throw new IllegalArgumentException(AUTOR_LEER);
        }
        this.autor = autor;
    }
    
    
    //________________________toString-Methode______________________________
    
    /**
     * 
     */
    @Override
    public String toString() 
    {
        return ("Buchtitel: " + titel + 
                "\nAutor: "   + autor + 
                "\nVerlag"    + verlag);
    }
    
    
    //________________________equals-Methode________________________________
    
    public boolean equals (Object buchObjekt)
     {
        if (this == buchObjekt) 
        {
            return true;
        }
        
        if (buchObjekt == null)
        {
            return false;
        }
        
        if (getClass() != buchObjekt.getClass()) 
        {
            return false;       
        }
        
        Buch buch = (Buch)buchObjekt;
        
        return (Objects.equals(titel, buch.titel) && 
                Objects.equals(autor, buch.autor) &&
                Objects.equals(verlag, buch.verlag));
    }
}
