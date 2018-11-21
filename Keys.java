
/**
 * The Keys class : this is a specific item that enable the player
 * to open a locked door. 
 *
 * @author Group 7 (Leyla)
 * @version 14/11/2018
 */
public class Keys extends Item
{
    private String shape; //The shape of the key, string that can take any word
    
    /**
     * Constructeur d'objets de classe Keys
     */
    public Keys(String newName, int newValue, int newWeight, String newDescription, String newShape)
    {
        super(newName, newValue, newWeight, newDescription);
        shape = newShape; 
    }
    
    /**
     * Getter for the attribute shape
     */
    public String getShape()
    {
        return shape;
    }
}

