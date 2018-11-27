
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
        addmoney(chest.getMoney());
        chest.removeMoneyChest();

        itemsInChest = chest.getListItems();

        for (Item item: itemsInChest){
            if (addItem(item))
                chest.removeItem(item);
        }
    }
    
    public void looseHP(int HP)
    {
        if (HP > 0){
            lifePoints -= HP;
        }
    }
    
    public boolean checkTime()
    {
        return false;
    }
    
    public boolean isDead()
    {
        return (lifePoints <= 0);
    }
    
    public void pet(Pet pet)
    {
        addMoney(1);
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



