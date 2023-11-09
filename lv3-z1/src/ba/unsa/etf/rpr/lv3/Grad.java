package ba.unsa.etf.rpr.lv3;

public enum Grad {
    TRAVNIK("030"),
    ORASJE("031"),
    ZENICA("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    POSUSJE("039"),
    BRCKO("049");

    private final String pozivniBroj;

    Grad(String pozivniBroj) {
        this.pozivniBroj = pozivniBroj;
    }

    public static Grad ocitajGrad(String broj){
        for(Grad g:Grad.values()){
            if(g.getPozivniBroj().equals(broj)) return g;
        }
        return null;
    }

    public String getPozivniBroj() {
        return pozivniBroj;
    }

};
