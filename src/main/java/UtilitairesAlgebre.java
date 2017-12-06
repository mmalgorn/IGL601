package main.java;

import java.util.ArrayList;

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
	    //Vecteur
	    double[] s1l1 = { 1, 2, 3, 14 };
	    
	    //Matrice
	    double[][] systeme1 = {

                { 3, 5, -3, 15 },
                { 7, 10, 1, 2 },
                { -3, 2, -5, 6 },
                { -3, 2, -5, 6 }
            };
	    
	    //Equation
	    String equation = "3x + 5y - 2z = 0";
		ArrayList<Character> variables = new ArrayList<Character>();
		ArrayList<Integer> coefficients = new ArrayList<Integer>();
        variables.add('x');
        variables.add('y');
        variables.add('z');
        coefficients.add(3);
        coefficients.add(5);
        coefficients.add(-2);
		int constante=0;
		

		/*
		 * Quelques manipulations pele-mele.
		 */

		Vecteur l1 = new Vecteur(s1l1);
		System.out.println(l1);
		Vecteur l2=l1.sousVecteur(2);
		System.out.println(l2);
		System.out.println("\n");
	
		
		Matrice mat = new Matrice(systeme1);
		System.out.println(mat);
		
		Matrice mat2 = new Matrice(systeme1);
		mat2=mat2.sousMatrice(2, 2);
		mat2=mat2.creerMatId();
		System.out.println(mat2);

		Equation eq1=new Equation(equation);
		System.out.println(eq1);
		Equation eq2=new Equation(variables,coefficients,constante);
		System.out.println(eq2);

	}

	


}
