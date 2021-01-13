package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OpretKampCenter implements CenterClassInterface {

    @Override
    public Node getCenter() {

        TextField hjemmehold = new TextField();
        hjemmehold.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        hjemmehold.setFocusTraversable(false);
        hjemmehold.setPromptText("Hjemmehold");


        TextField udehold = new TextField();
        udehold.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        udehold.setFocusTraversable(false);
        udehold.setPromptText("Udehold");


        TextField tidspunkt = new TextField();
        tidspunkt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        tidspunkt.setFocusTraversable(false);
        tidspunkt.setPromptText("Tidspunkt");


        TextField dato = new TextField();
        dato.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        dato.setFocusTraversable(false);
        dato.setPromptText("Dato");

        Button opret = new Button("Tilmeld");
        opret.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));





        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.add(hjemmehold, 1, 1);
        grid.add(udehold, 1, 2);
        grid.add(tidspunkt, 1, 3);
        grid.add(dato, 1, 4);
        grid.add(opret, 1,5);
        grid.setVgap(10);



        HBox opretkamp = new HBox(grid);

        opretkamp.setAlignment(Pos.CENTER);


        return opretkamp;
    }
}
