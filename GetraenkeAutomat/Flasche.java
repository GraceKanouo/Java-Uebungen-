/**
 * 
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public class Flasche<T extends Getraenk> 
{
    //_______________FEHLERMELDUNGEN_____________________

    private static final String FLASCHE_VOLL =
            "Die Flasche ist bereits gefuellt.";
        
    private static final String FLASCHE_LEER =
            "Die Flasche ist bereits leer.";


    //_______________ATTRIBUTE___________________________

    private T inhalt;


    //_______________KONSTRUNKTOREN______________________

    public Flasche() {}


    //_______________FUELLEN_____________________________

    /**
     * fuellen 
     * 
     * @param getraenk 
     */
    public void fuellen(T getraenk) 
    {
        if(istGefuellt())
        {
            throw new IllegalArgumentException(FLASCHE_VOLL);
        }
        this.inhalt = getraenk;
    }


    //_______________LEEREN______________________________

    /**
     * leeren 
     */
    public void leeren() 
    {
        if(!istGefuellt())
        {
            throw new IllegalArgumentException(FLASCHE_LEER);
        }
        this.inhalt = null;
    }


    //_______________HILFSMETHODEN_______________________

    public boolean istGefuellt() 
    {
        return inhalt != null;
    }

    //_______________GETTER______________________________

    public T getInhalt() 
    {
        return inhalt;
    }
    

    //_______________SETTER_____________________________

    public void setInhalt(T inhalt) 
    {
        this.inhalt = inhalt;
    }

    //_______________TO_STRING__________________________

    @Override
    public String toString() 
    {
        if(!istGefuellt())
        {
            throw new IllegalArgumentException("Die Flasche ist leer!");
        }
        return "Die Flasche enthält " + inhalt.toString();
    }

    //_______________EQUALS_____________________________

}

