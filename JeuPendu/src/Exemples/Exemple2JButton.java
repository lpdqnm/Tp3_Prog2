
package Exemples;

import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple2JButton {
   
   //constantes de classe
   public final static int LARG_BTN = 100;
   public final static int HAUT_BTN = 40;
   
   //variables d'instance
   
   //fenetre principale et conteneur pour les boutons
   private JFrame fenetre; 
   
   //boutons cliquables
   private JButton btnOK;
   private JButton btnAnnuler;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple2JButton() {
      
      //NOTE : decommenter un seul des initx pour visualiser l'exemple
      
      //init1(); 
      //init2();
      init3();
   }
   
   /**
    * Un bouton dans un JFrame avec gestionnaire de disposition null
    */
   private void init1() {
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec un bouton");
      fenetre.setBounds(400, 300, 500, 500);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      
      //Ne pas utiliser de Layout manager pour le JFrame.
      //Ceci veut dire que l'on devra donner une taille et
      //positionner chaque composant contenus dans le JFrame
      fenetre.setLayout(null);
      
      //creation et initialisation du bouton OK en donnant le texte
      //du bouton en parametre du constructeur
      btnOK = new JButton("OK");
      
      //NOTE : l'instruction precedent est equivalente aux deux instructions
      //suivantes :
      //btnOK = new JButton();
      //btnOK.setText("OK");
      
      //dimensionner et positionner le bouton a peu pres au milieu du JFrame. 
      //Pour la position, les coordonnees 0,0 correspondent au coin 
      //superieur gauche du conteneur de ce bouton qui
      //est ici le JFrame.
      btnOK.setBounds(fenetre.getWidth() / 2 - LARG_BTN / 2,   //x
              fenetre.getHeight() / 2 - HAUT_BTN,              //y
              LARG_BTN, HAUT_BTN);                             //larg, haut
      
      //NOTE : fenetre.getWidth retourne la largeur de la fenetre
      //       fenetre.getHeight retourne la hauteur de la fenetre
      //       getWidth() et getHeight() peuvent etre utilises sur 
      //       la plupart des composants graphiques.
      
      //Ajouter le boutons au content pane du JFrame
      fenetre.getContentPane().add(btnOK);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   /**
    * Deux boutons dans un JFrame avec gestionnaire de disposition null
    */
   private void init2() {
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec deux bouton");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      
      //Ne pas utiliser de Layout manager pour le JFrame.
      //Ceci veut dire que l'on devra donner une taille et
      //positionner chaque composant contenus dans le JFrame
      fenetre.setLayout(null);
      
      //creation et initialisation du bouton OK en donnant le texte
      //du bouton en parametre du constructeur
      btnOK = new JButton("OK");
      
      //dimensionner et positionner le bouton OK au milieu dans le bas 
      //du JFrame
      btnOK.setBounds(fenetre.getWidth() / 2 - LARG_BTN - 5,  //x
              fenetre.getHeight() - HAUT_BTN - 40,            //y
              LARG_BTN, HAUT_BTN);                            //larg, haut
      
      //creation et initialisation du bouton Annuler en donnant le texte
      //du bouton en parametre du constructeur
      btnAnnuler = new JButton("Annuler");
      
      //dimensionner et positionner le bouton Annuler a droite du bouton OK
      //en fonction de la position du bonton OK.
      btnAnnuler.setBounds(btnOK.getX() + LARG_BTN + 10,    //x
              btnOK.getY(),                                 //y
              LARG_BTN, HAUT_BTN);                          //larg, haut
      
      //NOTE : btnOK.getX() retourne la coordonnee x de btnOK
      //       btnOK.getY() retourne la coordonnee y de btnOK
      //       getX()() et getY() peuvent etre utilises sur 
      //       la plupart des composants graphiques.
      
      //Ajouter les deux bouton au content pane du JFrame
      fenetre.getContentPane().add(btnOK);
      fenetre.getContentPane().add(btnAnnuler);

      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   /**
    * Meme exemple que init2, mais avec le bouton Annuler desactive.
    */
   private void init3() {
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec un bouton");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      fenetre.setLayout(null);
      
      //creation et initialisation des proprietes du bouton OK 
      btnOK = new JButton("OK");
      btnOK.setBounds(fenetre.getWidth() / 2 - LARG_BTN - 5,  //x
              fenetre.getHeight() - HAUT_BTN - 40,            //y
              LARG_BTN, HAUT_BTN);                            //larg, haut
      
      //creation et initialisation des proprietes du bouton Annuler 
      btnAnnuler = new JButton("Annuler");
      btnAnnuler.setBounds(btnOK.getX() + LARG_BTN + 10,    //x
              btnOK.getY(),                                 //y
              LARG_BTN, HAUT_BTN);                          //larg, haut

      //desactiver le bouton Annuler
      btnAnnuler.setEnabled(false);
      
      //Ajouter les deux bouton au content pane du JFrame
      fenetre.getContentPane().add(btnOK);
      fenetre.getContentPane().add(btnAnnuler);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   public static void main (String [] args)  {
      
      new Exemple2JButton();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple2JButton();
            }
      });
      */
   }
   
}
