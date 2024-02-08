package Figures;
import java.util.Arrays;

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
        switch(this.nom.toLowerCase()){
            case "berlan" , "carre", "chance":
                for (De d : des){
                    score += d.getValeur(); // calculer le score pour Berlan, carre et chance
                }
                break;

            case "full":
                score = 25;
                break;
            
            case "grandesuite" :
                score = 40;
                break;
            
            case "petitesuite" :
                score = 30;
                break;
            
            case "yahtzee" :
                score = 50;
                break;
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
                if (!this.estPrise()) {
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
                if (!this.estPrise()) {
                    return true;
                }            
            }
        }
        return false;
    }

    public boolean estchance(){
        if (!this.estPrise()) {
            return true;
        } 
        return false;
    }

    public boolean estFull(De[] des){
        boolean Berlan = false;
        boolean Deuxmemesval = false;
        int valBerlan = 0;
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (De d : des) { // Comparer tous les des avec 1 juqu'à 6 
                if (d.getValeur() == i) { 
                    count++;  // Incrémenter count à chaque fois que la valeur de de est egale à i
                }
            }
            if (count == 3) { 
                valBerlan = i; // La valeur de Berlan (de qu'on a 3fois)
                Berlan = true;
                break;
            }
        }

        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (De d : des) { // Comparer tous les des avec 1 juqu'à 6 
                if (d.getValeur() == i && d.getValeur() != valBerlan) { // verification si la valeur de de n'est pas la meme de Berlan
                    count++;  // Incrémenter count à chaque fois que la valeur de de est egale à i
                }
            }
            if (count == 2) { 
                Deuxmemesval = true;
            }
        }

        return Berlan && Deuxmemesval;
    }

    public boolean estGrandeSuite(De[] des) {
        // Trier les de pour faciliter la verification
        Arrays.sort(des);

        for (int i = 0; i < des.length - 1; i++) {
            if (des[i + 1].getValeur() - des[i].getValeur() != 1) {
                return false; // Si la difference n'est pas de 1, ce n'est pas une suite
            }
        }
        return true; // Si la boucle se termine, c'est une suite croissante
    }

    public boolean estPetiteSuite(De[] des) {
        // Trier les des pour faciliter la verification
        Arrays.sort(des);

        int count = 0; // Compteur pour suivre le nombre de des consecutifs
        for (int i = 0; i < des.length - 1; i++) {
            // Verifie si la difference entre chaque de adjacent est egale à 1
            if (des[i + 1].getValeur() - des[i].getValeur() == 1) {
                count++; // Incremente le compteur si la difference est de 1
                if (count >= 3) { // Si nous avons au moins trois des consecutifs
                    return true; // Retourne true, car les quatre des forment une suite
                }
            } else {
                count = 0; // Reinitialise le compteur si la difference n'est pas de 1
            }
        }
        return false; // Si la boucle se termine, aucun suite de 4 des n'a ete trouvee
    }

    public boolean estYahtzee(De[] des){
        for (int i = 1; i <= 6; i++) {
            int count = 0;
            for (De d : des) { // Comparer tous les des avec 1 juqu'à 6 
                if (d.getValeur() == i) { 
                    count++;  // Incrémenter count à chaque fois que la valeur de de est egale à i
                }
            }
            if (count == 5) { 
                return true;
            }
        }
        return false;
    }


}
