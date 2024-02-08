package Figures;

import Jeu.De;

public class FigureMineur extends Figure {
    
    private int ValDe;
    
    public FigureMineur(String name , int valde) {
        super(name);
        this.ValDe = valde;
    }

    public int getValDe(){
        return this.ValDe;
    }

    
    

    public boolean estCorrecte(De[] des) {
        if(!this.estPrise()){
            for (De d : des) {
                // Verifie si l'entier existe dans le tableau
                if (d.getValeur() == this.getValDe()) {
                    return true; 
                }
            }
        }
        // Si l'entier n'est pas trouve apres avoir parcouru toute la figure, retourne faux
        return false;
    }
    
    @Override
    public int calculerScore(De[] des) {
        int somme = 0;

        // Parcourt le tableau
        for (De d : des) {
            // Si la valeur correspond à l'entier spécifie, l'ajoute a la somme
            if (d.getValeur() == this.getValDe()) {
                somme += d.getValeur();
            }
        }

        return somme;
    }



    
}
