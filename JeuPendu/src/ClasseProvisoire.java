
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
    private static String[] partiesNiv2 = {"niveau2", "0", "-", "-"};
    private static String[] partiesNiv3 = {"niveau3", "0", "-", "-"};

    public static void ecrireFichier() {
        //String[] partiesNiv1 = {"niveau1", "0", "-", "-"};
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter("statistiques.txt"));

            ecrireLigneFichier(out, partiesNiv1);
            ecrireLigneFichier(out, partiesNiv2);
            ecrireLigneFichier(out, partiesNiv3);

            out.close();
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
        out.println();
    }
}
