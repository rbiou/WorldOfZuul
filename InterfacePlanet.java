import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The InterfacePlanet class: this class defines update the descritpion and the picture of the planet 
 * in the game World of Zuul. Allows you to do a countdowm when the player is in the planet.
 * In the game there are 4 planets. 
 * They contain rooms (different number according to the planet)
 *
 *
 * @author (Group 7)
 * @version (11/12/2018)
 */
public class InterfacePlanet extends JPanel implements ActionListener
{
    private JPanel myPanel2,myPanel1, panelPlanet; //The JPanel for the planet Interface
    private JLabel planetLabel,imagePlanetLabel, descriptionLabel, timeLabel; // The JLabel of the planet: images, description 
    //and time
    private Timer room_timer; // The room_timer 
    private Game game; // The Game


    /**
     * Constructor for objects of class PlanetInterface 
     */
    public InterfacePlanet(Game mygame)
    {
        game = mygame;
        //create a new panelPlanet
        panelPlanet = new JPanel();
        updateInterfacePlanet(game);       
    }

    /**
     * this method updates the interface Planet : update the descritpion and the 
     * the picture of the planet
     * @parameter  Game : game 
     */
    public void updateInterfacePlanet(Game game){
        //remove the former panelPlanet
        panelPlanet.removeAll();        
        panelPlanet.setLayout(new GridLayout (1,3));

        // Get the name of the planet when the player after his move
        planetLabel = new JLabel("Nom: " + game.getPlayer().getCurrentRoom().getPlanet().getPlanetName(), JLabel.CENTER);

        myPanel1 = new JPanel();
        myPanel1.add(planetLabel);

        myPanel2 = new JPanel();
        myPanel2.setLayout(new GridLayout(3,1));
        
        // Get the description of the planet when the player after his move
        descriptionLabel = new JLabel("Description: " + game.getPlayer().getCurrentRoom().getPlanet().descriptionDisplayPlanet(), JLabel.CENTER);
        
        // Get The time of the planet that we have left 
        timeLabel = new JLabel("Time: " + game.getPlayer().getCurrentRoom().getPlanet().getTime(), JLabel.CENTER);
        
        // get the updaterTimer 
        updateTimer(game.getPlayer().getCurrentRoom().getPlanet().getTime());
        // Panel for the characteristics of the planet
        myPanel2.add(planetLabel);
        myPanel2.add(descriptionLabel);
        myPanel2.add(timeLabel);
        myPanel2.revalidate();
        myPanel2.repaint(); 
        
        // the image of the planet
        Icon imagePlanet = new ImageIcon(new ImageIcon("planet/planet_"+game.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
        ".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        imagePlanetLabel = new JLabel(imagePlanet);

        myPanel1.add(imagePlanetLabel);

        panelPlanet.add(myPanel1);
        panelPlanet.add(myPanel2);
        //Reload the planet buttons panel
        panelPlanet.revalidate();
        panelPlanet.repaint();
    }

    /**
     * The method updateTimer allows to update the timer on a global level. 
     */
    public void updateTimer(int time)
    {
        if (room_timer != null){
            room_timer.cancel();
        }
        room_timer = new Timer();
        room_timer.schedule(new TimerTasks(time), 0, 1000);
    }

    class TimerTasks extends TimerTask {
        int countdown;
        int option; 
        public TimerTasks(int time)
        {
            countdown = time;
        }
        
        /**
         * The method run allows you to do a countdowm when the player is in the planet
         */
        public void run() {
            countdown = countdown - 1;
            if (countdown == 0) {
                room_timer.cancel();
                //kill the player
                game.getInterfaceGame().popUpLose();
                //JOptionPane.showMessageDialog(null,"*blurp* *blurp* \n I'M SUFFOCATINGGGGGGG \n GAME OVER \n (et là on est censé retourner au départ mais ça sera relou pour developper le jeu)");
            }
            timeLabel.setText("Time: "+Integer.toString(countdown));
        }

    }

    public void actionPerformed(ActionEvent e)
    {
    }

    public JPanel getPanelPlanet()
    {
        return panelPlanet;
    }
    
    public Timer getRoomTimer()
    {
        return room_timer;
    }
}
