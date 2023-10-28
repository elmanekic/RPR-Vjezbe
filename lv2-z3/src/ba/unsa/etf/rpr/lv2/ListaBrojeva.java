package ba.unsa.etf.rpr.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaBrojeva {

    public static void main(String[] args) {
        List<Double> lista=new ArrayList<Double>();
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite broj (ili 'stop' za kraj): ");
        while(true){
            String input=ulaz.nextLine();
            if(input.equals("stop")) break;
            try{
                double broj=Double.parseDouble(input);
                lista.add(broj);
            }
            catch(Exception e){
                System.out.println("Uneseni argument nije broj");
                continue;
            }
        }

        System.out.println("Min: "+MinMaxMean.min(lista));
        System.out.println("Max: "+MinMaxMean.max(lista));
        System.out.println("Mean: "+MinMaxMean.mean(lista));
        System.out.println("Standardna devijacija: "+MinMaxMean.stdev(lista));
    }
}
