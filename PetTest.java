import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PetTest.
 *
 * @author  (Romain)
 * @version (21/11/2018)
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
     * Called before every test case method. Creation of a pet, player, planet
     * and a room for the different tests
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
     * This test verify if the pet is well created and have all the good values
     *  for the different attributes given in the constructor
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
     * Test if the pet give the description of the planet when a player speak 
     * to it
     */
    @Test
    public void testSpeak()
    {
        room1.addCharacter(petTest); 
        planet1.addRoom(room1);
        assertEquals("Welcome on the planet alpha", petTest.speak());
    }
}
