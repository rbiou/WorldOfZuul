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
        JFrame playerForm = new JFrame();
        //Le logo
        Icon gameLogo = new ImageIcon(new ImageIcon("logo/gameLogo.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
        JLabel panLogo = new JLabel(gameLogo, JLabel.CENTER);
        //Le nom
        JPanel panNom = new JPanel();
        panNom.setBackground(Color.white); // color of the panNom
        panNom.setPreferredSize(new Dimension(250, 60)); // panNom dimensions
        JTextField nom = new JTextField(); // writing area for the player
        nom.setPreferredSize(new Dimension(100, 25)); // dimensions to the textField
        panNom.setBorder(BorderFactory.createTitledBorder("Nom du personnage")); // the title is placed as border
        JLabel nomLabel = new JLabel("Saisir un nom :", JLabel.CENTER); // label where the player will give his name
        panNom.add(nomLabel);
        panNom.add(nom);

        //Le sexe
        JPanel panSexe = new JPanel(); 
        panSexe.setBackground(Color.white); // color if the panSexe
        panSexe.setPreferredSize(new Dimension(220, 60)); // dimension of the panSexe
        panSexe.setBorder(BorderFactory.createTitledBorder("Sexe du personnage"));
        JComboBox sexe = new JComboBox(); // to give the player the choice between féminin or masculin
        sexe.addItem("Masculin");
        sexe.addItem("Féminin");
        JLabel sexeLabel = new JLabel("Sexe : ",JLabel.CENTER); // Label where the player give his sex
        panSexe.add(sexeLabel);
        panSexe.add(sexe);

        // If the information are good 
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
