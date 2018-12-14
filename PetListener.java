import java.awt.event.*;
import javax.swing.*;

/**
 * PetListener class : this class group all the action performed when the player presses pet
 *
 * @author (Group7)
 * @version (13/12/2018)
 */
public class PetListener implements ActionListener
{
    //declaration of the variables
    private InterfacePets interPet; //The pet of interface
    private Game myGame; //The Game
    
    
    /**
     * Constructor for objects of class Listener
     * @param : interfacePet and game
     */
    public PetListener(InterfacePets i, Game game)
    {
        interPet = i;
        myGame = game;
    }
    
    /**
     * Action performed for the different buttons
     */
    public void actionPerformed(ActionEvent e){
        //When the player click on the validate button, he win 1 gold, so we must update the player panel
         if (e.getSource()== interPet.getButtonPet()){
            
             myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(new JPanel());
            }
        }
    }
    
             
             
