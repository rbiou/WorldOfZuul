import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.*;

/**
 * Class interface monster shows a monster, this class is composed of 
 *  - the panel 1 : display the monster, and a label with his enigma. There is also a text field for the player to put his answer 
 *  and a button to validate the answer.
 *  - the win panel : when the player give the right answer, display the monster and a button to validate the win, after that 
 *  the button to interract with the monster is not accessible anymore.
 *  - the loose panel : when the player give the wrong answer, display the monster his sentence and a button to validate the loose.
 * 
 * @author(Group7)
 * @date(20/12/2018)
 */
public class InterfaceMonster extends JPanel
{
    // all attributes used in the class to construct the different labels and panels
     private JPanel panel1, panelDroite, panelSouth, panelCenter, panelWin, panelWinSouth, panelLoose, panelLooseSouth ; // all the panels
     private JLabel labelImage ,labelText, labelEnigme, labelImageWin, labelImageLoose ; // the label to display the monsters and the answer field
     private JLabel labelLoose, labelWin; // display the sentence of the monster is the player loose or win
     private JButton buttonReponse, buttonValidWin, buttonValidLoose; // all the buttons to validate the reponse and if the player win or loose the enigma
     private ImageIcon monsterImage; //create the image of the monster
     private Monster monster; // declare a monster
     private JTextField labelReponse; // the field for the player to put his answer
     private Game game ; // declare a game
    /**
     * Constructeur d'objets de classe MonsterListener
     * Creation of the first panel that display the monster picture, the enigma and put a textfield
     * to allow to the player to give an answer. Also add a button to validate the answer.
     * 
     * @param : game and monster of the room
     */
    public InterfaceMonster(Game gameT, Monster monsterT)
    {
       //instanciation of the objects of the InterfaceMonster
       
       //create the panel1
       panel1 = new JPanel(); 
       panel1.setLayout(new GridLayout(1,2));
       
       game=gameT; 
       monster=monsterT;
       //the label to put the monster's sentence
       labelText = new JLabel("",JLabel.CENTER);
       labelText.setText("<html><center> <br>I AM " +monster.getName() 
       + " !!!!! <br>  YOU ARE VERY COURAGEOUS !!!! <br> GIVE THE CORRECT ANSWER OR YOU WILL LOSE HP !!! </center></html>");
       //the label to display the monster's enigma
       labelEnigme = new JLabel(monster.getQuestion());
       //display the monster's label
       Icon imageMonster = new ImageIcon(new ImageIcon("monster/"+monster.getName()+".jpg").getImage().getScaledInstance(240, 270, Image.SCALE_DEFAULT));
       labelImage = new JLabel(imageMonster,JLabel.CENTER);
       
       panelCenter = new JPanel();
       panelCenter.setLayout(new GridLayout(2,1));
       panelCenter.add(labelText);
       panelCenter.add(labelEnigme);
       
       //change the font of enigma's sentence
       Font f = new Font("Serif", Font.PLAIN, 15); 
       labelText.setFont(f);
       labelEnigme.setFont(f);
       
       //label of the player's response
       labelReponse =  new JTextField();
       labelReponse.setColumns(20);
       //button to validate the response
       buttonReponse = new JButton ("Validate my answer ! ");
       buttonReponse.addActionListener(new MonsterListener(this, game));
       
       panelDroite = new JPanel();
       panelDroite.setLayout(new BorderLayout());
       // a panel to display the player's response and the validating button 
       panelSouth = new JPanel();
       panelSouth.setLayout(new GridLayout(2,1));
       panelSouth.add(labelReponse);
       panelSouth.add(buttonReponse);
       
       panelDroite.add(panelCenter,BorderLayout.CENTER);
       panelDroite.add(panelSouth,BorderLayout.SOUTH);
       
       panel1.add(labelImage);
       panel1.add(panelDroite);
       panel1.setVisible(true);
       
    }
    
