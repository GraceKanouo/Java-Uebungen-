import java.util.Random;
import java.util.Arrays;
/**
 *  die Klasse NumberCrunchAnonym enthäalt Methoden ,um Reihe von Berechnungen auf einem gegebenen Array von gleichkommazahlen durchzufUhren.
 *  Das ergebnis jede Operation wird im Gleich Array gespechert. die Klasse enthäalt auch ein Konstructor der Array von gGleichkommmaZahlen erwartet
 * Die Klasse ist Anonym
 * @author (Sandra  Hussong und Grace Ntiwa) 
 * @version (Uebung 15)
 */
public class NumberCruncherAnonym 
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen

    private float[] numbers;
    /**
     * Konstruktor für Objekte der Klasse NumberCrunchAnonym
     * Erstellt eine NumberCruncherAnonym Object mit der ubergebene Float Array.
     * @throws NumberKruncherException wenn das ubergebene Array leer sit oder null ist.
     */
    public NumberCruncherAnonym(float[] numbers) throws NumberCruncherException
    {
        if(numbers == null || numbers.length == 0)
        {
            throw new NumberCruncherException("Das Array muss nicht leer sein. ");
        }
        // Instanzvariable initialisieren
        this.numbers = numbers;
    }

    /**Diese Klasse fuhrt die abgegebene Operationen
     *  auf denm Float Array aus.
     *  Das ergebnis jeder Operation wird im gleiche String Array Gespeichert.
     *   @throws NumberKruncherException wenn das ubergebene Array von Operation leer sit oder null ist
     *   @return nichts zurück.
     */
    public void crunch(String[] operations) throws NumberCruncherException
    {
        if(operations == null || operations.length == 0)
        {
            throw new NumberCruncherException("Das  operations Array muss nicht leer sein. ");
        }
        for(String operate : operations)
        {
            switch(operate)
            {
                case "sum":
                    crunch(new CrunchOperation()
                        {
                            @Override
                            public void crunch(float[] values)
                            {
                                for(int i = 1; i < values.length; i++){
                                    values[i] += values[i -1];

                                }
                            }
                        });
                    break;
                case "swirl" :
                    crunch(new CrunchOperation()
                        {
                            @Override
                            public void crunch(float[] values)
                            {
                                Random random = new Random();
                                for(int i = 0; i < values.length; i++)
                                {
                                    int j = random.nextInt(values.length);
                                    float temp = values[i];
                                    values[j] = temp;
                                }
                            }
                        });
                    break;
                case "divide" :
                    crunch(new CrunchOperation(){
                            @Override
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
                        });
                    break;
                case "subtract" :
                    crunch(new CrunchOperation()
                        {
                            @Override
                            public void crunch(float[] values)
                            {
                                for(int i = 1; i < values.length; i++)
                                {
                                    values[i] -= values[i - 1];
                                }
                            }
                        });
                    break;
                case "average" :
                    crunch(new CrunchOperation()
                        {
                            @Override
                            public void crunch(float[] values)
                            {
                                float sum = 0;
                                for(float wert : values)
                                {
                                    sum += wert;
                                }

                                float average = sum/values.length;
                                float max =values[0];// Float.MIN_VALUE;
                                int maxIndex = -1;
                                for(int i = 0; i < values.length; i++)
                                {
                                    if(values[i] > max)
                                    {
                                        max = values[i];
                                        maxIndex = i;
                                    }
                                }
                                values[maxIndex] = average;
                            }
                        });
                    break;
                default :
                    System.out.println("Unknown operation: " + operate);

            }
        }
    }

    /** Dienst als hilsfklasse
     * @throws  NumberCruncherException wenn operate null ist 
     * @return nichts zurück
     * @param operate von der implimenierung der CrunchOperate methode.
     */
    private void crunch(CrunchOperation operate) throws NumberCruncherException
    {
        if(operate.equals(null))
        {
            throw new NumberCruncherException("Das CrunchOperation object darf nicht leer sein. ");
        }
        operate.crunch(numbers);

    }

    /**Dies Methode gibt DAs Gleichkommazahlen Array zurück, auf das die Operationen angewendet wird
     * @param  nichts
     * @return ein float Array
     * 
     */
    public float[] getNumbers()
    {
        return this.numbers;
    }
    /**
     * private interface.
     * kann nur in deisen klasse verwendet wird für die implementierung der Crunch methode
     */
    private interface CrunchOperation
    {
        void crunch(float[] values);
    }
}
