package delfinen.Model;

import delfinen.DataMapper.DataMapperResultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Resultat implements ResultatI{
    private String tid;
    private String dato;
    private String medlemNavn;
    private String diciplin;
    private int længde;

    public Resultat(String tid, String dato, String medlemNavn, String diciplin, int længde) {
        this.tid = tid;
        this.dato = dato;
        this.medlemNavn = medlemNavn;
        this.diciplin = diciplin;
        this.længde = længde;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
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
