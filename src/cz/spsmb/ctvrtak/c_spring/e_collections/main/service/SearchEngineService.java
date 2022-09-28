/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.e_collections.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public class SearchEngineService implements SearchEngine {
	private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);
	private DocumentDAO documentDAO;

	
	public SearchEngineService(){
		if(log.isDebugEnabled())
			log.debug("SearchEngineService created: " + this);
	}
	
	public DocumentDAO getDocumentDAO() {
		return documentDAO;
	}

	public void setDocumentDAO(DocumentDAO documentDAO) {
		if(log.isDebugEnabled())
			log.debug("Document DAO set: " + documentDAO);
		
		this.documentDAO = documentDAO;
	}

	public List<Doc> findByType(Type documentType) {
		if(log.isDebugEnabled())
			log.debug("Start <findByType> Params: " + documentType);
		
		List<Doc>  result = new ArrayList<Doc>();
		for(Doc doc : listAll()){
			if(doc.getType().getName().equals(documentType.getName()))
				result.add(doc);
		}
		
		if(log.isDebugEnabled())
			log.debug("End <findByType> Result: " + result);
		return result;
	}
	
	public List<Doc> listAll() {
		if(log.isDebugEnabled())
			log.debug("Start <listAll> Params: ");
		List<Doc> result = Arrays.asList(documentDAO.getAll());
		if(log.isDebugEnabled())
			log.debug("End <listAll> Result: " + result);
		return result;
	}

}
