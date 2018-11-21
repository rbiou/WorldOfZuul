import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SellerTest
{
    private Seller seller;
    private Player player;
    private Item item1,item2, item;
    /**
     * Constructeur de la classe-test SellerTest
     */
    public SellerTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @Before
    public void setUp() // throws java.lang.Exception
    {
       seller= new Seller ("Marc",100,10000);
        
       player = new Player ("Joe",50);
        
       item1 = new Item ("banana1",1,1,"I am a banana1");
       item2 = new Item ("banana2",300,1,"I am a banana2");
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @Test
    public void testSellAnItemWithoutItems() 
    {
        seller.sellItems(item);
        assertEquals(false, seller.getListItems().size());
    }
     
    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @Test
    public void testBuyAnItemWithEnoughMoney() // throws java.lang.Exception
    {
       seller.buyItem(item1);
       assertEquals(true, seller.getListItems().size());
       assertEquals(99,seller.getMoney());
       
    }
}
