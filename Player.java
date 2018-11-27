
/**
 * The sub-class Player : this is a class that define the characteristics     
 * of the player
 * @author Group 7
 * @version 13/11/2018
 */
public class Player extends Character
{
    private int lifePoints;
    private Room currentRoom;
    
    /**
     * Constructor
    **/
    public Player(String newName, int newWeight)
    {
        super(newName, 0, newWeight);
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
    public void moveRoom(Door door)
    {
        
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
     
     /**
     * Return the position of the player (the room where he is)
     * @param 
     */
    public Room getCurrentRoom()
    { 
        return currentRoom;
    }
}



