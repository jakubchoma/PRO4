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
public interface DocumentService {
	public void createNewType(Type type);
	public void updateType(Type type);
	public void removeTypeById(String id);
	public List<Type> getAllDefinedTypes();
	public Type getTypeById(String id);
	
	public void createNewDocument(Document document);
	public void removeDocumentById(String id);
	public void updateDocument(Document document);
	public void updateLocationFromDocumentId(String documentId, String location);
}
