import java.awt.event.*;
import javax.swing.*;

/**
 * PetListener class : this class group all the action performed when the player presses pet
 *
 * @author (Group7)
 * @version (5/12/2018)
 */
public class PetListener implements ActionListener
{
    //declaration of the variables
    private InterfacePets interPet; //The pet of interface
    private Game myGame; //The Game
    
    
    /**
     * Constructor for objects of class Listener
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
        //check answer monster
         if (e.getSource()== interPet.getButtonPet()){
            
             myGame.getInterfaceGame().getInterfaceDescription().updatePanelDescription(new JPanel());
            }
        }
    }
    
             
             