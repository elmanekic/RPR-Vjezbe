package ba.unsa.etf.rpr.lab06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("digitron.fxml"));
        GridPane root = loader.load();

        Scene scene = new Scene(root, 250, 280);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
