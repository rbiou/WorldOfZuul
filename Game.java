import java.util.*;
/**
 * Game class
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
        createWorld();
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
     * the method allows you to create the World of our game
     */
    public void createWorld()
    {

        //creation of the planets
        Planet startP = new Planet("Start", "Welcome on the planet start", 10, 10); 
        Planet alpha = new Planet("Alpha", "Welcome on the planet alpha", 10, 10); 
        Planet beta = new Planet("Beta", "Welcome on the planet beta", 10, 10); 
        Planet gamma = new Planet("Gamma", "Welcome on the planet gamma", 10, 10); 
        Planet delta = new Planet("Delta", "Welcome on the planet alpha", 10, 10);

        //creation of the rooms in each planet according to the map that we defined
        Room start, alpha1, alpha2, alpha3, beta1, beta2, beta3, beta4, beta5, delta1, delta2, delta3, delta4, gamma1, gamma2, gamma3,
        gamma4, gamma5, gamma6; //decalration of the room
        
        start = new Room("start", startP);
        
        alpha.getListRoom().add(alpha1 = new Room("alpha1", alpha)); 
        alpha.getListRoom().add(alpha2 =new Room("alpha2", alpha)); 
        alpha.getListRoom().add(alpha3 =new Room("alpha3", alpha)); 
        
        beta.getListRoom().add(beta1 = new Room("beta1", beta)); 
        beta.getListRoom().add(beta2 = new Room("beta2", beta));
        beta.getListRoom().add(beta3 = new Room("beta3", beta));
        beta.getListRoom().add(beta4 = new Room("beta4", beta));
        beta.getListRoom().add(beta5 = new Room("beta5", beta));
        
        delta.getListRoom().add(delta1 = new Room("delta1", delta));
        delta.getListRoom().add(delta2 =new Room("delta2", delta));
        delta.getListRoom().add(delta3 =new Room("delta3", delta));
        delta.getListRoom().add(delta4 =new Room("delta4", delta));
        
        gamma.getListRoom().add(gamma1 = new Room("gamma1", gamma));
        gamma.getListRoom().add(gamma2 = new Room("gamma2", gamma));
        gamma.getListRoom().add(gamma3 = new Room("gamma3", gamma));
        gamma.getListRoom().add(gamma4 = new Room("gamma4", gamma));
        gamma.getListRoom().add(gamma5 = new Room("gamma5", gamma));
        gamma.getListRoom().add(gamma6 = new Room("gamma6", gamma));
        
        //declaration of the doors that will be added to the alpha planet
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
        start.setExit("Smurfette",startSouth = new Door(alpha1)); 
        alpha1.setExit("Papa Smurf", alpha1North = new Door(start));
        alpha1.setExit("Hefty Smurf", alpha1East = new Door(alpha2));
        alpha1.setExit("Brainy Smurf", alpha1South = new Door(alpha3));
        alpha2.setExit("Grouchy Smurf", alpha2West = new Door(alpha1));
        alpha2.setExit("Clumsy Smurf", alpha2South = new Door(alpha3));
        alpha3.setExit("Greedy Smurf", alpha3North = new Door(alpha2));
        alpha3.setExit("Jokey Smurf", alpha3West = new Door(alpha1));
        alpha3.setExit("Chef Smurf", alpha3South = new Door(delta1));
        alpha3.setExit("Vanity Smurf", alpha3East = new LockedDoor(beta1, "square"));
        
        //creation of the door and they are added to the room for the delta planet
        delta1.setExit("Handy Smurf", delta1North = new Door(alpha3));
        delta1.setExit("Scaredy Smurf", delta1South = new Door(delta2));
        delta2.setExit("Tracker Smurf", delta2North = new Door(delta1));       
        delta2.setExit("Sloppy Smurf", delta2East = new LockedDoor(delta3, "circle"));
        delta3.setExit("Harmony Smurf", delta3West = new Door(delta2));    
        delta3.setExit("Painter Smurf", delta3South = new Door(delta4));       
        delta4.setExit("Poet Smurf", delta4North = new Door(delta3));    
           
        
        //creation of the door and they are added to the room for the beta planet
        beta1.setExit("Farmer Smurf", beta1West = new Door(alpha3));
        beta1.setExit("Natural Smurf", beta1South = new Door(beta3));
        beta1.setExit("Snappy Smurfling", beta1East = new Door( beta2));      
        beta2.setExit("Slouchy Smurfling", beta2West = new Door(beta1));      
        beta2.setExit("Grandpa Smurf", beta2South = new Door(beta4));            
        beta3.setExit("Baby Smurf", beta3North = new Door(beta1)); 
        beta3.setExit("Sassette Smurfling", beta3East = new Door(beta4));   
        beta4.setExit("Alchemist Smurf", beta4North = new Door(beta2)); 
        beta4.setExit("Timid Smurf", beta4West = new Door(beta3));
        beta4.setExit("Architect Smurf", beta4South = new LockedDoor(beta5, "triangle"));
        beta5.setExit("Baker Smurf", beta5North = new Door(beta4));
        beta5.setExit("Clockwork Smurf", beta5South = new Door(gamma1));
        
        //creation of the door and they are added to the room for the gamma planet
        gamma1.setExit("Dabbler Smurf", gamma1North = new Door(beta5));
        gamma1.setExit("Doctor Smurf", gamma1South = new Door(gamma2));
        gamma2.setExit("Dopey Smurf", gamma2North = new Door(gamma1));
        gamma2.setExit("Enamored Smurf", gamma2South = new LockedDoor(gamma3, "star"));
        gamma3.setExit("Finance Smurf", gamma3North = new Door(gamma2));
        gamma3.setExit("Flying Smurf", gamma3South = new Door(gamma5));
        gamma3.setExit("King Smurf", gamma3East = new Door(gamma4));
        gamma4.setExit("Lazy Smurf", gamma4North = new LockedDoor(gamma6, "rectangle"));
        gamma4.setExit("Miner Smurf", gamma4West = new Door(gamma3));
        gamma4.setExit("Nanny Smurf", gamma4South = new Door(gamma5));
        gamma5.setExit("Nosey Smurf", gamma5North = new Door(gamma4));
        gamma5.setExit("Editor Smurf", gamma5West = new Door(gamma3));
        gamma6.setExit("Reflection Smurf", gamma6South = new Door( gamma4));
        
        //Add the monster in the rooms
        Monster monster1, monster2, monster3, monster4; //declaration of the monsters
        alpha2.addCharacter(monster1 = new Monster("Godzilla", 10000, 56,alpha2, "What is the capital of Bulgaria?", "Sofia")); 
        beta3.addCharacter(monster2 = new Monster("Yoda", 10000, 56,beta3, "Who is the best friend of Dora", "Babouch")); 
        delta3.addCharacter(monster3 = new Monster("Darkness", 10000, 56,delta3, "what is the date of the creation of the Mona Lisa", "1503")); 
        gamma6.addCharacter(monster4 = new Monster("Piranha", 10000, 56,gamma6, "What is the color of mikey's shoes", "yellow"));
        
        //Declaration 
        Item knief1, engine, propellant, windows, wheel, magicBall1, magicBall2, diamond1;
        Item fork1, diamond2, knief2, fork2, diamond3, fork3; //Declaration of the item
        Chest chest1alpha3, chest2delta1, chest3delta4, chest4beta1, chest5beta5, chestGamma1, chestGamma1bis, chestGamma2; 
        Chest chestGamma5, chestGamma4, chestGamma6, chestAlpha1;//declaration of the chest
        Keys keyAlpha3, keyDelta2, keyBeta4, keyGamma2, keyGamma4; // declaration of the key to open the door
        Pet petAlpha1, petDelta1, petGamma1, petBeta1, petBeta4 ;// pets in the first room of the planet
        Seller sellerDelta2, sellerBeta2, sellerGamma3; //declaration of the sellers
        
         //Add the chests in the rooms
        alpha1.addChest(chestAlpha1 = new Chest("Bill",0,50, "Hello my name is Bob and you lose 50 HP",0,true));
        alpha3.addChest(chest1alpha3 = new Chest("Bob",0,50,"Hello my name is Bob",50,false));
        delta1.addChest(chest2delta1 = new Chest("Sully",0,50,"Hello my name is Sully",0,false));
        delta4.addChest(chest3delta4 = new Chest ("Titi",0,50,"Hello my name is Titi ",50,false));
        beta1.addChest(chest4beta1 = new Chest("Kiwi",0,50,"Hello my name is Kiwi",0,true));
        beta5.addChest(chest5beta5= new Chest ("Cramberry",0,50,"Hello my name is Fraise",50,false));
        gamma1.addChest(chestGamma1 = new Chest ("Grosminet",0,50,"Hello my name is Grosminet",0,false));
        gamma1.addChest(chestGamma1bis = new Chest ("Shield",0,50,"Hello my name is Shield",50,false));
        gamma2.addChest(chestGamma2 = new Chest ("Banana",0,50,"Hello my name is Banane",0,true)); 
        gamma5.addChest(chestGamma5 = new Chest ("The best",0,50,"Hello my name is the best",50,false));
        gamma4.addChest(chestGamma4 = new Chest ("Magic",0,50,"Hello my name is magic",0,false)); 
        gamma6.addChest(chestGamma6 = new Chest ("free",0,50,"Hello my name is free",50,false)); 
        
       
        //Add items in the chests
        chest1alpha3.getListItems().add(knief1=new Item("Knieffy",50,10,"I am a knief, you can sell me to the sellers "));
        chest1alpha3.getListItems().add(magicBall2=new Item("MiniBall",100,10,"I am a MagicBall, you can sell me to the sellers "));
        chest2delta1.getListItems().add(keyAlpha3 = new Keys("Red key",300,20,"I am a key, I can open the door Vanity Smurf", "square"));
        chest3delta4.getListItems().add(wheel=new Item("wheely",500,50,"I am the wheel of your vessel"));
        chest4beta1.getListItems().add(keyBeta4 = new Keys("Grey key",300,20,"I am a key, I can open the door Architect Smurf", "triangle"));
        chest5beta5.getListItems().add(windows = new Item("windows",500,50,"I am the windows of your vessel")); 
        chestGamma1.getListItems().add(keyGamma2 = new Keys("Green key",300,20,"I am a key, I can open the door Enamored Smurf", "star"));
        chestGamma1.getListItems().add(fork1 = new Item("Big fork",3,10,"I am the fork that you need because I can fly"));
        chestGamma5.getListItems().add(propellant = new Item("propellant", 500, 50, "I am a the propellant of your vessel"));
        chestGamma4.getListItems().add(diamond2 = new Item("Wonderful diamond", 250, 50, "I am a wonderful brillant diamond"));
        chestGamma6.getListItems().add(engine = new Item("engine", 500, 50, "I am the engine of your vessel"));
        
         
        
        //Add the pets to the rooms
        alpha1.addCharacter(petAlpha1 = new Pet ("Bamby", 1000000, 10000, alpha1, "fawn")); 
        delta1.addCharacter(petDelta1 = new Pet ("Dolly", 1000000, 10000, delta1, "ship")); 
        gamma1.addCharacter(petGamma1 = new Pet ("Pumba", 1000000, 10000, gamma1, "pig")); 
        beta1.addCharacter(petBeta1 = new Pet ("Winnie", 1000000, 10000, delta1, "bear"));
        beta4.addCharacter(petBeta4= new Pet ("Timon", 1000000, 10000, delta4, "mongouste"));
        
         //Add the sellers to the rooms
        delta2.addCharacter(sellerDelta2 = new Seller ("Dumbledore", 15000, 200, delta2));
        beta2.addCharacter(sellerBeta2 = new Seller ("Hagrid", 15000, 200, beta2));
        gamma3.addCharacter(sellerGamma3 = new Seller("Harry Potter", 15000, 500, gamma3));
        
        //Add items to the sellers
        sellerDelta2.getListItems().add(keyDelta2 = new Keys("Yellow key",300,20,"I am a key, I can open the door Sloppy Smurf", "circle"));
        sellerBeta2.getListItems().add(magicBall1 = new Item ("flackball",100,50,"I am a diamond, you can win 100 pieces if you sell me"));
        sellerBeta2.getListItems().add(diamond1 = new Item ("little diamond",250,50,"I am a diamond, you can bue me"));
        sellerGamma3.getListItems().add(knief2 = new Item("sharp knife", 50, 10,"I am a sharp knief, you can buy me"));
        sellerGamma3.getListItems().add(fork2 = new Item("Small knife", 3, 10,"I am a small fork, you can buy me"));
        sellerGamma3.getListItems().add(keyGamma4 = new Keys("Blue key", 300, 20,"I am a key, I can open the door Lazy Smurf", "rectangle"));
        sellerDelta2.getListItems().add(diamond3 = new Item("Special diamond", 250, 50, "I am a special diamond, you can buy me to see why I am special"));
        sellerDelta2.getListItems().add(fork3 = new Item("Special fork", 3, 50, "I am a special fork, you can buy me to see why I am special"));
        
    }
   
    /**
     * Getter to return the name of the room
     * 
     * @return      String
     */
    public List<Planet> getListPlanet()
    {
        return this.listPlanet; 
    }
}    
    

