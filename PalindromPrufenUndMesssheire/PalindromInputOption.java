import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;

/**
 * Die Klasse 
 * 
 * @author (Grace  D. Ntiwa Kanou)
 * @author (Sandra R. Hussong)
 * 
 * @version (23.04.23)
 */
public class PalindromInputOption
{
    //public static final String STRING_REGEX = "\\s*";

    /**
     * Die Methode main führt das Programm aus.
     * 
     */
    public static void main(String[] args) throws IOException
    {
        // PalindromIterativ und PalindromRekursiv Instanzen erzeugen
        PalindromIterativ iter = new PalindromIterativ();
        PalindromRekursiv rek = new PalindromRekursiv();

        // Eingabestring
        String input ="";
        // Dateiname
        String filename = "";

        // Überprüfung, ob Argumente beim Aufruf des Programms übergeben wurden
        if(args.length > 0)
        {
            // Wenn ja, den Input-String = erstes Argument
            input = args[0];

            // Palindrom-Tests durchführen und Ergebnisse ausgeben
            boolean istIter = iter.istPalindrom(input);
            boolean istRek = rek.istPalindrom(input);

            if(istIter)
            {
                System.out.println("Iterativ Implimentierung: " + 
                    input + " Ist Palindrom " ); 
            }else{
                System.out.println("Iterativ Implimentierung: " + 
                    input  + " Kein Palindrom");
            }
            if(istRek)
            {
                System.out.println("Rekursiv Implimentierung: " + 
                    input + " Ist Palindrom " ); 
            }else{
                System.out.println("Rekursiv Implimentierung: " +  
                    input +  " Kein Palindrom");
            }

            //System.out.println(input + ": " +(istIter ? "ist iterativ Palindrom" : "kein iterativ Palindrom"));
            //System.out.println(input + ": " +(istRek ? "ist rekuriv Palindrom" : "kein rekursiv Palindrom"));

            // Wenn keine Argumente übergeben wurden, Eingabemethode abfragen
        }
        else
        {
            // Eingabeoption wählen
            Scanner scan = new Scanner(System.in);
            System.out.println("\nPALINDROMPRUEFER\n\n" + "Was möchten Sie pruefen?\n" + 
                "Datei (D)\n" + "Eingabe (E)");
            String auswahl = scan.nextLine();
            /*if(auswahl != IgnoreCase("D")  || auswahl != IgnoreCase("E"))
            {
            throw new PalindromException("Falsche Eingabe Type. ");
            }*/
            if(auswahl.equalsIgnoreCase("D"))
            {
                if(auswahl.equalsIgnoreCase("D"))
                {
                    //aus Datei lesen
                    System.out.println("Bitte geben Sie den Dateinamen mit Pfad ein");
                    filename = scan.nextLine();

                    try
                    {
                        // BufferedReader-Instanz mit FileReader-Instanz erzeugen
                        BufferedReader reader = new BufferedReader(new FileReader(filename));
                        String line = reader.readLine();

                        // Jede Zeile in der Datei lesen und in einzelne Wörter teilen
                        while(line != null)
                        {
                            String[] eigenesWort = line.trim().split("\\s+");

                            // Palindrom-Tests für jedes Wort durchführen und Ergebnisse ausgeben
                            for(String wort : eigenesWort)
                            {
                                boolean istIter = iter.istPalindrom(wort);
                                boolean istRek = rek.istPalindrom(wort);

                                if(istIter)
                                {
                                    System.out.println("Iterativ: " + wort +  " ist ein Palindrom!"); 
                                }
                                else
                                {
                                    System.out.println("Iterativ: " + wort  + " ist kein Palindrom!");
                                }
                                if(istRek)
                                {
                                    System.out.println("Rekursiv: " + wort +  " ist ein Palindrom!"); 
                                }
                                else
                                {
                                    System.out.println("Reursiv: " +  wort +  " ist kein Palindrom!");
                                }
                            }
                            line = reader.readLine();

                        }
                        reader.close();
                    }
                    catch(FileNotFoundException e)
                    {
                        System.out.println("Die Datei " + filename + " konnte nicht gefunden werden. ");

                    }
                    catch(IOException e)
                    {
                        System.out.println("Es ist ein Fehler beim Lesen der Datei aufgetreten.");

                    }
                }
                if(auswahl.equalsIgnoreCase("E"))
                {
                    // Konsoleneingabe überprüfen
                    System.out.println("Bitte geben Sie ein Wort oder einen Satz ein: ");
                    input = scan.nextLine();
                    boolean istIter = iter.istPalindrom(input);
                    boolean istRek = rek.istPalindrom(input);

                    if(istIter)
                    {
                        System.out.println("Iterativ: " + input +  
                            " ist ein Palindrom!"); 
                    }
                    else
                    {
                        System.out.println("Iterativ: " + input  + 
                            " ist kein Palindrom!");
                    }
                    if(istRek)
                    {
                        System.out.println("Rekursiv: " + input +  
                            " ist ein Palindrom!"); 
                    }
                    else
                    {
                        System.out.println("Reursiv: " +  input +  
                            " ist kein Palindrom!");
                    }
                    scan.close();
                }
            }

            
            // HINWEISE
            // Das Programm startet nicht von Neuem, wenn eine Überprüfung zu Ende ist
            // Eine ungültige Eingabe wird nicht abgefangen
        }
    }

    private static String IgnoreCase(String string) {
        return null;
    }
}
