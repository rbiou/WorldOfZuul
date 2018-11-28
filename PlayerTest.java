 
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
    private Item item, bigItem;
    private Chest chest, trappedChest;
    private Character character;
    private Pet petCat; 
    private Monster monster;
    private Room room1, room2;
    private Door door1, door2;
    private LockedDoor unlokedDoor; 
    private Planet planet1;
    
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
    public void setUp() 
    {
        player       = new Player("Joe",40, room1);
        chest        = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
        trappedChest = new Chest("Chest2", 360, 1000, "I am the Chest2", 100, true);
        item         = new Item("banana",1,1,"I'm a banana");
        bigItem      = new Item("Big item",41,41, "I am a big item"); 
        character    = new Character("Joe", 50, 40, room1);
        petCat       = new Pet("Minou",1000, 50, room1, "Cat");
        monster      = new Monster("Bowser",50, 100, room1, "Quelle est votre promo ?", "Gphy");
        planet1      = new Planet("Alpha","Welcome on the planet alpha",10,10);
        planet1.addRoom(room1);
        room1        = new Room("Room1", planet1);
        room2        = new Room("Room2", planet1);
        door1        = new Door(room1);
        door2        = new Door(room2);
    }

    /**
    * This test checks if the starting player has 100 points of life
    * the right name and he should be in the room1
    */
    
    @Test
    public void testNewPlayer()
    {
        assertEquals("Joe",player.getName());
        assertEquals(100,player.getLP());
        assertEquals(room1,player.getCurrentRoom());
    }
        
    /**
    * The test checks if the player loses 25 LP when he opens a trapped chest
    * @result : He must lose 25 LP
    * @error : It can be the grabContent method
    */
    @Test
    public void testGrabcontent()
    {   
        chest.addItem(item);
        player.grabContent(trappedChest);
        assertEquals(75,player.getLP());   
    }
    
    /**
     * This test checks if when the player dies, he has no money 
     * and his LP are equals to 0 
     *
    */
    @Test
        public void testCharacterIsDead()
        {
            player.looseHP(100);
            assertEquals(0,player.getMoney());   
            assertEquals(0,player.getLP()); 
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
        chest.addItem(item);
        player.grabContent(chest);
        assertEquals(true,player.getListItems().contains(item));
        assertEquals(false,chest.getListItems().contains(item));
        assertEquals(100,player.getLP()); //His LP should not be modify because the chest is not trapped
    }

    /**
     * this test Monster Speak Wrong Answer, allows to reduce the points of a player's life proscription
     * @return:
     * @correction:
     */   

    @Test
    public void testMonsterSpeakWrongAnswer(){
        player.interractWith(monster);
        assertEquals(50,player.getLP());
    }
        
    /**
     * This test checks if the player can move in another room
     * @result : The player should be in the room2 (next room) by using the door. 
     * @error : It may be an issue in the method moveRoom()
     */
    @Test
    public void testMovePlayer(){
        room1.setExit("Sortie1", door2);
        room2.setExit("Sortie1", door1);
        player.moveRoom(door1);
        assertEquals(room2, player.getCurrentRoom());
    }
    
    /**
     * The player can not add an item if his bag if full
     * @result : The item should not be added to the bag
     * @error : It may be an issue in the method moveRoom()
     */
    @Test
    public void testaddBigItem(){
        chest.addItem(bigItem);
        player.grabContent(chest);
        assertEquals(0,player.getListItems().size()); //the item should not be added to the player's bag
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
        chest.addItem(item);
        player.grabContent(chest);
        if(character.getTotalWeight(player)+item.getWeight() < character.getMaxWeight())
        { assertEquals(true,character.addItem(item));
          assertEquals(1,character.getListItems().size());
          assertEquals(true,character.getListItems().contains(item));
        }
    }
}
