import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Die Test-Klasse MessreiheRekursivTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MessreiheRekursivTest
{
    @Test
    public void testCountWortlaenge_Null_String() 
    {
        String[] data = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> 
            {
                    new MessreiheRekursiv(data);
            });

    }

    @Test
    public void testCountWortlaenge_0_String() 
    {
        String[] data = {""};
        MessreiheRekursiv messreihe = new MessreiheRekursiv(data);

        int[] expected = {0};
        int[] actual = messreihe.countWortlaenge();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testCountWortlaenge_0_String_mit_LZ() 
    {
        String[] data = {" "};
        MessreiheRekursiv messreihe = new MessreiheRekursiv(data);

        int[] expected = {0};
        int[] actual = messreihe.countWortlaenge();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testCountWortlaenge_1_String_Zahl() 
    {
        String[] data = {"1"};
        MessreiheRekursiv messreihe = new MessreiheRekursiv(data);

        int[] expected = {1};
        int[] actual = messreihe.countWortlaenge();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCountWortlaenge_1_String_BS() 
    {
        String[] data = {"a"};
        MessreiheRekursiv messreihe = new MessreiheRekursiv(data);

        int[] expected = {1};
        int[] actual = messreihe.countWortlaenge();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCountWortlaenge_10_Strings() 
    {
        String[] data = {"a", "Io", "Ida", "Mars", "Venus", "Saturn", "Jupiter", "Kallisto", "Andromeda", "Interamnia"};
        MessreiheRekursiv messreihe = new MessreiheRekursiv(data);
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actual = messreihe.countWortlaenge();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCountWortlaenge_2_Strings() 
    {
        String[] data = {"Dies ist ein Test", "Hier sind mehrere Wörter enthalten"};
        MessreiheRekursiv messreihe = new MessreiheRekursiv(data);

        int[] expected = {14, 30};
        int[] actual = messreihe.countWortlaenge();
        assertArrayEquals(expected, actual);
    }
}
