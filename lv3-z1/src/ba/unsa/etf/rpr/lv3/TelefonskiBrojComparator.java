package ba.unsa.etf.rpr.lv3;
import java.util.Comparator;

public class TelefonskiBrojComparator implements Comparator<TelefonskiBroj> {
    @Override
    public int compare(TelefonskiBroj broj1, TelefonskiBroj broj2) {
        String str1 = broj1.ispisi();
        String str2 = broj2.ispisi();
        return str1.compareTo(str2);
    }
}
