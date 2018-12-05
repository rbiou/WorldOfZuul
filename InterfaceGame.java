import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class InterfaceGame here.
 *
 * @author (Group 7)
 * @version (04/12/18)
 */
public class InterfaceGame extends JFrame implements ActionListener
{

    private JFrame gameFrame; 
    private JPanel panelDoor, panelMap, panelPlayer, panelPlanet, panelDescription, panelChar, panelFinal; 
    private JMenuBar menuBar;
    private JMenu menuName;
    private JMenuItem menu1, menu2, menu3; 
    /**
     * Constructor for objects of class InterfaceGame
     */
    public InterfaceGame()
    {
        InterfacePlayer panelOfPlayer = new InterfacePlayer(); 
        InterfaceChar panelOfChar = new InterfaceChar(); 
        
        gameFrame = new JFrame ("GAME");
        gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar(); 
        
        this.setJMenuBar(menuBar); 
        menuName = new JMenu("GAME"); 
        this.menuBar.add(menuName); 
        menu1 = new JMenuItem ("Start"); 
        this.menuName.add(menu1);
        menu1.addActionListener(this); 
        menu2 = new JMenuItem ("Restart"); 
        this.menuName.add(menu2); 
        menu2.addActionListener(this); 
        menu3 = new JMenuItem ("Quit"); 
        this.menuName.add(menu3); 
        menu3.addActionListener(this);
        
        panelDoor = new JPanel();
        panelDoor.setLayout(new GridLayout (1,1));
        
        panelMap = new JPanel();
        panelMap.setLayout(new GridLayout (1,1));
        
        panelPlayer = new JPanel();
        panelPlayer.setLayout(new GridLayout (1,1));
        panelPlayer.add(panelOfPlayer.getPanelPlayer()); 
        
        panelPlanet = new JPanel();
        panelPlanet.setLayout(new GridLayout (1,1));
        
        panelDescription = new JPanel(); 
        panelDescription.setLayout(new GridLayout (1,1));
        
        panelChar = new JPanel(); 
        panelChar.setLayout(new GridLayout (1,1));
        panelChar.add(panelOfChar.getPanelChar());

        
        panelFinal = new JPanel(); 
        panelFinal.setLayout(new GridLayout (2,3));
        panelFinal.add(panelDoor); 
        panelFinal.add(panelMap);
        panelFinal.add(panelPlayer);
        panelFinal.add(panelChar); 
        panelFinal.add(panelDescription);
        panelFinal.add(panelPlanet);

        this.add(panelFinal); 
        this.pack();
        this.setVisible(true);
    }
    
        public void actionPerformed(ActionEvent e){
    }
}
