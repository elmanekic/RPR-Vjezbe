package ba.unsa.etf.rpr.predavanje02;

import java.util.*;

public class BrojeviIspis{
public static void main(String[] args){
    Scanner ulaz=new Scanner(System.in);
    System.out.println("Unesite broj: ");
    int n=ulaz.nextInt();
    for(int i=1; i<n;i++){
        if(DjeljivSaSumom(i)) {
            System.out.println(i);
        }
    }

}
    private static int SumaCifara(int broj){
    int suma=0;
    while(broj>0){
        suma=suma+broj%10;
        broj=broj/10;
    }
    return suma;
    }

    private static boolean DjeljivSaSumom(int broj){
    int suma=SumaCifara(broj);
    if (broj%suma==0) return true;
    return false;
    }
}

