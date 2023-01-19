package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune;

import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB;
import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.Mark;
import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.WofModel;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

enum State {
    STUDENTS_SELECTION,
    STUDENT_DRAW,
    STOPPED,
    TICKET_DRAW,
    DONE
}
public class WofPresenter {
    private final int N_ALREADY_TESTED_DAYS = 60;
    private final int MAX_DEGREES_REMAINING = 5*360;
    private final WofModel model;
    private final WofView view;
    private final Random rnd;
    private int angleSpeed = 16;
    private double angle = 0;
    private State state = State.STUDENTS_SELECTION;
    private int degreesRemaining;



    public WofPresenter(WofModel model, WofView view) {
        this.model = model;
        this.view = view;
        this.rnd = new Random();
        this.rnd.setSeed(LocalDateTime.now().getNano());
        this.view.setPresenter(this);
    }
    public void initOnShown(){
        this.attachEvents();
    }

    public Map<Integer, String> getAllStudents() {
        return this.model.getAllStudents();
    }
    public Map<Integer, String> getAllTopics() {
        return this.model.getAllTopics();
    }
    public ObservableList<Mark> getMarks(int studentId){
        return this.model.getMarks(studentId);
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
            if(WofPresenter.this.state == State.STUDENT_DRAW || WofPresenter.this.state == State.TICKET_DRAW){
                if(angleSpeed == 16 && degreesRemaining < MAX_DEGREES_REMAINING*0.8 + WofPresenter.this.rnd.nextInt(102)) {
                    angleSpeed = 8;
                } else if(angleSpeed == 8 && degreesRemaining < MAX_DEGREES_REMAINING*0.6 + WofPresenter.this.rnd.nextInt(102)){
                    angleSpeed = 4;
                } else if(angleSpeed == 4 && degreesRemaining < MAX_DEGREES_REMAINING*0.4 + WofPresenter.this.rnd.nextInt(102)){
                    angleSpeed = 2;
                } else if (angleSpeed == 2 && degreesRemaining < MAX_DEGREES_REMAINING*0.2){
                    angleSpeed = 1;
                }
                if((degreesRemaining-=angleSpeed) < 0){
                    this.stop();
                    if(WofPresenter.this.state == State.STUDENT_DRAW) {
                        state = State.STOPPED;
                        WofPresenter.this.view.getFireBtn().setText("Topic draw");
                        WofPresenter.this.view.getFireBtn().setDisable(false);
                        //WofPresenter.this.view.getVbox().getChildren().clear();
                        //WofPresenter.this.view.generateTopicToggles();
                        //WofPresenter.this.view.fixTogglesWidth(WofPresenter.this.view.getTopicsVbox());
                    } else {
                        WofPresenter.this.view.getFireBtn().setText("Done");
                    }
                }

            }
        }
    };


    private void attachEvents(){
        this.view.getFireBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(WofPresenter.this.state == State.STOPPED || WofPresenter.this.state == State.STUDENTS_SELECTION) {
                    if(WofPresenter.this.state == State.STUDENTS_SELECTION){
                        WofPresenter.this.view.getFireBtn().setText("Drawing ...");
                        WofPresenter.this.view.getFireBtn().setDisable(true);
                        WofPresenter.this.state=State.STUDENT_DRAW;
                        WofPresenter.this.view.generateWheel(WofPresenter.this.view.getStudentsVbox());
                    } else {
                        WofPresenter.this.state=State.TICKET_DRAW;
                        WofPresenter.this.view.generateWheel(WofPresenter.this.view.getTopicsVbox());
                    }

                    WofPresenter.this.view.redrawWheel();
                    WofPresenter.this.angleSpeed = 16;
                    WofPresenter.this.degreesRemaining = WofPresenter.this.MAX_DEGREES_REMAINING / 2 + WofPresenter.this.rnd.nextInt(WofPresenter.this.MAX_DEGREES_REMAINING / 2);
                    WofPresenter.this.animationTimer.start();
                }
            }
        });
        // select students for the toggles preselect
        List<Integer> atsl = this.model.getAlreadyTestedStudentIdList(N_ALREADY_TESTED_DAYS, 1, 1);
        for(Node n:WofPresenter.this.view.getStudentsVbox().getChildren()) {
            ToggleButton b = (ToggleButton) n;
            b.setSelected(atsl.contains((Integer) b.getUserData()));
            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ToggleButton tbSelected = ((ToggleButton) mouseEvent.getSource());
                    WofPresenter.this.view.getlSelectedStudent().setText(tbSelected.getText());
                    Integer studentId = (Integer) tbSelected.getUserData();
                    WofPresenter.this.view.getlSelectedStudent().setUserData(studentId);
                    WofPresenter.this.view.getTable().getItems().clear();
                    WofPresenter.this.view.getTable().getItems().addAll(WofPresenter.this.getMarks(studentId));
                }
            });
        }
        // select topics for the toggles preselect
        List<Integer> attl = this.model.getAlreadyTestedTopicIdList(N_ALREADY_TESTED_DAYS, 1, 1);

        // assign selected topic to lSelectedTopic's userdata
        for(Node n:WofPresenter.this.view.getTopicsVbox().getChildren()) {
            ToggleButton b = (ToggleButton) n;
            b.setSelected(attl.contains((Integer) b.getUserData()));
            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    ToggleButton tbSelected = ((ToggleButton) mouseEvent.getSource());
                    WofPresenter.this.view.getlSelectedTopic().setText(tbSelected.getText());
                    WofPresenter.this.view.getlSelectedTopic().setUserData(tbSelected.getUserData());
                    WofPresenter.this.view.actualizeTopics();
                }
            });
        }
        this.view.actualizeTopics();
        // add row button
        WofPresenter.this.view.getBtnAdd().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Mark mark = new Mark(
                        0,
                        (Integer)WofPresenter.this.view.getlSelectedTopic().getUserData(),
                        Float.parseFloat(WofPresenter.this.view.getTfMark().getText()),
                        WofPresenter.this.view.getDpDate().getValue(),
                        Float.parseFloat(WofPresenter.this.view.getTfWeight().getText())
                );
                Integer studentId = (Integer) WofPresenter.this.view.getlSelectedStudent().getUserData();
                WofPresenter.this.model.addMark(studentId, mark);
                WofPresenter.this.view.getTable().getItems().clear();
                WofPresenter.this.view.getTable().getItems().addAll(WofPresenter.this.getMarks(studentId));
                int a =8;
            }
        });

    }
}
