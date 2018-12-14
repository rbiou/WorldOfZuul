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
    private static Planet last_visited_planet; //The planet where is the player after his last move
    
    /**
     * Constructeur d'objets de classe MoveListener
     */
    public MoveListener(Game theGame)
    {
        myGame = theGame;
        //When the player move for the first time, we assign to last_visited_planet variable the planet where he starts. 
        if (last_visited_planet == null)
        {
            last_visited_planet = theGame.getPlayer().getCurrentRoom().getPlanet();
        }
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
            //Get the JButton in a variable which correspond to one of the button of the list to check if he was pressed
            JButton myRoomButton = myGame.getInterfaceGame().getInterfaceRoom().getButtonsList().get(i);
            if ((JButton)e.getSource() ==  myRoomButton) {
                //Move the player to the direction indicates on the pressed button
                myGame.getPlayer().moveRoom(myGame.getPlayer().getCurrentRoom().exit.get(myRoomButton.getText()));
                //Update the InterfaceRoom panel where is the list of exits buttons, to display the exits of the new room
                myGame.getInterfaceGame().getInterfaceRoom().updateInterfaceRoom(myGame);
            };
        };
        
        //ON INTERFACE CHARACTER PANEL
        //Update the "actual room" label in the InterfacePlayer panel
        myGame.getInterfaceGame().getInterfaceChar().modButton();
        
        //ON INTERFACE MAP PANEL
        //Update the InterfaceMap panel to display the map with the new position of the player
        myGame.getInterfaceGame().getInterfaceMap().updateInterfaceMap(myGame);
        
        //ON INTERFACE PLANET PANEL
        //Check if the current planet of the player is different with the planet after his last move.
        if (last_visited_planet != myGame.getPlayer().getCurrentRoom().getPlanet()){
            //The current planet of the player is changed.
            last_visited_planet = myGame.getPlayer().getCurrentRoom().getPlanet();
            //Update the InterfacePanel with all the informations about the planet and launch a new timer.
            myGame.getInterfaceGame().getInterfacePlanet().updateInterfacePlanet(myGame);
        }
        
        //ON INTERFACE PLAYER PANEL
        myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
    }
}
