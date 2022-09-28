/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.data;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;

/**
 * @author Felipe Gutierrez
 *
 */
public interface DocumentDAO {
	public List<Document> getAll();
}
