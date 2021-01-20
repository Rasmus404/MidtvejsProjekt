package sample;

import Datalayer.DataLayer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.Hold;


// JDBC metoder linket til Hold

public class TilmeldHoldCenter implements CenterClassInterface {

    DataLayer DL = new DataLayer("HoldDB");


    @Override
    public Node getCenter() {
        TextField holdText = new TextField();

        holdText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        holdText.setFocusTraversable(false);
        holdText.setPromptText("Holdnavn");

        Button tilmeld = new Button("Tilmeld");
        tilmeld.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tilmeld.setAlignment(Pos.BOTTOM_CENTER);

        tilmeld.setOnAction(e-> DL.addHold(holdTilmed(holdText.getText())));

        HBox tilmeldHold = new HBox(holdText,tilmeld);
        tilmeldHold.setAlignment(Pos.CENTER);

        return tilmeldHold;
    }


 private Hold holdTilmed(String holdStringNavn){

    Hold hold = new Hold();
    hold.setHoldNavn(holdStringNavn);
    hold.setScore(0);
    return hold;
 }
}


