import java.awt.event.*;
import javax.swing.*;

/**
 * Décrivez votre classe Listener ici.
 *
 * @author (Lagrange Romain)
 * @version (5/12/2018)
 */
public class MonsterListener implements ActionListener
{
    // variables d'instance 
    private InterfaceMonster interMonster;
    private String reponse, reponseMin;
    private Game myGame; 
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
            interMonster.getMonster().checkAnswer(reponseMin, myGame.getPlayer());
            if (interMonster.getMonster().checkAnswer(reponseMin, myGame.getPlayer()))
                {
                interMonster.getPanel1().setVisible(false);
                myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interMonster.setPanelWin());
            }
            else {
                interMonster.getPanel1().setVisible(false);
                myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interMonster.setPanelLoose());}

        }
}
}