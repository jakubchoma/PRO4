/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.d_scopes.main.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
@Service("engine")
@Scope("prototype")
public class AnnotatedSearchEngine implements SearchEngine {
	
	private static final Logger log = LoggerFactory.getLogger(SearchEngineService.class);
	
	@Autowired
	private DocumentDAO documentDAO;
	
	public AnnotatedSearchEngine(){
		if(log.isDebugEnabled())
			log.debug("AnnotatedSearchEngine created: " + this);
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
