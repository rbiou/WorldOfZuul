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
    //private ArrayList<JButton> myRoomButtons; //List of buttons which indicate all the possible directions in the room panel
    //private Room myRoom; //The actual room of the player
    private JButton myRoomButton;
    private JLabel myMap, roomLabel, playerLabel, moneyLabel, weightLabel; //Modified labels

    /**
     * Constructeur d'objets de classe MoveListener
     */
    public MoveListener(Game theGame)
    {
        myGame = theGame;
    }

    /**
     * actionPerformed : perform all the actions for this listener, when the player decided to move.
     *
     */
    public void actionPerformed (ActionEvent e)
    {
        //Actions occured when we change room

        //ON ROOM PANEL
        //Iterate over all the actual directions buttons to know which button was pressed
        for (int i=0; i < myGame.getInterfaceGame().getInterfaceRoom().getButtonsList().size(); i++) {
            myRoomButton = myGame.getInterfaceGame().getInterfaceRoom().getButtonsList().get(i);
            if ((JButton)e.getSource() ==  myRoomButton) {
                //Move the player to the direction indicates on the pressed button
                myGame.getPlayer().moveRoom(myGame.getPlayer().getCurrentRoom().exit.get(myRoomButton.getText()));
                myGame.getInterfaceGame().getInterfaceRoom().updateInterfaceRoom(myGame);
            };
        };

        //ON MAP PANEL
        //Get the map panel at the moment when he click on the button
        myMapPanel = myGame.getInterfaceGame().getInterfaceMap().getPanelMap();
        //Load the image map designed for this room
        Icon imageMap = new ImageIcon(new ImageIcon("map/planet_"+myGame.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
                    "_room_"+myGame.getPlayer().getCurrentRoom().getName()+".jpg").getImage().getScaledInstance(480, 270, Image.SCALE_DEFAULT));
        //Load the new map on a new JLabel
        myMap = new JLabel(imageMap, JLabel.CENTER);
        //Clear the actual map panel to delete the precedent map
        myMapPanel.removeAll();
        //Add the new map to the map panel
        myMapPanel.add(myMap);

        //

    }
}
