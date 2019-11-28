package delfinen.Model;

import delfinen.DataMapper.DataMapperMedlem;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Resultat implements ResultatI{
    private double tid;

    private String dato;
    private String medlemNavn;
    private String diciplin;
    private int længde;

    public Resultat(double tid, String dato, String medlemNavn, String diciplin, int længde) {
        this.tid = tid;
        this.dato = dato;
        this.medlemNavn = medlemNavn;
        this.diciplin = diciplin;
        this.længde = længde;
    }

    public static Resultat makeResultat() throws ClassNotFoundException, SQLException {
        DataMapperMedlem.medlemListe();
        Resultat resultat = null;
        Scanner scan = new Scanner(System.in);
        boolean isOn = true;
        while (isOn) {
            boolean isOn2 = true;
            String navn = "";
            while (isOn2) {
                System.out.println("Navnet på medlemmet du vil opdatere?:");
                navn = scan.nextLine();
                boolean exist = DataMapperMedlem.medlemTjek(navn);
                if (exist == false) {
                    System.out.println("Medlemmet existerer ikke. Opret medlem før der laves resultat på det.");
                } else{
                    isOn2 = false;
                }
            }
                System.out.println("Hvilken disciplin?:");
                String disciplin = scan.nextLine();
                System.out.println("Tast længde svømmet:");
                int længde = scan.nextInt();
                scan.nextLine();
                System.out.println("På hvilken tid?:");
                double tid = scan.nextDouble();
                System.out.println("Skriv dato;");
                String dato = scan.nextLine();
                isOn = false;
                resultat = new Resultat(tid, dato, navn, disciplin, længde);
            }

            return resultat;
        }

    

    public double getTid() {
        return tid;
    }

    public void setTid(double tid) {
        this.tid = tid;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getMedlemNavn() {
        return medlemNavn;
    }

    public void setMedlemNavn(String medlemNavn) {
        this.medlemNavn = medlemNavn;
    }

    public String getDiciplin() {
        return diciplin;
    }

    public void setDiciplin(String diciplin) {
        this.diciplin = diciplin;
    }

    public int getLængde() {
        return længde;
    }

    public void setLængde(int længde) {
        this.længde = længde;
    }

    @Override
    public void gemIDB() {
        try {
            DataMapperResultat.resultatInsert(this);
        } catch (SQLException ex) {
            System.out.println("SQLException");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
    }

    @Override
    public String toString() {
        String result;
        result = "Resultat for " + getMedlemNavn() + " i " + getDiciplin() + " {Længde: " + getLængde() + "m, Tid: " + getTid() + "s, Dato: " + getDato() + "}";
        return result;
    }

}
