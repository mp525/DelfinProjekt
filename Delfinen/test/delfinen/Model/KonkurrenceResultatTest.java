package delfinen.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matti
 */
public class KonkurrenceResultatTest {

    public KonkurrenceResultatTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGetPlacering() {
        KonkurrenceResultat instance = new KonkurrenceResultat("Mattemandens Cup", 8, 26, "Matti Hansen", "Crawl");

        System.out.println("getPlacering");
        int expResult = 8;
        int result = instance.getPlacering();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testGetMedlemNavn() {
        KonkurrenceResultat instance = new KonkurrenceResultat("Mattemandens Cup", 8, 26, "Matti Hansen", "Butterfly");

        System.out.println("getMedlemNavn");
        String expResult = "Matti Hansen";
        String result = instance.getMedlemNavn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
