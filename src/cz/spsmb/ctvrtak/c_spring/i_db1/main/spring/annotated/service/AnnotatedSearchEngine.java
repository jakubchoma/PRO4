/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.annotated.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.spring.data.DocumentDAO;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.service.SearchEngine;

/**
 * @author Felipe Gutierrez
 *
 */
@Service("engine")
public class AnnotatedSearchEngine implements SearchEngine {
	
	@Autowired
	private DocumentDAO documentDAO;
	
	public AnnotatedSearchEngine(){
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
