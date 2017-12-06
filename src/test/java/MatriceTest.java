/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package test.java;

import static org.junit.Assert.*;

import org.junit.Test;
import main.java.Matrice;
import org.junit.Before;

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
            { -3, 2, -5, 6 }
        };
    double[][] systeme3 = {

            { 3, 5, -3 },
            { 7, 10, 1 },
            { -3, 2, -5}
        };
    double[][] systeme4 = {

            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }
        };
    double[][] systeme6 = {

            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
        };
    Matrice mat = new Matrice(systeme1);
    Matrice mat2 = new Matrice(systeme2);
    Matrice mat3 = new Matrice(systeme3);
    Matrice mat4 = new Matrice(systeme4);
    Matrice mat6 = new Matrice(systeme6);

    @Before
    public void setup()
    {
         mat = new Matrice(systeme1);
         mat2 = new Matrice(systeme2);
         mat3 = new Matrice(systeme3);
         mat4 = new Matrice(systeme4);
         mat6 = new Matrice(systeme6);
    }

    @Test
    public void test()
    {
        assertEquals("[3.0 5.0 -3.0 15.0]\n[7.0 10.0 1.0 2.0]\n[-3.0 2.0 -5.0 6.0]\n", mat.toString());
    }

    @Test
    public void testEquals()
    {
        assertTrue(mat.equals(mat2));
    }

    @Test
    public void testGaussNormal()
    {
       mat.Gauss();

        assertEquals("[1.0 0.0 0.0 4.15625]\n[0.0 1.0 0.0 -2.25]\n[0.0 0.0 1.0 -4.59375]\n", mat.toString());
    }

    @Test
    public void testGaussIdentite()
    {
        mat.Gauss();
        Matrice mat7 = mat.SousMatrice(3,3);
        assertTrue(mat6.equals(mat7));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGaussException() {
    	mat3.Gauss();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSousMatriceException()
    {
    	mat4 = mat.SousMatrice(4,5);
    }

    @Test
    public void testSousMatriceNormal()
    {
    	mat4 = mat.SousMatrice(3,3);
    	assertTrue(mat4.equals(mat3));
    }

    @Test
    public void testCreerMatriceNull()
    {
        Matrice mat5 = Matrice.creerMatriceNul(3,4);
        assertTrue(mat5.equals(mat4));
    }

    @Test
    public void testCreerMatriceIdentiteNormal() {
        mat3.creerMatriceIdentite();
        assertTrue(mat3.equals(mat6));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCreerMatriceIdentiteException() {
        mat.creerMatriceIdentite();
    }

}
