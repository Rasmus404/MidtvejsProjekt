package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;


public class KampSkaermCenter {

    Text timerTextSec = new Text();
    Text timerTextMin = new Text();
    Integer secondsLeft = 2;
    Integer minutsLeft = 1;
    Integer hjemmeMaal = 0;
    Integer udeMaal = 0;
    Timer kampTimer = new Timer();


    TimerTask kampTimerTask = new TimerTask() {
        @Override
        public void run() {

            if (secondsLeft > 0) {
                secondsLeft--;
                timerTextSec.setText(secondsLeft.toString());
            } else if (minutsLeft == 0 && secondsLeft == 0) {
                kampTimer.cancel();
            } else {
                secondsLeft = 59;
                minutsLeft--;
                timerTextSec.setText(secondsLeft.toString());
                timerTextMin.setText(minutsLeft.toString());

            }

        }

    };

    public void startKampTimer(Timer kampTimer, TimerTask kampTimerTask) {
        kampTimer.scheduleAtFixedRate(kampTimerTask, 100, 100);
    }

    public Node getKampSkaerm() {


        timerTextMin.setFont(Font.font("Tahoma", FontWeight.NORMAL, 80));
        timerTextSec.setFont(Font.font("Tahoma", FontWeight.NORMAL, 80));
        timerColonText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 80));

        hjemmeScoreText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 80));
        udeScoreText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 80));
        stregScoreText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 80));

        timerTextSec.setText(String.format("%02d", secondsLeft));
        timerTextMin.setText(String.format("%02d", minutsLeft));


        Button kampStartBut = new Button("Start Kampen");
        kampStartBut.setOnAction(e -> startKampTimer(kampTimer, kampTimerTask));
        kampStartBut.setPrefWidth(10000);

        Text hjemmehold = new Text("Hjemmehold");
        Text udehold = new Text("Udehold");

        HBox topBorder = new HBox();
        topBorder.getChildren().addAll(hjemmehold, kampStartBut, udehold);
        topBorder.setSpacing(20);
        topBorder.setAlignment(Pos.CENTER);


        VBox rightBorder = new VBox();
        rightBorder.setPrefHeight(700);
        rightBorder.setPrefWidth(700 / 5.4);
        //rightBorder.setStyle("-fx-background-color: #87CEFA;");
        rightBorder.setAlignment(Pos.BOTTOM_CENTER);
        rightBorder.setPadding(new Insets(5, 5, 5, 5));
        rightBorder.setSpacing(15);
        Button maalUdeButton = new Button("MÅL!");
        Button udvisningUdeButton = new Button("Udvisning!");
        //maalUdeButton.setDefaultButton(true);

        maalUdeButton.setPrefWidth(rightBorder.getPrefWidth() / 1.5);
        udvisningUdeButton.setPrefWidth(maalUdeButton.getPrefWidth());

        rightBorder.getChildren().addAll(maalUdeButton, udvisningUdeButton);

        VBox leftBorder = new VBox();
        leftBorder.setPrefHeight(700);
        leftBorder.setPrefWidth(700 / 5.4);
        // leftBorder.setStyle("-fx-background-color: #87CEFA;");
        leftBorder.setAlignment(Pos.BOTTOM_CENTER);
        leftBorder.setPadding(new Insets(5, 5, 5, 5));
        leftBorder.setSpacing(15);
        Button maalHjemmeButton = new Button("MÅL!");
        Button udvisningHjemmeButton = new Button("Udvisning!");

        maalHjemmeButton.setPrefWidth(leftBorder.getPrefWidth() / 1.5);
        udvisningHjemmeButton.setPrefWidth(maalHjemmeButton.getPrefWidth());

        leftBorder.getChildren().addAll(maalHjemmeButton, udvisningHjemmeButton);

        HBox timerCenter = new HBox();
        timerCenter.setAlignment(Pos.CENTER);
        timerCenter.getChildren().addAll(timerTextMin,timerColonText, timerTextSec);

        HBox scoreCenter = new HBox();
        scoreCenter.setAlignment(Pos.CENTER);
        scoreCenter.getChildren().addAll(hjemmeScoreText, stregScoreText, udeScoreText);

        VBox timerScoreCenter = new VBox();
        timerScoreCenter.getChildren().addAll(timerCenter, scoreCenter);

        BorderPane kampPane = new BorderPane();
        kampPane.setTop(topBorder);
        kampPane.setCenter(timerScoreCenter);
        kampPane.setRight(rightBorder);
        kampPane.setLeft(leftBorder);

        maalHjemmeButton.setOnAction(e -> maalscoreLeft(hjemmeMaal, hjemmeScoreText, leftBorder, kampPane));
        maalUdeButton.setOnAction(e -> maalscoreRight(udeMaal, udeScoreText, rightBorder, kampPane));
        return kampPane;

    }

    public void maalscoreRight(Integer count,Text scoreText, VBox vBox, BorderPane borderPane) {

        count++;
        scoreText.setText("" + count);
        //borderPane.setRight(vBox);

   }
    public void maalscoreLeft(Integer count,Text scoreText, VBox vBox, BorderPane borderPane) {

        count++;
        scoreText.setText(count.toString());
        borderPane.setLeft(vBox);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

