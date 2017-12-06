package main.java;

import java.util.Arrays;

/*
 * Classe representant un vecteur. 
 */

public class Vecteur {
    
    //ATTRIBUTS
    
    private double valeurs[];
    
    
    //CONSTRUCTEURS 
    
    //Avec tableau de valeurs
    public Vecteur(double [] valeurs){
        
        this.valeurs = new double[valeurs.length];
        for(int i=0;i<valeurs.length;i++){
            
            this.valeurs[i]=valeurs[i];         
        }       
    }
    
    //Avec une taille, (n'initialise pas les valeurs)
    private Vecteur(int taille){
        this.valeurs = new double[taille];
    }
    
    
    //METHODE DE CLASSES
    
    public static Vecteur creerVecteurNul(int taille){
        Vecteur vec= new Vecteur(taille);
        for(int i=0;i<taille;i++){
            vec.valeurs[i]=0;
        }
        return vec;
    }
     
    
    //ACCESSEURS ET INFOS
    
    public int taille(){
        return valeurs.length;
    }
    
    public double getValeur(int pos){
        return valeurs[pos];
    }
    
    public void setValeur(int pos,double val){
        valeurs[pos]=val;
    }

    
    //METHODES
    
    //Retourne un sous-vecteur de la longueur désirée
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

    
    //OVERRIDES
    
    @Override
    public String toString(){
        
        String res="[";
        for (double v:valeurs){
            res+=v+" ";
        }
        return  res.substring(0, res.length()-1)+"]";
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(valeurs);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
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
