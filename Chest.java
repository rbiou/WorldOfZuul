import java.util.*;

/**
 *The Chest class : this is class defines what is contained in the chests.
 * The chest can have 50 tests or a piece of the vessel. He can have a trap
 * and the player loses 25 life points.
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
        if (money < 0){
            throw new IllegalArgumentException("Money contained in the chest can not be negative.");
        }
        isTrap = isTrapped;
    }
    
    /**
     *The player removes the money from the chest. 
     *The chest contains 50 or 0 piece(s). 
     *If they contain money, the player earns it
     */
    public boolean removeMoneyChest()
       {
            money=0; 
            return true; 
       }
       
     /**
     *The player removes the item from the chest
     *@param : item to remove 
     *
     */
    public boolean removeItem(Item item)
    {        
        if (this.rewarding.contains(item)){
            this.rewarding.remove(item);
            return true;}
        else {
            return false;}
    }
    
     /**
      * Adds an item to the rewarding of the chest
      * @param item : the item to add to the chest
      * @return true if operation is successful
     */
    public boolean addItem(Item item)
    {
        if (this.rewarding.contains(item)){
            return false; }
        else {
            this.rewarding.add(item);
            return true;}
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
    
    /**
     * Returns the chest is trapped or not
     *
     * @return     boolean isTrap
     */
    public boolean getIsTrap()
    {
        return isTrap;
    }
}
