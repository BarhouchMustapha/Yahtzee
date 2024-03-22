package Jeu;
import App.*;
import java.util.ArrayList;



public class Table {

    private String nom;
    private int port;
    private Server server = new Server(port);
    private ArrayList<Joueur> ListJoueur = new ArrayList<>(6);
    private enum tableType{
        Permanente,
        Temporaire
    };
    tableType Type;
    private boolean partiEncours;

    public Table(String name, int port){
        this.nom = name;
        this.port = port;
    }

    public String getNom(){
        return this.nom;
    }

    public void LancerJeu(){
        this.server.start();
    }
    
    public int getPort(){
        return this.port;
    }
    
   

    public int getnbrjoueurs(){
        return this.ListJoueur.size();
    }

    public void setType(String type){
        if (type.equals("P")){
            this.Type = tableType.Permanente;
        }
        else{
            this.Type = tableType.Temporaire;
        }
    }

    public boolean estIncomplet(){
        if (this.ListJoueur.size() < 6){
            return true;
        }
        return false;
    }

    public boolean addJoueur(Joueur J){
        if(this.getnbrjoueurs() < 6){
            this.ListJoueur.add(J);
            return true;
        }
        return false;
    }

    public void quitterJoueur(Joueur J){
        this.ListJoueur.remove(J);
    }

    public boolean getPartEnCours(){
        return this.partiEncours;
    }
    

}
