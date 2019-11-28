
package delfinen.DataMapper;

import delfinen.Model.Medlem;
import delfinen.Model.Resultat;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataMapperRestance {
    public static void visRestancer() throws ClassNotFoundException, SQLException {
        ArrayList<Medlem> restancer = new ArrayList();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;
//(int alder, String aktivitetsForm, String navn, boolean aktiv) {
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

}

