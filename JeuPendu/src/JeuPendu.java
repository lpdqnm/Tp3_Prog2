
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
        
    

    }

    @Override
    public void actionPerformed(ActionEvent evenement) {
        if (evenement.getSource() == boutonJouer) {
            initVue2();
        } else if (evenement.getSource() == boutonStats) {

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
