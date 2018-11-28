
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
        String species = newSpecies.trim();
        if (species == ""){
            throw new IllegalArgumentException("Specie can't be empty.");
        }
    }
    
    /**
     * Getter for species of the pet
     * @return the string corresponding to the species
     */
    public String getSpecies()
    {
        return species;
    }
    
    /**
     * When a player speak to a pet, it give the description of the planet
     * he is standing in.
     * @return the description of the room as a string
     */
    public String giveMessage()
    {
        return ("You are in the "+this.getCurrentRoom().getName()+" of the planet "+this.getCurrentRoom().getPlanet().getPlanetName()
        +". The temperature is "+this.getCurrentRoom().getPlanet().getTemperature()+"°C. To survive, you have a limited time of "
        +this.getCurrentRoom().getPlanet().getTime()
        +" seconds to explore the planet. People of this planet left me a message for you : ")
        +this.getCurrentRoom().getPlanet().descriptionDisplayPlanet();
    }
    
    /**
     * When a player speak to a pet, it print the description of the planet
     * he is standing in.
     */
    public void speak()
    {
        System.out.println(giveMessage());
    }
}
