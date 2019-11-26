package delfinen.View;

public class MainMenu {

    public static void visHovedMenu() {
        System.out.println("");
        System.out.println("\t\tHovedmenu:");
        System.out.println("");
        System.out.println("Indtast tal for at identificere dig. Afslut med Enter.");
        System.out.println("");
        System.out.println("1) Formand");
        System.out.println("2) Kassér");
        System.out.println("3) Træner");
        System.out.println("4) Afslut program");
    }
    
    public static void visFormandMenu() {
        System.out.println("");
        System.out.println("\t\tVelkommen Formand");
        System.out.println("");
        System.out.println("Indtast tal for at vælge operation. Afslut med Enter.");
        System.out.println("");
        System.out.println("1) Opret nyt medlem");
        System.out.println("2) Ret eksisterende medlem");
        System.out.println("3) Slet eksisterende medlem");
        System.out.println("4) Se medlemsliste");
        System.out.println("5) Tilbage til hovedmenu");
    }
    
    public static void visKasserMenu() {
        System.out.println("");
        System.out.println("\t\tVelkommen Kassér");
        System.out.println("");
        System.out.println("Indtast tal for at vælge operation. Afslut med Enter.");
        System.out.println("");
        System.out.println("1) Se medlemsliste");
        System.out.println("2) Se restance på medlemmer");
        System.out.println("3) Tilbage til hovedmenu");
    }
    
    public static void visTraenerMenu() {
        System.out.println("");
        System.out.println("\t\tVelkommen Træner");
        System.out.println("");
        System.out.println("Indtast tal for at vælge operation. Afslut med Enter.");
        System.out.println("");
        System.out.println("1) Se medlemsliste");
        System.out.println("2) Tilføj ny rekord til medlem");
        System.out.println("3) Tilføj stævneresultat til medlem");
        System.out.println("4) Se top 5 konkurrencesvømmere");
        System.out.println("5) Se liste over rekorder for medlemmer");
        System.out.println("6) Se liste over stævner for medlemmer");
        System.out.println("7) Tilbage til hovedmenu");
    }
}
