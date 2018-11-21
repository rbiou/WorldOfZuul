import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "SpaceZuul" application. 
 * 
 *
 * A "Room" represents one location in the scenery of our game. Planet contains different rooms. 
 * There is not the same numberof rooms on each planet. 
 * It is connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * 
 *
 * @author (Groupe 7)
 * @version (14/11/2018)
 */
public class Room 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String name;// Name of the Room
    private HashMap<String,Door>lockExit; // Each exit is associated to this room
    private ArrayList<Character> listCharacters;  // List of all the Characters present in this room
    private ArrayList<Chest> listChest; // List of all the Chest present in this room

    /**
     * Constructeur d'objets de classe Room
     */
    public Room(String newName)
    {
        name = newName;
        lockExit = new HashMap <String,Door>();
        listCharacters = new ArrayList<Character>();
        listChest = new ArrayList<Chest>();
    }

        /**
     * Add a new character in the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public String getName()
    {
        return name; 
    }
    
    /**
     * Add an item to the list of items
     * @param  item
     * @return boolean
    **/
    public ArrayList<Character> getListCharacter()
    {
        return listCharacters;
    }
    
    public ArrayList<Chest> getListChest()
    {
        return listChest;
    }
    
    /**
     * Add a new character in the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public boolean addCharacter(Character newChar)
    {
        return false;
    }
    
    /**
     * Add a chest in the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public boolean addChest(Chest newChest)
    {
         return false;
    }
   
    /**
     * Remove a Character of the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public boolean removeCharacter(Character oldChar)
    {
         return false;
        
    }
    
    /**
     * Remove a Chest of the room
     *
     * @param  y   le paramètre de la méthode
     * @return the sum of x and y
     */
    public boolean removeChest (Chest oldChest)
    {
         return false;
    }
    
    /**
     * Define the exit of this room. Every direction either leads
     * to another door. 
     *
     * @param exitName. 
     * @param arrivalDoor.
     * 
     */
    public void setExit(String exitName, Door arrivalDoor)
    {
        
    }
    
     /**
     * Define the exit of this room. Every direction either leads
     * to a locked door. 
     *
     * @param exitName. 
     * @param arrivalDoor.
     * 
     */
    public void setExitLocked(String exitName, LockedDoor arrivalDoor)
    {
        
    }
    
}




