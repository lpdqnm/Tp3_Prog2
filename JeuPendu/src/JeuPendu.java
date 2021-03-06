
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * INF2120
 * 
 * Classe java avec interface graphique représentant le jeu du pendu.
 *
 * @author Maxime Gagnon et Léopold Aurélien Quenum et Maxime Gagnon
 * @codePermanent QUEL16107105 GAGM28089106 
 * @courriel gagnon.maxime.5@courrier.uqam.ca, quenum.leopold_Aurelien@courrier.uqam.ca
 * @version 18 avril 2017
 */

public class JeuPendu extends WindowAdapter implements ActionListener {

    //CONSTANTES
    ////////////
    public static final String ALPHABET
            = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final Integer[] TAB_DIFFICULTE = new Integer[]{1, 2, 3};
    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 510;
    public static final Font FONT_TITRE = new Font("Courier", Font.BOLD, 24);
    public static final Font FONT_BOUTON = new Font("Courier", Font.PLAIN, 20);    
    public static final Font FONT_PENDU = new Font("Courier New",
            Font.PLAIN, 16);
    public static final Font FONT_TITRES_NIVEAUX = new Font("Arial",
            Font.BOLD, 13);
    public static final Font FONT_LABELS_NIVEAUX = new Font("Courier New",
            Font.PLAIN, 12);
    public static final Font FONT_SAISIE_LETTRE = new Font("Courier New",
            Font.BOLD, 24);
    public static final Font FONT_MOT_CACHE = new Font("Courier New",
            Font.BOLD, 20);
    public static final Font FONT_SCORE = new Font("Courier", Font.BOLD, 12);
   
    
    public static final String TRAIT = "_______________________________________"
            + "____________________________";
    
//Contantes représentant les différentes étapes d'affichage du pendu  
    public static final String PENDU_ZERO_ERREUR = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |                  " 
            + "\n               |                  "
            + "\n               |                  " 
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";

    public static final String PENDU_UNE_ERREUR = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |        o         " 
            + "\n               |                  "
            + "\n               |                  " 
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";

    public static final String PENDU_DEUX_ERREURS = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |        o         " 
            + "\n               |        |         "
            + "\n               |                  "
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";
    public static final String PENDU_TROIS_ERREURS = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |        o         " 
            + "\n               |       /|         "
            + "\n               |                  " 
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";
    public static final String PENDU_QUATRE_ERREURS = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |        o         " 
            + "\n               |       /|\\        "
            + "\n               |                  " 
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";
    public static final String PENDU_CINQ_ERREURS = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |        o         " 
            + "\n               |       /|\\        "
            + "\n               |       /          " 
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";
    public static final String PENDU_SIX_ERREURS = 
            "              ____________    "
            + "\n               |        |     " 
            + "\n               |        |     "
            + "\n               |        o         " 
            + "\n               |       /|\\        "
            + "\n               |       / \\         " 
            + "\n               |                  "
            + "\n             __|__________   " 
            + "\n          __|_____________|__";

    //Constantes pour le fichier des statistiques
    public static final String NIV = "Niveau ";
    public static final String FIC_STATS = "statistiques.txt";
    public static final DecimalFormat DEC_FORMAT = new DecimalFormat("0.0");
    
    public static final String TIRET_BAS_ESP = "_ ";
    
    //Entiers pour les indices des tableau compteurNiv1,2,3 et partiesNiv1,2,3
    public static final int PARTIES = 0;
    public static final int JOUEES = PARTIES;
    public static final int PARTIES_GAG = 1;
    public static final int SCORE_TOT = 2;
    public static final int SCORE_MY = SCORE_TOT;
    
    //Chaines pour les JOptionPane
    public static final String MSG_UNE_LETTRE = "Vous devez entrer une lettre"
            +" non accentuée !";
    public static final String MSG_LETTRE_DEJA = "Cette lettre est déjà"
                    + " décourverte !";
    public static final String MSG_GAGNE = "BRAVO ! Vous avez gagné la partie.";
    public static final String MSG_PERDU = "Oups! Vous êtes mort.";
    public static final String MOT_CACHE = "\n  Mot caché  :";
    public static final String VOTRE_SCORE = "\n  Votre score : ";
    public static final String AUTRE_JEU = "\n\nVoulez-vous jouer une "
            + "autre partie ?";
    public static final String TITRE_GAGNE = "PARTIE GAGNÉE";
    public static final String TITRE_PERDU = "PARTIE PERDUE";

    //VARIABLES D'INSTANCE
    //////////////////////
    private int score = 0; 
    private int choixCouleurInterface = 0;
    private int choixNiveauDifficulte = 0;
    private String motTire = "";//contiendra le mot tire pour chaques partie 
    private int perdu;
    private int gagne;

    //Fenêtre principale
    private JFrame fenetre;

    //Vue 1:
    private JPanel panelVue1;
    private JLabel titre;
    private JButton boutonJouer;
    private JButton boutonStats;
    
    //Vue 2:
    private JPanel panelVue2;
    private JPanel panneauOptions;
    private JLabel difficulte;
    private JComboBox listeDifficulte;
    private JLabel couleurInterface;
    private JRadioButton interfaceClaire;
    private JRadioButton interfaceSombre;
    private ButtonGroup groupeCouleur;
    private JTextArea pendu;
    private JLabel labelScore;
    private JTextField affichageScore;
    private JTextField ligneSeparation;
    private JLabel labelMotCache;
    private JTextField motCache;
    private JLabel labelLettre;
    private JTextField lettre;
    private JButton boutonSoumettre;
    private JButton boutonQuitter;
    
    //Vue 3:
    private JPanel panelVue3;
    private JLabel titreStats;
    private JLabel titreStatsNiv1;
    private JPanel panneauStatsNiv1;
    private JLabel labelPartiesJoueesNiv1;
    private JLabel labelPartiesGagneesNiv1;
    private JLabel labelScoreMoyenNiv1;
    private JLabel titreStatsNiv2;
    private JPanel panneauStatsNiv2;
    private JLabel labelPartiesJoueesNiv2;
    private JLabel labelPartiesGagneesNiv2;
    private JLabel labelScoreMoyenNiv2;
    private JLabel titreStatsNiv3;
    private JPanel panneauStatsNiv3;
    private JLabel labelPartiesJoueesNiv3;
    private JLabel labelPartiesGagneesNiv3;
    private JLabel labelScoreMoyenNiv3;
    private JTextField champPartiesJoueesNiv1;
    private JTextField champPartiesGagneesNiv1;
    private JTextField champScoreMoyenNiv1;
    private JTextField champPartiesJoueesNiv2;
    private JTextField champPartiesGagneesNiv2;
    private JTextField champScoreMoyenNiv2;
    private JTextField champPartiesJoueesNiv3;
    private JTextField champPartiesGagneesNiv3;
    private JTextField champScoreMoyenNiv3;
    private JButton boutonFermerStats;
    
