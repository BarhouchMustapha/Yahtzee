package Figures;

import java.util.Arrays;

import Jeu.De;

public class GrandSuite extends Figure {
    private int score;

    public GrandSuite() {
        super("grandsuite");
        this.score = 30;
    }

    public int getScore() {
        return this.score;
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
    
}
