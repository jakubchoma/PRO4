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
    //private Resource schema;
    //private Resource data;

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

}
