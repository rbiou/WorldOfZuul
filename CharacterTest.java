import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CharacterTest.
 *
 * @author  (Groupe7)
 * @version (27/11/18)
 */
public class CharacterTest
{
    Seller seller;
    Room room1; 
    Planet planet1; 
    Item item; 
    /**
     * Default constructor for test class CharacterTest
     */
    public CharacterTest()
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
        planet1 = new Planet("Start", "Welcome on the planet start", 10, 10); 
        room1 = new Room ("room1", planet1); 
        seller = new Seller ("Dumbledore", 15000, 200, room1);
        item = new Item ("ball",500,50,"I am the ball"); 
    }
    /**
     * This test is used to see we can add an item to list of item of character
     * @result : The item should be added to the list of item (of the character) 
     */
    @Test
    public void testAddItem()
    { 
        seller.addItem(item);
        assertEquals(true,seller.getListItems().contains(item)); // test if the item is in the list of items
    }
    
    /**
     * This test checks if we can add a character twice in a room
     * @result : The character should be not added to the room (the second time)
     * @error : It may be an issue in the method addCharacter()
    */
    @Test
    public void testaddItemTwice()
    {
        boolean trouve = false; 
        int nbItem = 0; 
        seller.addItem(item);
        seller.addItem(item);
        for(int i = 0; i < seller.getListItems().size(); i++){
            nbItem++;
        }
        assertEquals(1, nbItem);
    }
}

