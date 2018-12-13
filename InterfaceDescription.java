import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 
/**
 * The InterfaceDescription is used to update the panel description
 *
 * @author (Group7)
 * @version (13/12/2018)
 */
public class InterfaceDescription extends JPanel 
{
    //declaration of variables
    private Game myGame;

    /**
     * Constructor for objects of class InterfaceDescription
     */
    public InterfaceDescription(Game game)
    {
        myGame = game; 

    }

    /**
     * update the panel description to display a new information
     * 
     * @param  JPanel : panel
     */
    public void updatePanelDescription(JPanel panel){
        myGame.getInterfaceGame().getPanelDescription().removeAll();
        myGame.getInterfaceGame().getPanelDescription().add(panel); 
        myGame.getInterfaceGame().getPanelDescription().revalidate();
        myGame.getInterfaceGame().getPanelDescription().repaint();
    }
}
