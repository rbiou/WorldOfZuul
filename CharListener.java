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
public class CharListener extends JPanel implements ActionListener
{
    private int x;
    private Game myGame; 
    
    /**
     * Constructor for objects of class CharListener
     */
    public CharListener(Game theGame)
    {
        myGame = theGame;
    }

    /**
     * 
     *
     */
    public void actionPerformed (ActionEvent e)
    {
        //check if there is a Monster in the room
        if (myGame.getPlayer().getCurrentRoom().getMonster() != null) {
            myGame.getInterfaceGame().getInterfaceChar().getMonsterButton().setEnabled(true);
            //event sur le bouton monster 
        }
        else {
            myGame.getInterfaceGame().getInterfaceChar().getMonsterButton().setEnabled(false);
        }

        //check if there is a seller in the room
        if (myGame.getPlayer().getCurrentRoom().getSeller() != null) {
            if (myGame.getPlayer().getMoney()>0) //check if the player has money to buy somthing
                myGame.getInterfaceGame().getInterfaceChar().getSellerButtonBuy().setEnabled(true);

            if (myGame.getPlayer().getListItems().size() > 0) //check if the player has items to sell
                myGame.getInterfaceGame().getInterfaceChar().getSellerButtonSell().setEnabled(true);                        
            //event sur le bouton seller
        }
        else {
            myGame.getInterfaceGame().getInterfaceChar().getSellerButtonBuy().setEnabled(false);
            myGame.getInterfaceGame().getInterfaceChar().getSellerButtonSell().setEnabled(false);
        }

        //check if there is a pet in the room
        if (myGame.getPlayer().getCurrentRoom().getPet() != null) {
            myGame.getInterfaceGame().getInterfaceChar().getPetButton().setEnabled(true);
            if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getPetButton()){
                myGame.getInterfaceGame().getPanelDescription().removeAll();
                myGame.getInterfaceGame().getPanelDescription().add(myGame.getInterfaceGame().getInterfacePet().getPanelPet()); 
                myGame.getInterfaceGame().getPanelDescription().revalidate();
                myGame.getInterfaceGame().getPanelDescription().repaint();
            }
        }
        else {
            myGame.getInterfaceGame().getInterfaceChar().getPetButton().setEnabled(false);
        }

        //check if there is a chest in the room
        if (myGame.getPlayer().getCurrentRoom().getChest() != null) {
            myGame.getInterfaceGame().getInterfaceChar().getChestButton().setEnabled(true);
            if (e.getSource() == myGame.getInterfaceGame().getInterfaceChar().getChestButton()) {
                //faire appel a la classe pour afficher la liste
                myGame.getPlayer().grabContent(myGame.getPlayer().getCurrentRoom().getListChest().get(0));
                myGame.getInterfaceGame().getInterfacePlayer().getLifeBar().setValue(myGame.getPlayer().getLP());
                //myGame.getInterfaceGame().getPanelPlayer().revalidate();
                //myGame.getInterfaceGame().getPanelPlayer().repaint();
            }
        }
        else {
            myGame.getInterfaceGame().getInterfaceChar().getChestButton().setEnabled(false);
        }
    }
}
