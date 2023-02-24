package cz.spsmb.ctvrtak.f_pop.a_mvp_based.b_contacts.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person ps = new Person(
                rs.getInt("id"),
                rs.getString("firstName"),
                rs.getString("secondName"),
                rs.getString("address"),
                rs.getString("phone"),
                rs.getString("email")
        );
        return ps;

    }
}
