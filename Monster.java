
/**
 * The class monster is the principal opponent of the player, the monster
 * ask a riddle to the player if the player answer correctly the monster
 * give money to him otherwise the monster attack the player.
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Monster extends NonPlayerCharacter
{
    // instance variables

    /**
     * Constructor for objects of class Monster
     */
    public Monster(String newName, int newMoney, int newWeight, Room newRoom)
    {
        super(newName, newMoney, newWeight, newRoom);
    }

    /**
     * this method allows the monster to attack the player
     *
     * @return the number of HP that the player lost after the monster
     * attack
     */
    public void attack(Player player)
    {
    }
}

