package delfinen.Model;
//@Matti
import delfinen.DataMapper.DataMapperMedlem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Medlem {
    
    /*
    @Vibeke
    */

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

    public static Medlem makeMedlem() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Indtast navn for nyt medlem: ");
        String navn1 = sc.nextLine();
        
        int ald = 0;
        boolean isOn = true;
        while(isOn == true) {
            System.out.println("Indtast alder for nyt medlem: ");
            
            try {
                ald = sc.nextInt();
                sc.nextLine();
                isOn = false;
                
            } catch (InputMismatchException e) {
                System.out.println("Input var ikke et tal. Prøv igen.");
                sc.nextLine();
            }
        }
        
        System.out.println("Indtast disciplin for nyt medlem: ");
        String akForm = DataMapperMedlem.aktivitetsForm();

        boolean answered = false;
        boolean aktiv = false;
        System.out.println("Er medlemmet aktiv? y/n");
        while (!answered) {

            String answer = sc.nextLine();
            if(answer.equals("y")) {
                aktiv = true;
                answered = true;
            } else if(answer.equals("n")) {
                aktiv = false;
                answered = true;
            } else {
                System.out.println("Forkert input. Er medlemmet aktiv? y/n");
            }
            
        }

        Medlem medlem = new Medlem(ald, akForm, navn1, aktiv);
        return medlem;
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

    @Override
    public String toString() {
        String result;
        result = "Medlemmets navn: " + getNavn() + ", Alder: " + getAlder() + ", Aktivitetsform: " + getAktivitetsForm() + ", Kontingent: " + getKontingentBetaling() + "kr";
        return result;
    }
    
}
