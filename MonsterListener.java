import java.awt.event.*;
import javax.swing.*;

/**
 * MonsterListener class : this class group all the action performed 
 * when the player is interacting with the monster
 *
 * @author (Group7)
 * @version (5/12/2018)
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
            
            if (interMonster.getMonster().checkAnswer(reponseMin, myGame.getPlayer()))
                {
                interMonster.getPanel1().setVisible(false);
                myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interMonster.setPanelWin()); 
                myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
                
            }
            else {
                interMonster.getPanel1().setVisible(false);
                myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interMonster.setPanelLoose());
                myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
                myGame.endGame();
            }
            
        }
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