package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle(" ");
        stage.setWidth(700);
        stage.setHeight(stage.getWidth() / 1.4);

        ScoreboardCenter scoreboardCenter = new ScoreboardCenter();
        KommendeKampCenter kommendeKampCenter = new KommendeKampCenter();
        KampHistorikCenter kampHistorikCenter = new KampHistorikCenter();
        KampSkaermCenter kampSkaermCenter = new KampSkaermCenter();


        VBox leftBorder = new VBox();
        Button b1 = new Button("One");
        leftBorder.setPrefWidth(stage.getWidth() / 5.4);
        leftBorder.setStyle("-fx-background-color: #336699;");
        leftBorder.setAlignment(Pos.TOP_CENTER);
        leftBorder.setPadding(new Insets(5, 5, 5, 5));
        Button tilmeldHoldButton = new Button("Tilmeld hold");
        Button opretKampButton = new Button("Opret Kamp");
        Button startKampButton = new Button("Start Kamp");

        //startKampButton.setOnAction(e -> beginKampSkærm);

        tilmeldHoldButton.setPrefWidth(leftBorder.getPrefWidth() / 1.1);
        opretKampButton.setPrefWidth(tilmeldHoldButton.getPrefWidth());
        startKampButton.setPrefWidth(tilmeldHoldButton.getPrefWidth());
        leftBorder.setSpacing(15);
        leftBorder.getChildren().addAll(tilmeldHoldButton, opretKampButton, startKampButton);


        VBox rightBorder = new VBox();
        rightBorder.setPrefWidth(stage.getWidth() / 5.4);
        rightBorder.setStyle("-fx-background-color: #336699;");
        rightBorder.setAlignment(Pos.TOP_CENTER);
        rightBorder.setPadding(new Insets(5, 5, 5, 5));

        Button pointTavleButton = new Button("Point Tavle");
        Button kommendeKampeButton = new Button("Kommende Kampe");
        Button kampHistorikButton = new Button("Kamp Historik");

        pointTavleButton.setPrefWidth(rightBorder.getPrefWidth() / 1.1);
        kommendeKampeButton.setPrefWidth(pointTavleButton.getPrefWidth());
        kampHistorikButton.setPrefWidth(pointTavleButton.getPrefWidth());
        rightBorder.setSpacing(15);
        rightBorder.getChildren().addAll(pointTavleButton, kommendeKampeButton, kampHistorikButton);


        Text miniPutLigaText = new Text("Miniput Liga");
        miniPutLigaText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        Text kommendeKampeText = new Text("Ingen kommende kampe");
        kommendeKampeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        VBox topBorder = new VBox(miniPutLigaText, kommendeKampeText);
        topBorder.setAlignment(Pos.CENTER);


        BorderPane pane = new BorderPane();
        pane.setLeft(leftBorder);
        pane.setRight(rightBorder);
        pane.setCenter(scoreboardCenter.getCenter());
        pane.setTop(topBorder);

        pointTavleButton.setOnAction(e -> pane.setCenter(scoreboardCenter.getCenter()));
        kommendeKampeButton.setOnAction(e -> pane.setCenter(kommendeKampCenter.getCenter()));
        kampHistorikButton.setOnAction(e -> pane.setCenter(kampHistorikCenter.getCenter()) );
        startKampButton.setOnAction( e->pane.setCenter(kampSkaermCenter.getCenter())); // evt. lave Pop op eller ændre hele vinduet(Left, Center, Right : knapper og tid) (Top : Hjemme vs ude)

        // Rasmus må gerne lave resten selv :)

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
