
/**
 * This class describe the pets in the game, pets are placed in the
 * different rooms.
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Pet extends NonPlayerCharacter
{
    // instance variables -
    private String species; // the species of the pets 

    /**
     * Constructor for objects of class Pets
     */
    public Pet(String newName, int newMoney, int newWeight, String newSpecies)
    {
        super(newName, newMoney, newWeight); 
        String species = newSpecies;
    }
    
    /**
     * Getter for species of the pet
     */
    public String getSpecies()
    {
        return species;
    }

}


