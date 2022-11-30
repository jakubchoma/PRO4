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
    private final IntegerProperty graduateTopicId;
    private final FloatProperty mark;
    private final StringProperty date;
    private final FloatProperty weight;

    public Mark(int id, int graduateTopicId, float mark, LocalDate date, float weight) {
        this.id = new SimpleIntegerProperty(this, "id",id);
        this.graduateTopicId = new SimpleIntegerProperty(this, "graduateTopicId", graduateTopicId);
        this.mark = new SimpleFloatProperty(this, "mark", mark);
        this.date = new SimpleStringProperty(this, "date", date.toString());
        this.weight = new SimpleFloatProperty(this, "weight", weight);
    }

    public int getGraduateTopicId() {
        return graduateTopicId.get();
    }

    public IntegerProperty graduateTopicIdProperty() {
        return graduateTopicId;
    }

    public void setGraduateTopicId(int graduateTopicId) {
        this.graduateTopicId.set(graduateTopicId);
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

    public float getMark() {
        return mark.get();
    }

    public FloatProperty markProperty() {
        return mark;
    }

    public void setMark(float mark) {
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
