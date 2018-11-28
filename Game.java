
import java.util.*;
/**
 * Game class
 * 
 * The game is built in this class : 
 * First, planets and rooms are created. Rooms are added to the planets (not the same number of rooms in each planet). 
 * Then, exits(Door) are associated to the rooms (not the same number of exits in the rooms). 
 * A door can be a simple door (which is always opened) or a locked door. The latter is opened with a specific key. 
 * All the keys to open the locked door are in the chest or selling by the sellers : Key : price=300 & weight= 20
 * Other objects can be found (in a chest or thank to a seller) : 
 *      MagicBall : price=150  &  weight= 10
 *      Diamond : price=250  &  weight= 30
 *      Knief : price=50  &  weight= 5
 *      Fork : price= 3  &  weight= 5
 *      Vessel pieces : wheel/window/propullant/engine : available in a chest with : weight = 50
 * 
 * The player can also sell his own objects that he found to earn money. 
 * A chest can be trapped. In this case, the player loses 25 life points.
 * All objects that the player finds are added to his bag. It has a limit of weight. 
 * The player starts the game with 100 life points. 
 * 
 * The aim of the game is to find all the vessel pieces. In this way, the player who is lost in the space 
 * can repair his vessel and go back on earth. He has to move between the different rooms (so, he moves between planets) using
 * the door to find all the vessel pieces. 
 * 
 * During his journey to find his pieces of vessel, he can meet : pets and monsters. 
 * Pets are presents in the first room of each planet to explain the feature of the planet. 
 * There also pets that give money to the player (1 piece when he pets them)
 * Monsters can also interact with the player with enigmas. If the answer of the player is right, he earns 300pieces. 
 * In the other case, he loses 50 life points.
 * 
 * The player can stay on the planet during a specific time. Each planet has its specific features. 
 * If the time that he spends on the planet is to long, the player dies and returns to the beginning of the game. 
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
        Planet startP = new Planet("Start", "Hic incipit adventum tuum.", 10, 10); 
        Planet alpha = new Planet("Alpha", "Ikke kast bort tiden din her, det er ingen nøkkel eller del av skipet.", 10, 10); 
        Planet beta = new Planet("Beta", "Θα βρείτε ένα κλειδί στο δωμάτιο ένα και ένα δωμάτιο του πλοίου στην αίθουσα πέντε.", 10, 10); 
        Planet gamma = new Planet("Gamma", "您將在第一和第三房間找到鑰匙，以及第五和第六房間的船隻。", 10, 10); 
        Planet delta = new Planet("Delta", "Вы найдете ключи в номерах один и два, а также комнату в комнате четыре.", 10, 10);

        //creation of the rooms in each planet according to the map that we defined
        Room start, alpha1, alpha2, alpha3, beta1, beta2, beta3, beta4, beta5, delta1, delta2, delta3, delta4, gamma1, gamma2, gamma3,
        gamma4, gamma5, gamma6; //decalration of the room
        
        start = new Room("start", startP);
        
        alpha.addRoom(alpha1 = new Room("alpha1", alpha)); 
        alpha.addRoom(alpha2 =new Room("alpha2", alpha)); 
        alpha.addRoom(alpha3 =new Room("alpha3", alpha)); 
        
        beta.addRoom(beta1 = new Room("beta1", beta)); 
        beta.addRoom(beta2 = new Room("beta2", beta));
        beta.addRoom(beta3 = new Room("beta3", beta));
        beta.addRoom(beta4 = new Room("beta4", beta));
        beta.addRoom(beta5 = new Room("beta5", beta));
        
        delta.addRoom(delta1 = new Room("delta1", delta));
        delta.addRoom(delta2 =new Room("delta2", delta));
        delta.addRoom(delta3 =new Room("delta3", delta));
        delta.addRoom(delta4 =new Room("delta4", delta));
        
        gamma.addRoom(gamma1 = new Room("gamma1", gamma));
        gamma.addRoom(gamma2 = new Room("gamma2", gamma));
        gamma.addRoom(gamma3 = new Room("gamma3", gamma));
        gamma.addRoom(gamma4 = new Room("gamma4", gamma));
        gamma.addRoom(gamma5 = new Room("gamma5", gamma));
        gamma.addRoom(gamma6 = new Room("gamma6", gamma));
        
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
        chest1alpha3.addItem(knief1=new Item("Knieffy",50,5,"I am a knief, you can sell me to the sellers "));
        chest1alpha3.addItem(magicBall2=new Item("MiniBall",100,10,"I am a MagicBall, you can sell me to the sellers "));
        chest2delta1.addItem(keyAlpha3 = new Keys("Red key",300,20,"I am a key, I can open the door Vanity Smurf", "square"));
        chest3delta4.addItem(wheel=new Item("wheely",500,50,"I am the wheel of your vessel"));
        chest4beta1.addItem(keyBeta4 = new Keys("Grey key",300,20,"I am a key, I can open the door Architect Smurf", "triangle"));
        chest5beta5.addItem(windows = new Item("windows",500,50,"I am the windows of your vessel")); 
        chestGamma1.addItem(keyGamma2 = new Keys("Green key",300,20,"I am a key, I can open the door Enamored Smurf", "star"));
        chestGamma1.addItem(fork1 = new Item("Big fork",3,5,"I am the fork that you need because I can fly"));
        chestGamma5.addItem(propellant = new Item("propellant", 500, 50, "I am a the propellant of your vessel"));
        chestGamma4.addItem(diamond2 = new Item("Wonderful diamond", 250, 30, "I am a wonderful brillant diamond"));
        chestGamma6.addItem(engine = new Item("engine", 500, 50, "I am the engine of your vessel"));
        
         
        
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
        sellerDelta2.addItem(keyDelta2 = new Keys("Yellow key",300,20,"I am a key, I can open the door Sloppy Smurf", "circle"));
        sellerBeta2.addItem(magicBall1 = new Item ("flackball",100,30,"I am a diamond, you can buy me"));
        sellerBeta2.addItem(diamond1 = new Item ("little diamond",250,30,"I am a diamond, you can buy me"));
        sellerGamma3.addItem(knief2 = new Item("sharp knife", 50, 5,"I am a sharp knief, you can buy me"));
        sellerGamma3.addItem(fork2 = new Item("Small knife", 3, 5,"I am a small fork, you can buy me"));
        sellerGamma3.addItem(keyGamma4 = new Keys("Blue key", 300, 20,"I am a key, I can open the door Lazy Smurf", "rectangle"));
        sellerDelta2.addItem(diamond3 = new Item("Special diamond", 250, 30, "I am a special diamond, you can buy me to see why I am special"));
        sellerDelta2.addItem(fork3 = new Item("Special fork", 3, 5, "I am a special fork, you can buy me to see why I am special"));
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
    
