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
    private JButton monsterButton, petButton, sellerButton, chestButton; 
    private JPanel panelChar; 
    /**
     * Constructor for objects of class InterfaceChar
     */
    public InterfaceChar(Game game)
    {
        monsterButton = new JButton("Monster");
        sellerButton = new JButton("Seller");
        petButton = new JButton("Pet");
        chestButton = new JButton("Chest"); 
        
        monsterButton.setBackground(Color.gray);
        monsterButton.setForeground(Color.white);
        
        sellerButton.setBackground(Color.gray);
        sellerButton.setForeground(Color.white);
        
        petButton.setBackground(Color.gray);
        petButton.setForeground(Color.white);
        
        chestButton.setBackground(Color.gray);
        chestButton.setForeground(Color.white);
        
        panelChar = new JPanel();
        panelChar.setLayout(new GridLayout(4,1));
        panelChar.add(monsterButton); 
        panelChar.add(sellerButton);
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
    
    public JButton getSellerButton(){
        return sellerButton; 
    }
}
