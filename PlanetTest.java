import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe-test PlanetTest.
 *
 * @author  (Groupe 7)
 * @version (v1)
 *
 */
public class PlanetTest
{
    private Planet planet1;
    private Character character; 
    private Room room1;
    
    /**
     * Constructeur de la classe-test PlanetTest
     */
    public PlanetTest()
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
        Planet planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        room1 = new Room("Room1");
        character= new Character("Joe", 50, 40);
    }

    /**
     * Test if a player can not live on a planet more than her time limit.
     */
    @Test
    public void testTimeLimit()
    {
        room1.addCharacter(character);
        planet1.addRoom(room1);
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

