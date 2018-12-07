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

                    //check if there is a Monster in the room
                    if (myGame.getPlayer().getCurrentRoom().getMonster() != null) {
                        myGame.getInterfaceGame().getInterfaceChar().getMonsterButton().setEnabled(true);
                        //event sur le bouton monster 
                    }
                    else {
                        myGame.getInterfaceGame().getInterfaceChar().getMonsterButton().setEnabled(false);
                    }
                    //check if there is a seller in the room
                    if (myGame.getPlayer().getCurrentRoom().getSeller() != null) {
                        myGame.getInterfaceGame().getInterfaceChar().getSellerButton().setEnabled(true);
                        //envent sur le bouton seller
                    }
                    else {
                        myGame.getInterfaceGame().getInterfaceChar().getSellerButton().setEnabled(false);
                    }
                    //check if there is a pet in the room
                    if (myGame.getPlayer().getCurrentRoom().getPet() != null) {
                        myGame.getInterfaceGame().getInterfaceChar().getPetButton().setEnabled(true);
                        if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getPetButton()){
                            myGame.getInterfaceGame().getPanelDescription().removeAll();
                            myGame.getInterfaceGame().getPanelDescription().add(myGame.getInterfaceGame().getInterfacePet().getPanelPet()); 
                        }
                    }
                    else {
                        myGame.getInterfaceGame().getInterfaceChar().getPetButton().setEnabled(false);
                    }
                    //check if there is a chest in the room
                    if (myGame.getPlayer().getCurrentRoom().getChest() != null) {
                        myGame.getInterfaceGame().getInterfaceChar().getChestButton().setEnabled(true);
                        if (e.getSource() == myGame.getInterfaceGame().getInterfaceChar().getChestButton()) {
                            //faire appel a la classe pour afficher la liste
                            myGame.getPlayer().grabContent(myGame.getPlayer().getCurrentRoom().getListChest().get(0));
                            myGame.getInterfaceGame().getInterfacePlayer().getLifeBar().setValue(myGame.getPlayer().getLP());
                        }
                    }
                    else {
                        myGame.getInterfaceGame().getInterfaceChar().getChestButton().setEnabled(false);
                    }
                };
                //Reload the room buttons panel
                myRoomPanel.revalidate();
                myRoomPanel.repaint();
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

        //ON PLAYER PANEL
    }
}
