package cz.spsmb.ctvrtak.c_spring.o_groovy_test.main;

import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.List;

public class WelcomeScreen extends TextFlow {
    private List<String> messages;
    private int fontSize;
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }


    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    //public WelcomeScreen()
    public void initScreen() {
        for (String message:messages) {
            Text t = new Text("\n"+message);
            t.setStyle("-fx-font-size:"+Integer.toString(this.fontSize));
            this.getChildren().add(t);
        }
    }
}
