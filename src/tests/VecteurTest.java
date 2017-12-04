package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import geo.Vecteur;

public class VecteurTest {

    double[] s1 = { 1, 2, 3, 14 };          
    Vecteur l1 = new Vecteur(s1);   
    
    
    @Before
    public void setup(){
        
                
        l1 = new Vecteur(s1);   
        
    }
    @Test
    public void testToString() {

        
        String resAttendu = "[1.0 2.0 3.0 14.0]";
        
        assertTrue(l1.toString().equals(resAttendu));
        
        
        
    }
    
    @Test
    public void testEquals() {

        double[] s2 = { 1, 2, 3, 14 };      
        
        Vecteur resAttendu = new Vecteur(s2);   
        
        assertEquals(l1,resAttendu);        
        
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testSousVecteur(){
        Vecteur l2=l1.sousVecteur(6);   
    }
    
    @Test
    public void testVecteurNul(){
        Vecteur l2=new Vecteur(4);
        for(int i=0;i<l2.taille();i++){
            assert(l2.getValeur(i)==0);
        }
    }
    private Vecteur Vecteur(int i)
    {
        // TODO Auto-generated method stub
        return null;
    }

}

