import java.util.function.Predicate;

/**
 * Die Klasse MatheFunktionenTester testet die 
 * Funktionalitaet der Methoden in der Klasse
 * MatheFunktionen.
 * 
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class MatheFunktionenTester
{
    /**
     * Konstruktor, um zu verhindern, dass ein 
     * MatheFunktionenTester-Objekt erstellt 
     * wird.
     *
     */
    public void MatheFunktionenTester() {}

    /**
     * applyAndPrint Soll eine uebergebene Funktion auf alle
     *               Zahlen zwischen start und end anwenden 
     *               und das Ergebnis ausgeben.
     *
     * @param function Eine Funktion
     * @param start    Der Startwert
     * @param end      Der Endwert
     */
    public static void applyAndPrint(ConditionateInterface function, int start, int end) 
    {
        for (int i = start; i <= end; i++) 
        {
            try 
            {
                int result = function.apply(i);
                System.out.println(i + " ---> " + result);
            } 
            catch (MatheException e) 
            {
                System.out.println(i + ", Fehler: " + e.getMessage());
            }
        }
    }

    /**
     * runFunctions Ruft die Methoden der Klasse MatheFunktionen auf
     *              und gibt die Ergebnisse der einzelnen Funktionen
     *              von 1-10 zurueck.
     *
     */
    public static void runFunctions()
    {
        MatheFunktionen matheFunktionen = new MatheFunktionen();
        
        
        // i) f(x) = x^2 --> Quadrat
        System.out.println("Quadrat (anonym):");
        testFunction(matheFunktionen.quadratAnonym, 1, 10);
        System.out.println();

        System.out.println("Quadrat (lambda):");
        testFunction(matheFunktionen.quadratLambda, 1, 10);
        System.out.println();

        
        // ii) f(x) = x!  --> Fakultaet
        System.out.println("Fakultaet (anonym):");
        testFunction(matheFunktionen.fakultaetAnonym, 1, 10);
        System.out.println();

        System.out.println("Fakultaet (lambda):");
        testFunction(matheFunktionen.fakultaetLambda, 1, 10);
        System.out.println();

        
        // iii) f(x) = x^(x+1)
        System.out.println("Zahl hoch Zahl plus 1 (anonym):");
        testFunction(matheFunktionen.zahlHochZahlPlus1Anonym, 1, 10);
        System.out.println();

        System.out.println("Zahl hoch Zahl plus 1 (lambda):");
        testFunction(matheFunktionen.zahlHochZahlPlus1Lambda, 1, 10);
        System.out.println();

        
        // iv) f(x) = fib(x) --> Fibonacci-Folge
        System.out.println("Fibonacci-Folge (anonym):");
        testFunction(matheFunktionen.fibonacciAnonym, 1, 10);
        System.out.println();

        System.out.println("Fibonacci-Folge (lambda):");
        testFunction(matheFunktionen.fibonacciLambda, 1, 10);
        System.out.println();
    }

    /**
     * evenAndOddTest Testet die Funktionalitaet der Praedikate
     *                even und odd.
     *
     */
    public static void evenAndOddTest()
    {
        //___________FUNKTIONEN__________________________
        
        ConditionateInterface  condQuadrat = x -> x * x;

        
        ConditionateInterface  condFakultaet = x -> 
            {
                    int result = 1;
                    for (int i = 2; i <= x; i++) 
                    {
                        result *= i;
                    }
                    return result;
            };

          
            
        //___________PRAEDIKATE__________________________ 
        
        Predicate<Integer> odd = new Predicate<Integer>() 
            {
                public boolean test(Integer i) 
                {
                    return i % 2 != 0;
                }
            };

        Predicate<Integer> even = i -> i % 2 == 0;
        
        
        //___________AUSGABE__________________________ 
        
        System.out.println("Quadrat (INPUT gerade):");
        applyAndPrint(condQuadrat.conditionateInput(even), 1, 10 );
        System.out.println();
        
        
        System.out.println("Fakultaet (OUTPUT ungerade):");
        applyAndPrint(condFakultaet.conditionateInput(even), 1, 10 );
        //System.out.println();
    }

    /**
     * testFunction Soll eine uebergebene Funktion auf alle
     *              Zahlen zwischen start und end anwenden 
     *              und das Ergebnis ausgeben.
     *
     * @param function Eine Funktion
     * @param start    Der Startwert
     * @param end      Der Endwert
     */
    public static void testFunction(MyFunction function, int start, int end) 
    {
        MatheFunktionen matheFunktionen = new MatheFunktionen();

        for (int i = start; i <= end; i++) 
        {
            try 
            {
                int result = function.apply(i);
                System.out.println(i + " ---> " + result);
            } 
            catch (MatheException e) 
            {
                System.out.println(i + ", Fehler: " + e.getMessage());
            }
        }
    }
    
    /**
     * main Startet die Testmethoden
     */
    public static void main(String[] args) 
    {
        runFunctions();
        evenAndOddTest();
    }
}


