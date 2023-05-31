import java.util.*;
import java.io.*;
/**
 * Beschreiben Sie hier die Klasse LagerDialog.
 * 
 * @author (Grace Ntiwa Kanou & Sandra Hussong) 
 * @version (16.01.2023)
 */
public class LagerDialog
{
    //_______________________Konstanten______________________________

    private static final int STANDARTLAGER_ANLEGEN        =  1;
    private static final int LAGER_ANLEGEN                =  2;
    private static final int LAGER_LOESCHEN               =  3;
    private static final int LAGER_GROESSE                =  4;

    private static final int ARTIKEL_ANLEGEN              =  5;
    private static final int ARTIKEL_ENTFERNEN            =  6;
    private static final int ZUGANG_BUCHEN                =  7;
    private static final int ABGANG_BUCHEN                =  8;
    private static final int PREIS_EINES_ARTIKELS_AENDERN =  9;
    private static final int PREIS_ALLER_ARTIKEL_AENDERN  = 10;
    private static final int ARTIKEL_AUSGEBEN             = 11;
    private static final int ARTIKEL_ANZAHL               = 12; 

    private static final int BESTANDSLISTE_AUSGEBEN       = 13;
    
    private static final int ENDE                         =  0;

    //________________________Exceptions______________________________
    private static final String ERROR =  
        "Es ist ein Fehler aufgetreten.";

    //__________________________Scanner_______________________________
    private Scanner input;

    //________________________Attribute_______________________________

    private Lager lager;

    //______________________Konstruktoren______________________________

    /**
     * 
     */
    public LagerDialog()
    {
        lager = null;
        input = new Scanner(System.in);
    } 

    //_____________try-Block, Hauptschleife des Dialogs________________ 

    /**
     * 
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
     * 
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
        System.out.println("LAGER-VERWALTUNG\n\n" +

                           STANDARTLAGER_ANLEGEN + 
                           ": Standart-Lager anlegen\n" +
                           LAGER_ANLEGEN + 
                           ": Lager anlegen;\n" +
                           LAGER_LOESCHEN + 
                           ": Lager loeschen;\n" +
                           LAGER_GROESSE +
                           ": Lager groesse anzeigen;\n" +
                
                           ARTIKEL_ANLEGEN + 
                           ": Neuen Artikel anlegen;\n" +
                           ARTIKEL_ENTFERNEN + 
                           ": Artikel entfernen;\n" +
                           ZUGANG_BUCHEN + 
                           ": Zugang buchen;\n" +
                           ABGANG_BUCHEN + 
                           ": Abgang buchen;\n" +
                           PREIS_EINES_ARTIKELS_AENDERN + 
                           ": Preis eines Artikels ändern;\n" +
                           PREIS_ALLER_ARTIKEL_AENDERN + 
                           ": Preis aller Artikels ändern;\n" +
                           ARTIKEL_AUSGEBEN + 
                           ": Artikel ausgeben;\n" +
                           ARTIKEL_ANZAHL +
                           ": Anzahl der Artikel im Lager anzeigen;\n" +
                
                           BESTANDSLISTE_AUSGEBEN +
                           ": Bestandsliste anzeigen;\n" +
                            
                           ENDE + 
                           ": Vorgang beenden -> ");

    }

    
    //_____________Ausgabe, Auswerten der Benutzereingabe_________________
    
    /**
     * 
     */
    private void ausfuehrenFunktion(int funktion)
    {
        if(funktion == STANDARTLAGER_ANLEGEN)
        {
            standartlagerAnlegen();
        }
        else if(funktion == LAGER_ANLEGEN)
        {
            lagerAnlegen();
        }
        else if(funktion == LAGER_LOESCHEN)
        {
            lagerLoeschen();
        }
        else if(funktion == LAGER_GROESSE)
        {
            lagerGroesseAnzeigen();
        }
        else if(funktion == ARTIKEL_ANLEGEN)
        {
            artikelAnlegen();
        }
        else if(funktion == ARTIKEL_ENTFERNEN)
        {
            artikelEntfernen();
        }
        else if(funktion == ZUGANG_BUCHEN)
        {
            zugangBuchen();
        }
        else if(funktion == ABGANG_BUCHEN)
        {
            abgangBuchen();
        }
        else if(funktion == PREIS_EINES_ARTIKELS_AENDERN)
        {
            preisEinesArtikelsAendern();
        }
        else if(funktion == PREIS_ALLER_ARTIKEL_AENDERN)
        {
            preisAllerArtikelAendern();
        }
        else if(funktion == ARTIKEL_AUSGEBEN)
        {
            artikelAusgeben();
        }
        else if(funktion == ARTIKEL_ANZAHL)
        {
            artikelAnzahl();
        }
        else if(funktion == BESTANDSLISTE_AUSGEBEN)
        {
            bestandslisteAusgeben();
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

    
    //_________________Standart-Lager anlegen_________________________
    
    /**
     * 
     */
    private void standartlagerAnlegen()
    {
        if(lager != null)
        {
            System.out.println("Um ein neues Lager zu eröffnen muss das bestehende gelöscht werden.");
        }
        else
        {
            lager = new Lager();
    
            System.out.println("Ihr Standart-Lager wurde erstellt.\nEs umfasst " + Lager.MAX_ANZAHL + " Lagerplaetze.");
        }
    }

    
    //__________________________Lager anlegen_________________________
    
    /**
     * 
     */
    private void lagerAnlegen()
    {
        if(lager != null)
        {
            System.out.println("Um ein neues Lager zu eröffnen muss das bestehende gelöscht werden.");
        }

        else 
        {
            int lagerGroesse;
            System.out.println("Geben Sie die Anzahl der Lagerplätze ein.");
            lagerGroesse = input.nextInt();
            lager        = new Lager(lagerGroesse);

            System.out.println("Ihr Lager wurde erstellt.\nEs umfasst " + lagerGroesse + " Lagerplaetze.");
        }
    }

    
    //__________________________Lager loeschen_________________________
    
    /**
     * 
     */
    private void lagerLoeschen()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager");
        }

        lager = null;

        System.out.println("Ihr Lager wurde erfolgreich gelöscht.");
    }

    
    //___________________Lagergroesse ausgeben_____________________
    
