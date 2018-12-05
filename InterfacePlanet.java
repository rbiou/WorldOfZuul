import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
/**
 * Décrivez votre classe Planet ici.
 *
 * @author (Group 7)
 * @version (un numéro de version ou une date)
 */
public class InterfacePlanet extends JPanel implements ActionListener
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    //private JFrame myFrame;
    private JPanel myPanel, panelPlanet;
    private JLabel planetLabel, temperatureLabel, descriptionLabel, timeLabel;
    //private Planet planet;
    /**
     * Constructeur d'objets de classe Planet
     */
    public InterfacePlanet(Game game)
    {
        // initialisation des variables d'instance
        //myFrame = new JFrame("Planet");
        //myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //myFrame.setLayout(new GridLayout(0,2));
        
        Icon imagePlanet = new ImageIcon("planet.jpg");
        JLabel imageplanetLabel = new JLabel(imagePlanet);
        
        
        planetLabel = new JLabel("Nom: " + game.getPlayer().getCurrentRoom().getPlanet().getPlanetName(), JLabel.CENTER);
        descriptionLabel = new JLabel("Description: " + game.getPlayer().getCurrentRoom().getPlanet().descriptionDisplayPlanet(), JLabel.CENTER);
        timeLabel = new JLabel("Time: " + game.getPlayer().getCurrentRoom().getPlanet().getTime(), JLabel.CENTER);
        
        JPanel myPanel1 = new JPanel();
        myPanel1.add(planetLabel);
        
        
        JPanel myPanel2 = new JPanel();
        myPanel2.setLayout(new GridLayout(3,1));
        myPanel2.add(planetLabel);
        myPanel2.add(descriptionLabel);
        myPanel2.add(timeLabel);
        
        panelPlanet = new JPanel();
        panelPlanet.setLayout(new GridLayout (1,3));
        panelPlanet.add(myPanel1);
        panelPlanet.add(myPanel2); 
        
        //myFrame.add(myPanel1);
        //myFrame.add(myPanel2);
        
        //myFrame.pack();
        //myFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    }
    
    public JPanel getPanelPlanet()
    {
       return panelPlanet;
    }
}
