import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Décrivez votre classe Planet ici.
 *
 * @author (Group 7)
 * @version (11/12/2018)
 */
public class InterfacePlanet extends JPanel implements ActionListener
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    //private JFrame myFrame;
    private JPanel myPanel2,myPanel1, panelPlanet;
    private JLabel planetLabel,imagePlanetLabel, temperatureLabel, descriptionLabel, timeLabel, updatePlanetLabel;
    //private Planet planet;
    private Timer room_timer;
    private Game game;

    /**
     * Constructeur d'objets de classe Planet
     */
    public InterfacePlanet(Game game)
    {
        game = game;
          
        updateTimer(game.getPlayer().getCurrentRoom().getPlanet().getTime());
        
        myPanel1 = new JPanel();
        myPanel1.add(planetLabel);

        myPanel2 = new JPanel();
        myPanel2.setLayout(new GridLayout(3,1));
        

        panelPlanet = new JPanel();
        panelPlanet.setLayout(new GridLayout (1,3));
        

        updateInterfacePlanet(game);

       
    }

    public void updateInterfacePlanet(Game game){
        myPanel2.removeAll();

        planetLabel = new JLabel("Nom: " + game.getPlayer().getCurrentRoom().getPlanet().getPlanetName(), JLabel.CENTER);

        descriptionLabel = new JLabel("Description: " + game.getPlayer().getCurrentRoom().getPlanet().descriptionDisplayPlanet(), JLabel.CENTER);

        timeLabel = new JLabel("Time: " + game.getPlayer().getCurrentRoom().getPlanet().getTime(), JLabel.CENTER);
        
        updateTimer(game.getPlayer().getCurrentRoom().getPlanet().getTime());
        

        myPanel2.add(planetLabel);
        myPanel2.add(descriptionLabel);
        myPanel2.add(timeLabel);
        myPanel2.revalidate();
        myPanel2.repaint(); 
        
        myPanel1.removeAll();
        Icon imagePlanet = new ImageIcon(new ImageIcon("planet/planet_"+game.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
        ".png").getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        imagePlanetLabel = new JLabel(imagePlanet);
        myPanel1.add(imagePlanetLabel);
        
        myPanel1.revalidate();
        myPanel1.repaint();
        panelPlanet.add(myPanel1);
        panelPlanet.add(myPanel2);

    }

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
        public TimerTasks(int time)
        {
            countdown = time;
        }

        public void run() {
            countdown = countdown - 1;
            if (countdown == 0) {
                room_timer.cancel();
                //kill the player
                JOptionPane.showMessageDialog(null,"*blurp* *blurp* \n I'M SUFFOCATINGGGGGGG \n GAME OVER \n (et là on est censé retourner au départ mais ça sera relou pour developper le jeu)");
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
}
