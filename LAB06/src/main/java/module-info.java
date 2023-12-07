module ba.unsa.etf.rpr.lab06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens ba.unsa.etf.rpr.lab06 to javafx.graphics, javafx.fxml;
    exports ba.unsa.etf.rpr.lab06;
}