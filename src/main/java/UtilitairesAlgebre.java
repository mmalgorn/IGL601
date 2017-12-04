/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * Obtention de donn�es test:
 * http://planetcalc.com/3571/
 * Classe "preuve de concept". D�montre l'utilisation des fonctions
 * et classes de base du labo. Exemple d'une mauvaise fa�on d'�crire 
 * des tests (surtout quand le code prend de l'expansion).
 * Contient des tests extr�mement minimaux, ne prouve pas beaucoup 
 * le bon fonctionnement du code �crit.
 */

public class UtilitairesAlgebre {

	public static void main(String[] args) {

		/*
		 * Ensemble de donn�es d�clar�es pour effectuer des tests.
		 */
		ArrayList<Character> variables = new ArrayList<Character>();
		ArrayList<Integer> coefficients = new ArrayList<Integer>();
		int constante;
		
		double[][] systeme1 = {

				{ 3, 5, -3, 15 },
				{ 7, 10, 1, 2 },
				{ -3, 2, -5, 6 }
			};
		double[][] systeme3 = {

                { 3, 5, -3, 15 },
                { 7, 10, 1, 2 },
                { -3, 2, -5, 6 }
            };

		double[] s1l1 = { 1, 2, 3, 14 };
		double[] s1l2 = { 1, 2, 3, 14 };
	      double[][] systeme2 = {

	                { 3, 5, -3 },
	                { 7, 10, 1 },
	                { -3, 2, -5 }
	            };


		/*
		 * Quelques tests pele-m�le.
		 */
	    
		Vecteur l1 = new Vecteur(s1l1);
		Vecteur l2 = new Vecteur(s1l2);
		//l1=l1.SousVecteur(2);
		//System.out.println(l1);
		System.out.println(l1.equals(l2, 0.01));
		
		//Vecteur l3 = Vecteur.creerVecteurNul(4);
		//System.out.println(l3);

		Matrice mat = new Matrice(systeme1);
		Matrice mat2 = new Matrice(systeme3);
		//mat.Gauss();
		System.out.println(mat.equals(mat2));
		//mat = mat.SousMatrice(2, 2);
		//Matrice mat2 = Matrice.creerMatriceNul(4,5);
		//Matrice mat2 = new Matrice(systeme2);
		//mat2.creerMatriceIdentite();
		//System.out.println(mat2);


		String equation = "3x + 5y - 2z = 0";
		String equ2 = "3x + 5y - 2z = 0";
		//constante = lireEquation(equation, variables, coefficients);
		//String resultat = afficherEquation(variables, coefficients, constante);
		Equation equation1 = new Equation(equation);	
		Equation equation2 = new Equation(equ2);
		System.out.println(equation1.equals(equation2));

	}
	
	public static boolean egaliteDoublePrecision(double a, double b, double epsilon)
    { 
        return (Math.abs(a-b) <= epsilon); 
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
					throw new IllegalArgumentException("Equation: equation mal formee (constante manquante a la fin");

				constante = Integer.parseInt(tokenizer.nextToken().trim());
				complete = true;
				break;

			} else {

				int coeff = Integer.parseInt(val.substring(0, val.length() - 1));
				char var = val.charAt(val.length() - 1);

				if (variables.contains(var))
					throw new IllegalArgumentException("Equation: �quation mal form�e (variable dupliqu�e");

				variables.add(var);
				coefficients.add(coeff * lastSign);
			}
		}
		if (tokenizer.hasMoreTokens())
			throw new IllegalArgumentException("Equation: �quation mal form�e (expression continue apr�s la constante");
		if (!complete)
			throw new IllegalArgumentException("Equation: �quation mal form�e (manque = constante � la fin)");

		return constante;

	}

	/*
	 * Fonctions utilitaires pour reconna�tre les op�rateurs.
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
