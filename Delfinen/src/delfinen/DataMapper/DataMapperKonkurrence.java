package delfinen.DataMapper;

import delfinen.Model.KonkurrenceResultat;
import delfinen.Model.Medlem;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataMapperKonkurrence {

    /*
    @Matti
     */
    public static void konkurrenceInsert(KonkurrenceResultat konkurrence) throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;

        myConnector = DBConnector.getConnector();

        String query = "insert into konkurrence (KonkurrenceNavn, Placering, Tid, Navn, Disciplin) values (?, ?, ?, ?, ?);";
        pstmt = myConnector.prepareStatement(query);

        pstmt.setString(1, konkurrence.getKonkurrence());
        pstmt.setInt(2, konkurrence.getPlacering());
        pstmt.setDouble(3, konkurrence.getTid());
        pstmt.setString(4, konkurrence.getMedlemNavn());
        pstmt.setString(5, konkurrence.getDisciplin());
        pstmt.execute();

        pstmt.close();
        myConnector.close();
    }

    public static void seKonkurrenceTabel() throws ClassNotFoundException, SQLException {
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        myConnector = DBConnector.getConnector();

        String query = "select * from delfinen.konkurrence";
        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String konkurrenceNavn = resultSet.getString("konkurrenceNavn");
            int placering = resultSet.getInt("Placering");
            double tid = resultSet.getDouble("Tid");
            String navn = resultSet.getString("Navn");
            String disciplin = resultSet.getString("Disciplin");
            System.out.println("\nKonkurrenceNavn: " + konkurrenceNavn + "\nPlacering: " + placering + "\nTid: " + tid
                    + "\nNavn: " + navn + "\nDisciplin: " + disciplin);
        }

        resultSet.close();
        statement.close();
        myConnector.close();

    }
}
