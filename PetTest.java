import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PetTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PetTest
{
    private Pet petTest;
    private Player playerTest;
    private Room room1;
    private Planet planet1;
    
    /**
     * Default constructor for test class PetTest
     */
    public PetTest()
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
        petTest = new Pet("Tom",10, 100, "cat"); 
        playerTest = new Player ("Joe", 40);
        Planet planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        room1 = new Room("Room1");

    }

    /**
     * Test the good creation of a new pet
     */
    @Test
    public void testNewPet()
    {
        assertEquals("Tom", petTest.getName());
        assertEquals(10, petTest.getMoney());
        assertEquals(100, petTest.getMaxWeight());
        assertEquals(0, petTest.getListItems().size());
    }
    
    /**
     * Test if the pet give of the description of the planet where it is when
     * a player speak to him
     */
    @Test
    public void testSpeak()
    {
        room1.addCharacter(petTest); 
        planet1.addRoom(room1);
        assertEquals("Welcome on the planet alpha", petTest.speak());
    }
    
    
}