    /**
     * 
     */
    private void lagerGroesseAnzeigen()
    {
        int lagerGroesse = lager.getLagerGroesse();

        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager"); 
        }
        else
        {
            System.out.println("Ihr Lager umfasst " + lagerGroesse + " Lagerplaetze.");
        } 
    }
    
    
    //_________________________Artikel anlegen________________________
    
    /**
     * 
     */
    private void artikelAnlegen()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager"); 
        }
        /*
         *  int     artikelNr;
         *  String  art;
         *  double  preis;
         *  int     bestand;
         *  Artikel artikel;
         *  
         *  System.out.println("Bitte geben Sie eine vierstellige Zahl als Artikelnummer ein.");
         *  artikelNr = input.nextInt();
         *  
         *  System.out.println("Bitte geben Sie die Art des Artikels an.");
         *  art = input.next();
         *  
         *  System.out.println("Bitte bestimmen Sie den Bestand des Artikels.");
         *  bestand = input.nextInt();
         *  
         *  System.out.println("Bitte bestimmen Sie den Preis des Artikels.");
         *  preis = input.nextDouble();
         *  
         *  artikel = new Artikel(artikelNr, art, bestand, preis);
         *  
         *  lager.legeAnArtikel(new Artikel(artikelNr, art, bestand, preis));
         */
        lager.legeAnArtikel( artikelErzeugen( input));
    }
    
    
    //_________________________Artikel erzeugen________________________
    
    /**
     * 
     */
    private Artikel artikelErzeugen(Scanner input) 
    {
        System.out.println("Artikelnummer: ");
        final int artikelnr = input.nextInt();
    
        System.out.println("Bestand: ");
        final int bestand = input.nextInt();
    
        System.out.println("Preis: ");
        final double preis = input.nextDouble();
    
        System.out.println("Art(CD/Video/Buch/Artikel): ");
        final String art = input.next();
    
        switch (art.toLowerCase()) 
        {
            case "cd":
            
            System.out.println("Interpret:");
            final String interpret = input.next();
    
            System.out.println("Titel:");
            final String titel =input.next();
    
            System.out.println("Anzahl der Titel:");
            final int anzahlTitel = input.nextInt();
    
            return new CD(artikelnr, bestand, preis, interpret, titel, anzahlTitel);
          
            //________________________________________________________________________
            
            case "video":
    
            System.out.println(" Titel:");
            final String videoTitel =  input.next();
    
            System.out.println("Spieldauer: ");
            final int spieldauer = input.nextInt();
    
            System.out.println("Jahr ");
            final int jahr = input.nextInt();
    
            return new Video(artikelnr, bestand, preis, videoTitel, spieldauer, jahr);
          
            //_________________________________________________________________________
            
            case "buch":
    
            System.out.println("Titel: ");
            final String buchTitel = input.next();
            
            System.out.println("Autor: ");
            final String autor = input.next();
            
            System.out.println("Verlag: ");
            final String verlag = input.next();
            
            return new Buch(artikelnr, bestand, preis, autor, buchTitel, verlag);
          
            //________________________________________________________________________
            
            case "artikel":
    
            return new Artikel(artikelnr,"" , bestand, preis);
          
            //________________________________________________________________________
            
            default:
            
            return new Artikel(artikelnr, "", bestand, preis);
        }
    }

    
    //______________________Artikel entfernen_____________________
    
    /**
     * artikelEntfernen Die
     */
    private void artikelEntfernen()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Artikel im Lager"); 
        }
        else
        {
            System.out.println("Geben Sie die Artikelnummer des Artikels, den Sie entfernen wollen, an"); 
            int artikelNr = input.nextInt();
            lager.entferneArtikel(artikelNr);
        }
    }

    
    //__________________________Zugang buchen_________________________
    
    /**
     * 
     */
    private void zugangBuchen()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager"); 
        }
        else
        {
            System.out.println("Geben Sie die Artikelnummer des Artikels, dessen Bestand geändert werden soll, an");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie die Menge, um die der Bestand geändert werden soll, an");
            int zugang = input.nextInt();
            lager.bucheZugang(artikelNr, zugang);
        }
    }

    
    //__________________________Abgang buchen_________________________
   
    /**
     * 
     */
    private void abgangBuchen()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager"); 
        }
        else
        {
            System.out.println("Geben Sie die Artikelnummer des Artikels, dessen Bestand geändert werden soll, an");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie die Menge, um die der Bestand geändert werden soll, an");
            int abgang = input.nextInt();
            lager.bucheAbgang(artikelNr, abgang);
        }
    }

    
    //___________________Preis eines Artikels ändern___________________
    
    /**
     * 
     */
    private void preisEinesArtikelsAendern()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Artikel in dem Lager"); 
        }
        else
        {
            System.out.println("Bestimmen Sie den neuen Preis des Artikels");
            System.out.println("Geben Sie die Artikelnummer des Artikels an, dessen Preis geändert werden soll.");
            int artikelNr = input.nextInt();
            System.out.println("Geben Sie den Prozentwert an, um den der Preis des Artikels geändert werden soll.");
            double prozent = input.nextDouble();
            lager.aenderePreisEinesArtikels(artikelNr, prozent);
        }
    }

    
    //__________________Preis aller Artikel ändern_________________
    
    /**
     * 
     */
    private void preisAllerArtikelAendern()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Artikel in dem Lager"); 
        }
        else
        {
            System.out.println("Geben Sie den Prozentwert, um den die Preise der Artikel geändert werden sollen, an.");
            double prozent = input.nextDouble();
            lager.aenderePreisAllerArtikel(prozent);
        }
    }

    
    //______________________Artikel ausgeben_____________________
    
    /**
     * 
     */
    private void artikelAusgeben()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Artikel im Lager"); 
        }
        
        System.out.println("Geben Sie den Index des Artikels an," + 
                           "den Sie sich anzeigen lassen wollen.");
        int index = input.nextInt();
        lager.getArtikel(index); 
    }

    
    //____________________Artikelanzahl ausgeben____________________
    
    /**
     * 
     */
    private void artikelAnzahl()
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager"); 
        }
        else
        {
            System.out.println("Es befinden sich " + lager.getArtikelAnzahl() + " Artikel im Lager");
        } 
    }
    
    
    //____________________Bestandsliste ausgeben____________________

    /**
     * bestandslisteAusgeben Gibt alle im Lager-Array enthaltenen Artikel aus.
     */
    private void bestandslisteAusgeben() 
    {
        if(lager == null)
        {
            System.out.println("Es existiert noch kein Lager"); 
        }
        
        System.out.println("Folgende Artikel befinden sich im Lager:\n");
        lager.ausgebenBestandsListe();
    }
    
    
    //__________________________Main Methode________________________
    
    /**
     * 
     */
    public static void main(String[] args) 
    {
        new LagerDialog().start();
    }
}