package ba.unsa.etf.rpr.lv7lv8;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.ListViewMatchers.hasListCell;
import static org.testfx.util.NodeQueryUtils.hasText;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.framework.junit5.Start;

import java.util.function.Predicate;

@ExtendWith(ApplicationExtension.class)

public class fxTest {

    @Start
    public void start (Stage stage) throws Exception {
        KorisniciModel model = new KorisniciModel();
        Controller ctrl=new Controller(model);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/ba/unsa/etf/rpr/lv7lv8/LogIn.fxml"));
        fxmlLoader.setController(ctrl);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 350);
        stage.setScene(scene);
        stage.show();

    }

    @Test
    public void testDodajButton(FxRobot robot){
        robot.clickOn("#fldIme").write("Ime");
        robot.clickOn("#fldPrezime").write("Prezime");
        robot.clickOn("#fldEmail").write("ime.prezime@gmail.com");
        robot.clickOn("#fldKorisnickoIme").write("ime_prezime");
        robot.clickOn("#fldLozinka").write("lozinka12345");
        robot.clickOn("#dodaj");

        ListView<Korisnik> listView = robot.lookup("#listaKorisnika").query();
        ObservableList<Korisnik> korisnici = listView.getItems();

        assertEquals(1, korisnici.size());
        Korisnik korisnik =korisnici.get(0);
        assertEquals("Ime", korisnik.getIme());
        assertEquals("Prezime", korisnik.getPrezime());
        assertEquals("ime.prezime@gmail.com", korisnik.getEmail());
        assertEquals("ime_prezime", korisnik.getKorisnickoIme());
        assertEquals("lozinka12345", korisnik.getLozinka());
    }

}
