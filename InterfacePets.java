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
     private Pet pet;
     private JButton button1;
    
    /**
     * Constructeur d'objets de classe Listener
     */
    public InterfacePets(Game game,Pet petroom)
    {
      
       panel1 = new JPanel(); 
       pet= petroom;
       
       label1 = new JLabel("*** THANK YOU FOR YOUR VISIT AND TAKING SOME TIMES FOR ME ***  I AM" +pet.getName()+ " *** HERE A RECOMPENSE***",JLabel.CENTER);
       Icon imagePets = new ImageIcon("pets/"+pet.getName()+".jpg");
       label2 = new JLabel(imagePets,JLabel.CENTER);
       button1 = new JButton("GOODBYE"); 
       panel1.setLayout(new BorderLayout());
       
       Font f = new Font("Serif", Font.PLAIN, 29); 
       
       label1.setFont(f);
       panel1.add(label1,BorderLayout.NORTH);
   
       panel1.add(label2,BorderLayout.CENTER);
       panel1.add(button1,BorderLayout.SOUTH);
     
    }

    public JPanel getPanelPet(){
        return panel1; 
    }
    public JButton getButtonPet(){
        return button1;
    }
}
