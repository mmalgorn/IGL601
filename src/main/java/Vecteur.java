package main.java;
import java.util.Arrays;

/*
 * Classe representant un vecteur. 
 */

public class Vecteur {
    
    //Attributs
    
    private double valeurs[];
    
    //Constructeurs et methode de construction vide??
    
    //Avec tableau de valeurs
    public Vecteur(double [] valeurs){
        
        this.valeurs = new double[valeurs.length];
        for(int i=0;i<valeurs.length;i++){
            
            this.valeurs[i]=valeurs[i];         
        }       
    }
    
    //Avec une taille, (remplis de 0)
    public Vecteur(int taille){
        this.valeurs = new double[taille];
        for(int i=0;i<taille;i++){
            this.valeurs[i]=0;         
        }       
    }
    
    //Accesseurs et infos
    
    public int taille(){
        return valeurs.length;
    }
    
    public double getValeur(int pos){
        return valeurs[pos];
    }
    
    public void setValeur(int pos,double val){
        valeurs[pos]=val;
    }

    //Methodes
    
    public Vecteur sousVecteur(int longueurvoulue){
        if(longueurvoulue>valeurs.length){
            throw new IllegalArgumentException("Reduction de vecteur non autorisÃ©e");
        }
        else{
            double[] s1 = new double[longueurvoulue] ;
            for(int i=0;i<longueurvoulue;i++){
                s1[i]=valeurs[i];
            }
            Vecteur res = new Vecteur(s1);
            return res;
        }
        
    }

    //Surcharges
    
    @Override
    public String toString(){
        
        String res="[";
        for (double v:valeurs){
            res+=v+" ";
        }
        return  res.substring(0, res.length()-1)+"]";
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vecteur other = (Vecteur) obj;
        if (!Arrays.equals(valeurs, other.valeurs))
            return false;
        return true;
    }

}
