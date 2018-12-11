import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * 
 * @author (Group7)
 * @version (04/12/18)
 */
public class InterfacePlayer extends JPanel implements ActionListener

{
    //declaration of the variables
    //private JFrame myFrame;
    private Game game;
    private JLabel descriptionLabel, roomLabel, moneyLabel, weightLabel, playerLabel, picture;
    private JButton bagButton;
    private JPanel panel1, panel2, panelFinalPlayer, panel3; 
    private JProgressBar lifeBar; 
    private ImageIcon image; 
    /**
     * Constructor for objects of class Counter
     */
    public InterfacePlayer(Game game)
    {
        this.game = game;
        bagButton = new JButton ("BAG");
        
        playerLabel = new JLabel ("Name : "+game.getPlayer().getName(), JLabel.CENTER);
        roomLabel = new JLabel ("You are in the room : "+ game.getPlayer().getCurrentRoom().getName(), JLabel.CENTER);
        moneyLabel = new JLabel ("Money : "+game.getPlayer().getMoney()+" pieces", JLabel.CENTER);
        weightLabel = new JLabel ("Weight available in your bag : "+game.getPlayer().getTotalWeight(), JLabel.CENTER);
        
        lifeBar  = new JProgressBar(0, game.getPlayer().getLP());
        lifeBar.setValue(game.getPlayer().getLP()); 
        lifeBar.setStringPainted(true); 
        lifeBar.setForeground(Color.red);
        //
        Icon imageAvatar = new ImageIcon("avatar/avatar.jpg");
        picture = new JLabel(imageAvatar, JLabel.CENTER);
        //
        panel1 = new JPanel(); 
        panel1.setLayout(new GridLayout (7,1));
        panel1.add(playerLabel);
        panel1.add(lifeBar);
        panel1.add(bagButton); 
        panel1.add(roomLabel);
        panel1.add(moneyLabel);
        panel1.add(weightLabel); 
        //
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout (1,1));
        panel2.add(picture);
        //
        panelFinalPlayer = new JPanel();
        panelFinalPlayer.setLayout(new GridLayout (1,3));
        panelFinalPlayer.add(panel2);
        panelFinalPlayer.add(panel1);
    }
    
    public void actionPerformed(ActionEvent e){
        game.getInterfaceGame().getInterfaceItem().showList(
            game.getPlayer().getListItems()
        );
    }
    
    public JPanel getPanelPlayer(){
        return panelFinalPlayer; 
    }
    
    public JProgressBar getLifeBar(){
        return lifeBar; 
    }
}


  