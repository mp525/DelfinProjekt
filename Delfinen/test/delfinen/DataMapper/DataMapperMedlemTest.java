/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.DataMapper;

import delfinen.Model.Medlem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mathias
 */
public class DataMapperMedlemTest {
    
    public DataMapperMedlemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testMedlemTjek() throws Exception {
        System.out.println("medlemTjek");
        String navn = "Matti";
        boolean expResult = true;
        boolean result = DataMapperMedlem.medlemTjek(navn);
        assertEquals(expResult, result);
        
    }
    
}
