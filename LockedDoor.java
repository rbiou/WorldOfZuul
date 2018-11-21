/**
 * Same as door, but are locked and need to be opened to move in another room.
 *
 * @author (Groupe 7)
 * @version (13/11/2018)
 */
public class LockedDoor extends Door{
      private boolean locked; // false = the door is not locked - true = the door is locked
      private String shapeLocked; // the key is used to open the lockedDoor if it is closed
    
    /**
    LockedDoor constructor
    */
    public LockedDoor(Room newPresentRoom, Room newNextRoom, String newShapeKey)
    {
        super(newPresentRoom, newNextRoom); 
        locked = true;
        shapeLocked = newShapeKey; 
    }

    /**
     * Open a LockedDoor - The shape of the lock must correspond to the shape of the key
     * If it corresponds, the door is opened
     * If it not corresponds, the door stay locked
    **/
    public boolean unlock(Keys key)
    {
        return false; 
    }
    
    /**
     * Description of the shape of the key
    **/
    public String ShapeKeyDescription()
    {
        return shapeLocked; 
    }
 
}
