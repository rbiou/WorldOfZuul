import java.util.*;
/**
 * The sub-class Player : this is a class that define the characteristics     
 * of the player
 * @author Group 7
 * @version 13/11/2018
 */
public class Player extends Character
{
    private int lifePoints;
    
    /**
     * Constructor
    **/
    public Player(String newName, int newWeight, Room newRoom)
    {
        super(newName, 0, newWeight, newRoom);
        lifePoints = 100; 
    }

    /**
     * the player grab the content of the chest
     * @param door
    **/
    public void grabContent(Chest chest)
    {
    }
    
    public void looseHP(int HP)
    {
    }
    
    public boolean checkTime()
    {
        return false;
    }
    
    public boolean isDead()
    {
        return false;
    }
    
    public void pet(Pet pet)
    {
    }

    /**
     * Go to the room to which specified door leads to
     * @param  door    The door to where player has to go
    **/
    public void move()
    {
        System.out.println("Voici la liste des différentes sorties possibles");
        getCurrentRoom().displayExit();
        System.out.println("Choisissez votre porte");
        Scanner reader = new Scanner (System.in);
        
        
    }
    
    
    /**
     * getter to get the LP of the player
    **/
    public int getLP()
    {
        return lifePoints;
    }
    
    /**
     * Interract with the no player character
     * @param 
     */
    public void interractWith(NonPlayerCharacter character)
    {
        character.speak(this);
    }
     
    
}



