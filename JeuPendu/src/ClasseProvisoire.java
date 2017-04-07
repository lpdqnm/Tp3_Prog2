
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

    public static void ecrireLigneFichier(String[] partiesNiveau) {
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

    public static void ecrireFichier() {
        String[] partiesNiv1 = {"niveau1", "0", "-", "-"};
        String[] partiesNiv2 = {"niveau2", "0", "-", "-"};
        String[] partiesNiv3 = {"niveau3", "0", "-", "-"};

        ecrireLigneFichier(partiesNiv1);
        ecrireLigneFichier(partiesNiv2);
        ecrireLigneFichier(partiesNiv3);
    }
}
