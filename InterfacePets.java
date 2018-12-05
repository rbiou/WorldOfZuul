import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
/**
 * Décrivez votre classe Listener ici.
 *
 * @MARLIAT Julien
 * @5/12/2018
 */
public class InterfacePets 
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
     private JPanel panel1 ;
     private JLabel label1 ,label2;
     private ImageIcon petsimage; 
     private String namePet;
    /**
     * Constructeur d'objets de classe Listener
     */
    public InterfacePets(Game game)
    {
       panel1 = new JPanel(); 
       
       for (int i=0;i<game.getPlayer().getCurrentRoom().getListCharacter().size();i++)
       {if(game.getPlayer().getCurrentRoom().getListCharacter().get(i).getName()== "Bamby" ||game.getPlayer().getCurrentRoom().getListCharacter().get(i).getName() == "Timon" || 
           game.getPlayer().getCurrentRoom().getListCharacter().get(i).getName() == "Pumba" ||game.getPlayer().getCurrentRoom().getListCharacter().get(i).getName() == "Dolly" || game.getPlayer().getCurrentRoom().getListCharacter().get(i).getName() == "Winnie")
           namePet=game.getPlayer().getCurrentRoom().getListCharacter().get(i).getName(); 
        }
        label1 = new JLabel("*** THANK YOU FOR YOUR VISIT AND TAKING SOME TIMES FOR ME ***  I AM" +namePet+ " *** HERE A RECOMPENSE***",JLabel.CENTER);
       Icon imagePets = new ImageIcon("pets/"+namePet+".jpg");
       label2 = new JLabel(imagePets,JLabel.CENTER);
       panel1.setLayout(new BorderLayout());
       
       Font f = new Font("Serif", Font.PLAIN, 29); 

       label1.setFont(f);
       panel1.add(label1,BorderLayout.NORTH);
       
       
       
       panel1.add(label2,BorderLayout.CENTER);
       
    }

    public JPanel getPanelPet(){
        return panel1; 
    }
}
