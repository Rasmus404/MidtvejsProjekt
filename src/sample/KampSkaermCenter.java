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

import java.util.Timer;
import java.util.TimerTask;


// lave funktionalitet til hændenlse knapperne
// lave timestamps når der bliverscoret mål og der sker en hændelse
public class KampSkaermCenter {

    Text timerTextSec = new Text();
    Text timerTextMin = new Text();
    Integer secondsLeft = 2;
    Integer minutsLeft = 1;
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


        kampStartBut = new Button("Start Kampen");
        kampStartBut.setOnAction(e -> startKampTimer(kampTimer, kampTimerTask));
        kampStartBut.setPrefWidth(10000);

        Text hjemmehold = new Text("Hjemmehold");
        Text udehold = new Text("Udehold");

        topBorder = new HBox();
        topBorder.getChildren().addAll(hjemmehold, kampStartBut, udehold);
        topBorder.setSpacing(20);
        topBorder.setAlignment(Pos.CENTER);


        rightBorder = new VBox();
        rightBorder.setPrefHeight(700);
        rightBorder.setPrefWidth(700 / 5.4);
        //rightBorder.setStyle("-fx-background-color: #87CEFA;");
        rightBorder.setAlignment(Pos.BOTTOM_CENTER);
        rightBorder.setPadding(new Insets(5, 5, 5, 5));
        rightBorder.setSpacing(15);
        maalUdeButton = new Button("MÅL!");
        udvisningUdeButton = new Button("Udvisning!");


        maalUdeButton.setPrefWidth(rightBorder.getPrefWidth() / 1.5);
        udvisningUdeButton.setPrefWidth(maalUdeButton.getPrefWidth());

        rightBorder.getChildren().addAll(maalUdeButton, udvisningUdeButton);

        leftBorder = new VBox();
        leftBorder.setPrefHeight(700);
        leftBorder.setPrefWidth(700 / 5.4);
        leftBorder.setAlignment(Pos.BOTTOM_CENTER);
        leftBorder.setPadding(new Insets(5, 5, 5, 5));
        leftBorder.setSpacing(15);
        maalHjemmeButton = new Button("MÅL!");
        udvisningHjemmeButton = new Button("Udvisning!");

        maalHjemmeButton.setPrefWidth(leftBorder.getPrefWidth() / 1.5);
        udvisningHjemmeButton.setPrefWidth(maalHjemmeButton.getPrefWidth());

        leftBorder.getChildren().addAll(maalHjemmeButton, udvisningHjemmeButton);

        timerCenter = new HBox();
        timerCenter.setAlignment(Pos.CENTER);
        timerCenter.getChildren().addAll(timerTextMin, timerColonText, timerTextSec);

        scoreCenter = new HBox();
        scoreCenter.setAlignment(Pos.CENTER);
        scoreCenter.getChildren().addAll(hjemmeScoreText, stregScoreText, udeScoreText);

        VBox timerScoreCenter = new VBox();
        timerScoreCenter.getChildren().addAll(timerCenter, scoreCenter);

        kampPane = new BorderPane();
        kampPane.setTop(topBorder);
        kampPane.setCenter(timerScoreCenter);
        kampPane.setRight(rightBorder);
        kampPane.setLeft(leftBorder);

        maalHjemmeButton.setOnAction(e -> maalScoreHjemmeMeth(hjemmeScoreText));
        maalUdeButton.setOnAction(e -> maalScoreUdeMeth(udeScoreText));
        return kampPane;

    }

    public void maalscoreRight(Integer count,Text scoreText, VBox vBox, BorderPane borderPane) {

        maalScoreHjemme++;
        scoreText.setText(String.format("%d", maalScoreHjemme));
        //getKampHaendelse(maalScoreHjemme, haendelseHjemme, getTimeLeft);

    }

    public void maalScoreUdeMeth(Text scoreText) {

        maalScoreUde++;
        scoreText.setText(String.format("%d", maalScoreUde));
        //

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

