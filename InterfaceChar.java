import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * Write a description of class InterfaceChar here.
 *
 * @author (Group 7)
 * @version (04/12/18)
 */
public class InterfaceChar extends JFrame 
{
    private JButton monsterButton, petButton, sellerButtonBuy, sellerButtonSell, chestButton; 
    private JPanel panelChar, panelSeller; 
    private JLabel labelSeller;
    private Game myGame; 
    /**
     * Constructor for objects of class InterfaceChar
     */
    public InterfaceChar(Game game)
    {
        myGame = game; 
        monsterButton = new JButton("Monster");
        labelSeller = new JLabel ("Interact with a seller : ", labelSeller.CENTER);
        sellerButtonBuy = new JButton("Buy something");
        sellerButtonSell = new JButton("Sell something");
        petButton = new JButton("Pet");
        chestButton = new JButton("Chest"); 
        
        monsterButton.setBackground(Color.gray);
        monsterButton.setForeground(Color.white);
        monsterButton.setEnabled(false);

        sellerButtonBuy.setBackground(Color.gray);
        sellerButtonBuy.setForeground(Color.white);
        sellerButtonBuy.setEnabled(false);
        
        sellerButtonSell.setBackground(Color.gray);
        sellerButtonSell.setForeground(Color.white);
        sellerButtonSell.setEnabled(false);
        
        petButton.setBackground(Color.gray);
        petButton.setForeground(Color.white);
        petButton.setEnabled(false);
        
        chestButton.setBackground(Color.gray);
        chestButton.setForeground(Color.white);
        chestButton.setEnabled(false); 
        
        panelSeller = new JPanel();
        panelSeller.setLayout(new GridLayout(1,3));
        panelSeller.add(labelSeller); 
        panelSeller.add(sellerButtonBuy); 
        panelSeller.add(sellerButtonSell); 

        panelChar = new JPanel();
        panelChar.setLayout(new GridLayout(4,1));
        panelChar.add(monsterButton); 
        panelChar.add(panelSeller);
        panelChar.add(petButton);
        panelChar.add(chestButton);
    }

    public JPanel getPanelChar(){
        return panelChar; 
    }

    public JButton getChestButton(){
        return chestButton; 
    }

    public JButton getMonsterButton(){
        return monsterButton; 
    }

    public JButton getPetButton(){
        return petButton; 
    }

    public JButton getSellerButtonBuy(){
        return sellerButtonBuy; 
    }

    public JButton getSellerButtonSell(){
        return sellerButtonSell; 
    }

    public void modButton(){
        
        //check if there is a Monster in the room    
        if (myGame.getPlayer().getCurrentRoom().getMonster() != null) {
            monsterButton.setEnabled(true);
        }
        else {
            monsterButton.setEnabled(false);
        }

        //check if there is a seller in the room
        if (myGame.getPlayer().getCurrentRoom().getSeller() != null) {
            if (myGame.getPlayer().getMoney()>0) //check if the player has money to buy somthing
                sellerButtonBuy.setEnabled(true);

            if (myGame.getPlayer().getListItems().size() > 0) //check if the player has items to sell
                sellerButtonSell.setEnabled(true);                        
        }
        else {
            sellerButtonBuy.setEnabled(false);
            sellerButtonSell.setEnabled(false);
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
            chestButton.setEnabled(true);
        }
        else {
            chestButton.setEnabled(false);
        }
    }
}
