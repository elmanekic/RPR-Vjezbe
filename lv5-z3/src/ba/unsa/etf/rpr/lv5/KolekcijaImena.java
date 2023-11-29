package ba.unsa.etf.rpr.lv5;

import java.util.List;

public class KolekcijaImena implements Kolekcija {
    private List<String> imena;

    public List<String> getImena() {
        return imena;
    }

    public void setImena(List<String> imena) {
        this.imena = imena;
    }

    @Override
    public String getNajduzeIme(){
        String najduzi=imena.get(0);
        for(String x:imena){
            if(x.length()>najduzi.length()) najduzi=x;
        }
        return najduzi;
    }
}
