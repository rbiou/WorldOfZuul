import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test RoomTest.
 *
 * @author  (Groupe 7)
 * @version (un numéro de version ou une date)
 *
 */
public class RoomTest
{
    private Player player; 
    private Chest chest; 
    private Room room1;
    /**
     * Constructeur de la classe-test RoomTest
     */
    public RoomTest()
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
        player = new Player("Joe", 50);
        chest = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
        room1 = new Room("Room1"); 
    }

    @Test
    public void testCreatRoom() {
    assertEquals("Room1", room1.getName());
    }
    
    /**
     * This test checks if we can add a character in a room.
    */
    @Test
    public void testAddACharacterInTheRoom()
    {
        boolean test = false; 
        room1.addCharacter(player);
        for(int i = 0; i < room1.getListCharacter().size(); i++){
            if (room1.getListCharacter().get(i)==player) {
                test = true;}
            }
        assertEquals(true, test);
    }
    
    /**
     * This test checks if we can add a character (who not exists) in a room.
    */
    @Test
    public void testAddUnknownACharacterInRoom()
    {
        boolean test = false;
        for(int i = 0; i < room1.getListCharacter().size(); i++){
            if (room1.getListCharacter().get(i)==player) {
                test = true;}
            }
        assertEquals(false, test);
    }
    
    /**
     * This test checks if we can add a chest in a room.
    */
    @Test
    public void testAddChestInTheRoom()
    {
        boolean test = false; 
        room1.addChest(chest);
        for(int i = 0; i < room1.getListChest().size(); i++){
            if (room1.getListChest().get(i)==chest) {
                test = true;}
            }
        assertEquals(true, test);
    }
    
    /**
    * This test checks if we can add a chest (which not exist) in a room.
    */
    @Test
    public void testAddUnknownChestInTheRoom()
    {
        boolean test = false; 
        room1.addChest(chest);
        for(int i = 0; i < room1.getListChest().size(); i++){
            if (room1.getListChest().get(i)==chest) {
                test = true;}
            }
        assertEquals(false, test);
    }
    
    /**
     * This test check if wa can remove a character in a room.
    */
    @Test
    public void testRemoveCharacterInTheRoom()
    {
        boolean trouve = false; // true = the character was found in the list - false = the character was not found in the list
        room1.addCharacter(player);
        room1.removeCharacter(player);
        //assertEquals(1, room1.getListCharacter().size());
        for(int i = 0; i < room1.getListCharacter().size(); i++){
            if (room1.getListCharacter().get(i)==player) {
                trouve = true;}
            }
        assertEquals(false, trouve);
    }
    
    /**
    * This test check if we can remove an unknown character in a room.
    */
    @Test
    public void testRemoveUnknownCharacterInTheRoom()
    {
        boolean trouve = false; // true = the character was found in the list - false = the character was not found in the list
        //assertEquals(1, room1.getListCharacter().size());
        for(int i = 0; i < room1.getListCharacter().size(); i++){
            if (room1.getListCharacter().get(i)==player) {
                trouve = true;}
            }
        assertEquals(false, trouve);
    }
    
    /**
    * This test check if we can remove a chest in a room.
    */
    @Test
    public void testRemoveChestInTheRoom()
    {
        boolean trouve = false; // true = the chest was found in the list - false = the chest was not found in the list
        room1.addChest(chest);
        room1.removeChest(chest);
        //assertEquals(1, room1.getListCharacter().size());
        for(int i = 0; i < room1.getListChest().size(); i++){
            if (room1.getListChest().get(i)==chest) {
                trouve = true;}
            }
        assertEquals(false, trouve);
    }
    
    /**
    * This test check if we can remove a chest in a room.
    */
    @Test
    public void testRemoveChestUnknownInTheRoom()
    {
        boolean trouve = false; // true = the chest was found in the list - false = the chest was not found in the list
        for(int i = 0; i < room1.getListChest().size(); i++){
            if (room1.getListChest().get(i)==chest) {
                trouve = true;}
            }
        assertEquals(false, trouve);
    }
   
}

