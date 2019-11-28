package delfinen.DataMapper;

import delfinen.Model.KonkurrenceResultat;
import delfinen.Model.Medlem;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataMapperMedlem {

    public static void medlemInsert(Medlem medlem) throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;

        myConnector = DBConnector.getConnector();

        String query = "insert into medlemmer (Alder, AktivitetsForm, kontingentBetaling, Aktiv, Navn) values (?, ?, ?, ?, ?);";
        pstmt = myConnector.prepareStatement(query);
        pstmt.setInt(1, medlem.getAlder());
        pstmt.setString(2, medlem.getAktivitetsForm());
        pstmt.setInt(3, medlem.getKontingentBetaling());
        pstmt.setBoolean(4, medlem.isAktiv());
        pstmt.setString(5, medlem.getNavn());

        pstmt.execute();

        pstmt.close();
        myConnector.close();
    }

    public static void medlemUpdate() throws ClassNotFoundException, SQLException {
        
        Connection myConnector = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        Statement statement = null;
        ResultSet resultSet = null;

        ArrayList<String> myArr = new ArrayList<>();

        myConnector = DBConnector.getConnector();

        String search = "select navn from medlemmer";

        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(search);
        
        //Laver en arrayliste der hurtigt kan søges igennem for navne i databasen:
        while (resultSet.next()) {
            String navne = resultSet.getString("Navn");
            myArr.add(navne);
        }

        //Får navn til søgning i arrayliste:
        System.out.println("Indtast det fulde navn på det medlem du vil ændre informationer på: ");
        String navn = sc.nextLine();

        //En switch til at opdatere information i databasen:
        if (myArr.contains(navn)) {
            boolean quit = false;
            
            while(quit == false) {
                tekst();
                
                String brugerInput = sc.nextLine();
                
                switch(brugerInput) {
                    case "1":
                        
                        boolean isOn1 = true;
                        int ald = 0;
                        
                        while(isOn1) {
                        System.out.println("Hvad er den nye alder?");
                        
                        try {
                        ald = sc.nextInt();
                        sc.nextLine();
                        isOn1 = false;
                        
                        } catch(InputMismatchException e) {
                            System.out.println("");
                            sc.nextLine();
                        }
                        }
                        
                        String query1 = "UPDATE medlemmer set Alder = (?) WHERE Navn = (?)";

                        pstmt = myConnector.prepareStatement(query1);
                        pstmt.setInt(1, ald);
                        pstmt.setString(2, navn);

                        pstmt.execute();

                        System.out.println("Alderen for medlemmet er blevet ændret.");
                        
                        
                        break;
                        
                    case "2":
                        
                        String akForm = aktivitetsForm();
            
                        String query2 = "UPDATE medlemmer set AktivitetsForm = (?) WHERE Navn = (?)";

                        pstmt = myConnector.prepareStatement(query2);
                        pstmt.setString(1, akForm);
                        pstmt.setString(2, navn);

                        pstmt.execute();

                        System.out.println("Aktivitetsformen for medlemmet er blevet ændret.");
                        
                        break;
                        
                    case "3":
                        
                        System.out.println("Hvad er den nye status for aktiv/passivt medlemsskab? a/p");
                        String stat = sc.nextLine();
                        //sc.nextLine();
                        boolean status = false;
                        boolean isOn3 = true;
                        
                        while(isOn3) {
                        if(stat.contains("a")) {
                            status = true;
                            
                            String query3 = "UPDATE medlemmer set Aktiv = (?) WHERE Navn = (?)";

                            pstmt = myConnector.prepareStatement(query3);
                            pstmt.setBoolean(1, status);
                            pstmt.setString(2, navn);

                            pstmt.execute();

                            System.out.println("Statusen for medlemmet er blevet ændret.");
                        
                            isOn3 = false;
                            
                        } else if(stat.contains("p")) {
                            status = false;
                            
                            String query3 = "UPDATE medlemmer set Aktiv = (?) WHERE Navn = (?)";

                            pstmt = myConnector.prepareStatement(query3);
                            pstmt.setBoolean(1, status);
                            pstmt.setString(2, navn);
                        
                            pstmt.execute();

                            System.out.println("Statusen for medlemmet er blevet ændret.");
                            
                            isOn3 = false;
                            
                        } else {
                            System.out.println("Forkert indtastning. Tast a for aktiv eller p for passiv");
                            stat = sc.nextLine();
                        }
                        }
                        
                        break;
                        
                    case "4":
                        
                        System.out.println("Hvad er det nye navn for medlemmet?");
                        String nyNavn = sc.nextLine();
                        //sc.nextLine();
            
                        String query4 = "UPDATE medlemmer set Navn = (?) WHERE Navn = (?)";

                        pstmt = myConnector.prepareStatement(query4);
                        pstmt.setString(1, nyNavn);
                        pstmt.setString(2, navn);

                        pstmt.execute();
                        
                        navn = nyNavn;

                        //pstmt.close();
                        //myConnector.close();

                        System.out.println("Navnet for medlemmet er blevet ændret.");
                        
                        break;
                        
                    case "5":
                        quit = true;
                        System.out.println("Redigering er færdig.");
                        break;
                        
                    default: {
                        System.out.println("Noget gik galt. Kommandoen kunne ikke udføres.");
                    }
                }
            }

            //pstmt.close();
            myConnector.close();
            
        } else {
            System.out.println("Det valgte medlem eksisterer ikke i databasen.");
        }
        
        //pstmt.close();
        //statement.close();
        resultSet.close();
        myConnector.close();
    }

    public static void medlemDelete() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        Statement statement = null;
        ResultSet resultSet = null;

        ArrayList<String> myArr = new ArrayList<>();

        myConnector = DBConnector.getConnector();

        String search = "select navn from medlemmer";

        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(search);
        while (resultSet.next()) {
            String navne = resultSet.getString("Navn");
            myArr.add(navne);
        }

        System.out.println("Indtast det fulde navn på det medlem du vil melde ud af klubben: ");
        String navn = sc.nextLine();

        if (myArr.contains(navn)) {
            String query = "DELETE FROM medlemmer WHERE Navn = (?)";

            pstmt = myConnector.prepareStatement(query);
            pstmt.setString(1, navn);

            pstmt.execute();

            pstmt.close();
            myConnector.close();

            System.out.println("Det valgte medlem er blevet slettet fra listen.");
            
        } else {
            System.out.println("Det valgte medlem eksisterer ikke i databasen.");
        }
        
        //pstmt.close();
        //statement.close();
        resultSet.close();
        myConnector.close();
    }

    public static void medlemListe() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        myConnector = DBConnector.getConnector();

        String query = "select * from delfinen.medlemmer";
        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int alder = resultSet.getInt("Alder");
            String akForm = resultSet.getString("AktivitetsForm");
            int konBet = resultSet.getInt("kontingentBetaling");
            boolean aktiv = resultSet.getBoolean("Aktiv");
            String navn = resultSet.getString("Navn");
            System.out.println(navn + "\nAlder: " + alder + "\nUdmærker sig i " + akForm
                    + "\nÅrlig kontingent på " + konBet + "\n");
        }

        resultSet.close();
        statement.close();
        myConnector.close();
    }
    
    public static void tekst() {
        System.out.println("");
        System.out.println("\t\tHvilket felt skal ændres?");
        System.out.println("");
        System.out.println("1) Alder");
        System.out.println("2) Aktivitetsform");
        System.out.println("3) Aktiv/passiv medlemsskab");
        System.out.println("4) Navn");
        System.out.println("5) Afslut redigering af medlem");
    }
    
    public static String aktivitetsForm() {
        boolean quit = false;
        Scanner scan = new Scanner(System.in);
        String aktivitet = "";
        
        while(quit == false) {
            System.out.println("Hvad er den nye Aktivitetsform?");
            System.out.println("1) Butterfly");
            System.out.println("2) Crawl");
            System.out.println("3) Rygcrawl");
            System.out.println("4) Brystsvoemning");
            
            String brugerInput = scan.nextLine();
            
            switch(brugerInput) {
                case "1":
                    aktivitet = "Butterfly";
                    quit = true;
                    break;
                    
                case "2":
                    aktivitet = "Crawl";
                    quit = true;
                    break;
                    
                case "3":
                    aktivitet = "Rygcrawl";
                    quit = true;
                    break;
                    
                case "4":
                    aktivitet = "Brystsvoemning";
                    quit = true;
                    break;
                    
                default:
                    System.out.println("Noget gik galt. Prøv igen.");
                    System.out.println("");
            }
        }
        
        return aktivitet;
    }

}
