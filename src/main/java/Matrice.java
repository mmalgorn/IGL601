/*
 * classe modifiee par Melissa L'henoret
 * matricule: 17 148 784
 */

package main.java;

/*
 * Classe repr�sentant une matrice. Compos�e d'une liste
 * de vecteurs. Chaque rang�e de la matrice est un vecteur.
 */
public class Matrice {

	private Vecteur[] lignes;

	public Matrice(double[][] dat) {

		lignes = new Vecteur[dat.length];

		for (int i = 0; i < dat.length; i++) {

			lignes[i] = new Vecteur(dat[i]);

		}
	}
	
	private Matrice(int ligne, int colonne) {
	    double[][] mat = new double[ligne][colonne];
	    lignes = new Vecteur[mat.length];
	    for(int i=0; i<ligne; i++){
	        this.lignes[i] = new Vecteur(mat[i]); 
	    }
	    
	}

	/*
	 * �limination Gaussienne. Let me google that for you... Impl�mentation
	 * suivant le pseudo-code classique.
	 */
	public void Gauss() {

		int noLigne = 0;
		if(this.lignes[0].taille() == (this.tailleMatrice()+1)) {
			for (Vecteur ligne : lignes) {
				double pivot = ligne.getValeur(noLigne);
				if (pivot != 0) {
					double pivotInverse = 1.0 / pivot;
					for (int i = 0; i < ligne.taille(); i++) {
						ligne.setValeur(i, ligne.getValeur(i) * pivotInverse);
					}
				}

				for (Vecteur ligneElim : lignes) {
					if (ligneElim != ligne) {
						double f = ligneElim.getValeur(noLigne);
						for (int i = 0; i < ligneElim.taille(); ++i) {
							ligneElim.setValeur(i, ligneElim.getValeur(i) - f * ligne.getValeur(i));
						}
					}
				}
				noLigne++;
			}
		}
		else throw new IllegalArgumentException("erreur");
	
	}
	
	public String toString() {

		String res = "";

		for (Vecteur v : lignes) {
			res += v + "\n";
		}

		return res;
	}
	
	public int tailleMatrice(){
        return lignes.length;
        
    }

	public boolean equals(Matrice mat){
        boolean resultat = true;
        
        if(this instanceof Matrice){
            
            if(this.tailleMatrice() == mat.tailleMatrice()){
               int i=0;
               while( i<mat.tailleMatrice() && resultat != false){
                   
                   resultat = this.lignes[i].equals(mat.lignes[i],0.01);
                   i++;
               }
                return resultat;
                
            }
        }
        return false;
    }
	
	public Vecteur getLigne(int l) {
		
		return this.lignes[l];
	}
	
	public Matrice SousMatrice(int nbligne, int nbcolonne) {
		double[][] mat = new double[nbligne][nbcolonne];
		
		if(nbligne<=this.tailleMatrice() || nbcolonne<=this.lignes[0].taille() ) {
			for(int i=0; i<nbligne; i++) {
				Vecteur lignes = this.getLigne(i);
				for(int j=0; j<nbcolonne; j++) {
					mat[i][j] = lignes.getValeur(j);
				}
			}
			
			Matrice newmat = new Matrice(mat);
			
			return newmat;
		}
		else throw new IllegalArgumentException("erreur");
	}
	
	public static Matrice creerMatriceNul (int nbligne, int nbcolonne) {
	    Matrice matrice = new Matrice(nbligne, nbcolonne);
	    
	    for(int i=0; i<nbligne; i++){	       
	        for(int j=0; j<nbcolonne; j++){
	            matrice.lignes[i].setValeur(j, 0);
	        }
	    }
	    return matrice;        
	}


	public void setLigne(Vecteur[] lignes) {
		this.lignes = lignes;
	}
	
	public Matrice creerMatriceIdentite(){
	    
	    if(this.tailleMatrice() == this.lignes[0].taille()){
	        for(int i=0; i<this.tailleMatrice(); i++){
	            for(int j=0; j<this.lignes[0].taille(); j++){
	               if(i == j){
	                  this.lignes[i].setValeur(j, 1);
	               }
	               else this.lignes[i].setValeur(j, 0);
	            }
	        }
	        return this;
	    }
	    else throw new IllegalArgumentException("erreur");
	}
}
