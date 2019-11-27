
package delfinen.Model;


import static org.junit.Assert.assertEquals;
import org.junit.Test;



/**
 *
 * @author John
 */
public class MedlemTest {
    
    public MedlemTest() {
    }
    
 
    public void setUp() {
        
    }

    @Test
    public void testKontingentBetaling() {
        Medlem m = new Medlem(16,"Butterfly","John",true);      
        int expResult = 1000;
        int result = m.kontingentBetaling();
        assertEquals(expResult, result);
        System.out.println("kontingentBetaling expected " + expResult + ". Kontingent var " + result);
    }
    
}
