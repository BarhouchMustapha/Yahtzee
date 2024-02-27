package Jeu;
import java.util.ArrayList;
import java.util.Scanner;

public class Lancer {
    
    private De[] des;
    Scanner scanner = new Scanner(System.in);
    
    

    public Lancer(){
        this.des = new De[5];
    }

    public De[] getDes(){
        return this.des;
    }



    public void lancer(){

        De d_1 = new De();
        De d_2 = new De();
        De d_3 = new De();
        De d_4 = new De();
        De d_5 = new De();
    
        this.des[0] = d_1; 
        this.des[1] = d_2; 
        this.des[2] = d_3; 
        this.des[3] = d_4; 
        this.des[4] = d_5;
    }

    public void relancer(ArrayList<Integer> vals){
        De d;
        for (int val : vals) {
            d = debyVal(val);
            
            for(int i=0;i<5;i++){
                if(this.des[i].getValeur() == d.getValeur()){
                    this.des[i].lancer();
                }
            }
        }   
    }

    public De debyVal(int valeur) {
        De de = null;
    
        boolean valide = false;
        while (!valide) {
            for (De d : des) {
                if (d.getValeur() == valeur) {
                    de = d;
                    valide = true;
                    break; // Sortir de la boucle for une fois que le dé est trouvé
                }
            }
    
            if (!valide) {
                System.out.println("La valeur que vous avez saisie ne correspond à aucun dé existant.");
                System.out.println("Veulliez entrer à nouveau la valeur d'un dé existant :");
                valeur = this.scanner.nextInt();
            }
        }
    
        return de;
    }
    
    


}
