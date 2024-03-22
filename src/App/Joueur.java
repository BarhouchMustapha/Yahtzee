package App;
import Jeu.*;

public class Joueur {
    private String nom;
    private Table table;

    public Joueur(String name){
        this.nom = name;
    }

    public Table getTable(){
        return this.table;
    }

    public String getNom(){
        return this.nom;
    }

    

    public boolean JoindreTable(Table T){
        if (T.addJoueur(this)){
        this.table = T;
        return true;
        }
        return false;
    }

    public void QuitterTable(Table T){
        if (this.table.equals(T) ){
            T.quitterJoueur(this);
            this.table = null;
        }
    }

    public void creerTable(String name, int port){
        this.table = new Table(name, port);
        this.table.setType("T");
        this.JoindreTable(this.table);
    }
}
