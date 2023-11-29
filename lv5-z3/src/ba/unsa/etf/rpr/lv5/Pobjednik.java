package ba.unsa.etf.rpr.lv5;

import java.util.ArrayList;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;
    private Kolekcija kolekcija;

    public Pobjednik(Kolekcija i){
            String[] rez = i.getNajduzeIme().split(" ");
            this.ime = rez[0];
            this.prezime = rez[1];
            this.brojZnakova = rez[0].length() + rez[1].length();

    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public int getBrojZnakova() {
        return brojZnakova;
    }
}
