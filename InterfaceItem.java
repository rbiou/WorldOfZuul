import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
/**
 * Write a description of class InterfaceItem here.
 *
 * @author Group7
 * @version 12/12/18
 */
public class InterfaceItem extends JPanel implements ActionListener
{
    private JLabel labelImage,labelDescription;
    private ImageIcon imageItem;
    private JPanel panel1, panel2,panelFinal;
    private JComboBox itemBox;
    private ArrayList<Item> itemList;
    private Item selectedItem;
    private JButton buttonBuy, buttonSell;
    private Game game;
    /**
     * Constructor for objects of class InterfaceItem
     */
    public InterfaceItem(Game game)
    {

        //instanciation of the objects of the InterfaceItem
        this.game = game;
        String name = "Item";
        Icon imageItem = new ImageIcon(name+".png");
        buttonBuy = new JButton("Buy");
        buttonBuy.setBackground(Color.YELLOW);
        buttonBuy.setPreferredSize(new Dimension(60,40));
        buttonSell = new JButton("Sell");
        buttonBuy.setPreferredSize(new Dimension(60,40));
        buttonBuy.setEnabled(false);
        buttonSell.setEnabled(false);
        
        buttonBuy.addActionListener(this);
        buttonSell.addActionListener(this);
        
        
        
        // Creation List
        itemBox = new JComboBox();
        itemBox.addActionListener(this);
        
        //Création du LabelItem
        
        labelImage = new JLabel(imageItem);
        labelDescription = new JLabel();
        
        // panel 1 en bas
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout (1,2));
        panel1.add(itemBox);
        panel1.add(labelDescription);
        
        //panel 2 
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout ());
        
        GridBagConstraints gbc= new GridBagConstraints();
        
        gbc.gridx = 0;
        gbc.gridy=0;
        
        gbc.gridheight=1;
        gbc.gridwidth=1;
        panel2.add(buttonSell, gbc);
        
        gbc.gridx = 1;
        panel2.add(buttonBuy, gbc);
        
       
        
       
        //Creation panel Final
        panelFinal = new JPanel();
        panelFinal.setLayout(new GridLayout(3, 1));
        panelFinal.add(labelImage);
        panelFinal.add(panel1);
        panelFinal.add(panel2);
        
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        // Get event origin
        Object source = e.getSource();


        if (source == itemBox)
        {
            int itemNumber = itemBox.getSelectedIndex();
            selectedItem = itemList.get(itemNumber);
            imageItem = new ImageIcon(selectedItem.getName()+".png");
            labelDescription.setText(selectedItem.getDescription());
            return;
        }

        // Get player and seller
        Seller seller = game.getPlayer().getCurrentRoom().getSeller();
        Player player = game.getPlayer();

        if (source == buttonBuy)
        {
            if (player.buyItem(seller, selectedItem))
            {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Come back when you'll be wealthy enough for that boy.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (source == buttonSell)
        {
            JOptionPane jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public JPanel getPanel(){
        return panelFinal;
    }

    public void showList(ArrayList<Item> items){
        itemList = items;
        int n = itemBox.getItemCount();
        System.out.println(n);
        itemBox.removeAllItems();
        for (Item item: items){
            System.out.println(item.getName());
            itemBox.addItem(item.getName());
        }
    }

    public Item getSelectedItem(){
        return selectedItem;
    }
    
    public JButton getBuyButton(){
        return buttonBuy;
    }

    public JButton getSellButton(){
        return buttonSell;
    }
}
