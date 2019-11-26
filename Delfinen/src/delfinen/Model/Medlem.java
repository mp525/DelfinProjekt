package delfinen.Model;


public class Medlem {
    private int alder;
    private String aktivitetsForm;
    private int kontingentBetaling;
    private boolean aktiv;
    private String navn;

    public Medlem(int alder, String aktivitetsForm, String navn, boolean aktiv) {
        this.alder = alder;
        this.aktivitetsForm = aktivitetsForm;
        this.aktiv = aktiv;
        this.kontingentBetaling = kontingentBetaling();
        this.navn = navn;
    }
    
    
    
}

