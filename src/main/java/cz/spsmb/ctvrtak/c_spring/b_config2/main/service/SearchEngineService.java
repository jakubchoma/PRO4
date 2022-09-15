/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
public class SearchEngineService implements SearchEngine {
	
	private DocumentDAO documentDAO;

	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		this.documentDAO = documentDAO;
	}

	public List<Doc> findByType(Type documentType) {
		List<Doc>  result = new ArrayList<Doc>();
		for(Doc doc : listAll()){
			if(doc.getType().getName().equals(documentType.getName()))
				result.add(doc);
		}
		return result;
	}
	
	public List<Doc> listAll() {
		return Arrays.asList(documentDAO.getAll());
	}

}
