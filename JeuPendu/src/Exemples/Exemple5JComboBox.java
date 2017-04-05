
package Exemples;

import javax.swing.JFrame;
import javax.swing.JComboBox;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple5JComboBox {
   
   /************************************
    * CONSTANTES DE CLASSE
    ************************************/
   
   //hauteur est largeur des composants
   public final static int LARG = 280;
   public final static int HAUT = 30;
   
   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   //listes deroulantes
   private JComboBox liste1;
   private JComboBox liste2;
   
   //On va ajouter les elements de ce tableau dans une liste deroulante (voir init() )
   private final static Point [] TAB = { new Point(19, 23), new Point(12, 8), new Point(34, 55)};
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple5JComboBox() {
      init(); 
   }
   
   /**
    * Initialise une fenetre avec deux listes deroulantes.
    */
   private void init() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec une liste déroulante");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      fenetre.setLayout(null);
      
      /*********************************************************
       * INIT. DES LISTES DEROULANTES
       *********************************************************/
      
      liste1 = new JComboBox();
      liste1.setBounds(100, 50, LARG, HAUT);
      
      //Ajout de contenu (10 elements) dans la liste
      
      //Ajout d'un element vide
      liste1.addItem(""); //indice 0 dans la liste
      
      //Ajout de 10 autres elements un a la suite de l'autre
      for (int i = 2 ; i <= 6 ; i++) {
         liste1.addItem("Item " + i + " dans la liste");
      }
      
      //Ajout d'un element en position 3 dans la liste
      liste1.insertItemAt("Nouvel element insere en position 3", 3);
      
      //selectionner un element particulier dans la liste
      //par defaut, c'est le premier element dans la liste qui 
      //est selectionner.
      //selectionner l'element a l'indice 3
      liste1.setSelectedIndex(3);
      
      

      //NOTE : on peut aussi demander la selection d'un element dans la liste
      //Exemple : 
      //liste.setSelectedItem("Nouvel element insere en position 4");
      
      /*****************************************************************/
      
      //NOTE : Ci-dessus on insere des String dans la liste mais on peut y inserer
      //tout type d'elements (type object).  Ce qui sera affiche dans la liste
      //est la chaine retournee par la methode toString appelee sur cet objet.
      
      //Exemple d'une liste d'objets de type Point (cette classe est definie 
      //a la suite de celle-ci).
      liste2 = new JComboBox(TAB);
      liste2.setBounds(liste1.getX(), 
              liste1.getY() + liste1.getHeight() + 100, 
              LARG, HAUT);
      
      //Ajout de 5 points dans la liste2
      liste2.addItem(new Point(1,2));
      liste2.addItem(new Point(6,4));
      liste2.addItem(new Point(0,10));
      liste2.addItem(new Point(9,3));
      liste2.addItem(new Point(3,8));
      
         
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(liste1);
      fenetre.getContentPane().add(liste2);
      
      fenetre.setVisible(true);
   }
   
   
   public static void main (String [] args)  {
      
      new Exemple5JComboBox();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple5JComboBox();
            }
      });
      */
   }
   
}

/**
 * Modelise un point dans un systeme de coordonnees a deux dimensions (x et y).
 * @author Melanie Lord
 */
class Point {
   private int x = 0;
   private int y = 0;
   
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   @Override
   public String toString() {
      return "Point de coordonnées ( " + x + ", " + y + " )"; 
   }
}

