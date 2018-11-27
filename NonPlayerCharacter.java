
/**
 * The class NonPlayerCharacter describ all the characters of the
 * game except the player
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class NonPlayerCharacter extends Character
{
    // instance variables - 
    /**
     * Constructor for objects of class NonPLayerCharacter
     */
    public NonPlayerCharacter(String newName, int newMoney, int newWeight, Room newRoom)
    {
        super(newName, newMoney, newWeight, newRoom); 
    }

    /**
     * this method allows the player to speak with the character
     *
     * @param
     * @return  return the message of the character
     */
    public String speak(Player player)
    {
        return (""); 
    }

}

