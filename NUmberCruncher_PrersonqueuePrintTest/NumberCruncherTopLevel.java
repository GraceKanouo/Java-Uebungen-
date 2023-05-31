import java.util.Arrays;
/**
 *  die Klasse NumberCrunchAnonym enthäalt Methoden ,um Reihe von Berechnungen auf einem gegebenen Array von gleichkommazahlen durchzufUhren.
 *  Das ergebnis jede Operation wird im Gleich Array gespechert. die Klasse enthäalt auch ein Konstructor der Array von gGleichkommmaZahlen erwartet
 * Die Klasse ist Anonym
 * @author (Sandra  Hussong und Grace Ntiwa) 
 * @version (Uebung 15)
 */
public class NumberCruncherTopLevel 
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    private float[] numbers;
    /**
     * Konstruktor für Objekte der Klasse NumberCrunchAnonym
     * Erstellt eine NumberCruncherAnonym Object mit der ubergebene Float Array.
     * @throws NumberKruncherException wenn das ubergebene Array leer sit oder null ist.
     */
    public NumberCruncherTopLevel(float[] numbers)
    {
        // Instanzvariable initialisiere
        if(numbers == null || numbers.length == 0)
        {
            throw new NumberCruncherException("Das numbers Array darf nicht leer sein. ");
        }
        this.numbers = numbers;
    }

    /**Diese Klasse fuhrt die abgegebene Operationen
     *  auf denm Float Array aus.
     *  Das ergebnis jeder Operation wird im gleiche String Array Gespeichert.
     *   @throws NumberKruncherException wenn das ubergebene Array von Operation leer sit oder null ist
     *   @return nichts zurück.
     */
    public void crunch(String[] operations)
    {
        for(String operate : operations)
        {
            CrunchOperation cruncher = getCruncher(operate);
            if(operations == null )
            {
                throw new NumberCruncherException("Das operations Array darf nicht leer sein. ");
            }

            cruncher.crunch(numbers);
        }
    }

    /**
     * 
     */
    private CrunchOperation getCruncher(String operate)
    {
        switch(operate)
        {
            case "sum" :
                return new SumCruncher();
            case "swirl" :
                return new SwirlCruncher();
            case "divide" :
                return new DivideCruncher();
            case "subtract" :
                return new SubtractCruncher();
            case "average" :
                return new AverageCruncher();
            default :
                throw new IllegalArgumentException("Unknown operation: " + operate );

        }
    }

    /**Dies Methode gibt DAs Gleichkommazahlen Array zurück, auf das die Operationen angewendet wird
     * @param  nichts
     * @return ein float Array
     * 
     */
    public float[] getNumbers()
    {
        return numbers;
    }
     /**
     * private interface.
     * kann nur in deisen klasse verwendet wird für die implementierung der Crunch methode
     */
    private interface CrunchOperation
    {
        void crunch(float[] values);
    }

    /**
     *  diese Methode Summiert die werte im array Von Links nach Recht und Speicher die ergebnisse in der Wert der recht steht
     *  @param float Array
     *  @return nichts
     * 
     */
    private static class SumCruncher implements CrunchOperation
    {
        public void crunch(float[] values)
        {
            for(int i = 1; i < values.length; i++)
            {
                values[i] += values[i - 1];
            }
        }
    }

    /** diese Methode macht eine zufällige Neuanordnung der Elemente im Array.
     * @param float array
     * dievWerte im Array Sind zufällig bei der Random Operation gegeben
     * @return nichts
     */
    private static class SwirlCruncher implements CrunchOperation
    {
        public void crunch(float[] values)
        {
            int n = values.length;
            for(int i = 0; i < n; i++)
            {
                int j = (int)(Math.random() * n);
                float tmp = values[i];
                values[j] = tmp;
            }
        }

    }

    /**  Diese Methode dividiert die größten und kleinsten Elemente des Arrays miteinander.
     * @param float Array
     * @return nichts
     * 
     */
    private static class DivideCruncher implements CrunchOperation
    {
        public void crunch(float[] values)
        {
            int n = values.length;
            int halbNum = n/2;
            Arrays.sort(values);
            for(int i= 0; i < halbNum; i++)
            {
                int j = n-i -1;
                float divisor = values[i];
                float dividend = values[j];
                values[j] = dividend/ divisor;
            }
        }

    }
     /**
     *  diese Methode Ssubstrahiert die werte im array Von Links nach Recht und Speicher die ergebnisse in der Wert der recht steht
     *  @param float Array
     *  @return nichts
     * 
     */
    private static class SubtractCruncher implements CrunchOperation
    {
        public void crunch(float[] values)
        {
            for(int i = 1; i < values.length; i++)
            {
                values[i] -= values[i - 1];
            }
        }

    }

    /** Diese vmethode Berechnet den Durchnitt alle werte im Array und erzetz das hochste element durch diese ergebnisse 
     * @param float array
     * @  throws  NumberCruncherException wenn das Array values leer oder Null ist
     * 
     */
    private static class AverageCruncher implements CrunchOperation
    {
        public void crunch(float[] values)
        {
            if(values == null || values.length == 0)
            {
                throw new NumberCruncherException("Das Array darf nicht leer sein. ");
            }
            float sum  = 0;
            for(float valaue : values)
            {
                sum += valaue;
            }
            float average = sum/values.length;
            float max =values[0]; 
            int index = 0;
            for(int i = 0; i < values.length; i++)
            {
                if(values[i] > max) 
                {
                    index = i;
                }
            }
            values[index] = average;
        }

    }
}
