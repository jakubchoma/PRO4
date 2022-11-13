package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune;

import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB;
import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.WofModel;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;

enum State {
    INIT,
    STARTED,
    STOPPED,
    DONE
}
public class WofPresenter {
    private final int MAX_DEGREES_REMAINING = 20*360;
    private final WofModel model;
    private final WofView view;
    private final Random rnd;
    private int angleSpeed = 4;
    private double angle = 0;
    private State state = State.INIT;
    private int degreesRemaining;



    public WofPresenter(WofModel model, WofView view) {
        this.model = model;
        this.view = view;
        this.rnd = new Random();
        this.rnd.setSeed(LocalDateTime.now().getNano());
        this.view.setPresenter(this);
        this.attachEvents();
    }
    public Map<Integer, String> getAllStudents() {
        return this.model.getAllStudents();
    }
    public double getAngle() {
        return angle;
    }

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if((angle+=angleSpeed) >= 360) {
                angle -= 360;
            }
            view.redrawWheel();
            if(WofPresenter.this.state == State.STARTED){
                if(degreesRemaining < MAX_DEGREES_REMAINING*0.4){
                    angleSpeed = 2;
                } else if (degreesRemaining < MAX_DEGREES_REMAINING*0.1){
                    angleSpeed = 1;
                }
                if((degreesRemaining-=angleSpeed) < 0){
                    this.stop();
                    state = State.DONE;
                }

            }
        }
    };


    private void attachEvents(){
        this.view.getFireBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switch(WofPresenter.this.state) {
                    case INIT -> {
                        WofPresenter.this.view.generateWheel();
                        WofPresenter.this.view.redrawWheel();
                        WofPresenter.this.animationTimer.start();
                        WofPresenter.this.state=State.STARTED;
                        WofPresenter.this.view.getFireBtn().setText("stop wheel");
                        WofPresenter.this.degreesRemaining = new Random().nextInt(360*20);
                    }
                    case STARTED -> {

                    }
                }
            }
        });
    }
}
