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
    private boolean isOpen = false;
    /**
     * Constructeur d'objets de classe Chest
     */
    public Chest(String newName, int newValue, int newWeight, String newDescription, int newMoney, boolean isTrapped)
    {
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
    public void removeMoneyChest()
    {
        money=0;          
    }

    /**
     *The player removes the item from the chest
     *@param : item to remove 
     *
     */
    public void removeItem(Item item)
    {        
        if (this.rewarding.contains(item))
            this.rewarding.remove(item);
    }

    /**
     * Adds an item to the rewarding of the chest
     * @param item : the item to add to the chest
     * @return true if operation is successful
     */
    public void addItem(Item item)

    {
        if (!this.rewarding.contains(item)){
            this.rewarding.add(item);
        }
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

    /**
     * set the boolean isOpen to indicate when the chest is opened
     *
     * @param     boolean open
     */
    public void setIsOpened(boolean open)
    {
        isOpen = open; 
    }

    /**
     * set the boolean isOpen to indicate when the chest is opened
     *
     * @param     boolean open
     */
    public boolean getIsOpened()
    {
        return isOpen; 
    }

        /**
     * set the boolean isOpen to indicate when the chest is opened
     *
     * @return     int poids
     */
    public int getTotWeight(){
        int poids = 0; 
        for (int i=0; i< this.rewarding.size(); i++){
            poids = poids + this.rewarding.get(i).getWeight(); 
        }
        return(poids); 
    }
}
