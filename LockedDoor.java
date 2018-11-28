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
    public LockedDoor(Room newNextRoom, String newShapeKey)
    {
        super(newNextRoom);
        locked = true;
        shapeLocked = newShapeKey.trim();
        if (newShapeKey == ""){
            throw new IllegalArgumentException("The shape of the key which open the door can not be empty.");
        }
    }
    
    /**
     * Description of the shape of the key
    **/
    @Override
    public String ShapeKeyDescription()
    {
        return shapeLocked; 
    }
    
    /**
     * Return if the locked door has been opened or not.
    **/
    @Override
    public boolean getIfLocked()
    {
        return locked; 
    }
    
    /**
     * open the lockedDoor
    **/
    @Override
    public void openLocked()
    {
        locked=false; 
    }
    
    /**
     * If the shape of the given key corresponds to 
     * the shape of the door, the latter is opened.
    **/
    public void open(Keys key)
    { 
        if (this.shapeLocked.equals(key.getShape()) && this.locked == true){
            this.locked = false; //The door is opened if the shape of 
                                 //the key corresponds to the shape of the door
        }
    }
}
