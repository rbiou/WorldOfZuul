import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class CharListener here.
 *
 * @author (group7)
 * @version (11/12/18)
 */
public class GameListener extends JPanel implements ActionListener
{
    private Game myGame;
    private InterfacePets panelOfPets;
    private InterfaceMonster panelOfMonster;
    /**
     * Constructor for objects of class CharListener
     */
    public GameListener(Game theGame)
    {
        myGame = theGame;
    }

    /**
     * 
     */
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getPetButton()){
            Pet recupPet = myGame.getPlayer().getCurrentRoom().getPet();
            panelOfPets = new InterfacePets(myGame, recupPet);
            myGame.getPlayer().pet(recupPet); //The player earn one piece
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelOfPets.getPanelPet());
            myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
        }

        else if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getMonsterButton()){
            Monster recupMonster = myGame.getPlayer().getCurrentRoom().getMonster();
            panelOfMonster = new InterfaceMonster(myGame, recupMonster);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelOfMonster.getPanel1());
        }

        else if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getChestButton()){
            Chest chestRecup = myGame.getPlayer().getCurrentRoom().getChest();
            myGame.getPlayer().grabContent(chestRecup);
            myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
        }

        else if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getSellerButtonBuy()){

        }

        else if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getSellerButtonSell()){

        }        
        
        else if (e.getSource() == myGame.getInterfaceGame().getInterfaceChar().getSellerButtonSell())
        {
            Player player =  myGame.getPlayer();
            InterfaceItem itemListPanel = myGame.getInterfaceGame().getInterfaceItem();
            itemListPanel.showList(player.getListItems());
            itemListPanel.getSellButton().setEnabled(true);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(myGame.getInterfaceGame().getInterfaceItem());
        }
        
        else if (e.getSource() == myGame.getInterfaceGame().getInterfaceChar().getSellerButtonBuy())
        {
            Seller seller = myGame.getPlayer().getCurrentRoom().getSeller();
            InterfaceItem itemListPanel = myGame.getInterfaceGame().getInterfaceItem();
            itemListPanel.showList(seller.getListItems());
            itemListPanel.getBuyButton().setEnabled(true);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(myGame.getInterfaceGame().getInterfaceItem());
        }
    }
}