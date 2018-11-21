import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Classe-test PlayerTest.
 *
 * @author  Marliat Julien
 * @version 20/11/2018
 * 
 */
public class PlayerTest
{
    private Player player;
    private Item item;
    private Chest chest;
    private Character character;
    private Pet petCat;
    private Monster monster;
    
    /**
    * Constructeur de la classe-test PlayerTest
    */
    public PlayerTest()
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
        // Initialisez ici vos engagements
        player = new Player("Joe",40);
        chest = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
        item = new Item("banana",1,1,"I'm a banana");
        character = new Character("Joe", 50, 40);
        petCat = new Pet("Minou",1000, 50,"Cat");
        monster = new Monster("Bowser",50, 100);
    }
   /**
    * This test checks if the starting player has 100 points of life
    */
    
    @Test
    public void CheckplayerHP()
    {
    
        assertEquals(100,player.getLP());
    
    }
    
    /**
    * 
    */
    @Test
    public void grabcontent()
    {
        
    assertEquals(75,player.getLP());
        
}
     /**
	* This test checks if when the player dies, he has no money
	*
	*/
	@Test
	public void testCharacterisDead()
	{
    	player.looseHP(100000000);
    	assertEquals(0,player.getMoney());	
	
}

    @Test
    /**
     * Test when a player pets a pet. He must earn money (1 piece) and the cat must lose 1 piece. 
     */
    public void testPetAPet() {
        player.pet(petCat); 
        assertEquals(1,player.getMoney());
        assertEquals(999,petCat.getMoney());
    }    

    @Test
    /**
     * Test when a player grab an item from a chest. If the player have enought weight available, the item go his bah and be removed
     * from the chest.
     * @return :
     * @correction : 
     */
    public void testGrabAnItemFromAChest() {
        chest.addItemChest(item);
        player.grabContent(chest);
        assertEquals(true,player.getListItems().contains(item));
        assertEquals(false,chest.getListItems().contains(item));
    }

/**
   	* this test Monster Speak Wrong Answer, allows to reduce the points of a player's life proscription
     	* @return:
       	* @correction:
 	*/   

	@Test
	public void testMonsterSpeakWrongAnswer()
{
	player.interractWith(monster);
	assertEquals(50,player.getLP());
}
}
