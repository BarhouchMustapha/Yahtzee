package Figures;

import Jeu.De;


public class Figure {

    private String nom;
    private boolean prise;
    

    public Figure(String nom) {
        this.nom = nom;
        this.prise = false;
    }
    
    public String getNom() {
        return this.nom;
    }

    public boolean estPrise() {
        return prise;
    }

    public void setPrise(){
        this.prise = true;
    }

    public int calculerScore(De[] des){
        int score = 0;

        for (De d : des){
            score += d.getValeur(); // calculer le score pour Berlan, carre et chance
        }

        return score;
    }

    public boolean estBerlan(De[] des){
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (De d : des) { // Comparer tous les des avec 1 juqu'à 6 
                if (d.getValeur() == i) { 
                    count++;  // Incrémenter count à chaque fois que la valeur de de est egale à i
                }
            }
            if (count >= 3) { 
                if (this.prise == false) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estCarre(De[] des){
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (De d : des) { // Comparer tous les des avec 1 juqu'à 6 
                if (d.getValeur() == i) {
                    count++;  // Incrémenter count à chaque fois que la valeur de de est egale à i
                }
            }
            if (count >= 4) {
                if (this.prise == false) {
                    return true;
                }            
            }
        }
        return false;
    }

    public boolean estchance(De[] des){
        if (this.prise == false) {
            return true;
        } 
        return false;
    }

}
