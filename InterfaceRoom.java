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
public class InterfaceRoom extends JPanel implements ActionListener
{
    private JButton button1,button2,button3,button4;
    private Game myGame;
    private Room myRoom;
    private Player myPlayer;
    private JPanel myPanel;
    private ArrayList<JButton> button; 

    /**
     * Constructor for objects of class InterfaceRoom
     */
    public InterfaceRoom(Game newGame)
    {
        myGame = newGame ;
        myPlayer = myGame.getPlayer();
        myRoom = myGame.getPlayer().getCurrentRoom();
        myPanel = new JPanel();
        ArrayList <JButton> button = new ArrayList <JButton>();

        for (int i=0; i < myRoom.getNameDoor().size(); i++)
        {
            JButton btn = new JButton(myRoom.getNameDoor().get(i));
            myPanel.add(btn);
            btn.addActionListener(this);
            button.add(btn);
            };
            
         //System.out.println(button.size());
    };
    
    public void actionPerformed(ActionEvent e){
        // System.out.println(button.size());
    // for (int i=0; i < button.size(); i++) {
       // if ((JButton)e.getSource() ==  button.get(i)) { 
        // myGame.getPlayer().moveRoom(myRoom.exit.get(i));
        // this.revalidate();
        // this.repaint();
    // };
// };
};
    
    public JPanel getPanelRoom()
    { return myPanel;
    }
};
