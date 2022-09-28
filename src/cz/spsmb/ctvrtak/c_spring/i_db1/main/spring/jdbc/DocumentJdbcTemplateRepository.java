/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
public class DocumentJdbcTemplateRepository implements DocumentDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private String query;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	public void setQuery(String query){
		this.query = query;
	}

	public List<Document> getAll() {
		return jdbcTemplate.query(query, new DocumentRowMapper());
	}

}
