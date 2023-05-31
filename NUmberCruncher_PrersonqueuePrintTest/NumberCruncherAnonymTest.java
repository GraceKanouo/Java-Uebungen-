import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
/**
 * Dies test-Klasse NumberCruncherAnonym
 * @author(Grace und Sandra)
 * @version()
 */

public class NumberCruncherAnonymTest {

    @Test
    public void testConstructor() {
        float[] numbers = {1.0f, 2.0f, 3.0f};
        NumberCruncherAnonym nca = new NumberCruncherAnonym(numbers);
        assertArrayEquals(numbers, nca.getNumbers(), 0.01f);
    }

    @Test
    public void testConstructorNullArray() {
        assertThrows(NumberCruncherException.class, () -> {
                    new NumberCruncherAnonym(null);
            });
    }

    @Test
    public void testConstructorEmptyArray() {
        assertThrows(NumberCruncherException.class, () -> {
                    new NumberCruncherAnonym(new float[]{});
            });
    }

    @Test
    public void testCrunchSum() {
        float[] numbers = {1.0f, 2.0f, 3.0f};
        NumberCruncherAnonym nca = new NumberCruncherAnonym(numbers);
        nca.crunch(new String[]{"sum"});
        float[] expected = {1.0f, 3.0f, 6.0f};
        assertArrayEquals(expected, nca.getNumbers(), 0.01f);
    }

    @Test
    public void testCrunchSwirl() {
        float[] numbers = {1.0f, 2.0f, 3.0f};
        NumberCruncherAnonym nca = new NumberCruncherAnonym(numbers);
        nca.crunch(new String[]{"swirl"});
        assertNotEquals(numbers, nca.getNumbers());
    }

    @Test
    public void testCrunchDivide() {
        float[] numbers = {2.0f, 4.0f, 6.0f, 8.0f};
        NumberCruncherAnonym nca = new NumberCruncherAnonym(numbers);
        nca.crunch(new String[]{"divide"});
        float[] expected = {4.0f, 3.0f, 2.0f, 1.0f};
        assertArrayEquals(expected, nca.getNumbers(), 0.01f);
    }

    @Test
    public  void testCrunchSubtract() {
        float[] numbers = {1.0f, 2.0f, 3.0f};
        NumberCruncherAnonym nca = new NumberCruncherAnonym(numbers);
        nca.crunch(new String[]{"subtract"});
        float[] expected = {1.0f, 1.0f, 1.0f};
        assertArrayEquals(expected, nca.getNumbers(), 0.01f);
    }

    @Test
    public void testCrunchAverage() {
        float[] numbers = {1.0f, 2.0f, 3.0f};
        NumberCruncherAnonym nca = new NumberCruncherAnonym(numbers);
        nca.crunch(new String[]{"average"});
        float[] expected = {1.0f, 2.0f, 2.0f};
        assertArrayEquals(expected, nca.getNumbers(), 0.01f);
    }

    @Test
    public void testEmptyNumbersArray() {
        assertThrows(NumberCruncherException.class, () ->  new NumberCruncherAnonym( new float[0]) );
    }

    @Test
    public void testNullNumbersArray() {
        assertThrows(NumberCruncherException.class, () ->  new NumberCruncherAnonym(null));
    }

    @Test
    public void testEmptyOperationsArray() {
        String[] operations = new String[]{};
        assertThrows(NumberCruncherException.class, () ->  new NumberCruncherAnonym(null));
    }

    @Test
    public void testNullOperationsArray() {
        String[] operations = null;
        assertThrows(NumberCruncherException.class, () ->  new NumberCruncherAnonym(null));
    }
}