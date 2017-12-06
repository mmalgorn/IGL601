package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import labo2.Matrice;
import labo2.Vecteur;

public class FonctionnelTest
{
    
    double[] s1 = { 3, 5, -3, 15 };
    double[] s2 = { 7, 10, 1, 2 };
    double[] s3 = { -3, 2, -5, 6 };
    Vecteur l1 = new Vecteur(s1);
    Vecteur l2 = new Vecteur(s2);
    Vecteur l3 = new Vecteur(s3);

    double[][] systeme2 = {

            { 1.0, 0.0, 0.0,  133./32},
            { 0.0, 1.0, 0.0, -9./4 },
            { 0.0, 0.0, 1.0, -147./32 }
        };
    
    
    @Test
    public void TestUtilisationGauss() {
        
        assertEquals("[3.0 5.0 -3.0 15.0]", l1.toString());
        assertEquals("[7.0 10.0 1.0 2.0]", l2.toString());
        assertEquals("[-3.0 2.0 -5.0 6.0]", l3.toString());

        Vecteur tab[]= {l1,l2,l3};
        Matrice mat = new Matrice(tab);
        assertEquals("[3.0 5.0 -3.0 15.0]\n[7.0 10.0 1.0 2.0]\n[-3.0 2.0 -5.0 6.0]\n", mat.toString());
        
        mat.Gauss();
        double[][] systeme2 = {

                { 1.0, 0.0, 0.0,  133./32},
                { 0.0, 1.0, 0.0, -9./4 },
                { 0.0, 0.0, 1.0, -147./32 }
            };
        Matrice resAttendu = new Matrice(systeme2);
        
        assertEquals(mat,resAttendu); 
    }
    
}
