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
 * Class Interface Item shows the bag of the player and the seller when they interact. There are image og the item, listof item
 * with her description
 *
 * @author Group7
 * @version 12/12/18
 */
public class InterfaceItem extends JPanel implements ActionListener
{
    private JLabel labelImage,labelDescription; // JLabel for images and descriptions of the items. 
    private ImageIcon imageItem; // Image of items
    private JPanel panel1, panel2,panelFinal; // Panel of the InterfaceItem
    private JComboBox itemBox; // Box where is the list of items.
    private ArrayList<Item> itemList; // List of items
    private Item selectedItem; // when the player selects item
    private JButton buttonBuy, buttonSell; // The buttons to sell and to buy
    private Game game; 
    /**
     * Constructor for objects of class InterfaceItem
     */
    public InterfaceItem(Game game)
    {

        //instanciation of the objects of the InterfaceItem
        this.game = game;
        String name = "Item"; // name of the item, it is associated with the name of the image
        Icon imageItem = new ImageIcon(name+".png");
        buttonBuy = new JButton("Buy"); // Creation of the buy button
        buttonBuy.setBackground(Color.YELLOW); // Color of the button
        buttonBuy.setPreferredSize(new Dimension(1000,40)); // size of the button
        buttonSell = new JButton("Sell"); // Creation of the sell button
        buttonSell.setBackground(Color.BLUE); // Color of the button
        buttonSell.setPreferredSize(new Dimension(1000,40)); // size of the button
        //buttonBuy.setEnabled(false); // The button is accessible or not.
        //buttonSell.setEnabled(false);

        // Link of the interface button and his action
        buttonBuy.addActionListener(this); 
        buttonSell.addActionListener(this); 

        // Creation List
        itemBox = new JComboBox();
        itemBox.addActionListener(this);

        //Création of LabelItem

        labelImage = new JLabel(imageItem);
        labelDescription = new JLabel();

        // panel 1 South panel
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout (1,2));
        panel1.add(itemBox);
        panel1.add(labelDescription);

        //panel 2 with buttons
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout ());

        GridBagConstraints gbc= new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy=0;
        gbc.insets= new Insets(10,10,0,0);
        gbc.ipadx=10;

        gbc.gridheight=2;
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
                game.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(game);
                game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(game.getInterfaceGame().getInterfaceItem().getPanel());
            } else {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Come back when you'll be wealthy enough for that boy.", "Information", JOptionPane.INFORMATION_MESSAGE);   
            }
        }
        else if (source == buttonSell)
        {   
            if (player.sellItem(seller, selectedItem))
            {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
                game.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(game);
                game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(game.getInterfaceGame().getInterfaceItem().getPanel());
            }
            else {
                JOptionPane jop1 = new JOptionPane();
                jop1.showMessageDialog(null, "Come back when you'll be enough items for that boy.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
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
