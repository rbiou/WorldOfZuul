
/**
 * This class describe the pets in the game, pets are placed in the
 * different rooms and can interact with the player (speak to him)
 * The pet contain an amount of money and every time the player pet it, he 
 * gain 1$
 *
 * @author Group 7
 * @version 14/11/2018
 */
public class Pet extends NonPlayerCharacter
{
    // instance variables -
    private String species; // the species of the pets, can be any String

    /**
     * Constructor for objects of class Pets
     */
    public Pet(String newName, int newMoney, int newWeight, Room newRoom, String newSpecies)
    {
        super(newName, newMoney, newWeight, newRoom); 
        String species = newSpecies;
    }
    
    /**
     * Getter for species of the pet
     */
    public String getSpecies()
    {
        return species;
    }
    
    /**
     * When a player speak to a pet, it give the description of the planet
     * he is standing in.
     */
    public String speak()
    {
        System.out.println("You are in the "+"test"+" of the planet.");
    }
}
