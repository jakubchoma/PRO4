package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DB {
    private static String url = "jdbc:sqlite:wof.db";
    private static Connection conn = null;
    static{
        String sql = "CREATE TABLE IF NOT EXISTS S_Student " +
                "(S_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " S_FirstName VARCHAR(25) NOT NULL," +
                " S_LastName VARCHAR(25) NOT NULL);" +
                " CREATE TABLE IF NOT EXISTS M_Marking " +
                "(M_Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " M_S_Id INTEGER NOT NULL," +
                " M_Mark TINYINT NOT NULL," +
                " M_Date DATE NOT NULL," +
                " M_Weight DECIMAL(3,2) NOT NULL)";
        // vytvoření tabulky ((C)RUD - Create)
        Statement stmt = null;
        try {
            DB.conn = DriverManager.getConnection(DB.url);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.format("Problém s připojením do db %s:%s", DB.url, e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void fillStudents() throws SQLException {
        int N = 15;
        for(int i=0; i<N; i++) {
            PreparedStatement pstmt = DB.conn.prepareStatement(
                    "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES (?, ?)");
            pstmt.setString(1, String.format("Herb%02d", i));
            pstmt.setString(2, String.format("Hero%02d", i));
            pstmt.executeUpdate();
        }
    }
    public static void fillBStudents() throws SQLException {
        String sql =
                "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES ('Lukáš', 'Haken')," +
                        "('Vojtěch', 'Černý')," +
                        "('Michal', 'Kraušner')," +
                        "('Ondřej', 'Merhaut')," +
                        "('Ondřej', 'Žárský')," +
                        "('Jakub', 'Chomanič')," +
                        "('Robin', 'Krouský')," +
                        "('Michal', 'Skalický')," +
                        "('Vojtěch', 'Zajíček')," +
                        "('Pavel', 'Šípek')," +
                        "('Tadeáš', 'Karban')," +
                        "('Ondřej', 'Janošík')," +
                        "('Zdenek', 'Stanke')," +
                        "('Pavel', 'Štemberk')," +
                        "('Josef', 'Matoušek');";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

    }
    public static Map<Integer, String> getAllStudents() throws SQLException {
        HashMap<Integer, String> students = new HashMap<>();
        Statement stmt = DB.conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM S_Student;");
        //String format = "%3s|%20s\n";
        //System.out.format(format, "id", "name");
        while(rs.next()){
            students.put(rs.getInt("S_Id"), rs.getString("S_FirstName"));
        }
        return students;
    }

}
