import java.awt.event.*;
import javax.swing.*;

/**
 * Décrivez votre classe Listener ici.
 *
 * @author (Lagrange Romain)
 * @version (5/12/2018)
 */
public class PetListener implements ActionListener
{
    // variables d'instance 
    private InterfacePets interPet;
    private Game myGame; 
    
    
    /**
     * Constructeur d'objets de classe Listener
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
    
             
             