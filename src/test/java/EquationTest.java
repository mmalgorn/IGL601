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
