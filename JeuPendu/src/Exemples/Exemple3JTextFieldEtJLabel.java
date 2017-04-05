
package Exemples;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple3JTextFieldEtJLabel {
   
   /************************************
    * CONSTANTES DE CLASSE
    ************************************/
   //hauteur est largeur des composants
   public final static int LARG = 150;
   public final static int HAUT = 30;
   
   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   
   //fenetre principale et conteneur pour les etiquettes et champs textes
   private JFrame fenetre; 
   
   //champs texte de etiquettes
   private JTextField champNom;
   private JTextField champPrenom;
   private JTextField champAge;
   private JLabel etiquetteNom;
   private JLabel etiquettePrenom;
   private JLabel etiquetteAge;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple3JTextFieldEtJLabel() {
      init(); 
   }
   
   
   /**
    * Initialise une fenetre 3 etiquettes et 3 champs textes.
    */
   private void init() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec champs texte et etiquettes");
      fenetre.setBounds(400, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      fenetre.setLayout(null);
      
      /*********************************************************
       * INIT ETIQUETTES ET CHAMPS TEXTES (JTextField et JLabel)
       *********************************************************/
      
      //creation et initialisation des proprietes de l'etiquette prenom
      etiquettePrenom = new JLabel("Prenom");
      etiquettePrenom.setBounds(20, 50, LARG, HAUT);
      
      //pour aligner le texte a droite (aligner a gauche par defaut) et au bas
      //du JLabel
      etiquettePrenom.setHorizontalAlignment(SwingConstants.RIGHT);
      etiquettePrenom.setVerticalAlignment(SwingConstants.BOTTOM);

      //modifier couleur du fond : noir
      etiquettePrenom.setBackground(Color.BLACK);
      etiquettePrenom.setOpaque(true);  //rendre l'etiquette opaque pour qu'on
                                        //voit la couleur de fond
      //modifier couleur du texte : blanc
      etiquettePrenom.setForeground(Color.WHITE);
      
      /******************************************************************/

      //creation et initialisation des proprietes du champ texte prenom
      //Le champPrenom contiendra le texte donne en parametre. Pas obligatoire.
      champPrenom = new JTextField("<champ actif editable>");
      champPrenom.setBounds(
              etiquettePrenom.getX() + etiquettePrenom.getWidth() + 10, //x
              etiquettePrenom.getY(),                                   //y   
              LARG * 2, HAUT);                                          //larg, haut
      
      //mettre le focus sur le champPrenom
      champPrenom.requestFocusInWindow();
      
      /******************************************************************/
      
      //creation et initialisation des proprietes de l'etiquette nom
      etiquetteNom = new JLabel("Nom");
      etiquetteNom.setBounds(etiquettePrenom.getX(),                    //x
              etiquettePrenom.getY() + etiquettePrenom.getHeight() + 20 //y
              ,LARG, HAUT);                                             //larg, haut
      
      //pour aligner le texte a droite, en haut
      etiquetteNom.setHorizontalAlignment(SwingConstants.CENTER); 
      etiquetteNom.setVerticalAlignment(SwingConstants.TOP);
      
      //NOTE : valeurs possibles d'alignement comme parametre de la methode
      //setHorizontalAlignment(...) :
      //- LEFT     : alignement a gauche
      //- CENTER   : alignement centré
      //- RIGHT    : alignement a droite
      
      //NOTE : valeurs possibles d'alignement comme parametre de la methode
      //setVerticalAlignment(...) :
      //- CENTER    : alignement au centre (par defaut)
      //- TOP       : alignement en haut du JLabel
      //- BOTTOM    : alignement au bas du JLabel


      //couleur du fond : noir
      etiquetteNom.setBackground(Color.ORANGE);
      etiquetteNom.setOpaque(true);  //rendre l'etiquette opaque pour qu'on
                                     //voit la couleur de fond
      
      //couleur du texte : noir par defaut
      
      /******************************************************************/
      
      //creation et initialisation des proprietes du champ texte nom
      champNom = new JTextField("Champ desactive");
      champNom.setBounds(
              etiquetteNom.getX() + etiquetteNom.getWidth() + 10,    //x
              etiquetteNom.getY(),                                   //y   
              LARG * 2, HAUT);                                           //larg, haut
      
      //Desactiver le champ texte 
      champNom.setEnabled(false);
      
      /******************************************************************/
      
      //creation et initialisation des proprietes de l'etiquette age
      etiquetteAge = new JLabel("Age");
      etiquetteAge.setBounds(etiquetteNom.getX(),                    //x
              etiquetteNom.getY() + etiquetteNom.getHeight() + 20,   //y 
              LARG, HAUT);                                           //larg, haut
      
      //alignement horizontal et vertical par defaut : gauche centre

      //couleur du fond : transparent par defaut
      
      //couleur du texte : noir par defaut
      
      /******************************************************************/

      //creation et initialisation des proprietes du champ texte Age
      champAge= new JTextField("Champ actif, mais non editable");
      champAge.setBounds(
              etiquetteAge.getX() + etiquetteAge.getWidth() + 10, //x
              etiquetteAge.getY(),                                //y   
              LARG * 2, HAUT);                                    //larg, haut
      
      //rendre le champ age non editable
      champAge.setEditable(false);
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(etiquettePrenom);
      fenetre.getContentPane().add(champPrenom);
      fenetre.getContentPane().add(etiquetteNom);
      fenetre.getContentPane().add(champNom);
      fenetre.getContentPane().add(etiquetteAge);
      fenetre.getContentPane().add(champAge);
      
      //afficher la fenetre
      fenetre.setVisible(true);
   }
   
   public static void main (String [] args)  {
      
      new Exemple3JTextFieldEtJLabel();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple3JTextFieldEtJLabel();
            }
      });
      */
   }
}
