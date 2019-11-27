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

    public static void medlemUpdate(Medlem medlem) {

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

}
