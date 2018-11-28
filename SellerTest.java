import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test SellerTest.
 *
 * @author Groupe 7
 * @version 21/11/2018
 * 
 */

public class SellerTest
{
    private Seller seller;
    private Item item1;
    private Item item2;
    private Item item3;
    private Room room1;
    private Planet planet1;
    /**
     * Constructor of the class seller test
     */
    public SellerTest()
    {
    }

    /**
     * 
     *The method called before each test method call
     */
    @Before
    public void setUp()
    {
       planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
       planet1.addRoom(room1);
       room1 = new Room("Room1", planet1);
       seller= new Seller ("Marc",100,10000,room1);
       item1 = new Item ("banana1",1,1,"I am a banana1");
       item2 = new Item ("banana2",300,1,"I am a banana2");
       item3 = new Item ("banana3",30,1,"I am a banana3");
    }

    // /**
    //  * Description : The seller must not be able to sell an 
    //  * item without item in his bag. 
    //  * 
    //  * @return : We want the test return false if the 
    //  * seller try to sell an item without item his bag.
    //  * @ correction : the seller add an item before to sell
    //  * an item
    //  */
    // @Test
    // public void testSellAnItemWithoutItems() 
    // {
    //     assertEquals(0,seller.getListItems().size());
    //     seller.sellItems(item1);
    //     assertEquals(false, seller.getListItems().size());
    // }
     
    // /**
    //  * Description : the seller can buy an item if he has 
    //  * enough money.
    //  * @ return : We want the test to be good if the 
    //  * seller try to buy an item with enough money.
    //  */
    // @Test
    // public void testBuyAnItemWithEnoughMoney() 
    // {
    //    assertEquals (0, seller.getListItems().size());
    //    assertEquals (100, seller.getMoney());
    //    seller.buyItem(item1);
    //    assertEquals(1, seller.getListItems().size());
    //    assertEquals(99,seller.getMoney());
       
    // }
    
    // /**
    //  * Description : the seller cannot buy an item if he has 
    //  * not enough money.
    //  * @ return : We want the test to be not good if the 
    //  * seller try to buy an item without enough money.
    //  * @correction: The seller must win money before buy 
    //  * this item.
    //  */
    // @Test
    // public void testBuyAnItemWithNotEnoughMoney()
    // {
    //    assertEquals (0, seller.getListItems().size());
    //    assertEquals (100, seller.getMoney());
    //    seller.buyItem(item2);
    //    assertEquals(0, seller.getListItems().size());
    // }
    
}
