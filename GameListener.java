import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
 * The gameListener class is used to applicate event when the user clicks on
 * button from the 'InterfaceChar class'.
 * The different events are displayed in the panel 
 * description (in InterfaceClass)
 *
 * @author (group7)
 * @version (11/12/18)
 */
public class GameListener extends JPanel implements ActionListener
{
    //declaration of the variables
    private Game myGame;
    private InterfacePets panelOfPets;
    private InterfaceMonster panelOfMonster;
    private String reponse;
    private JOptionPane jop1;
    /**
     * Constructor for objects of class CharListener
     */
    public GameListener(Game theGame)
    {
        myGame = theGame;
    }

    /**
     * Here there are the different events : 
     *      when the user clicks on PetButton
     *      when the user clicks on MonsterButton
     *      when the user clicks on ChestButton
     *      when the user clicks on SellerButtonBuy
     *      when the user clicks on SellerButtonSell
     * All these buttons are instantiated in the InterfaceChar class.
     * 
     * The method 'updatePanelDescription()' (describes in Interface description)
     * allows us to update the panel description to display information.
     */
    public void actionPerformed (ActionEvent e)
    {
        //pet button
        if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getPetButton()){
            Pet recupPet = myGame.getPlayer().getCurrentRoom().getPet();
            panelOfPets = new InterfacePets(myGame, recupPet);
            myGame.getPlayer().pet(recupPet); //The player earn one piece
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelOfPets.getPanelPet());
            myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
        }
        //Monster button
        else if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getMonsterButton()){
            Monster recupMonster = myGame.getPlayer().getCurrentRoom().getMonster();
            panelOfMonster = new InterfaceMonster(myGame, recupMonster);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(panelOfMonster.getPanel1());
            myGame.getInterfaceGame().getInterfaceChar().getMonsterButton().setEnabled(false);
            
            myGame.getInterfaceGame().getInterfaceRoom().getPanelFinal().setVisible(false);
        }
        //chest button
        else if (e.getSource() ==  myGame.getInterfaceGame().getInterfaceChar().getChestButton()){
            Chest chestRecup = myGame.getPlayer().getCurrentRoom().getChest();
            InterfaceChest interfaceChest = new InterfaceChest(myGame, chestRecup.getListItems());
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceChest.getPanelItem());
            myGame.getPlayer().grabContent(chestRecup);
            myGame.getInterfaceGame().getInterfacePlayer().updateInterfacePlayer(myGame);
            if ( chestRecup.getIsTrap()){
                jop1 = new JOptionPane();
                ImageIcon img = new ImageIcon(new ImageIcon("trap/chest.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                jop1.showMessageDialog(null, "IT WAS A TRAP !! YOU LOSE 25 HP", "chest", JOptionPane.INFORMATION_MESSAGE,img);
            }       
            myGame.getInterfaceGame().getInterfaceChar().getChestButton().setEnabled(false);
            myGame.endGame();
        }
        //sell button
        else if (e.getSource() == myGame.getInterfaceGame().getInterfaceChar().getSellerButtonSell())
        {
            Player player = myGame.getPlayer();
            Seller seller = player.getCurrentRoom().getSeller();
            InterfaceItem interfaceItem = new InterfaceItem(myGame, player.getListItems());
            interfaceItem.getBuyButton().setEnabled(false);
            interfaceItem.getSellButton().setEnabled(true);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
            
        }
        //buy button
        else if (e.getSource() == myGame.getInterfaceGame().getInterfaceChar().getSellerButtonBuy())
        {
            Player player = myGame.getPlayer();
            Seller seller = player.getCurrentRoom().getSeller();
            InterfaceItem interfaceItem = new InterfaceItem(myGame, seller.getListItems());
            interfaceItem.getBuyButton().setEnabled(true);
            interfaceItem.getSellButton().setEnabled(false);
            myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(interfaceItem.getPanel());
        }
       

    }
}