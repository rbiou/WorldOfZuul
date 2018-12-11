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
    private Game myGame;
    private Room myRoom;
    private Player myPlayer;
    private JPanel myRoomPanel;
    private ArrayList<JButton> myRoomButtons;

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
        //Get the room panel at the moment when he click on the button
        myPlayer = myGame.getPlayer();
        myRoom = myGame.getPlayer().getCurrentRoom();
        myRoomButtons = new ArrayList <JButton>();

        //Clear the room buttons panel
        myRoomPanel.removeAll();
        //Get the current room of the player after his moove
        myRoom = myGame.getPlayer().getCurrentRoom();
        //Create a new list of possible directions buttons which correspond to all exits possible of his new room
        myRoomButtons.clear();
        //Iterate over all exits possible for this new room where the player is now after he moved
        for (int y=0; y < myRoom.getNameDoor().size(); y++)
        {
            //Create the button for each new exit
            JButton btn = new JButton(myRoom.getNameDoor().get(y));
            //Add the button to the interface
            myRoomPanel.add(btn);
            myRoomButtons.add(btn);
            //Link the button with all the actions performed where he moved to perform them for next player moove
            btn.addActionListener(new MoveListener(myGame));

        };
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
