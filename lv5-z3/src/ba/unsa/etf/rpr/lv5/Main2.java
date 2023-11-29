package ba.unsa.etf.rpr.lv5;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args){
        ArrayList<String> imena1 = new ArrayList<String>();
        imena1.add("Elma Nekic");
        imena1.add("Emina Omerovic");

        KolekcijaImena i=new KolekcijaImena();
        i.setImena(imena1);
        Pobjednik p=new Pobjednik(i);
        System.out.println(p.getIme()+", "+p.getPrezime()+", "+p.getBrojZnakova());

        ArrayList<String> imena2=new ArrayList<String>();
        imena2.add("Dinela");
        imena2.add("Azra");
        ArrayList<String> prezimena2=new ArrayList<String>();
        prezimena2.add("Peskovic");
        prezimena2.add("Trako");
        KolekcijaImenaIPrezimena kol=new KolekcijaImenaIPrezimena(imena2,prezimena2);
        Pobjednik p2=new Pobjednik(kol);
        System.out.println(p2.getIme()+", "+p2.getPrezime()+", "+p2.getBrojZnakova());
    }
}
