import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * InterfacePlayer class is used to display the panel of the player. 
 * This panel is composed of : 
 *      - The name of the player
 *      - Avatar of the player 
 *      - The room where he is (current room)
 *      - His life points with a bar life
 *      - His money 
 *      - His bag with a button 
 *      - The weight in his bag 
 * 
 * @author (Group7)
 * @version (11/12/18)
 */
public class InterfacePlayer extends JPanel implements ActionListener

{
    //declaration of the variables
    private Game game; //The Game
    private JLabel descriptionLabel, roomLabel, moneyLabel, weightLabel, playerLabel, picture; //JLanel of the interface. 
    private JButton bagButton; // The Button bag
    private JPanel panel1, panel2, panelFinalPlayer, panel3, panelRoom; //JPanel of the interface 
    private JProgressBar lifeBar, updateLifeBar; 
    private ImageIcon image; // The image of the player (avatar)
    private int playerLP;

    /**
     * Constructor for objects of class Counter
     */
    public InterfacePlayer(Game game)
    {
        panelFinalPlayer = new JPanel();
        this.game = game;
        updateInterfacePlayer(game); //method to add elements in the panel
    }

    /**
     * Construction of the panel with all elements
     * This methods is used to update the panel when the player
     * lost life points, made money, harvested items or moved (changed room)
     */
    public void updateInterfacePlayer(Game game){  

        panelFinalPlayer.removeAll(); //to update the panel

        //elements in the panel
        bagButton = new JButton ("BAG");
        bagButton.addActionListener(this);
        playerLabel = new JLabel ("Name : "+game.getPlayer().getName(), JLabel.CENTER);
        roomLabel = new JLabel ("You are in the room : "+ game.getPlayer().getCurrentRoom().getName(), JLabel.CENTER);
        moneyLabel = new JLabel ("Money : "+game.getPlayer().getMoney()+" pieces", JLabel.CENTER);
        weightLabel = new JLabel ("Weight available in your bag : "+game.getPlayer().getTotalWeight(), JLabel.CENTER);

        playerLP = game.getPlayer().getLP();
        lifeBar  = new JProgressBar(0, 100);
        lifeBar.setValue(playerLP); 
        lifeBar.setStringPainted(true);

        //change the color of lifeBar depending on the playerLP
        if (playerLP>75){
            lifeBar.setForeground(new Color(0,114,0));
        }else if (playerLP>50){
            lifeBar.setForeground(new Color(193,193,0));
        }else if (playerLP>25){
            lifeBar.setForeground(Color.orange);
        }else{
            lifeBar.setForeground(Color.red);
        }

        Icon imageAvatar = new ImageIcon(new ImageIcon("avatar/"+game.getPlayerSexe()+".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        picture = new JLabel(imageAvatar, JLabel.CENTER);

        //different elements are added to the panel
        panel1 = new JPanel(); 
        panel1.setLayout(new GridLayout (7,1));
        panel1.add(playerLabel);
        panel1.add(lifeBar); 
        panel1.add(roomLabel);
        panel1.add(moneyLabel);
        panel1.add(weightLabel);
        panel1.add(bagButton);

        //Another panel to add the avatar
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout (1,1));
        panel2.add(picture);

        //Final panel with the two other panels
        panelFinalPlayer.setLayout(new GridLayout (1,4));
        panelFinalPlayer.add(panel2);
        panelFinalPlayer.add(panel1);

        //update the final panel
        panelFinalPlayer.revalidate();
        panelFinalPlayer.repaint(); 

    }

    public void actionPerformed(ActionEvent e){
        System.out.println ("ok");
        InterfaceItem interfaceItem = new InterfaceItem(game, game.getPlayer().getListItems());
        game.getInterfaceGame().getInterfaceItem();
        game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
    }

    /**
     * getter of the panel player
     * @return   JPanel -> panelFinalPlayer
     */
    public JPanel getPanelPlayer(){
        return panelFinalPlayer; 
    }

    /**
     * getter of the player's life bar
     * @return   JProgressBar -> lifeBar
     */
    public JProgressBar getLifeBar(){
        return lifeBar; 
    }
}

