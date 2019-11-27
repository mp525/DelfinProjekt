
package delfinen.DataMapper;

import delfinen.Model.Resultat;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataMapperRestance {
    public static void visRestancer() throws ClassNotFoundException, SQLException {
        ArrayList<Resultat> restancer = new ArrayList();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        myConnector = DBConnector.getConnector();
        String query = "select * from medlemmer where restance = 1;";

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

