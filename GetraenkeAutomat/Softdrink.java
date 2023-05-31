/**
 * Die Klasse Softdrink ermöeglicht die Erzeugung eines 
 * Softdrink-Objekts.
 * 
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
class Softdrink extends AlkoholfreiesGetraenk 
{
    //_______________KONSTANTEN__________________________

    private static final float EPSILON = 0.00000000000001f;

    //_______________FEHLERMELDUNGEN_____________________

    private static final String ZUCKERGEHALT_UNGUELTIG =
            "Der Zuckergehalt kann nicht negativ sein.";


    //_______________ATTRIBUTE___________________________

    private float zuckergehalt;


    //_______________KONSTRUNKTOREN______________________

    /**
     * Ein Konstruktor ohne Parameter.
     * Ruft den Konstruktor der Elternklasse auf und setzt 
     * das Attribut zuckergehalt auf den Standardwert 0.
     */
    public Softdrink() 
    {
        super();
        this.zuckergehalt = 0.0f;
    }

    /**
     * Konstruktor fuer die Klasse Softdrink.
     * Ruft den Konstruktor der Elternklasse auf und 
     * initialisiert das Attribut zuckergehalt.
     * 
     * @param hersteller   Der Hersteller des Softdrinks
     * @param zuckergehalt Der Zuckergehalt des Softdrinks
     * 
     * @throws IllegalArgumentException, 
     *         wenn Der Zuckergehalt negativ ist
     */
    public Softdrink(String hersteller, float zuckergehalt)
    {
        super(hersteller);
        setZuckergehalt(zuckergehalt);
    }


    //_______________GETTER_____________________________

    public float getZuckergehalt() 
    {
        return zuckergehalt;
    }


    //_______________SETTER_____________________________
    /**
     * Setter-Methode fuer das Attribut zuckergehalt.
     * Ueberprueft, ob der Zuckergehalt positiv ist.
     * 
     * @param zuckergehalt Der Zuckergehalt des Softdrinks
     * 
     * @throws IllegalArgumentException, 
     *         wenn der Zuckergehalt des Softdrinks ungueltig,
     *         d.h. unter 0 liegt.
     */
    public void setZuckergehalt(float zuckergehalt)
    {
        if(zuckergehalt < EPSILON)
        {
            throw new GetraenkException(ZUCKERGEHALT_UNGUELTIG);  
        }

        this.zuckergehalt = zuckergehalt;
    }


    //_______________TO_STRING__________________________

    /**
     * Gibt eine String-Repraesentation des Softdrinks zurueck.
     * 
     * @return Die String-Repraesentation des Softdrinks
     */
    @Override
    public String toString() 
    {
        return super.toString() + " " + zuckergehalt + "% Zucker";
    }


    //_______________EQUALS_____________________________

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(this == obj)
        {
            return true;
        }
        if (!(obj instanceof Softdrink)) 
        {
            return false;
        }

        Softdrink other = (Softdrink) obj;

        return super.equals(other) && 
               Float.compare(zuckergehalt, other.zuckergehalt) == 0;
    }
}