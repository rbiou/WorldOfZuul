

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ChestTest.
 *
 * @author  (Group 7)
 * @version (21/11/2018)
 */
public class ChestTest
{
    private Chest testChest;
    private Chest negMoneyChest;
    private Item testItem;
    private Player testPlayer;
    private Room room1;
    private Planet planet1;
    
    /**
     * Default constructor for test class ChestTest
     */
    public ChestTest()
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
        planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        planet1.addRoom(room1);
        room1 = new Room("Room1", planet1);
        testChest = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
        testItem = new Item("banana",1,1,"I'm a banana");
        testPlayer = new Player("Joe",40, room1);
    }

    /**
     * This test verify the good creation of a chest with the diffent values
     * given in the constructor and it is empty (no items in)
     */
    @Test
    public void testCreationChest()
    {
        assertEquals("Chest1",testChest.getName());
        assertEquals(360,testChest.getValue());
        assertEquals(1000,testChest.getWeight());
        assertEquals("I am the Chest1",testChest.getDescription());
        assertEquals(100,testChest.getMoney());
        assertEquals(0,testChest.getListItems().size());
    }
    
    /**
     * This test verify if when we put an item in the chest, it is very inside
     * it. That means that when we look inside the chest, we must find it.
     */
    @Test
    public void testAddItemChest()
    {
        testChest.addItem(testItem); // add an item into the chest
        assertEquals(true,testChest.getListItems().contains(testItem)); // test if the item is in the list of items
    }
    
     /**
     * This test verify if when we put an item in the chest, it is very inside
     * it. That means that when we look inside the chest, we must find it.
     */
    @Test
    public void testAddItemChestTwice()
    {
        boolean trouve = false; 
        int nbItems = 0;
        testChest.addItem(testItem); // add an item into the chest
        testChest.addItem(testItem); // add an the item a second time
        for(int i = 0; i < testChest.getListItems().size(); i++){
            nbItems++;
        }
        assertEquals(1, nbItems); // test if the number of item is equal to 1 and not 2
    }
    
    /**
     * This test verify if when we put an item in the chest and then remove it, he should not be there.
     * That means that when we look inside the chest, we must not find it.
     */
    @Test
    public void testRemoveItemChest()
    {
        testChest.addItem(testItem); // add an item into the chest
        testChest.removeItem(testItem); // remove an item into the chest
        assertEquals(false,testChest.getListItems().contains(testItem)); // test if the item is in the list of items
    }
    
    /**
     * This test verify if when we take the money inside the chest (using the method grabContent() from the player), the chest
     * contains no money after that.
     * That means that when we look inside the chest, we must find no money.
     */
    @Test
    public void testRemoveMoneyChest()
    {
        testPlayer.grabContent(testChest);
        assertEquals(0,testChest.getMoney());
    }
    
    /**
    * Methode testNegativeMoney : test if the money contained a chest in creation is negative, there is a message 
    * "Money contained in the chest can not be negative." and the chest is not created.
    * @return exception.getMessage()= "Money contained in the chest can not be negative."; 
    */
    @Test
    public void testNegativeMoney()
    {
        String message ="";
        try
        {
            negMoneyChest = new Chest("Chest1", 360, 1000, "I am the Chest1", -10, false);
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Money contained in the chest can not be negative.", message);
    }
}
