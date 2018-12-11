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
        updateInterfaceMap(newGame); 
        
    }

    public JPanel getPanelMap(){
        return panelMap; 
    }
    
    public void updateInterfaceMap (Game game){
        //Get the map panel at the moment when he click on the button
        panelMap = new JPanel();
        //Load the image map designed for this room
        Icon imageMap = new ImageIcon(new ImageIcon("map/planet_"+game.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
        "_room_"+game.getPlayer().getCurrentRoom().getName()+".jpg").getImage().getScaledInstance(480, 270, Image.SCALE_DEFAULT));
        //Load the new map on a new JLabel
        myMap = new JLabel(imageMap, JLabel.CENTER);
        //Clear the actual map panel to delete the precedent map
        panelMap.removeAll();
        //Add the new map to the map panel
        panelMap.add(myMap);
        
};

// //Get the map panel at the moment when he click on the button
        // myMap = myGame.getInterfaceGame().getPanelMap();
        // //Load the image map designed for this room
        // Icon imageMap = new ImageIcon(new ImageIcon("map/planet_"+myGame.getPlayer().getCurrentRoom().getPlanet().getPlanetName()+
                    // "_room_"+myGame.getPlayer().getCurrentRoom().getName()+".jpg").getImage().getScaledInstance(480, 270, Image.SCALE_DEFAULT));
        // //Load the new map on a new JLabel
        // myMap = new JLabel(imageMap, JLabel.CENTER);
        // //Clear the actual map panel to delete the precedent map
        // myMapPanel.removeAll();
        // //Add the new map to the map panel
        // myMapPanel.add(myMap);

}
