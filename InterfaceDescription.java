import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 
/**
 * Write a description of class InterfaceDescription here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InterfaceDescription extends JPanel 
{
    private Game myGame; 
    /**
     * Constructor for objects of class InterfaceDescription
     */
    public InterfaceDescription(Game game)
    {
        myGame = game; 
        //updatePanelDescription(myGame.getInterfaceGame().getPanelDescription());
    }

    public void updatePanelDescription(JPanel panel){
        myGame.getInterfaceGame().getPanelDescription().removeAll();
        myGame.getInterfaceGame().getPanelDescription().add(panel); 
        myGame.getInterfaceGame().getPanelDescription().revalidate();
        myGame.getInterfaceGame().getPanelDescription().repaint();
    }
}
