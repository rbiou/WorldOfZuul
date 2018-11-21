
/**
 * The seller is the subclass of the non player character the seller
 * class allows the player to buy or to sell the items.
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Seller extends NonPlayerCharacter
{

    /**
     * Constructor for objects of class Seller
     */
    public Seller(String newName, int newMoney, int newWeight)
    {
        super(newName, newMoney, newWeight);
    }

    /**
     * this method allows the player to sell an item to the seller
     *
     * @param item
     * @return return the amount of money owned by the player
     */
    public void sellItems(Item item)
    {
        // put your code here
    }
    
    /**
     * this method allows the player to buy an item from the seller
     *
     * @param amount of money
     * @return return the new item get by the player
     */
    public void buyItem(Item item)
    {
        // put your code here
    }

    /**
     * this method allows the player to display the different items in
     * the shop
     *
     * @param  
     * @return all the items in the shop
     */
    public void displayShop()
    {
        // put your code here
    }

}


