package ba.unsa.etf.rpr.lv1;

import java.util.Scanner;

public class Brojevi {

    public static void main(String[] args) {

        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite prvi broj: ");
        int a=ulaz.nextInt();
        System.out.println("Unesite drugi broj: ");
        int b=ulaz.nextInt();
        System.out.print("Prvi broj: "+a+"\nDrugi broj: "+b);
    }
}
