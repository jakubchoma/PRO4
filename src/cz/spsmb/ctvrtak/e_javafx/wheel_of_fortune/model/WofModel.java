package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class WofModel {
    public Map<Integer, String> getAllStudents() {
        Map<Integer, String> out = null;
        try {
            //DB.fillTopics();
            //DB.fillBStudents();
            //DB.fillBStudentsOfEvil();
            //DB.fillAStudents();
            //DB.removeMark(14);
            //DB.customStmt("UPDATE M_Marking SET M_Weight = 0.5 WHERE M_Id IN (19, 20, 21);");
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
    public ObservableList<Mark> getMarks(int studentId){
            return DB.getMarks(studentId);
    }
    public void addMark(int studentId, Mark mark){
        DB.addMark(studentId, mark);
    }
    public List<Integer> getAlreadyTestedStudentIdList(int nDays){
        return DB.getAlreadyTestedIdList(true, nDays, 0, 1);
    }
    public List<Integer> getAlreadyTestedStudentIdList(int nDays, float weightFrom, float weightTo){
        return DB.getAlreadyTestedIdList(true, nDays, weightFrom, weightTo);
    }
    public List<Integer> getAlreadyTestedTopicIdList(int nDays, float weightFrom, float weightTo){
        return DB.getAlreadyTestedIdList(false, nDays, weightFrom, weightTo);
    }
}
