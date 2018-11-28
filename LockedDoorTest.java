import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LockedDoorTest.
 * A locked door can not open with a key who does not have the right 
 * shape.
 * A locked door can not open with different keys
 * @author  (Group7)
 * @version (28/11/18)
 */
public class LockedDoorTest
{
    LockedDoor lockedDoor;
    LockedDoor doorEmptyShapeKey;
    Keys key1, key2; 
    Room room1; 
    Planet alpha; 
    /**
     * Default constructor for test class LockedDoorTest
     */
    public LockedDoorTest()
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
        key1 = new Keys("key1", 300, 50,"I am the key1. I can open the door1", "circle" );
        key2 = new Keys("key2", 300, 50,"I am the key2. I can't open the door1", "rectangle");
        lockedDoor = new LockedDoor(room1, "circle"); 
    }
    
     /**
     *  This test verify if the locked door is well created and has all the good values
     *  for the different attributes given in the constructor
     */
    @Test
    public void testCreationLockedDoor()
    {
        assertEquals(true,lockedDoor.getIfLocked());
        assertEquals("circle", lockedDoor.ShapeKeyDescription());
        assertEquals(room1,lockedDoor.getNextRoom());
    }
    
    /**
     * This test is used to open a door when the shape of the door 
     * and the shape of key are the same. 
     * @result : The door must open
     * @error : It may be the method open()
     */
    @Test
    public void testOpenDoor()
    {
        lockedDoor.open(key1); 
        assertEquals(false, lockedDoor.getIfLocked()); // test if the door is not closed
    }
    
    /**
     * We could not open a door when the shape between the door 
     * and the key are different
     * @result : The door must not open
     * @error : It may be the method open()
     */
    @Test
    public void testOpenDoorDifferentShape()
    {
        lockedDoor.open(key2); 
        assertEquals(true, lockedDoor.getIfLocked()); // test if the door is always closed
    }
    
    /**
     * This test is used to open a door a first time and then a second time
     * @result : The door must open the first time. The second time, it should be still open. 
     * The door should not be locked again
     * @error : It may be the method open()
    */
    @Test
    public void testOpenDoorAlreadyOpen()
    {
        lockedDoor.open(key1); // The door is open a first time
        lockedDoor.open(key1); // We try to open the door a second time
        assertEquals(false, lockedDoor.getIfLocked()); // test if the door is always closed
    }
    
    /**
     * Methode testEmptyShapeKey : test if the shape of the key is empty, if the shape of the key is empty there is an error
     * message : "The shape of the key which open the door can not be empty." and the locked door is not created.
     * @return exception.getMessage()= "The shape of the key which open the door can not be empty.";
     */
    @Test
    public void testEmptyName()
    {
        String message ="";
        try
        {
            doorEmptyShapeKey = new LockedDoor(room1, "");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("The shape of the key which open the door can not be empty.", message);
    }
}
