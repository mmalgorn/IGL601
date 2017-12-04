package test.java;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.java.Matrice;

public class MatriceTest
{
    double[][] systeme1 = {

            { 3, 5, -3, 15 },
            { 7, 10, 1, 2 },
            { -3, 2, -5, 6 }
        };
    
    double[][] systeme2 = {

            { 3, 5, -3, 15 },
            { 7, 10, 1, 2 },
            { -3, 2, -5, 6 },
            { -3, 2, -5, 6 }
        };
    
    
    Matrice m1 = new Matrice(systeme1);
    Matrice m2 = new Matrice(systeme2);
    
    @Before
    public void setup(){
        Matrice m1 = new Matrice(systeme1);
        Matrice m2 = new Matrice(systeme2);
    }
    
    
    
    @Test
    public void testToString()
    {
        
        
        String resAttendu = "[3.0 5.0 -3.0 15.0]\n[7.0 10.0 1.0 2.0]\n[-3.0 2.0 -5.0 6.0]\n";
        
        assertTrue(m1.toString().equals(resAttendu));
    }
    
   
    
    @Test
    public void testEquals() {
        double[][] systeme2 = {

                { 3, 5, -3, 15 },
                { 7, 10, 1, 2 },
                { -3, 2, -5, 6 }
            };
        
        Matrice resAttendu = new Matrice(systeme2);
        
        assertEquals(m1,resAttendu);        

    }
    
    
    
    @Test
    public void testGauss()
    {
    m1.Gauss();
    double[][] systeme2 = {

            { 1.0, 0.0, 0.0,  133./32},
            { 0.0, 1.0, 0.0, -9./4 },
            { 0.0, 0.0, 1.0, -147./32 }
        };
    Matrice resAttendu = new Matrice(systeme2);
    
    assertEquals(m1,resAttendu); 
    }
    
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testSousMatrice(){
        Matrice m3=m1.sousMatrice(6,6);
    }
    
    
    
    @Test
    public void testMatriceNul(){
        
        Matrice m3=new Matrice(4,4);
        
        for(int i=0;i<m3.nombreLigne();i++){
            
            for(int j=0;j<m3.nombreColonne();j++){
                
                assert(m3.getLigne(i).getValeur(j)!=0);
            }
        }               
    }
    
    
    
    @Test
    public void testContenuMatriceIdentite(){
        m2=m2.creerMatId();
        for (int i=0;i<m2.nombreLigne();i++){
            for (int j=0;j<m2.nombreColonne();j++){
                if (i==j){
                    assertEquals(m2.getLigne(i).getValeur(j),1.,0.01);
                }
                else {
                    assertEquals(m2.getLigne(i).getValeur(j),0.,0.01);                           //JE NE COMPREND PAS, KESSECÃ‰...???
                }
            }
        }
    }
    
    
    
    @Test(expected=IllegalArgumentException.class)
    public void testCreationMatriceIdentite(){
        m1.creerMatId();
    }
    
    
    @Test
    public void testVerifGaussEstMatId(){
        m1.Gauss();
        m1=m1.sousMatrice(3, 3);
        m2=m2.creerMatId();
        m2=m2.sousMatrice(3, 3);
        assertEquals(m1,m2);
    }
    
    
    
    
}
