package test;
import Jeu.De;
import Figures.Full;
import Figures.PetiteSuite;

public class test {
    public static void main(String[] args) {
    
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

        Full f = new Full();
        System.out.println(f.calculerScore(des));



    }

}
    
