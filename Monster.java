import java.util.*;
/**
 * The class monster is the principal opponent of the player. The monster
 * asks a riddle to the player. If he answers correctly the monster
 * gives money to him otherwise the monster attack the player and the 
 * player loses 50 life points.
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Monster extends NonPlayerCharacter
{
    // instance variables
    String question; //the question of the monster
    String answer ; // the good answer at the question 
    boolean isResolved; // boolean to check if the enigma is already answered
    /**
    * Constructor for objects of class Monster
    */
    public Monster(String newName, int newMoney, int newWeight,Room newRoom,String newQuestion, String newAnswer )
    {
        super(newName, newMoney, newWeight, newRoom );
        question = newQuestion.trim() ;
        if (question == ""){
            throw new IllegalArgumentException("Question can't be empty.");
        }
        answer= newAnswer;
        if (answer == ""){
            throw new IllegalArgumentException("Answer can't be empty.");
        }
        isResolved = false ; 
    }


    /**
     * this method allows the monster to attack the player
     *
     * @return the number of life point that the player lost after 
     * the monster attack
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
    
    /**
     * This method allows to see if the answer is good or false
     * @param String playerAnswer : the answer of the player
     * @return boolean : true : the answer is good.The player wins 300 pieces
     *                  false : the answers is false. The player loses 50HP.
     */                 
    public boolean checkAnswer(String playerAnswer, Player player){
            if(playerAnswer.equals(answer))
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