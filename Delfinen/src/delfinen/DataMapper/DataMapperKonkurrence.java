
package delfinen.DataMapper;


import delfinen.Model.KonkurrenceResultat;
import delfinen.Model.Medlem;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vnord
 */
public class DataMapperKonkurrence {
    public static void medlemInsert(KonkurrenceResultat konkurrence) throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;

        myConnector = DBConnector.getConnector();

        String query = "insert into medlemmer (KonkurrenceNavn, Placering, Tid, Navn) values (?, ?, ?, ?);";
        pstmt = myConnector.prepareStatement(query);
        pstmt.setString(1, konkurrence.getKonkurrence());
        pstmt.setInt(2, konkurrence.getPlacering());
        pstmt.setDouble(3, konkurrence.getTid());
        pstmt.setString(4, konkurrence.getMedlemNavn());
        
        
        pstmt.execute();

        pstmt.close();
        myConnector.close();
    }
}
