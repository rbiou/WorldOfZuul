import java.util.*;

public class Character{
    private String name;           // Name of character
    private int money;             // Money owned by character
    private ArrayList<Item> items; // Items owned by character
    private int maxWeight;         // Maximum weight character can
    private int itemsTotalWeight;       // Total weight of the bag
    private Room currentRoom;


    /**
     * Constructor
    **/
    public Character(String newName, int newMoney, int newWeight, Room newRoom)
    {
        money       = newMoney; 
        name        = newName; 
        maxWeight   = newWeight; 
        items       = new ArrayList<Item>(); 
        itemsTotalWeight = 0;
        currentRoom = newRoom;
    }
    
    public ArrayList<Item> getListItems(){
        return items; 
    }
    
    /**
     * Returns the character's name
     *
     * @return     The character's name.
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the amount of money owned by character
     *
     * @return     The money.
     */
    public int getMoney(){
        return money; 
    }
    
    /**
     * Returns the maximum weight a character can handle in its items
     *
     * @return     The maximum weight.
     */
    public int getMaxWeight(){
        return maxWeight; 
    }
    
    /**
     * Add an item to the list of items
     * @param  item
     * @return boolean
    **/
    public boolean addItem (Item item)
    {
        int newWeight = itemsTotalWeight + item.getWeight();
        if ((newWeight) > getMaxWeight())
        {
            return false;
        }
        else 
        {
            items.add(item);
            itemsTotalWeight = newWeight;
            return true;
        }
    }
    
    
    /**
     * Remove an item from the list of items
     * @param  item
     * @return boolean
    **/
    public boolean removeItem(Item item)
    {
        if (items.remove(item)){
            itemsTotalWeight -= item.getWeight();
            return true;
        }
        return false;
    }
    
    /**
     * Add money to character
     * @param  amount    The amount of money that character gains
     * @return boolean
    **/
    public boolean addMoney (int amount)
    {
        return false;
    }
    
    /**
     * Remove an item from the list of items
     * @param  amount  The amount of money that character loses
     * @return boolean
    **/
    public boolean removeMoney(int amount)
    {
        return false;
    }
    
    /**
     * Return the total weight of items owned by character
     *
     * @param  
     * @return int TotalWeight
     */
    public int getTotalWeight()
    
    {
        return itemsTotalWeight;
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
