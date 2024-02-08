package Jeu;
import Figures.*;
import java.util.ArrayList;

public  class Tour {
    private int numTour;
    private int scoreTour;
    private Lancer L;
    ArrayList<String> figuresDispo = new ArrayList<>();

    public Tour(){
        this.scoreTour = 0;
        this.numTour = 0;
        this.L = new Lancer();
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
                }
                else
                    dispo = false;
                break;

            case "carre":
                if(F.estCarre(L.getDes())){
                    dispo = true;
                }
                else
                    dispo = false;
                break;

            case "chance":
                if(F.estchance()){
                    dispo = true;
                }
                else
                    dispo = false;
                break;
            
            case "full":
                if(F.estFull(L.getDes())){
                    dispo = true;
                }
                else
                    dispo = false;
                break;
            
            case "grandesuite":
                if(F.estGrandeSuite(L.getDes())){
                    dispo = true;
                }
                else
                    dispo = false;
                break;
            
            case "petitesuite":
                if(F.estPetiteSuite(L.getDes())){
                    dispo = true;
                }
                else
                    dispo = false;
                break;
            
                case "yahtzee":
                    if(F.estYahtzee(L.getDes())){
                        dispo = true;
                    }
                    else
                        dispo = false;
                    break;   
        }
        return dispo;         
    }

    public boolean figureMinDisponible(FigureMineur F){

        if(F.estCorrecte(L.getDes())){
            return true;
        }
        else
            return false;

    }

    
    public void choisirMajFigure(Figure F){
        if (this.figureMajDisponible(F)){
            this.scoreTour = F.calculerScore(L.getDes());
                    F.setPrise();
                    this.numTour++;
        }
        else
            System.out.println("Impossible de choisir cette figure");
    }

    public void choisirMinFigure(FigureMineur F){
            
        if(this.figureMinDisponible(F)){
            this.scoreTour = F.calculerScore(L.getDes());
            F.setPrise();
            this.numTour++;
        }
        else
            System.out.println("Impossible de choisir cette figure");
    }

    public void barreFigure(Figure F){
        F.setPrise();
        this.numTour++;
    }


}





   
    

