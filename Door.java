
/**
 * This class describe the door in the different rooms.
  * @author Group 7
 * @version 14/11/2018
 */
public class Door
{
    // instance variables
    private Room nextRoom; // the room where you going to
    /**
     * Constructor for objects of class Door
     */
    public Door(Room newNextRoom)
    {
        nextRoom = newNextRoom;
    }
    
    public Room getNextRoom()
    {
        return nextRoom;
    }
}

