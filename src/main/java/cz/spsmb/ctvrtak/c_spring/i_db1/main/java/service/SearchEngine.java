/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.java.service;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public interface SearchEngine {

	public List<Document> findByType(Type documentType);
	
	public List<Document> listAll();
	
	public List<Document> findByLocation(String location);
}
