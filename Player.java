import java.util.*;

/**
 * The sub-class Player : this is a class that define the characteristics     
 * of the player. The player a life point. At the beggining, the player 
 * has 100 life point in his chest. He can check the time. He can lose
 * life points and if he has not life points he deads. He can win money
 * when he pets a pet.
 * The player change room with the door. He can open the door with key.
 * @author Group 7
 * @version 13/11/2018
 */
public class Player extends Character
{
    private int lifePoints;

    /**
     * Constructor
     **/
    public Player(String newName, int newWeight, Room newRoom)
    {
        super(newName, 0, newWeight, newRoom);
        lifePoints = 100;
    }

    /**
     * The player grabs the content of the chest
     * He loses 25 LP when the chest is trapped
     * The items/money which are presents in the chest are added to 
     * player's bag. Then they are removed from the chest. 
     * @param   chest opens by the player
     **/
    public void grabContent(Chest chest)
    {
        chest.setIsOpened(true); 
        int newLP; 
        if (chest.getIsTrap()==true){
            newLP = this.lifePoints - 25; 
            this.lifePoints = newLP; 
            if (newLP < 0){
                this.lifePoints=0;
                this.lifePoints = newLP;
            }
        }; 

        //add the money of the chest to the player and remove the money of the chest
        this.addMoney(chest.getMoney());
        chest.removeMoneyChest();

        //add all the items in the player's bag and remove them of the chest
        if (chest.getTotWeight() <= (this.getMaxWeight()-this.getTotalWeight())){
            this.getListItems().addAll(chest.getListItems());
            chest.getListItems().clear(); 

        }
    }

    /**
     * The player loses LP 
     * The life points can not be negative
     * @param    number of HP that should be removed from player's LP
     **/
    public void looseHP(int HP)
    {
        if (HP > 0){
            this.lifePoints -= HP;
            if (this.lifePoints < 0){
                this.lifePoints = 0; 
            }
        }
    }

    /**
     * This method returns true if the player is dead. 
     * In this case, his life points are egals to 0
     * @param    number of HP that should be removed from player's LP
     **/
    public boolean isDead()
    {
        return (lifePoints <= 0);
    }

    /**
     * This method allows to pet a pet
     * The player earns 1 piece
     * The pet loses 1 piece
     **/
    public void pet(Pet pet)
    {
        pet.removeMoney(1);
        this.addMoney(1);
    }

    /**
     * Go to the room to which specified door leads to
     * @param  door    The door to where player has to go
     **/
    public void moveRoom(Door door)
    {
        setCurrentRoom(door.getNextRoom());
        door.getNextRoom().addCharacter(this);
    }

    /**
     * Go to the room to which specified lockeDoor leads to
     * @param  door    The door to where player has to go
     * @return a boolean 
     *  if the player does not have the key return false;
     *  if the player has the key return true; 
     **/
    public boolean moveLockedDoor(Door doorExit)
    {

        boolean rightKey = false;
        for(int i=0;i<getListItems().size();i++)
        {
            if (getListItems().get(i).getShape()== doorExit.ShapeKeyDescription())
            {
                rightKey = true;
                doorExit.openLocked();
            }
        }

        return rightKey; 
    }

    /**
     * getter to get the LP of the player
     **/
    public int getLP()
    {
        return lifePoints;
    }

    /**
     * this method allows the player to sell an item to the seller
     *
     * @param item
     * @return return the amount of money owned by the player
     */
    public boolean sellItem(Seller seller, Item item)
    {
        int price = item.getValue();
        this.addMoney(price);
        this.removeItem(item);
        seller.addItem(item);
        return true;
    }

    /**
     * this method allows the player to buy an item from the seller
     *
     * @param Seller seller
     * @param Item item
     * @return true if the player can buy a new item
     */
    public boolean buyItem(Seller seller, Item item)
    {
        int price = item.getValue();
        if (item.getWeight() <= (this.getMaxWeight() - this.getTotalWeight())){
            if (price <= this.getMoney())
            {
                this.removeMoney(price);
                this.addItem(item);
                seller.removeItem(item);
                return true;
            }
        }
        return false;

    }
}
