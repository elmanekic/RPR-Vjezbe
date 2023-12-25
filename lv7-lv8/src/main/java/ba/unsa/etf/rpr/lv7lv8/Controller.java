package ba.unsa.etf.rpr.lv7lv8;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private KorisniciModel model;
    public TextField fldIme;
    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldKorisnickoIme;
    public PasswordField fldLozinka;
    public ListView listaKorisnika;

    public Button dodaj;
    public Button kraj;

    public Controller(KorisniciModel model){this.model=model;}

    @FXML
        public void initialize() {
            listaKorisnika.setItems(model.getKorisnici());
            listaKorisnika.getSelectionModel().selectedItemProperty().addListener((obs, oldK, newK) -> {
                model.setTrenutniKorisnik((Korisnik) newK);
                listaKorisnika.refresh();
            });
            model.trenutniKorisnikProperty().addListener((obv, o, n) -> {
                if(o != null){
                    fldIme.textProperty().unbindBidirectional(o.imeProperty());
                    fldPrezime.textProperty().unbindBidirectional(o.prezimeProperty());
                    fldEmail.textProperty().unbindBidirectional(o.emailProperty());
                    fldKorisnickoIme.textProperty().unbindBidirectional(o.korisnickoImeProperty());
                    fldLozinka.textProperty().unbindBidirectional(o.lozinkaProperty());
                }
                if(n == null){
                    fldIme.setText("");
                    fldPrezime.setText("");
                    fldEmail.setText("");
                    fldKorisnickoIme.setText("");
                    fldLozinka.setText("");
                }else{
                    fldIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
                    fldPrezime.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().prezimeProperty());
                    fldEmail.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().emailProperty());
                    fldKorisnickoIme.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().korisnickoImeProperty());
                    fldLozinka.textProperty().bindBidirectional(model.trenutniKorisnikProperty().get().lozinkaProperty());

                }
            });
    }

    @FXML
    public void Kraj(ActionEvent actionEvent) {
        Node n = (Node) actionEvent.getSource();
        Stage stage = (Stage) n.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Dodaj(ActionEvent actionEvent){
        ObservableList<Korisnik> temp = model.getKorisnici();
        Korisnik novi = new Korisnik(fldIme.getText(),fldPrezime.getText(),fldEmail.getText(),fldKorisnickoIme.getText(),fldLozinka.getText());
        temp.add(novi);
        model.setKorisnici(temp);
        model.setTrenutniKorisnik(novi);
    }
}