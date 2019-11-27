package delfinen.Model;

import delfinen.ResultatI.ResultatI;


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
