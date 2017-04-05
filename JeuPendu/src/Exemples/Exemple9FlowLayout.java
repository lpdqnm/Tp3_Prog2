

package Exemples;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;


/**
 * FlowLayout arrange les composants dans un flux directionnel, un peu comme 
 * les lignes d'un texte dans un paragraphe. 
 * 
 * FlowLayout est typiquement utilise pour positionner les boutons dans un
 * panneau. Il positionne les boutons horizontalement jusqu'a ce 
 * que ce ne soit plus possible d'inserer un bouton sur cette ligne (va ensuite a
 * la ligne suivante).
 * 
 * L'alignement sur un ligne est determine par la propriete align dont les valeurs
 * peuvent être :
 *    LEFT
 *    RIGHT
 *    CENTER     -  valeur par defaut
 * 
 * REF: traduction de la Javadoc de FlowLayout (JavaSE 6)
 * 
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple9FlowLayout {

   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   //tableau de 6 boutons
   private JButton[] boutons = new JButton[6];
   
   //panneau qui contiendra les boutons dans exemple 3 (init3)
   private JPanel panneauBoutons;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple9FlowLayout() {
      
      //NOTE : decommenter un seul des init pour visualiser l'exemple
      
      //avec 3 boutons centrés
      init1(); 
      
      //avec 6 boutons, alignés a gauche
      //init2();
      
      //avec JFrame (layout manager null) et panneau (flowLayout) 
      //qui contient 3 boutons centrés dans le panneau
      //init3();
   }
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * FlowLayout contenant 3 boutons, centrés.
    */
   private void init1() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple FlowLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //assigner le gestionnaire de disposition FlowLayout
      fenetre.setLayout(new FlowLayout());
      
      //NOTE : Par defaut, les composants sont centrés mais on peut changer 
      //l'alignement. Par exemple : 
      //((FlowLayout)fenetre.getContentPane().getLayout()).setAlignment(FlowLayout.RIGHT);
      //((FlowLayout)fenetre.getContentPane().getLayout()).setAlignment(FlowLayout.LEFT);
      
      
      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("Bouton 1");
      boutons[1] = new JButton("Super long Bouton 2");
      boutons[2] = new JButton("Bouton 3");
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(boutons[0]);
      fenetre.getContentPane().add(boutons[1]);
      fenetre.getContentPane().add(boutons[2]);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * FlowLayout contenant 6 boutons, alignés à gauche.
    */
   private void init2() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple FlowLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //assigner le gestionnaire de disposition FlowLayout
      fenetre.setLayout(new FlowLayout());
      
      //Aligner les composants (ici des boutons) a gauche 
      ((FlowLayout)fenetre.getContentPane().getLayout()).setAlignment(FlowLayout.LEFT);
      
      
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
    * FlowLayout contenant un panneau dans lequel se trouve 3 boutons centrés
    */
   private void init3() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple FlowLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //enlever le gestionnaire de disposition pour le JFrame. 
      //On pourra alors positionner explicitement (x,y) le panneau 
      //se trouvant dans ce JFrame
      fenetre.setLayout(null);
      
      //Alignement des boutons par defaut = centré
      
      
      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("Bouton 1");
      boutons[1] = new JButton("Bouton 2");
      boutons[2] = new JButton("Bouton 3");
      
      
      /*********************************************************
       * INIT PANNEAU BOUTONS
       *********************************************************/
      
      //Par defaut, un JPanel possede un FlowLayout comme gestionnaire
      //de disposition. Donc, inutile de le signaler explicitement.
      panneauBoutons = new JPanel();
      
      //positionner le panneau dans le bas du JFrame
      panneauBoutons.setBounds(20,
              fenetre.getHeight() - 80, 
              fenetre.getWidth() - 40,
              40);
      
      //assigner une couleur (noir) au panneau pour pouvoir mieux le visualiser
      //dans cet exemple (mais souvent, on ne colore pas le JPanel qui est, par 
      //defaut, de la meme couleur que le JFrame)
      panneauBoutons.setBackground(Color.BLACK);
      
      //espace entre les boutons = 40
      ((FlowLayout)panneauBoutons.getLayout()).setHgap(40);
      
      //NOTE : Si on avait plusieurs lignes de boutons, on pourrait aussi 
      //modifier l'espace entre les lignes (vgap). Par exemple :
      //((FlowLayout)panneauBoutons.getLayout()).setVgap(35);
      
      //ajouter les boutons au panneau
      panneauBoutons.add(boutons[0]);
      panneauBoutons.add(boutons[1]);
      panneauBoutons.add(boutons[2]);
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      
      //ajouter le panneau au JFrame
      fenetre.getContentPane().add(panneauBoutons);
      
      //NOTE : Evidemment, on peut aligner differents composants avec un 
      //FlowLayout, pas seulement des boutons. Pour les champs texte (JTextField), 
      //donner une dimension (setSize).
      
      //afficher la fenetre
      fenetre.setVisible(true);
      
   }

   
   public static void main (String [] args)  {
      
      new Exemple9FlowLayout();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple9FlowLayout();
            }
      });
      */
   }
   
}



