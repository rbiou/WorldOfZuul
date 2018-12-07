import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * Interface MAP. Permet l'affichage de la map avec l'évolution du joueur au
 * de l'interface de jeu.
 *
 * @author (Groupe 7)
 * @version (07/)
 */
public class InterfaceMap extends JPanel
{
    private JLabel myMap;
    private JPanel panelMap;

    /**
     * Constructeur d'objets de classe Interface_Map
     */
    public InterfaceMap(Game game)
    {
        panelMap = new JPanel();
        Icon imageMap = new ImageIcon(new ImageIcon("map/planet_"+game.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
        "_room_"+game.getPlayer().getCurrentRoom().getName()+".jpg").getImage().getScaledInstance(480, 270, Image.SCALE_DEFAULT));
        myMap = new JLabel(imageMap, JLabel.CENTER);
        panelMap.add(myMap);
    }

    public JPanel getPanelMap(){
        return panelMap; 
    }
}
