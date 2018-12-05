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
public class InterfaceChar extends JFrame implements ActionListener
{
    private JButton monsterButton, petButton, sellerButton, chestButton; 
    private JPanel panelChar; 
    /**
     * Constructor for objects of class InterfaceChar
     */
    public InterfaceChar(Game game)
    {
        monsterButton = new JButton("Monster");
        monsterButton.setSize(20,20);
        sellerButton = new JButton("Seller");
        petButton = new JButton("Pet");
        chestButton = new JButton("Chest"); 
        
        monsterButton.setPreferredSize(new Dimension(50, 50));
        monsterButton.setPreferredSize(new Dimension(50, 50));
        monsterButton.setPreferredSize(new Dimension(50, 50));
        
        panelChar = new JPanel();
        //panelChar.setPreferredSize(new Dimension(2,2));
        panelChar.setLayout(new GridLayout (4,1));
        panelChar.add(monsterButton); 
        panelChar.add(sellerButton); 
        panelChar.add(petButton);
        panelChar.add(chestButton);
    }

        public void actionPerformed(ActionEvent e){
    }
    
    public JPanel getPanelChar(){
        return panelChar; 
    }
}
