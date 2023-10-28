package ba.unsa.etf.rpr.lv2;

import java.util.List;

public class MinMaxMean {
    public static Double mean(List<Double> lista){
        double suma=0;
        for(double x:lista) suma+=x;
        return suma/lista.size();
    }

    public static Double min (List<Double> lista){
        double min=Double.MAX_VALUE;
        for(Double x:lista){
            if(x<min) min=x;
        }
        return min;
    }

    public static Double max(List<Double> lista){
        double max=Double.MIN_VALUE;
        for(Double x:lista){
            if(x>max) max=x;
        }
        return max;
    }

    public static Double stdev(List<Double> lista){
        Double m=mean(lista);
        float sd=0;
        for(Double x:lista){
            sd+=Math.pow(x-m,2);
        }
        return Math.sqrt(sd/lista.size());
    }
}
