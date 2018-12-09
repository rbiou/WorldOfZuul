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
    /**
     * Constructor for objects of class InterfaceChar
     */
    public InterfaceChar(Game game)
    {
        monsterButton = new JButton("Monster");
        labelSeller = new JLabel ("Interact with a seller : ", labelSeller.CENTER);
        sellerButtonBuy = new JButton("Buy something");
        sellerButtonSell = new JButton("Sell something");
        petButton = new JButton("Pet");
        chestButton = new JButton("Chest"); 
        monsterButton.setBackground(Color.gray);
        monsterButton.setForeground(Color.white);
        
        sellerButtonBuy.setBackground(Color.gray);
        sellerButtonBuy.setForeground(Color.white);
        
        sellerButtonSell.setBackground(Color.gray);
        sellerButtonSell.setForeground(Color.white);
        
        petButton.setBackground(Color.gray);
        petButton.setForeground(Color.white);
        
        chestButton.setBackground(Color.gray);
        chestButton.setForeground(Color.white);
        
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
}
