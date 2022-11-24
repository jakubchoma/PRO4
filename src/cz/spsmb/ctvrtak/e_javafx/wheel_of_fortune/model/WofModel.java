package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import java.sql.SQLException;
import java.util.Map;

public class WofModel {
    public Map<Integer, String> getAllStudents() {
        Map<Integer, String> out = null;
        try {
            //DB.fillStudents();
            DB.fillBStudents();
            out = DB.getAllStudents();
        } catch (SQLException e) {
            System.err.format("Unable to read students from DB:%s", e.getMessage());
            e.printStackTrace();
        } finally {
            return out;
        }
    }
}
