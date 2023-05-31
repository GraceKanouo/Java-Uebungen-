import java.util.*;
import java.io.*;
import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse QeueDialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class QueueDialog
{
    //_______________________Konstanten______________________________

    private static final int ART_DER_WARTESHLANGE                = 1;
    private static final int ADDLAST_ZU_ARRAY                    = 2;
    private static final int REMOVE_FIST_ELEMENT_VON_ARRAY       = 3;
    private static final int ANZAHL_ELEMENTE_IN_DER_QUEUE        = 4;
    private static final int PRINT_QUEUE                         = 5;

    private static final int ENDE                               =  0;
    //________________________Exceptions______________________________
    private static final String ERROR =  
        "Es ist ein Fehler aufgetreten.";

    //__________________________Scanner_______________________________
    private Scanner input;

    //________________________Attribute_______________________________

    private Queue queue;

    //______________________Object_____________________________________
    private Object object;

    //______________________Konstruktoren______________________________
    
     /**
     * Der Konstruktor initiiert ein Objekt der Klasse LagerDialog
     * und initilisiert die Variable input als Scannerobjekt.
     */
    public QueueDialog() {
        //queue = null;
        input = new Scanner(System.in);

    }
    /**
     * start stellt die Hauptprogrammschleife dar, regelt den 
     * Programmablauf und faengt auftretende Fehler ab. Das
     * Beenden dieser Schleife stellt gleichzeitig das Programm-
     * ende dar.
     */
    public void start()
    {
        int funktion;

        do
        {
            try
            {
                menueAusgeben();
                funktion = eingabe();
                ausfuehrenFunktion (funktion);
            }
            catch(IllegalArgumentException e)
            {
                System.out.println (ERROR);
            }
            catch(InputMismatchException e)
            {
                System.out.println (ERROR);
                input.nextLine();
            }
            catch(Exception e)
            {
                System.out.println (ERROR);
                e.printStackTrace(System.out);
            }
        }
        while(eingabe() != ENDE);
    }

    //_______________Eingabe, Hauptschleife des Dialogs__________________ 
    /**
     * eingabe nimmt eine Usereingabe und speichert diese in die Variable 
     * option der Hauptprogrammschleife. 
     * @return  Integer, der in der Variablen option gespeichert wird.
     */
    private int eingabe()
    {
        int funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * gibt Hauptmenü auf Bildschirm aus
     */
    private void menueAusgeben()
    {
        System.out.println( ART_DER_WARTESHLANGE + 
            ": Art der WArteschlange Wählen(String/Person);\n" +
            ADDLAST_ZU_ARRAY + 
            ": Eine elemete am ende der Queue  hinzufügen;\n" +
            REMOVE_FIST_ELEMENT_VON_ARRAY + 
            ":Die erste Elemente in der Queue loeschen;\n" +
            ANZAHL_ELEMENTE_IN_DER_QUEUE + 
            ": Anzahl den Elememnten im Queue;\n" +
            PRINT_QUEUE +
            " : Queue ausgeben;\n" +

            ENDE + 
            ": Vorgang beenden -> ");

    }

    //_____________Ausgabe, Auswerten der Benutzereingabe_________________

    /**
     *ausfuehrenFunktion  ruft anhand des aktuell in der Variablen option gespeicherten
     * Wertes die naechste auszufuehrende Methode auf.
     * @param  funktion  Integer als Wert der Variable option.
     */
    private void ausfuehrenFunktion(int funktion)
    {
        if(funktion == ART_DER_WARTESHLANGE)
        {
            warteschlange(input);
        }
        else if(funktion == ADDLAST_ZU_ARRAY)
        {
            addLast(input);
        }
        else if(funktion == REMOVE_FIST_ELEMENT_VON_ARRAY)
        {
            removeFirst ();
        }
        else if(funktion == ANZAHL_ELEMENTE_IN_DER_QUEUE)
        {
            size ();
        }
        else if(funktion == PRINT_QUEUE) 
        {
            print(queue);
        }
        else if(funktion == ENDE)
        {
            System.out.println("Programmende");
        }
        else
        {
            System.out.println("Ungültige Eingabe!");
        }
    }

    /**
     * Wartrschlange hilfst der benutzer auszuwaehlen, welche arte von Schlangen der benutzer 
     * bearbeiten will
     */
    public String warteschlange(Scanner input) {
        System.out.println("Bitte wählen sie die Art der Warteschlange aus (String/Person)");
        final String art = input.nextLine();
        switch (art.toLowerCase()) {
            case "string" :
                System.out.println("Sie haben ein String queue ausgewählt !");
                queue = new StringQueue(10);
                break ;
            case "person" :
                System.out.println("Sie haben ein Person Queue ausgewählt !");
                queue = new PersonQueue(10);
                break ;
            default :  System.out.print("Falsche Eingabe");
        }
        return "";
    }

    /**
     * addLast fuegt ein Object am Ende des arrays
     */

    public void addLast(Scanner input){
        int size  = 0;
        String art = input.nextLine();
        System.out.println("Bitte wählen sie die Art der Warteschlange aus (String/Person)");
        switch (art.toLowerCase()) {
            case "string" :
                System.out.println("Sie haben ein String queue ausgewählt !");
                System.out.print("Geben sie der Name ihre String");
                String string = input.next();
                System.out.print("der String ist: " + "\n" + string);
                queue.addLast(string);
                //queue = new StringQueue(size);
                break;
            case "person" :
                System.out.println("Sie haben ein Person Queue ausgewählt !");
                System.out.print("Geben sie der Name Der Person");
                String name = input.next();
                System.out.print("Geben sie der Vorname Der Person");
                String vorname = input.next();
                System.out.println("Der Person heisst: " + name + "\n" + vorname);
                queue.addLast(name + vorname);
                // queue = new PersonQueue(size);
                break;
            default :  System.out.print("Falsche Eingabe");
        }

    }
    /**
     * remove first implimentiert die methode removefirst() von der interface 
     * und loescht der Object der am erste stelle im array steht
     * 
     */

    public void removeFirst() {
        queue.removeFirst();
        System.out.println(queue.removeFirst() + " wurde entfernt");
    }
    /**
     * size Methode gibt uns der anzahl der objecte im queue zueruck
     * 
     */
    public void size() {
        int size = 0;
        if(input.hasNextLine()) {
        System.out.println("Bitte wählen sie die Art der Warteschlange aus (String/Person)");
        final String art = input.nextLine();
        switch (art.toLowerCase()) {
            case "string" :
                System.out.println("Sie haben ein String queue ausgewählt !");
                System.out.println("Gebne Sie der Groesse der warteschlange");
                size = input.nextInt();
                queue = new PersonQueue(size);
                System.out.println("die schlange Groesse ist :" + size);
                break ;
            case "person" :
                System.out.println("Sie haben ein Person Queue ausgewählt !");
                System.out.println("Gebne Sie der Groesse der warteschlange");
                size = input.nextInt();
                queue = new PersonQueue(size);
                System.out.println("die schlange Groesse ist : " + size );
                break ;
            default :  System.out.print("Falsche Eingabe");
        }

    }
}

    /**
     * Prnt queue gibt aus was im queue steht
     * @param queue
     * @throws exception wenn queue leer ist,
     * wenn object null ist
     */
    public void print(Queue queue) {
        if(queue.empty() ) {
            throw new IllegalArgumentException(ERROR);
        } 
        if(object == null) {
            throw new IllegalArgumentException(ERROR); 
        }
        for(int i = 0; i < queue.size(); i++) {
            Object object = queue.get(i);
        }

        System.out.println(object);
    }

    //__________________________Main Methode________________________
    /**
     * Der Main Methode  stellt den Einstiegspunkt in die Ausführung einer Java-Anwendung dar 
     * rueft die start Methode
     */
    public static void main(String[] args) 
    {
        new QueueDialog().start();
    }
}

