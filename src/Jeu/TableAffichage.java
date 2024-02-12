package Jeu;

import java.util.HashMap;
import java.util.Map;

public class TableAffichage {

    public Map<String, Integer> TableScoresmin = new HashMap<>(6);
    public Map<String, Integer> TableScoresmaj = new HashMap<>(7);
    public Map<String, Integer> TableAffich = new HashMap<>(2);

    private int scorePartie;
    private int bonus;

    public TableAffichage() {
        this.TableScoresmin.put("AS", 0);
        this.TableScoresmin.put("DEUX", 0);
        this.TableScoresmin.put("TROIS", 0);
        this.TableScoresmin.put("QUATRES", 0);
        this.TableScoresmin.put("CINQUES", 0);
        this.TableScoresmin.put("SIX", 0);

        this.TableAffich.put("Total fmin", 0);

        this.TableScoresmaj.put("BERLAN", 0);
        this.TableScoresmaj.put("CARRE", 0);
        this.TableScoresmaj.put("FULL", 0);
        this.TableScoresmaj.put("PETITESUITE", 0);
        this.TableScoresmaj.put("GRANDESUITE", 0);
        this.TableScoresmaj.put("YAHTZEE", 0);
        this.TableScoresmaj.put("CHANCE", 0);
        this.bonus = 0;
        this.TableAffich.put("Total fmaj", 0);

        this.scorePartie = 0;
    }

    public Map<String, Integer> getTmaj() {
        return this.TableScoresmaj;
    }

    public Map<String, Integer> getTmin() {
        return this.TableScoresmin;
    }

    public int getScorePartie() {
        return this.scorePartie;
    }

    public void ajouterBonus() {
        int sommemin = 0;
        for (String key : TableScoresmin.keySet()) {
            if (TableScoresmin.get(key) != null) {
                sommemin += TableScoresmin.get(key);
            }
        }
        if (sommemin >= 63) {
            this.bonus = 35;
        }
    }

    public void claculerTotals() {
        int totalmin = 0;
        int totalmaj = 0;

        for (String key : TableScoresmin.keySet()) {
            if (TableScoresmin.get(key) != null) {
                totalmin += TableScoresmin.get(key);
            }
        }

        for (String key : TableScoresmaj.keySet()) {
            if (TableScoresmaj.get(key) != null) {
                totalmaj += TableScoresmaj.get(key);
            }
        }

        this.TableAffich.put("Total fmin", totalmin);
        this.TableAffich.put("Total fmaj", totalmaj);
        this.scorePartie = totalmaj + totalmin;
    }

    public String affTable() {
        String table = "----------------------------Figeurs Mineurs-------------------------- : \n";
        for (Map.Entry<String, Integer> entry : TableScoresmin.entrySet()) {
            table += "-" + entry.getKey() + " : " + entry.getValue() + "\n";
        }
        table += "-Bonus +35 : " + this.bonus + "\n";
        table += "-Total figures mineurs : " + TableAffich.get("Total fmin") + "\n";
        table += "-------------------------------Figeurs Majeurs------------------------------ \n";
        for (Map.Entry<String, Integer> entry : TableScoresmaj.entrySet()) {
            table += "-" + entry.getKey() + " : " + entry.getValue() + "\n";
        }
        table += "-Total figures majeurs : " + TableAffich.get("Total fmaj") + "\n";
        table += "-Total de jeu : " + this.scorePartie + "\n";
        table += "------------------------------Fin de Jeu-------------------------------------";
        return table;
    }

}
