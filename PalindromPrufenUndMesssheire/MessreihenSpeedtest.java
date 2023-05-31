import java.io.*;
import java.util.Scanner;

/**
 * Beschreiben Sie hier die Klasse MessreihenSpeedtest.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MessreihenSpeedtest
{
    public static final String STRING_REGEX = "\\s*";

   
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
         
        System.out.println("Geben Sie die Anzahl der Wörter ein:");
        int n = scanner.nextInt();
        
        String[] woerterArray = generateWordsArray(n);

        Messreihe[] messreihen = new Messreihe[] { new MessreiheIterativ(woerterArray), new MessreiheRekursiv(woerterArray) };

        int[][] wortlaengen = new int[messreihen.length][n];
        long[][] messzeiten = new long[messreihen.length][n];

        for (int i = 0; i < messreihen.length; i++) 
        {

            wortlaengen[i] = messreihen[i].countWortlaenge();
            messzeiten[i] = measureSpeed(messreihen[i], woerterArray);
        }

        writeToFile(wortlaengen, messzeiten, "messung.csv");
        System.out.println("Die gewunchte Ergebnis wude ins Datei gespeichert.");
    }

    public static long[] measureSpeed(Messreihe messreihe, String[] woerterArray) 
    {
        long[] messzeiten = new long[woerterArray.length];

        for (int i = 0; i < woerterArray.length; i++) 
        {
            String[] worte = new String[i + 1];
            System.arraycopy(woerterArray, 0, worte, 0, i + 1);

            long start = System.nanoTime();
            messreihe.countWortlaenge();
            long end = System.nanoTime();

            messzeiten[i] = end - start;
        }
        return messzeiten;
    }

    public static void writeToFile(int[][] wortlaengen, long[][] messzeiten, String filename) 
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) 
        {
            writer.println("Wortlaenge,Iterativ,Rekursiv");
            for (int i = 0; i < wortlaengen[0].length; i++) 
            {
                writer.printf("%d, %d, %d\n", wortlaengen[0][i], messzeiten[0][i], messzeiten[1][i]);
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public static String[] generateWordsArray(int n) 
    {
        String[] words = new String[n];
        for (int i = 0; i < n; i++) 
        {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) 
            {
                sb.append('a');
            }
            words[i] = sb.toString();
        }
        return words;
    }
}


