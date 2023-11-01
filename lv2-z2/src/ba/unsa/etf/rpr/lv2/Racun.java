package ba.unsa.etf.rpr.lv2;

public class Racun {
    protected long brojRacuna;
    protected Osoba korisnikRacuna;
    protected boolean odobrenjePrekoracenja;
    protected double stanjeRacuna;
    protected double prekoracenje;

    public Racun(long brojRacuna, Osoba korisnikRacuna) {
        this.brojRacuna = brojRacuna;
        this.korisnikRacuna=korisnikRacuna;
    }

    private boolean provjeriOdobrenjePrekoracenja(Double n){
        return this.prekoracenje>n;
    }

    public boolean izvrsiUplatu(Double n){
        this.stanjeRacuna+=n;
        return true;
    }

    public boolean izvrsiIsplatu(Double n){
        if(this.stanjeRacuna+this.prekoracenje<n){
            return false;
        }
        this.stanjeRacuna-=n;
        return true;

    }
    public void odobriPrekoracenje(Double n){
        this.prekoracenje=n;
    }


}
