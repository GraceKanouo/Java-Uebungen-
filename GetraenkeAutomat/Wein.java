import java.util.*;
/**
 * Die Klasse ermöeglicht die Erzeugung eines Wein-Objekts.
 * Sie enthaelt zusaetzlich zum Alkoholgehalt das Weingut, 
 * von welchem der Wein stammt.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public class Wein extends AlkoholischesGetraenk
{
    //_______________FEHLERMELDUNGEN_____________________

    private static final String WEINGUT_LEER =
            "Es wurde keine Weingut angegeben.";


    //_______________ATTRIBUTE___________________________

    private String weingut;


    //_______________KONSTRUNKTOREN______________________

    /**
     * Ein Konstruktor fuer ein Wein-Objekt ohne Argumente. 
     */
    public Wein() 
    {
        super();
    }

    /**
     * Konstruktor fuer ein Wein-Objekt mit Angabe des Alkoholgehalts und des Weinguts.
     * 
     * @param alkoholgehalt Der Alkoholgehalt des Weins
     * @param weingut       Das Weingut, von dem der Wein stammt
     */
    public Wein(float alkoholgehalt, String weingut)
    {
        super(alkoholgehalt);
        setWeingut(weingut);
    }


    //_______________GETTER_____________________________

    public String getWeingut() 
    {
        return weingut;
    }


    //_______________SETTER_____________________________

    /**
     * Setzt das Weingut des Weins.
     * 
     * @param weingut Das Weingut, von dem der Wein stammt
     * 
     * @throws IllegalArgumentException, 
     *         wenn das Weingut nicht angegeben wurde 
     *         (---> null oder leerer String)
     */
    public void setWeingut(String weingut)
    {
        if(weingut == null || weingut.isBlank())
        {
            throw new GetraenkException(WEINGUT_LEER);  
        }

        this.weingut = weingut;
    }


    //_______________TO_STRING__________________________

    @Override
    public String toString() 
    {
        return super.toString() + " vom Weingut " + weingut;
    }


    //_______________EQUALS_____________________________

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) 
        {
            return false;
        }
        if (!super.equals(obj)) 
        {
            return false;
        }

        Wein wein = (Wein) obj;

        return Objects.equals(weingut, wein.weingut);
    }
}
