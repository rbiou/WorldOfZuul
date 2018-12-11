import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 
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
    private InterfaceChar panelOfChar; 
    private InterfacePlayer panelOfPlayer;
    private InterfaceMap panelOfMap; 
    private InterfaceItem panelItems;
    private InterfaceRoom panelOfRoom; 
    private InterfacePets panelOfPets;
    private InterfacePlanet panelOfPlanet;
    private InterfaceDescription panelOfDescription; 
    private Game gamebis; 
    /**
     * Constructor for objects of class InterfaceGame
     */
    public InterfaceGame(Game game)
    {
        gamebis = game; 
        panelOfPlayer = new InterfacePlayer(game); 
        panelOfChar = new InterfaceChar(game);
        panelOfMap = new InterfaceMap(game);
        panelItems = new InterfaceItem(game);
        panelOfRoom = new InterfaceRoom(game);
        panelOfPlanet = new InterfacePlanet(game);
        panelOfDescription = new InterfaceDescription(game);

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
        panelDoor.add(panelOfRoom.getPanelRoom());

        panelMap = new JPanel();
        panelMap.setLayout(new GridLayout (1,1));
        panelMap.add(panelOfMap.getPanelMap());

        panelPlayer = new JPanel();
        panelPlayer.setLayout(new GridLayout (1,1));
        panelPlayer.add(panelOfPlayer.getPanelPlayer()); 

        panelPlanet = new JPanel();
        panelPlanet.setLayout(new GridLayout (1,1));
        panelPlanet.add(panelOfPlanet.getPanelPlanet());

        panelDescription = new JPanel(); 
        panelDescription.setLayout(new GridLayout (1,1));
        panelDescription.add(panelOfDescription);

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

    public void changerPanel(JPanel panel, JPanel mod){
        this.setContentPane(panel); 
        mod.revalidate(); 
        mod.repaint(); 
    }

    public void actionPerformed(ActionEvent e){
    }
    
    public InterfaceMap getInterfaceMap()
    { 
        return panelOfMap;
    }
    
    public InterfaceRoom getInterfaceRoom()
    { 
        return panelOfRoom;
    }
    
    public InterfacePlayer getInterfacePlayer()
    { 
        return panelOfPlayer;
    }
    
    public InterfaceChar getInterfaceChar()
    { 
        return panelOfChar;
    }
    
    public InterfacePets getInterfacePet()
    { 
        return panelOfPets;
    }
    
    public JPanel getPanelDescription(){
        return panelDescription;
    }
   
    public JPanel getPanelPlayer(){
        return panelPlayer;
    }

    public InterfaceItem getInterfaceItem()
    {
        return panelItems;
    }
    
    public InterfaceDescription getInterfaceDescription()
    {
        return panelOfDescription;
    }
}

