package sample;

import Datalayer.DataLayer;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ScoreboardCenter implements CenterClassInterface{

    DataLayer DL = new DataLayer("HoldDB");
    @Override
    public Node getCenter() {
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


        holdColumn.prefWidthProperty().bind(scoreboard.widthProperty().divide(2)); // w / 2
        scoreColumn.prefWidthProperty().bind(scoreboard.widthProperty().divide(4));
        placeringColumn.prefWidthProperty().bind(scoreboard.widthProperty().divide(4.1));


        scoreboard.getItems().add(new Hold("Randers MiniScooters", "0", "2"));
        scoreboard.getItems().add(new Hold("Herning MiniPut", "3", "1"));
        //scoreboard.getItems().add(getHoldDB); // maybe


        scoreboard.getSortOrder().add(placeringColumn);
        scoreboard.sort();

        VBox scoreboardHolder = new VBox(scoreboard);
        return scoreboardHolder;
    }
}
