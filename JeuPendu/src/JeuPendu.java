
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class JeuPendu extends WindowAdapter implements ActionListener {

    //CONSTANTES
    
    public static final String ALPHABET = 
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 510;
    public static final Font FONT_TITRE = new Font("Courier", Font.BOLD, 24);
    public static final Font FONT_BOUTON = new Font("Courier", Font.PLAIN, 20);
    public static final Integer[] TAB_DIFFICULTE = new Integer[] {1,2,3};
    public static final Font FONT_PENDU = new Font("Courier New", 
            Font.PLAIN, 16);
    public static final Font FONT_TITRES_NIVEAUX = new Font("Arial", 
            Font.BOLD,13);
    public static final Font FONT_LABELS_NIVEAUX = new Font("Courier New", 
            Font.PLAIN,12);
    public static final Font FONT_SAISIE_LETTRE = new Font("Courier New",
            Font.BOLD,24);
    public static final Font FONT_SCORE = new Font("Courier", Font.BOLD,12);
    public static final String TRAIT = "_______________________________________"
            +"____________________________";

    public static final String PENDU_ZERO_ERREUR = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |                  " + "\n               |                  "
            + "\n               |                  " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";

    public static final String PENDU_UNE_ERREUR = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |        o         " + "\n               |                  "
            + "\n               |                  " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";

    public static final String PENDU_DEUX_ERREURS = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |        o         " + "\n               |        |         "
            + "\n               |                  " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";
    public static final String PENDU_TROIS_ERREURS = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |        o         " + "\n               |       /|         "
            + "\n               |                  " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";
    public static final String PENDU_QUATRE_ERREURS = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |        o         " + "\n               |       /|\\        "
            + "\n               |                  " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";
    public static final String PENDU_CINQ_ERREURS = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |        o         " + "\n               |       /|\\        "
            + "\n               |       /          " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";
    public static final String PENDU_SIX_ERREURS = "              ____________    "
            + "\n               |        |     " + "\n               |        |     "
            + "\n               |        o         " + "\n               |       /|\\        "
            + "\n               |       /\\         " + "\n               |                  "
            + "\n             __|__________   " + "\n          __|_____________|__";
    
    public static final String FIC_STATS = "statistiques.txt";
    public static final DecimalFormat DEC_FORMAT = new DecimalFormat("0.0");
    public static final String TIRET_BAS = "_";
    
    //VARIABLES D'INSTANCE
    
    private int score = 6; // le nb d'essais effectuée, on pourra se servir de cette variable pour faire les affichage du pendu.
    
    //Vue 1:
    private JFrame fenetre;
    private JLabel titre;
    private JButton boutonJouer;
    private JButton boutonStats;

    
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
    private JTextField motCache; // ici il faudra dynamiser les _ _ _ _  pour que ceux-ci soient au bon nombre et change au fur et à mesure en focntion de ce qui se trouve dans le mot.txt.
    private JLabel labelLettre;
    private JTextField lettre;
    private JButton boutonSoumettre;
    private JButton boutonQuitter;
    
    
    private JPanel fenetreVue3;
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
    private static String[] partiesNiv1 = {"niveau1", "0", "-", "-"};
    private static String[] partiesNiv2 = {"niveau2", "0", "-", "-"};
    private static String[] partiesNiv3 = {"niveau3", "0", "-", "-"};
    

    public JeuPendu() {
        initVue1();
    }

    private void initVue1() {
        if(panelVue2 != null){
        panelVue2.setVisible(false);
        }
        if(fenetreVue3 != null){
        fenetreVue3.setVisible(false);
        }
        
        fenetre = new JFrame("JEU DU PENDU");
        fenetre.setBounds(700, 250, LARGEUR, HAUTEUR);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.setLayout(null);
        fenetre.getContentPane().setBackground(java.awt.Color.WHITE);

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

        fenetre.getContentPane().add(titre);
        fenetre.getContentPane().add(boutonJouer);
        fenetre.getContentPane().add(boutonStats);
        fenetre.setVisible(true);

        boutonJouer.addActionListener(this);
        boutonStats.addActionListener(this);
    }

   private void initVue2() {
       
        cacherMenuPrincipal();
        
        
        panelVue2 = new JPanel(null);
        panelVue2.setBounds(0, 0, LARGEUR, HAUTEUR);
        panelVue2.setBackground(java.awt.Color.WHITE);
       
       
        

        panneauOptions = new JPanel(null);
        panneauOptions.setBounds(17, 20, fenetre.getWidth() - 50, 85);
        panneauOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauOptions.setBackground(Color.WHITE);
        panneauOptions.setVisible(true);
        
        difficulte = new JLabel("Niveau de difficulté");
        difficulte.setBounds(panneauOptions.getX(), panneauOptions.getY()+2, panneauOptions.getWidth()/4, 10);
        
        listeDifficulte = new JComboBox (TAB_DIFFICULTE);
        listeDifficulte.setBounds(difficulte.getX()+140, difficulte.getY()-8, difficulte.getWidth()/2, difficulte.getHeight()+10);
        listeDifficulte.setBackground(Color.WHITE);
        
        couleurInterface = new JLabel ("Couleur de l'interface");
        couleurInterface.setBounds(difficulte.getX(), difficulte.getY()+30, difficulte.getWidth()+10 , difficulte.getHeight());
        
        interfaceClaire = new JRadioButton("Claire");
        interfaceClaire.setSelected(true);
        interfaceClaire.setBounds(listeDifficulte.getX(), listeDifficulte.getY()+30, 60, 30);
        interfaceClaire.setBackground(Color.WHITE);
        
        interfaceSombre = new JRadioButton("Sombre");
        interfaceSombre.setBounds(interfaceClaire.getX()+60, interfaceClaire.getY(), 75, 30);
        interfaceSombre.setBackground(Color.WHITE);
        
        groupeCouleur = new ButtonGroup();
        groupeCouleur.add(interfaceClaire);
        groupeCouleur.add(interfaceSombre);
        
        pendu = new JTextArea(PENDU_ZERO_ERREUR);
        pendu.setBounds(panneauOptions.getX(), panneauOptions.getY()+85, panneauOptions.getWidth(), 185);
        pendu.setFont(FONT_PENDU);
        pendu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pendu.setEditable(false);
        
        labelScore = new JLabel("SCORE:  ");
        labelScore.setBounds(pendu.getX() + 175, pendu.getY()+190, 65, 15);
        
        affichageScore = new JTextField("" +score);
        affichageScore.setBounds(labelScore.getX() + 50, labelScore.getY()-2, 17, 17);
        affichageScore.setFont(labelScore.getFont());
        affichageScore.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        
        ligneSeparation = new JTextField(TRAIT);
        ligneSeparation.setBounds(pendu.getX(), labelScore.getY() + 25, pendu.getWidth(), labelScore.getHeight()+10);
        ligneSeparation.setBackground(Color.WHITE);
        ligneSeparation.setEditable(false);
        ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        labelMotCache = new JLabel("MOT CACHÉ");
        labelMotCache.setBounds(ligneSeparation.getX(), ligneSeparation.getY()+40, labelScore.getWidth()+10, labelScore.getHeight());
        
        motCache = new JTextField ("");
        motCache.setBounds(labelMotCache.getX()+110, labelMotCache.getY()-10, 300, labelMotCache.getHeight()+20);
        motCache.setEditable(false);
        
        labelLettre = new JLabel ("LETTRE");
        labelLettre.setBounds(labelMotCache.getX(), labelMotCache.getY()+50, 60, motCache.getHeight());
        
        lettre = new JTextField();
        lettre.setBounds(labelLettre.getX()+70, labelLettre.getY(), 40, motCache.getHeight());
        lettre.setFont(FONT_SAISIE_LETTRE);
        
        
        boutonSoumettre = new JButton ("Soumettre");
        boutonSoumettre.setBounds(lettre.getX()+60, lettre.getY()+8, 95, motCache.getHeight()-10);
        
        boutonQuitter = new JButton ("Quitter");
        boutonQuitter.setBounds(lettre.getX()+300, lettre.getY()+8, 75, motCache.getHeight()-10);

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
    
        panelVue2.setVisible(true);
        
        interfaceClaire.addActionListener(this);
        interfaceSombre.addActionListener(this);
        boutonSoumettre.addActionListener(this);
        boutonQuitter.addActionListener(this);
        lettre.addActionListener(this);
        
        
        initVue2Claire();
        
        
    }

    private void cacherMenuPrincipal() {
        titre.setVisible(false);
        boutonJouer.setVisible(false);
        boutonStats.setVisible(false);
    }
    
    private void initVue3(){
        cacherMenuPrincipal();
        
        fenetreVue3 = new JPanel(null);
        fenetreVue3.setBounds(0, 0, LARGEUR, HAUTEUR);
        fenetreVue3.setBackground(java.awt.Color.WHITE);
        
        titreStats = new JLabel("STATISTIQUES");
        titreStats.setBounds(0, -15, LARGEUR, HAUTEUR /5 );
        titreStats.setHorizontalAlignment(SwingConstants.CENTER);
        titreStats.setFont(FONT_TITRE);
        
        titreStatsNiv1 = new JLabel("Parties de niveau 1");
        titreStatsNiv1.setBounds(titreStats.getX() +15, titreStats.getY() +100, 135, 20);
        titreStatsNiv1.setFont(FONT_TITRES_NIVEAUX);
        
        panneauStatsNiv1 = new JPanel(null);
        panneauStatsNiv1.setBounds(titreStatsNiv1.getX(), titreStatsNiv1.getY()+17, fenetreVue3.getWidth()-50, 80);
        panneauStatsNiv1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauStatsNiv1.setBackground(Color.WHITE);
        panneauStatsNiv1.setVisible(true);
        
        labelPartiesJoueesNiv1= new JLabel("Parties jouées : ");
        labelPartiesJoueesNiv1.setBounds(panneauStatsNiv1.getX(), panneauStatsNiv1.getX()-5, 130, 12);
        labelPartiesJoueesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesJoueesNiv1= new JTextField("0");
        champPartiesJoueesNiv1.setBounds(labelPartiesJoueesNiv1.getX()+135, labelPartiesJoueesNiv1.getY()-2, 20, 15);
        champPartiesJoueesNiv1.setBackground(Color.WHITE);
        champPartiesJoueesNiv1.setEditable(false);
        champPartiesJoueesNiv1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesJoueesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        
        labelPartiesGagneesNiv1= new JLabel("Parties gagnées : ");
        labelPartiesGagneesNiv1.setBounds(labelPartiesGagneesNiv1.getX()+15, labelPartiesGagneesNiv1.getY()+33, 130, 12);
        labelPartiesGagneesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesGagneesNiv1= new JTextField("-");
        champPartiesGagneesNiv1.setBounds(labelPartiesGagneesNiv1.getX()+135, labelPartiesGagneesNiv1.getY()-2, 20, 15);
        champPartiesGagneesNiv1.setBackground(Color.WHITE);
        champPartiesGagneesNiv1.setEditable(false);
        champPartiesGagneesNiv1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesGagneesNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        labelScoreMoyenNiv1= new JLabel("Score Moyen : ");
        labelScoreMoyenNiv1.setBounds(labelPartiesGagneesNiv1.getX(), labelPartiesGagneesNiv1.getY()+22, 130, 12);
        labelScoreMoyenNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        champScoreMoyenNiv1= new JTextField("-");
        champScoreMoyenNiv1.setBounds(labelScoreMoyenNiv1.getX()+135, labelScoreMoyenNiv1.getY()-2, 20, 15);
        champScoreMoyenNiv1.setBackground(Color.WHITE);
        champScoreMoyenNiv1.setEditable(false);
        champScoreMoyenNiv1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champScoreMoyenNiv1.setFont(FONT_LABELS_NIVEAUX);
        
        titreStatsNiv2 = new JLabel("Parties de niveau 2");
        titreStatsNiv2.setBounds(panneauStatsNiv1.getX(), panneauStatsNiv1.getY() +100, 135, 20);
        titreStatsNiv2.setFont(FONT_TITRES_NIVEAUX);
        
        panneauStatsNiv2 = new JPanel(null);
        panneauStatsNiv2.setBounds(panneauStatsNiv1.getX(), titreStatsNiv2.getY()+17, fenetreVue3.getWidth()-50, 80);
        panneauStatsNiv2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauStatsNiv2.setBackground(Color.WHITE);
        panneauStatsNiv2.setVisible(true);
        
        labelPartiesJoueesNiv2= new JLabel("Parties jouées : ");
        labelPartiesJoueesNiv2.setBounds(panneauStatsNiv2.getX(), panneauStatsNiv2.getX()-5, 130, 12);
        labelPartiesJoueesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesJoueesNiv2= new JTextField("0");
        champPartiesJoueesNiv2.setBounds(labelPartiesJoueesNiv2.getX()+135, labelPartiesJoueesNiv2.getY()-2, 20, 15);
        champPartiesJoueesNiv2.setBackground(Color.WHITE);
        champPartiesJoueesNiv2.setEditable(false);
        champPartiesJoueesNiv2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesJoueesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        labelPartiesGagneesNiv2= new JLabel("Parties gagnées : ");
        labelPartiesGagneesNiv2.setBounds(labelPartiesGagneesNiv2.getX()+15, labelPartiesGagneesNiv2.getY()+33, 130, 12);
        labelPartiesGagneesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesGagneesNiv2= new JTextField("-");
        champPartiesGagneesNiv2.setBounds(labelPartiesGagneesNiv2.getX()+135, labelPartiesGagneesNiv2.getY()-2, 20, 15);
        champPartiesGagneesNiv2.setBackground(Color.WHITE);
        champPartiesGagneesNiv2.setEditable(false);
        champPartiesGagneesNiv2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesGagneesNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        labelScoreMoyenNiv2= new JLabel("Score Moyen : ");
        labelScoreMoyenNiv2.setBounds(labelPartiesGagneesNiv2.getX(), labelPartiesGagneesNiv2.getY()+22, 130, 12);
        labelScoreMoyenNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        champScoreMoyenNiv2= new JTextField("-");
        champScoreMoyenNiv2.setBounds(labelScoreMoyenNiv2.getX()+135, labelScoreMoyenNiv2.getY()-2, 20, 15);
        champScoreMoyenNiv2.setBackground(Color.WHITE);
        champScoreMoyenNiv2.setEditable(false);
        champScoreMoyenNiv2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champScoreMoyenNiv2.setFont(FONT_LABELS_NIVEAUX);
        
        titreStatsNiv3 = new JLabel("Parties de niveau 3");
        titreStatsNiv3.setBounds(panneauStatsNiv2.getX(), panneauStatsNiv2.getY() +100, 135, 20);
        titreStatsNiv3.setFont(FONT_TITRES_NIVEAUX);
        
        panneauStatsNiv3 = new JPanel(null);
        panneauStatsNiv3.setBounds(panneauStatsNiv2.getX(), titreStatsNiv3.getY()+17, fenetreVue3.getWidth()-50, 80);
        panneauStatsNiv3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panneauStatsNiv3.setBackground(Color.WHITE);
        panneauStatsNiv3.setVisible(true);
        
        labelPartiesJoueesNiv3= new JLabel("Parties jouées : ");
        labelPartiesJoueesNiv3.setBounds(panneauStatsNiv3.getX(), panneauStatsNiv3.getX()-5, 130, 12);
        labelPartiesJoueesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesJoueesNiv3= new JTextField("0");
        champPartiesJoueesNiv3.setBounds(labelPartiesJoueesNiv3.getX()+135, labelPartiesJoueesNiv3.getY()-2, 20, 15);
        champPartiesJoueesNiv3.setBackground(Color.WHITE);
        champPartiesJoueesNiv3.setEditable(false);
        champPartiesJoueesNiv3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesJoueesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        labelPartiesGagneesNiv3= new JLabel("Parties gagnées : ");
        labelPartiesGagneesNiv3.setBounds(labelPartiesGagneesNiv3.getX()+15, labelPartiesGagneesNiv3.getY()+33, 130, 12);
        labelPartiesGagneesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        champPartiesGagneesNiv3= new JTextField("-");
        champPartiesGagneesNiv3.setBounds(labelPartiesGagneesNiv3.getX()+135, labelPartiesGagneesNiv3.getY()-2, 20, 15);
        champPartiesGagneesNiv3.setBackground(Color.WHITE);
        champPartiesGagneesNiv3.setEditable(false);
        champPartiesGagneesNiv3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champPartiesGagneesNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        labelScoreMoyenNiv3= new JLabel("Score Moyen : ");
        labelScoreMoyenNiv3.setBounds(labelPartiesGagneesNiv3.getX(), labelPartiesGagneesNiv3.getY()+22, 130, 12);
        labelScoreMoyenNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        champScoreMoyenNiv3= new JTextField("-");
        champScoreMoyenNiv3.setBounds(labelScoreMoyenNiv3.getX()+135, labelScoreMoyenNiv3.getY()-2, 20, 15);
        champScoreMoyenNiv3.setBackground(Color.WHITE);
        champScoreMoyenNiv3.setEditable(false);
        champScoreMoyenNiv3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        champScoreMoyenNiv3.setFont(FONT_LABELS_NIVEAUX);
        
        boutonFermerStats = new JButton("Fermer");
        boutonFermerStats.setBounds(panneauStatsNiv3.getX()+190, panneauStatsNiv3.getY()+95,75,20);
        
       
        
        fenetre.getContentPane().add(fenetreVue3);
        fenetreVue3.add(titreStats);
        fenetreVue3.add(titreStatsNiv1);
        fenetreVue3.add(panneauStatsNiv1);
        panneauStatsNiv1.add(labelPartiesJoueesNiv1);
        panneauStatsNiv1.add(champPartiesJoueesNiv1);
        panneauStatsNiv1.add(labelPartiesGagneesNiv1);
        panneauStatsNiv1.add(champPartiesGagneesNiv1);
        panneauStatsNiv1.add(labelScoreMoyenNiv1);
        panneauStatsNiv1.add(champScoreMoyenNiv1);
        fenetreVue3.add(titreStatsNiv2);
        fenetreVue3.add(panneauStatsNiv2);
        panneauStatsNiv2.add(labelPartiesJoueesNiv2);
        panneauStatsNiv2.add(champPartiesJoueesNiv2);
        panneauStatsNiv2.add(labelPartiesGagneesNiv2);
        panneauStatsNiv2.add(champPartiesGagneesNiv2);
        panneauStatsNiv2.add(labelScoreMoyenNiv2);
        panneauStatsNiv2.add(champScoreMoyenNiv2);
        fenetreVue3.add(titreStatsNiv3);
        fenetreVue3.add(panneauStatsNiv3);
        panneauStatsNiv3.add(labelPartiesJoueesNiv3);
        panneauStatsNiv3.add(champPartiesJoueesNiv3);
        panneauStatsNiv3.add(labelPartiesGagneesNiv3);
        panneauStatsNiv3.add(champPartiesGagneesNiv3);
        panneauStatsNiv3.add(labelScoreMoyenNiv3);
        panneauStatsNiv3.add(champScoreMoyenNiv3);
        fenetreVue3.add(boutonFermerStats);
        
        
        fenetreVue3.setVisible(true);
        
        boutonFermerStats.addActionListener(this);
        
        initVue3Claire();
    }

    @Override
    public void actionPerformed(ActionEvent evenement) {
        String scoreNul = "" + 0;
        String motTire = "";
        
        if (evenement.getSource() == boutonJouer) {
            initVue2();
            lettre.requestFocusInWindow();
            motTire = jouer();
        } else if (evenement.getSource() == boutonStats) {
            initVue3();
        } else if(evenement.getSource() == boutonQuitter){
            initVue1();
            
        }else if(evenement.getSource() == boutonFermerStats){
            initVue1();
        }else if(evenement.getSource() == interfaceClaire){
            initVue2Claire();
        }else if(evenement.getSource() == interfaceSombre){
            initVue2Sombre();
        }else if (evenement.getSource() == boutonSoumettre || evenement.getSource() == lettre ){
            if(lettre.getText().length()!= 1 || !ALPHABET.contains(lettre.getText())){
                JOptionPane.showMessageDialog(panelVue2, "Vous devez entrer une lettre non accentuée!", "ERREUR", JOptionPane.WARNING_MESSAGE);
            } else {
                resultatLettre(lettre.getText(), motTire);
            }
        }else if(Integer.parseInt(labelScore.getText()) == 0){
            JOptionPane.showMessageDialog(panelVue2, "Bravo! Vous avez gagné la partie!", "PARTIE GAGNÉE", JOptionPane.PLAIN_MESSAGE);
        }

    }
    
    private void initVue2Claire() {
     panelVue2.setBackground(Color.WHITE);
     difficulte.setBackground(Color.WHITE);
     listeDifficulte.setBackground(Color.WHITE);
     couleurInterface.setBackground(Color.WHITE);
     interfaceClaire.setBackground(Color.WHITE);
     interfaceSombre.setBackground(Color.WHITE);
     pendu.setBackground(Color.WHITE);
     labelScore.setBackground(Color.WHITE);
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
     ligneSeparation.setForeground(Color.BLACK);
     ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.WHITE));
     labelMotCache.setForeground(Color.BLACK);
     motCache.setForeground(Color.BLACK);
     labelLettre.setForeground(Color.BLACK);
     panneauOptions.setForeground(Color.BLACK);
     panneauOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    private void initVue2Sombre() {
     
     panelVue2.setBackground(Color.BLACK);
     difficulte.setBackground(Color.BLACK);
     listeDifficulte.setBackground(Color.BLACK);
     couleurInterface.setBackground(Color.BLACK);
     interfaceClaire.setBackground(Color.BLACK);
     interfaceSombre.setBackground(Color.BLACK);
     pendu.setBackground(Color.BLACK);
     labelScore.setBackground(Color.BLACK);
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
     ligneSeparation.setForeground(Color.WHITE);
     ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
     labelMotCache.setForeground(Color.WHITE);
     motCache.setForeground(Color.WHITE);
     labelLettre.setForeground(Color.WHITE);
     panneauOptions.setForeground(Color.WHITE);
     panneauOptions.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
    
    private void initVue3Claire(){
        fenetreVue3.setBackground(Color.WHITE);
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
    
    private String jouer(){
        String motTire = Mots.tirerUnMot((Integer)listeDifficulte
                .getSelectedItem());
        
        motCache.setText(tiretsCacherMot(motTire));
        return motTire;
    }
    
    private String tiretsCacherMot(String motTire) {
        String tirets = "";
        
        for (int i = 0; i < motTire.length(); i++) {
            tirets += TIRET_BAS;
        }
        return tirets;
    } 
    
    private boolean resultatLettre(String lettreChoisie, String motTire){
        boolean partieTerminee = false;
        String motCacheAff = motCache.getText();
        
        if (score != 0 && !motCacheAff.equalsIgnoreCase(motTire)) {            
            if (motTire.contains(lettreChoisie)) {
                motCacheAff = remplacerLettreMotCache(lettreChoisie.toUpperCase(),
                        motCacheAff, motTire.toUpperCase()); 
                motCache.setText(motCacheAff);
            } else {
                score--;
                ajusterPendu(score);
            }
        }
        
//        if (score != 0 && !motCache.equals(motTire)) {
//            partieTerminee = true;
//        }
        return partieTerminee;
    }
    
    private String remplacerLettreMotCache(String lettreChoisieMaj, 
            String motCache, String motTireMaj){
        char carTire;
        String motCachePartiel = "";

        if (lettreChoisieMaj != null && motCache != null && motTireMaj != null) {
            for (int i = 0; i < motTireMaj.length(); i++) {
                carTire = motTireMaj.charAt(i);
                if (lettreChoisieMaj.charAt(0)  == carTire) {
                    motCachePartiel += "" + carTire;
                } else {
                    motCachePartiel += "" + motCache.charAt(i);
                }
            }
        }
        
        return motCachePartiel;
    }

    /**
     * Exécutée lorsque l'utilisateur ferme la fenetre.
     *
     * @param e l'evenement intercepte.
     */
    @Override
    public void windowClosing(WindowEvent e) {
    }

    public static void main(String[] params) {
        new JeuPendu();

//System.out.println("\n"+PENDU_ZERO_ERREUR);
//        System.out.println("\n"+PENDU_UNE_ERREUR);
//        System.out.println("\n"+PENDU_DEUX_ERREURS);
//        System.out.println("\n"+PENDU_TROIS_ERREURS);
//        System.out.println("\n"+PENDU_QUATRE_ERREURS);
//        System.out.println("\n"+PENDU_CINQ_ERREURS);
//        System.out.println("\n"+PENDU_SIX_ERREURS);
        
        
    }

    private void ajusterPendu(int score) {
        if(score == 5){
            pendu.setVisible(false);
            pendu.setText(PENDU_UNE_ERREUR);
            pendu.setVisible(true);
        }else if(score == 4){
            pendu.setVisible(false);
            pendu.setText(PENDU_DEUX_ERREURS);
            pendu.setVisible(true);
        }else if(score == 3){
            pendu.setVisible(false);
            pendu.setText(PENDU_DEUX_ERREURS);
            pendu.setVisible(true);
        }else if(score == 2){
            pendu.setVisible(false);
            pendu.setText(PENDU_TROIS_ERREURS);
            pendu.setVisible(true);
        }else if(score == 1){
            pendu.setVisible(false);
            pendu.setText(PENDU_QUATRE_ERREURS);
            pendu.setVisible(true);
        }else if(score == 0){
            pendu.setVisible(false);
            pendu.setText(PENDU_DEUX_ERREURS);
            pendu.setVisible(true);
            JOptionPane.showMessageDialog(panelVue2, "Oups! Vous êtes mort.", "PARTIE PERDUE", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
