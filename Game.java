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

        //creation of the rooms in each planet according to the map that we defined
        Room start, alpha1, alpha2, alpha3, beta1, beta2, beta3, beta4, beta5, delta1, delta2, delta3, delta4, gamma1, gamma2, gamma3,
        gamma4, gamma5, gamma6; //decalration of the room
        
        start = new Room("start"); 
        
        alpha.getListRoom().add(alpha1 = new Room("alpha1")); 
        alpha.getListRoom().add(alpha2 =new Room("alpha2")); 
        alpha.getListRoom().add(alpha3 =new Room("alpha3")); 
        
        beta.getListRoom().add(beta1 = new Room("beta1")); 
        beta.getListRoom().add(beta2 = new Room("beta2"));
        beta.getListRoom().add(beta3 = new Room("beta3"));
        beta.getListRoom().add(beta4 = new Room("beta4"));
        beta.getListRoom().add(beta5 = new Room("beta5"));
        
        delta.getListRoom().add(delta1 = new Room("delta1"));
        delta.getListRoom().add(delta2 =new Room("delta2"));
        delta.getListRoom().add(delta3 =new Room("delta3"));
        delta.getListRoom().add(delta4 =new Room("delta4"));
        
        gamma.getListRoom().add(gamma1 = new Room("gamma1"));
        gamma.getListRoom().add(gamma2 = new Room("gamma2"));
        gamma.getListRoom().add(gamma3 = new Room("gamma3"));
        gamma.getListRoom().add(gamma4 = new Room("gamma4"));
        gamma.getListRoom().add(gamma5 = new Room("gamma5"));
        gamma.getListRoom().add(gamma6 = new Room("gamma6"));
        
        //declaration of the door that will be added to the alpha planet
        Door startSouth, alpha1North, alpha1East, alpha1South, alpha2West, alpha2South, alpha3South, alpha3West, alpha3North;
        LockedDoor alpha3East; 
        //declaration of the door that will be added to the beta planet
        Door beta1West, beta1East, beta1South, beta2West, beta2South, beta3North, 
        beta3East, beta4North, beta4West, beta5North, beta5South;
        LockedDoor beta4South; 
        //declaration of the door that will be added to the delta planet
        Door delta1North, delta1South, delta2North, delta3West, delta3South, delta4North ; 
        LockedDoor delta2East;
        //declaration of the door that will be added to the gamma planet
        Door gamma1North, gamma1South, gamma2North, gamma3North, gamma3South, 
        gamma3East, gamma4West, gamma4South, gamma6South, gamma5North, gamma5West; 
        LockedDoor gamma2South, gamma4North; 
        
        //creation of the door and they are added to the room for the alpha planet
        start.setExit("",startSouth = new Door(alpha1)); 
        alpha1.setExit("", alpha1North = new Door(start));
        alpha1.setExit("", alpha1East = new Door(alpha2));
        alpha1.setExit("", alpha1South = new Door(alpha3));
        alpha2.setExit("", alpha2West = new Door(alpha1));
        alpha2.setExit("", alpha2South = new Door(alpha3));
        alpha3.setExit("", alpha3North = new Door(alpha2));
        alpha3.setExit("", alpha3West = new Door(alpha1));
        alpha3.setExit("", alpha3South = new Door(delta1));
        alpha3.setExit("", alpha3East = new LockedDoor(beta1, ""));
        
        //creation of the door and they are added to the room for the delta planet
        delta1.setExit("", delta1North = new Door(alpha3));
        delta1.setExit("", delta1South = new Door(delta2));
        delta2.setExit("", delta2North = new Door(delta1));       
        delta2.setExit("", delta2East = new LockedDoor(delta3, ""));
        delta3.setExit("", delta3West = new Door(delta2));    
        delta3.setExit("", delta3South = new Door(delta4));       
        delta4.setExit("", delta4North = new Door(delta3));    
           
        
        //creation of the door and they are added to the room for the beta planet
        beta1.setExit("", beta1West = new Door(alpha3));
        beta1.setExit("", beta1South = new Door(beta3));
        beta1.setExit("", beta1East = new Door( beta2));      
        beta2.setExit("", beta2West = new Door(beta1));      
        beta2.setExit("", beta2South = new Door(beta4));            
        beta3.setExit("", beta3North = new Door(beta1)); 
        beta3.setExit("", beta3East = new Door(beta4));   
        beta4.setExit("", beta4North = new Door(beta2)); 
        beta4.setExit("", beta4West = new Door(beta3));
        beta4.setExit("", beta4South = new LockedDoor(beta5, ""));
        beta5.setExit("", beta5North = new Door(beta4));
        beta5.setExit("", beta5South = new Door(gamma1));
        
        //creation of the door and they are added to the room for the gamma planet
        gamma1.setExit("", gamma1North = new Door(beta5));
        gamma1.setExit("", gamma1South = new Door(gamma2));
        gamma2.setExit("", gamma2North = new Door(gamma1));
        gamma2.setExit("", gamma2South = new LockedDoor(gamma3, ""));
        gamma3.setExit("", gamma3North = new Door(gamma2));
        gamma3.setExit("", gamma3South = new Door(gamma5));
        gamma3.setExit("", gamma3East = new Door(gamma4));
        gamma4.setExit("", gamma4North = new LockedDoor(gamma6, ""));
        gamma4.setExit("", gamma4West = new Door(gamma3));
        gamma4.setExit("", gamma4South = new Door(gamma5));
        gamma5.setExit("", gamma5North = new Door(gamma4));
        gamma5.setExit("", gamma5West = new Door(gamma3));
        gamma6.setExit("", gamma6South = new Door( gamma4));
        
        //Add the monster in the rooms
        Monster monster1, monster2, monster3, monster4; //decalration of the monsters
        alpha2.addCharacter(monster1 = new Monster("Godzilla", 10000, 56)); 
        beta3.addCharacter(monster2 = new Monster("Yoda", 10000, 56)); 
        delta3.addCharacter(monster3 = new Monster("Darkness", 10000, 56)); 
        gamma6.addCharacter(monster4 = new Monster("Piranha", 10000, 56));
    }
    
}    
    

