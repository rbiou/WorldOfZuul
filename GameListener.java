import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class CharListener here.
 *
 * @author (group7)
 * @version (11/12/18)
 */
public class GameListener extends JPanel implements ActionListener
{
    private Game myGame;
    private InterfacePets panelOfPets;
    /**
     * Constructor for objects of class CharListener
     */
    public GameListener(Game theGame)
    {
        myGame = theGame;
    }

    /**
     * 
     *
     */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getPetButton()){
            Pet recupPet = myGame.getPlayer().getCurrentRoom().getPet();
            panelOfPets = new InterfacePets(myGame, recupPet);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelOfPets.getPanelPet());
        }

    }

    
}