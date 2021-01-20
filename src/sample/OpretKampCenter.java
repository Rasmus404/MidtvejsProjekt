package sample;

import Datalayer.DataLayer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.Kamp;

import java.time.LocalDate;


// JDBC metoder linket til Kampe


public class OpretKampCenter implements CenterClassInterface {

    DataLayer DL = new DataLayer("HoldDB");

    @Override
    public Node getCenter() {

        ObservableList<String> holdOptions = FXCollections.observableArrayList();
        holdOptions.addAll(DL.getALLHoldNavne());

        ComboBox hjemmeValg = new ComboBox(holdOptions);

        ComboBox udeValg = new ComboBox(holdOptions);


        TextField tidspunkt = new TextField();
        tidspunkt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        tidspunkt.setFocusTraversable(false);
        tidspunkt.setPromptText("Tidspunkt");

        DatePicker datepicker = new DatePicker();
        {

            Button opret = new Button("Opret");
            opret.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));


            opret.setOnAction(e ->
                    DL.addKamp(tilmed(
                            hjemmeValg.getValue().toString(),
                            udeValg.getValue().toString(),
                            datepicker.getValue(),
                            tidspunkt.getText()
                    )));


            GridPane grid = new GridPane();
            grid.setPadding(new Insets(20, 20, 20, 20));
            grid.add(hjemmeValg, 1, 1);
            grid.add(udeValg, 1, 2);
            grid.add(tidspunkt, 1, 3);
            grid.add(datepicker, 1, 4);
            grid.add(opret, 1, 5);
            grid.setVgap(10);


            HBox opretkamp = new HBox(grid);

            opretkamp.setAlignment(Pos.CENTER);


            return opretkamp;

        }
    }
        private Kamp tilmed(String hjemmehold, String udehold, LocalDate dato, String tidspunkt){

            String sStamp = dato.toString()+  " "  + tidspunkt;



            Kamp kamp = new Kamp(DL.getHoldByHoldNavn(hjemmehold), DL.getHoldByHoldNavn(udehold), sStamp);

            return kamp;
        }

}



