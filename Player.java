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
     * the player grabs the content of the chest
     * @param door
    **/
    public void grabContent(Chest chest)
    {
        int newLP = 0; 
        if (chest.getIsTrap()==true){
            newLP = this.lifePoints - 25; 
            if (newLP < 0){
            this.lifePoints=0; 
            }
        }; 
        
        this.addMoney(chest.getMoney());
        chest.removeMoneyChest();

        ArrayList<Item> itemsInChest = chest.getListItems();

        for (Item item: itemsInChest){
            if (this.addItem(item))
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
    
    /**
     * This method allows to pet a pet
     * The player earns 1 piece
     * The pet loses 1 piece
    **/
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
        System.out.println("Here the list of the different possible exits : ");
        ArrayList<String> exits = getCurrentRoom().getNameDoor();
        for(int i=0;i<exits.size();i++)
        {
            System.out.println(exits.get(i));
        }
        String nameDoor="";
        while (test==false){
            System.out.println("Choose a valide exit | 'stop' to stop moving");
            Scanner reader = new Scanner (System.in);
            nameDoor = reader.next();
            if (getCurrentRoom().getNameDoor().contains(nameDoor))
            {
                test=true;
                Door doorExit = getCurrentRoom().getSpecificExit(nameDoor);
           
                if (doorExit.getIfLocked())
                {
                    ArrayList<Item> bag = getListItems();
                    
                }
                else
                {
                    moveRoom(doorExit);
                }
            }
            if (nameDoor == "stop")
            {
                test=true;
            }
        }
        
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



