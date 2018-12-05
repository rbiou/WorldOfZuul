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
    private JLabel descriptionLabel, roomLabel, moneyLabel, weightLabel, playerLabel, picture;
    private JButton bagButton;
    private JPanel panel1, panel2, panelFinalPlayer, panel3; 
    private JProgressBar lifeBar; 
    private ImageIcon image; 
    /**
     * Constructor for objects of class Counter
     */
    public InterfacePlayer()
    {
        //myFrame = new JFrame ("GAME");
        //myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        bagButton = new JButton ("BAG");
        playerLabel = new JLabel ("Name : ", JLabel.CENTER);
        roomLabel = new JLabel ("You are in the room : ", JLabel.CENTER);
        moneyLabel = new JLabel ("Money : ", JLabel.CENTER);
        weightLabel = new JLabel ("Weight available in your bag : ", JLabel.CENTER);
        //
        lifeBar  = new JProgressBar(0, 100);
        lifeBar.setMaximum(100);
        lifeBar.setMinimum(0); 
        lifeBar.setStringPainted(true);
        //
        String name = "avatar"; 
        Icon imagePlanet = new ImageIcon(name+".jpg");
        picture = new JLabel(imagePlanet, JLabel.CENTER);
        //
        panel1 = new JPanel(); 
        panel1.setLayout(new GridLayout (7,1));
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
        //
        //this.add(panelFinalPlayer); 
        //this.pack();
        //this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
    }
    
    public JPanel getPanelPlayer(){
        return panelFinalPlayer; 
    }
}


  