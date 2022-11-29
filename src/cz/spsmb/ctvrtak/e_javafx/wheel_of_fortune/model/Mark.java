package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import javafx.beans.property.*;

import java.time.LocalDate;

/*
"(M_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
        " M_S_Id INTEGER NOT NULL," +
        " M_Mark TINYINT NOT NULL," +
        " M_Date DATE NOT NULL," +
        " M_Weight DECIMAL(3,2) NOT NULL);" +
 */
public class Mark {
    private final IntegerProperty id;
    private final IntegerProperty mark;
    private final StringProperty date;
    private final FloatProperty weight;

    public Mark(int id, byte mark, LocalDate date, float weight) {
        this.id = new SimpleIntegerProperty(this, "id",id);
        this.mark = new SimpleIntegerProperty(this, "mark", mark);
        this.date = new SimpleStringProperty(this, "date", date.toString());
        this.weight = new SimpleFloatProperty(this, "weight", weight);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getMark() {
        return mark.get();
    }

    public IntegerProperty markProperty() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark.set(mark);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public float getWeight() {
        return weight.get();
    }

    public FloatProperty weightProperty() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight.set(weight);
    }
}
