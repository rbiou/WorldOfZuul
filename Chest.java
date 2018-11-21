import java.util.*;

/**
 *The Chest class : this is class defines what is contained in the chests. 
 * @Groupe 7
 * @14/11/2018
 **/
public class Chest extends Item
{
    private ArrayList<Item> rewarding; // list of items in the chest
    private boolean isTrap; // true if the chest is trapped ; false if the chest is not trapped
    private int money; // Money in the chest
    /**
     * Constructeur d'objets de classe Chest
     */
    public Chest(String newName, int newValue, int newWeight, String newDescription, int newMoney, boolean isTrapped)
    {
        //List<Item> item, int newMoney
        super(newName, newValue, newWeight, newDescription); 
        rewarding = new ArrayList<Item>(); // creation of the list of Item
        money = newMoney; 
        isTrap = isTrapped;
    }
    
    /**
     *The player removes the money from the chest
     */
    public boolean removeMoneyChest()
       {
           return false; 
       }
     /**
     *The player removes the item from the chest
     */
    public boolean removeItemChest()
    {
        return false;
    }
    
     /**
      * Adds an item to the rewarding of the chest
      * @param item the item to add to the chest
      * @return true if operation is successful
     */
    public boolean addItemChest(Item item)
    {
        return false;
    }


    /**
     * Returns the list of items in the chest
     *
     * @return     The item list.
     */
    public ArrayList<Item> getListItems()
    {
        return rewarding;
    }

    /**
     * Returns the amount of money inside the chest
     *
     * @return     The amount of money
     */
    public int getMoney()
    {
        return money;
    }
     
}
