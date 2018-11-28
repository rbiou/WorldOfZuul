import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DoorTest.
 *
 * @author  (Group7)
 * @version (28/11/18)
 */
public class DoorTest
{
    Door door; 
    Room room1; 
    Planet alpha; 
    /**
     * Default constructor for test class LockedDoorTest
     */
    public DoorTest()
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
        alpha = new Planet("Alpha", "Welcome on the planet alpha", 10, 10); 
        room1 = new Room("room1", alpha); 
        door = new Door(room1); 
    }
    
     /**
     *  This test verify if the door is well created and has all the good values
     *  for the different attributes given in the constructor
     */
    @Test
    public void testCreationDoor()
    {
        assertEquals(room1,door.getNextRoom());
    }
    
 
    
    
}
