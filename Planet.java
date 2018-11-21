import java.util.*;
/**
 * The Planet class: this class defines the different Planet in the game World of Zuul
 *
 * @author (Groupe7)
 * @version (13/11/2018)
 */
public class Planet
{
    private String name; // name of the planet
    private String description; // Description of the planet
    private int temperature; // Temperature of the planet 
    private int time; // Limit of time (in second) available for the player in one planet
    private List<Room> listRoom; // Rooms that are in the planet

    /**
     * Constructor of planet class
     */
    public Planet(String newName, String newDescription, int newTemp, int newTime)
    {
        name = newName; 
        time = newTime; 
        description = newDescription; 
        temperature = newTemp; 
        listRoom = new ArrayList<Room>(); 
    }
    /**
     * Get the room list of the planet
     *
     * @return     listRoom of the planet
     */
    public List<Room> getListRoom()
    {
        return listRoom; 
    }
    /**
     * Get the time limit of the planet
     *
     * @return     time of the planet
     */
    public int getTime()
    {
        return time; 
    }
    /**
     * This method allows you to display the description of the planet
     */
    public String descriptionDisplayPlanet()
    {
        return ("");
    }
    /**
     * Add a new room in the planet
     *
     * @param  y   le paramètre de la méthode
     */
    public boolean addRoom(Room newRoom)
    {
        return false; 
    }
}

