
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
     * When a player speak to a pet, it give the description of the planet he is standing in.
     * @return the description of the room as a string
     */
    public String giveMessage()
    {
        return ("<html><center>***Welcome on the planet "+
                getCurrentRoom().getPlanet().getPlanetName()+
                "*** <br> I am " +getName()+"."+
                "The current temperature is " +getCurrentRoom().getPlanet().getTemperature()+"°c."+
                " Warning you have " +getCurrentRoom().getPlanet().getTime()+ " seconds to succeed." + "<br>"+
                " Here is a small reward to start the quest on this planet</center></html>");
    }
    
    /**
     * When a player speak to a pet, it print the description of the planethe is standing in.
     */
    public void speak()
    {
        System.out.println(giveMessage());
    }
}
