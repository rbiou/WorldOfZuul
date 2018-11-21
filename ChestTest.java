

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChestTest.
 *
 * @author  (Group 7)
 * @version (21/11/2018)
 */
public class ChestTest
{
    private Chest testChest;
    
    /**
     * Default constructor for test class ChestTest
     */
    public ChestTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        testChest = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);

    }

    /**
     * This test verify the good creation of a chest with the diffent values
     * given in the constructor and it is empty (no items in)
     */
    @Test
    public void testCreationChest()
    {
        assertEquals("Chest1",testChest.getName());
        assertEquals(360,testChest.getValue());
        assertEquals(1000,testChest.getWeight());
        assertEquals("I am the Chest1",testChest.getDescription());
        assertEquals(100,testChest.getMoney());
        assertEquals(0,testChest.getListItems().size());
        
    }
}
