package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune;

import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.WofModel;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.*;

import java.util.LinkedList;
import java.util.Map;

public class WofView extends Group {
    private int nStudentsInWheel = 0;
    private WofPresenter presenter;
    private double radiusInner = 30;
    private Map<Integer, String> students;
    private Button fireBtn;
    private VBox vbox;
    private LinkedList<Button> buttons = new LinkedList<>();

    public WofView(){
        //this.presenter = presenter;
        fireBtn = new Button("Make wheel of fortune");
        this.vbox = new VBox();
        this.vbox.layoutYProperty().bind(this.fireBtn.heightProperty());
        this.getChildren().addAll(this.fireBtn, this.vbox);
    }

    public int getnStudentsInWheel() {
        return nStudentsInWheel;
    }

    public double getRadiusInner() {
        return radiusInner;
    }

    public Map<Integer, String> getStudents() {
        return students;
    }

    public Button getFireBtn() {
        return fireBtn;
    }

    public VBox getVbox() {
        return vbox;
    }

    public LinkedList<Button> getButtons() {
        return buttons;
    }

    public void setPresenter(WofPresenter presenter) {
        this.presenter = presenter;
    }

    public void init(){
        this.students = presenter.getAllStudents();
        this.generateStudentToggles();

    }
    public void redrawWheel(){
        int cnt=0;
        for (Button b: this.buttons) {
            double ang = (this.presenter.getAngle()+cnt*360/this.nStudentsInWheel) % 360;
            if(ang < 360/this.nStudentsInWheel/2 || ang > 360 -360/this.nStudentsInWheel/2){
                b.requestFocus();
                //b.setVisible(false);
            } else {
                //b.setVisible(true);
            }
            for (Transform tran : b.getTransforms()) {
                if(tran.getClass() == Rotate.class){
                    ((Rotate) tran).setAngle(ang);
                    tran.transform(0,b.getHeight()/2);
                } else if (tran.getClass() == Translate.class){
                    //System.out.println("**Translate");
                }
                //System.out.println(tran.getClass().toString());
                //System.out.println(tran.toString());
            }
            //b.getTransforms().clear();
            cnt++;
        }
    }
    public void generateStudentToggles(){
        for(Integer i:this.students.keySet()) {
            ToggleButton b = new ToggleButton(this.students.get(i));
            b.setUserData(Integer.valueOf(i));
            this.vbox.getChildren().add(b);
        }
    }
    public void generateWheel(){
        for(Node n:this.vbox.getChildren()){
            if(! ((ToggleButton)n).isSelected() ){
                this.nStudentsInWheel++;
            }
        }
        int i=0;
        for(Node n:this.vbox.getChildren()){
            ToggleButton tb = (ToggleButton) n;
            if(tb.isSelected()){
                continue;
            }
            Button b = new Button(tb.getText());
            b.layoutXProperty().bind(this.getScene().widthProperty().divide(2));
            b.layoutYProperty().bind(this.getScene().heightProperty().divide(2));
            this.getChildren().add(b);
            Rotate r = new Rotate();
            //r.setPivotY(-b.getHeight()/2);
            r.setAngle(this.presenter.getAngle()+i*360/this.nStudentsInWheel);
            b.getTransforms().addAll(
                    //new Affine(0, b.getHeight()/2, 0,0,0,0),
                    //new Translate( 0, -b.getHeight()/2),

                    //new Translate(150, 150)
                    r,
                    new Translate(this.radiusInner,0)

            );
            buttons.add(b);
            i++;
        }
        Polygon triangle = new Polygon(0, 0, 10, -5, 10, 5);
        this.getChildren().add(triangle);
        triangle.layoutXProperty().bind(this.getScene().widthProperty().divide(2).add(this.radiusInner).add(this.buttons.peek().widthProperty()));
        triangle.layoutYProperty().bind(this.getScene().heightProperty().divide(2));
    }

}
