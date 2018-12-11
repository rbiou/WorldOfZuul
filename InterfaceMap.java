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
    public InterfaceMap(Game newGame)
    {
        panelMap = new JPanel();
        updateInterfaceMap(newGame); 
        
    }

    public JPanel getPanelMap(){
        return panelMap; 
    }
    
    public void updateInterfaceMap (Game game){
        //Clear the actual map panel to delete the precedent map
        panelMap.removeAll();
        //Load the image map designed for this room
        Icon imageMap = new ImageIcon(new ImageIcon("map/planet_"+game.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
        "_room_"+game.getPlayer().getCurrentRoom().getName()+".jpg").getImage().getScaledInstance(480, 270, Image.SCALE_DEFAULT));
        //Load the new map on a new JLabel
        myMap = new JLabel(imageMap, JLabel.CENTER);
        //Add the new map to the map panel
        panelMap.add(myMap);
        //Reload the map panel
        panelMap.revalidate();
        panelMap.repaint();       
        
};

}
