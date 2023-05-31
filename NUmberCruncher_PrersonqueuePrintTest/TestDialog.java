import java.util.Scanner;

/**
 *Diese Klasse ist eine interative test.
 *Gibt der benutzer den Auswahl zu wahlen wie die Zahlen generiert werden.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TestDialog
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie viele elemente soll das Array haben? ");
        int length = scan.nextInt();
        float[] numbers = new float[length];

        System.out.println("Wie sollen die Zahlen generiert werden? \n manuel(1) oder automatisch(2)");
        int auswahl = scan.nextInt();

        if(auswahl == 1)
        {
            for(int i = 0; i < length; i++)
            {
                System.out.println("Geben Sie die "+ (i+1) + " Zahl ein ");
                numbers[i] = scan.nextFloat();

            }
        }else if(auswahl == 2)
        {
            for(int i = 0; i < length; i++)
            {
                numbers[i] = (float)(Math.random() * 100);
            }
        }else{
            System.out.println("Ungültige Eingabe. Bitte wahlen sie 1 oder 2: ");
            return;
        }
        
        
        System.out.println("Welche Operation sollte durchgefuhrt weden? \n (sum, swirl, divide, substract,average)");
        NumberCruncherAnonym anonymCruncher     = new NumberCruncherAnonym(numbers);
        NumberCruncherTopLevel topLevelCruncher = new NumberCruncherTopLevel(numbers);
        scan.nextLine();
        String input = scan.nextLine();
        
        

        String[] operations = input.split(" ");
        anonymCruncher.crunch(operations);
        topLevelCruncher.crunch(operations);

        System.out.println("Ergebnisse des NumberCruncherAnonym: ");
        printNumbers(anonymCruncher.getNumbers());

        System.out.println("Ergebnisse des NumberCruncherTopLevel: ");
        printNumbers(topLevelCruncher.getNumbers());

        scan.close();

    }

    /**
     * diese Methode dient nur dazu, der Ergebnisse lesbarer darzustellen.
     * @param float numbers array
     * @return kein wert
     */
    private static void printNumbers(float[] numbers)
    {
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.println("Elements " + i + ":" + numbers[i]);
        }
    }
}

