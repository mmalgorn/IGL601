/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package test.java;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import main.java.Equation;

public class EquationTest {

	String e = "3x + 5y - 2z = 0";
	String e6 = "3x + 5y - 2z = 0";
	
	Equation equation1 = new Equation(e);
	Equation equation6 = new Equation(e6);
	
	
	@Before
	public void setUp() {
		equation1 = new Equation(e);
		equation6 = new Equation(e6);
		
	}

	@Test(expected=IllegalArgumentException.class)
    public void testEquationExceptionConstante() 
    {
		String e2 = "3x + 5y - 2z = ";
		Equation equation2 = new Equation(e2);
    }
	
	@Test(expected=IllegalArgumentException.class)
	public void testEquationExceptionVariable() 
	{
		String e3 = "3x + 5x - 2z = 0";		
		Equation equation3 = new Equation(e3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEquationExceptionSuiteConstante() 
	{
		String e4 = "3x + 5x - 2z = 0+";		
		Equation equation4 = new Equation(e4);
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void testEquationExceptionEgalConstante() 
    {
		String e5 = "3x + 5y - 2z ";
		Equation equation5 = new Equation(e5);
    }
	
	@Test
	public void testToString() {
		
		assertEquals("3x + 5y - 2z = 0", equation1.toString());
		
	}
	
	@Test
    public void testEquals()
    {
        assertTrue(equation1.equals(equation6));
    }

}
