package Jeu;
import Figures.*;
import java.util.ArrayList;

public  class Tour {
    private int numTour;
    private int scoreTour;
    private Lancer L;
    private TableAffichage T;
    private ArrayList<String> figuresDispo = new ArrayList<>();

    public Tour(){
        this.scoreTour = 0;
        this.numTour = 0;
        this.L = new Lancer();
        this.T= new TableAffichage();
    }
    public ArrayList<String> getFigDispo(){
        return this.figuresDispo;
    }

    public Lancer getLance(){
        return this.L;
    }

    public void lancer(){
        this.L.lancer();
    }

    public int getnumTour()
    {
        return this.numTour;
    }

    public int getscoreTour()
    {
        return this.scoreTour;
    }

    public boolean figureMajDisponible(Figure F){

        boolean dispo = false;
        switch (F.getNom().toLowerCase()) {
            
            case "berlan":
                if(F.estBerlan(L.getDes())){
                    dispo = true;
                    figuresDispo.add("Berlan");
                }
                else
                    dispo = false;
                break;

            case "carre":
                if(F.estCarre(L.getDes())){
                    dispo = true;
                    figuresDispo.add("Carre");
                }
                else
                    dispo = false;
                break;

            case "chance":
                if(F.estchance()){
                    dispo = true;
                    figuresDispo.add("Chance");
                }
                else
                    dispo = false;
                break;
            
            case "full":
                if(F.estFull(L.getDes())){
                    dispo = true;
                    figuresDispo.add("Full");
                }
                else
                    dispo = false;
                break;
            
            case "grandesuite":
                if(F.estGrandeSuite(L.getDes())){
                    dispo = true;
                    figuresDispo.add("Grande Suite");
                }
                else
                    dispo = false;
                break;
            
            case "petitesuite":
                if(F.estPetiteSuite(L.getDes())){
                    dispo = true;
                    figuresDispo.add("Petite Suite");
                }
                else
                    dispo = false;
                break;
            
                case "yahtzee":
                    if(F.estYahtzee(L.getDes())){
                        dispo = true;
                        figuresDispo.add("Yahtzee");
                    }
                    else
                        dispo = false;
                    break;   
        }
        return dispo;         
    }

    public boolean figureMinDisponible(FigureMineur F){

        if(F.estCorrecte(L.getDes())){
            String fig = ""+ F.getValDe();
            figuresDispo.add(fig);
            return true;
        }
        else
            return false;

    }

    
    public boolean choisirMajFigure(Figure F){
        if (this.figureMajDisponible(F)){
            this.scoreTour = F.calculerScore(L.getDes());
            F.setPrise();
            remplirTablemaj(F, this.scoreTour);
            this.numTour++;
            return true;
        }
        else
            System.out.println("Impossible de choisir cette figure");
            return false;
    }

    public boolean choisirMinFigure(FigureMineur F){
            
        if(this.figureMinDisponible(F)){
            this.scoreTour = F.calculerScore(L.getDes());
            F.setPrise();
            remplirTablemin(F, this.scoreTour);
            this.numTour++;
            return true;
        }
        else
            System.out.println("Impossible de choisir cette figure");
            return false;
    }

    public void barreFigure(FigureMineur F){
        this.scoreTour = 0;
        F.setPrise();
        remplirTablemaj(F, this.scoreTour);
        remplirTablemin(F, this.scoreTour);
        this.numTour++;
    }

    public void remplirTablemaj(Figure F, int score){
        
        switch (F.getNom().toLowerCase()) {
            
            case "berlan":
                if(F.estBerlan(L.getDes())){
                    T.TableScoresmaj.put("BERLAN",score);
                }
                break;

            case "carre":
                if(F.estCarre(L.getDes())){
                    T.TableScoresmaj.put("CARRE",score);
                }
                break;

            case "chance":
                if(F.estchance()){
                    T.TableScoresmaj.put("CHANCE",score);
                }
                break;
            
            case "full":
                if(F.estFull(L.getDes())){
                    T.TableScoresmaj.put("FULL",score);
                }
                break;
            
            case "grandesuite":
                if(F.estGrandeSuite(L.getDes())){
                    T.TableScoresmaj.put("GRANDE SUITE",score);
                }
                break;
                
            case "petitesuite":
                if(F.estPetiteSuite(L.getDes())){
                    T.TableScoresmaj.put("PETITE SUITE",score);
                }
                break;
            
                case "yahtzee":
                    if(F.estYahtzee(L.getDes())){
                        T.TableScoresmaj.put("YAHTZEE",score);                    }
                    break;   
        }
    }

    public void remplirTablemin(FigureMineur F, int score){
        
        switch (F.getNom().toUpperCase()) {
            
            case "AS":
                if(F.estBerlan(L.getDes())){
                    T.TableScoresmin.put("AS",score);
                }
                break;

            case "DEUX":
                if(F.estCarre(L.getDes())){
                    T.TableScoresmin.put("DEUX",score);
                }
                break;

            case "TROIS":
                if(F.estchance()){
                    T.TableScoresmin.put("TROIS",score);
                }
                break;
            
            case "QUATRES":
                if(F.estFull(L.getDes())){
                    T.TableScoresmin.put("QUATRES",score);
                }
                break;
            
            case "CINQUES":
                if(F.estGrandeSuite(L.getDes())){
                    T.TableScoresmin.put("CINQUES",score);
                }
                break;
                
            case "SIX":
                if(F.estPetiteSuite(L.getDes())){
                    T.TableScoresmin.put("SIX",score);
                }
                break;   
        }


    }


}





   
    

