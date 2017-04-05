
package Exemples;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

/**
 * @author Melanie Lord
 * @version novembre 2013
 */
public class Exemple4JRadioButtonEtJCheckBox {
   
   /************************************
    * CONSTANTES DE CLASSE
    ************************************/
   //hauteur est largeur des composants
   public final static int LARG = 130;
   public final static int HAUT = 30;
   
   /************************************
    * VARIABLES D'INSTANCES
    ************************************/
   
   //fenetre principale et conteneur pour boutons radio et case a cocher
   private JFrame fenetre; 
   
   //boutons radio et cases a cocher
   private JRadioButton btnRadio1;
   private JRadioButton btnRadio2;
   private JRadioButton btnRadio3;
   private JCheckBox boiteACocher1;
   private JCheckBox boiteACocher2;
   private JCheckBox boiteACocher3;
   
   //groupe pour les boutons radio
   private ButtonGroup groupeBtnRadio;
   
   /**
    * Constructeur qui initialise tous les composants 
    * graphiques.
    */
   public Exemple4JRadioButtonEtJCheckBox() {
      init(); 
   }
   
   /**
    * Initialise une fenetre avec 3 boutons radio et 3 case a cocher
    */
   private void init() {
      
      /************************************
       * INIT FENETRE PRINCIPALE (JFRAME)
       ************************************/
      
      //creation et initialisation des proprietes de la fenetre principale
      fenetre = new JFrame("Exemple avec boutons radio et boîtes à cocher");
      fenetre.setBounds(500, 300, 500, 300);
      fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      fenetre.setResizable(false);
      fenetre.setLayout(null);
      
      /*********************************************************
       * INIT BOUTONS RADIO
       *********************************************************/
      
      groupeBtnRadio = new ButtonGroup();
      
      btnRadio1 = new JRadioButton();
      btnRadio1.setText("Option 1");
      btnRadio1.setBounds(50, 50, LARG, HAUT); 
      
      //Selectionne le bouton btnRadio1
      btnRadio1.setSelected(true);
      
      /***********************************************************/
      
      btnRadio2 = new JRadioButton();
      btnRadio2.setText("Option 2");
      btnRadio2.setBounds(btnRadio1.getX() + btnRadio1.getWidth(), 
              btnRadio1.getY(), LARG, HAUT); 
      
      /***********************************************************/
      
      btnRadio3 = new JRadioButton();
      btnRadio3.setText("Option 3");
      btnRadio3.setBounds(btnRadio2.getX() + btnRadio2.getWidth(), 
              btnRadio2.getY(), LARG, HAUT); 
      
      /***********************************************************/
      
      //ajouter les boutons radio au meme groupe pour qu'un seul 
      //ne puisse etre selectionne a la fois
      groupeBtnRadio.add(btnRadio1);
      groupeBtnRadio.add(btnRadio2);
      groupeBtnRadio.add(btnRadio3);
      
      /*********************************************************
       * INIT CASES A COCHER
       *********************************************************/
      
      boiteACocher1 = new JCheckBox("Ceci est l'option 1");
      boiteACocher1.setBounds(btnRadio1.getX(),
              btnRadio2.getY() + btnRadio2.getHeight() + 30,
              LARG * 2, HAUT);
      
      
      /***********************************************************/
      
      boiteACocher2 = new JCheckBox("Ceci est l'option 2");
      boiteACocher2.setBounds(boiteACocher1.getX(),
              boiteACocher1.getY() + boiteACocher1.getHeight(),
              LARG * 2, HAUT);
      
      /***********************************************************/
      
      boiteACocher3 = new JCheckBox("Ceci est l'option 3");
      boiteACocher3.setBounds(boiteACocher2.getX(),
              boiteACocher2.getY() + boiteACocher2.getHeight(),
              LARG * 2, HAUT);
      
      /*************************************************
       * AJOUT DES COMPOSANTS AU CONTENT PANE DU JFRAME
       *************************************************/
      fenetre.getContentPane().add(btnRadio1);
      fenetre.getContentPane().add(btnRadio2);
      fenetre.getContentPane().add(btnRadio3);
      fenetre.getContentPane().add(boiteACocher1);
      fenetre.getContentPane().add(boiteACocher2);
      fenetre.getContentPane().add(boiteACocher3);
      
      //afficher la fenetre
      fenetre.setVisible(true);
      
      
      //NOTE : les methodes setVisible, setEnabled, setBackground, 
      //       setForeground, setText que nous avons vues peuvent aussi 
      //       s'appliquer sur les JRadioButton et JCheckBox (entre autres).

   }
   
   
   public static void main (String [] args)  {
      
      new Exemple4JRadioButtonEtJCheckBox();
      
      //OU Exécution d'un thread, MAJ du GUI
      /*
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exemple4JRadioButtonEtJCheckBox();
            }
      });
      */
   }
   
}