    //Tableaux des statistiques
    private static String[] partiesNiv1 = {"0", "-", "-"};
    private static String[] partiesNiv2 = {"0", "-", "-"};
    private static String[] partiesNiv3 = {"0", "-", "-"};
    
    //Tableau comptant  les parties jouées, gagnées et les scores globaux
    private int[] compteurNiv1 = new int[3];
    private int[] compteurNiv2 = new int[3];
    private int[] compteurNiv3 = new int[3];

    
    
    
    //Code du programme principal

    /**
     *Constructeur principal sans arguments qui initialise la fenêtre principale
     * avant d'afficher la vue 1.
     */
    
    public JeuPendu() {
        initFenetre();
    }
    
    /**
     *Initialise la fenêtre principale.
     */
    private void initFenetre() {

        fenetre = new JFrame("JEU DU PENDU");
        fenetre.setBounds(700, 250, LARGEUR, HAUTEUR);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.setLayout(null);
        fenetre.getContentPane().setBackground(java.awt.Color.WHITE);

        fenetre.setVisible(true);
        fenetre.addWindowListener(this);
        initVue1();

    }
    
    /**
     *Initialisation du conteneur de la vue 1 contenant le titre du programme,
     * un bouton «jouer» et un bouton «Statistiques».
     */
    private void initVue1() {
        cacherPanneauxVue1();

        panelVue1 = new JPanel(null);
        panelVue1.setBounds(0, 0, LARGEUR, HAUTEUR);
        panelVue1.setBackground(java.awt.Color.WHITE);

        initElementsVue1();

        ajoutElementsVue1();
        
        boutonJouer.addActionListener(this);
        boutonStats.addActionListener(this);
    }
    /**
     *Initialise les éléments contenus dans le conteneur de la vue 1, soit 
     * le titre du programme, un bouton «jouer» et un bouton «Statistiques».
     */
    private void initElementsVue1() {
        titre = new JLabel("Le jeu du pendu");
        titre.setBounds(0, 0, LARGEUR, HAUTEUR / 3);
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        titre.setFont(FONT_TITRE);

        boutonJouer = new JButton("Jouer");
        boutonJouer.setBounds(titre.getX() + 175, titre.getY() + 175, 150, 40);
        boutonJouer.setFont(FONT_BOUTON);
        boutonJouer.setHorizontalAlignment(SwingConstants.CENTER);

        boutonStats = new JButton("Statistiques");
        boutonStats.setBounds(boutonJouer.getX(), boutonJouer.getY() + 80,
                boutonJouer.getWidth(), boutonJouer.getHeight());
        boutonStats.setFont(FONT_BOUTON);
        boutonStats.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    /**
     *Ajoute  le titre du programme, un bouton «jouer» et un bouton 
     * «Statistiques» au conteneur de la vue 1.
     */
    private void ajoutElementsVue1() {
        panelVue1.add(titre);
        panelVue1.add(boutonJouer);
        panelVue1.add(boutonStats);
        fenetre.getContentPane().add(panelVue1);
        panelVue1.setVisible(true);
    }

    /**
     *Cache les autres vues en vue de l'affichage de la vue 1.
     */
    private void cacherPanneauxVue1() {
        if (panelVue2 != null) {
            panelVue2.setVisible(false);
        }
        if (panelVue3 != null) {
            panelVue3.setVisible(false);
        }
    }
    
    /**
     * Initialise le panneau de la vue2 représentant le jeu du pendu.
     */
    private void initVue2() {

        cacherPanneauxVue2();

        panelVue2 = new JPanel(null);
        panelVue2.setBounds(0, 0, LARGEUR, HAUTEUR);
        panelVue2.setBackground(java.awt.Color.WHITE);

        initElementsPartieSuperieureVue2();

        initElementsPartieInferieureVue2();

        ajoutElementsVue2();

        attributionActionListenersVue2();

        if (interfaceSombre.isSelected()) {
            initVue2Sombre();

        } else {
            initVue2Claire();
        }

        panelVue2.setVisible(true);

    }
    
    /**
     * Initialise les éléments contenus dans la partie supérieure du conteneur 
     * de la vue 2 , soit le panneau d'options et l'affichage du pendu.
     * 
     */
    private void initElementsPartieSuperieureVue2() {
        panneauOptions = new JPanel(null);
        panneauOptions.setBounds(17, 20, fenetre.getWidth() - 50, 85);
        panneauOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauOptions.setBackground(Color.WHITE);
        panneauOptions.setVisible(true);
        
        difficulte = new JLabel("Niveau de difficulté");
        difficulte.setBounds(panneauOptions.getX(), panneauOptions.getY() + 2,
                panneauOptions.getWidth() / 4, 10);
        
        listeDifficulte = new JComboBox(TAB_DIFFICULTE);
        listeDifficulte.setBounds(difficulte.getX() + 140,
                difficulte.getY() - 8, difficulte.getWidth() / 2,
                difficulte.getHeight() + 10);
        listeDifficulte.setSelectedItem(TAB_DIFFICULTE[choixNiveauDifficulte]);
        listeDifficulte.setBackground(Color.WHITE);
        
        couleurInterface = new JLabel("Couleur de l'interface");
        couleurInterface.setBounds(difficulte.getX(), difficulte.getY() + 30,
                difficulte.getWidth() + 10, difficulte.getHeight());
        
        interfaceClaire = new JRadioButton("Claire");
        if (choixCouleurInterface == 0) {
            interfaceClaire.setSelected(true);
        }
        interfaceClaire.setBounds(listeDifficulte.getX(),
                listeDifficulte.getY() + 30, 60, 30);
        interfaceClaire.setBackground(Color.WHITE);
        
        interfaceSombre = new JRadioButton("Sombre");
        interfaceSombre.setBounds(interfaceClaire.getX() + 60,
                interfaceClaire.getY(), 75, 30);
        if (choixCouleurInterface == 1) {
            interfaceSombre.setSelected(true);
        }
        interfaceSombre.setBackground(Color.WHITE);
        
        groupeCouleur = new ButtonGroup();
        groupeCouleur.add(interfaceClaire);
        groupeCouleur.add(interfaceSombre);
        
        pendu = new JTextArea(PENDU_ZERO_ERREUR);
        pendu.setBounds(panneauOptions.getX(), panneauOptions.getY() + 85,
                panneauOptions.getWidth(), 185);
        pendu.setFont(FONT_PENDU);
        pendu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pendu.setEditable(false);
        
        labelScore = new JLabel("SCORE:  ");
        labelScore.setBounds(pendu.getX() + 175, pendu.getY() + 190, 65, 15);
        
        affichageScore = new JTextField("" + score);
        affichageScore.setBounds(labelScore.getX() + 50,
                labelScore.getY() - 2, 17, 17);
        affichageScore.setFont(labelScore.getFont());
        affichageScore.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
    
    /**
     * Initialise les éléments contenus dans la partie inférieure du conteneur 
     * de la vue 2 , soit le mot caché, l'entrée de la lettre, le mot caché, le 
     * bouton de soumission et un bouton pour quitter la vue 2.
     */
     private void initElementsPartieInferieureVue2() {
        ligneSeparation = new JTextField(TRAIT);
        ligneSeparation.setBounds(pendu.getX(), labelScore.getY() + 25,
                pendu.getWidth(), labelScore.getHeight() + 10);
        ligneSeparation.setBackground(Color.WHITE);
        ligneSeparation.setEditable(false);
        ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        labelMotCache = new JLabel("MOT CACHÉ");
        labelMotCache.setBounds(ligneSeparation.getX(),
                ligneSeparation.getY() + 40, labelScore.getWidth()+10,
                labelScore.getHeight());
        
        motCache = new JTextField("");
        motCache.setBounds(labelMotCache.getX() + 100,
                labelMotCache.getY() - 10, 350, labelMotCache.getHeight() + 20);
        motCache.setEditable(false);
        motCache.setFont(FONT_MOT_CACHE);
        
        labelLettre = new JLabel("LETTRE");
        labelLettre.setBounds(labelMotCache.getX(),
                labelMotCache.getY() + 50, 60, motCache.getHeight());
        
        lettre = new JTextField();
        lettre.setBounds(labelLettre.getX() + 70,
                labelLettre.getY(), 40, motCache.getHeight());
        lettre.setFont(FONT_SAISIE_LETTRE);
        
        boutonSoumettre = new JButton("Soumettre");
        boutonSoumettre.setBounds(lettre.getX() + 60,
                lettre.getY() + 8, 95, motCache.getHeight() - 10);
        
        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(lettre.getX() + 300,
                lettre.getY() + 8, 75, motCache.getHeight() - 10);
    }
    
     /**
      * Ajout des éléments contenus dans la partie supérieur et inférieure de la
      * vue 2 au panneau de la vue 2.
      */
    private void ajoutElementsVue2() {
        panelVue2.add(panneauOptions);
        panneauOptions.add(difficulte);
        panneauOptions.add(listeDifficulte);
        panneauOptions.add(couleurInterface);
        panneauOptions.add(interfaceClaire);
        panneauOptions.add(interfaceSombre);
        panelVue2.add(pendu);
        panelVue2.add(labelScore);
        panelVue2.add(affichageScore);
        panelVue2.add(ligneSeparation);
        panelVue2.add(labelMotCache);
        panelVue2.add(motCache);
        panelVue2.add(labelLettre);
        panelVue2.add(lettre);
        panelVue2.add(boutonSoumettre);
        panelVue2.add(boutonQuitter);
        fenetre.getContentPane().add(panelVue2);
    }
    
    /**
     * Organise la capture d'événements dans la vue 2 représentant le jeu du
     * pendu.
     */
    private void attributionActionListenersVue2() {
        interfaceClaire.addActionListener(this);
        listeDifficulte.addActionListener(this);
        interfaceSombre.addActionListener(this);
        boutonSoumettre.addActionListener(this);
        boutonQuitter.addActionListener(this);
        lettre.addActionListener(this);
    }

    /**
     *Cache les autres vues en vue de l'affichage de la vue 2.
     */
    private void cacherPanneauxVue2() {
        if (panelVue1 != null) {
            panelVue1.setVisible(false);
        }
        if (panelVue3 != null) {
            panelVue3.setVisible(false);
        }
    }
    
    /**
     * Initialise le panneau de la vue 3 représentant l'affichage des 
     * statistiques.
     */
    private void initVue3() {
        cacherPanneauxVue3();

        panelVue3 = new JPanel(null);
        panelVue3.setBounds(0, 0, LARGEUR, HAUTEUR);
        panelVue3.setBackground(java.awt.Color.WHITE);

        titreStats = new JLabel("STATISTIQUES");
        titreStats.setBounds(0, -15, LARGEUR, HAUTEUR / 5);
        titreStats.setHorizontalAlignment(SwingConstants.CENTER);
        titreStats.setFont(FONT_TITRE);

        initStatistiquesNiveau1();

        initStatistiquesNiveau2();

        initStatistiquesNiveau3();

        boutonFermerStats = new JButton("Fermer");
        boutonFermerStats.setBounds(panneauStatsNiv3.getX() + 190,
                panneauStatsNiv3.getY() + 95, 75, 20);

        ajoutElementsVue3();

        panelVue3.setVisible(true);

        boutonFermerStats.addActionListener(this);

        initVue3Claire();
    }
    /**
     * Initialise le panneau contenant les statistiques pour les parties jouée 
     * au niveau de difficulté 1.
     */
    private void initStatistiquesNiveau1() {
        titreStatsNiv1 = new JLabel("Parties de niveau 1");
        titreStatsNiv1.setBounds(titreStats.getX() + 15,
                titreStats.getY() + 100, 135, 20);
        titreStatsNiv1.setFont(FONT_TITRES_NIVEAUX);
        
        panneauStatsNiv1 = new JPanel(null);
        panneauStatsNiv1.setBounds(titreStatsNiv1.getX(),
                titreStatsNiv1.getY() + 17, panelVue3.getWidth() - 50, 80);
        panneauStatsNiv1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauStatsNiv1.setBackground(Color.WHITE);
        panneauStatsNiv1.setVisible(true);
        
        labelPartiesJoueesNiv1 = new JLabel("Parties jouées : ");
        labelPartiesJoueesNiv1.setBounds(panneauStatsNiv1.getX(),
                panneauStatsNiv1.getX() - 5, 130, 12);
        labelPartiesJoueesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesJoueesNiv1 = new JTextField("0");
        champPartiesJoueesNiv1.setBounds(labelPartiesJoueesNiv1.getX() + 135,
                labelPartiesJoueesNiv1.getY() - 2, 50, 15);
        champPartiesJoueesNiv1.setBackground(Color.WHITE);
        champPartiesJoueesNiv1.setEditable(false);
        champPartiesJoueesNiv1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesJoueesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        labelPartiesGagneesNiv1 = new JLabel("Parties gagnées : ");
        labelPartiesGagneesNiv1.setBounds(labelPartiesGagneesNiv1.getX() + 15,
                labelPartiesGagneesNiv1.getY() + 33, 130, 12);
        labelPartiesGagneesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesGagneesNiv1 = new JTextField("-");
        champPartiesGagneesNiv1.setBounds(labelPartiesGagneesNiv1.getX() + 135,
                labelPartiesGagneesNiv1.getY() - 2, 50, 15);
        champPartiesGagneesNiv1.setBackground(Color.WHITE);
        champPartiesGagneesNiv1.setEditable(false);
        champPartiesGagneesNiv1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesGagneesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        labelScoreMoyenNiv1 = new JLabel("Score Moyen : ");
        labelScoreMoyenNiv1.setBounds(labelPartiesGagneesNiv1.getX(),
                labelPartiesGagneesNiv1.getY() + 22, 130, 12);
        labelScoreMoyenNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        champScoreMoyenNiv1 = new JTextField("-");
        champScoreMoyenNiv1.setBounds(labelScoreMoyenNiv1.getX() + 135,
                labelScoreMoyenNiv1.getY() - 2, 50, 15);
        champScoreMoyenNiv1.setBackground(Color.WHITE);
        champScoreMoyenNiv1.setEditable(false);
        champScoreMoyenNiv1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champScoreMoyenNiv1.setFont(FONT_LABELS_NIVEAUX);
    }
    
    /**
     * Initialise le panneau contenant les statistiques pour les parties jouée 
     * au niveau de difficulté 2.
     */
    private void initStatistiquesNiveau2() {
        titreStatsNiv2 = new JLabel("Parties de niveau 2");
        titreStatsNiv2.setBounds(panneauStatsNiv1.getX(),
                panneauStatsNiv1.getY() + 100, 135, 20);
        titreStatsNiv2.setFont(FONT_TITRES_NIVEAUX);
        
        panneauStatsNiv2 = new JPanel(null);
        panneauStatsNiv2.setBounds(panneauStatsNiv1.getX(),
                titreStatsNiv2.getY() + 17, panelVue3.getWidth() - 50, 80);
        panneauStatsNiv2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauStatsNiv2.setBackground(Color.WHITE);
        panneauStatsNiv2.setVisible(true);
        
        labelPartiesJoueesNiv2 = new JLabel("Parties jouées : ");
        labelPartiesJoueesNiv2.setBounds(panneauStatsNiv2.getX(),
                panneauStatsNiv2.getX() - 5, 130, 12);
        labelPartiesJoueesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesJoueesNiv2 = new JTextField("0");
        champPartiesJoueesNiv2.setBounds(labelPartiesJoueesNiv2.getX() + 135,
                labelPartiesJoueesNiv2.getY() - 2, 50, 15);
        champPartiesJoueesNiv2.setBackground(Color.WHITE);
        champPartiesJoueesNiv2.setEditable(false);
        champPartiesJoueesNiv2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesJoueesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        labelPartiesGagneesNiv2 = new JLabel("Parties gagnées : ");
        labelPartiesGagneesNiv2.setBounds(labelPartiesGagneesNiv2.getX() + 15,
                labelPartiesGagneesNiv2.getY() + 33, 130, 12);
        labelPartiesGagneesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesGagneesNiv2 = new JTextField("-");
        champPartiesGagneesNiv2.setBounds(labelPartiesGagneesNiv2.getX() + 135,
                labelPartiesGagneesNiv2.getY() - 2, 50, 15);
        champPartiesGagneesNiv2.setBackground(Color.WHITE);
        champPartiesGagneesNiv2.setEditable(false);
        champPartiesGagneesNiv2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesGagneesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        labelScoreMoyenNiv2 = new JLabel("Score Moyen : ");
        labelScoreMoyenNiv2.setBounds(labelPartiesGagneesNiv2.getX(),
                labelPartiesGagneesNiv2.getY() + 22, 130, 12);
        labelScoreMoyenNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        champScoreMoyenNiv2 = new JTextField("-");
        champScoreMoyenNiv2.setBounds(labelScoreMoyenNiv2.getX() + 135,
                labelScoreMoyenNiv2.getY() - 2, 50, 15);
        champScoreMoyenNiv2.setBackground(Color.WHITE);
        champScoreMoyenNiv2.setEditable(false);
        champScoreMoyenNiv2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champScoreMoyenNiv2.setFont(FONT_LABELS_NIVEAUX);
    }
    
    /**
     * Initialise le panneau contenant les statistiques pour les parties jouée 
     * au niveau de difficulté 3.
     */
    private void initStatistiquesNiveau3() {
        titreStatsNiv3 = new JLabel("Parties de niveau 3");
        titreStatsNiv3.setBounds(panneauStatsNiv2.getX(), panneauStatsNiv2.getY() + 100, 135, 20);
        titreStatsNiv3.setFont(FONT_TITRES_NIVEAUX);
        
        panneauStatsNiv3 = new JPanel(null);
        panneauStatsNiv3.setBounds(panneauStatsNiv2.getX(),
                titreStatsNiv3.getY() + 17, panelVue3.getWidth() - 50, 80);
        panneauStatsNiv3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauStatsNiv3.setBackground(Color.WHITE);
        panneauStatsNiv3.setVisible(true);
        
        labelPartiesJoueesNiv3 = new JLabel("Parties jouées : ");
        labelPartiesJoueesNiv3.setBounds(panneauStatsNiv3.getX(),
                panneauStatsNiv3.getX() - 5, 130, 12);
        labelPartiesJoueesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesJoueesNiv3 = new JTextField("0");
        champPartiesJoueesNiv3.setBounds(labelPartiesJoueesNiv3.getX() + 135,
                labelPartiesJoueesNiv3.getY() - 2, 50, 15);
        champPartiesJoueesNiv3.setBackground(Color.WHITE);
        champPartiesJoueesNiv3.setEditable(false);
        champPartiesJoueesNiv3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesJoueesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        labelPartiesGagneesNiv3 = new JLabel("Parties gagnées : ");
        labelPartiesGagneesNiv3.setBounds(labelPartiesGagneesNiv3.getX() + 15,
                labelPartiesGagneesNiv3.getY() + 33, 130, 12);
        labelPartiesGagneesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesGagneesNiv3 = new JTextField("-");
        champPartiesGagneesNiv3.setBounds(labelPartiesGagneesNiv3.getX() + 135,
                labelPartiesGagneesNiv3.getY() - 2, 50, 15);
        champPartiesGagneesNiv3.setBackground(Color.WHITE);
        champPartiesGagneesNiv3.setEditable(false);
        champPartiesGagneesNiv3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesGagneesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        labelScoreMoyenNiv3 = new JLabel("Score Moyen : ");
        labelScoreMoyenNiv3.setBounds(labelPartiesGagneesNiv3.getX(),
                labelPartiesGagneesNiv3.getY() + 22, 130, 12);
        labelScoreMoyenNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        champScoreMoyenNiv3 = new JTextField("-");
        champScoreMoyenNiv3.setBounds(labelScoreMoyenNiv3.getX() + 135,
                labelScoreMoyenNiv3.getY() - 2, 50, 15);
        champScoreMoyenNiv3.setBackground(Color.WHITE);
        champScoreMoyenNiv3.setEditable(false);
        champScoreMoyenNiv3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champScoreMoyenNiv3.setFont(FONT_LABELS_NIVEAUX);
    }
    /**
     * Ajoute les éléments contenus dans la vue 3 au panneau des statistiques.
     */
     private void ajoutElementsVue3() {
        fenetre.getContentPane().add(panelVue3);
        panelVue3.add(titreStats);
        panelVue3.add(titreStatsNiv1);
        panelVue3.add(panneauStatsNiv1);
        panneauStatsNiv1.add(labelPartiesJoueesNiv1);
        panneauStatsNiv1.add(champPartiesJoueesNiv1);
        panneauStatsNiv1.add(labelPartiesGagneesNiv1);
        panneauStatsNiv1.add(champPartiesGagneesNiv1);
        panneauStatsNiv1.add(labelScoreMoyenNiv1);
        panneauStatsNiv1.add(champScoreMoyenNiv1);
        panelVue3.add(titreStatsNiv2);
        panelVue3.add(panneauStatsNiv2);
        panneauStatsNiv2.add(labelPartiesJoueesNiv2);
        panneauStatsNiv2.add(champPartiesJoueesNiv2);
        panneauStatsNiv2.add(labelPartiesGagneesNiv2);
        panneauStatsNiv2.add(champPartiesGagneesNiv2);
        panneauStatsNiv2.add(labelScoreMoyenNiv2);
        panneauStatsNiv2.add(champScoreMoyenNiv2);
        panelVue3.add(titreStatsNiv3);
        panelVue3.add(panneauStatsNiv3);
        panneauStatsNiv3.add(labelPartiesJoueesNiv3);
        panneauStatsNiv3.add(champPartiesJoueesNiv3);
        panneauStatsNiv3.add(labelPartiesGagneesNiv3);
        panneauStatsNiv3.add(champPartiesGagneesNiv3);
        panneauStatsNiv3.add(labelScoreMoyenNiv3);
        panneauStatsNiv3.add(champScoreMoyenNiv3);
        panelVue3.add(boutonFermerStats);
    }
     
    /**
     *Cache les autres vues en vue de l'affichage de la vue 3.
     */ 
    private void cacherPanneauxVue3() {
        if (panelVue1 != null) {
            panelVue1.setVisible(false);
        }
        if (panelVue2 != null) {
            panelVue2.setVisible(false);
        }
    }
    
    /**
     * Capture et interprètes les événements produits par les divers élements du
     * programmme afin de générer l'effet voulu en fonction de l'élément étant à
     * l'origine de l'événement.
     * 
     * @param evenement l'événement capturés par les ActionListeners des
     *                  différentes vues
     */
    @Override
    public void actionPerformed(ActionEvent evenement) {

        if (evenement.getSource() == boutonJouer) {
            initVue2();
            lettre.requestFocusInWindow();
            jouer();
        } else if (evenement.getSource() == boutonStats) {
            initVue3();
            mettreStatsVue3();
        } else if (evenement.getSource() == boutonQuitter) {
            initVue1();

        } else if (evenement.getSource() == listeDifficulte) {
            setDifficulte();
        } else if (evenement.getSource() == boutonFermerStats) {
            initVue1();
        } else if (evenement.getSource() == interfaceClaire) {
            this.choixCouleurInterface = 0;
            initVue2Claire();
        } else if (evenement.getSource() == interfaceSombre) {
            this.choixCouleurInterface = 1;
            initVue2Sombre();
        } else if (evenement.getSource() == boutonSoumettre 
                || evenement.getSource() == lettre) {
            analyseLettreEntree();
        }

    }
    
    /**
     * Analyse le caractère entré dans le champe demandant une lettre à
     * l'utilisateur et, s'il est valide, on vérifie si la lettre entrée est 
     * contenue dans le mot caché.
     * 
     * @throws HeadlessException  Si l'environnement exécutant est appelé dans 
     *                            un contexte où il est dépendant d'un matériel 
     *                            ou d'un affichage qui n'est pas supporté. 
     */
    private void analyseLettreEntree() throws HeadlessException {
        if (lettre.getText().length() != 1 || !ALPHABET.contains(lettre.getText())) {
            JOptionPane.showMessageDialog(panelVue2, MSG_UNE_LETTRE, "ERREUR",
                    JOptionPane.ERROR_MESSAGE);
            lettre.requestFocusInWindow();
        } else if (motCache.getText().contains(lettre.getText()
                .toUpperCase())) {
            JOptionPane.showMessageDialog(fenetre, MSG_LETTRE_DEJA, "Message",
                    JOptionPane.PLAIN_MESSAGE);
            lettre.requestFocusInWindow();
        } else {
            resultatPartie();
            lettre.requestFocusInWindow();
        }
        lettre.setText("");
        lettre.requestFocusInWindow();
    }

    /**
     * Ajuste le niveau de difficulte en fonction du bouton radio selectionne 
     * dans la vue 2.
     */
    private void setDifficulte() {
        if (listeDifficulte.getSelectedIndex() == 0) {
            this.choixNiveauDifficulte = 0;
            lettre.requestFocusInWindow();
            jouer();
            
        } else if (listeDifficulte.getSelectedIndex() == 1) {
            this.choixNiveauDifficulte = 1;
            lettre.requestFocusInWindow();
            jouer();
            
        } else {
            this.choixNiveauDifficulte = 2;
            lettre.requestFocusInWindow();
            jouer();
        }
    }
    
    /**
     * Réinitialise les éléments de la vue 2 pour qu'ils soient conformes à la 
     * vue claire lorsque cette vue est choisie dans les boutons radio de la vue
     * 2.
     */
    private void initVue2Claire() {
        panelVue2.setBackground(Color.WHITE);
        difficulte.setBackground(Color.WHITE);
        listeDifficulte.setBackground(Color.WHITE);
        couleurInterface.setBackground(Color.WHITE);
        interfaceClaire.setBackground(Color.WHITE);
        interfaceSombre.setBackground(Color.WHITE);
        pendu.setBackground(Color.WHITE);
        labelScore.setBackground(Color.WHITE);
        affichageScore.setBackground(Color.WHITE);
        ligneSeparation.setBackground(Color.WHITE);
        labelMotCache.setBackground(Color.WHITE);
        motCache.setBackground(Color.WHITE);
        labelLettre.setBackground(Color.WHITE);
        panneauOptions.setBackground(Color.WHITE);

        panelVue2.setForeground(Color.BLACK);
        difficulte.setForeground(Color.BLACK);
        listeDifficulte.setForeground(Color.BLACK);
        couleurInterface.setForeground(Color.BLACK);
        interfaceClaire.setForeground(Color.BLACK);
        interfaceSombre.setForeground(Color.BLACK);
        pendu.setForeground(Color.BLACK);
        labelScore.setForeground(Color.BLACK);
        affichageScore.setForeground(Color.BLACK);
        affichageScore.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        ligneSeparation.setForeground(Color.BLACK);
        ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        labelMotCache.setForeground(Color.BLACK);
        motCache.setForeground(Color.BLACK);
        motCache.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        labelLettre.setForeground(Color.BLACK);
        panneauOptions.setForeground(Color.BLACK);
        panneauOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    /**
     * Réinitialise les éléments de la vue 2 pour qu'ils soient conformes à la 
     * vue sombre lorsque cette vue est choisie dans les boutons radio de la vue
     * 2.
     */
    private void initVue2Sombre() {

        panelVue2.setBackground(Color.BLACK);
        difficulte.setBackground(Color.BLACK);
        listeDifficulte.setBackground(Color.BLACK);
        couleurInterface.setBackground(Color.BLACK);
        interfaceClaire.setBackground(Color.BLACK);
        interfaceSombre.setBackground(Color.BLACK);
        pendu.setBackground(Color.BLACK);
        labelScore.setBackground(Color.BLACK);
        affichageScore.setBackground(Color.BLACK);
        ligneSeparation.setBackground(Color.BLACK);
        labelMotCache.setBackground(Color.BLACK);
        motCache.setBackground(Color.BLACK);
        labelLettre.setBackground(Color.BLACK);
        panneauOptions.setBackground(Color.BLACK);

        panelVue2.setForeground(Color.WHITE);
        difficulte.setForeground(Color.WHITE);
        listeDifficulte.setForeground(Color.WHITE);
        couleurInterface.setForeground(Color.WHITE);
        interfaceClaire.setForeground(Color.WHITE);
        interfaceSombre.setForeground(Color.WHITE);
        pendu.setForeground(Color.WHITE);
        labelScore.setForeground(Color.WHITE);
        affichageScore.setForeground(Color.WHITE);
        affichageScore.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ligneSeparation.setForeground(Color.WHITE);
        ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelMotCache.setForeground(Color.WHITE);
        motCache.setForeground(Color.WHITE);
        motCache.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        labelLettre.setForeground(Color.WHITE);
        panneauOptions.setForeground(Color.WHITE);
        panneauOptions.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    private void initVue3Claire() {
        panelVue3.setBackground(Color.WHITE);
        titreStats.setBackground(Color.WHITE);
        titreStatsNiv1.setBackground(Color.WHITE);
        panneauStatsNiv1.setBackground(Color.WHITE);
        labelPartiesJoueesNiv1.setBackground(Color.WHITE);
        labelPartiesGagneesNiv1.setBackground(Color.WHITE);
        labelScoreMoyenNiv1.setBackground(Color.WHITE);
        titreStatsNiv2.setBackground(Color.WHITE);
        panneauStatsNiv2.setBackground(Color.WHITE);
        labelPartiesJoueesNiv2.setBackground(Color.WHITE);
        labelPartiesGagneesNiv2.setBackground(Color.WHITE);
        labelScoreMoyenNiv2.setBackground(Color.WHITE);
        titreStatsNiv3.setBackground(Color.WHITE);
        panneauStatsNiv3.setBackground(Color.WHITE);
        labelPartiesJoueesNiv3.setBackground(Color.WHITE);
        labelPartiesGagneesNiv3.setBackground(Color.WHITE);
        labelScoreMoyenNiv3.setBackground(Color.WHITE);
        champPartiesJoueesNiv1.setBackground(Color.WHITE);
        champPartiesGagneesNiv1.setBackground(Color.WHITE);
        champScoreMoyenNiv1.setBackground(Color.WHITE);
        champPartiesJoueesNiv2.setBackground(Color.WHITE);
        champPartiesGagneesNiv2.setBackground(Color.WHITE);
        champScoreMoyenNiv2.setBackground(Color.WHITE);
        champPartiesJoueesNiv3.setBackground(Color.WHITE);
        champPartiesGagneesNiv3.setBackground(Color.WHITE);
        champScoreMoyenNiv3.setBackground(Color.WHITE);
        boutonFermerStats.setBackground(Color.WHITE);

    }

    /**
     * Ajoute les statistiques correspondantes à la vue 3 une fois une partie
     * terminée.
     */
    private void mettreStatsVue3() {
        
        champPartiesJoueesNiv1.setText(partiesNiv1[JOUEES]);
        champPartiesGagneesNiv1.setText(partiesNiv1[PARTIES_GAG]);
        champScoreMoyenNiv1.setText(partiesNiv1[SCORE_MY]);

        champPartiesJoueesNiv2.setText(partiesNiv2[JOUEES]);
        champPartiesGagneesNiv2.setText(partiesNiv2[PARTIES_GAG]);
        champScoreMoyenNiv2.setText(partiesNiv2[SCORE_MY]);

        champPartiesJoueesNiv3.setText(partiesNiv3[JOUEES]);
        champPartiesGagneesNiv3.setText(partiesNiv3[PARTIES_GAG]);
        champScoreMoyenNiv3.setText(partiesNiv3[SCORE_MY]);
    }
    
    /**
     * Initialisation d'une partie du jeu du pendue de la vue 2 avec la 
     * difficulte selectionnee, un nouveau mot caché correspondant à cette 
     * difficulte et un score réinitialisé.
     */
    private void jouer() {
        motTire = Mots.tirerUnMot((Integer) listeDifficulte.getSelectedItem());
        motCache.setText(tiretsCacherMot(motTire));
        score = 6;
        affichageScore.setText("" + score);
        pendu.setText(PENDU_ZERO_ERREUR);
    }

    /**
     * Affiche un nombre de tirets dans la vue 2 correspondants au nombre de 
     * caractères du mot tire.
     * 
     * @param motTire le mot tiré du fichier contenant les mots cachés.
     * @return le nombre de tirets correspondant au nombre de caractères du mot 
     *         tire.
     */
    private String tiretsCacherMot(String motTire) {
        String tirets = "";

        for (int i = 0; i < motTire.length(); i++) {
            tirets += TIRET_BAS_ESP;
        }
        return tirets;
    }

    /**
     * Gère la validation d'une lettre si celle-ci n'avait pas déjà été entrée 
     * et vérifie si toutes les lettres ont été découvertes, gère la fin de la
     * partie.
     */
    private void resultatPartie() {
        boolean finPartie = resultatLettre(lettre.getText(), motTire);

        if (finPartie) {
            statsNivJeu((Integer) listeDifficulte.getSelectedItem());
            afficherBoiteDialogConfirm();
        }
    }
    /**
     * Ajuste les statistiques en fontion du niveau de difficulte selectionne.
     * 
     * @param nivJeu le niveau de difficulte selectionne.
     */
    private void statsNivJeu(int nivJeu) {
        
        switch(nivJeu) {
            case 1:
                compteurNiv1 = compteurNivJeu(compteurNiv1, score);
                partiesNiv1 = partiesNivJeu(partiesNiv1, compteurNiv1);
                break;
            case 2:
                compteurNiv2 = compteurNivJeu(compteurNiv2, score);
                partiesNiv2 = partiesNivJeu(partiesNiv2, compteurNiv2);
                break;
            case 3:
                compteurNiv3 = compteurNivJeu(compteurNiv3, score);
                partiesNiv3 = partiesNivJeu(partiesNiv3, compteurNiv3);
                break;
            default:
                break;
        }
    }
    /**
     * Vérifie si la lettre fait partie du mot caché, ajuste le score en
     * conséquence.
     * 
     * @param lettreChoisie la lettre entrée par l'utilisateur.
     * @param motTire le mot à découvrir.
     * @return true si la partie est terminée, false sinon.
     */
    private boolean resultatLettre(String lettreChoisie, String motTire) {
        String motCacheAff = motCache.getText();

        if (score != 0 && motCacheAff.contains(TIRET_BAS_ESP)) {
            if (motTire.toUpperCase().contains(lettreChoisie.toUpperCase())) {
                motCacheAff = remplacerLettreMotCache(lettreChoisie.toUpperCase(),
                        motCacheAff, motTire.toUpperCase());
                motCache.setText(motCacheAff);

            } else {
                score--;
                affichageScore.setText("" + score);
                ajusterPendu(score);
            }
        }//Retourne vrai si la partie est terminée
        return score == 0 || !motCacheAff.contains(TIRET_BAS_ESP);
    }

    /**
     * Insère la lettre validée comme étant contenue dans le mot caché à la 
     * place de son tiret correspondant dans la vue 2.
     * 
     * @param lettreChoisieMaj la lettre choisie sous sa forme majuscule.
     * @param motCache Le mot à découvriravec des tirets aux endroit où les 
     *                 lettres ne sont pas découvertes.
     * @param motTireMaj le mot à découvrir sous sa forme majuscule.
     * @return la nouvelle chaine correspondant au mot caché incluant 
     *         la lettre decouverte.
     */
    private String remplacerLettreMotCache(String lettreChoisieMaj,
            String motCache, String motTireMaj) {
        String motCachePartiel = "";

        if (lettreChoisieMaj != null && motCache != null && motTireMaj != null) {
            for (int i = 0; i < motTireMaj.length(); i++) {
                if (lettreChoisieMaj.charAt(0) == motTireMaj.charAt(i)) {
                    motCachePartiel += lettreChoisieMaj + " ";
                } else {
                    motCachePartiel += motCache.charAt(2 * i) + " ";
                }
            }
        }
        return motCachePartiel;
    }
    
    /**
     * Affiche une fenêtre surgissante dépendanmment de l'issue de la partie en
     * cours.
     */
    private void afficherBoiteDialogConfirm() {
        //Toutes les lettres du mot sont découvertes, l'utilisateur gagne
        if (!motCache.getText().contains(TIRET_BAS_ESP)) {
            gagne = JOptionPane.showConfirmDialog(fenetre, MSG_GAGNE + MOT_CACHE
                    + motTire.toUpperCase() + VOTRE_SCORE + score + AUTRE_JEU,
                    TITRE_GAGNE, JOptionPane.YES_NO_OPTION, JOptionPane
                    .PLAIN_MESSAGE);

            if (gagne == JOptionPane.YES_OPTION) {
                lettre.requestFocusInWindow();
                jouer();
            } else {
                initVue1();
            }
        }
        
        //Le score est arrivé à zéro et l'utilisateur perd
        if (score == 0) {
            perdu = JOptionPane.showConfirmDialog(fenetre, MSG_PERDU + MOT_CACHE
                     + motTire.toUpperCase() + AUTRE_JEU, TITRE_PERDU, 
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (perdu == JOptionPane.YES_OPTION) {
                lettre.requestFocusInWindow();
                jouer();
            } else {
                initVue1();
            }
        }
    }

    /**
     * Insère les statistiques obtenues à la fin d'une partie dans un tableau 
     * dans le but de les affiché dans la vue 3.
     * 
     * @param compteurNiv le tableau contenant les statistiques.
     * @param scorePartie le score final de la partie terminée.
     * @return le tableau mis à jour.
     */
    private int[] compteurNivJeu(int[] compteurNiv, int scorePartie) {
        if (compteurNiv != null && compteurNiv.length == 3 && scorePartie >= 0) {
            compteurNiv[PARTIES]++;
            if (scorePartie > 0) {
                compteurNiv[PARTIES_GAG]++;
                compteurNiv[SCORE_TOT] += scorePartie;
            }
        }
        return compteurNiv;
    }
    /**
     * Effectue les manipulations mathématiques afin de généré les statistiques 
     * finales provenant du tableau de statistiques brutes à la fin de chaque 
     * partie pour un niveau donné.
     * @param partiesNiv le tableau qui contiendra les statistiques finales sous
     *                   la forme de chaines de caractères
     * @param compteurNiv le tableau contenant les statistiques brutes sous 
     *                     forme de nombres entiers.
     * @return le tableau de statistiques finales mis à jour.
     */
    private static String[] partiesNivJeu(String[] partiesNiv, int[] compteurNiv) {
        partiesNiv[JOUEES] = "" + compteurNiv[PARTIES];
        if (compteurNiv[PARTIES] > 0) {
            partiesNiv[PARTIES_GAG] = DEC_FORMAT.format(100.0 * compteurNiv
                   [PARTIES_GAG] / compteurNiv[PARTIES]) + "%";
            partiesNiv[SCORE_MY] = DEC_FORMAT.format((compteurNiv[SCORE_TOT] 
                    + 0.0) / compteurNiv[PARTIES])  + " / 6";
        }
        return partiesNiv;
    }
    
    /**
     * Exécutée lorsque l'utilisateur ferme la fenetre.
     *
     * @param e l'evenement intercepte.
     */
    @Override
    public void windowClosing(WindowEvent e) {
        //Sauvegarde les statistiques à la fermeture de lafenêtre dans un 
        //fichier texte
        ecrireFichier();
    }

    /**
     * Ajuste l'affichage du pendu en fonction du score de la partie en cours.
     * 
     * @param score le score obtenu suite à la validation d'une lettre.
     */
    private void ajusterPendu(int score) {
        if (score == 5) {
            pendu.setVisible(false);
            pendu.setText(PENDU_UNE_ERREUR);
            pendu.setVisible(true);
        } else if (score == 4) {
            pendu.setVisible(false);
            pendu.setText(PENDU_DEUX_ERREURS);
            pendu.setVisible(true);
        } else if (score == 3) {
            pendu.setVisible(false);
            pendu.setText(PENDU_TROIS_ERREURS);
            pendu.setVisible(true);
        } else if (score == 2) {
            pendu.setVisible(false);
            pendu.setText(PENDU_QUATRE_ERREURS);
            pendu.setVisible(true);
        } else if (score == 1) {
            pendu.setVisible(false);
            pendu.setText(PENDU_CINQ_ERREURS);
            pendu.setVisible(true);
        } else if (score == 0) {
            pendu.setVisible(false);
            pendu.setText(PENDU_SIX_ERREURS);
            pendu.setVisible(true);

        }
    }
    /**
     * Écrit les statitiques dans le fichier texte.
     */
    public static void ecrireFichier() {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(FIC_STATS));

            ecrireNivFichier(out, partiesNiv1, 1);
            ecrireNivFichier(out, partiesNiv2, 2);
            ecrireNivFichier(out, partiesNiv3, 3);

            out.close();
        } catch (IOException e) {
            //aucune écriture dans le fichier
        }
    }

    /**
     * Écrit les statistiques des parties correspondant à un niveau de 
     * difficulte donne.
     * 
     * @param out Le fichier de sortie.
     * @param partiesNiveau le tableau de statistiques.
     * @param niv le niveau de difficulte
     * @throws IOException  s'il y a une erreur d'entrée ou de sortie avec le 
     *                      fichier texte.
     */
    public static void ecrireNivFichier(PrintWriter out, 
            String[] partiesNiveau, int niv) throws IOException{
        out.println(NIV + niv);//Le niveau est en entête
        
        for (int i = 0; i < partiesNiveau.length; i++) {
            if (i != 0) {
                out.print(" : ");
            }
            out.print(partiesNiveau[i]);
        }
        if (niv != 3) {
            out.print("\n\n");
        }
    }
    /**
     * Lit les statistique à partir du fichier texte de sauvegarde.
     * @param ficEntree le fichier de statistiques.
     */
    public static void lireFichier(String ficEntree) {
        BufferedReader in;
        String entete;
        String ligne;
        String saut;
        int niv = 0;

      try {
         in = new BufferedReader(new FileReader(ficEntree));

         while (in.ready()) {
             niv++;
             entete = in.readLine();
            ligne = in.readLine().trim();
             if (niv != 3) {
                 saut = in.readLine();
             }
                        
            switch(niv) {
                case 1: partiesNiv1 = ligne.split(" : ");
                    break;
                case 2: partiesNiv2 = ligne.split(" : ");
                    break;
                case 3: partiesNiv3= ligne.split(" : ");
                    break;
                default:
            }
         }
         
        in.close();
           
        } catch (IOException e) {
           //maintient les tableaux partiesNiv à leurs valeurs initials
        }
    }
    
    /**
     * Application JeuPendu
     * @param params
     */
    public static void main(String[] params) {
        //Lecture du fichier des statistiques s'il existe
        lireFichier(FIC_STATS);
        
        //Démarre l'application
        new JeuPendu();

    }
    
}
