
package Exemples;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

/**
 * BorderLayout permet la disposition des composants dans 5 regions différentes : 
 * nord, sud, est, ouest et centre. Chaque region ne peut contenir qu'un 
 * seul composant et est identifiee par une constante correspondante : 
 * NORTH, SOUTH, EAST, WEST, et CENTER.
 * 
 * Lors de l'ajout d'un composant dans un conteneur ayant ce gestionnaire de 
 * disposition, il faut utiliser l'une de ces 5 constantes.
 * 
 * Exemple : 
 * 
 * Panel p = new Panel();
 * p.setLayout(new BorderLayout());
 * p.add(new Button("OK"), BorderLayout.SOUTH);
 * 
 * Si aucune region n'est mentionnee lors de l'ajout d'un composant, celui-ci sera
 * ajoute au centre, par defaut.
 * 
 *  Panel p2 = new Panel();
 *  p2.setLayout(new BorderLayout());
 *  p2.add(new TextArea());  // Meme chose que p.add(new TextArea(), BorderLayout.CENTER);
 *
 * REF: traduction de la Javadoc de BorderLayout (JavaSE 6)
 * 
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple8BorderLayout {
   
   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   //tableau de 5 boutons
   private JButton[] boutons = new JButton[5];
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple8BorderLayout() {
      
      //NOTE : decommenter un seul des init pour visualiser l'exemple
      
      init1(); 
      
      //avec espace entre les regions
      //init2();
   }
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * BorderLayout et contenant 5 boutons (1 dans chaque region).
    */
   private void init1() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple BorderLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //assigner le gestionnaire de disposition BorderLayout
      fenetre.setLayout(new BorderLayout());
      
      //NOTE : en fait, BorderLayout est le gestionnaire par defaut
      //d'un JFrame, on pourrait alors ne pas mettre cette instruction.
      //Par contre, pour assigner ce gestionnaire a un JPanel, il 
      //faut le specifier explicitement car ce gesionnaire n'est pas celui
      //par defaut pour un JPanel.
      
      
      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("NORD");
      boutons[1] = new JButton("CENTRE");
      boutons[2] = new JButton("SUD");
      boutons[3] = new JButton("EST");
      boutons[4] = new JButton("OUEST");
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(boutons[0], BorderLayout.NORTH);
      fenetre.getContentPane().add(boutons[1], BorderLayout.CENTER);
      fenetre.getContentPane().add(boutons[2], BorderLayout.SOUTH);
      fenetre.getContentPane().add(boutons[3], BorderLayout.EAST);
      fenetre.getContentPane().add(boutons[4], BorderLayout.WEST);
      
      fenetre.setVisible(true);
   }
   
   
   /**
    * Initialisation d'une fenetre avec un gestionnaire de disposition 
    * BorderLayout et contenant 5 boutons (1 dans chaque region). Comme
    * dans init1, mais ici, les 5 regions sont separees horizontalement et
    * verticalement par des espace de 10 pixels.
    */
   private void init2() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple BorderLayout");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //possibilite de modifier la taille de la fenetre
      fenetre.setResizable(true);
      
      //assigner le gestionnaire de disposition BorderLayout
      //hgap = 20, vgap = 50  (espace entre les regions)
      fenetre.setLayout(new BorderLayout(20, 50));
      
      //Note : les methodes setHgap et setVgap servent a modifier l'espace
      //entre les regions. Exemple : 
      //((BorderLayout)fenetre.getContentPane().getLayout()).setVgap(5);
      
      /*********************************************************
       * INIT BOUTONS
       *********************************************************/
      boutons[0] = new JButton("NORD");
      boutons[1] = new JButton("CENTRE");
      boutons[2] = new JButton("SUD");
      boutons[3] = new JButton("EST");
      boutons[4] = new JButton("OUEST");
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(boutons[0], BorderLayout.NORTH);
      fenetre.getContentPane().add(boutons[1], BorderLayout.CENTER);
      fenetre.getContentPane().add(boutons[2], BorderLayout.SOUTH);
      fenetre.getContentPane().add(boutons[3], BorderLayout.EAST);
      fenetre.getContentPane().add(boutons[4], BorderLayout.WEST);
      
      fenetre.setVisible(true);
   }
   
   //NOTE: On peut aussi assigner un gestionnaire de disposition a un JPanel
   
   
   public static void main (String [] args)  {
      
      new Exemple8BorderLayout();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple8BorderLayout();
            }
      });
      */
   }
   
}


