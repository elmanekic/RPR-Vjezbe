package ba.unsa.etf.rpr.lv4;

public class NeodgovarajuciProcesorException extends Exception{
    private String poruka;
    public NeodgovarajuciProcesorException(String poruka){
        super(poruka);
    }
}
