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
public class InterfaceRoom extends JFrame implements ActionListener
{
private JButton button1,button2,button3,button4;
private Game myGame;
private Room myRoom;
private Player myPlayer;
private JPanel myPanel;
public HashMap<String, Door>exit;

    /**
     * Constructor for objects of class InterfaceRoom
     */
    public InterfaceRoom(Game newGame)
    {
    myGame = newGame ;
    myPlayer = myGame.getPlayer();
    myRoom = myGame.getPlayer().getCurrentRoom();
    // list of the exits of the current room of the player
    for (int i=0; i < myRoom.exit.size(); i++)
        {
            //myPanel.add( new JButton("bllaa"));
      
    };
};
      
public void actionPerformed(ActionEvent e){
    };
    
 public JPanel getPanelRoom()
 { return myPanel;
    }
};
