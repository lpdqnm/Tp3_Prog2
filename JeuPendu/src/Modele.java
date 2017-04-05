
package composantsGraphiquesEtLayout;

import javax.swing.JFrame;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Modele {
   
   /************************************
    * CONSTANTES DE CLASSE
    ************************************/

   
   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Modele() {
      init(); 
   }
   
   /**
    * 
    */
   private void init() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec un bouton");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      fenetre.setLayout(null);
      
      /*********************************************************
       * INIT...
       *********************************************************/
      
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/

      fenetre.setVisible(true);

   }
   
   
   public static void main (String [] args)  {
      //Exécution d'un thread, MAJ du GUI
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Modele();
            }
      });
   }
   
}
