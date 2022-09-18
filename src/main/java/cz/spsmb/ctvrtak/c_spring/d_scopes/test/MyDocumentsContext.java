/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.d_scopes.test;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.d_scopes.main.service.SearchEngineService;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentRepository;

/**
 * @author Felipe Gutierrez
 *
 */
@Configuration
public class MyDocumentsContext {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsContext.class);
	
	private Map<String,Doc> documents = new HashMap<String,Doc>();
	private Map<String,Type> types = new HashMap<String,Type>();

	@Bean
	public Type webType(){		
		return getTypeFromMap("web");
	}
	
	@Bean
	@Scope("prototype")
	public SearchEngine engine(){
		SearchEngineService engine = new SearchEngineService();
		engine.setDocumentDAO(documentDAO());
		
		if(log.isDebugEnabled())
			log.debug("SearchEngine created: " + engine);
		
		return engine;
	}
	
	public MyDocumentsContext(){
		Type type = new Type();
		type.setName("PDF");
		type.setDesc("Portable Document Format");
		type.setExtension(".pdf");
		
		
		Doc document = new Doc();
		document.setName("Book Template");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
		
		documents.put("doc1", document);
		types.put("pdf",type);
		
		document = new Doc();
		document.setName("Sample Contract");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
		
		documents.put("doc2",document);
		
		type = new Type();
		type.setName("NOTE");
		type.setDesc("Text Notes");
		type.setExtension(".txt");
		
		document = new Doc();
		document.setName("Clustering with RabbitMQ");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
		
		documents.put("doc3",document);
		types.put("note",type);
		
		type = new Type();
		type.setName("WEB");
		type.setDesc("Web Link");
		type.setExtension(".url");
		
		document = new Doc();
		document.setName("Pro Spring Security Book");
		document.setType(type);
		document.setLocation("http://www.apress.com/9781430248187");
		
		documents.put("doc4",document);
		types.put("web",type);
	}
	
	private DocumentDAO documentDAO(){
		DocumentRepository documentDAO = new DocumentRepository();
		documentDAO.setDoc1(getDocumentFromMap("doc1"));
		documentDAO.setDoc2(getDocumentFromMap("doc2"));
		documentDAO.setDoc3(getDocumentFromMap("doc3"));
		documentDAO.setDoc4(getDocumentFromMap("doc4"));
		return documentDAO;
	}
	
	private Doc getDocumentFromMap(String documentKey){
		return documents.get(documentKey);
	}
	
	private Type getTypeFromMap(String typeKey){		
		return types.get(typeKey);
	}
}
