package ba.unsa.etf.rpr.lv3;

import java.util.Objects;


public class FiksniBroj extends TelefonskiBroj {
    private String broj;
    private Grad grad;
    public FiksniBroj(Grad grad, String broj) {
            this.grad = grad;
            this.broj = broj;
    }

    public Grad getGrad(){
        return grad;
    }
    public String getBroj(){return broj;}
    public String ispisi() {
        return grad.getPozivniBroj()+"/"+broj;
    }

    @Override
    public int hashCode(){
        return grad.hashCode()+broj.hashCode();
    }
};
