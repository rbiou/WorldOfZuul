import java.util.*;
/**
 * 
 */
public class Game
{
    private List<Planet>listPlanet; // list of planet of our game
    
    /**
     * Constructeur d'objets de classe Game
     */
    public Game()
    {
        listPlanet = new ArrayList<Planet>();
        
    }

    /**
     * this method allows you to quit the game
     */
    public void quit()
    {
        //
    }
    /**
     * this method allows you to open the game
     */
    public void openGame()
    {
        //
    }
    /**
     * this method allows you to save the game
     */
    public void save()
    {
        //
    }
    /**
     * the method allows you to create a Room
     */
    public void createRoom()
    {
        //
    }
    
     /**
     * the method allows you to create the World of our game
     */
    public void createWolrd()
    {
        //creation of the planets
        Planet alpha = new Planet("Alpha", "Welcome on the planet alpha", 10, 10); 
        Planet beta = new Planet("Beta", "Welcome on the planet beta", 10, 10); 
        Planet gamma = new Planet("Gamma", "Welcome on the planet gamma", 10, 10); 
        Planet delta = new Planet("Delta", "Welcome on the planet alpha", 10, 10);

        
        // Add the exits of each room
                //creation of the rooms
        //alpha.listRoom.add(new Room("alpha1")); 
        //alpha.listRoom.add(); 
        //alpha.listRoom.add(); 
        
        //beta.listRoom.add(); 
        //beta.listRoom.add();
        //beta.listRoom.add();
        //beta.listRoom.add();
        //beta.listRoom.add();
        
        //delta.listRoom.add();
        //delta.listRoom.add();
        //delta.listRoom.add();
        //delta.listRoom.add();
        
        //gamma.listRoom.add();
        //gamma.listRoom.add();
        //gamma.listRoom.add();
        //gamma.listRoom.add();
        //gamma.listRoom.add();
        //gamma.listRoom.add();

        
    }
    
}
