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
 * Class Interface Item shows the bag of the player and the seller when they interact. 
 * There are images of the item, list of items
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
     * @param  Game  game
     * @param  ArrayList<Item>  items
     */
    public InterfaceItem(Game game, ArrayList<Item> items)
    {
        //instanciation of the objects of the InterfaceItem
        this.game = game;
        
        buttonBuy = new JButton("Buy"); // Creation of the buy button
        buttonBuy.setEnabled(false);

        buttonSell = new JButton("Sell"); // Creation of the sell button
        buttonSell.setEnabled(false);

        // Link of the interface button and his action
        buttonBuy.addActionListener(this);
        buttonSell.addActionListener(this);

        // Creation List
        itemList = items;
        itemBox = new JComboBox();
        if (itemList != null){
            for (Item item: itemList){
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

    /**
     * Event associated to the JComboBox, buttonBuy and buttonSell
     */
    public void actionPerformed(ActionEvent e){
        // Get event origin
        Object source = e.getSource();

        if (source == itemBox) //select an item in the list
        {
            panel1.remove(labelImage);
            int itemNumber = itemBox.getSelectedIndex();
            //get the selected item
            selectedItem = itemList.get(itemNumber); 
            
            //display the image of the selectedItem
            Icon imageItem = new ImageIcon(new ImageIcon("items/"+ selectedItem.getName()+".png").getImage().getScaledInstance(150, 100, Image.SCALE_DEFAULT));
            
            labelImage = new JLabel(imageItem);
            
            //add the image in the panel
            panel1.add(labelImage);
            
            // reloade the labelImage
            labelImage.repaint();
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
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
                    game.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(game);
                    //update the panelDescription -> update the JComboBox
                    InterfaceItem interfaceItem = new InterfaceItem(game, seller.getListItems());
                    interfaceItem.getBuyButton().setEnabled(true);
                    interfaceItem.getSellButton().setEnabled(false);
                    game.getInterfaceGame().getInterfaceRoom().updateInterfaceRoom(game);
                    game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
                } else { //inform the user that he can not buy this item
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "It seems that you are not able to buy this object. Remember to check if you have enough space in your bag and if you have enough money!", "Information", JOptionPane.INFORMATION_MESSAGE);   
                }
            }
        }
        else if (source == buttonSell)
        {       
            if (selectedItem!=null){
                if (player.sellItem(seller, selectedItem))
                {
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Cheers, bro", "Information", JOptionPane.INFORMATION_MESSAGE);
                    game.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(game);
                    game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelFinal);
                    //update the panelDescription -> update the JComboBox
                    InterfaceItem interfaceItem = new InterfaceItem(game, player.getListItems());
                    interfaceItem.getBuyButton().setEnabled(false);
                    interfaceItem.getSellButton().setEnabled(true);
                    game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
                }
                else { //inform the user that he can not sell this item
                    JOptionPane jop1 = new JOptionPane();
                    jop1.showMessageDialog(null, "Come back when you'll be enough items for that boy.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }
    
    /**
     * getter of the panelFinal
     * @return JPanel panelFinal
     */
    public JPanel getPanel(){
        return panelFinal;
    }

     /**
     * getter of the selectedItem
     * @return Item selectedItem
     */
    public Item getSelectedItem(){
        return selectedItem;
    }

    /**
     * getter of the buttonBuy
     * @return JButton buttonBuy
     */
    public JButton getBuyButton(){
        return buttonBuy;
    }

    /**
     * getter of the buttonSell
     * @return JButton buttonSell
     */
    public JButton getSellButton(){
        return buttonSell;
    }
}
