import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.util.*;

/**
 * MoveListener class : this class group all the action performed when the player is changing room.
 *
 * @author  (Groupe 7)
 * @version (07/12/2018)
 */
public class MoveListener extends JPanel implements ActionListener
{
    private JPanel myRoomPanel, myMapPanel, myPlayerPanel; //All the interface panels which change 
    private Game myGame; //Our game
    private ArrayList<JButton> myRoomButtons; //List of buttons which indicate all the possible directions in the room panel
    private Room myRoom; //The actual room of the player
    private JLabel myMap, roomLabel, playerLabel, moneyLabel, weightLabel; //Modified labels

    /**
     * Constructeur d'objets de classe MoveListener
     */
    public MoveListener(Game theGame, ArrayList<JButton> button)
    {
        myGame = theGame;
        myRoomButtons = button;
    }

    /**
     * actionPerformed : perform all the actions for this listener, when the player decided to move.
     *
     */
    public void actionPerformed (ActionEvent e)
    {
        //Actions occured when we change room

        //ON ROOM PANEL
        //Get the room panel at the moment when he click on the button
        myRoomPanel = myGame.getInterfaceGame().getInterfaceRoom().getPanelRoom();
        //Iterate over all the actual directions buttons to know which button was pressed
        for (int i=0; i < myRoomButtons.size(); i++) {
            if ((JButton)e.getSource() ==  myRoomButtons.get(i)) {
                //Move the player to the direction indicates on the pressed button
                myGame.getPlayer().moveRoom(myGame.getPlayer().getCurrentRoom().exit.get(myRoomButtons.get(i).getText()));
                //Clear the room buttons panel
                myRoomPanel.removeAll();
                //Get the current room of the player after his moove
                myRoom = myGame.getPlayer().getCurrentRoom();
                //Create a new list of possible directions buttons which correspond to all exits possible of his new room
                myRoomButtons = new ArrayList <JButton>();
                //Iterate over all exits possible for this new room where the player is now after he moved
                for (int y=0; y < myRoom.getNameDoor().size(); y++)
                {
                    //Create the button for each new exit
                    JButton btn = new JButton(myRoom.getNameDoor().get(y));
                    //Add the button to the interface
                    myRoomPanel.add(btn);
                    myRoomButtons.add(btn);
                    //Link the button with all the actions performed where he moved to perform them for next player moove
                    btn.addActionListener(this);

                };
                //Reload the room buttons panel
                myRoomPanel.revalidate();
                myRoomPanel.repaint();
            };
        };

    }
}
