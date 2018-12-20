import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
/**
 * Class Interface Item shows the bag of the player and the seller when they interact. There are image og the item, listof item
 * with her description.
 *
 * @author Group7
 * @version 12/12/18
 */
public class InterfaceItem extends JPanel implements ActionListener
{
    private JLabel labelImage; // JLabel for images and descriptions of the items. 
    private JTextArea labelDescription;
    private ImageIcon imageItem; // Image of items
    private JPanel panelb, panels, panel1, panel2, panelImage, panelFinal; // Panel of the InterfaceItem
    private JComboBox itemBox; // Box where is the list of items.
    private ArrayList<Item> itemList; // List of items
    private Item selectedItem; // when the player selects item
    private JButton buttonBuy, buttonSell; // The buttons to sell and to buy
    private Game game; 
    /**
     * Constructor for objects of class InterfaceItem
     */
    public InterfaceItem(Game game, ArrayList<Item> items)
    {
        //instanciation of the objects of the InterfaceItem
        this.game = game;
        Icon imageItem = new ImageIcon("items/Red key.png");
        buttonBuy = new JButton("Buy"); // Creation of the buy button
        buttonBuy.setEnabled(false);

        buttonSell = new JButton("Sell"); // Creation of the sell button
        buttonSell.setEnabled(false);

        //buttonBuy.setEnabled(false); // The button is accessible or not.
        //buttonSell.setEnabled(false);

        // Link of the interface button and his action
        buttonBuy.addActionListener(this);
        buttonSell.addActionListener(this);

        // Creation List
        itemList = items;
        itemBox = new JComboBox();
        if (itemList != null){
            for (Item item: itemList){
                System.out.println(item.getName());
                itemBox.addItem(item.getName());
            }
            itemBox.addActionListener(this);
        }

        //Création of LabelItem
        labelDescription = new JTextArea();
        labelDescription.setLineWrap(true); 
        labelDescription.setWrapStyleWord(true); 
        labelDescription.setOpaque(false); 
        labelDescription.setEditable(false); 

        panelImage = new JPanel();
        labelImage = new JLabel();
        panelImage.add(labelImage);

        // panel 1 South panel
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout (1,2));
        panel1.add(itemBox);
        panel1.add(labelDescription);

        //panel 2 with buttons
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout (1,2));
        panel2.add(buttonBuy);
        panel2.add(buttonSell);

        //Creation panel Final
        panelFinal = new JPanel();
        panelFinal.setLayout(new GridLayout(3, 1));
        panelFinal.add(panelImage);
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

            labelImage.setIcon(new ImageIcon("items/" + selectedItem.getName()+".png"));
            labelImage.repaint();

            System.out.println(selectedItem.getName());
            labelDescription.setText(selectedItem.getDescription()+ "\n Price : " +selectedItem.getValue());

            return;
        }

        // Get player and seller
        Seller seller = game.getPlayer().getCurrentRoom().getSeller();
        Player player = game.getPlayer();

        if (source == buttonBuy)
        {       
            if (selectedItem!=null){
                if (player.buyItem(seller, selectedItem))
                {
                    System.out.println("Achat");
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
                    game.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(game);
                    
                    InterfaceItem interfaceItem = new InterfaceItem(game, game.getPlayer().getCurrentRoom().getSeller().getListItems());
                    interfaceItem.getBuyButton().setEnabled(true);
                    interfaceItem.getSellButton().setEnabled(false);
                    game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
                } else {
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Come back when you'll be wealthy enough for that boy.", "Information", JOptionPane.INFORMATION_MESSAGE);   
                }
            }
        }
        else if (source == buttonSell)
        {       
            if (selectedItem!=null){
                if (player.sellItem(seller, selectedItem))
                {
                    System.out.println("Vente");
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
                    game.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(game);
                    game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelFinal);

                    InterfaceItem interfaceItem = new InterfaceItem(game, game.getPlayer().getListItems());
                    interfaceItem.getBuyButton().setEnabled(false);
                    interfaceItem.getSellButton().setEnabled(true);
                    game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
                }
                else {
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Come back when you'll be enough items for that boy.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    public JPanel getPanel(){
        return panelFinal;
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
