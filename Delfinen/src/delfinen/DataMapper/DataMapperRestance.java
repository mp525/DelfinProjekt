package delfinen.DataMapper;

import delfinen.Model.Medlem;
import delfinen.Model.Resultat;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DataMapperRestance {
    
    /*
    @Mathias
    */

    public static void visRestancer() throws ClassNotFoundException, SQLException {
        ArrayList<Medlem> restancer = new ArrayList();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
        myConnector = DBConnector.getConnector();
        String query = "select * from medlemmer where restance = 1;";

        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String navn = resultSet.getString("Navn");
            int alder = resultSet.getInt("Alder");
            String aktivitet = resultSet.getString("AktivitetsForm");
            boolean aktiv = resultSet.getBoolean("Aktiv");
            Medlem medlemR = new Medlem(alder, aktivitet, navn, aktiv);
            restancer.add(medlemR);

        }
        System.out.println("Alle medlemmer i restance: \n");
        for (Medlem medlem : restancer) {
            System.out.println(medlem.toString());
        }

        statement.close();
        resultSet.close();
        myConnector.close();

    }

    public static void addRestance() throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;
        Scanner myScan = new Scanner(System.in);
        DataMapperMedlem.medlemListe();
        System.out.println("Skriv navnet på det medlem der skal redigeres:");
        String navn = myScan.nextLine();

        myConnector = DBConnector.getConnector();

        String query = "update medlemmer set Restance = 1 where Navn = ?;";
        pstmt = myConnector.prepareStatement(query);
        pstmt.setString(1, navn);

        pstmt.execute();
        System.out.println(navn + " er blevet opdateret.");
        pstmt.close();
        myConnector.close();
    }

    public static void removeRestance() throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;
        Scanner myScan = new Scanner(System.in);
        DataMapperMedlem.medlemListe();
        System.out.println("Skriv navnet på det medlem der skal redigeres:");
        String navn = myScan.nextLine();

        myConnector = DBConnector.getConnector();

        String query = "update medlemmer set Restance = 0 where Navn = ?;";
        pstmt = myConnector.prepareStatement(query);
        pstmt.setString(1, navn);

        pstmt.execute();
        System.out.println(navn + " er blevet opdateret.");
        pstmt.close();
        myConnector.close();
    }
    public static void visUdenRestancer() throws ClassNotFoundException, SQLException {
        ArrayList<Medlem> restancer = new ArrayList();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
        myConnector = DBConnector.getConnector();
        String query = "select * from medlemmer where restance = 0;";

        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String navn = resultSet.getString("Navn");
            int alder = resultSet.getInt("Alder");
            String aktivitet = resultSet.getString("AktivitetsForm");
            boolean aktiv = resultSet.getBoolean("Aktiv");
            Medlem medlemR = new Medlem(alder, aktivitet, navn, aktiv);
            restancer.add(medlemR);

        }
        System.out.println("Alle medlemmer i restance: \n");
        for (Medlem medlem : restancer) {
            System.out.println(medlem.toString());
        }

        statement.close();
        resultSet.close();
        myConnector.close();

    }

}
