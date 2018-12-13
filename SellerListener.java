import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * This class desribe the actions when the user click on 
 * seller's button (sell and buy)
 *
 * @author group7
 * @version 13/12/2018
 */
public class SellerListener implements ActionListener
{
    
    Game game;

    /**
     * Constructor for objects of class SellerListener
     */
    public SellerListener(Game game)
    {
        this.game = game;
    }

    /**
     * This method describes the grpahic events when the player interacts with de seller. 
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
