package geo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * Obtention de donnees test:
 * http://planetcalc.com/3571/
 * Classe "preuve de concept". Demontre l'utilisation des fonctions
 * et classes de base du labo. Exemple d'une mauvaise facon d'ecrire 
 * des tests (surtout quand le code prend de l'expansion).
 * Contient des tests extremement minimaux, ne prouve pas beaucoup 
 * le bon fonctionnement du code ecrit.
 */

public class UtilitairesAlgebre {

    public static void main(String[] args) {

        /*
         * Ensemble de donnees declarees pour effectuer des tests.
         */
        ArrayList<Character> variables = new ArrayList<Character>();
        ArrayList<Integer> coefficients = new ArrayList<Integer>();
        int constante;
        String equation = "3x + 5y - 2z = 0";

        double[][] systeme1 = {

                { 3, 5, -3, 15 },
                { 7, 10, 1, 2 },
                { -3, 2, -5, 6 },
                { -3, 2, -5, 6 }
            };

        double[] s1l1 = { 1, 2, 3, 14 };

        /*
         * Quelques tests pele-mele.
         */

        Vecteur l1 = new Vecteur(s1l1);
        System.out.println(l1);
        Vecteur l2=l1.sousVecteur(2);
        System.out.println(l2);

        Matrice mat2 = new Matrice(systeme1);
        mat2=mat2.sousMatrice(2, 2);
        mat2=mat2.creerMatId();
        
        System.out.println(mat2);
        
        
        
        Matrice mat = new Matrice(systeme1);
        
        mat.Gauss();
        System.out.println(mat);

        constante = lireEquation(equation, variables, coefficients);
        String resultat = afficherEquation(variables, coefficients, constante);
        System.out.println(resultat);

    }

    /*
     * Fonction qui transforme en String contenant une equation lineaire une liste de
     * variables et de coefficients separees.
     */
    public static String afficherEquation(ArrayList<Character> variables, ArrayList<Integer> coefficients,
            int constante) {

        String res = "";
        res += coefficients.get(0) + "" + variables.get(0);

        for (int i = 1; i < variables.size(); i++) {

            int coeff = coefficients.get(i);
            if (coeff < 0) {
                res += " - ";
            } else {
                res += " + ";
            }

            res += Math.abs(coeff) + "" + variables.get(i);
        }

        res += " = " + constante;
        return res;

    }

    /*
     * Fonction qui extrait une liste de variables (une lettre par variable) et
     * une liste des coefficients qui leur correspond d'une String contenant une
     * une equation lineaire. Extrait egalement la constante a droite du =.
     * Lance des exceptions dans plusieurs des cas problematiques.
     */
    public static int lireEquation(String source, ArrayList<Character> variables, ArrayList<Integer> coefficients) {

        int constante = 0;
        final String delims = "+-=";
        HashMap<Character, Integer> signes = new HashMap<Character, Integer>();
        signes.put('+', 1);
        signes.put('-', -1);

        int lastSign = 1;
        boolean complete = false;

        StringTokenizer tokenizer = new StringTokenizer(source, delims, true);

        while (tokenizer.hasMoreTokens()) {

            String val = tokenizer.nextToken().trim();
            if (val.length() == 0)
                continue;

            if (isOperator(val)) {

                lastSign = signes.get(val.charAt(0));

            } else if (isOperatorEquals(val)) {

                if (!tokenizer.hasMoreTokens())
                    throw new IllegalArgumentException("Equation: equation mal formee (constante manquante ï¿½ la fin");

                constante = Integer.parseInt(tokenizer.nextToken().trim());
                complete = true;
                break;

            } else {

                int coeff = Integer.parseInt(val.substring(0, val.length() - 1));
                char var = val.charAt(val.length() - 1);

                if (variables.contains(var))
                    throw new IllegalArgumentException("Equation: equation mal formee (variable dupliquee");

                variables.add(var);
                coefficients.add(coeff * lastSign);
            }
        }
        if (tokenizer.hasMoreTokens())
            throw new IllegalArgumentException("Equation: equation mal formee (expression continue apres la constante");
        if (!complete)
            throw new IllegalArgumentException("Equation: equation mal formee (manque = constante ï¿½ la fin)");

        return constante;

    }

    /*
     * Fonctions utilitaires pour reconnaetre les operateurs.
     */

    private static boolean isOperator(String c) {

        if (c.length() == 1) {
            return c.charAt(0) == '+' || c.charAt(0) == '-';
        }

        return false;

    }

    private static boolean isOperatorEquals(String c) {

        if (c.length() == 1) {
            return c.charAt(0) == '=';
        }

        return false;
    }

}
