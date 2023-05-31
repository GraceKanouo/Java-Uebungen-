import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Beschreiben Sie hier die Klasse Dialog.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Dialog
{
    private int getraenkTyp;
    private int typ;

    private Getraenkeautomat<Wein> weinautomat;
    private Getraenkeautomat<Wasser> wasserautomat;
    private Getraenkeautomat<Softdrink> softdrinkautomat;
    private Getraenkeautomat<Rotwein> rotweinautomat;
    private Getraenkeautomat<Weisswein> weissweinautomat;
    private Getraenkeautomat<Getraenk> getraenkeautomat;
    private Getraenkeautomat<Bier> bierautomat;
    private Getraenkeautomat<AlkoholfreiesGetraenk> alkoholfreierGetrankautomat;
    private Getraenkeautomat<AlkoholischesGetraenk> alkoholischerGetraenkeautomat;
    //_______________________Konstanten______________________________

    private static final int AUTOMAT_ANLEGEN             = 1;
    private static final int FLASCHE_EINLEGEN            = 2;
    private static final int FLASCHE_AUSGEBEN            = 3;
    private static final int AUTOMAT_STATUS              = 4;
    private static final int ENDE                        = 0;

    private static final int FUNKTION_NICHT_DEFINIERT       = -1;
    private static final int FUNKTION_ENDE                   = 0;
    private static final int FUNKTION_AUTOMAT_ANLEGEN        = 1;
    private static final int FUNKTION_FLASCHE_EINGEBEN       = 2;
    private static final int FUNKTION_FLASCHE_AUSGEBEN       = 3;
    private static final int FUNKTION_AUTOMAT_AUSGEBEN       = 4;

    private static final int AUTOMAT_GETRAENK                = 1;
    private static final int AUTOMAT_ALKOHOLFREIESGETRAENK   = 2;
    private static final int AUTOMAT_SOFTDRINK               = 3;
    private static final int AUTOMAT_WASSER                  = 4;
    private static final int AUTOMAT_ALKOHOLISCH             = 5;
    private static final int AUTOMAT_BIER                    = 6;
    private static final int AUTOMAT_WEIN                    = 7;
    private static final int AUTOMAT_WEISSWEIN               = 8;
    private static final int AUTOMAT_ROTWEIN                 = 9;

    private Scanner scan; 
    public Dialog ()
    {
        this.scan =new Scanner(System.in);
    }

    public void start()
    { int funktion = -1;

        while(funktion != ENDE) {
            try {
                menueAusgeben();
                funktion = eingabe();
                ausfuehrenFunktion(funktion);

            }
            catch(GetraenkeautomatException message) {
                System.err.println(message);

            } 
            catch(FlascheException message){
                 System.err.println(message);
            }
            catch(GetraenkException message){
                 System.err.println(message);
            }
            catch(InputMismatchException e) {
                System.err.println(e);
                scan.next();

            } catch(Exception e) {
                System.err.println(e);
                e.printStackTrace(System.out); 

            }
        }      

    }

    /**
     * eingabe nimmt eine Usereingabe und speichert diese in die Variable 
     * option der Hauptprogrammschleife. 
     * @return  Integer, der in der Variablen option gespeichert wird.
     */
    private int eingabe()
    {
        int funktion = scan.nextInt();
        scan.nextLine();
        return funktion;
    }

    /**
     * gibt Hauptmenü auf Bildschirm aus
     */
    public void menueAusgeben()
    {

        System.out.print(
            "\n\n" +
            AUTOMAT_ANLEGEN        + ": Getraenkeautomat anlegen;\n"  + 
            FLASCHE_EINLEGEN       + ": Flasche einlegen;\n"          +
            FLASCHE_AUSGEBEN       + ": Flasche ausgeben;\n"          + 
            AUTOMAT_STATUS         + ": Getraenkeautomatausgeben;\n"  +
            ENDE                   + ": beenden -> \n\n" 
        );

    }

    /**
     * Diese Funktion fuehrt je nach Parameter die dazugehoerige Funktion aus
     * @param funktion die ausgefuehrt werden soll
     */
    private void ausfuehrenFunktion(int funktion) {
        switch(funktion) {
            case AUTOMAT_ANLEGEN:
                automatAnlegen();
                break;  
            case FLASCHE_EINLEGEN:
                flascheEinlegen();
                break;
            case FLASCHE_AUSGEBEN:
                flascheAusgeben();
                break;  
            case AUTOMAT_STATUS:
                if(getraenkeautomat.getKapazitaet() != 0) {
                    System.out.println(getraenkeautomat.toString());    
                }
                else{
                    System.out.println("Es gibt keinen Automaten");
                }

                break;
            case ENDE:  
                System.out.println("Das Programm ist zu Ende");
                break;
            default:
                System.out.println("Ugültige Eingabe");
                break;
        }

    }

    /**
     * 
     */
    public  void automatAnlegen() {
        this.typ = -1;
        while(typ != 0)
        {
            try {
                getraenkeAutomatArtEinlesen();
                anlegenAutomatArt();

            }  catch(GetraenkeautomatException message) {
                System.err.println(message);

            } 
            catch(FlascheException message){
                 System.err.println(message);
            }
            catch(GetraenkException message){
                 System.err.println(message);
            }
            catch(InputMismatchException e) {
                System.err.println(e);
                scan.next();

            } catch(Exception e) {
                System.err.println(e);
                e.printStackTrace(System.out); 

            }
        }

    }

    private void getraenkeAutomatArtEinlesen() {
        System.out.print(
            "\n\n" +
            AUTOMAT_GETRAENK                 + ": Getraenkeautomat fuer alle Getraenke anlegen;\n"  + 
            AUTOMAT_ALKOHOLFREIESGETRAENK    + ": Getraenkeautomat fuer alkoholfreie Getraenke anlegen;\n"  + 
            AUTOMAT_SOFTDRINK                + ": Getraenkeautomat fuer Sofdrinks anlegen;\n"  + 
            AUTOMAT_WASSER                   + ": Getraenkeautomat fuer alle Wasser anlegen;\n"  + 
            AUTOMAT_ALKOHOLISCH              + ": Getraenkeautomat fuer alkoholische Getraenke anlegen;\n"  + 
            AUTOMAT_BIER                     + ": Getraenkeautomat fuer Bier anlegen;\n"  + 
            AUTOMAT_WEIN                     + ": Getraenkeautomat fuer Wein anlegen;\n"  + 
            AUTOMAT_WEISSWEIN                + ": Getraenkeautomat fuer Weisswein anlegen;\n"  + 
            AUTOMAT_ROTWEIN                  + ": Getraenkeautomat fuer Rotwein anlegen;\n"  + 
            FUNKTION_ENDE                    + ": beenden -> \n\n"
        );

        System.out.println("Wahlen sie biite aus ");
        this.typ = scan.nextInt();
        scan.nextLine();
        System.out.println("Sie haben: " + this.typ + " ausgewählt");    
    }

    private void anlegenAutomatArt() {
        int kapazitaet = 0;

        if(this.typ != 0) {
            System.out.println("Geben Sie die max. Kapazitaet des Automaten an:");
            kapazitaet = scan.nextInt();    
        }
        System.out.println("Ihre Automat wird erfolgreich angelegt mit Kapzität: "+ kapazitaet + "\n");
        switch(this.typ) {
            case AUTOMAT_GETRAENK:
                this.getraenkeautomat = new Getraenkeautomat<Getraenk>(kapazitaet);
                System.out.println("Sie bekommen in kurzem einem Getränk ");
                break;  
            case AUTOMAT_ALKOHOLFREIESGETRAENK:
                this.alkoholfreierGetrankautomat = new Getraenkeautomat<AlkoholfreiesGetraenk>(kapazitaet);
                System.out.println("Sie bekommen in kurzem einem Alkoholfreies Getränk ");
                break; 
            case AUTOMAT_SOFTDRINK:
                this.softdrinkautomat = new Getraenkeautomat<Softdrink>(kapazitaet);
                System.out.println("Sie bekommen in kurzem einen Softdrink ");
                break; 
            case AUTOMAT_WASSER:
                this.wasserautomat = new Getraenkeautomat<Wasser>(kapazitaet);
                System.out.println("Sie bekommen in kurzem Wasser ");
                break; 
            case AUTOMAT_ALKOHOLISCH:
                this.alkoholischerGetraenkeautomat = new Getraenkeautomat<AlkoholischesGetraenk>(kapazitaet);
                System.out.println("Sie bekommen in kurzem einem Alkoholiches Getränk ");
                break; 
            case AUTOMAT_BIER:
                this.bierautomat = new Getraenkeautomat<Bier>(kapazitaet);
                System.out.println("Sie bekommen in kurzem Bier ");
                break;   
            case AUTOMAT_WEIN:
                this.weinautomat = new Getraenkeautomat<Wein>(kapazitaet);
                System.out.println("Sie bekommen in kurzem wein ");
                break; 
            case AUTOMAT_WEISSWEIN:
                this.weissweinautomat = new Getraenkeautomat<Weisswein>(kapazitaet);
                System.out.println("Sie bekommen in kurzem wieswein ");
                break;
            case AUTOMAT_ROTWEIN:
                this.rotweinautomat = new Getraenkeautomat<Rotwein>(kapazitaet);
                System.out.println("Sie bekommen in kurzem Rotwein ");
                System.out.println(rotweinautomat.toString());
                break;
            case FUNKTION_ENDE:  
                System.out.println("Die Schleife ist zu Ende");
                break;
            default:
                System.out.println("Keine gueltige Eingabe");
                break;
        }    
    }

    private void flascheAusgeben() {
        if(getraenkeautomat != null) {
            Flasche flasche = getraenkeautomat.flascheAusgeben();

            System.out.println(getraenkeautomat.flascheAusgeben() + "flasche.toString()");    

        } else {
            System.out.println("Es gibt keinen Automaten");
        }
    }

    private void flascheEinlegen() {
        Getraenk getraenk = new Wasser();

        String hersteller;
        float alkoholgehalt;
        if(getraenkeautomat.getKapazitaet() != 0) {

            System.out.println("\n\n"                                    + 
                "1: "+ "AUTOMAT_GETRAENK"                + "\n" +
                "2: " + "AUTOMAT_SOFTDRINK"               + "\n" +
                "3: " + "AUTOMAT_WASSER"                  + "\n" +
                "4: " + " AUTOMAT_ALKOHOLFREIESGETRAENK " + "\n" +
                "5: " + "AUTOMAT_WEIN "                   + "\n" +
                "6: " + "AUTOMAT_ROTWEIN "                + "\n" +
                "7: " + "AUTOMAT_WEISSWEIN "              + "\n" +
                "8: " + "AUTOMAT_BIER "                   + "\n" 
            );
            System.out.println("Wahlen sie ein Funktion: ");
                    this.typ = scan.nextInt();
                    scan.nextLine();
                    System.out.println();
            
            switch(this.typ) {
                case AUTOMAT_GETRAENK:         
                    System.out.print(
                        "\n\n"   +
                        "1: "    + "Softdrink" + "\n" +
                        "2: "    + "Wasser"    + "\n" +
                        "3: "    + "Bier"      + "\n" +
                        "4: "    + "Wein"      + "\n" +
                        "5: "    + "Weisswein" + "\n" +
                        "6: "    + "Rotwein"   + "\n" 
                    );

                    System.out.println("Wahlen sie ein Funktion: ");
                    this.getraenkTyp = scan.nextInt();
                    scan.nextLine();
                    System.out.println();  

                    switch(this.getraenkTyp) {
                        case 1:
                            getraenk = erstelleSoftDrink();
                            break;
                        case 2:
                            getraenk = erstelleWasser();
                            break;
                        case 3:
                            getraenk = erstelleBier();
                            break;
                        case 4:
                            getraenk = erstelleWein(); 
                            break;
                        case 5:
                            getraenk = erstelleWeissWein();
                            break;
                        case 6:
                            getraenk = erstelleRotWein();
                            break;
                        default:
                            System.out.println("Keine gueltige Eingabe");
                            break;
                    }

                    Flasche<Getraenk>  fgetraenk = new Flasche<Getraenk>();
                    fgetraenk.fuellen(getraenk);
                    getraenkeautomat.flascheEinlegen(fgetraenk);
                    break;  
                case AUTOMAT_ALKOHOLFREIESGETRAENK:
                    System.out.print(
                        "\n\n" +
                        
                        "1: "    + "Softdrink" + "\n" +
                        "2: "    + "Wasser" + "\n" 
                    );

                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkTyp = scan.nextInt();
                    scan.nextLine();
                    System.out.println();  

                    switch(this.getraenkTyp) {
                        case 1:
                            getraenk = erstelleSoftDrink();
                            break;
                        case 2:
                            getraenk = erstelleWasser();
                            break;
                        default:
                            System.out.println("Keine gueltige Eingabe");
                            break;
                    }

                    Flasche<AlkoholfreiesGetraenk>  falkfrei = new Flasche<AlkoholfreiesGetraenk>();
                    falkfrei.fuellen((AlkoholfreiesGetraenk)getraenk);
                    alkoholfreierGetrankautomat.flascheEinlegen(falkfrei);
                    break; 
                case AUTOMAT_SOFTDRINK:
                    getraenk = erstelleSoftDrink();
                    Flasche<Softdrink>  fsoft = new Flasche<Softdrink>();
                    fsoft.fuellen((Softdrink)getraenk);
                    softdrinkautomat.flascheEinlegen( fsoft);
                    break; 

                case AUTOMAT_WASSER:
                    getraenk = erstelleWasser();
                    Flasche<Wasser>  fwasser = new Flasche<Wasser>();
                    fwasser.fuellen((Wasser)getraenk);
                    wasserautomat.flascheEinlegen( fwasser); 
                    break; 
                case AUTOMAT_ALKOHOLISCH:
                    System.out.print(
                        "\n\n" +
                        "1: "    + "Bier" + "\n" +
                        "2: "    + "Wein" + "\n" +
                        "3: "    + "Weisswein" + "\n" +
                        "4: "    + "Rotwein"   
                    );

                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkTyp = scan.nextInt();
                    scan.nextLine();
                    System.out.println();  
                    switch(this.getraenkTyp) {
                        case 1:
                            getraenk = erstelleBier();
                            break;
                        case 2:
                            getraenk = erstelleWein();   
                            break;
                        case 3:
                            getraenk = erstelleWeissWein();
                            break;
                        case 4:
                            getraenk = erstelleRotWein();
                            break;
                        default:
                            System.out.println("Keine gueltige Eingabe");
                            break;
                    }
                    Flasche<AlkoholischesGetraenk>  falk = new Flasche<AlkoholischesGetraenk>();
                    falk.fuellen((AlkoholischesGetraenk)getraenk);
                    alkoholischerGetraenkeautomat.flascheEinlegen(falk);
                    break; 

                case AUTOMAT_BIER:
                    getraenk = erstelleBier();
                    Flasche<Bier>  fbier = new Flasche<Bier>();
                    fbier.fuellen((Bier)getraenk);
                    bierautomat.flascheEinlegen(fbier);
                    break; 

                case AUTOMAT_WEIN:
                    System.out.print(
                        "\n\n" +
                        "1: "    + "Wein" + "\n" +
                        "2: "    + "Weisswein" + "\n" +
                        "3: "    + "Rotwein"   
                    );

                    System.out.println("Ausgewählte Funktion: ");
                    this.getraenkTyp = scan.nextInt();
                    scan.nextLine();
                    System.out.println();  
                    switch(this.getraenkTyp) {
                        case 1:
                            getraenk = erstelleWein();   
                            break;
                        case 2:
                            getraenk = erstelleWeissWein();
                            break;
                        case 3:
                            getraenk = erstelleRotWein();
                            break;
                        default:
                            System.out.println("Keine gueltige Eingabe");
                            break;
                    }
                    Flasche<Wein>  fwein = new Flasche<Wein>();
                    fwein.fuellen((Wein)getraenk);
                    weinautomat.flascheEinlegen(fwein);
                    break; 
                case AUTOMAT_WEISSWEIN:
                    getraenk = erstelleWeissWein();
                    Flasche<Weisswein>  fwwein = new Flasche<Weisswein>();
                    fwwein.fuellen((Weisswein)getraenk);
                    weissweinautomat.flascheEinlegen(fwwein);
                    break;
                case AUTOMAT_ROTWEIN:
                    getraenk = erstelleRotWein();
                    Flasche<Rotwein>  frwein = new Flasche<Rotwein>();
                    frwein.fuellen((Rotwein)getraenk);
                    rotweinautomat.flascheEinlegen(frwein);
                    break;
                default:
                    System.out.println("Keine gueltige Eingabe");
                    break;
            }   

        } else{
            System.out.println("Keine gueltige Eingabe");
        }
    }

    private Softdrink erstelleSoftDrink() 
    {
        String hersteller = scan.nextLine();  
        System.out.println("Geben Sie den Zuckergehalt an:");
        float zuckergehalt = scan.nextFloat(); 
        scan.nextLine();
        return new Softdrink(hersteller, zuckergehalt);
    }

    private Wasser erstelleWasser() 
    {
        System.out.println("Geben Sie den Hersteller an:");
        String hersteller = scan.nextLine();  
        System.out.println("Geben Sie die Quelle an:");
        String quelle = scan.nextLine();
        System.out.println("Wasser "+ hersteller + "" + quelle);
        return new Wasser(hersteller, quelle);
    }

    private Bier erstelleBier() 
    {   
        System.out.println("Geben Sie den Alkoholgehalt an:");
        float alkoholgehalt = scan.nextFloat();  
        scan.nextLine();
        System.out.println("Geben Sie die Brauerei an:");
        String brauerei = scan.nextLine();  
        System.out.println("Bier "+ alkoholgehalt + "" +brauerei);
        return new Bier(alkoholgehalt, brauerei);
    }

    private Wein erstelleWein()
    {
        System.out.println("Geben Sie den Alkoholgehalt an:");
        float alkoholgehalt = scan.nextFloat();  
        scan.nextLine();
        System.out.println("Geben Sie das Weingut an:");
        String weingut = scan.nextLine(); 
        System.out.println("Wein "+ alkoholgehalt + "" + weingut);
        return new Wein( alkoholgehalt, weingut);
    }

    private Weisswein erstelleWeissWein()
    {
        System.out.println("Geben Sie den Alkoholgehalt an:");
        float alkoholgehalt = scan.nextFloat();  
        scan.nextLine();
        System.out.println("Geben Sie das Weingut an:");
        String weingut = scan.nextLine();
        System.out.println("Weisswein "+ alkoholgehalt + "" + weingut);
        return new Weisswein(alkoholgehalt, weingut);
    }

    private Rotwein erstelleRotWein() 
    { 
        System.out.println("Geben Sie den Alkoholgehalt an:");
        float alkoholgehalt = scan.nextFloat();  
        scan.nextLine();
        System.out.println("Geben Sie das Weingut an:");
        String weingut = scan.nextLine();  
        System.out.println("Rotwein "+ alkoholgehalt + "" + weingut);
        return new Rotwein(alkoholgehalt, weingut);
    }

    public static void main(String[] args)
    {
        Dialog run = new Dialog();
        run.start();
    }
}

