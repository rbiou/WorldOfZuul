import java.util.*;
/**
 * The Planet class: this is class define the different Planet in the game World of Zuul
 *
 * @author (Groupe7)
 * @version (13/11/2018)
 */
public class Planet
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private String name; // name de la planete
    private String description; // description de la planete
    private int temperature; // valeur de la temperature de la planete 
    private int time; // valeur du temps
    private List<Room> listRoom = new ArrayList<Room>();


    /**
     * Constructeur d'objets de classe Planet
     */
    public Planet()
    {
        // initialisation des variables d'instance
    }

    /**
     * Permet d'afficher la decription de la planete
     */
   public String descriptionDisplayPlanet()
   {
       return ("");
   }
}
