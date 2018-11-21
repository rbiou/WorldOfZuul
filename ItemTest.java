import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  Goupr 7
 * @version 20/11/2018
 */
public class ItemTest
{
private Item item;
private Item bigItem;
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
* create an item :
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
* method testRemoveNonExixtingItem : test if it is not possible to remove a non existing item in the chacter bag
*
* expected value : Character.removeItem(Item)= false;
*/
@Test
public void testRemoveNonExistingItem ()
{
    character.removeItem(item);
    assertEquals(false,character.getListItems().contains(item));
    assertEquals(false, character.removeItem(item));
}

/**
* method testRemoveExixtingItem : test if it is possible to remove an existing item in the chacter bag
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
* Method addItemEnoughPlace : test if an item is added in a bag with enough place
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
*
*/
@Test
public void testAddItemNotEnoughPlace()
{
    character.addItem(bigItem);
     assertEquals(true,character.getTotalWeight()==character.getMaxWeight());
     character.addItem(item);
     assertEquals(false,character.getListItems().contains(item));
}


}


