// PersonApp.java
package cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.a_mvc_mvp.mvp;

import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.a_mvc_mvp.mvp.model.Person;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.a_mvc_mvp.mvp.view.PersonPresenter;
import cz.spsmb.ctvrtak.d_maturitni_okruhy.l_navrhove_vzory.a_mvc_mvp.mvp.view.PersonView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/***
 * Ukázka aktivního MVP. JavaFX podporuje data binding, tudíž pasivní MVP zde není nutné zavádět.
 */
public class PersonApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Person model = new Person();		
		String dateFormat = "MM/dd/yyyy";
		PersonView view = new PersonView(model, dateFormat);

		// Must set the scene before creating the presenter that uses 
		// the scene to listen for the focus change
		Scene scene = new Scene(view);
		scene.getStylesheets().add("button_hover.css");
		PersonPresenter presenter = new PersonPresenter(model, view);
		view.setStyle("-fx-padding: 10;" + 
		              "-fx-border-style: solid inside;" + 
		              "-fx-border-width: 2;" +
		              "-fx-border-insets: 5;" + 
		              "-fx-border-radius: 5;" + 
		              "-fx-border-color: blue;");
		
		stage.setScene(scene);
		stage.setTitle("Person Management");
		stage.show();
	}
}
