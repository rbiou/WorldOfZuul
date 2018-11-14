
/**
 * The item class : Base class that will be used for every different item  
 * in the game WoZ
 * @author Group 7 
 * @version 14/11/2018
 */
public class Item
{
    private String name; //name of the item
    private int value; // value of the item
    private int weight; // the weight of the item
    private String description; // a short description of the item
    
    /**
     *Constructor of the object Item.
     *Initially, each item has its own price, weight and decription.
     *
     *@param description : the description of the item.
     *@parm price : the price of the item.
     *@parm weight : the weight of the item.
     */
    public Item()
    {
        // initialisation des variables d'instance     
    }

    /**
     * this method allows the player to show the description of the item
     *
     * @return the description of the item
     */
    public String descriptionDisplayItem()
    {
        return ("");
    }
    



}
