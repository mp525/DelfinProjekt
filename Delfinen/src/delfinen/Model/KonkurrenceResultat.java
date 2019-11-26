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

    
}
