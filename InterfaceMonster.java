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
public class InterfaceMonster extends JPanel
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
     private JPanel panel1, panelDroite, panelSouth, panelCenter, panelWin, panelWinSouth, panelLoose, panelLooseSouth ;
     private JLabel labelImage ,labelText, labelEnigme, labelImageWin, labelImageLoose ;
     private JLabel labelLoose, labelWin;
     private JButton buttonReponse, buttonValidWin, buttonValidLoose;
     private ImageIcon monsterImage; 
     private Monster monster;
     
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
       labelText.setText("<html><center> <br><br>I AM " +monster.getName() 
       + " !!!!! <br>  YOU ARE VERY COURAGEOUS !!!! <br> GIVE THE CORRECT ANSWER OR YOU WILL LOSE HP !!! </center></html>");
       labelEnigme = new JLabel(monster.getQuestion());
       Icon imageMonster = new ImageIcon(new ImageIcon("monster/"+monster.getName()+".jpg").getImage().getScaledInstance(240, 270, Image.SCALE_DEFAULT));
       labelImage = new JLabel(imageMonster,JLabel.CENTER);
       panelCenter = new JPanel();
       panelCenter.setLayout(new GridLayout(2,1));
       panelCenter.add(labelText);
       panelCenter.add(labelEnigme);
      
       Font f = new Font("Serif", Font.PLAIN, 15); 

       labelText.setFont(f);
       labelEnigme.setFont(f);
       labelReponse =  new JTextField();
       labelReponse.setColumns(20);
       buttonReponse = new JButton ("Validate my answer ! ");
       buttonReponse.addActionListener(new MonsterListener(this, game));
       
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
       panel1.setVisible(true);
       
    }
    
    public JPanel setPanelWin() {
        panelWin = new JPanel();
        panelWin.setLayout(new BorderLayout());
        labelWin = new JLabel("",JLabel.CENTER);
        labelWin.setText("<html><center> CORRECT ANSWER !!! <br>  HERE 300 GOLDS AS A REWARD !!!<br> GOOD LUCK IN YOUR JOURNEY !!!!!! </center></html>");
        Icon imageMonster = new ImageIcon(new ImageIcon("monster/"+monster.getName()+".jpg").getImage().getScaledInstance(240, 230, Image.SCALE_DEFAULT));
        labelImageWin = new JLabel(imageMonster,JLabel.CENTER);
        panelWin.add(labelImageWin, BorderLayout.CENTER);
        
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
    
    public JPanel getPanelWin() {
        return panelWin;
    }
    
    public JPanel setPanelLoose() {
        panelLoose = new JPanel();
        panelLoose.setLayout(new BorderLayout());
        labelLoose = new JLabel("",JLabel.CENTER);
        labelLoose.setText("<html><center> WRONG ANSWER !!! <br>  AS A PUNISHEMENT I'M REMOVING YOU 50HP !!!<br> GOOD LUCK FOR THE NEXT TIME !!!!!! </center></html>");
        Icon imageMonster = new ImageIcon(new ImageIcon("monster/"+monster.getName()+".jpg").getImage().getScaledInstance(240, 230, Image.SCALE_DEFAULT));
        labelImageLoose = new JLabel(imageMonster,JLabel.CENTER);
        panelLoose.add(labelImageLoose, BorderLayout.CENTER);
        
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
    
    public JPanel getPanelLoose() {
        return panelLoose;
    }

    public JPanel getPanelPet(){
        return panel1; 
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
    
    public JButton getButtonValidLoose() {
        return buttonValidLoose;
    }
    
    public JButton getButtonValidWin() {
        return buttonValidWin;
    }
}

