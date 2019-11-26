package delfinen.Model;

import delfinen.ResultatI.ResultatI;


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

    @Override
    public void gemIDB() {
        
    }
    
    
    

}
