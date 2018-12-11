import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.*;

/**
 * Décrivez votre classe Listener ici.
 *
 * @MARLIAT Julien
 * @5/12/2018
 */
public class InterfaceMonster extends JFrame
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
     private JPanel panel1, panelDroite, panelSouth, panelCenter, panelWin, panelLoose ;
     private JLabel labelImage ,labelText, labelEnigme ;
     private JLabel labelLoose, labelWin;
     private JButton buttonReponse;
     private ImageIcon monsterImage; 
     private Monster monster;
     private JFrame myFrame;
     private JTextField labelReponse;
     private Game game ;
    /**
     * Constructeur d'objets de classe Listener
     */
    public InterfaceMonster(Game gameT, Monster monsterT)
    {
       panel1 = new JPanel(); 
       panel1.setLayout(new GridLayout(1,2));
       game=gameT; 
       monster=monsterT;
       labelText = new JLabel("",JLabel.CENTER);
       labelText.setText("<html><center> I AM " +monster.getName() 
       + " !!!!! <br>  YOU ARE VERY COURAGEOUS !!!! <br> GIVE THE CORRECT ANSWER OR YOU WILL LOSE HP !!! </center></html>");
       labelEnigme = new JLabel(monster.getQuestion());
       Icon imagePets = new ImageIcon("monster/"+monster.getName()+".jpg");
       labelImage = new JLabel(imagePets,JLabel.CENTER);
       panelCenter = new JPanel();
       panelCenter.setLayout(new GridLayout(2,1));
       panelCenter.add(labelText);
       panelCenter.add(labelEnigme);
      
       Font f = new Font("Serif", Font.PLAIN, 18); 

       labelText.setFont(f);
       labelEnigme.setFont(f);
       labelReponse =  new JTextField();
       labelReponse.setColumns(20);
       buttonReponse = new JButton ("Validate my answer ! ");
       buttonReponse.addActionListener(new MonsterListener(this));
       
       panelDroite = new JPanel();
       panelDroite.setLayout(new BorderLayout());
       
       panelSouth = new JPanel();
       panelSouth.setLayout(new GridLayout(2,1));
       panelSouth.add(labelReponse);
       panelSouth.add(buttonReponse);
       
       
       panelDroite.add(panelCenter,BorderLayout.CENTER);
       panelDroite.add(panelSouth,BorderLayout.SOUTH);
       
       
       
       panel1.add(labelImage);
       panel1.add(panelDroite);
       myFrame = new JFrame("Monster");
       myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       this.add(panel1);
      
       this.pack();
       this.setVisible(true);
       
    }
    
    public JPanel setPanelWin() {
        panelWin = new JPanel();
        panelWin.setLayout(new BorderLayout());
        labelWin = new JLabel("",JLabel.CENTER);
        labelWin.setText("<html><center> CORRECT ANSWER !!! <br>  HERE 300 GOLDS AS A REWARD !!!<br> GOOD LUCK IN YOUR JOURNEY !!!!!! </center></html>");
        panelWin.add(labelImage, BorderLayout.CENTER);
        panelWin.add(labelWin,BorderLayout.SOUTH); 
        
        panelWin.setVisible(true);
        return panelWin;
    }
    
    public JPanel getPanelWin() {
        return panelWin;
    }
    
    public JPanel setPanelLoose() {
        panelLoose = new JPanel();
        panelLoose.setLayout(new BorderLayout());
        labelLoose = new JLabel("",JLabel.CENTER);
        labelLoose.setText("<html><center> WRONG ANSWER !!! <br>  AS A PUNISHEMENT I'M REMOVING YOU 50HP !!!<br> GOOD LUCK FOR THE NEXT TIME !!!!!! </center></html>");
        panelLoose.add(labelImage, BorderLayout.CENTER);
        panelLoose.add(labelLoose,BorderLayout.SOUTH); 
       
        panelLoose.setVisible(true);
        return panelLoose;
    }
    
    public JPanel getPanelLoose() {
        return panelLoose;
    }

    public JPanel getPanelPet(){
        return panel1; 
    }
    
    /**
     * Method used to actualize the actual panel displayed on the window
     */
    public void changerPanel(JPanel pan){
        this.setContentPane(pan);
        this.revalidate();
        this.repaint();
    }
    
    public JButton getButtonReponse() {
        return buttonReponse;
    }
    
    public JTextField getLabelReponse() {
        return labelReponse;
    }
    
    public Monster getMonster() {
        return monster;
    }
    
    public Player getPlayer(){
        return game.getPlayer();
    }
    
    public JPanel getPanel1() {
        return panel1;
    }
}
