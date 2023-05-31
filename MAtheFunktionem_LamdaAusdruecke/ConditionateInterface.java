import java.util.function.Predicate;

/**
 * Die Schnittstelle ConditionateInterface erweitert 
 * das Interface MyFunction und bietet die Standardmethoden 
 * conditionateInput und conditionateOutput, die die 
 * Anwendung von Praedikaten (Predicate<Integer>) auf die 
 * Eingabe- bzw. Ausgabewerte einer Funktion ermoeglichen.
 * 
 *
 * @author Grace D. Ntiwa Kanou
 * @author Sandra R. Hussong
 * 
 * @version 09.05.23
 */
public interface ConditionateInterface extends MyFunction
{
    /**
     * Wendet das gegebene Praedikat auf den Eingabewert 
     * einer Funktion an und gibt das Ergebnis
     * der Funktion zurueck, wenn das Praedikat erfuellt ist. 
     * Andernfalls wird 0 zurueckgegeben.
     * 
     * @param predicate Das Praedikat, das auf den 
     *                  Eingabewert angewendet wird
     * @return Eine ConditionateInterface-Funktion, 
     *         die das Praedikat auf den Eingabewert anwendet
     */
    default public ConditionateInterface conditionateInput(Predicate<Integer> predicate) 
    {
        return x -> predicate.test(x) ? this.apply(x) : 0;
    }

    /**
     * Wendet das gegebene Praedikat auf den Ausgabewert 
     * einer Funktion an und gibt das Ergebnis
     * der Funktion zurueck, wenn das Praedikat erfuellt ist. 
     * Andernfalls wird 0 zurueckgegeben.
     * 
     * @param predicate Das Praedikat, das auf den 
     *                  Ausgabewert angewendet wird
     * @return Eine ConditionateInterface-Funktion, 
     *         die das Praedikat auf den Ausgabewert anwendet
     */
    default public ConditionateInterface conditionateOutput(Predicate<Integer> predicate) 
    {
        return x -> 
        {
            int result = this.apply(x);
            return predicate.test(result) ? result : 0;
        };
    }
}
