package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import java.sql.SQLException;
import java.util.Map;

public class WofModel {
    public Map<Integer, String> getAllStudents() {
        Map<Integer, String> out = null;
        try {
            //DB.fillStudents();
            //DB.fillAStudents();
            //DB.fillTopics();
            out = DB.getAllStudents();
        } catch (SQLException e) {
            System.err.format("Unable to read students from DB:%s", e.getMessage());
            e.printStackTrace();
        } finally {
            return out;
        }
    }
    public Map<Integer, String> getAllTopics() {
        Map<Integer, String> out = null;
        try {
            out = DB.getAllTopics();
        } catch (SQLException e) {
            System.err.format("Unable to read students from DB:%s", e.getMessage());
            e.printStackTrace();
        } finally {
            return out;
        }
    }
}
