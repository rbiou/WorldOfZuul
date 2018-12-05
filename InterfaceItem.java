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
    private JComboBox list;
    /**
     * Constructor for objects of class InterfaceItem
     */
    public InterfaceItem()
    // public InterfaceItem(ArrayList<Item> items)
    {

        // Label avec image
        String name = "Item";
        // Icon imageItem = new ImageIcon("./"+name+".png");
        Icon imageItem = new ImageIcon("Item.png");
       
         // Cration List
        list = new JComboBox();

        // for (Item item: items){
        //     list.addItem(item.getName());
        // }
        //Création du LabelItem
        labelItem = new JLabel ("List of item on your bag");
       
        labelItem.add(list);
       
        labelDescription = new JLabel("Description item");
        labelImage = new JLabel(imageItem);
       
        // panel 1 en bas
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout (1,2));
        panel1.add(labelItem);
        panel1.add(labelDescription);
       
       
        //Creation panel Final
        panelFinal = new JPanel();
        panelFinal.setLayout(new GridLayout(2,1));
        panelFinal.add(panel1);

    }
    
    public void actionPerformed(ActionEvent e){
    }

    public JPanel getPanel(){
        return panelFinal;
    }
}
