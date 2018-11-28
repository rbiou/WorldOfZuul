import java.util.*;
import java.io.*;
import java.lang.*; 

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
     *@parm description : the description of the item.
     *@parm value : the price of the item.
     *@parm weight : the weight of the item.
     *@ return : item with value, weight, description
     */
    public Item(String newName, int newValue, int newWeight, String newDescription)
    {
        name = newName.trim(); 
        value = newValue; 
        weight = newWeight; 
        description = newDescription.trim();
        if (weight <= 0){
            throw new IllegalArgumentException("Weight can't be negative.");
        }
        if (value <= 0){
            throw new IllegalArgumentException("Price can't be negative.");
        }
        if (name == ""){
            throw new IllegalArgumentException("Name can't be empty.");
        }
        if (description == ""){
            throw new IllegalArgumentException("Description can't be empty.");
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
