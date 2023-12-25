package ba.unsa.etf.rpr.lv7lv8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        KorisniciModel model = new KorisniciModel();
       // model.napuni(new Korisnik("Elma", "Nekic", "enekic1@etf.unsa.ba","enekic1","enekic1234"));
       Controller ctrl=new Controller(model);
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/ba/unsa/etf/rpr/lv7lv8/LogIn.fxml"));
        fxmlLoader.setController(ctrl);
        Parent root = fxmlLoader.load();
         Scene scene = new Scene(root, 600, 350);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}