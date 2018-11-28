import java.util.*;
import java.io.*;
import java.lang.*; 

/** Character is a super Class. It contains all the attributes which in
* common subclasses. The subclasses are Player and NPC.
* a character has a name, some money, a maximum weight of items that he can grab, and the current room where he is.
*/


public class Character{
    private String name;           // Name of character
    private int money;             // Money owned by character
    private ArrayList<Item> items; // Items owned by character
    private int maxWeight;         // Maximum weight character can
    private int itemsTotalWeight;       // Total weight of the bag
    private Room currentRoom;      // To know where is the Character


    /**
     * Constructor of the class character 
    **/
    public Character(String newName, int newMoney, int newWeight, Room newRoom)
    {
        money       = newMoney; 
        name        = newName.trim(); 
        maxWeight   = newWeight; 
        items       = new ArrayList<Item>(); 
        itemsTotalWeight = 0;
        currentRoom = newRoom;
        if (maxWeight < 0){
            throw new IllegalArgumentException("Maximum weight can't be negative.");
        }
        if (name == ""){
            throw new IllegalArgumentException("Name can't be empty.");
        }
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
     * @param  item add in a list
     * @return boolean
    **/
    public boolean addItem(Item item)
    {
        int newWeight = itemsTotalWeight + item.getWeight();
        if ((newWeight) > getMaxWeight() || this.items.contains(item))
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
     * @param  item : item remove to a list
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
        if (this.money>=0){
            this.money = money+amount; 
            return true;}
        else 
            return false; 
    }
    
    /**
     * The amount of money of the character decreases. 
     * @param  amount  The amount of money that character loses
     * @return boolean
    **/
    public boolean removeMoney(int amount)
    {
        int newValueMoney; 
        if (this.money>=0){
            newValueMoney = money-amount;
                if (newValueMoney < 0){
                    this.money = 0; 
                }
                else 
                    this.money = newValueMoney; 
            return true;}
        else 
            return false;
    }
    
    /**
     * Return the total weight of items owned by character
     * @return int TotalWeight
     */
    public int getTotalWeight(Character character)
    
    {   int weightTot = 0 ; 
        for (int i = 0; i < character.items.size(); i++){
            weightTot = weightTot + character.items.get(i).getWeight() ;   
            }
        itemsTotalWeight = weightTot ; 
        return itemsTotalWeight ;
    }
    
     /**
     * Return the position of the player (the room where he is)
     * @return Current Room
     */
    public Room getCurrentRoom()
    { 
        return currentRoom;
    }
    
     /**
     * Change the position of the player (the room where he is)
     * @param new Room
     *  retrun current Room
     */
    public void setCurrentRoom(Room newRoom)
    { 
        currentRoom = newRoom;
    }
}
