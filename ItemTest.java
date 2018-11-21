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
    private Character character;    
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
        item = new Item("banana",1,1,"I'm a banana");
        bigItem = new Item("apple",1,40,"I'm a big apple");
        negItem = new Item("orange",-4,1,"I have a negative price");
        negWeightItem = new Item("papaye",1,-4,"I have a negative weight");
        character= new Character("Joe", 50, 40);
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
    
    /**
    * Method testItemDescription : test if the item description is available for the player
    *
    *expected value : item.getDescription()="I'm a banana"
    *
    */
    @Test
    public void testItemDescription()
    {
        assertEquals("I'm a banana",item.descriptionDisplayItem());
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
        assertEquals(1,character.getListItems().size());// test if the size of the list is 1
        character.removeItem(item);
        assertEquals(0,character.getListItems().size());
        assertEquals(false,character.getListItems().contains(item));
        assertEquals(true, character.removeItem(item));
    }
    
    /**
    * Method addItemEnoughPlace : test if an item is added in a bag with enough place, if there is enough place in the bag
    * the item is added in the bag and the size of the bag is implemented, otherwise if there is not enough places in the bag
    * an error message "not enough places" is displayed.
    * @return : charater.addItem(item) = true ;
    *
    */
    @Test
    public void testaddItemEnoughPlace()
    {
        if( character.getTotalWeight() < character.getMaxWeight())
        { assertEquals(true,character.addItem(item));
          assertEquals(1,character.getListItems().size());
          assertEquals(true,character.getListItems().contains(item));
        }
    }
    
    /**
    * Method testAddItemNotEnoughPlace : test if an item is added in a bag with not enough place
    * @return : character.getListItem().contains(item)) = false;
    */
    @Test
    public void testAddItemNotEnoughPlace()
    {
        character.addItem(bigItem);
         assertEquals(true,character.getTotalWeight()==character.getMaxWeight());
         character.addItem(item);
         assertEquals(false,character.getListItems().contains(item));
    }
    
    /**
    * Methode testNegativePrice : test if the price of an item is negative, if the price is negative there is a message 
    * "the price of this item is negative" and the item is not added into the character bag.
    * @return character.addItem(negItem)= false; 
    */
    @Test
    public void testNegativePrice()
    {
        assertEquals(-4,negItem.getValue());
        assertEquals(false,character.addItem(negItem));
        assertEquals(0,character.getListItems().size());
        assertEquals(false,character.getListItems().contains(negItem));
        
    }
    
    /**
     * Methode testNegativeWeight : test if the weight of an item is negative, if the weight is negative there is an error
     * message : " the weight can't be negative" and the item is not added into the character bag.
     * @return 
     */
    public void testNegativeWeight()
    {
        assertEquals(-4,negWeightItem.getWeight());
        assertEquals(false,character.addItem(negWeightItem));
        assertEquals(0,character.getListItems().size());
        assertEquals(false,character.getListItems().contains(negWeightItem));
    }

}


