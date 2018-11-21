
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
    private Keys testBadKey;
    private LockedDoor lockedDoor;
    private Room room1;
    private Room room2;
    
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
        testBadKey = new Keys("Key1",5, 2, "key for room 14", "square");
        room1 = new Room("Room1");
        room2 = new Room("Room2");
        lockedDoor = new LockedDoor(room1,room2,"circle");
    }

    /**
     *  This test verify if the key is well created and have all the good values
     *  for the different attributes given in the constructor
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
    
    /**
     *  testOpenADoorWithWrongKey : This test verify if the door is not open if we use the wrong key to open it
     *  @ result : locked attribute is now false if the shapes corresponds
     *  @ correction : give an error message "This is the wrong key." 
     */
    @Test
    public void testOpenADoorWithWrongKey()
    {
        assertEquals(false,testBadKey.getShape()==lockedDoor.ShapeKeyDescription());
        lockedDoor.open(testBadKey);
        assertEquals(true,lockedDoor.getIfLocked());
    }
    
    /**
     *  testOpenADoorWithGoodKey : This test verify if the door is open after we use the good key to open it
     *  @ result : locked attribute is now false if the shapes corresponds
     *  @ correction : give an error message "The door is not opened yet." 
     */
    @Test
    public void testOpenADoorWithGoodKey()
    {
        assertEquals(false,testKey.getShape()==lockedDoor.ShapeKeyDescription());
        lockedDoor.open(testKey);
        assertEquals(false,lockedDoor.getIfLocked());
    }
}
