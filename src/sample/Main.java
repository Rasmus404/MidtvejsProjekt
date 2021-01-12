package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.setTitle(" ");
        stage.setWidth(500);
        stage.setHeight(500);

        TableView scoreboard = new TableView();
        TableColumn<Hold, String> holdColumn = new TableColumn<>("Hold");
        holdColumn.setCellValueFactory(new PropertyValueFactory<>("holdNavn"));

        TableColumn<Hold, String> scoreColumn = new TableColumn<>("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        TableColumn<Hold, String> placeringColumn = new TableColumn<>("Placering");
        placeringColumn.setCellValueFactory(new PropertyValueFactory<>("placering"));

        scoreboard.getColumns().add(holdColumn);
        scoreboard.getColumns().add(scoreColumn);
        scoreboard.getColumns().add(placeringColumn);

        scoreboard.getItems().add(new Hold("Randers MiniScooters", "0", "2"));
        scoreboard.getItems().add(new Hold("Herning MiniPut", "0", "1"));
        VBox scoreboardHolder = new VBox(scoreboard);


        VBox leftBorder = new VBox();
        Button b1 = new Button("One");
        leftBorder.setPrefWidth(100);
        leftBorder.setStyle("-fx-background-color: #336699;");


        VBox rightBorder = new VBox();
        Button pointTavleButton = new Button("Point Tavle");
        rightBorder.getChildren().addAll(pointTavleButton);
        rightBorder.setPrefWidth(100);
        rightBorder.setStyle("-fx-background-color: #336699;");



        Text miniPutLigaText = new Text("Miniput Liga");
        miniPutLigaText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 50));
        Text kommendeKampeText = new Text("Ingen kommende kampe");
        kommendeKampeText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));

        VBox topBorder = new VBox(miniPutLigaText, kommendeKampeText);
        topBorder.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setLeft(leftBorder);
        pane.setRight(rightBorder);
        pane.setCenter(scoreboardHolder);
        pane.setTop(topBorder);

        Scene scene = new Scene(pane, 400, 300);
        stage.setScene(scene);
        stage.show();


    }
}
