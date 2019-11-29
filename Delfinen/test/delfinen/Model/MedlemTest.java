
package delfinen.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matti
 */
public class MedlemTest {
    
    public MedlemTest() {
    }
    
    @Before
    public void setUp() {
    }


    /**
     * Test of kontingentBetaling method, of class Medlem.
     */
    @Test
    public void testKontingentBetaling() {
        System.out.println("kontingentBetaling");
        Medlem instance = new Medlem(1,"oki","doki",true);
        int expResult = 1000;
        int result = instance.kontingentBetaling();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Medlem.
     */

    
}
