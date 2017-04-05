
package Exemples;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple1JFrame {
   //constantes de classe
   public final static int LARG_FENETRE = 400;
   public final static int HAUT_FENETRE = 300;
   
   //variables d'instance
   
   //fenetre principal
   private JFrame fenetre;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple1JFrame() {
      
      //NOTE : decommenter un seul des init pour visualiser l'exemple
      
      //init1(); 
      init2();
   }
   
   /**
    * Initialisation d'un JFrame simple, sans titre, 
    * de taille 400 x 300 et redimensionnable
    */
   private void init1() {
      //création d'un JFrame invisible (par défaut)
      fenetre = new JFrame();
      
      //NOTE : on peut toujours rendre un composant graphique visible ou 
      //invisible en utilisant composant.setVisible(true) ou 
      //composant.setVisible(false);
      
      //dimensionner le JFrame (largeur, hauteur)
      fenetre.setSize(LARG_FENETRE, HAUT_FENETRE);
      
      //permet de terminer l'application (le processus) lorsqu'on
      //clique sur le x de la fenetre
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   
   }
   
   /**
    * Initialisation d'un JFrame non redimensionnable avec titre, 
    * de taille 400 x 300, avec fond noir et positionne a peu pres 
    * dans le mileu de l'ecran.
    */
   private void init2() {
      //création d'un JFrame invisible (par défaut)
      fenetre = new JFrame("Titre de ma fenetre");
      
      //NOTE : on pourrait construire un JFrame sans titre, comme dans 
      //init1 et appeler ensuite la mehtode setTitre :
      //fenetre.setTitre("Titre de ma fenetre");
      
      //dimensionner le JFrame (largeur, hauteur)
      fenetre.setSize(LARG_FENETRE, HAUT_FENETRE);
      
      //positionnement du JFrame a peu pres dans le milieu de l'ecran
      //avec coordonnees x et y (les coordonnees 0,0 correspondent au coin
      //superieur gauche de l'ecran)
      fenetre.setLocation(500, 300); //x = 500, y = 300
      
      //NOTE : Les opérations setSize et setLocation peuvent se faire avec
      //un seule methode : setBounds(x, y, LARGEUR, HAUTEUR)
      //fenetre.setBounds(500, 300, LARG_FENETRE, HAUT_FENETRE);
      
      //NOTE pour positionner le JFrame dans l'ecran, vous
      //pouvez calculer la postion x, y du JFrame en considerant la taille 
      //du JFrame et la taille de l'ecran obtenue comme ceci :
      /*
      double largeurEcran = java.awt.Toolkit.getDefaultToolkit().
              getScreenSize().getWidth();
      
      double hauteurEcran = java.awt.Toolkit.getDefaultToolkit().
              getScreenSize().getHeight();
      */
      
      //Colorer le fond du JFrame en noir
      fenetre.getContentPane().setBackground(Color.BLACK);
      
      //NOTE : d'autres couleurs sont prédéfinies (constantes) dans la 
      //classe java.awt.Color comme :
      //Color.BLUE;
      //Color.GREEN;
      //Color.ORANGE;
      //etc...
      
      //permet de terminer l'application (le processus) lorsqu'on
      //clique sur le x de la fenetre
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //empeche la fenetre d'etre redimensionnee par l'utilisateur
      fenetre.setResizable(false);
      
      //afficher la fenetre 
      fenetre.setVisible(true);
      
   }
   
   
   public static void main (String [] args)  {
      
      new Exemple1JFrame();
      
      // OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple1JFrame();
            }
      });
      */
   }
   
}
