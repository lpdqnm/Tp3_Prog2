
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

    private static String[] partiesNiv1 = {"niveau1", "0", "-", "-"};
    private static String[] partiesNiv2 = {"niveau2", "0", "-", "-"};
    private static String[] partiesNiv3 = {"niveau3", "0", "-", "-"};

    public static void ecrireFichier() {
        //String[] partiesNiv1 = {"niveau1", "0", "-", "-"};
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("statistiques.txt"));

            ecrireLigneFichier(out, partiesNiv1);
            out.println();
            ecrireLigneFichier(out, partiesNiv2);
            out.println();
            ecrireLigneFichier(out, partiesNiv3);

            out.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public static void ecrireLigneFichier(PrintWriter out, 
            String[] partiesNiveau) throws IOException{
        for (int i = 0; i < partiesNiveau.length; i++) {
            if (i != 0) {
                out.print("|");
            }
            out.print(partiesNiveau[i]);
        }
    }
    
    public static void lireFichier(String ficEntree) {
        BufferedReader in;
        String ligne = "";
        int i = 0;

      try {
         in = new BufferedReader(new FileReader("statistiquesLire.txt"));

         while (in.ready()) {
             i++;
            ligne = in.readLine().trim();
            
            switch(i) {
                case 1: partiesNiv1 = ligne.split("[|]{1}");
                    break;
                case 2: partiesNiv2 = ligne.split("[|]{1}");
                    break;
                case 3: partiesNiv3= ligne.split("[|]{1}");
                    break;
                default:
            }
         }
         
           in.close();
           
           System.out.println(java.util.Arrays.toString(partiesNiv1));//test
           System.out.println(java.util.Arrays.toString(partiesNiv2));//test
           System.out.println(java.util.Arrays.toString(partiesNiv3));//test
        } catch (IOException e) {
           //retourne liste vide
        }
    }
    
}
