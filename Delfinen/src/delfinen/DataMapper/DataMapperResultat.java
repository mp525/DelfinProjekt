
package delfinen.DataMapper;

import delfinen.Model.Resultat;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataMapperResultat {
    public static void resultatInsert(Resultat resultat) throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;

        myConnector = DBConnector.getConnector();

        String query = "insert into resultater (Navn, Tid, Dato, Disciplin, Længde) values (?, ?, ?, ?, ?);";
        pstmt = myConnector.prepareStatement(query);
        pstmt.setString(1, resultat.getMedlemNavn());
        pstmt.setString(2, resultat.getTid());
        pstmt.setString(3, resultat.getDato());
        pstmt.setString(4, resultat.getDiciplin());
        pstmt.setInt(5, resultat.getLængde());
        
        pstmt.execute();

        pstmt.close();
        myConnector.close();
    }
    public static void visResultater() throws ClassNotFoundException, SQLException {
        ArrayList<Resultat> resultater = new ArrayList();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        myConnector = DBConnector.getConnector();
        String query = "select * from Resultater";

        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String navn = resultSet.getString("Navn");
            String tid = resultSet.getString("Tid");
            String dato = resultSet.getString("Dato");
            String disciplin = resultSet.getString("Disciplin");
            int længde = resultSet.getInt("Længde");
            Resultat resultat = new Resultat(tid, dato, navn, disciplin, længde);
            resultater.add(resultat);
            }
            for (Resultat resultat1 : resultater) {
                System.out.println(resultat1.toString());
            }
        
        statement.close();
        resultSet.close();
        myConnector.close();


        
    }

}
