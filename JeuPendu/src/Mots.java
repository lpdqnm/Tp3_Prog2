import java.util.ArrayList;
import java.io.*;

/**
 * INF2120-10 H17 : Classe fournie avec l'enonce du TP3.
 * 
 * L'utilisation de la methode tirerUnMot permet d'obtenir aleatoirement
 * un mot du niveau donne en parametre.
 *
 * @author Melanie Lord
 * @version H17
 */
public class Mots {
   //chemin du fichier contenant les mots des differents niveaux
   public static final String CHEMIN_FIC_MOTS = "mots.txt";

   //mots de niveau 1 (entre 3 et 6 lettres inclus.)
   public static final ArrayList<String> MOTS_1 = initMotNiv1();

   //mots de niveau 2 (entre 7 et 10 lettres inclus.)
   public static final ArrayList<String> MOTS_2 = initMotNiv2();

   //mots de niveau 3 (entre 11 et 14 lettres inclus.)
   public static final ArrayList<String> MOTS_3 = initMotNiv3();

   /**
    * Cette methode retourne un mot (nom commun) tire au hasard et dont le
    * nombre de lettres varie selon le niveau de difficulte passe en parametre.
    * NiveauDifficulte = 1 : mot compose de 3 a 6 lettres inclusivement.
    * NiveauDifficulte = 2 : mot compose de 7 a 10 lettres inclusivement. 
    * NiveauDifficulte = 3 : mot compose de 11 a 14 lettres inclusivement. 
    * 
    * Si niveauDifficulte n'est pas entre 1 et 3 inclusivement, la methode
    * retourne null.
    * 
    * @param niveauDifficulte le niveau de difficulte du mot retourne.
    * @return un mot tire au hasard selon niveauDifficulte si celui-ci est entre
    * 1 et 3 inclus. Sinon, retourne null.
    */
   public static String tirerUnMot(int niveauDifficulte) {
      String mot;
      if (niveauDifficulte == 1) {
         mot = MOTS_1.get(tirerUnNombre(0, MOTS_1.size() - 1));

      } else if (niveauDifficulte == 2) {
         mot = MOTS_2.get(tirerUnNombre(0, MOTS_2.size() - 1));
         
      } else if (niveauDifficulte == 3) {
         mot = MOTS_3.get(tirerUnNombre(0, MOTS_3.size() - 1));

      } else {
         mot = null;
      }
      return mot;
   }

   /**
    * Retourne un nombre entier tire au hasard entre min et max
    * inclusivement.
    *
    * @param min la borne minimale du nombre a tirer
    * @param max la borne maximale du nombre a tirer
    * @return un entier tire au hasard entre min et max inclusivement.
    */
   private static int tirerUnNombre(int min, int max) {
      return (int) (Math.random() * (max - min) + min + 0.5);
   }

   /**
    * Initialise une liste de mots de niveau 1 en lisant le fichier 
    * CHEMIN_FIC_MOT.
    * @return une liste contenant les mots de niveau 1.
    */
   private static ArrayList<String> initMotNiv1() {
      ArrayList<String> liste = new ArrayList<>();
      BufferedReader in;
      String ligne = "";

      try {
         in = new BufferedReader(new FileReader(CHEMIN_FIC_MOTS));

         while (in.ready() && !ligne.startsWith("#1")) {
            ligne = in.readLine().trim();
         }
         while (in.ready() && !ligne.startsWith("#2")) {
            ligne = in.readLine().trim();
            if (!ligne.isEmpty() && !ligne.startsWith("#")) {
               liste.add(ligne);
            }
         }
         in.close();
      } catch (IOException e) {
         //retourne liste vide
      }

      return liste;
   }

   /**
    * Initialise une liste de mots de niveau 2 en lisant le fichier 
    * CHEMIN_FIC_MOT.
    * @return une liste contenant les mots de niveau 2.
    */
   private static ArrayList<String> initMotNiv2() {
      ArrayList<String> liste = new ArrayList<>();
      String ligne = "";
      BufferedReader in;

      try {
         in = new BufferedReader(new FileReader(CHEMIN_FIC_MOTS));

         while (in.ready() && !ligne.startsWith("#2")) {
            ligne = in.readLine().trim();
         }

         while (in.ready() && !ligne.startsWith("#3")) {
            ligne = in.readLine().trim();
            if (!ligne.isEmpty() && !ligne.startsWith("#")) {
               liste.add(ligne);
            }
         }
      } catch (IOException e) {
         //retourne liste vide
      }

      return liste;
   }

   /**
    * Initialise une liste de mots de niveau 3 en lisant le fichier 
    * CHEMIN_FIC_MOT.
    * @return une liste contenant les mots de niveau 3.
    */
   private static ArrayList<String> initMotNiv3() {
      ArrayList<String> liste = new ArrayList<>();
      String ligne = "";
      BufferedReader in;

      try {
         in = new BufferedReader(new FileReader(CHEMIN_FIC_MOTS));

         while (in.ready() && !ligne.startsWith("#3")) {
            ligne = in.readLine().trim();
         }

         while (in.ready()) {
            ligne = in.readLine().trim();
            if (!ligne.isEmpty() && !ligne.startsWith("#")) {
               liste.add(ligne);
            }
         }
      } catch (IOException e) {
         //retourne liste vide
      }

      return liste;
   }

}
