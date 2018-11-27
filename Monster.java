import java.util.*;
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
    String question;
    String answer ; 
    boolean isResolved;
    /**
    * Constructor for objects of class Monster
    */
    public Monster(String newName, int newMoney, int newWeight,Room newRoom,String newQuestion, String newAnswer )
    {
        super(newName, newMoney, newWeight, newRoom );
        question = newQuestion ; 
        answer= newAnswer;
        isResolved = false ; 
    }


    /**
     * this method allows the monster to attack the player
     *
     * @return the number of HP that the player lost after the monster
     * attack
     */
    public void attack(Player player)
    {
        System.out.println("ATTACK !!!!!!!");
        player.looseHP(50);
    }
    
    /**
     * this method alllows the monster to speak to the player
     * @return the enigma of the monster
     *
     */
    public void speak(Player player)
    { 
        if( isResolved )
        {
            String PlayerAnswer ="";
            System.out.println("Welcome brave space adventurer to continue your quest you have to answer my enigma...");
            System.out.println(question);
            Scanner reader = new Scanner (System.in);
            PlayerAnswer = reader.next();
            if(PlayerAnswer == answer)
            {
                player.addMoney(300);
                this.removeMoney(300);
                System.out.println("Well done ! You are very smart, you can continue your journey");
                isResolved = true;
            } 
            else { attack(player);
            }
        }
    }

}