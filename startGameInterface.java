import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *This class allows us to start the game by asking the player his name and sex to be able to assign an avatar. When the 
 *information are good the game starts.
 *
 * @author Group7
 * @version 13/12/18
 */
public class startGameInterface
{
    /**
     * Constructeur d'objets de classe startGameInterface
     */
    public startGameInterface()
    {
        //Final Window
        JFrame finalPanel = new JFrame();
        //Left part
        JPanel playerForm = new JPanel();
        //Le logo
        Icon gameLogo = new ImageIcon(new ImageIcon("logo/gameLogo.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel panLogo = new JLabel(gameLogo, JLabel.CENTER);
        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white); // color of the panNom
        panNom.setPreferredSize(new Dimension(250, 60)); // panNom dimensions
        JTextField nom = new JTextField(); // writing area for the player
        nom.setPreferredSize(new Dimension(100, 25)); // dimensions to the textField
        panNom.setBorder(BorderFactory.createTitledBorder("Player name")); // the title is placed as border
        JLabel nomLabel = new JLabel("Give a name :", JLabel.CENTER); // label where the player will give his name
        panNom.add(nomLabel);
        panNom.add(nom);

        //Le sexe
        JPanel panSexe = new JPanel(); 
        panSexe.setBackground(Color.white); // color if the panSexe
        panSexe.setPreferredSize(new Dimension(220, 60)); // dimension of the panSexe
        panSexe.setBorder(BorderFactory.createTitledBorder("Gender of the player"));
        JComboBox sexe = new JComboBox(); // to give the player the choice between féminin or masculin
        sexe.addItem("Male");
        sexe.addItem("Female");
        JLabel sexeLabel = new JLabel("Gender : ",JLabel.CENTER); // Label where the player give his sex
        panSexe.add(sexeLabel);
        panSexe.add(sexe);

        // If the information are good 
        JPanel control = new JPanel();
        JButton okBouton = new JButton("PLAY");
        okBouton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent arg0) {
                    finalPanel.setVisible(false);
                    Game game = new Game(nom.getText(), (String)sexe.getSelectedItem());
                }});
        
        JPanel playerPanel = new JPanel(); 
        
        playerForm.setLayout(new GridLayout (2,1));
        playerPanel.setLayout(new GridLayout (3,1));
        
        playerPanel.add(panNom);
        playerPanel.add(panSexe);
        playerPanel.add(okBouton);
        
        playerForm.add(panLogo);
        playerForm.add(playerPanel);
       
        
        
        finalPanel.setLayout(new GridLayout(1,2));
        
        String text = "After a difficult party, your vessel crashed into a planet. It's not smart from your part, but you can repare it. This planet is part of a planet group once upon explored by smurfs. They are linked together by temporal spatial gates.So this looks like a labyrinth.In the game, some gates are blocked. To open those doors, you must find the right keys that open those gates. Anyway, if you do not possede the key, you cannot click on the gate.The aim is to move between rooms to find 4 replacement pieces.\nIn a room, you can interact with pets, monsters and sellers. You can click only on them if they are present in the room.When you pet a pet, it gives you 1 gold as a reward. It also gives you the description of the planet.he monsters are here to challenging you with an enigma. If you give the right answer, the monster rewards you with 300 golds. Otherwise, you loose 50HP. So be carreful before challenging it !Different sellers are present all the game. You can sell them items you have found during your journey, or buy items like keys for example.\nYou have a bag where you can store objects but be careful : your bag has a limit of weight ! Also, planets have a limited time, depending on their atmosphere ! So do not stay too long on the same planet ! At the beginning of the game you have 100 life points but some traps are present in the game.You must be careful :)\nGood luck and have fun ! :)\n\nPS: When you have finished the game, use the quit button in the menu, do not click on the cross !!! ";
        JTextArea labelRules = new JTextArea (text);
        labelRules.setLineWrap(true);
        labelRules.setWrapStyleWord(true);
        Font f = new Font("Times New Roman", Font.PLAIN, 20);
        labelRules.setFont(f);
        
        finalPanel.add(playerForm);
        finalPanel.add(labelRules);
        
        finalPanel.pack();
        finalPanel.setVisible(true);
    }
    
}
