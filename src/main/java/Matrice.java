package main.java;

import java.util.Arrays;

/*
 * Classe representant une matrice. Composee d'une liste
 * de vecteurs. Chaque rangee de la matrice est un vecteur.
 */
public class Matrice {

    //ATTRIBUT   
    
    private Vecteur[] lignes;
     
  
    //CONSTRUCTEURS
     
    //Avec tableau de vecteur
     public Matrice(Vecteur[] lignes)
    {
        this.lignes = lignes;
    }
    
    //Avec tableau de valeurs
    public Matrice(double[][] dat) {

        lignes = new Vecteur[dat.length];

        for (int i = 0; i < dat.length; i++) {

            lignes[i] = new Vecteur(dat[i]);

        }
    }
    
    //Avec tailles, sans initialiser
    private Matrice(int ligne, int colonne){
       double[][] mat = new double[ligne] [colonne];
        lignes = new Vecteur[ligne];
        for (int i = 0; i < ligne; i++) {
            this.lignes[i] = new Vecteur(mat[i]);
        }
    }
      
    
    //METHODE DE CLASSES
         
    //Constructeur avec taille (remplis de 0)
    public static Matrice creerMatriceNul(int ligne,int colonne){
        Matrice m0 = new Matrice(ligne,colonne);     
        
        for (int i=0;i<ligne;i++){
            for(int j=0; j<colonne;j++){
                m0.lignes[i].setValeur(j,0);
            }
        }
        return m0;
    }

    
    //ACCESSEURS ET INFOS   

    public int nombreLigne(){
        return lignes.length;
    }
       
    public int nombreColonne(){
        return lignes[0].taille();
    }
    
    public Vecteur getLigne(int i){
        return lignes[i];
    }

    
    //METHODES
    
    /*
     * elimination Gaussienne. Let me google that for you... Implementation
     * suivant le pseudo-code classique.
     */
    public void Gauss() {
        if (lignes[0].taille()-1!=lignes.length){
            throw new IllegalArgumentException("Gauss impossible : La matrice n'est pas de la bonne dimension");
        }
        int noLigne = 0;
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
    
    //Renvoie une sous matrice de la taille demandé
    public Matrice sousMatrice(int nombreligne,int nombrecolonne){
        if(nombreligne >lignes.length || nombrecolonne>lignes[0].taille() ){
            throw new IllegalArgumentException("Reduction de matrice non autorisÃ©e(mauvaise valeurs)");
        }
        else{
            double[][] systeme1 = new double[nombreligne][nombrecolonne];
            for (int i=0;i<nombreligne;i++){
                for (int j=0;j<nombrecolonne;j++){
                   systeme1[i][j]= lignes[i].getValeur(j);
                }
                    
            }
            Matrice res = new Matrice(systeme1);
            return res;
        }
    }
    
    //Renvoie une matrice identite de la taille de la matrice courante 
    public Matrice creerMatId(){
        if (nombreLigne()!=nombreColonne()){
            throw new IllegalArgumentException("La matrice identite doit etre carre");
        }
        else{
            Matrice mat=creerMatriceNul(nombreLigne(),nombreColonne());
            for(int i=0;i<nombreLigne();i++){
                mat.lignes[i].setValeur(i,1);
            }
            return mat;
            }
    }
    
    
    //OVERRIDE       
    
    @Override
    public String toString() {

        String res = "";

        for (Vecteur v : lignes) {
            res += v + "\n";
        }

        return res;
    }
    
    @Override
    public boolean equals(Object obj)
    {
    	//test
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matrice other = (Matrice) obj;
        if (!Arrays.equals(lignes, other.lignes))
            return false;
        return true;
    }

}