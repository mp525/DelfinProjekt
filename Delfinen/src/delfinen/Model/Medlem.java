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

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getAktivitetsForm() {
        return aktivitetsForm;
    }

    public void setAktivitetsForm(String aktivitetsForm) {
        this.aktivitetsForm = aktivitetsForm;
    }

    public int getKontingentBetaling() {
        return kontingentBetaling;
    }

    public void setKontingentBetaling(int kontingentBetaling) {
        this.kontingentBetaling = kontingentBetaling;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int kontingentBetaling() {
        if (this.aktiv == false) {
            this.kontingentBetaling = 500;
            return kontingentBetaling;
        } else if (this.alder < 18) {
            kontingentBetaling = 1000;
        } else if (18 <= this.alder && 60 > this.alder) {
            kontingentBetaling = 1600;
        } else if (60 <= this.alder) {
            kontingentBetaling = 1200;
        }

        return kontingentBetaling;
    }
}
