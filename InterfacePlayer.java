import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * 
 * @author (Group7)
 * @version (11/12/18)
 */
public class InterfacePlayer extends JPanel implements ActionListener

{
    //declaration of the variables
    //private JFrame myFrame;
    private Game game;
    private JLabel descriptionLabel, roomLabel, moneyLabel, weightLabel, playerLabel, picture, updateRoomLabel, updateMoneyLabel, updateWeightLabel;
    private JButton bagButton;
    private JPanel panel1, panel2, panelFinalPlayer, panel3, panelRoom; 
    private JProgressBar lifeBar, updateLifeBar; 
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
        //
        
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
        //
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout (1,1));
        panel2.add(picture);
        //
        panelFinalPlayer = new JPanel();
        panelFinalPlayer.setLayout(new GridLayout (1,4));
        panelFinalPlayer.add(panel2);
        panelFinalPlayer.add(panel1);
        //
        updateInterfaceRoom(game);
        
    }
    
    public void updateInterfaceRoom(Game game){  
        
        panel1.removeAll();
        updateRoomLabel = new JLabel ("You are in the room : "+ game.getPlayer().getCurrentRoom().getName(), JLabel.CENTER);
        panel1.add(updateRoomLabel);
        
        panel1.add(playerLabel);
        
        updateLifeBar  = new JProgressBar(0, game.getPlayer().getLP());
        updateLifeBar.setValue(game.getPlayer().getLP()); 
        updateLifeBar.setStringPainted(true); 
        updateLifeBar.setForeground(Color.red);
        panel1.add(updateLifeBar);
        
        panel1.add(bagButton); 
        
        updateMoneyLabel = new JLabel ("Money : "+game.getPlayer().getMoney()+" pieces", JLabel.CENTER);
        panel1.add(updateMoneyLabel);
        
        updateWeightLabel = new JLabel ("Weight available in your bag : "+game.getPlayer().getTotalWeight(), JLabel.CENTER);
        panel1.add(updateWeightLabel); 
        
        panel1.revalidate();
        panel1.repaint(); 
    
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


  