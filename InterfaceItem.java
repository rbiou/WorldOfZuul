import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
/**
 * Write a description of class InterfaceItem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class InterfaceItem extends JPanel implements ActionListener
{
    private JLabel labelImage,labelDescription, labelItem;;
    private ImageIcon imageItem;
    private JPanel panel1,panelFinal;
    private JComboBox itemBox;
    private ArrayList<Item> itemList;
    private Item selectedItem;
    /**
     * Constructor for objects of class InterfaceItem
     */
    public InterfaceItem(Game game)
    {

        // Label avec image
        String name = "Item";
        Icon imageItem = new ImageIcon(name+".png");
       
         // Cration List
        itemBox = new JComboBox();
        //Création du LabelItem
        labelItem = new JLabel ("List of item on your bag");
        labelItem.setHorizontalAlignment(JLabel.CENTER);
        labelItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelItem.setOpaque(true);
        labelItem.setBackground(Color.PINK);

        labelItem.add(itemBox);
        itemBox.addActionListener(this);
     
        labelDescription = new JLabel("Description item");
        labelDescription.setHorizontalAlignment(JLabel.CENTER);
        labelDescription.setOpaque(true);
        labelDescription.setBackground(Color.LIGHT_GRAY);
        labelDescription.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelImage = new JLabel(imageItem);
        
        // panel 1 en bas
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout (1,2));
        panel1.add(labelItem);
        panel1.add(labelDescription);
       
       
        //Creation panel Final
        panelFinal = new JPanel();
        panelFinal.setLayout(new GridLayout(2, 1));
        panelFinal.add(labelImage);
        panelFinal.add(panel1);
    }
    
    public void actionPerformed(ActionEvent e){
        int itemNumber = itemBox.getSelectedIndex();
        Item item = itemList.get(itemNumber);
        imageItem = new ImageIcon(item.getName()+".png");
        labelDescription.setText(item.getDescription());
    }

    public JPanel getPanel(){
        return panelFinal;
    }

    public void showList(ArrayList<Item> items){
        itemList = items;
        int n = itemBox.getItemCount();
        for(int i=0;i<n;i++){
            itemBox.removeItemAt(0);
        }
        for (Item item: items){
            itemBox.addItem(item.getName());
        }
    }

    public Item getSelectedItem(){
        return selectedItem;
    }
}
