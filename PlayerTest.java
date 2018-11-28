import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * PlayerTest class
 *
 * @author  Groupe 7
 * @version 20/11/2018
 * 
 */
public class PlayerTest
{
    //declaration
    private Player player;
    private Item item, bigItem;
    private Chest chest, trappedChest;
    private Character character;
    private Pet petCat; 
    private Monster monster;
    private Room room1, room2;
    private Door door1, door2;
    private LockedDoor lockedDoor1; 
    private Planet planet1;
    
    /**
    * Default constructor for test class ChestTest
    */
    public PlayerTest()
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
        //Items
        chest        = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
        trappedChest = new Chest("Chest2", 360, 1000, "I am the Chest2", 100, true);
        item         = new Item("banana",1,1,"I'm a banana");
        bigItem      = new Item("Big item",41,41, "I am a big item"); 
        //Location
        planet1      = new Planet("Alpha","Welcome on the planet alpha",10,10);
        room1        = new Room("Room1", planet1);
        room2        = new Room("Room2", planet1);
        //Characters
        petCat       = new Pet("Minou",1000, 50, room1, "Cat");
        monster      = new Monster("Bowser",50, 100, room1, "Quelle est votre promo ?", "Gphy");
        player       = new Player("Joe",40, room1);
        //Locate all characters generated
        room1.addCharacter(player);
        planet1.addRoom(room1);
        planet1.addRoom(room2);
        //Generate doors
        door1        = new Door(room2);
        door2        = new Door(room1);
        lockedDoor1  = new LockedDoor(room2, "triangle");
    }

    /**
    * This test checks if the starting player has 100 points of life,
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
     * This test checks if when the player dies. In this case, he has no money 
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
     * Test when a player grabs an item from a chest. If the player has enough weight available, 
     * the item goes in his bag and be removed from the chest.
     * @result : The item should be added to the chest, the chest should be removed from the chest
     *           As the chest is not trapped, the life points are still egal to 100
     */
    public void testGrabAnItemFromAChest() {
        chest.addItem(item);
        player.grabContent(chest);
        assertEquals(true,player.getListItems().contains(item));
        assertEquals(false,chest.getListItems().contains(item));
        assertEquals(100,player.getLP()); //His LP should not be modify because the chest is not trapped
    }

    /**
     * This test checks if 300 money pieces are added to the player if the answer is right
     * @result: The player earns 300 pieces of money
     */   
    @Test
    public void testMonsterSpeakRightAnswer(){
        player.interractWith(monster);
        assertEquals(true,monster.checkAnswer("Gphy",player));
        assertEquals(300,player.getMoney());
    }
    
    /**
     * This test checks if the player loses 50 LP when the answer is wrong
     * @result: The player should lose 50 LP
    */   
   @Test
   public void testMonsterSpeakWrongAnswer(){
       player.interractWith(monster);
       assertEquals(false,monster.checkAnswer("Gcell",player));
       assertEquals(50,player.getLP());
   }
        
    /**
     * This test checks if the player can move in another room
     * @result : The player should be in the room2 (next room) by using the door. 
     * @error : It may be an issue in the method moveRoom()
     */
    @Test
    public void testMovePlayer(){
        room1.setExit("Sortie1", door1);
        room2.setExit("Sortie1", door2);
        player.moveRoom(door1);
        assertEquals(room2, player.getCurrentRoom());
    }
    
    /**
     * The player can not add an item if his bag is full
     * @result : The item should not be added to the bag
     * @error : It may be an issue in the method grabContent()
     */
    @Test
    public void testaddBigItem(){
        chest.addItem(bigItem);
        player.grabContent(chest);
        assertEquals(0,player.getListItems().size()); //the item should not be added to the player's bag
        assertEquals(false,player.getListItems().contains(item));
    }
    
    /**
    * Method addItemEnoughPlace : test if an item is added in a bag with enough place, 
    * if there is enough place in the bag the item is added in the bag and 
    * the size of the bag is implemented.
    * @return : charater.addItem(item) = true ;
    */
    @Test
    public void testaddItemEnoughPlace()
    {
        chest.addItem(item);
        player.grabContent(chest);
        assertEquals(1,player.getListItems().size());
        assertEquals(true,player.getListItems().contains(item));
    }
    
    /**
     * This test checks if the player can not move in another room if the door is locked
     * and if he does not have the specific key to open the door
     * @result : The player should be in the room1 (starting room) after trying to move. 
     * @error : It may be an issue in the method moveLockedDoor()
     */
    @Test
    public void testMovePlayerButLocked(){
        room1.setExit("Sortie1", lockedDoor1);
        player.moveLockedDoor(lockedDoor1);
        assertEquals(room1, player.getCurrentRoom());
    }
}
