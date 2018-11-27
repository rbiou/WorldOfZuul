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
        addMoney(chest.getMoney());
        chest.removeMoneyChest();

        ArrayList<Item> itemsInChest = chest.getListItems();

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
    }

    /**
     * When the player choose to move room, the game displayed the current rooms where the player is.
     * Then the player has to choose one and is moved to it.
    **/
    public void move()
    {
        boolean test = false;
        System.out.println("Here the list of the different possible exits");
        getCurrentRoom().displayExit();
        String nameDoor;
        while (test==false){
            System.out.println("Choose a valide exit");
            Scanner reader = new Scanner (System.in);
            nameDoor = reader.next();
            if (getCurrentRoom().getNameDoor().contains(nameDoor))
            {test=true;}
        }
        Door doorExit = getCurrentRoom().getSpecificExit(nameDoor);
        moveRoom(doorExit);
    }
    
    /**
     * Go to the room to which specified door leads to
     * @param  door    The door to where player has to go
    **/
    public void moveRoom(Door door)
    {
        setCurrentRoom(door.getNextRoom());
        door.getNextRoom().addCharacter(this);
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



