import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.*;

/**
 * Write a description of class InterfaceRoom here.
 *
 * @author (Groupe 7)
 * @version (05/12/2018)
 */
public class InterfaceRoom extends JPanel
{
    private Game myGame;                      //The game
    private Room myRoom;                      //The actual room of the player
    private Player myPlayer;                  //The actual player
    private JPanel myRoomPanel;               //The JPanel for the Room interface 
    private ArrayList<JButton> myRoomButtons; //The list of possible directions buttons which correspond to all exits possible of
    //the current room of the player.

    /**
     * Constructor for objects of class InterfaceRoom
     */
    public InterfaceRoom(Game newGame)
    {
        myRoomPanel = new JPanel();
        myRoomButtons = new ArrayList <JButton>();
        updateInterfaceRoom(newGame);
    }

    
    public void updateInterfaceRoom(Game myGame)
    {
        //Clear the room buttons panel
        myRoomPanel.removeAll();
        //Clear all exit buttons from the precedent room
        myRoomButtons.clear();
        //Get the current room of the player after his moove
        myRoom = myGame.getPlayer().getCurrentRoom();
        //Iterate over all exits possible for this new room where the player is now after he moved
        for (int y=0; y < myRoom.getNameDoor().size(); y++)
        {
            //Create the button for each new exit
            JButton btn = new JButton(myRoom.getNameDoor().get(y));
            //Add the button to the interface
            myRoomPanel.add(btn);
            //Add the button to the list of buttons
            myRoomButtons.add(btn);
            //Link the button with all the actions performed where he moved to perform them for next player moove
            btn.setBackground(Color.gray);
            btn.setForeground(Color.white);
            btn.addActionListener(new MoveListener(myGame));
        }
        //Reload the room buttons panel
        myRoomPanel.revalidate();
        myRoomPanel.repaint();
    }

    public JPanel getPanelRoom()
    { 
        return myRoomPanel;
    }

    public ArrayList<JButton> getButtonsList()
    { 
        return myRoomButtons;
    }
};
