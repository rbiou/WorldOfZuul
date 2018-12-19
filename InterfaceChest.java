import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.*;
/**
 * This class allows us to display items' name.
 * These items are those which are present in the 
 * chest that the player opened.
 * The player wins these items.
 *
 * @author (Group7)
 * @version (18/12/18)
 */
public class InterfaceChest extends JPanel
{
    //declarations
    private JPanel panelChest; 
    private JTextArea displayItems;
    private JLabel labelItem, labelPres, labelend; 
    /**
     * Constructor for objects of class InterfaceChest
     * Constructor of the chest Interface -> a chestPanel
     */
    public InterfaceChest(ArrayList<Item> items)
    { 
        boolean ok = false; //use to display a message where there is something in the chest

        panelChest = new JPanel(); //chest panel
        panelChest.removeAll(); //remove the panel - allow to update the panel

        labelPres = new JLabel("Oh good, you may have win something : ");
        panelChest.add(labelPres);

        //display in the panel, the name of each item presents in the chest
        if (items != null){
            for (int i = 0; i<items.size(); i++){
                labelItem = new JLabel();
                labelItem.setText(items.get(i).getName()+" / ");
                panelChest.add(labelItem); 
                ok = true; 
            }
        }
        //if there is something in the chest -> display a specific message
        if (ok) {
            labelend = new JLabel("Go in your bag to see what are this(these) specific object(s) !");
            panelChest.add(labelend);
        }
        //update the panel
        panelChest.revalidate(); 
        panelChest.repaint();
    }
    
    /**
     * getter of the chest panel
     * @return  JPanel  panelChest
     */
    public JPanel getPanelItem(){
        return panelChest; 
    }

}
