import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class SellerListener here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SellerListener implements ActionListener
{
    // instance variables - replace the example below with your own
    private int x;
    Game game;

    /**
     * Constructor for objects of class SellerListener
     */
    public SellerListener(Game game)
    {
        this.game = game;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == game.getInterfaceGame().getInterfaceChar().getSellerButtonSell())
        {
            Player player = game.getPlayer();
            Seller seller = player.getCurrentRoom().getSeller();
            InterfaceItem interfaceItem = game.getInterfaceGame().getInterfaceItem();
            interfaceItem.getBuyButton().setEnabled(false);
            interfaceItem.getSellButton().setEnabled(true);
            interfaceItem.showList(player.getListItems());
            game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
        }
        
        else if (e.getSource() == game.getInterfaceGame().getInterfaceChar().getSellerButtonBuy())
        {
            Player player = game.getPlayer();
            Seller seller = player.getCurrentRoom().getSeller();
            InterfaceItem interfaceItem = game.getInterfaceGame().getInterfaceItem();
            interfaceItem.getBuyButton().setEnabled(true);
            interfaceItem.getSellButton().setEnabled(false);
            interfaceItem.showList(seller.getListItems());
            game.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
        }     
    }
}
