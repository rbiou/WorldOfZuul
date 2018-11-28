import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * PlanetTest class
 * In the game there are 4 planets. 
 * They contain rooms (different number according to the planet)
 * The player can stay on the planet during a specific time. 
 * The time depends on the planet (specific for each planet)
 * When the time is over, the player is dead (he loses his LP and he returns to the beginnig og the game).
 *
 * @author  (Groupe 7)
 * @version (21/11/2018)
 *
 */
public class PlanetTest
{
    private Planet planet1;
    private Planet negPlanet;
    private Planet emptyDescriptionPlanet;
    private Planet emptyNamePlanet ;
    private Character character; 
    private Room room1;
    
    /**
     * Constructor of the PlanetTest class
     */
    public PlanetTest()
    {
    }

    /**
     * Creation of one planet, one room and one character.
     * They are used in all the methods described in this class
     */
    @Before
    public void setUp()
    {
        planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        room1 = new Room("Room1", planet1);
        character= new Character("Joe", 50, 40, room1);
        room1.addCharacter(character);
        planet1.addRoom(room1);
    }

    /**
     * Test if a player can not live on a planet more than her time limit.
     */
    @Test
    public void testTimeLimit()
    {
        long original = System.currentTimeMillis();
        while (true) {
            if (System.currentTimeMillis() - original >= (planet1.getTime()*1000)+1000) {
                break;
            }
        }
        assertEquals(0, planet1.getListRoom().get(0).getListCharacter().size());
    }
    
     /**
     * Test to add a room to the planet
     * We can not add the same room twice
     */
    @Test
    public void testAddRoom() 
    {
        boolean trouve = false; 
        if (planet1.getListRoom().contains(room1)){
            trouve = true; 
        }
        assertEquals(true, trouve);
    }
    
     /**
     * Test to add a room in the planet
     * This room is already in the planet
     * @expected result : The room should not be added to the planet
     */
    @Test
    public void testAddRoomTwice() 
    {
        boolean trouve = false; 
        int nbRoom = 0; 
        planet1.addRoom(room1);
        planet1.addRoom(room1);
        for(int i = 0; i < planet1.getListRoom().size(); i++){
            nbRoom++;
        }
        assertEquals(1, nbRoom);
    }
    
    /**
    * Methode testNegativeTime : check that the remainnig time of the player in the planet is not negative , 
    * if the time is negative there is a message 
    * "Time can't be negative." and the planet is not created.
    * @return exception.getMessage()= "Time can't be negative."; 
    */
    @Test
    public void testNegativeTime()
    {
        String message ="";
        try
        {
            negPlanet = new Planet("Beta","Welcome on the planet Beta",10,-10);
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("time can't be negative.", message);
    }
    
    /**
    * Methode testEmptyName : check if the name of a planet is empty, if the name is empty there is a message :  
    * "A planet needs a name" and the planet is not created.
    * @return exception.getMessage()= "Name cant' be nempty"; 
    */
    @Test
    public void testEmptyName()
    {
        String message ="";
        try
        {
            emptyNamePlanet = new Planet("","Welcome on the planet B",10,10);
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Name can't be empty.", message);
    }
    
    /**
    * Methode testEmptyDescription : check if the description of a planer is empty, 
    * if the description is empty there is a message :  
    * "A planet needs a description" and the planet is not created.
    * @return exception.getMessage()= "Description cant' be empty"; 
    */
    @Test
    public void testEmptyDescription()
    {
        String message ="";
        try
        {
            emptyDescriptionPlanet = new Planet("Gamma","",10,10);
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Description can't be empty.", message);
    }
}

