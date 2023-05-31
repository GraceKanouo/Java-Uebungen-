import java.lang.Math;
import java.util.InputMismatchException;
/**
 * Beschreiben Sie hier die Klasse MathFunctions.
 * 
 * @author (Ihr Name) 
 * @version (Grace dinecha Ntiwa && Sanda Hussong)
 */
public class MathFunctions
{
    private static final String ERROR_FALSCHE_DATEITYPE = "Dateitype is falsch";
    private static final String ERROR_FALSCHE_ISBN = "Bitte Geben Sie ein Isbn  mit 9 ziffer ein !!";
    private static final String KEINE_NATUERLICHE_ZAHL ="Natuerliche Zahl eingeben";
    private static final String WERT_DER_FAKULTAET_ZU_GROß_FUER_DATENTYP ="Fakultaet kann derzeit nicht berechnet werden";
    private static final String NULL_KANN_NICHT_GETEILT = "eine -zahl kann nicht durch null geteilt werden";
    private static final String ZAHL_MUSS_GROESER_NULL = "Die Zahl muss gröser null sein";

    
    /**
     * diese mehode berechnet die Teilsumme eine natuerlische Zahl.
     * @param  type long teilsumme
     * @ param type long zahl.
     * @return teilersumme.
     */
    public static long berechneTeilersumme(long zahl){
        long teilerSumme = 0;
        for (long teiler = 1; teiler < zahl; teiler++) {
            if (zahl % teiler == 0) {
                teilerSumme = teilerSumme + teiler;

            }else{
                throw new IllegalArgumentException(ERROR_FALSCHE_DATEITYPE);
            }
        }
        return teilerSumme;
    }

    /**
     * dieses Methode berechnet die Prüfziffer einer ISBN-10.
     * @param isbn bekommt einen 9-stelligen Wert 
     * @return Pruefziffereiner ISBN-10
     */
    public static String berechneChecksummeIsbn(long isbn){
        long summe = 0;
        int i= 9;

        if (String.valueOf(isbn).length()!=9){
            throw new IllegalArgumentException(ERROR_FALSCHE_ISBN);
        }
        while (isbn>0) {
            summe +=(isbn%10)*i;
            isbn =isbn/10;
            i--;
        }
        if(summe%11==10){
            return "X";
        }else{
            return "" + summe%11;
        }
    }

    /**
     * diese Methode berechnet die Nullstellen einer quadratische Gleischung.
     * @param diskriminant hilf uns zu wissen ob die Nullstelen reel, doppelte oder komplexe.
     * return value in String type
     */
    public static String berechneNullstellen(double p,double q){
        double diskriminant =Math.pow(p/q,2.0)-p;
        double x1 = 0.0;
        double x2 = 0.0;
        double konstante = 0.0000000001;
        double minusPHalbe = -(p/2.0);
        if (diskriminant >=0){
            x1 = minusPHalbe + Math.sqrt(diskriminant);
            x2 = minusPHalbe - Math.sqrt(diskriminant);
        }

        if (diskriminant>konstante){
            return "zwei reele Nullstellen" + x1 + "|" + x2;
        }else if (diskriminant<konstante && diskriminant >=-konstante){
            return "doppelte Nullstelle:" + x1;
        }else if (diskriminant<konstante ){
            return "komplexe Nullstelle";
        }else{  return String.valueOf(konstante);
        }
    } 

    /**
     * diese Methode pruft ob eine natürliche zahl kann als a4+b³+c² geschrieben weden.
     * @param zahl
     */
    static boolean istSummeVonPotenzen(long zahl){

        boolean antwort1 = true;
        boolean antwort2 = false;

        if (zahl < 1){
            throw new IllegalArgumentException(ZAHL_MUSS_GROESER_NULL);
        }
        for(int a = 1; a < zahl; a++){
            for( int b =1;b<zahl;b++){
                for(int c=1; c<zahl;c++) {
                    if(Math.pow(c,2)+Math.pow(b,3)+Math.pow(a,4)==zahl){
                        return antwort1; 
                    }  else{

                        return antwort2;

                    } 
                }
            }
        }
        return antwort1;
    }    

    /**
     * Die Methode berechnet die groesten gemeinsamen Teiler zweier natürlische zahlen.
     * @paran zahl1 und zahl2.
     * Wenn die  eine Zahl gleich null ist, gibt es eine Exception.
     * Null hat keine Teiler
     */
    static int berechneGgt(int zahl1, int zahl2){
        int ggt = 1;
        if(zahl1==0||zahl2==0){
            throw new IllegalArgumentException(KEINE_NATUERLICHE_ZAHL);
        }
        while(zahl1 != zahl2){
            if(zahl1 > zahl2){
                zahl1= zahl1 - zahl2;
            }else{
                zahl2= zahl2 - zahl1;
            }
            ggt = zahl1;
        }        
        return ggt;
    }

    /**
     * Die berechnetvoneiner natürlichen zahl die Fakultät.
     * @param Zahl
     */
    static long berechneFakultaet(int zahl){
        long fakultaet = 1;
        if (zahl < 0)
        {
            throw new IllegalArgumentException(KEINE_NATUERLICHE_ZAHL);
        }
        else if (zahl > 20)
        {
            throw new IllegalArgumentException(WERT_DER_FAKULTAET_ZU_GROß_FUER_DATENTYP);
        }
        for(int i = 1;i <= zahl;i++){
            fakultaet = fakultaet *i;
        }
        return fakultaet;
    }

    /**
     * Die Methode berechnetvon einer ganzen zahl und einen wert x eine mathematische funktion.
     * @param anzahl n,
     * @param x
     */
    static double berechneReihensumme(int anzahl, double x){
        double summe = 0.0;
        double werte1 = 0.0; 
        double werte2 = 0.0;
        if(x == 0){
            throw new IllegalArgumentException(NULL_KANN_NICHT_GETEILT);
        }
        for (int i=1;i<=anzahl;i++){
            werte1 = Math.pow((x-1),i);
            werte2 = i*Math.pow(x,i);
            summe  = werte1/werte2;
        }
        return summe;
    }

}
