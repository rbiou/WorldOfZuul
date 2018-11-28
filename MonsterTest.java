import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MonsterTest.
 * 
 * A monster can add a question to the player. 
 * If the answer is right : the player earns 300 pieces
 * If the answer is wrong : the player loses 50 LP 
 * A monster can interact with the player only one time.
 * 
 * @author  (Groupe7)
 * @version (21/11/2018)
 */
public class MonsterTest
{
    private Monster testMonster, emptyAnswerMonster, emptyQuestionMonster;
    private Player testPlayer;
    private Room room1;
    private Planet planet1;
    
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
        planet1 = new Planet("Alpha","Welcome on the planet alpha",10,10);
        planet1.addRoom(room1);
        room1 = new Room("Room1", planet1);
        testPlayer = new Player ("Joe", 40, room1);
        testMonster = new Monster ("Bowser", 50 , 100, room1, "Quelle est votre promo ?","Gphy");
    }
      
    /**
     * Test the creation of a new monster
     * 
     * @result : Creation of the monster, all the parameters should be the same as testMonster
     * @error :  It may be an issue in the constructor 
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
     * 
     * @result : The player should lose 50 LP
     * @error : It may be an issue in the attack() method
     */
    @Test
    public void testAttack()
    {
        testMonster.attack(testPlayer);
        assertEquals(50, testPlayer.getLP());
        
    }
    
    /**
     * Methode testEmptyQuestion : test if the question is empty, if the question is empty there is an error
     * message : "Question can't be empty." and the monster is not created.
     * @return exception.getMessage()= "Question can't be empty.";
     */
    @Test
    public void testEmptyQuestion()
    {
        String message ="";
        try
        {
            emptyQuestionMonster = new Monster ("Bowser", 50 , 100, room1, "","Gphy");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Question can't be empty.", message);
    }
    
    /**
     * Methode testEmptyAnswer : test if the answer is empty, if the answer is empty there is an error
     * message : "Answer can't be empty." and the monster is not created.
     * @return exception.getMessage()= "Answer can't be empty.";
     */
    @Test
    public void testEmptyAnswer()
    {
        String message ="";
        try
        {
            emptyAnswerMonster = new Monster ("Bowser", 50 , 100, room1, "Quelle est votre promo ?","");
        }
        catch (IllegalArgumentException exception)
        {
            message = exception.getMessage();
        }
        assertEquals("Answer can't be empty.", message);
    }
}
