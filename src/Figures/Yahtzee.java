package Figures;
import Jeu.De;

public class Yahtzee extends Figure {
    
    private int score;

    public Yahtzee() {
        super("yahtzee");
        this.score = 50;
    }

    @Override
    public boolean estPrise() {
        return false;
    }

    public int getScore(){
        return this.score;
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
