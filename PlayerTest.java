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
 	private Player playerTest;
 	private Chest chestTest;
 	private Character characterTest;
	
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
    	playerTest = new Player("Joe",40);
    	chestTest = new Chest("Chest1", 360, 1000, "I am the Chest1", 100, false);
    	characterTest= new Character("Joe", 50, 40);
    	// Initialisez ici vos engagements
   	
	}
   /**
 	* This test checks if the starting player has 100 points of life
	*/
	
	@Test
	public void CheckplayerHP()
	{
   	
    	assertEquals(100,playerTest.getLP());
   	
	}
	/**
 	* This test checks if When the player dies, he has no money
 	*/
 	@Test
	public void grabcontent()
	{
    	
 	assertEquals(75,playerTest.getLP());
    	
}
 @Test
	public void CaracterisDead()
	{
}
}

