package ba.unsa.etf.rpr.lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static String ispisiGradove(){
        GeografijaDAO inst=GeografijaDAO.getInstance();
        ArrayList<Grad> gradovi=inst.gradovi();
        String podaci="";
        for(Grad g:gradovi){
            podaci+=g.toString();
            podaci+="\n";
        }
        return podaci;
    }
    public static void glavniGrad(){
        GeografijaDAO inst=GeografijaDAO.getInstance();
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite naziv drzave: ");
        String d=ulaz.nextLine();
        Grad g=inst.glavniGrad(d);
        if(g==null) System.out.println("Nepostojeca drzava");
        else System.out.println("Glavni grad drzave "+d+" je "+g.getNaziv());



    }
    public static void main(String[] args){
        System.out.println("Gradovi: ");
        String p= ispisiGradove();
        System.out.println(p);
        glavniGrad();
    }
}
