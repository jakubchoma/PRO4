package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder;

import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.HumanRepository;
import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.Human;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class BrView extends Application {

    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    private HumanRepository model = context.getBean("humanRepo", HumanRepository.class);
    private LocalDate date;
    private BorderPane mainBp = new BorderPane();
    private DatePicker dp = new DatePicker();
    private Scene scene = new Scene(mainBp);
    private TextFlow tf = new TextFlow();

    @Override
    public void start(Stage stage) throws Exception {
        this.mainBp.setMinSize(500, 700);
        this.date = LocalDate.now();
        this.dp.setValue(this.date);
        this.mainBp.setTop(new VBox(
                new MonthlyCal(2023, 1),
                new MonthlyCal(2023, 2),
                new MonthlyCal(2023, 3)
                ));
        this.mainBp.setCenter(this.tf);
        //this.customizeDp();
        //for (Human h:model.getAll()) {
            for (int i = 0; i < 7; i++) {
                LocalDate tmp = this.date.plusDays(i);
                this.tf.getChildren().add(new Text("\n" + tmp));
                for (Human h: model.getAll()) {
                    if(h.getBirthdate().getDayOfYear()== tmp.getDayOfYear()) {
                        int age = this.date.getYear() - h.getBirthdate().getYear();
                        this.tf.getChildren().add(new Text(" "+ h.getFirstName()+" "+h.getSecondName() + "(" + age + ")"));
                    }
                }

                /*this.tf.getChildren().add(new Text(String.format("(%s)", h.getBirthdate()) + h.getFirstName()+" "+h.getSecondName()));*/

            }


        //}

        stage.setScene(this.scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

