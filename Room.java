import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "SpaceZuul" application. 
 * 
 *
 * A "Room" represents one location in the scenery of our game. Planet contains different rooms. 
 * There is not the same number of rooms on each planet. 
 * It is connected to other rooms via exits. f
 * The number of exits (doors) is different for each room.
 * 
 * @author (Groupe 7)
 * @version (14/11/2018)
 */
public class Room 
{
    private String name; // Name of the room
    private HashMap<String, Door>exit; // Each exit is associated to this room
    private ArrayList<Character> listCharacters;  // List of all the Characters present in this room
    private ArrayList<Chest> listChest; // List of all the chest present in this room
    private Planet currentPlanet; // planet where is the room

    /**
     * Constructor of the Room class
     */
    public Room(String newName, Planet newPlanet)
    {
        name = newName.trim();
        if (name == ""){
            throw new IllegalArgumentException("Name can't be empty.");
        }
        exit = new HashMap <String,Door>(); 
        listCharacters = new ArrayList<Character>();
        listChest = new ArrayList<Chest>();
        currentPlanet = newPlanet ;
    }

     /**
     * Getter to return the name of the room
     * 
     * @return      String
     */
    public String getName()
    {
        return name; 
    }
    
     /**
     * Getter to return the planet of the room
     * 
     * @return      Planet
     */
    public Planet getPlanet()
    {
        return currentPlanet; 
    }
    
    /**
     * Getter to return the list of the character
     * 
     * @return      ArrayList<Character>
    **/
    public ArrayList<Character> getListCharacter()
    {
        return listCharacters;
    }
    
    /**
     * Getter to return the list of the chest
     * 
     * @return       ArrayList<Chest>
    **/
    public ArrayList<Chest> getListChest()
    {
        return listChest;
    }
    
    /**
     * Add a new character in the room
     *
     * @param      a character
     * 
     * @return     boolean : true when we add the character
     *                       false when the character is not added 
     */
    public boolean addCharacter(Character newChar)
    {
        if (this.listCharacters.contains(newChar)){
            return false; }
        else {
            this.listCharacters.add(newChar);
            return true;}
    }
    
    /**
     * Add a chest in the room
     *
     * @param       a chest
     * @return      boolean : true when we add the chest
     *                       false when the chest is not added
     */
    public boolean addChest(Chest newChest)
    {
        if (this.listChest.contains(newChest)){
            return false; }
        else {
            this.listChest.add(newChest);
            return true;}
    }
    
    /**
     * Remove a character from the room
     *
     * @param      a character
     * @return     boolean : true when we remove the character
     *                       false when the character is not removed
     */
    public boolean removeCharacter(Character oldChar)
    {
        if (this.listCharacters.contains(oldChar)){
            this.listCharacters.remove(oldChar);
            return true; }
        else {
            return false;}
    }
    
    /**
     * Remove a chest from the room
     *
     * @param      a chest
     * @return     boolean : true when we remove the chest
     *                       false when the chest is not removed
     */
    public boolean removeChest (Chest oldChest)
    {
        if (this.listChest.contains(oldChest)){
            this.listChest.remove(oldChest);
            return true; }
        else {
            return false;}
    }
    
    
    /**
     * Define the exit of this room. 
     * Each door leads to another room. 
     *
     * @param       exitName. 
     * @param       arrivalDoor (Door).
     * 
     */
    public void setExit(String exitName, Door arrivalDoor)
    {
        exit.put(exitName, arrivalDoor);
    }
    
    /**
     * This method displays all the different exits of the room
     * Name of the door + Name of the room where it leads
    **/
    public void displayExit()
    {
        Iterator<Map.Entry<String,Door>> itr = exit.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String,Door>entry = itr.next();
            String key = entry.getKey();
            Door value = entry.getValue();
            System.out.println("name of the door : " + key);
            System.out.println("exit room : " +
            value.getNextRoom().getName());
            
        }
    }
    
    /**
     * With this method you give in parameter the name of the door, and it returns the door
     * where it leads.
     * @return the door that correspond to the given name
    **/
    public Door getSpecificExit(String nomPorte)
    {
        return exit.get(nomPorte);
    }
    
     /**
     * This method returns a list of the name of the different doors of the room.
     * @return the name of the different doors
    **/
    public ArrayList<String> getNameDoor()
    {
        ArrayList<String> list = new ArrayList<String>() ;
        Iterator<Map.Entry<String,Door>> itr = exit.entrySet().iterator();
        while(itr.hasNext())
        {
            Map.Entry<String,Door>entry = itr.next();
            String key = entry.getKey();
            list.add(key);
        }
        return list;
    }
        
}
    





