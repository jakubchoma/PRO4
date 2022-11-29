package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune;

import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.WofModel;
import cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.Mark;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.*;


import java.util.LinkedList;
import java.util.Map;

// návrhový vzor "přepravka"
class TogglesInfo {
    public final int nUnselectedToggles;
    public final int maxTextWidth;
    public final double maxWidth;
    public TogglesInfo(int nUnselectedToggles, int maxTextWidth, double maxWidth) {
        this.nUnselectedToggles = nUnselectedToggles;
        this.maxTextWidth = maxTextWidth;
        this.maxWidth = maxWidth;
    }
}

public class WofView extends Group {
    private WofPresenter presenter;
    private double radiusInner = 30;
    private Map<Integer, String> students, topics;
    private Button fireBtn;
    private VBox studentsVbox, topicsVbox;
    private TableView<Mark> table;
    private LinkedList<Button> buttons = new LinkedList<>();

    public WofView(){
        //this.presenter = presenter;
        fireBtn = new Button("Make wheel of fortune");
        this.studentsVbox = new VBox();
        this.topicsVbox = new VBox();
        this.table = new TableView<>();
        this.studentsVbox.layoutYProperty().bind(this.fireBtn.heightProperty());
        this.getChildren().addAll(this.fireBtn, this.studentsVbox, this.topicsVbox, this.table);
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

    public VBox getStudentsVbox() {
        return studentsVbox;
    }

    public VBox getTopicsVbox() {
        return topicsVbox;
    }

    public LinkedList<Button> getButtons() {
        return buttons;
    }

    public void setPresenter(WofPresenter presenter) {
        this.presenter = presenter;
    }

    public void init(){
        this.topicsVbox.layoutXProperty().bind(this.getScene().widthProperty().subtract(this.topicsVbox.widthProperty()));
        //this.table.setLayoutY(60);
        this.table.setLayoutX(60);
        this.table.layoutYProperty().bind(this.getScene().heightProperty().subtract(this.table.prefHeightProperty()));
        this.students = presenter.getAllStudents();
        this.topics = presenter.getAllTopics();
        this.generateStudentToggles();
    }
    public void initOnShown(){
        this.fixTogglesWidth(this.studentsVbox);
    }
    public void redrawWheel(){
        int cnt=0;
        for (Button b: this.buttons) {
            double ang = (this.presenter.getAngle()+cnt*360/this.buttons.size()) % 360;
            if(ang < 360/this.buttons.size()/2 || ang > 360 -360/this.buttons.size()/2){
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
            this.studentsVbox.getChildren().add(b);
        }
        //ještě nevykresleno, zde width všech togglů bude 0
        // potřeba zavolat v initOnShown()
        //this.fixTogglesWidth(this.studentsVbox);
    }
    public void generateTopicToggles(){
        for(Integer i:this.topics.keySet()) {
            ToggleButton b = new ToggleButton(this.topics.get(i));
            b.setUserData(Integer.valueOf(i));
            this.topicsVbox.getChildren().add(b);
        }
    }
    public void fixTogglesWidth(VBox from){
        TogglesInfo ti = this.getTogglesInfo(from);
        for(Node n:from.getChildren()){
            ((ToggleButton)n).setPrefWidth(ti.maxWidth);
        }
    }
    public TogglesInfo getTogglesInfo(VBox from){
        int nUnselected = 0;
        int maxTextWidth = 0;
        double maxWidth = 0;
        for(Node n:from.getChildren()){
            if(! ((ToggleButton)n).isSelected() ){
                nUnselected++;
            }
            int len = ((ToggleButton)n).getText().length();
            if(len > maxTextWidth){
                maxTextWidth = len;
            }
            double width =((ToggleButton) n).getWidth();
            if(width > maxWidth){
                maxWidth = width;
            }
        }
        return new TogglesInfo(nUnselected, maxTextWidth, maxWidth);
    }
    public void generateWheel(VBox from){
        int i = 0;
        TogglesInfo ti = this.getTogglesInfo(from);
        for (Button b:this.buttons) {
            b.setVisible(false);
        }
        this.buttons.clear();
        //String format = String.format("%%%ds", ti.maxTextWidth);
        for(Node n:from.getChildren()){
            ToggleButton tb = (ToggleButton) n;
            if(tb.isSelected()){
                continue;
            }
            Button b = new Button(tb.getText());
            b.setPrefWidth(ti.maxWidth);
            b.layoutXProperty().bind(this.getScene().widthProperty().divide(2));
            b.layoutYProperty().bind(this.getScene().heightProperty().divide(2));
            this.getChildren().add(b);
            Rotate r = new Rotate();
            //r.setPivotY(-b.getHeight()/2);
            r.setAngle(this.presenter.getAngle()+i*360/ti.nUnselectedToggles);
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
