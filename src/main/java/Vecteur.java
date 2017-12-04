/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package main.java;

import java.util.ArrayList;

/*
 * Classe repr�sentant un vecteur. 
 */

public class Vecteur {
	
	private double valeurs[];
	
	
	public Vecteur(double [] valeurs){
		
		this.valeurs = new double[valeurs.length];
		for(int i=0;i<valeurs.length;i++){
			
			this.valeurs[i]=valeurs[i];			
		}		
	}
	
	public Vecteur(ArrayList<Integer> coefficients){
				
		this.valeurs = new double[coefficients.size()];
		for(int i=0;i<coefficients.size();i++){
			
			this.valeurs[i]=coefficients.get(i);			
		}		
	}
	
	public void ajouter(int e ) {
		
		
		double Tab[] = new double[this.taille()+1];
		
		for(int i=0; i<this.taille(); i++) {
			Tab[i] = this.getValeur(i);
		}
		
		Tab[this.taille()] = e;
		
		this.valeurs = Tab;
			
	}
	
	public Vecteur() {
	    
		   this.valeurs = new double[0];
			
	}
	
	private Vecteur(int taille) {
	    
	   this.valeurs = new double[taille];
		
	}

	public String toString(){
		
		String res="[";
		for (double v:valeurs){
			res+=v+" ";
		}
		return  res.substring(0, res.length()-1)+"]";
	}
	
	public int taille(){
		return valeurs.length;
	}
	
	public double getValeur(int pos){
		return valeurs[pos];
	}
	
	public void setValeur(int pos,double val){
		valeurs[pos]=val;
	}

	
	public boolean equals(Vecteur vec, double epsilon){
        boolean resultat = true;
        
	    if(this instanceof Vecteur){
	        if(this.taille() == vec.taille()){
	           int i=0;
	           while( i<this.taille() && resultat != false){	           
	               resultat = egaliteDoublePrecision(this.getValeur(i),vec.getValeur(i),epsilon);
	               
	               i++;	           
	           }
	            return resultat;
	            
	        }
	    }
	    return false;
	}
	
	public static boolean egaliteDoublePrecision(double a, double b, double epsilon)
	{ 
	    return (Math.abs(a-b) <= epsilon); 
	}
	
	public Vecteur SousVecteur(int nbelement){
		
		double valeurs2[] = new double [nbelement];		
		
		if(nbelement<this.taille()) {
			for(int i=0; i<nbelement; i++) {
				valeurs2[i]=this.getValeur(i);
			}
		
			Vecteur newvecteur = new Vecteur(valeurs2);
			return newvecteur;
		}
		else throw new IllegalArgumentException("erreur");
	}
	
	public static Vecteur creerVecteurNul (int taille) {
		Vecteur vecteur = new Vecteur(taille);
		
		for(int i=0; i<taille; i++) {
			vecteur.valeurs[i] = 0;
		}
		
		return vecteur;
	}
	
}
