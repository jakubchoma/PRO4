/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.e_collections.main.service;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

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
	
	public void createNewDocument(Doc document);
	public void removeDocumentById(String id);
	public void updateDocument(Doc document);
	public void updateLocationFromDocumentId(String documentId, String location);
}
