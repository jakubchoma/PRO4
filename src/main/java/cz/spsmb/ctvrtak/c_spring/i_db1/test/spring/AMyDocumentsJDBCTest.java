/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.test.spring;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.service.SearchEngine;

/**
 * @author Felipe Gutierrez
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-jdbc-context.xml")
public class AMyDocumentsJDBCTest {
	private static final Logger log = LoggerFactory.getLogger(AMyDocumentsJDBCTest.class);
	
	@Autowired
	private SearchEngine engine;
	
	private Type webType = new Type("WEB",".url");
	
	@Test
	public void testUsingSpringJDBC() {	
		log.debug("Using Spring JDBC...");
	
		List<Document> documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertEquals(4, documents.size());
		
		
		documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertEquals(1, documents.size());
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		log.debug("Found WEB Document: " + documents.get(0));
	}
}
