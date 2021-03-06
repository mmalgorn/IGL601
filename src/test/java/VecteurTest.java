package test.java;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Vecteur;

public class VecteurTest {

	double[] s1 = { 1, 2, 3, 14 };	
	double[] s2 = { 1, 2, 3};
	
	Vecteur l1 = new Vecteur(s1);	
	Vecteur l2 = new Vecteur(s2);
	Vecteur l3 = new Vecteur(s2);

	
	@Before
	public void setup(){
		l1 = new Vecteur(s1);
		l2 = new Vecteur(s2);
		
	}
	

	@Test
	public void testToString() {

		
		String resAttendu = "[1.0 2.0 3.0 14.0]";
		
		assertTrue(l1.toString().equals(resAttendu));		
	}

	
	// Test Equals
	@Test
	public void equals() {

		double[] s2 = { 1, 2, 3, 14 };		
		
		Vecteur resAttendu = new Vecteur(s2);	
		
		assertEquals(l1,resAttendu);		
		
	}
	
	@Test
	public void equalsSameObject(){
	    assertEquals(l1,l1);
	}
	
	@Test
    public void nonEqualsNull(){
        assertFalse(l1.equals(null));
    }

	@Test
    public void nonEqualsNotSameObject(){
        assertFalse(l1.equals(s1));
    }
	
	@Test
    public void nonEqualsNotSameVecteur(){
        assertFalse(l1.equals(l2));
    }
	
	//Cas normal
	@Test
	public void testSousVecteur2(){
        Vecteur l3=l1.sousVecteur(3);   
        assertEquals(l2,l3);
    }
	
	//Cas exceptionnel
	@Test(expected=IllegalArgumentException.class)
    public void testSousVecteur(){
	    l3=l1.sousVecteur(6);
    }

	
	
	@Test
	public void testVecteurNul(){
	    Vecteur l3= Vecteur.creerVecteurNul(4);
	    for(int i=0;i<l3.taille();i++){
	        assert(l3.getValeur(i)==0);
	    }
	}
	
	@Test
	public void testHashCode(){
	    assertEquals(l1.hashCode(),-1153296480);
	}
}
