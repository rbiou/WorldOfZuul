import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Décrivez votre classe startGameInterface ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class startGameInterface
{
    /**
     * Constructeur d'objets de classe startGameInterface
     */
    public startGameInterface()
    {
        JFrame playerForm = new JFrame();
        //Le logo
        Icon gameLogo = new ImageIcon(new ImageIcon("logo/gameLogo.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel panLogo = new JLabel(gameLogo, JLabel.CENTER);
        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white);
        panNom.setPreferredSize(new Dimension(250, 60));
        JTextField nom = new JTextField();
        nom.setPreferredSize(new Dimension(100, 25));
        panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage"));
        JLabel nomLabel = new JLabel("Saisir un nom :", JLabel.CENTER);
        panNom.add(nomLabel);
        panNom.add(nom);

        //Le sexe
        JPanel panSexe = new JPanel();
        panSexe.setBackground(Color.white);
        panSexe.setPreferredSize(new Dimension(220, 60));
        panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du personnage"));
        JComboBox sexe = new JComboBox();
        sexe.addItem("Masculin");
        sexe.addItem("Féminin");
        JLabel sexeLabel = new JLabel("Sexe : ",JLabel.CENTER);
        panSexe.add(sexeLabel);
        panSexe.add(sexe);

        //OK
        JPanel control = new JPanel();
        JButton okBouton = new JButton("JOUER");

        okBouton.addActionListener(new ActionListener(){

                public void actionPerformed(ActionEvent arg0) {
                    playerForm.setVisible(false);
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
        
        playerForm.pack();
        playerForm.setVisible(true);
    }
    
}