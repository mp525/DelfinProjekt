package delfinen.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    public static Connection getConnector() throws ClassNotFoundException, SQLException {
        Connection connection = null;

        String url = "jdbc:mysql://localhost:3306/delfinen?";
        url += "serverTimezone=UTC&allowPublicKeyRetrieaval=true&";
        url += "useSSL=false";
        String password = "cph39178";

        String user = "root";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;

    }

}
