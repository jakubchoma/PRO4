package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model;

import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HumanRepository {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;
    private String query;
    private Resource schema;
    private Resource data;

    public void setSchema(Resource schema) {
        this.schema = schema;
    }

    public void setData(Resource data) {
        this.data = data;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Human> getAll(){
        return jdbcTemplate.query(query, new HumanRowMapper());
    }
    public void initialize() {
        try {
            InputStream stream = schema.getInputStream();
            Scanner scanner = new Scanner(stream);
            StringBuilder sql = new StringBuilder();
            while (scanner.hasNext()) {
                sql.append(scanner.nextLine());
                sql.append("\n");
            }
            scanner.close();
            stream.close();
            Connection connection = null;
            Statement statement = null;
            try {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                statement.execute(sql.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            } finally {
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                    }
                }
            }

            stream = data.getInputStream();
            scanner = new Scanner(stream);
            sql = new StringBuilder();
            while (scanner.hasNext()) {
                sql.append(scanner.nextLine());
                sql.append("\n");
            }
            scanner.close();
            stream.close();
            connection = null;
            statement = null;
            try {
                connection = dataSource.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(sql.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            } finally {
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
