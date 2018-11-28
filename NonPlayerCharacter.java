
/**
 * The class NonPlayerCharacter describ all the characters of the
 * game except the player
 *
 * @author Group 7
 * @version 28/11/2018
 */
abstract class NonPlayerCharacter extends Character
{
    // instance variables - 
    /**
     * Constructor for objects of class NonPLayerCharacter : this constructor allows the user to create a NPC withe a name
     * some money, a weight, and the room where the NPC is.
     */
    public NonPlayerCharacter(String newName, int newMoney, int newWeight, Room newRoom)
    {
        super(newName, newMoney, newWeight, newRoom); 
    }

    /**
     * this method allows the player to speak with the character
     *
     * @param player
     * @return  return the message of the player
     */
    public void speak(Player player)
    {
    }

}

