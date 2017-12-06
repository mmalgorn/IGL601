package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import main.java.Equation;

public class EquationTest
{
    String equation1 = "3x + 5y - 2z = 0";
    Equation eq1=new Equation(equation1);
    String equation2 = "3x + 5y - 2z = 0";
    Equation eq2=new Equation(equation2);
    
    @Before
    public void setup(){
        eq1=new Equation(equation1);
    }
        
    @Test
    public void egalite()
    {
        ArrayList<Character> variables = new ArrayList<Character>();
        ArrayList<Integer> coefficients = new ArrayList<Integer>();
        variables.add('x');
        variables.add('y');
        variables.add('z');
        coefficients.add(3);
        coefficients.add(5);
        coefficients.add(-2);
        int constante=0;
        eq2=new Equation(variables,coefficients,constante);
        assertEquals(eq1,eq2);       
        assertEquals(eq1,eq1);
    }
    
    @Test
    public void nonEgalite() {
    	assertFalse(eq1.equals(new Integer(5)));
    	assertFalse(eq1.equals(null));
    	
    }
    
    @Test 
    public void nonEgaliteCoef() {
    	 ArrayList<Character> variables = new ArrayList<Character>();
         ArrayList<Integer> coefficients = new ArrayList<Integer>();
         variables.add('x');
         variables.add('y');
         variables.add('z');
         int constante=0;
         eq2=new Equation(variables,coefficients,constante);
         assertFalse(eq1.equals(eq2));
    }
    
    @Test
    public void nonEgaliteCoefNull() {
   	 ArrayList<Character> variables = new ArrayList<Character>();
     variables.add('x');
     variables.add('y');
     variables.add('z');
     int constante=0;
     eq2=new Equation(variables,null,constante);
     assertFalse(eq2.equals(eq1));
    }
    
    @Test
    public void nonEgaliteConstante() {
    	 ArrayList<Character> variables = new ArrayList<Character>();
         ArrayList<Integer> coefficients = new ArrayList<Integer>();
         coefficients.add(3);
         coefficients.add(5);
         coefficients.add(-2);
         int constante=5;
         eq2=new Equation(variables,coefficients,constante);
         assertFalse(eq1.equals(eq2));
    }
    
    @Test 
    public void nonEgaliteVar() {
    	 ArrayList<Character> variables = new ArrayList<Character>();
         ArrayList<Integer> coefficients = new ArrayList<Integer>();
         coefficients.add(3);
         coefficients.add(5);
         coefficients.add(-2);
         int constante=0;
         eq2=new Equation(variables,coefficients,constante);
         assertFalse(eq1.equals(eq2));
    }
    
    @Test
    public void nonEgaliteVarNull() {
     ArrayList<Integer> coefficients = new ArrayList<Integer>();
     coefficients.add(3);
     coefficients.add(5);
     coefficients.add(-2);
     int constante=0;
     eq2=new Equation(null,coefficients,constante);
     assertFalse(eq2.equals(eq1));
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testSansSecondMembre()
    {
        String equation2 = "3x + 5y - 2z = ";
        eq2=new Equation(equation2);  
    }
 
    
    @Test(expected=IllegalArgumentException.class)
    public void testVariableDupliquee()
    {
        String equation2 = "3x + 5x - 2z = 0";
        eq2=new Equation(equation2);   
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testSecondMembreCalculatoire()
    {
        String equation2 = "3x + 5y - 2z = 3 + 5";
        eq2=new Equation(equation2);       
    }
 
    
    @Test(expected=IllegalArgumentException.class)
    public void testSansEgalite()
    {
        String equation2 = "3x + 5y - 2z ";
        eq2=new Equation(equation2);       
    }
    
    @Test
    public void affichage()
    {
        assertTrue(eq1.toString().equals(equation2));       
    }
    
}
