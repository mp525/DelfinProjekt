/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfinen.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class MedlemTest {
    
    public MedlemTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void testKontingentBetaling() {
        Medlem m = new Medlem(16,"Butterfly","John",true);        
        int expResult = 1000;
        int result = m.kontingentBetaling();
        assertEquals(expResult, result);
        System.out.println("kontingentBetaling expected "+expResult+". Kontingent var "+result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
