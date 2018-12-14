import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * This class is the panel of 4 buttons : Monster, Chest, Pet 
 * and Seller (Buy or Sell)
 * 
 *      Monster : When we click on it -> interact with a monster : an enigma
 *      Pet : Interact with a pet to have information about a planet and to 
 *            earn one piece.
 *      Chest : to open a chest 
 *      Buy : to buy something to a seller
 *      Sell : to sell something to a seller
 *      
 * All interactions are displayed in the panel 'PanelDescription' in the
 * InterfaceGame class which contains the frame.
 * The user can't click on the button when there is no monster, pet, chest or 
 * seller in the room. 
 * 
 * @author (Group 7)
 * @version (04/12/18)
 */
public class InterfaceChar extends JFrame 
{
    //declaration of the variables
    private JButton monsterButton, petButton, sellerButtonBuy, sellerButtonSell, chestButton; // The different buttons
    private JPanel panelChar, panelSeller; // The panel of the char interface
    private JLabel labelSeller; // The JLabel of the char interface
    private Game myGame; // The game
    /**
     * Constructor for objects of class InterfaceChar
     * Construction of the panel
     */
    public InterfaceChar(Game game)
    {
        myGame = game;
        //elements in the panel
        monsterButton = new JButton("Monster");
        labelSeller = new JLabel ("Interact with a seller : ", labelSeller.CENTER);
        sellerButtonBuy = new JButton("Buy something");
        sellerButtonBuy.addActionListener(new GameListener(game));
        sellerButtonSell = new JButton("Sell something");
        sellerButtonSell.addActionListener(new GameListener(game));
        petButton = new JButton("Pet");
        chestButton = new JButton("Chest");
        
        //The button of the monster
        monsterButton.setBackground(Color.gray);
        monsterButton.setForeground(Color.white);
        monsterButton.setEnabled(false);
        monsterButton.addActionListener(new GameListener(myGame));

        sellerButtonBuy.setBackground(Color.gray);
        sellerButtonBuy.setForeground(Color.white);
        sellerButtonBuy.setEnabled(false);
        sellerButtonBuy.addActionListener(new GameListener(myGame));        

        sellerButtonSell.setBackground(Color.gray);
        sellerButtonSell.setForeground(Color.white);
        sellerButtonSell.setEnabled(false);
        sellerButtonSell.addActionListener(new GameListener(myGame));        

        petButton.setBackground(Color.gray);
        petButton.setForeground(Color.white);
        petButton.setEnabled(false);
        petButton.addActionListener(new GameListener(myGame));        
        
        chestButton.setBackground(Color.gray);
        chestButton.setForeground(Color.white);
        chestButton.setEnabled(false); 
        chestButton.addActionListener(new GameListener(myGame));
        
        //The panel seller contains the buttons buy and sell
        panelSeller = new JPanel();
        panelSeller.setLayout(new GridLayout(1,3));
        panelSeller.add(labelSeller); 
        panelSeller.add(sellerButtonBuy); 
        panelSeller.add(sellerButtonSell); 
        
        //panel character = contains all the previous panel
        panelChar = new JPanel();
        panelChar.setLayout(new GridLayout(4,1));
        panelChar.add(monsterButton); 
        panelChar.add(panelSeller);
        panelChar.add(petButton);
        panelChar.add(chestButton);
    }

    /**
     * Getter of the panelChar
     * @return : JPanel -> panelChar
     */
    public JPanel getPanelChar(){
        return panelChar; 
    }

    /**
     * Getter of the chestButton
     * @return : JButton -> chestButton
     */
    public JButton getChestButton(){
        return chestButton; 
    }

    /**
     * Getter of the monsterButton
     * @return : JButton -> monsterButton
     */    
    public JButton getMonsterButton(){
        return monsterButton; 
    }

    /**
     * Getter of the petButton
     * @return : JButton -> petButton
     */    
    public JButton getPetButton(){
        return petButton; 
    }

    /**
     * Getter of the sellerButtonBuy
     * @return : JButton -> sellerButtonBuy
     */    
    public JButton getSellerButtonBuy(){
        return sellerButtonBuy; 
    }

    /**
     * Getter of the sellerButtonSell
     * @return : JButton -> sellerButtonSell
     */      
    public JButton getSellerButtonSell(){
        return sellerButtonSell; 
    }

    /**
     * The button is accessible or not depending on characters present
     * in the room
     */ 
    public void modButton(){

        //check if there is a Monster in the room    
        if (myGame.getPlayer().getCurrentRoom().getMonster() != null) {
            if (!myGame.getPlayer().getCurrentRoom().getMonster().getIsResolved())
                monsterButton.setEnabled(true);
        }
        else {
            monsterButton.setEnabled(false);
        }

        //check if there is a seller in the room
        if (myGame.getPlayer().getCurrentRoom().getSeller() != null) {
            if (myGame.getPlayer().getMoney()>0) //check if the player has money to buy somthing
                sellerButtonBuy.setEnabled(true);
            myGame.getInterfaceGame().getInterfaceItem().getBuyButton().setEnabled(true);

            if (myGame.getPlayer().getListItems().size() > 0) //check if the player has items to sell
                sellerButtonSell.setEnabled(true);  
            myGame.getInterfaceGame().getInterfaceItem().getSellButton().setEnabled(true);
        }
        else {
            sellerButtonBuy.setEnabled(false);
            sellerButtonSell.setEnabled(false);
            myGame.getInterfaceGame().getInterfaceItem().getSellButton().setEnabled(false);
            myGame.getInterfaceGame().getInterfaceItem().getBuyButton().setEnabled(false);
        }

        //check if there is a pet in the room
        if (myGame.getPlayer().getCurrentRoom().getPet() != null) {
            petButton.setEnabled(true);
        }
        else {
            petButton.setEnabled(false);
        }

        //check if there is a chest in the room
        if (myGame.getPlayer().getCurrentRoom().getChest() != null) {
            //Check if the chest is already open -> the user can't open it again
            if (myGame.getPlayer().getCurrentRoom().getChest().getIsOpened()==false)
                chestButton.setEnabled(true);
            else 
                chestButton.setEnabled(false);
        }
        else {
            chestButton.setEnabled(false);
        }
    }
}
