package Jeu;

import java.util.HashMap;
import java.util.Map;
public class TableAffichage {

    private Map<String, Integer> TableScoresmin = new HashMap<>(6);
    private Map<String, Integer> TableScoresmaj = new HashMap<>(7);
    private Map<String, Integer> TableAffich = new HashMap<>(2);
    
    private int scorePartie;
    private int bonus;

    public TableAffichage(){
        this.TableScoresmin.put("AS",null);
        this.TableScoresmin.put("DEUX",null);
        this.TableScoresmin.put("TROIS",null);
        this.TableScoresmin.put("QUATRES",null);
        this.TableScoresmin.put("CINQUES",null);
        this.TableScoresmin.put("SIX",null);

        this.TableAffich.put("Total fmin",null);

        this.TableScoresmaj.put("BERLAN",null);
        this.TableScoresmaj.put("CARRE",null);
        this.TableScoresmaj.put("FULL",null);
        this.TableScoresmaj.put("PETITE SUITE",null);
        this.TableScoresmaj.put("GRANDE SUITE",null);
        this.TableScoresmaj.put("YAHTZEE",null);
        this.TableScoresmaj.put("CHANCE",null);
        this.bonus = 0;
        this.TableAffich.put("Total fmaj",null);

        this.scorePartie = 0;
    }

    public int getScorePartie(){
        return this.scorePartie;
    }

    public void afficherTable(){
       
        System.out.println("Figures Mineures:");
        for (String key : TableScoresmin.keySet()) {
            System.out.println(key + ": " + TableScoresmin.get(key));
        }
        System.out.println( "Bonus +35 " + this.bonus);
        System.out.println( "Total figures mineurs: " + TableAffich.get("Total fmin")+"\n");


        System.out.println("Figures Majeurs:");
        for (String key : TableScoresmaj.keySet()) {
            System.out.println(key + ": " + TableScoresmaj.get(key));
        }
        System.out.println( "Total figures majeurs: " + TableAffich.get("Total fmaj")+"\n");
        System.out.println( "Total de la Partie: "+ this.getScorePartie() );
    }

    public void ajouterBonus(){
        int sommemin = 0;
        for (String key : TableScoresmin.keySet()) {
            if (TableScoresmin.get(key) != null){
                sommemin += TableScoresmin.get(key);
            }
        }
        if (sommemin >= 63 ){
            this.bonus = 35;
        }
    }

    public void claculerTotals(){
        int totalmin=0;
        int totalmaj=0;


        for (String key : TableScoresmin.keySet()) {
            if (TableScoresmin.get(key) != null){
                totalmin += TableScoresmin.get(key);
            }
        }

        for (String key : TableScoresmaj.keySet()) {
            if (TableScoresmaj.get(key) != null){
                totalmaj += TableScoresmin.get(key);
            }
        }

        this.TableAffich.put("Total fmin", totalmin);
        this.TableAffich.put("Total fmaj", totalmaj);
        this.scorePartie = totalmaj + totalmin;
    }

    
    



    
    
}
