
import java.io.FileNotFoundException;
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
    public static void ecrireLigneFichier(String args) {
        String[] partiesNiv1 = {"niveau1", "0", "-", "-"};
        PrintWriter out;

      try {
         out = new PrintWriter(new FileWriter("statistiques.txt"));
         
          for (int i = 0; i < partiesNiv1.length; i++) {
              if (i != 0) {
                  out.print("|");
              }
              out.print(partiesNiv1[i]);
          }
         
         out.close();
      } catch (IOException e) {
         
      }
      
    }
}
