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
    // TODO
    // Create OK seller
    // Create WRONG seller
}
