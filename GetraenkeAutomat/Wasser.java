/**
 * Die Klasse dient als Basis fuer konkrete Getraenkeklassen.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
class Wasser extends AlkoholfreiesGetraenk
{
    //_______________FEHLERMELDUNGEN_____________________

    private static final String QUELLE_LEER =
            "Der Zuckergehalt kann nicht negativ sein.";


    //_______________ATTRIBUTE___________________________

    private String quelle;
    

    //_______________KONSTRUNKTOREN______________________

    public Wasser() 
    {
        super();
    }
    
    public Wasser(String hersteller, String quelle) 
    {
        super(hersteller);
        setQuelle(quelle);
    }
    

    //_______________GETTER_____________________________

    public String getQuelle() 
    {
        return quelle;
    }
    

    //_______________SETTER_____________________________

    public void setQuelle(String quelle) 
    {
        if(quelle == null || quelle.isBlank())
        {
            throw new GetraenkException(QUELLE_LEER);
        }
        
        this.quelle = quelle;
    }
    

    //_______________TO_STRING__________________________

    @Override
    public String toString() 
    {
        return super.toString() + ", Quelle: " + quelle;
    }
}