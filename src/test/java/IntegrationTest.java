package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.Matrice;
import main.java.Vecteur;

public class IntegrationTest
{

    
    double[] s1 = { 1, 2, 3, 14 };
    double[] s2 = { 15, 4, 8, 9 };
    Vecteur l1 = new Vecteur(s1);
    Vecteur l2 = new Vecteur(s2);
    
     @Before
        public void setup(){
            l1 = new Vecteur(s1);
            l2 = new Vecteur(s2);
     }
           
    
    @Test
    public void TestIntegration1() {
        
        assertEquals("[1.0 2.0 3.0 14.0]", l1.toString());
        assertEquals("[15.0 4.0 8.0 9.0]", l2.toString());
    }
    
    @Test
    public void TestIntegration2() {
        
        assertEquals("[1.0 2.0 3.0 14.0]", l1.toString());
        assertEquals("[15.0 4.0 8.0 9.0]", l2.toString());
        Vecteur tab[]= {l1,l2};
        Matrice mat = new Matrice(tab);
        assertEquals("[1.0 2.0 3.0 14.0]\n[15.0 4.0 8.0 9.0]\n", mat.toString());
    }
    
}
