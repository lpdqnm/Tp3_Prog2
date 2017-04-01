
import java.awt.event.*;



public class JeuPendu extends WindowAdapter implements ActionListener {
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
        System.out.println("\n"+PENDU_ZERO_ERREUR);
        System.out.println("\n"+PENDU_UNE_ERREUR);
        System.out.println("\n"+PENDU_DEUX_ERREURS);
        System.out.println("\n"+PENDU_TROIS_ERREURS);
        System.out.println("\n"+PENDU_QUATRE_ERREURS);
        System.out.println("\n"+PENDU_CINQ_ERREURS);
        System.out.println("\n"+PENDU_SIX_ERREURS);
    }
}
