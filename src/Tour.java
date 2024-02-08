import Jeu.De;
import Figures.*;
public class Tour {

    private int numTour;

    public Tour(){
        this.numTour = 0;
    }

    public De[] lancer(){
        
        De[] des = new De[5];
        
        De d_1 = new De();
        De d_2 = new De();
        De d_3 = new De();
        De d_4 = new De();
        De d_5 = new De();

        des[0] = d_1;
        des[1] = d_2;
        des[2] = d_3;
        des[3] = d_4;
        des[4] = d_5;
        return des;
    }
    
}
