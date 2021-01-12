package sample;

import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import java.time.LocalTime;


public class KommendeKampCenter implements CenterClassInterface{

    @Override
    public Node getCenter() {
        TableView kommendeKampe = new TableView();
        TableColumn<Kamp, String> hjemmeholdColumn = new TableColumn<>("Hjemmehold");
        hjemmeholdColumn.setCellValueFactory(new PropertyValueFactory<>("hjemmehold"));

        TableColumn<Kamp, String> tidspunktColumn = new TableColumn<>("Tidspunkt");
        tidspunktColumn.setCellValueFactory(new PropertyValueFactory<>("tidspunkt"));

        TableColumn<Kamp, String> datoColumn = new TableColumn<>("Dato ");
        datoColumn.setCellValueFactory(new PropertyValueFactory<>("dato"));

        TableColumn<Kamp, String> udeholdColumn = new TableColumn<>("Udehold ");
        udeholdColumn.setCellValueFactory(new PropertyValueFactory<>("udehold"));


        kommendeKampe.getColumns().add(hjemmeholdColumn);
        kommendeKampe.getColumns().add(tidspunktColumn);
        kommendeKampe.getColumns().add(datoColumn);
        kommendeKampe.getColumns().add(udeholdColumn);



        hjemmeholdColumn.prefWidthProperty().bind(kommendeKampe.widthProperty().divide(3)); // w / 2
        tidspunktColumn.prefWidthProperty().bind(kommendeKampe.widthProperty().divide(6));
        datoColumn.prefWidthProperty().bind(kommendeKampe.widthProperty().divide(6.2));
        udeholdColumn.prefWidthProperty().bind(kommendeKampe.widthProperty().divide(3));


        kommendeKampe.getItems().add(new Kamp("Randers MiniScooters", "Herning Miniput", LocalDate.now().plusDays(1), LocalTime.parse("15:30")));

        VBox kommendeKampeHolder = new VBox(kommendeKampe);
        return kommendeKampeHolder;
    }
}
