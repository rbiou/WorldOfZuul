import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.*;
/**
 * Write a description of class InterfaceChest here.
 *
 * @author (Group7)
 * @version (18/12/18)
 */
public class InterfaceChest extends JPanel
{
    private Game myGame; 
    private JPanel panelChest; 
    private JTextArea displayItems;
    private JLabel labelItem, labelPres, labelImage, labelend; 
    /**
     * Constructor for objects of class InterfaceChest
     */
    public InterfaceChest(Game game, ArrayList<Item> items)
    {

        myGame = game; 
        boolean ok = false; 
        panelChest = new JPanel();
        panelChest.removeAll();
        
        labelPres = new JLabel("Oh good, you may have win something : ");
        //labelItem = new JLabel("Oh no sorry, there is nothing in this chest :( ! ");
        panelChest.add(labelPres);
        //panelChest.add(labelItem);
        if (items != null){
            for (int i = 0; i<items.size(); i++){
                labelItem = new JLabel();
                labelItem.setText(items.get(i).getName()+" / ");
                panelChest.add(labelItem); 
                ok = true; 
            }
        }
        
        if (ok) {
          labelend = new JLabel("Go in your bag to see what are this(these) specific object(s) !");
          panelChest.add(labelend);
    }
    panelChest.revalidate(); 
    panelChest.repaint();
}

    public JPanel getPanelItem(){
        return panelChest; 
    }

}
