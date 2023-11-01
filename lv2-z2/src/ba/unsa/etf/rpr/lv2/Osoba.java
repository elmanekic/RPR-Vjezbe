package ba.unsa.etf.rpr.lv2;

public class Osoba {
    private String ime;
    private String prezime;

    public Osoba(String ime, String prezime) {
        this.ime = ime;
        this.prezime=prezime;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                '}';
    }
}

