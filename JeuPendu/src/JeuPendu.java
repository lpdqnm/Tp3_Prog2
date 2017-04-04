
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JeuPendu extends WindowAdapter implements ActionListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 510;
    public static final Font FONT_TITRE = new Font("Courier", Font.BOLD, 24);
    public static final Font FONT_BOUTON = new Font("Courier", Font.PLAIN, 20);
    public static final Integer[] TAB_DIFFICULTE = new Integer[] {1,2,3};

    public static final String PENDU_ZERO_ERREUR = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |             " + "\n     |             "
            + "\n     |             " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";

    public static final String PENDU_UNE_ERREUR = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |        o     " + "\n     |             "
            + "\n     |             " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";

    public static final String PENDU_DEUX_ERREURS = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |        o     " + "\n    |         |     "
            + "\n     |             " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";
    public static final String PENDU_TROIS_ERREURS = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |        o     " + "\n     |       /|    "
            + "\n     |             " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";
    public static final String PENDU_QUATRE_ERREURS = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |        o     " + "\n     |       /|\\   "
            + "\n     |             " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";
    public static final String PENDU_CINQ_ERREURS = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |        o     " + "\n     |       /|\\   "
            + "\n     |       /     " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";
    public static final String PENDU_SIX_ERREURS = "   _____________   "
            + "\n     |        |    " + "\n     |        |    "
            + "\n     |        o     " + "\n     |       /|\\   "
            + "\n     |       / \\     " + "\n     |             "
            + "\n   __|__________   " + "\n__|_____________|__";

    private int nbEssais = 0; // le nb d'essais effectuée, on pourra se servir de cette variable pour faire les affichage du pendu.

    //Vue 1:
    private JFrame fenetre;
    private JLabel titre;
    private JButton boutonJouer;
    private JButton boutonStats;

    private JPanel panneauOptions;
    private JLabel difficulte;
    private JComboBox listeDifficulte;
    private JLabel couleurInterface;
    private JRadioButton interfaceClaire;
    private JRadioButton interfaceSombre;
    private ButtonGroup groupeCouleur;

    public JeuPendu() {
        initVue1();
    }

    private void initVue1() {
        fenetre = new JFrame("JEU DU PENDU");
        fenetre.setBounds(700, 250, LARGEUR, HAUTEUR);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(true);
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
        titre.setVisible(false);
        boutonJouer.setVisible(false);
        boutonStats.setVisible(false);

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

        fenetre.getContentPane().add(panneauOptions);
        panneauOptions.add(difficulte);
        panneauOptions.add(listeDifficulte);
        panneauOptions.add(couleurInterface);
        panneauOptions.add(interfaceClaire);
        panneauOptions.add(interfaceSombre);

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
