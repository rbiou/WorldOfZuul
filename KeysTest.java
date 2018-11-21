
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class KeysTest.
 *
 * @author (Romain)
 * @version (a version number or a date)
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
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
