import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*; 
import javax.swing.ImageIcon;
import java.awt.Color;

/**
 * The InterfaceGame class contains the Frame of the game.
 * The frame is composed of 6 panels : 
 *      Player : displays all elements about a player (class : InterfacePlayer)
 *      Planet : displays all elements about a planet (class : InterfacePlanet
 *      Description : this panel is empty. It is used to display information : 
 *          - Interaction with a monster, a pet, a chest or a seller
 *          - display the items of the player
 *          This panel is update very often. 
 *      Map : displays the map of the game 
 *      Door : displays the possible exits of a room (class : InterfaceRoom)
 *      Character : displays 4 buttons (class : InterfaceChar)
 *  
 *
 * @author (Group 7)
 * @version (04/12/18)
 */
public class InterfaceGame extends JFrame implements ActionListener
{
    //declaration of the different variables
    private JFrame gameFrame; 
    private JPanel panelDoor, panelMap, panelPlayer, panelPlanet, panelDescription, panelChar, panelFinal; 
    private JMenuBar menuBar;
    private JMenu menuName;
    private JMenuItem menu1, menu2; 
    private InterfaceChar panelOfChar; 
    private InterfacePlayer panelOfPlayer;
    private InterfaceMap panelOfMap; 
    private InterfaceItem panelItems;
    private InterfaceRoom panelOfRoom; 
    private InterfacePets panelOfPets;
    private InterfacePlanet panelOfPlanet;
    private InterfaceDescription panelOfDescription; 
    private InterfaceMonster panelOfMonster;
    private Game gamebis; 
    private int option; //possible option = YES or NO (YES = restart the game, NO = quit the game)
    /**
     * Constructor for objects of class InterfaceGame
     * Creation of the 6 panels where it is added the 
     * different panels which come from other classes 
     */
    public InterfaceGame(Game game)
    {
        gamebis = game; 

        //Instantation of objects from the different classes
        panelOfPlayer = new InterfacePlayer(game); 
        panelOfChar = new InterfaceChar(game);
        panelOfMap = new InterfaceMap(game);
        panelItems = new InterfaceItem(game, null);
        panelOfRoom = new InterfaceRoom(game);
        panelOfPlanet = new InterfacePlanet(game); 
        panelOfDescription = new InterfaceDescription(game);

        //frame creation
        gameFrame = new JFrame ("GAME");
        gameFrame.setDefaultCloseOperation(gameFrame.DISPOSE_ON_CLOSE);
        menuBar = new JMenuBar(); 

        //menu creation
        this.setJMenuBar(menuBar); 
        menuName = new JMenu("GAME"); 
        this.menuBar.add(menuName); 
        menu1 = new JMenuItem ("Restart"); 
        this.menuName.add(menu1); 
        menu1.addActionListener(this); 
        menu2 = new JMenuItem ("Quit"); 
        this.menuName.add(menu2); 
        menu2.addActionListener(this);

        //panel door = displays exits
        panelDoor = new JPanel();
        panelDoor.setLayout(new GridLayout (1,1));
        panelDoor.add(panelOfRoom.getPanelFinal());

        //panel map = displays the map
        panelMap = new JPanel();
        panelMap.setLayout(new GridLayout (1,1));
        panelMap.add(panelOfMap.getPanelMap());

        //panel player = displays information about the player
        panelPlayer = new JPanel();
        panelPlayer.setLayout(new GridLayout (1,1));
        panelPlayer.add(panelOfPlayer.getPanelPlayer()); 

        //panel planet = displays information about the planet
        panelPlanet = new JPanel();
        panelPlanet.setLayout(new GridLayout (1,1));
        panelPlanet.add(panelOfPlanet.getPanelPlanet());

        //panel description = display many information (interaction with characters)
        panelDescription = new JPanel(); 
        panelDescription.setLayout(new GridLayout (1,1));
        panelDescription.add(panelOfDescription);
        //panel character = 4 buttons to interact with the character
        panelChar = new JPanel(); 
        panelChar.setLayout(new GridLayout (1,1));
        panelChar.add(panelOfChar.getPanelChar());

        //final panel = contains all the previous panel
        panelFinal = new JPanel(); 
        panelFinal.setLayout(new GridLayout (2,3));
        panelFinal.add(panelDoor); 
        panelFinal.add(panelMap);
        panelFinal.add(panelPlayer);
        panelFinal.add(panelChar); 
        panelFinal.add(panelDescription);
        panelFinal.add(panelPlanet);

        //add the final panel to the frame and displays the frame
        this.add(panelFinal); 
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() ==  gamebis.getInterfaceGame().getRestartMenuItem()){ 
            gamebis.resetGame();
        }
        if (e.getSource() ==  gamebis.getInterfaceGame().getQuitMenuItem()){
            gamebis.getInterfaceGame().getInterfacePlanet().getRoomTimer().cancel();
            System.exit(0);
        }
    }

    /**
     * Getter of the InterfaceMap
     * @return InterfaceMap : panelOfMap
     */
    public InterfaceMap getInterfaceMap()
    { 
        return panelOfMap;
    }

    /**
     * Getter of the InterfaceRoom
     * @return InterfaceRoom : panelOfRoom
     */
    public InterfaceRoom getInterfaceRoom()
    { 
        return panelOfRoom;
    }

    /**
     * Getter of the InterfacePlayer
     * @return InterfacePlayer : panelOfPlayer
     */
    public InterfacePlayer getInterfacePlayer()
    { 
        return panelOfPlayer;
    }

    /**
     * Getter of the InterfaceChar
     * @return InterfaceChar : panelOfChar
     */
    public InterfaceChar getInterfaceChar()
    { 
        return panelOfChar;
    }

    /**
     * Getter of the InterfacePet
     * @return InterfacePet : panelOfPets
     */
    public InterfacePets getInterfacePet()
    { 
        return panelOfPets;
    }

    /**
     * Getter of the InterfaceItem
     * @return InterfaceItem : panelOfItem
     */
    public InterfaceItem getInterfaceItem()
    {
        return panelItems;
    }

    /**
     * Getter of the InterfaceDescription
     * @return InterfaceDescription : panelOfDescription
     */
    public InterfaceDescription getInterfaceDescription()
    {
        return panelOfDescription;
    }

    /**
     * Getter of the InterfacePlanter
     * @return InterfacePlanet : panelOfPlanet
     */
    public InterfacePlanet getInterfacePlanet()
    {
        return panelOfPlanet;
    }

    /**
     * Getter of the InterfaceMonster
     * @return InterfaceMonster : panelOfMonster
     */
    public InterfaceMonster getInterfaceMonster()
    {
        return panelOfMonster;
    }

    /**
     * Getter of the RestartMenuItem
     * @return JMenuItem : menu1
     */
    public JMenuItem getRestartMenuItem(){
        return menu1; 
    }

    /**
     * Getter of the quittMenuItem
     * @return JMenuItem : menu2
     */
    public JMenuItem getQuitMenuItem(){
        return menu2; 
    }

    /**
     * Getter of the panelDescription
     * @return JPanel : panelDescription
     */
    public JPanel getPanelDescription(){
        return panelDescription;
    }

    /**
     * Getter of the panelPlayer
     * @return JPanel : panelPlayer
     */    
    public JPanel getPanelPlayer(){
        return panelPlayer;
    }

    /**
     * Display a window when the user wins the game
     * Ask if he wants to start again
     *        Answer = YES -> reset the game
     *        Answer = NO -> quit the game
     */
    public void popUpWin(){
        //image added in the window
        Icon icon = new ImageIcon(new ImageIcon("items/win.jpg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        //creation of the window with a specific message
        JOptionPane win = new JOptionPane();      
        option = win.showConfirmDialog(null, 
            "Congratulation you have win!! Now you can go on earth! \n  Do you want to start again ?", "WIN", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, icon);
        //events
        if (option == JOptionPane.OK_OPTION){ //when the user clicks on YES
            gamebis.resetGame();
        }
        else if (option == JOptionPane.NO_OPTION){ //when the user clicks on NO
            gamebis.getInterfaceGame().getInterfacePlanet().getRoomTimer().cancel();
            System.exit(0);
        }
    }

    /**
     * Display a window when the user loses the game
     * Ask if he wants to start again
     *        Answer = YES -> reset the game
     *        Answer = NO -> quit the game
     */
    public void popUpLose(){
        //image added in the window
        ImageIcon icon = new ImageIcon("items/lose.jpg");
        //creation of the window with a specific message
        JOptionPane win = new JOptionPane();
        Font f = new Font("Serif", Font.PLAIN, 20);         
        win.setFont(f);      
        option = win.showConfirmDialog(null, 
            "Oh no you lost!! \n  Do you want to start again ?", "LOSE", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, icon);
        //events
        if (option == JOptionPane.OK_OPTION){ //when the user clicks on YES
            gamebis.resetGame();
        }
        else if (option == JOptionPane.NO_OPTION){ //when the user clicks on NO
            gamebis.getInterfaceGame().getInterfacePlanet().getRoomTimer().cancel();
            System.exit(0);
        }
    }
}

