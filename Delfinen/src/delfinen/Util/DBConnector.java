package delfinen.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector {
    public static Connection getConnector() throws ClassNotFoundException, SQLException{
            Connection connector = null;
            String url = "jdbc:mysql://localhost:3306/delfinen?serverTimeZone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
            String user = "root";
            String password = "cph39178";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connector = DriverManager.getConnection(url, user, password);
            return connector;
        }

}
