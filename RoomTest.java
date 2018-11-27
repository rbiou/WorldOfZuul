import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RoomTest class
 *
 * @author  (Groupe 7)
 * @version (21/11/18)
 * 
 * We can create a room and add to this room : a chest or a character (pets, monsters, players, sellers). 
 * Several characters can be present in the same room.
 * We can remove a chest or a character from the room. 
 * The player can move between rooms : he can pass through a door (locked or not). He can move only to the next rooms. 
 * 
 */
public class RoomTest
{
    private Player player; 
    private Chest chest; 
    private Room room1, room2;
    private Planet planet1;
    
    /**
     * Constructor
     */
    public RoomTest()
    {
    }

    /**
     * Creation of one player, one chest and 2 rooms.
     * They are used in all the methods described in this class
     */
    @Before
    public void setUp()
    {   
        player = new Player("Joe", 50, room1);
        chest = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
        planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        planet1.addRoom(room1);
        planet1.addRoom(room2);
        room1 = new Room("Room1", planet1);
        room2 = new Room("Room2", planet1); 
    }

    @Test
    /**
     * Test to create a room.
     * @result : The name of the room should be "Room1"
     * @error : It may be an issue in the constructor
     */
    public void testCreatRoom() {
        assertEquals("Room1", room1.getName());
    }
    
    /**
     * This test checks if we can add a player in a room.
     * @result : The player (Joe) should be added in the Room1
     * @error : It may be an issue in the method addCharacter()
    */
    @Test
    public void testAddACharacterInTheRoom()
    {
        boolean test = false; 
        for(int i = 0; i < room1.getListCharacter().size(); i++){
            if (room1.getListCharacter().get(i)==player) {
                test = true;}
            }
        assertEquals(true, test);
    }
    
    
    /**
     * This test checks if we can add a chest in a room.
     * @result : The chest (Chest1) should be added in the Room1
     * @error : It may be an issue in the method addChest()
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
     * This test checks if we can remove a player in a room.
     * @result : The player (Joe) should be removed to the Room1
     * @error : It may be an issue in the method removeCharacter()
    */
    @Test
    public void testRemoveCharacterInTheRoom()
    {
        boolean trouve = false; // true = the character was found in the list - false = the character was not found in the list
        room1.removeCharacter(player);
        //assertEquals(1, room1.getListCharacter().size());
        for(int i = 0; i < room1.getListCharacter().size(); i++){
            if (room1.getListCharacter().get(i)==player) {
                trouve = true;}
            }
        assertEquals(false, trouve);
    }
    
    /**
     * This test checks if we can remove a chest in a room.
     * @result : The chest (Chest1) should be removed to the Room1
     * @error : It may be an issue in the method removeChest()
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
    
    
}
