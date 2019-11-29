package delfinen.Model;

import delfinen.DataMapper.DataMapperKonkurrence;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

//@matti
public class KonkurrenceResultat implements ResultatI{
    private String konkurrence;
    private int placering;
    private double tid;
    private String medlemNavn;

    public KonkurrenceResultat(String konkurrence, int placering, double tid, String medlemNavn) {
        this.konkurrence = konkurrence;
        this.placering = placering;
        this.tid = tid;
        this.medlemNavn = medlemNavn;
    }

    @Override
    public void gemIDB() {
           try {
            DataMapperKonkurrence.konkurrenceInsert(this);
        } catch (SQLException ex) {
            System.out.println("SQLException");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
    }
    public static KonkurrenceResultat makekonkurrence(){
        KonkurrenceResultat k=null;
        Scanner s = new Scanner(System.in);
                
                
                System.out.println("Skriv konkurrence navn");
                String konkurrenceNavn;               
                konkurrenceNavn=s.nextLine();
                System.out.println("skriv placering");
                int placering = -1;
                
                    
                boolean isOn= true;
                
               while (isOn==true){
                   try{
                  
                placering=s.nextInt();
                
                s.nextLine();
                isOn= false;
               }catch(InputMismatchException e){
                        System.out.println("Input var ikke et tal");
                        System.out.println("Skriv et tal");
                        //placering = s.nextInt();
                        s.nextLine();
                        
                        
                        }
               }
               while(placering<1){
                   System.out.println("input var minus eller 0 som ikke er valid input");
                   placering =s.nextInt();
                   
               }
                //s.nextLine();
                System.out.println("skriv tid som for eksempel 21:16, hvor 21 er sekunder og 16 er milisekunder");
                double tid;
                tid=s.nextDouble();
                String navn;
                System.out.println("Skriv navn");
                navn=s.nextLine();
                 k = new KonkurrenceResultat(konkurrenceNavn,placering,tid,navn);
                    
                    
        return k;
        
    }
 
    public String getKonkurrence() {
        return konkurrence;
    }

    public void setKonkurrence(String konkurrence) {
        this.konkurrence = konkurrence;
    }

    public int getPlacering() {
        return placering;
    }

    public void setPlacering(int placering) {
        this.placering = placering;
    }

    public double getTid() {
        return tid;
    }

    public void setTid(double tid) {
        this.tid = tid;
    }

    public String getMedlemNavn() {
        return medlemNavn;
    }

    public void setMedlemNavn(String medlemNavn) {
        this.medlemNavn = medlemNavn;
    }

    
}
