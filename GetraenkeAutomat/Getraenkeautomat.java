import java.util.*;
/**
 * Die Klasse dient als Basis fuer konkrete Getraenkeklassen.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 06.05.23
 */
public class Getraenkeautomat <T extends Getraenk>
{
    //_______________FEHLERMELDUNGEN_____________________

    private static final String FLASCHE_LEER =
            "Die Flasche ist leer!";

    private static final String AUTOMAT_VOLL =
            "Der Automat ist bereits voll!";

    private static final String AUTOMAT_LEER =
            "Der Automat ist leer!";

    private static final String KAPAZITAET_UNGUELTIG =
            "Die Kapazitaet des Atomaten kann nicht kleiner 1 sein!";

    //_______________ATTRIBUTE___________________________

    private ArrayList<Flasche<T>> flaschenlager;
    private int kapazitaet;


    //_______________KONSTRUNKTOREN______________________

    public Getraenkeautomat(int kapazitaet) 
    {
        setKapazitaet(kapazitaet);
        this.flaschenlager = new ArrayList<>();
    }
    
    
    //_______________FLASCHE_EINLEGEN____________________


    /**
     * flascheEinlegen Legt eine Flasche in den Getränkeautomat ein.
     *
     * @param flasche Die Flasche, die eingelagert werden soll
     * 
     * @throws IllegalArgumentException, 
     *         wenn der Automat voll ist oder die Flasche,
     *         die eingelagert werden soll, leer ist.
     */
    public void flascheEinlegen(Flasche<T> flasche) 
    {
        if(automatVoll())
        {
            throw new IllegalArgumentException(AUTOMAT_VOLL);
        }
        if (!flasche.istGefuellt()) 
        {
            throw new IllegalArgumentException(FLASCHE_LEER);
        }

        flaschenlager.add(flasche);

        System.out.println("Die Flasche wurde erfolgreich eingelagert.\n" + 
                           "Anzahl der Flaschen im Automaten: " 
                           + flaschenlager.size() + 
                           "\nVerfuegbare Plaetze im Automaten: " 
                           + (kapazitaet - flaschenlager.size()));
    }


    //_______________FLASCHE_AUSGEBEN____________________

    public Flasche<T> flascheAusgeben() 
    {
        if(flaschenlager.isEmpty())
        {
            throw new IllegalArgumentException(AUTOMAT_LEER);
        }
        
        Flasche<T> ausgegebeneFlasche = flaschenlager.remove(0);
        System.out.println("Ausgegebene Flasche: " 
                           + ausgegebeneFlasche.toString() +
                           "\nVerfuegbare Plaetze im Automaten: " 
                           + (kapazitaet - flaschenlager.size()));

        return ausgegebeneFlasche;
    }
   
    //_______________HILFSMETHODEN_______________________

    private boolean automatVoll()
    {
        return this.flaschenlager.size() == this.kapazitaet;
    }


    //_______________GETTER______________________________

    public int getKapazitaet()
    {
        return kapazitaet;
    }

    //_______________SETTER______________________________

    public void setKapazitaet(int kapazitaet)
    {
        if(kapazitaet <= 0)
        {
            throw new IllegalArgumentException(KAPAZITAET_UNGUELTIG);
        }
        this.kapazitaet = kapazitaet;
    }

    //_______________TO_STRING___________________________

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Kapazitaet: ").append(kapazitaet).append("\n");
        sb.append("Anzahl der Flaschen: ").append(flaschenlager.size()).append("\n");
        
        for(Flasche<T> f : flaschenlager) 
        {
            sb.append(f.toString()).append("\n");
        }
        return sb.toString();
    }
}
