
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leopold
 */
public class ClasseProvisoire {

    private static String[] partiesNiv1 = {"0", "-", "-"};
    private static String[] partiesNiv2 = {"0", "-", "-"};
    private static String[] partiesNiv3 = {"0", "-", "-"};

    public static void ecrireFichier() {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("statistiques.txt"));

            ecrireNivFichier(out, partiesNiv1, 1);
            ecrireNivFichier(out, partiesNiv2, 2);
            ecrireNivFichier(out, partiesNiv3, 3);

            out.close();
        } catch (IOException e) {
            //pas d'écriture dans le fichier
        }
    }

    public static void ecrireNivFichier(PrintWriter out, 
            String[] partiesNiveau, int niv) throws IOException{
        out.println("Niveau " + niv);//Le niveau est en entête
        
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
            
            System.out.println(entete);//test
            
            switch(niv) {
                case 1: partiesNiv1 = ligne.split(" : ");;
                    break;
                case 2: partiesNiv2 = ligne.split(" : ");
                    break;
                case 3: partiesNiv3= ligne.split(" : ");
                    break;
                default:
            }
         }
         
           in.close();
           
           System.out.println(java.util.Arrays.toString(partiesNiv1));//test
           System.out.println(java.util.Arrays.toString(partiesNiv2));//test
           System.out.println(java.util.Arrays.toString(partiesNiv3));//test
        } catch (IOException e) {
           //maintient les tableaux partiesNiv à leurs valeurs initials
        }
    }
    
}
