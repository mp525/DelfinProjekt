package delfinen.DataMapper;

import delfinen.Model.Medlem;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
    

}
