// import java.awt.event.*;
// import javax.swing.*;

// /**
 // * Décrivez votre classe Listener ici.
 // *
 // * @author (Lagrange Romain)
 // * @version (5/12/2018)
 // */
// public class MonsterListener implements ActionListener
// {
    // // variables d'instance 
    // private InterfaceMonster interMonster;
    // private String reponse;
    // /**
     // * Constructeur d'objets de classe Listener
     // */
    // public MonsterListener(InterfaceMonster i)
    // {
        // interMonster = i;
    // }
    
    // /**
     // * Action performed for the different buttons
     // */
    // public void actionPerformed(ActionEvent e){
        // if (e.getSource()==interMonster.getButtonReponse()){
            // reponse = interMonster.getLabelReponse().getText();
            // interMonster.getMonster().checkAnswer(reponse, interMonster.getPlayer());
            // if (interMonster.getMonster().checkAnswer(reponse, interMonster.getPlayer()))
                // {
                // interMonster.getPanel1().setVisible(false);
                // interMonster.changerPanel(interMonster.setPanelWin());
            // }
            // else {
                // interMonster.getPanel1().setVisible(false);
                // interMonster.changerPanel(interMonster.setPanelLoose());}
        // }
    // }
// }