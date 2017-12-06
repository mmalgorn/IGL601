package main.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Equation
{
    //ATTRIBUTS
    private ArrayList<Character> variables= new ArrayList<Character>();
    private ArrayList<Integer> coefficients =new ArrayList<Integer>();
    private int constante;
    
    
    //CONSTRUCTEURS
    
    /*
     * Constructeur qui extrait une liste de variables (une lettre par variable) et
     * une liste des coefficients qui leur correspond d'une String contenant une
     * une equation lineaire. Extrait egalement la constante a droite du =.
     * Lance des exceptions dans plusieurs des cas problematiques.
     */
    public Equation(String source) {

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
                    throw new IllegalArgumentException("Equation: equation mal formee (constante manquante � la fin");

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


    }
     
    /*
     * Constructeur qui prends la liste de variable, 
     * de coefficient et la valeur de la constante et remplit directement les attributs
    */
    public Equation(ArrayList<Character> variables, ArrayList<Integer> coefficients, int constante)
    {
        super();
        this.variables = variables;
        this.coefficients = coefficients;
        this.constante = constante;
    }

    
    //METHODES
    
    
    // Fonctions utilitaires pour reconnaetre les operateurs. 
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
    
    
    //OVERRIDE
   
    @Override
    public String toString() {

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

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Equation other = (Equation) obj;
        if (coefficients == null)
        {
            if (other.coefficients != null)
                return false;
        }
        else if (!coefficients.equals(other.coefficients))
            return false;
        if (constante != other.constante)
            return false;
        if (variables == null)
        {
            if (other.variables != null)
                return false;
        }
        else if (!variables.equals(other.variables))
            return false;
        return true;
    }
    
    
}
