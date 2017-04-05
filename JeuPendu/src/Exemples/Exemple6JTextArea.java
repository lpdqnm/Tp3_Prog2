
package Exemples;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple6JTextArea {
   
   /************************************
    * CONSTANTES DE CLASSE
    ************************************/
   //hauteur est largeur des composants
   public final static int LARG = 200;
   public final static int HAUT = 230;
   
   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   //zone de texte
   private JTextArea zoneTexte1;
   private JTextArea zoneTexte2;
   
   //pour assigner des barres de defilement a zoneTexte2
   private JScrollPane defilZone2;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple6JTextArea() {
      init(); 
   }
   
   /**
    * Initialisation d'une fenetre avec deux zones de texte.
    */
   private void init() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec deux zones de texte");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      fenetre.setLayout(null);
      
      /*********************************************************
       * INIT ZONE DE TEXTE
       *********************************************************/
      
      //Creation et initialisation de zoneText1 - AVEC LINE WRAP
      zoneTexte1 = new JTextArea();
      zoneTexte1.setBounds(35, 20, LARG, HAUT);
      
      //Ajout d'une bordure noire, large de 1 pixel, autour de la zone de texte
      zoneTexte1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
      
      //Notes : voir les autres possibilites de bordures dans BorderFactory
      
      //passe a la ligne suivante s'il n'y a plus de place sur la ligne courante
      zoneTexte1.setLineWrap(true);
      //retour de ligne sans couper les mots
      zoneTexte1.setWrapStyleWord(true); 
      
      //editable par defaut
      
      /***********************************************************/
      
      //Creation et initialisation de zoneText2 - AVEC BARRES DE DEFILEMENT
      //                                          HORIZIZONTALE ET VERTICALE
      zoneTexte2 = new JTextArea();
      
      //couleur du fond : gris
      zoneTexte2.setBackground(Color.GRAY);
      
      //couleur du texte : jaune
      zoneTexte2.setForeground(Color.YELLOW);
      
      //Creer un JScrollPane pour le JTextArea zoneTexte2 : pour avoir des 
      //barres de défilement.
      defilZone2 = new JScrollPane(zoneTexte2);
      defilZone2.setBounds(zoneTexte1.getX() + zoneTexte1.getWidth() + 30, 
              zoneTexte1.getY(), 
              LARG, HAUT);
      
      defilZone2.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
      
      //Barre de defilement horizontale : toujours presente
      defilZone2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      
      //Note : autres options pour la barre de defilement horizontal
      //JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED - barre horiz. au besoin seulement
      //JScrollPane.HORIZONTAL_SCROLLBAR_NEVER - jamais de barre horiz.        
      
      //Barre de defilement verticale : au besoin seulement
      defilZone2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      
      //Note : autres options pour la barre de defilement horizontal
      //JScrollPane.VERTICAL_SCROLLBAR_ALWAYS - barre verticale. toujours presente
      //JScrollPane.VERTICAL_SCROLLBAR_NEVER //- jamais de barre verticale.
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(zoneTexte1);
      
      //C'est le JScrollPane qu'on ajoute au JFrame
      fenetre.getContentPane().add(defilZone2);
      
      //afficher la fenetre
      fenetre.setVisible(true);
      
      //NOTES : des methodes comme setVisible, setEditable, setEnabled sont aussi 
      //disponibles pour les JTextArea.
   }
   
   
   public static void main (String [] args)  {
      
      new Exemple6JTextArea();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple6JTextArea();
            }
      });
      */
   }
   
}


