import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * InterfaceRoom : this class is a part of the global interface for the game. This interface concerns all the moving actions
 * for the player, all the exits for his current room are displayed. 
 *
 * @author (Groupe 7)
 * @version (13/12/2018)
 */
public class InterfaceRoom extends JPanel
{
    private Game myGame;                            //The game
    private Room myRoom;                            //The actual room of the player
    private JPanel myRoomPanel, myRoomPanelFinal;   //JPanel of the interface.
    private ArrayList<JButton> myRoomButtons;       //List of buttons which correspond to all exits for the player current room.
    private JTextArea descriptionLabel;             //Label to give a description of what is displayed in this interface.

    /**
     * Constructor for objects of class InterfaceRoom
     * @param : Game newGame : the game where we want to implement an InterfaceRoom to display the exits.
     */
    public InterfaceRoom(Game newGame)
    {
        //A JTextArea to explain that we display the possible exits
        descriptionLabel = new JTextArea ("Here the different exits possible for the current room : ");
        Font f = new Font("Apple Chancery", Font.PLAIN, 24);
        descriptionLabel.setFont(f);
        descriptionLabel.setLineWrap(true);
        descriptionLabel.setWrapStyleWord(true);
        descriptionLabel.setBackground(Color.gray);
        descriptionLabel.setForeground(Color.white);
        
        //A JPanel to display all the exit buttons which correpond to a move on one of the portals availables
        myRoomPanel = new JPanel();
        myRoomPanel.setLayout(new GridLayout(4,1));
        
        //The final panel with the JTextArea which explain what is display and the JPanel with the exit buttons 
        myRoomPanelFinal = new JPanel();
        myRoomPanelFinal.setLayout(new BorderLayout());
        myRoomPanelFinal.add(descriptionLabel, BorderLayout.NORTH);
        myRoomPanelFinal.add(myRoomPanel, BorderLayout.CENTER);
        
        //A list of buttons with all the buttons displayed, in order to get the JLabel in the button we have pressed when we
        //decided to move, to know the exit that the player have choose.
        myRoomButtons = new ArrayList <JButton>();
        
        //Update dynamically the JPanel with the buttons displayed, to create buttons which correspond to the exits of the
        //player current room
        updateInterfaceRoom(newGame);
    }

    /**
     * updateInterfaceRoom : this method update all the informations modified in the myRoomPanelFinal JPanel during the game
     * @param : Game myGame : the game that we want to update 
     */
    public void updateInterfaceRoom(Game myGame)
    {
        //Clear the room buttons panel
        myRoomPanel.removeAll();
        //Clear all exit buttons from the precedent room
        myRoomButtons.clear();
        //Iterate over all exits possible for this new room where the player is now after he moved
        for (int y=0; y < myRoom.getNameDoor().size(); y++)
        {
            //Create the button for each new exit
            JButton btn = new JButton(myGame.getPlayer().getCurrentRoom().getNameDoor().get(y));
            //Add the button to the interface
            myRoomPanel.add(btn);
            //Add the button to the list of buttons (in order to iterate over him in the MoveListener to get the JLabel of the
            //button pressed to know where move)
            myRoomButtons.add(btn);
            //Set the design of the button.
            btn.setForeground(Color.gray);
            btn.setBackground(Color.white);
            //Check if the door in the button is locked.
            if (myGame.getPlayer().getCurrentRoom().exit.get(btn.getText()).getIfLocked()){
                 //If yes, the button is disabled.
                 btn.setEnabled(false);
                }
            //Add a listener to perform actions occured we decided to move
            btn.addActionListener(new MoveListener(myGame));
        }
        //Reload the room buttons panel
        myRoomPanel.revalidate();
        myRoomPanel.repaint();
    }

    /**
     * getPanelRoom : this method is a getter for the myRoomPanel variable.
     */
    public JPanel getPanelRoom()
    { 
        return myRoomPanel;
    }
    
    /**
     * getButtonsList : this method is a getter for the myRoomButtons variable.
     */
    public ArrayList<JButton> getButtonsList()
    { 
        return myRoomButtons;
    }

    /**
     * getPanelFinal : this method is a getter for the myRoomPanelFinal variable.
     */
    public JPanel getPanelFinal()
    {
        return myRoomPanelFinal;
    }
};
