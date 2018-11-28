import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest : In the game Space Zuul, the player can grabb different items to help him during his journey.
 * The character has a bag with all his items, the bag has an infinite size limit but it has limited maximum weight
 * (predefined at the beginning of the game)
 * an item is defined with a name, a value, a weight and a description. 
 * The weight of the item can't be negative, and an item can't have a negative price.
 * the character can add an item in his bag and remove an item from his bag. The character can't remove a non existing
 * item from his bag.
 * 
 *
 * @author  Goupr 7
 * @version 21/11/2018
 */
public class ItemTest
{
    private Item item;
    private Item bigItem;
    private Item negItem;
    private Item negWeightItem;
    private Item emptyDescriptionItem;
    private Item emptyNameItem;
    private Character character;
    private Room room1;
    private Planet planet1;
    
    /**
    * Default constructor for test class ItemTest
    */
    public ItemTest()
    {
    }
    
    
    /**
    * Sets up the test.
    *
    * Called before every test case method.
    * create a prefefined item :
    *  name ="banana"
    *  weight = 1
    *  price = 1
    *  description "I'm a banana"
    */
    @Before
    public void setUp()
    {
        planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        planet1.addRoom(room1);
        room1 = new Room("Room1", planet1);
        item = new Item("banana",1,1,"I'm a banana");
        bigItem = new Item("apple",1,40,"I'm a big apple");
        character= new Character("Joe", 50, 40, room1);
    }

    /**
    * Method testItemDescription : test if the item description is available for the player
    *
    *expected value : item.getDescription()="I'm a banana"
    *
    */
    @Test
    public void testItemDescription()
    {
        assertEquals("I'm a banana",item.getDescription());
    }
    
    /**
    * method testRemoveNonExistingItem : test if it is possible to remove a non existing item in the character bag
    *
    * @Return Character.removeItem(Item)= false;
    * @correction the test return a message "this item does not exist in your bag"
    */
    @Test
    public void testRemoveNonExistingItem ()
    {
        character.removeItem(item);
        assertEquals(false,character.getListItems().contains(item));
        assertEquals(false, character.removeItem(item));
    }
    
    /**
    * method testRemoveExistingItem : test if it is possible to remove an existing item in the chacter bag
    *
    * expected value : Character.removeItem(Item) =true ;
    */
    @Test
    public void testRemoveExistingItem ()
    {
        character.addItem(item); // add an item into a character bag
        assertEquals(true,character.getListItems().contains(item)); // test if the item is in the list of items
        character.removeItem(item);
        assertEquals(false,character.getListItems().contains(item)); // test if the item is not in the list of items after removing him
    }
    
    /**
    * Methode testNegativePrice : test if the price of an item is negative, if the price is negative there is a message 
    * "Price can't be negative." and the item is not created.
    * @return exception.getMessage()= "Price can't be negative."; 
    */
    @Test
    public void testNegativePrice()
    {
        String message ="";
        try
        {
            negItem = new Item("orange",-4,1,"I have a negative price");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Price can't be negative.", message);
    }
    
    /**
     * Methode testNegativeWeight : test if the weight of an item is negative, if the weight is negative there is an error
     * message : "Weight can't be negative." and the item is not created.
     * @return exception.getMessage()= "Weight can't be negative."; 
     */
    @Test
    public void testNegativeWeight()
    {
        String message ="";
        try
        {
            negWeightItem = new Item("papaye",1,-4,"I have a negative weight");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Weight can't be negative.", message);
    }
    
    /**
     * Methode testEmptyName : test if the name is empty, if the name is empty there is an error
     * message : "Name can't be empty." and the item is not created.
     * @return exception.getMessage()= "Name can't be empty.";
     */
    @Test
    public void testEmptyName()
    {
        String message ="";
        try
        {
            emptyNameItem = new Item("",1,1,"I have an empty name.");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Name can't be empty.", message);
    }
    
        /**
     * Methode testEmptyDescription : test if the description is empty, if the description is empty there is an error
     * message : "Description can't be empty." and the item is not created.
     * @return exception.getMessage()= "Description can't be empty.";
     */
    @Test
    public void testEmptyDescription()
    {
        String message ="";
        try
        {
            emptyDescriptionItem = new Item("apple",1,1,"");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Description can't be empty.", message);
    }
}


