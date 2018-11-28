import java.util.*;
/**
 * The class monster is the principal opponent of the player. The monster
 * asks a riddle to the player. If he answers correctly the monster
 * gives money to him otherwise the monster attack the player.
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Monster extends NonPlayerCharacter
{
    // instance variables
    String question; //the question of the monster
    String answer ; // the good answer 
    boolean isResolved; // boolean to check if the enigma is already answered
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
            String playerAnswer ="";
            System.out.println("Welcome brave space adventurer to continue your quest you have to answer my enigma...");
            System.out.println(question);
            Scanner reader = new Scanner (System.in);
            playerAnswer = reader.next();
            checkAnswer(playerAnswer, player);
        }
    }
    
    public boolean checkAnswer(String playerAnswer, Player player){
            if(playerAnswer == answer)
            {
                player.addMoney(300);
                this.removeMoney(300);
                System.out.println("Well done ! You are very smart, you can continue your journey");
                isResolved = true;
                return true; 
            } 
            else { 
                attack(player);
                return false; 
            }
    }
    
    public boolean getIsResolved(){
        return isResolved; 
    }
}