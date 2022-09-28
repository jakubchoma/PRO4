/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.m_email_scheduling.main.spring.data;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.m_email_scheduling.main.java.model.Document;

/**
 * @author Felipe Gutierrez
 *
 */
public interface DocumentDAO {
	public List<Document> getAll();
	public Document save(String id, Document document);
	public Document findById(String id);
	public Document removeById(String id);
	public List<Document> findByTypeName(String name);
}
