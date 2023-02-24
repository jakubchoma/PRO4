package cz.spsmb.ctvrtak.f_pop.a_mvp_based.b_contacts.model;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class PersonRepository {
    private JdbcTemplate jdbcTemplate;
    private String query;
    private DataSource dataSource;

    public void setQuery(String query) {
        this.query = query;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
    }

   public List <Person> getAll(){
        return this.jdbcTemplate.query(this.query,new PersonRowMapper());
   };

}