
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
    
      /**
     * Return if the locked door has been opened or not.
    **/
    public boolean getIfLocked()
    {
        return true;
    }
    
    /**
     * Description of the shape of the key
    **/
    public String ShapeKeyDescription()
    {
        return ""; 
    }
}

