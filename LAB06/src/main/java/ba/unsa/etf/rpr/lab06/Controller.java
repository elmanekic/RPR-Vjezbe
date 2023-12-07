package ba.unsa.etf.rpr.lab06;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label display;
    private SimpleStringProperty input = new SimpleStringProperty("");
    private double prev = 0;
    private String operator = "";
    @FXML
    public void initialize() {
        // Set the controller for the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("digitron.fxml"));
        loader.setController(this);
    }


    public SimpleStringProperty inputProperty() {
        return input;
    }

    public String getInput() {
        return input.get();
    }


    @FXML
    private void ButtonClick(ActionEvent event){
        Button B= (Button) event.getSource();
        String unos=B.getText();

        if("0123456789".contains(unos)){
            input.set(input.get()+unos);
            display.setText(input.get());
        }
        else if("+-/x%".contains(unos)){
            Operacija();
            operator=unos;
        }
        else if("=".equals(unos)){
            Operacija();
            operator="";
        }
        else if(".".equals(unos)){
            input.set(input.get()+unos);
            display.setText(input.get());
        }
    }

    private void Operacija(){
        if(input.get()!=""){
            double vrijednost=Double.parseDouble(input.get());
            switch(operator){
                case "+":
                    prev+=vrijednost;
                    break;
                case "-":
                    prev-=vrijednost;
                    break;
                case "x":
                    prev*=vrijednost;
                    break;
                case "/":
                    if(vrijednost!=0) prev/=vrijednost;
                    else {
                        display.setText("Greska");
                        return;
                    }
                    break;
                case "%":
                    prev%=vrijednost;
                    break;
                default:
                    prev=vrijednost;
                    break;
            }
            /*if (prev % 1 == 0) {
                display.setText(String.valueOf((int) prev));
            } else {*/
                display.setText(String.valueOf(prev));
            //}

            input.set("");

        }
    }
}