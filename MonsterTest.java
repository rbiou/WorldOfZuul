import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MonsterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MonsterTest
{
    private Monster testMonster;
    private Player testPlayer;
    
    /**
     * Default constructor for test class MonsterTest
     */
    public MonsterTest()
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
        testPlayer = new Player ("Joe", 40);
        testMonster = new Monster ("Bowser", 50 , 100);
    }
      
    /**
     * Test the good creation of a new monster
     */
    @Test
    public void testNewMonster()
    {
        assertEquals("Bowser", testMonster.getName());
        assertEquals(50, testMonster.getMoney());
        assertEquals(100, testMonster.getMaxWeight());
        assertEquals(0, testMonster.getListItems().size());
    }

    /**
     * test to verify that the player loose LP after been attacking by the monster
     */
    @Test
    public void testAttack()
    {
        testMonster.attack(testPlayer);
        assertEquals(90, testPlayer.getLP());
    }
}
