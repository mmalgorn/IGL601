/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package test.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import main.java.Vecteur;


public class VecteurTest
{
    
    double[] s1 = { 1, 2, 3, 14 };
    double[] s2 = { 1, 2, 3, 14 };
    double[] s3 = { 1, 2 };
    double[] s4 = { 0, 0, 0, 0 };
    
    Vecteur l1 = new Vecteur(s1);
    Vecteur l2 = new Vecteur(s2);
    Vecteur l3 = new Vecteur(s3);
    Vecteur l4 = new Vecteur(s4);
    
    @Before
    public void setup(){
        l1 = new Vecteur(s1);
        l2 = new Vecteur(s2);
        l3 = new Vecteur(s3);
        l4 = new Vecteur(s4);
    }
    

    
    @Test
    public void test()
    {
        assertEquals("[1.0 2.0 3.0 14.0]", l1.toString());
      
    }
    
    @Test
    public void testEquals()
    {
        assertTrue(l1.equals(l2,0.01));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testSousVecteurException() 
    {
        	
    	l4 = l1.SousVecteur(5);
    	

    }
    
    @Test
    public void testVecteurNormal() {
    	l4 = l1.SousVecteur(2);
    	assertTrue(l4.equals(l3,0.01));
    }
	
    @Test
    public void testCreerVecteurNull() 
    {
        Vecteur l5 = Vecteur.creerVecteurNul(4);
        int taille = 4;
        
        for(int i=0; i<taille; i++){
            assertEquals(l5.getValeur(i), 0,0.01);
        }
    }
}
