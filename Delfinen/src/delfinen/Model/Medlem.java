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
        this.aktiv = aktiv;
    }
    
    
    public int kontingentBetaling(){
        if(this.aktiv=false){
            kontingentBetaling=500;
            return kontingentBetaling;
        }                        
        else if(this.alder<18){
            kontingentBetaling=1000;
        }
        else if(18<=this.alder && 60>this.alder){
            kontingentBetaling=1600; 
        }
    else if(60<=this.alder){
            kontingentBetaling=1200;
            }
    return kontingentBetaling;
}
}

