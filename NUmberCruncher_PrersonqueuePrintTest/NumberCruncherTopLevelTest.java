
import org.junit.jupiter.api.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Die Test-Klasse NumberCruncherTest , testen die Funktionalitaet 
 * der Methoden aus der Klasse Person.
 *
 * @author  (Grace D. Ntiwa Kanou)
 * @author  (Sandra R. Hussong)
 * 
 * @version (01.05.23)
 */
 public class NumberCruncherTopLevelTest {

    private float[] numbers;
    private NumberCruncherTopLevel cruncher;

    @BeforeEach
    public void setUp() {
        numbers = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f};
        cruncher = new NumberCruncherTopLevel(numbers);
    }

    @Test
    public void testSumCruncher() {
        String[] operations = new String[]{"sum"};
        cruncher.crunch(operations);
        float[] expected = new float[]{1.0f, 3.0f, 6.0f, 10.0f, 15.0f};
        assertArrayEquals(expected, cruncher.getNumbers());
    }

    @Test
    public void testSwirlCruncher() {
        String[] operations = new String[]{"swirl"};
        cruncher.crunch(operations);
        assertFalse(Arrays.equals(numbers, cruncher.getNumbers()));
    }

    @Test
    public void testDivideCruncher() {
        String[] operations = new String[]{"divide"};
        cruncher.crunch(operations);
        float[] expected = new float[]{5.0f, 4.0f/3.0f, 1.0f, 3.0f/4.0f, 1.0f/5.0f};
        assertArrayEquals(expected, cruncher.getNumbers(), 0.001f);
    }

    @Test
   public void testSubtractCruncher() {
        String[] operations = new String[]{"subtract"};
        cruncher.crunch(operations);
        float[] expected = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        assertArrayEquals(expected, cruncher.getNumbers());
    }

    @Test
    public void testAverageCruncher() {
        String[] operations = new String[]{"average"};
        cruncher.crunch(operations);
        float[] expected = new float[]{3.0f};
        assertArrayEquals(expected, cruncher.getNumbers());
    }

    @Test
    public void testMultipleOperations() {
        String[] operations = new String[]{"sum", "divide", "subtract"};
        cruncher.crunch(operations);
        float[] expected = new float[]{5.0f, 4.0f/3.0f - 5.0f, 1.0f - 4.0f/3.0f, 3.0f/4.0f - 1.0f, 1.0f/5.0f - 3.0f/4.0f};
        assertArrayEquals(expected, cruncher.getNumbers(), 0.001f);
    }

    @Test
    public void testEmptyNumbersArray() {
        assertThrows(NumberCruncherException.class, () -> new NumberCruncherTopLevel(new float[0]));
    }

    @Test
    public void testNullNumbersArray() {
        assertThrows(NumberCruncherException.class, () -> new NumberCruncherTopLevel(null));
    }

    @Test
    public void testEmptyOperationsArray() {
        String[] operations = new String[]{};
        assertThrows(NumberCruncherException.class, () -> cruncher.crunch(operations));
    }

    @Test
    public void testNullOperationsArray() {
        String[] operations = null;
         assertThrows(NumberCruncherException.class, () -> cruncher.crunch(operations));
    }
}