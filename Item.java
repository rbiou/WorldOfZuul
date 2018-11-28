
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
     *Initially, each item has its own value, weight and decription.
     *
     *@param description : the description of the item.
     *@parm price : the price of the item.
     *@parm weight : the weight of the item.
     */
    public Item(String newName, int newValue, int newWeight, String newDescription)
    {
        name = newName; 
        value = newValue; 
        weight = newWeight; 
        description = newDescription;
        if (weight < 0){
            throw new InvalidArgumentException("Weight can't be negative.");
        }
        if (name.trim()){
            throw new InvalidArgumentException("Name can't be empty.");
        }
    }

    /**
     * getter to get the weight of the object
    **/
    public int getWeight()
    {
        return weight;
    }

    /**
     * Getter for the attribute shape
     */
    public String getShape()
    {
        return "";
    }
    
    /**
     * getter to get the name of the object
    **/
    public String getName()
    {
        return name;
    }
    
    /**
     * getter to get the value of the object
    **/
    public int getValue()
    {
        return value;
    }
    
    /**
     * getter to get the description of the object
    **/
    public String getDescription()
    {
        return description;
    }

}
