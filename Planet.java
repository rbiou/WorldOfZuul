import java.util.*;
/**
 * The Planet class: this class defines the different Planet in the game World of Zuul
 * In the game there are 4 planets. 
 * They contain rooms (different number according to the planet)
 *
 * @author (Groupe7)
 * @version (13/11/2018)
 */
public class Planet
{
    private String name; // name of the planet
    private String description; // Description of the planet
    private int temperature; // Temperature of the planet 
    private int time; // Limit of time (in seconds) available for the player in one planet
    private ArrayList<Room> listRoom; // Rooms that are in the planet

    /**
     * Constructor of Planet class
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
     * Get the temperature of the planet
     *
     * @return the temperature
     */
    public int getTemparature()
    {
        return temperature; 
    }
    
    /**
     * This method allows you to display the description of the planet
     */
    public String descriptionDisplayPlanet()
    {
        return (description);
    }
    
    /**
     * Add a new room in the planet
     *
     * @param        a room
     * @return       a boolean : true when the room is added to the planet
     *                           false when the room is not added to the planet
     */
    public boolean addRoom(Room newRoom)
    {
        if (listRoom.contains(newRoom)){
            return false; }
        else {
            this.listRoom.add(newRoom);
            return true;}
    }
}

