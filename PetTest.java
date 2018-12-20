import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PetTest.
 *
 * @author  (Group7)
 * @version (21/11/2018)
 */
public class PetTest
{
    private Pet petTest, emptySpeciePet;
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
        planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        room1 = new Room("Room1", planet1);
        planet1.addRoom(room1);
        petTest = new Pet("Tom",10, 100, room1, "cat"); 
        room1.addCharacter(petTest); 
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
        assertEquals("<html><center>***Welcome on the planet Alpha*** <br> I am Tom.The current temperature is 10°c. Warning you have 10 seconds to succeed.<br> Here is a small reward to start the quest on this planet</center></html>",
        petTest.giveMessage());
    }
    
    /**
     * Methode testEmptySpecie : test if the specie is empty, if the specie is empty there is an error
     * message : "Specie can't be empty." and the pet is not created.
     * @return exception.getMessage()= "Specie can't be empty.";
     */
    @Test
    public void testEmptyAnswer()
    {
        String message ="";
        try
        {
            emptySpeciePet = new Pet("Tom",10, 100, room1, "");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Specie can't be empty.", message);
    }
}
