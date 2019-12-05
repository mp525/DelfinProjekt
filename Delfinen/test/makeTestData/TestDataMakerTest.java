/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeTestData;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matti
 */
public class TestDataMakerTest {
    
    public TestDataMakerTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of nameMaker method, of class TestDataMaker.
     */
    @Test
    public void testNameMaker() {
        System.out.println("Test: does it return a String");
        String result = TestDataMaker.nameMaker();
        assertNotNull(result);
        System.out.println("It does");
    }

    /**
     * Test of randomAktivitetsChooser method, of class TestDataMaker.
     */
    @Test
    public void testRandomAktivitetsChooser() {
        System.out.println("Test: does it return a String");        
        String result = TestDataMaker.randomAktivitetsChooser();
        assertNotNull(result);
        System.out.println("It does");
    }

}