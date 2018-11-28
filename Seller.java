import java.util.*;

/**
 * The seller is the subclass of the non player character the seller
 * class allows the player to buy or to sell the items.
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Seller extends NonPlayerCharacter
{

    /**
     * Constructor for objects of class Seller
     */
    public Seller(String newName, int newMoney, int newWeight, Room newRoom)
    {
        super(newName, newMoney, newWeight, newRoom);
    }


    /**
     * this method allows the player to display the different items in
     * the shop
     *
     * @param  
     * @return all the items in the shop
     */
    public void displayShop()
    {
        // put your code here
    }

    public void speak (Player player)
    {
        System.out.println("Would you like to buy or sell something ?");
        Scanner reader = new Scanner (System.in);
        String answer = reader.next();
        
        if (answer == "buy"){

            Item item = selectItemFromList(this.getListItems());
            if (item == null) {
                boolean success = player.buyItem(this, item);
                if (success)
                    System.out.println("Thanks.");
                else
                    System.out.println("You don't have enough money.");
            }
        }

        if (answer == "sell"){

            Item item = selectItemFromList(this.getListItems());
            if (item == null) {
                boolean success = player.sellItem(this, item);
                if (success)
                    System.out.println("Cheers.");
                else
                    System.out.println("You can't sell this.");

            }
        }
    }

    public Item selectItemFromList(ArrayList<Item> items)
    {
        Scanner reader = new Scanner (System.in);
        while(true){
            System.out.println("Select an item");
            for (int i = 0; i < items.size(); i++)
            {
                System.out.println(i + " : " + items.get(i).getName());
            }
            System.out.println("exit : CANCEL");

            String answer = reader.next();
            if (answer == "exit"){
                return null;
            }
            
            int itemIndex = Integer.valueOf(answer);
            if (itemIndex < 0 || itemIndex >= items.size() - 1){
                System.out.println("Wrong item selected");
                continue;
            }

            return items.get(itemIndex);
        }
    }
}


