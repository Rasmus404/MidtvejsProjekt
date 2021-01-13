package sample;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TilmeldHoldCenter implements CenterClassInterface {

    @Override
    public Node getCenter() {
        TextField text = new TextField();

        text.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        text.setFocusTraversable(false);
        text.setPromptText("Holdnavn");

        Button tilmeld = new Button("Tilmeld");
        tilmeld.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tilmeld.setAlignment(Pos.BOTTOM_CENTER);


        HBox tilmeldHold = new HBox(text,tilmeld);
        tilmeldHold.setAlignment(Pos.CENTER);

        return tilmeldHold;
    }
}
