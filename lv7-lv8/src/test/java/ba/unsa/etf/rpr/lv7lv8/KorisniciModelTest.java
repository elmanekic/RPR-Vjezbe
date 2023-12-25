package ba.unsa.etf.rpr.lv7lv8;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KorisniciModelTest {

    private KorisniciModel model;

    @BeforeEach
    public void setUp() {
        model = new KorisniciModel();
    }

    @Test
    public void testDefaultConstructor() {
        Korisnik pocetniKorisnik = model.getKorisnici().get(0);
        assertEquals("Elma", pocetniKorisnik.getIme());
        assertEquals("Nekic", pocetniKorisnik.getPrezime());
        assertEquals("enekic1@etf.unsa.ba", pocetniKorisnik.getEmail());
        assertEquals("enekic1", pocetniKorisnik.getKorisnickoIme());
        assertEquals("enekic1234", pocetniKorisnik.getLozinka());
    }

    @Test
    public void testSetKorisnici() {
        ObservableList<Korisnik> novi = FXCollections.observableArrayList(
                new Korisnik("Ime", "Prezime", "ime.prezime@gmail.com", "ime_prezime", "lozinka12345")
        );

        model.setKorisnici(novi);
        assertEquals(novi, model.getKorisnici());
    }


    @Test
    public void testNapuni() {
        Korisnik noviK = new Korisnik("Ime2", "Prezime2", "ime2.prezime2@gmail.com", "ime2_prezime2", "lozinka22222");

        model.napuni(noviK);
        assertEquals(2, model.getKorisnici().size());
        assertEquals(noviK, model.getKorisnici().get(1));
    }
}
