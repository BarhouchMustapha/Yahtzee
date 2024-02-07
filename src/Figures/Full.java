package Figures;

import Jeu.De;

public class Full extends Figure {

    private int score;

    public Full() {
        super("full");
        this.score = this.calculerScore();
    }


    public int getScore(){
        return this.score;
    }

    
    public int calculerScore(){
        return 25;
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

}
