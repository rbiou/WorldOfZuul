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
        Planet planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        planet1.addRoom(room1);
        room1 = new Room("Room1");
        character= new Character("Joe", 50, 40, room1);
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
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @After
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
}

