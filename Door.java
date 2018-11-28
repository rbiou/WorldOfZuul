
/**
 * *
 * This class describe the door in the different rooms.This class allows
 * us to know where we go with the doors and if they are locked or not.
 * The player must open the door to change room.
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
        return false;
    }
    
    /**
     * Description of the shape of the key
    **/
    public String ShapeKeyDescription()
    {
        return ""; 
    }
    
     /**
     * open a lockedDoor
    **/
    
    public void openLocked()
    {
    }
}

