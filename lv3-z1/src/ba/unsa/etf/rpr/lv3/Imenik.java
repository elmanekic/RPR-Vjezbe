package ba.unsa.etf.rpr.lv3;

import java.util.Collections;
import java.util.Set;
import java.util.HashMap;
import java.util.TreeSet;

public class Imenik {
    private HashMap<String, TelefonskiBroj> i;

    public Imenik(){
        this.i=new HashMap<String, TelefonskiBroj>();
    }

    public void dodaj(String ime, TelefonskiBroj broj) throws NeispravanParametarException{
        if(ime!=null && broj!=null) i.put(ime,broj);
        else throw new NeispravanParametarException("Neispravan parametar");
    }

    public String dajBroj(String ime){
        return i.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for(String x:i.keySet()){
            if (i.get(x).ispisi().equals(broj.ispisi())) return x;
        }
        return null;
    }


    public String naSlovo (char s){
        StringBuilder r= new StringBuilder();
        for(String ime:i.keySet()){
            if(ime.charAt(0)==s){
                r.append(ime).append(" - ").append(i.get(ime).ispisi()).append("\n");
            }
        }
        return r.toString();
    }

    public Set<String> izGrada (Grad g){
        Set<String> r=new TreeSet<String>();
        for(String ime:i.keySet()) {
            if (i.get(ime) instanceof FiksniBroj) {
                FiksniBroj temp = (FiksniBroj) i.get(ime);
                if (temp.getGrad().equals(g)) {
                    r.add(ime);
                }
            }
        }
        return r;
    }

    public Set<TelefonskiBroj> izGradaBrojevi (Grad g){
        Set<TelefonskiBroj> r=new TreeSet<>(new TelefonskiBrojComparator());
        for(String ime:i.keySet()) {
            if (i.get(ime) instanceof FiksniBroj) {
                FiksniBroj temp = (FiksniBroj) i.get(ime);
                if (temp.getGrad().equals(g)) {
                    r.add(temp);
                }
            }
        }
        return r;
    }

}
