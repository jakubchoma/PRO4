package cz.spsmb.ctvrtak.d_maturitni_okruhy.v_prace_s_db;

import java.sql.*;

public class ASQLiteEx {
    public static void main(String[] args) throws SQLException {
        Statement stmt;
        // Connection string pro DB sqlite a uložení DB v relativní cestě moje.db
        String url = "jdbc:sqlite:moje.db";
        Connection conn = DriverManager.getConnection(url);

        // vytvoření tabulky
        stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS mojetabulka " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR(255) NOT NULL)" ;
        stmt.executeUpdate(sql);
        stmt.close();

        //naplnění daty
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO mojetabulka (name) VALUES (?)");
        pstmt.setString(1, "první záznam do DB");
        pstmt.executeUpdate();

        //čtení dat
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mojetabulka;");
        String format = "%3s|%20s\n";
        System.out.format(format, "id", "name");
        while(rs.next()){
            System.out.format(format, rs.getInt("id"), rs.getString("name"));
        }

        //uzavření spojení s DB
        conn.close();
    }
}
