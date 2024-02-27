package Jeu;
import Figures.*;
import java.util.ArrayList;

public  class Tour {
    private int numTour;
    private int scoreTour;
    private Lancer L;
    private TableAffichage T;
    private ArrayList<String> figuresDispo = new ArrayList<>();
    private ArrayList<String> figuresNPrise = new ArrayList<>();

    public Tour(){
        this.scoreTour = 0;
        this.numTour = 0;
        this.L = new Lancer();
        this.T= new TableAffichage();
    }
    public ArrayList<String> getFigDispo(){
        return this.figuresDispo;
    }

    public ArrayList<String> getFigNPrise(){
        return this.figuresNPrise;
    }

    public void clearFigDispo(){
        this.figuresDispo.clear();
    }

    public void clearFigNPrise(){
        this.figuresNPrise.clear();
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

    public void relancer(ArrayList<Integer> liste){
        this.L.relancer(liste);
    }

    public int getnumTour()
    {
        return this.numTour;
    }

    public int getscoreTour()
    {
        return this.scoreTour;
    }

    public void setscoreTour()
    {
        this.scoreTour = 0;
    }

    public void listeNPrise(Figure F){

        switch (F.getNom().toLowerCase()) {
            
            case "berlan":
                if(!F.estPrise()){
                    figuresNPrise.add("berlan");
                }
                break;

            case "carre":
                if(!F.estPrise()){
                    figuresNPrise.add("carre");
                }
                break;

            case "chance":
                if(!F.estPrise()){
                    figuresNPrise.add("chance");
                }
                break;
            
            case "full":
                if(!F.estPrise()){
                    figuresNPrise.add("full");
                }
                break;
            
            case "grandesuite":
                if(!F.estPrise()){
                    figuresNPrise.add("grandesuite");
                }
                break;
            
            case "petitesuite":
                if(!F.estPrise()){
                    figuresNPrise.add("petitesuite");
                }
                break;
            
                case "yahtzee":
                    if(!F.estPrise()){
                        figuresNPrise.add("yahtzee");
                    }
                    break;   
        }  
        if (F instanceof FigureMineur){
            FigureMineur Fmin =  (FigureMineur) F;
            if(!Fmin.estPrise()){
                String fig = ""+ Fmin.getValDe();
                figuresNPrise.add(fig);
            } 

        }
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
        else if (this.figureDisponible(F)){
            this.scoreTour = F.calculerScore(L.getDes());
            F.setPrise();
            remplirTablemaj(F, this.scoreTour);
            this.numTour++;
            choix = true;
        }


        return choix;
    }


    public boolean barreFigure(Figure F){
        this.scoreTour = 0;
        boolean succe = false;
        if(this.getFigNPrise().contains(F.getNom())){
            F.setPrise();
            remplirTablemaj(F, this.scoreTour);
            succe = true;
        }
        if  (F instanceof FigureMineur) {
            FigureMineur Fm =  (FigureMineur)F; 
            int valde = Fm.getValDe();
            if(this.getFigNPrise().contains(String.valueOf(valde))){
                Fm.setPrise();
                remplirTablemin(Fm, this.scoreTour);
            }
        }
        this.numTour++;
        return succe;
    }

    public void remplirTablemaj(Figure F, int score){
        
        String figure;
        figure = F.getNom().toUpperCase();
        T.TableScoresmaj.put(figure,score);

    }

    public void remplirTablemin(FigureMineur F, int score){
        
        String figure;
        figure = F.getNom().toUpperCase();
        T.TableScoresmin.put(figure,score);


    }


}





   
    

