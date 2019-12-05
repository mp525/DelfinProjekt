//@Matti
package makeTestData;
import delfinen.Model.KonkurrenceResultat;
import delfinen.Model.Medlem;

import java.util.Random;

public class TestDataMaker {
    //de første 2 metoder jeg har lavet, er til undgåelse af gentagelse.
    public static String nameMaker(){
        Random rand = new Random();
        
        String[] a = {"Billie", "Bob", "John", "Paul", "Peter", "Børge", "Nanna"};       
        String[] b = {"Eiiirrlliish", "Roberts", "Kristensen", "Hansen", "Legaard", "Voigt", "Ciesla"};
        
        String name = a[rand.nextInt(6)] + " " + b[rand.nextInt(6)];

        return name;
        
    }
    
    public static String randomAktivitetsChooser(){
        Random aktivitetRand= new Random();
        
        String[] aktivitetsForm = {"Crawl", "Brystsvoemning", "Butterfly", "RygCrawl"};
        String disciplin = aktivitetsForm[aktivitetRand.nextInt(3)];
        
        return disciplin;
        
    }
    public static KonkurrenceResultat testDataMakekonkurrence() {
        KonkurrenceResultat k = null;
        
        Random rand = new Random();
        
        String konkurrenceNavn;

        String[] kNavn = {"Billies", "Bobs", "Johns", "Pauls", "Peters", "Børges", "Nannas"};
        konkurrenceNavn = kNavn[rand.nextInt(6)]+" cup";

        int placering = rand.nextInt(10);
        int tid1=rand.nextInt(59);
        double tid2= 0.1*rand.nextInt(59);
        double tid = tid1+tid2;
                
        String navn=nameMaker();

        String disciplin=randomAktivitetsChooser();
       
        k = new KonkurrenceResultat(konkurrenceNavn, placering, tid, navn, disciplin);

        return k;

    }
    public static Medlem testDataMedlem() {
       
        /* Designet med metoden er, at alle tilfælde, der i den virkelige verden 
        skulle kunne forekomme skal også forekomme i den random testDataMedlem 
        metoden, det samme gælder også alle de andre metoder i denne klasse*/
        
        Random rand = new Random();
        
        String navn1 =nameMaker();
        
        int ald = rand.nextInt(99)+1;
                       
        boolean aktiv=true;
        int tal;
        tal=rand.nextInt(1);
        
        if(tal==0){
        aktiv = false;
        }
            
        String akForm=randomAktivitetsChooser();

        Medlem medlem = new Medlem(ald, akForm, navn1, aktiv);
        
        System.out.println(medlem.toString());
        
        return medlem;
    }
}
