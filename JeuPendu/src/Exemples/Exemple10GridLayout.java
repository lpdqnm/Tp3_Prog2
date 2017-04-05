

package Exemples;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;


/**
 * GridLayout arrange les composants dans une grille rectangulaire. Le conteneur 
 * est divise en rectangles de dimensions egales et un composant est place dans
 * chaque rectangle.
 * 
 * REF: traduction de la Javadoc de GridLayout (JavaSE 6)
 * 
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple10GridLayout {

   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   //tableau de 6 boutons
   private JButton[] boutons = new JButton[6];
   
   //panneau (plus petit que le JFrame) qui contiendra les boutons,
   //pour creer une marge autour du JFrame (voir exemple 3 => init3)
   private JPanel panneau;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple10GridLayout() {
      
      //NOTE : decommenter un seul des initx pour visualiser l'exemple
      
      //Grille de 3 lignes, 2 col, avec 6 boutons
      init1(); 
      
      //Grille de 2 lignes, 3 col, avec 6 boutons et 
      //espace entre les col (hgap) de 20 et espace entre les
      //lignes (vgap) de 20
      //init2();
      
      //Avec un  panneau (GridLayout) qui contient les boutons.
      //init3();
   }
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * GridLayout (3 lignes, 2 colonnes) contenant 6 boutons.
    */
   private void init1() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple GridLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //assigner le gestionnaire de disposition GridLayout
      fenetre.setLayout(new GridLayout(3, 2)); //grille de 3 lignes et 2 colonnes
      
      
      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("Bouton 1");
      boutons[1] = new JButton("Bouton 2");
      boutons[2] = new JButton("Bouton 3");
      boutons[3] = new JButton("Bouton 4");
      boutons[4] = new JButton("Bouton 5");
      boutons[5] = new JButton("Bouton 6");
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(boutons[0]);
      fenetre.getContentPane().add(boutons[1]);
      fenetre.getContentPane().add(boutons[2]);
      fenetre.getContentPane().add(boutons[3]);
      fenetre.getContentPane().add(boutons[4]);
      fenetre.getContentPane().add(boutons[5]);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * GridLayout (2 lignes, 3 colonnes) contenant 6 boutons.
    */
   private void init2() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple GridLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //assigner le gestionnaire de disposition GridLayout
      //grille de 2 lignes et 3 colonnes avec vgap et hgap = 20
      fenetre.setLayout(new GridLayout(2, 3, 20, 20)); 
      
      
      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("Bouton 1");
      boutons[1] = new JButton("Bouton 2");
      boutons[2] = new JButton("Bouton 3");
      boutons[3] = new JButton("Bouton 4");
      boutons[4] = new JButton("Bouton 5");
      boutons[5] = new JButton("Bouton 6");
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(boutons[0]);
      fenetre.getContentPane().add(boutons[1]);
      fenetre.getContentPane().add(boutons[2]);
      fenetre.getContentPane().add(boutons[3]);
      fenetre.getContentPane().add(boutons[4]);
      fenetre.getContentPane().add(boutons[5]);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * GridLayout (2 lignes, 3 colonnes) contenant 6 boutons.
    */
   private void init3() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple GridLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //pas de gestionnaire de disposition. 
      fenetre.setLayout(null); 
      
      /*********************************************************
       * INIT PANNEAU
       *********************************************************/
      
      //Creatioin d'un JPanel avec GridLayout : grille de 3 lignes, 
      //2 colonnes, espace horiz. (hgap) = 10 et espace vert. (vgap)
      //= 20
      panneau = new JPanel(new GridLayout(3, 2, 10, 20));
      
      //centrer le panneau dans le JFrame en laissant une marge de 20 tout
      //le tour
      panneau.setBounds(20, 20, 
              fenetre.getWidth() -40,
              fenetre.getHeight() - 60);
      

      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("Bouton 1");
      boutons[1] = new JButton("Bouton 2");
      boutons[2] = new JButton("Bouton 3");
      boutons[3] = new JButton("Bouton 4");
      boutons[4] = new JButton("Bouton 5");
      boutons[5] = new JButton("Bouton 6");
      
      //Ajout des 6 boutons au panneau
      panneau.add(boutons[0]);
      panneau.add(boutons[1]);
      panneau.add(boutons[2]);
      panneau.add(boutons[3]);
      panneau.add(boutons[4]);
      panneau.add(boutons[5]);
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      
      //ajout du panneau au JFrame
      fenetre.getContentPane().add(panneau);
      
      
      //NOTE : Evidemment on peut inserer differents composants dans la 
      //grille, pas seulement des boutons.
      
      //Aussi, on peut utiliser les methodes setHgap setVgap pour modifier
      //l'espace horizontal et l'espace vertical entre les rectangles de la 
      //grille. Par exemple : 
      //((GridLayout)panneau.getLayout()).setHgap(5);
      //((GridLayout)panneau.getLayout()).setVgap(5);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   
   public static void main (String [] args)  {
      
      new Exemple10GridLayout();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple10GridLayout();
            }
      });
      */
   }
   
}






