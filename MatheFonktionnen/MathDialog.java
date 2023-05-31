import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * die klasse MathDialog ist zur Interaktion des Users mit der Fachklasse gedacht.
 * diese klasse ermoeglicht der User bestimmte Werte mit bestime matematischen Formeln zu berechnen.
 * 
 * @author (Grace dinecha Ntiwa && Sanda Hussong) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class MathDialog
{
    /**
     * Die variablen fuer den Scanner und MathFunctions sind deklariert.
     * MathFunctions stellt die Verbindung zwischen den Fachklasse und diese klasse da .
     * 
     * 
     * private Menuepunkte sind hier als konstanten deklariert.
     */
    private Scanner input;
    private MathFunctions mathFunctions;

    private static final int TEILLERSUMME = 1;
    private static final int ISBN_PRUFFZIFFER = 2;
    private static final int  NULL_STELLEN_FUER_QUADRATIC_GLEICHERUNG = 3;
    private static final int SUMME_VON_POTENZEN_BERECHNEN = 4;
    private static final int GGT_VON_ZWEI_ZAHLEN_BERECHNEN = 5;
    private static final int FAKULTAET_BERECHNEN =6;
    private static final int REIHENSUMME_BERECHNEN = 7;
    private static final int ENDE = 8;
    
    /**
     * Standard Konstructor.
     */
    public MathDialog(){
        input = new Scanner(System.in);
    }

    /**
     * Dieses methode aktivieert die Schleife des Programms und sorg dabei fuer die staendige Wiederholungder MenueAusgabe.
     * Die try und catch methode wirk dabei,dass alle eingabe die wir nicht tolerieren gezeigt und gestoppt wird.
     * 
     */

    public void start(){
        int funktion = 0;

        do{
            try{
                menueAusgabe();
                funktion = this.eingabeFunktion();
                this.ausfuehrenFunktion(funktion);
            }catch(IllegalArgumentException e){
                System.out.println(e);
            } catch(InputMismatchException e){
                System.out.println(e);
                input.nextLine();
            }catch(Exception e){
                System.out.println(e);
                e.printStackTrace(System.out);
            }

        }while(funktion !=ENDE);       
    } 

    private int eingabeFunktion(){
        int funktion = input.nextInt();
        return funktion;
    } 

    /**
     * Dieses Methode  erfasst den Wert der Funktion.
     * Es leitet die jeweilige Methode ein, die diesem Wert zogeordnet hat.
     */
    private void ausfuehrenFunktion(int funktion){
        if (funktion == TEILLERSUMME){
            teilerSummeBerechnen();
        }else if(funktion == ISBN_PRUFFZIFFER){
            ibsnZifferPruefen();
        }else if(funktion == NULL_STELLEN_FUER_QUADRATIC_GLEICHERUNG){
            nullstellenBerechnen();
        }else if(funktion ==SUMME_VON_POTENZEN_BERECHNEN){
            summeVonPotenzen();
        }else if(funktion ==GGT_VON_ZWEI_ZAHLEN_BERECHNEN){
            ggtBerechnen();
        }else if(funktion ==FAKULTAET_BERECHNEN){
            fakultaetBerechnen();
        }else if(funktion ==REIHENSUMME_BERECHNEN){
            ReihenSumme();
        }else if (funktion == ENDE){
            System.out.println("Programm wird beendet");
        }else
            System.out.println("Ungultiger Befehl");
    }

    /**
     * Siese Methode nimmt die Zahl des Users und berechnet die vteilersumme.
     */
    private void teilerSummeBerechnen(){
        System.out.println("Geben Sie der zahl ein, dessen Teilersummme berechnen wird !");
        long zahl = input.nextLong();
        long teilerSumme = mathFunctions.berechneTeilersumme(zahl);
        System.out.println("Teilersumme ist :" + teilerSumme);
    }

    /**
     * diese Methode rechnet mit hilfe der Fachklasse die ISBN-10 Nummer aus.
     */
    private void ibsnZifferPruefen(){
        System.out.println("Biite geben Sie die Zahl ein.");
        long zahl = input.nextLong();
        String prufziffer = mathFunctions.berechneChecksummeIsbn(zahl);
        System.out.println("Prüfziffer: " + prufziffer);
    }

    /**
     * Diese methode berechnet mit die variablen p und q die Nullstellen dieser Funktion
     */
    private void nullstellenBerechnen() {
        System.out.println("Bitte geben Sie die Werte von p und q für die Berechnung der Nullstellen  der  quadratischen Gleichung ein."); 
        System.out.println("Value of p ist :");
        double p = input.nextDouble();
        System.out.println("Value of q ist :");
        double q= input.nextDouble();
        String nullstelle = MathFunctions.berechneNullstellen(p,q);
        System.out.println("Nullstellen : " + nullstelle);
    }

    /**
     * 
     */
    private void summeVonPotenzen(){
        System.out.println("Biite geben Sie die Zahl ein.");
        long zahl = input.nextLong();
        boolean summeVonPotenzen = MathFunctions.istSummeVonPotenzen(zahl);
        System.out.println("Die antwort ist :" + summeVonPotenzen);
    }

    /**
     * 
     */
    private void ggtBerechnen(){
        System.out.println("Biite geben Sie die erste Zahl ein.");
        int zahl1 = input.nextInt();
        System.out.println("Biite geben Sie die  zweite Zahl ein.");
        int zahl2 = input.nextInt();
        int ggt = MathFunctions.berechneGgt(zahl1,zahl2);
        System.out.println("Groester gemeinsamer Teiler ist:" + ggt);
    }

    /**
     * 
     */
    private void fakultaetBerechnen(){
        System.out.println("Biite geben Sie die Zahl ein.");
        int zahl = input.nextInt();
        long fakultaet = MathFunctions.berechneFakultaet(zahl);
        System.out.println("Fakultaet von der Zahl ist :" + fakultaet);
    }

    /**
     * 
     */
    private void ReihenSumme(){
        System.out.println("Biite geben Sie die anZahl ein.");
        int anzahl = input.nextInt();
        System.out.println("Biite geben Sie eine werte fuer x ein.");
        double x= input.nextDouble();
        double reihenSumme = MathFunctions.berechneReihensumme(anzahl,x);
        System.out.println("Die Reihensumme ist :" + reihenSumme);
    }

    /**
     * Diese Methode stellt das Interface des Progamms da und ist mit der User die Wichtigste Interaction.
     */
    private void menueAusgabe(){
        System.out.println(TEILLERSUMME + " :Die Teilersumme von ein positive Naturliche Zahl berechnen.\n" +
            ISBN_PRUFFZIFFER + ": isbn ziffer pruffen \n" +
            NULL_STELLEN_FUER_QUADRATIC_GLEICHERUNG +": Nullstelle fuer Quadraticgleicherung berechnen \n" +
            SUMME_VON_POTENZEN_BERECHNEN +":Die Summe von drei Potenzen eine beliebigen Zahl berechnen \n" +
            GGT_VON_ZWEI_ZAHLEN_BERECHNEN +":Die groester gemeinsamen Teiler zweier natuerlicher Zahlen berechnen \n" +
            FAKULTAET_BERECHNEN +":Die Fakultaet von einer natuerlicher Zahl berechnen \n" +
            REIHENSUMME_BERECHNEN +":Die Reihensumme von einer uebergebenen ganzen Zahl berechnen \n" +
            ENDE + "Programm \n"
        );
    }

    /**
     * der mathDialog konstruktor ist abgeruefen und gestartet
     */
    public static void main(String [] args){
        new MathDialog().start();
    }

}