    /**
     * Creation of the win panel when the player give the good answer of the enigma
     */
    public JPanel setPanelWin() {
        //create the panel
        panelWin = new JPanel();
        panelWin.setLayout(new BorderLayout());
        //create the label to display the monster's sentence
        labelWin = new JLabel("",JLabel.CENTER);
        labelWin.setText("<html><center> CORRECT ANSWER !!! <br>  HERE 300 GOLDS AS A REWARD !!!<br> GOOD LUCK IN YOUR JOURNEY !!!!!! </center></html>");
        //create the monster's image
        Icon imageMonster = new ImageIcon(new ImageIcon("monster/"+monster.getName()+".jpg").getImage().getScaledInstance(240, 230, Image.SCALE_DEFAULT));
        // the label wwhen the user win
        labelImageWin = new JLabel(imageMonster,JLabel.CENTER);
        panelWin.add(labelImageWin, BorderLayout.CENTER);
        // button to validate when the player give the right answer
        buttonValidWin = new JButton ("Thank you bro");
        buttonValidWin.addActionListener(new MonsterListener(this, game));
        
        panelWinSouth = new JPanel();
        panelWinSouth.setLayout(new GridLayout(2,1));
        
        panelWinSouth.add(labelWin);
        panelWinSouth.add(buttonValidWin);
        panelWin.add(panelWinSouth,BorderLayout.SOUTH); 
        
        panelWin.setVisible(true);
        return panelWin;
    }
    
     /**
     * Getter of the panelWin
     * @return: panelWin
     */
    public JPanel getPanelWin() {
        return panelWin;
    }
    
     /**
     * Creation of the loose panel when the player give the wrong answer of the enigma
     */
    public JPanel setPanelLoose() {
        //the panel when the player give the wrong answer
        panelLoose = new JPanel();
        panelLoose.setLayout(new BorderLayout());
        //the monster's sentence when the player give the wrong answer
        labelLoose = new JLabel("",JLabel.CENTER);
        labelLoose.setText("<html><center> WRONG ANSWER !!! <br>  AS A PUNISHEMENT I'M REMOVING YOU 50HP !!!<br> GOOD LUCK FOR THE NEXT TIME !!!!!! </center></html>");
        //create the monster's image
        Icon imageMonster = new ImageIcon(new ImageIcon("monster/"+monster.getName()+".jpg").getImage().getScaledInstance(240, 230, Image.SCALE_DEFAULT));
        
        labelImageLoose = new JLabel(imageMonster,JLabel.CENTER);
        panelLoose.add(labelImageLoose, BorderLayout.CENTER);
        //button to validate the wrong answer
        buttonValidLoose = new JButton ("I WILL BEAT YOU NEXT TIME !");
        buttonValidLoose.addActionListener(new MonsterListener(this, game));
        
        panelLooseSouth = new JPanel();
        panelLooseSouth.setLayout(new GridLayout(2,1));
        panelLooseSouth.add(labelLoose);
        panelLooseSouth.add(buttonValidLoose);
        panelLoose.add(panelLooseSouth,BorderLayout.SOUTH); 
       
        panelLoose.setVisible(true);
        return panelLoose;
    }
    
    /**
     * Getter of the panelLoose
     * @return: panelLoose
     */
    public JPanel getPanelLoose() {
        return panelLoose;
    }
   
    /**
     * Getter of the ButtonReponse
     * @return: buttonReponse
     */
    public JButton getButtonReponse() {
        return buttonReponse;
    }
    
    /**
     * Getter of the LabelReponse
     * @return: labelReponse
     */
    public JTextField getLabelReponse() {
        return labelReponse;
    }
    
    /**
     * Getter of the Monster
     * @return: monster
     */
    public Monster getMonster() {
        return monster;
    }
    
    /**
     * Getter of the Player
     * @return: game.getPlayer()
     */
    public Player getPlayer(){
        return game.getPlayer();
    }
    
    /**
     * Getter of the Panel1
     * @return: panel1
     */
    public JPanel getPanel1() {
        return panel1;
    }
    
    /**
     * Getter of the ButtonValid for the loose panel
     * @return: buttonValidLoose
     */
    public JButton getButtonValidLoose() {
        return buttonValidLoose;
    }
    
     /**
     * Getter of the ButtonValid for the win panel
     * @return: buttonValidWin
     */
    public JButton getButtonValidWin() {
        return buttonValidWin;
    }
}

