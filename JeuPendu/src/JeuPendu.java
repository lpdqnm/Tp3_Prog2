
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class JeuPendu extends WindowAdapter implements ActionListener {
   
    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 510;
    public static final Font FONT_TITRE = new Font("Courier",Font.BOLD, 24);
    
    public static final String PENDU_ZERO_ERREUR ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |             "+"\n     |             "
            +"\n     |             "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    
    public static final String PENDU_UNE_ERREUR ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |        o     "+"\n     |             "
            +"\n     |             "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    
    public static final String PENDU_DEUX_ERREURS ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |        o     "+"\n    |         |     "
            +"\n     |             "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    public static final String PENDU_TROIS_ERREURS ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |        o     "+"\n     |       /|    "
            +"\n     |             "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    public static final String PENDU_QUATRE_ERREURS ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |        o     "+"\n     |       /|\\   "
            +"\n     |             "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    public static final String PENDU_CINQ_ERREURS ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |        o     "+"\n     |       /|\\   "
            +"\n     |       /     "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    public static final String PENDU_SIX_ERREURS ="   _____________   "
            +"\n     |        |    "+"\n     |        |    "
            +"\n     |        o     "+"\n     |       /|\\   "
            +"\n     |       / \\     "+"\n     |             "
            +"\n   __|__________   "+"\n__|_____________|__";
    
    private int nbEssais = 0; // le nb d'essais effectuée, on pourra se servir de cette variable pour faire les affichage du pendu.
    
    //Vue 1:
    private JFrame fenetre;
    private JLabel titre;
    private JButton boutonJouer;
    private JButton boutonStats;
     
    public JeuPendu() {
        initVue1();
    }
    
    
    private void initVue1(){
        fenetre = new JFrame("JEU DU PENDU");
        fenetre.setBounds(700,250, HAUTEUR, LARGEUR);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(true);
        fenetre.setLayout(null);
        fenetre.getContentPane().setBackground(java.awt.Color.WHITE);
        
        titre = new JLabel ("Le jeu du pendu");
        titre.setBounds(0, 0, LARGEUR, HAUTEUR/3);
        titre.setHorizontalAlignment(SwingConstants.CENTER);
        titre.setFont(FONT_TITRE);
        
        boutonJouer = new JButton("Jouer");
        boutonJouer.setBounds(titre.getX(), titre.getY()+20, HAUTEUR, LARGEUR);
        
        boutonStats = new JButton("Statistiques");
        boutonStats.setBounds(boutonJouer.getX(), boutonJouer.getY()+10, HAUTEUR, LARGEUR);
        
        fenetre.getContentPane().add(titre);
        fenetre.getContentPane().add(boutonJouer);
        fenetre.getContentPane().add(boutonStats);
        fenetre.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Exécutée lorsque l'utilisateur ferme la fenetre.
     *
     * @param e l'evenement intercepte.
     */
    @Override
    public void windowClosing(WindowEvent e) {
    }
    
    public static void main (String[] params){
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
