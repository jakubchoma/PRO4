/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.service;

import java.util.ArrayList;
import java.util.List;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.service.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
public class SearchEngineService implements SearchEngine {
	private DocumentDAO documentDAO;

	
	public SearchEngineService(){
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	public List<Document> findByType(Type documentType) {
		List<Document>  result = new ArrayList<Document>();
		for(Document doc : listAll()){
			if(doc.getType().getName().equals(documentType.getName()))
				result.add(doc);
		}
		return result;
	}
	
	public List<Document> listAll() {
		List<Document> result = documentDAO.getAll();
		return result;
	}

	public List<Document> findByLocation(String location) {
		throw new UnsupportedOperationException("findByLocation not yet implemented.");
	}
}
