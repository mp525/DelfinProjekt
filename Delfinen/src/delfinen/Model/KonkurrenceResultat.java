package delfinen.Model;

import delfinen.DataMapper.DataMapperKonkurrence;
import delfinen.DataMapper.DataMapperMedlem;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
@Matti og @Mathias
*/

public class KonkurrenceResultat implements ResultatI{
    private String konkurrence;
    private int placering;
    private double tid;
    private String medlemNavn;
    private String disciplin;

    public KonkurrenceResultat(String konkurrence, int placering, double tid, String medlemNavn, String disciplin) {
        this.konkurrence = konkurrence;
        this.placering = placering;
        this.tid = tid;
        this.medlemNavn = medlemNavn;
        this.disciplin = disciplin;
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
                s.nextLine();
                String navn;
                System.out.println("Skriv navn");
                navn=s.nextLine();
                String disciplin = DataMapperMedlem.aktivitetsForm();
                 k = new KonkurrenceResultat(konkurrenceNavn,placering,tid,navn,disciplin);
                    
                    
        return k;
        
    }
 
    public String getKonkurrence() {
        return konkurrence;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
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
