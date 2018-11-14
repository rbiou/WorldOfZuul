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
    private List<String> listCharacters = new ArrayList<String>(); // List of all the Characters present in this room
    private List<String> listChest = new ArrayList<String>(); // List of all the Chest present in this room

    /**
     * Constructeur d'objets de classe Room
     */
    public Room()
    {
        
        this.lockExit = new HashMap <String,Door>();
        
    }

    /**
     * Add a new character in the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void addCharacter()
    {
        
    }
    
    /**
     * Add a chest in the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void addChest()
    {
        
    }
   
    /**
     * Remove a Character of the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void removeCharacter()
    {
        
        
    }
    
    /**
     * Remove a Chest of the room
     *
     * @param  y   le paramètre de la méthode
     * @return     la somme de x et de y
     */
    public void removeChest ()
    {
    
    }
    
    /**
     * Define the exits of this room. Every direction either leads
     *to another room or is null (not exite here).
     *
     * @param north The north exit.
     * @param east The east exit.
     * @param south The south exit.
     * @param west The west exit.
     * 
     */
    public void setExits(Door north, Door east, Door south, Door west)
    {
    }
}




