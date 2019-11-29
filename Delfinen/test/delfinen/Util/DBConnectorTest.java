/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matti
 */
public class DBConnectorTest {
    
    public DBConnectorTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getConnector method, of class DBConnector.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = DBConnector.getConnector();
        Statement st = result.createStatement();
        String query="select * from delfinen.konkurrence";
        ResultSet res = (ResultSet) st.executeQuery(query);
        System.out.println(res.getRow());
        assertTrue(result!=null);
    }
    
}
