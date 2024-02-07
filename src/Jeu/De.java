package Jeu;
import java.util.*;

public class De implements Comparable<De> {
    private int valeur;
    private final Random random;

    public De() {
        random = new Random();
        lancer(); // Lance le dé lors de création d'un objet
    }

    public void lancer() {
        this.valeur = random.nextInt(6) + 1; // génerer un nombre entre 1 et 6
    }

    public int getValeur() {
        return this.valeur;
    }

    public int compareTo(De autreDe) {   // Compare les valeurs des dés pour le tri 
        
        return Integer.compare(this.valeur, autreDe.valeur);
    }
}
