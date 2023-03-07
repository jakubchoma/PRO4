package cz.spsmb.ctvrtak.f_pop.a_mvp_based.a_birthdate_reminder.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HumanRowMapper implements RowMapper<Human> {
    @Override
    public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
        Human human = new Human();
        human.setId(rs.getInt("id"));
        human.setEmail(rs.getString("email"));
        human.setFirstName(rs.getString("firstName"));
        human.setSecondName(rs.getString("secondName"));
        human.setBirthdate(rs.getDate("birthdate").toLocalDate());
        return human;
    }
}
