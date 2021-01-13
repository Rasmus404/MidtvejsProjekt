package sample;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;


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


        timerTextSec.setText(secondsLeft.toString());
        timerTextMin.setText(minutsLeft.toString());
        Button kampStartBut = new Button("Start Kampen");
        kampStartBut.setOnAction(e -> startKampTimer(kampTimer, kampTimerTask));
        HBox kampHBox = new HBox(timerTextMin, timerTextSec, kampStartBut);
        kampHBox.setSpacing(5);

        return kampHBox;

    }
}

