package ba.unsa.etf.rpr.lv3;

import java.util.Objects;

public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }
    @Override
    public String ispisi() {
        return "0"+mobilnaMreza+"/"+broj;
    }


    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza,broj);
    }

}
