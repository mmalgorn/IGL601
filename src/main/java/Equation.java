/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class equation extends Vecteur {
	
	private ArrayList<Character> variables = new ArrayList<Character>();

    private int constante;
    
    
	public Equation(String source) {
		
		super();
		
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

				this.constante = Integer.parseInt(tokenizer.nextToken().trim());
				complete = true;
				break;

			} else {

				int coeff = Integer.parseInt(val.substring(0, val.length() - 1));
				char var = val.charAt(val.length() - 1);

				if (this.variables.contains(var))
					throw new IllegalArgumentException("Equation: equation mal formee (variable dupliquee");

				this.variables.add(var);				
				this.ajouter(coeff * lastSign);
			}
		}
		if (tokenizer.hasMoreTokens())
			throw new IllegalArgumentException("Equation: equation mal forme (expression continue apres la constante");
		if (!complete)
			throw new IllegalArgumentException("Equation: equation mal forme (manque = constante a la fin)");


	}
	
	
	public Equation( ArrayList<Character> variables, ArrayList<Integer> coefficients, int constante) {
		super(coefficients);		
		this.variables = variables;		
		this.constante = constante;
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
	
	public String toString() {
		
		
		String res = "";
		res += (int) this.getValeur(0) + "" + this.variables.get(0);
		
		for (int i = 1; i < this.variables.size(); i++) {
		
			int coeff = (int) this.getValeur(i);
			if (coeff < 0) {
				res += " - ";
			} else {
				res += " + ";
			}
		
			res += Math.abs(coeff) + "" + this.variables.get(i);
		}
		
		res += " = " + this.constante;
		return res;
		
	}
	
	public boolean equals(Equation eq){
	    
	    boolean resultat = true;
	    if(this instanceof Equation){
	        if(this.constante == eq.constante){
	           int i=0;
               while( i<this.variables.size() && resultat != false){
                   
                   resultat = this.variables.get(i) == eq.variables.get(i);
                   i++;
               }
               if(resultat == false){
                    return false;
                }
                else{
                    int j=0;
                    while( j<this.taille() && resultat != false){
                        resultat = this.getValeur(j) == eq.getValeur(j);
                        j++;
                    }	                
                    return resultat;
                   
                }
	        }
	    }
	    return false;
	    
	}


    
	
	

}
