package cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DB {
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
                    " M_Weight DECIMAL(3,2) NOT NULL)" +
                    "CREATE TABLE IF NOT EXISTS GT_Graduate_Topic " +
                    "(S_Id INTEGER PRIMARY KEY," +
                    " GT_Topic VARCHAR(25) NOT NULL,";
            // vytvoření tabulky ((C)RUD - Create)
            Statement stmt = null;
            try {
                cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.conn = DriverManager.getConnection(cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.url);
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                System.err.format("Problém s připojením do db %s:%s", cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.url, e.getMessage());
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
                PreparedStatement pstmt = cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.conn.prepareStatement(
                        "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES (?, ?)");
                pstmt.setString(1, String.format("A%02d", i));
                pstmt.setString(2, String.format("B%02d", i));
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
        public static void fillAStudents() throws SQLException {
            String sql =
                    "INSERT INTO S_Student (S_FirstName, S_LastName) VALUES ('Martin', 'Hojný')," +
                            "('Jan', 'Vítek')," +
                            "('Štěpán', 'Novák')," +
                            "('Lukáš', 'Škrabánek')," +
                            "('Adam', 'Novák')," +
                            "('Vojtěch', 'Odstrčil')," +
                            "('Marek', 'Fiala')," +
                            "('Daniel', 'Bílek')," +
                            "('Jiří', 'Jiránek')," +
                            "('Tomáš', 'Kargl')," +
                            "('Tadeáš', 'Tondl')," +
                            "('Honza', 'Hofman')," +
                            "('Matěj', 'Zralý'),";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        public static void fillTopics() throws SQLException {
            String sql =
                    "INSERT INTO GT_Graduate_Topic (GT_Topic) VALUES ('1','Algoritmizace a programování')," +
                            "('2','Vývojové prostředí a obecná znalost')," +
                            "('3', 'Rozdíly mezi Javou a JavaScriptem')," +
                            "('4', 'Proměnné a paměťové oblasti')," +
                            "('5', 'Operátory')," +
                            "('6', 'Podmíněné větvení')," +
                            "('7', 'Cykly')," +
                            "('8', 'Pole')," +
                            "('9', 'OOP')," +
                            "('10', 'Interface a anotace')," +
                            "('11', 'Enum')," +
                            "('12', 'Návrhové vzory')," +
                            "('13', 'Datum a čas')," +
                            "('14', 'Práce se soubory')," +
                            "('15', 'Kolekce');"+
                            "('16', 'Výjimky a ladění');"+
                            "('17', 'Komentáře, konvence');"+
                            "('18', 'JavaFX');"+
                            "('19', 'Vstupy');"+
                            "('20', 'Práce s grafikou');"+
                            "('21', 'Animace');"+
                            "('22', 'Práce s databází');"+
                            "('23', 'Základy 2D her');"+
                            "('24', 'Build systémy');"+
                            "('25', 'Vlákna');";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

        }
        public static Map<Integer, String> getAllStudents() throws SQLException {
            HashMap<Integer, String> students = new HashMap<>();
            HashMap<Integer, String> topics = new HashMap<>();
            Statement stmt = cz.spsmb.ctvrtak.e_javafx.wheel_of_fortune.model.DB.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM S_Student;");
            ResultSet rst = stmt.executeQuery("SELECT * FROM GT_Graduate_Topic;");
            //String format = "%3s|%20s\n";
            //System.out.format(format, "id", "name");
            while(rs.next()){
                students.put(rs.getInt("S_Id"), rs.getString("S_FirstName"));
                topics.put(rs.getInt("S_Id"), rs.getString("GT_Topic"));
            }
            return students;
            return topics;
        }

    }

}
