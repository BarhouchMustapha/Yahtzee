package Figures;

import java.util.Arrays;

import Jeu.De;

public class PetiteSuite extends Figure {

    private int score;

    public PetiteSuite() {
        super("petitesuite");
        this.score = 30;
    }

    public int getScore() {
        return this.score;
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


    

}
