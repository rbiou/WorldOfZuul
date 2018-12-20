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
    public HashMap<String, Door>exit; // Each exit is associated to this room
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
     */
    public void addCharacter(Character newChar)
    {
        if (!this.listCharacters.contains(newChar)){
            this.listCharacters.add(newChar);
        }
    }

    /**
     * Add a chest in the room
     *
     * @param       a chest
     */
    public void addChest(Chest newChest)
    {
        if (!this.listChest.contains(newChest)){
            this.listChest.add(newChest);
        }
    }

    /**
     * Remove a character from the room
     *
     * @param      a character
     */
    public void removeCharacter(Character oldChar)
    {
        if (this.listCharacters.contains(oldChar)){
            this.listCharacters.remove(oldChar);
        }
    }

    /**
     * Remove a chest from the room
     *
     * @param      a chest

     */
    public void removeChest (Chest oldChest)
    {
        if (this.listChest.contains(oldChest)){
            this.listChest.remove(oldChest);
        }
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

    /**
     * Return a specific monster present in a room
     * Only one monster is present in a room
     */
    public Monster getMonster() {
        for (int i = 0; i< this.listCharacters.size(); i++)
        {
            if (this.listCharacters.get(i)!=null){
                if (this.listCharacters.get(i).getName() == "Godzilla" || this.listCharacters.get(i).getName() == "Yoda" ||
                this.listCharacters.get(i).getName() == "Darkness" || this.listCharacters.get(i).getName() == "Piranha")
                    return ((Monster)listCharacters.get(i));
            }
        }
        return null; 
    }

    /**
     * Return a specific seller present in a room
     * Only one seller is present in a room
     */
    public Seller getSeller() {
        for (int i = 0; i< this.listCharacters.size(); i++)
        {
            if (this.listCharacters.get(i)!=null){
                if (this.listCharacters.get(i).getName() == "Dumbledore" || this.listCharacters.get(i).getName() == "Hagrid" ||
                this.listCharacters.get(i).getName() == "Harry Potter" )
                    return ((Seller)listCharacters.get(i));
            }
        }
        return null; 
    }

    /**
     * Return a specific pet present in a room
     * Only one pet is present in a room
     */
    public Pet getPet() {
        for (int i = 0; i< this.listCharacters.size(); i++)
        {
            if (this.listCharacters.get(i)!=null){
                if (this.listCharacters.get(i).getName() == "Bamby" || this.listCharacters.get(i).getName() == "Dolly" ||
                this.listCharacters.get(i).getName() == "Pumba" || this.listCharacters.get(i).getName() == "Winnie" || 
                this.listCharacters.get(i).getName() == "Timon" )
                    return ((Pet)listCharacters.get(i));
            }
        }
        return null; 
    }

    /**
     * Return a specific chest present in a room
     * Only one chest is present in a room
     */
    public Chest getChest() {
        for (int i = 0; i< listChest.size(); i++)
        {
            if (listChest.get(i)!=null){
                if (this.listChest.get(i).getName() == "Bill" || this.listChest.get(i).getName() == "Bob" ||
                this.listChest.get(i).getName() == "Sully" || this.listChest.get(i).getName() == "Kiwi" || 
                this.listChest.get(i).getName() == "Titi" || this.listChest.get(i).getName() == "Cramberry" ||
                this.listChest.get(i).getName() == "Grosminet" || this.listChest.get(i).getName() == "Banana" ||
                this.listChest.get(i).getName() == "The best" || this.listChest.get(i).getName() == "Free" || 
                this.listChest.get(i).getName() == "Magic")
                    return (listChest.get(i));
            }
        }
        return null; 
    }
}

