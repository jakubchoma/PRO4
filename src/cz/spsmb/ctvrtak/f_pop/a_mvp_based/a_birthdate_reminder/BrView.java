package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder;

import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.HumanRepository;
import cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model.Human;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
        this.mainBp.setTop(this.dp);
        this.mainBp.setCenter(this.tf);
        //this.customizeDp();
        for (Human h:model.getAll()) {
            this.tf.getChildren().add(new Text(h.getFirstName()+" "+h.getSecondName()+String.format("(%s)", h.getBirthdate())));
            this.tf.getChildren().add(new Text("\n"));
        }

        stage.setScene(this.scene);
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

