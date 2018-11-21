
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KeysTest.
 *
 * @author (Romain)
 * @version (21/11/2018)
 */
public class KeysTest
{
    private Keys testKey;
    
    /**
     * Default constructor for test class KeysTest
     */
    public KeysTest()
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
        testKey = new Keys("Key1",5, 2, "key for room 14", "circle");
    }

    /**
     *  This test very if the key is well created and have all the good values
     *  for the different attributes give in the constructor
     */
    @Test
    public void testCreationKey()
    {
        assertEquals("Key1", testKey.getName());
        assertEquals(5,testKey.getValue());
        assertEquals(2,testKey.getWeight());
        assertEquals("key for room 14",testKey.getDescription());
        assertEquals("circle",testKey.getShape());
    }
}
