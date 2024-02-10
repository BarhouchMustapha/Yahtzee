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

    public TableAffichage getTableAffichage(){
        return this.T;
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

    public void listeDispo(Figure F){

        switch (F.getNom().toLowerCase()) {
            
            case "berlan":
                if(F.estBerlan(L.getDes())){
                    figuresDispo.add("Berlan");
                }
                break;

            case "carre":
                if(F.estCarre(L.getDes())){
                    figuresDispo.add("Carre");
                }
                break;

            case "chance":
                if(F.estchance()){
                    figuresDispo.add("Chance");
                }
                break;
            
            case "full":
                if(F.estFull(L.getDes())){
                    figuresDispo.add("Full");
                }
                break;
            
            case "grandesuite":
                if(F.estGrandeSuite(L.getDes())){
                    figuresDispo.add("Grande Suite");
                }
                break;
            
            case "petitesuite":
                if(F.estPetiteSuite(L.getDes())){
                    figuresDispo.add("Petite Suite");
                }
                break;
            
                case "yahtzee":
                    if(F.estYahtzee(L.getDes())){
                        figuresDispo.add("Yahtzee");
                    }
                    break;   
        }  
        if (F instanceof FigureMineur){
            FigureMineur Fmin =  (FigureMineur) F;
            if(Fmin.estCorrecte(L.getDes())){
                String fig = ""+ Fmin.getValDe();
                figuresDispo.add(fig);
            } 

        }
    }


    public boolean figureDisponible(Figure F){

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
        if (F instanceof FigureMineur){
            FigureMineur Fmin =  (FigureMineur) F;
            if(Fmin.estCorrecte(L.getDes())){
                dispo =  true;
            }
            else
                dispo =  false;
        }

        return dispo;         
    }


    
    public boolean choisirFigure(Figure F){
        boolean choix = false;
        if (this.figureDisponible(F)){
            this.scoreTour = F.calculerScore(L.getDes());
            F.setPrise();
            remplirTablemaj(F, this.scoreTour);
            this.numTour++;
            choix = true;
        }

        if  (F instanceof FigureMineur) {
            FigureMineur Fm =  (FigureMineur)F; 
            if(this.figureDisponible(Fm)){
                this.scoreTour = F.calculerScore(L.getDes());
                F.setPrise();
                remplirTablemin(Fm, this.scoreTour);
                this.numTour++;
                choix =  true;
            }
            
        }

        return choix;
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





   
    

