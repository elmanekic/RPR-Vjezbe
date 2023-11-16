package ba.unsa.etf.rpr.lv4;

import java.io.IOException;
import java.util.ArrayList;

public interface LaptopDao {
    void dodajLaptopUListu(Laptop laptop);
    void dodajLaptopUFile(Laptop laptop);
    Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException;
    void napuniListu(ArrayList<Laptop> laptopi);
    ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException;
}
