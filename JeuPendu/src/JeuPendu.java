
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JeuPendu extends WindowAdapter implements ActionListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 510;
    public static final Font FONT_TITRE = new Font("Courier", Font.BOLD, 24);
    public static final Font FONT_BOUTON = new Font("Courier", Font.PLAIN, 20);
    public static final Integer[] TAB_DIFFICULTE = new Integer[] {1,2,3};
    public static final Font FONT_PENDU = new Font("Courier New", Font.PLAIN, 16);
    public static final Font FONT_TITRES_NIVEAUX = new Font("Arial", Font.BOLD,13);
    public static final Font FONT_LABELS_NIVEAUX = new Font("Courier New", Font.PLAIN,12);
    public static final Font FONT_SAISIE_LETTRE = new Font("Courier New", Font.BOLD,24);
    
    public static final String TRAIT = "___________________________________________________________________";

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

    private int score = 6; // le nb d'essais effectuée, on pourra se servir de cette variable pour faire les affichage du pendu.

    //Vue 1:
    private JFrame fenetre;
    private JLabel titre;
    private JButton boutonJouer;
    private JButton boutonStats;

    
    private JFrame fenetreVue2;
    private JPanel panneauOptions;
    private JLabel difficulte;
    private JComboBox listeDifficulte;
    private JLabel couleurInterface;
    private JRadioButton interfaceClaire;
    private JRadioButton interfaceSombre;
    private ButtonGroup groupeCouleur;
    private JTextArea pendu;
    private JLabel affichageScore;
    private JTextField ligneSeparation;
    private JLabel labelMotCache;
    private JTextField motCache; // ici il faudra dynamiser les _ _ _ _  pour que ceux-ci soient au bon nombre et change au fur et à mesure en focntion de ce qui se trouve dans le mot.txt.
    private JLabel labelLettre;
    private JTextField lettre;
    private JButton boutonSoumettre;
    private JButton boutonQuitter;
    
    
    private JFrame fenetreVue3;
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
    
    
    

    public JeuPendu() {
        initVue1();
    }

    private void initVue1() {
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
        fenetre.setVisible(false);
        
        fenetreVue2 = new JFrame("JEU DU PENDU");
        fenetreVue2.setBounds(700, 250, LARGEUR, HAUTEUR);
        fenetreVue2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreVue2.setResizable(false);
        fenetreVue2.setLayout(null);
        fenetreVue2.getContentPane().setBackground(java.awt.Color.WHITE);
        

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
        pendu.setBounds(panneauOptions.getX(), panneauOptions.getY()+85, panneauOptions.getWidth(), 175);
        pendu.setFont(FONT_PENDU);
        pendu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pendu.setEditable(false);
        
        affichageScore = new JLabel("SCORE:  " + score);
        affichageScore.setBounds(pendu.getX() + 175, pendu.getY() +180, 75, 15);
        
        ligneSeparation = new JTextField(TRAIT);
        ligneSeparation.setBounds(pendu.getX(), affichageScore.getY() + 25, pendu.getWidth(), affichageScore.getHeight()+10);
        ligneSeparation.setBackground(Color.WHITE);
        ligneSeparation.setEditable(false);
        ligneSeparation.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        
        labelMotCache = new JLabel("MOT CACHÉ");
        labelMotCache.setBounds(ligneSeparation.getX(), ligneSeparation.getY()+40, affichageScore.getWidth(), affichageScore.getHeight());
        
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

        fenetreVue2.getContentPane().add(panneauOptions);
        panneauOptions.add(difficulte);
        panneauOptions.add(listeDifficulte);
        panneauOptions.add(couleurInterface);
        panneauOptions.add(interfaceClaire);
        panneauOptions.add(interfaceSombre);
        fenetreVue2.getContentPane().add(pendu);
        fenetreVue2.getContentPane().add(affichageScore);
        fenetreVue2.getContentPane().add(ligneSeparation);
        fenetreVue2.getContentPane().add(labelMotCache);
        fenetreVue2.getContentPane().add(motCache);
        fenetreVue2.getContentPane().add(labelLettre);
        fenetreVue2.getContentPane().add(lettre);
        fenetreVue2.getContentPane().add(boutonSoumettre);
        fenetreVue2.getContentPane().add(boutonQuitter);
        
        
        fenetreVue2.setVisible(true);
        
        boutonSoumettre.addActionListener(this);
        boutonQuitter.addActionListener(this);
    }
    
    private void initVue3(){
        fenetre.setVisible(false);
        
        fenetreVue3 = new JFrame("JEU DU PENDU");
        fenetreVue3.setBounds(700, 250, LARGEUR, HAUTEUR);
        fenetreVue3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetreVue3.setResizable(false);
        fenetreVue3.setLayout(null);
        fenetreVue3.getContentPane().setBackground(java.awt.Color.WHITE);
        
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
        
       
        
        
        fenetreVue3.getContentPane().add(titreStats);
        fenetreVue3.getContentPane().add(titreStatsNiv1);
        fenetreVue3.getContentPane().add(panneauStatsNiv1);
        panneauStatsNiv1.add(labelPartiesJoueesNiv1);
        panneauStatsNiv1.add(champPartiesJoueesNiv1);
        panneauStatsNiv1.add(labelPartiesGagneesNiv1);
        panneauStatsNiv1.add(champPartiesGagneesNiv1);
        panneauStatsNiv1.add(labelScoreMoyenNiv1);
        panneauStatsNiv1.add(champScoreMoyenNiv1);
        fenetreVue3.getContentPane().add(titreStatsNiv2);
        fenetreVue3.getContentPane().add(panneauStatsNiv2);
        panneauStatsNiv2.add(labelPartiesJoueesNiv2);
        panneauStatsNiv2.add(champPartiesJoueesNiv2);
        panneauStatsNiv2.add(labelPartiesGagneesNiv2);
        panneauStatsNiv2.add(champPartiesGagneesNiv2);
        panneauStatsNiv2.add(labelScoreMoyenNiv2);
        panneauStatsNiv2.add(champScoreMoyenNiv2);
        fenetreVue3.getContentPane().add(titreStatsNiv3);
        fenetreVue3.getContentPane().add(panneauStatsNiv3);
        panneauStatsNiv3.add(labelPartiesJoueesNiv3);
        panneauStatsNiv3.add(champPartiesJoueesNiv3);
        panneauStatsNiv3.add(labelPartiesGagneesNiv3);
        panneauStatsNiv3.add(champPartiesGagneesNiv3);
        panneauStatsNiv3.add(labelScoreMoyenNiv3);
        panneauStatsNiv3.add(champScoreMoyenNiv3);
        fenetreVue3.add(boutonFermerStats);
        
        
        fenetreVue3.setVisible(true);
        
        boutonFermerStats.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == boutonJouer) {
            initVue2();
            lettre.requestFocusInWindow();
        } else if (evenement.getSource() == boutonStats) {
            initVue3();
        } else if(evenement.getSource() == boutonQuitter){
            initVue1();
        }else if(evenement.getSource() == boutonSoumettre){
            
        }else if(evenement.getSource() == boutonFermerStats){
            initVue1();
        }

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
}
