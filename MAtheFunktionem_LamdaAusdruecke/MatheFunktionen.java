import java.util.function.Predicate;

/**
 * Die Klasse beinhaltet folgende mathematische 
 * Funktionen: 1. f(x) = x^2
 *    
 *             2. f(x) = x!
 *    
 *             3. f(x) = x^(x+1)
 *    
 *             4. f(x) = fib(x)
 *    
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 22.05.23
 */
public class MatheFunktionen 
{
    //_______________KONSTANTEN_________________________________

    public static final int MAX_EINGABEWERT_QUADRAT     = 
        Ueberpruefungen.getMaxInputQuadrat();

    public static final int MAX_EINGABEWERT_FAKULTAET   = 
        Ueberpruefungen.getMaxInputFakultaet();  

    public static final int MAX_EINGABEWERT_ZHochZPLUS1 = 
        Ueberpruefungen.getMaxInputZahlHochZahlPlus1();

    public static final int MAX_EINGABEWERT_FIBONACCI   = 
        Ueberpruefungen.getMaxInputFibonacci();

        
    //_______________FEHLERMELDUNGEN___________________________
    
    public static final String UNGUELTIGE_EINGABE_QUADRAT     = 
        "Die Zahl darf nicht groesser als " +
        MAX_EINGABEWERT_QUADRAT + " sein!";

    public static final String UNGUELTIGE_EINGABE_FAKULTAET   = 
        "Die Zahl darf nicht kleiner als 1 oder groesser " +
        MAX_EINGABEWERT_FAKULTAET + " sein!";

    public static final String UNGUELTIGE_EINGABE_ZHOCHZPLUS1 = 
        "Die Zahl darf nicht kleiner als 1 oder groesser " +
        MAX_EINGABEWERT_ZHochZPLUS1 + " sein!";

    public static final String UNGUELTIGE_EINGABE_FIBONACCI   = 
        "Die Zahl darf nicht kleiner als 0 oder groesser " +
        MAX_EINGABEWERT_FIBONACCI + " sein!";

        
    
    //_______________APPLYANDPRINT__________________________
    
    /**
     * applyAndPrint Soll eine uebergebene Funktion auf alle
     *               Zahlen zwischen start und end anwenden 
     *               und das Ergebnis ausgeben.
     *
     * @param f    Eine Funktion
     * @param i    Der Startwert
     * @param j    Der Endwert
     */
    public void applyAndPrint(int i, int j, MyFunction f) 
    {
        for (int zahl = i; zahl <= j; zahl++) 
        {
            int result = f.apply(zahl);
            System.out.println(result);
        }
    }

    
    //___________PRAEDIKATE__________________________ 
    
    Predicate<Integer> odd = new Predicate<Integer>() 
        {
            public boolean test(Integer i) 
            {
                return i % 2 != 0;
            }
        };

    Predicate<Integer> even = i -> i % 2 == 0;

    
    
    //  i) f(x) =  --> Quadrat

    MyFunction quadratAnonym = new MyFunction() 
        {
            public int apply(int i) 
            {
                if (!Ueberpruefungen.istZahlImBereich(i, MAX_EINGABEWERT_QUADRAT)) 
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_QUADRAT);
                }
                return i * i;
            }
        };

    MyFunction quadratLambda = i -> 
        {
                if (!Ueberpruefungen.istZahlImBereich(i, MAX_EINGABEWERT_QUADRAT)) 
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_QUADRAT);
                }
                return i * i;
        };

        
        
    // ii) f(x) = x!  --> Fakultaet
    
    MyFunction fakultaetAnonym = new MyFunction() 
        {
            public int apply(int i) 
            {
                if (!Ueberpruefungen.istNatuerlicheZahl(i) || 
                !Ueberpruefungen.istZahlImBereich(i, MAX_EINGABEWERT_FAKULTAET)) 
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_QUADRAT);
                }

                int result = 1;
                for (int j = 2; j <= i; j++) 
                {
                    result *= j;
                }
                return result;
            }
        };

    MyFunction fakultaetLambda = i -> 
            {
                if (!Ueberpruefungen.istNatuerlicheZahl(i) || 
                !Ueberpruefungen.istZahlImBereich(i, MAX_EINGABEWERT_FAKULTAET)) 
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_QUADRAT);
                }

                int result = 1;
                for (int j = 2; j <= i; j++) 
                {
                    result *= j;
                }
                return result;
        };

    public static class NestedFakultaet implements MyFunction 
    {
        public int apply(int i) 
        {
            if(!Ueberpruefungen.istNatuerlicheZahl(i) || 
            !Ueberpruefungen.istZahlImBereich
            (i,MAX_EINGABEWERT_FAKULTAET))
            {
                throw new MatheException(UNGUELTIGE_EINGABE_QUADRAT);
            }

            int result = 1;
            for (int j = 2; j <= i; j++)
            {
                result *= j;
            }
            return result;
        }
    }

    
    
    // iii) f(x) = x^(x+1)

    MyFunction zahlHochZahlPlus1Anonym = new MyFunction() 
        {
            public int apply(int i) 
            {
                if(!Ueberpruefungen.istNatuerlicheZahl(i) || 
                !Ueberpruefungen.istZahlImBereich
                (i,MAX_EINGABEWERT_ZHochZPLUS1))
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_ZHOCHZPLUS1);
                }

                int result = 1;

                for (int x = 0; x <= i + 1; x++) 
                {
                    result *= i;
                }
                return result;
            }
        };

    MyFunction zahlHochZahlPlus1Lambda = i -> 
        {
                if(!Ueberpruefungen.istNatuerlicheZahl(i) || 
                !Ueberpruefungen.istZahlImBereich
                (i,MAX_EINGABEWERT_ZHochZPLUS1))
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_ZHOCHZPLUS1);
                }

                int result = 1;

                for (int x = 0; x <= i + 1; x++) 
                {
                    result *= i;
                }
                return result;
        };

    
        
        // iv)  f(x) = fib(x) --> Fibonacci-Folge

    MyFunction fibonacciAnonym = new MyFunction() 
        {
            public int apply(int i) 
            {
                if(!Ueberpruefungen.istNatuerlicheZahl(i) || 
                !Ueberpruefungen.istZahlImBereich
                (i,MAX_EINGABEWERT_FIBONACCI))
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_FIBONACCI);
                }
                else if (i == 1 || i == 2) 
                {
                    return 1;
                } 

                int prev1 = 1;
                int prev2 = 1;
                int fib = 0;
                for (int x = 3; x <= i; x++) 
                {
                    fib = prev1 + prev2;
                    prev1 = prev2;
                    prev2 = fib;
                }
                return fib;   
            }
        };

    MyFunction fibonacciLambda = i -> 
        {
                if (!Ueberpruefungen.istNatuerlicheZahl(i) ||
                !Ueberpruefungen.istZahlImBereich
                (i, MAX_EINGABEWERT_FIBONACCI)) 
                {
                    throw new MatheException(UNGUELTIGE_EINGABE_FIBONACCI);
                } 
                if (i == 1 || i == 2) 
                {
                    return 1;
                } 

                int prev1 = 1;
                int prev2 = 1;
                int fib = 0;
                for (int x = 3; x <= i; x++) 
                {
                    fib = prev1 + prev2;
                    prev1 = prev2;
                    prev2 = fib;
                }    
                return fib;

        };
}