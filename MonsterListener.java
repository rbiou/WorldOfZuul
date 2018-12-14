import java.awt.event.*;
import javax.swing.*;

/**
 * MonsterListener class : this class group all the action performed 
 * when the player is interacting with the monster
 *
 * @author (Group7)
 * @version (13/12/2018)
 */
public class MonsterListener implements ActionListener
{
    //declaration of the different variables
    private InterfaceMonster interMonster;
    private String reponse, reponseMin;
    private Game myGame; //The game
    /**
     * Constructeur d'objets de classe Listener
     */
    public MonsterListener(InterfaceMonster i, Game game)
    {
        interMonster = i;
        myGame = game;
    }
    
    /**
     * Action performed for the different buttons
     */
    public void actionPerformed(ActionEvent e){
        //check answer monster
         if (e.getSource()== interMonster.getButtonReponse()){
            reponse = interMonster.getLabelReponse().getText();
            reponseMin = reponse.toLowerCase();
            // if the player give the good answer, we replace the actual panel
            // by the panel rewarding the player, and we update the money in the panel player
            if (interMonster.getMonster().checkAnswer(reponseMin, myGame.getPlayer()))
                {
                interMonster.getPanel1().setVisible(false);
                myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interMonster.setPanelWin()); 
                myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
                
            }
            // if the player give the wrong answer, we replace the actual panel
            // by the panel bad answer, and we update the life in the panel player
            else {
                interMonster.getPanel1().setVisible(false);
                myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interMonster.setPanelLoose());
                myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
                myGame.endGame();
            }
            
        }
        //after the player saw if he has given the good answer, he has to validate before keep moving in another room
        else if(e.getSource()== interMonster.getButtonValidLoose())
        {
            myGame.getInterfaceGame().getInterfaceChar().getMonsterButton().setEnabled(true);
            myGame.getInterfaceGame().getInterfaceRoom().getPanelFinal().setVisible(true);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(new JPanel());
        }
        else if(e.getSource()== interMonster.getButtonValidWin())
        {
            
            myGame.getInterfaceGame().getInterfaceRoom().getPanelFinal().setVisible(true);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(new JPanel());
        }
}
}
