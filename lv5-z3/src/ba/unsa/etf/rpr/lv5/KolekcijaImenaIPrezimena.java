package ba.unsa.etf.rpr.lv5;

import java.util.List;

public class KolekcijaImenaIPrezimena implements Kolekcija {
    private List<String> imena;
    private List<String> prezimena;

    public KolekcijaImenaIPrezimena(List<String> imena, List<String> prezimena) {
        this.imena = imena;
        this.prezimena = prezimena;
    }

    public List<String> getImena() {
        return imena;
    }

    public List<String> getPrezimena() {
        return prezimena;
    }

    public int getIndexNajduzegPara() {
        int index = 0;
        int najduzi = 0;
        for (int i=0; i < imena.size(); i++) {
            int l=(imena.get(i)+prezimena.get(i)).length();
            if (l > najduzi) {
                najduzi = l;
                index = i;
                }
            }
        return index;
        }
    public String getImeIPrezime(int i){
        return imena.get(i)+" "+prezimena.get(i);
    }


    @Override
    public String getNajduzeIme() {
        String najduzeIme=imena.get(0);
        for(String x:imena){
            if(x.length()>najduzeIme.length()) najduzeIme=x;
        }
        String najduzePrezime=prezimena.get(0);
        for(String x:prezimena){
            if(x.length()>najduzePrezime.length()) najduzePrezime=x;
        }
        return najduzeIme+" "+najduzePrezime;
    }
}
