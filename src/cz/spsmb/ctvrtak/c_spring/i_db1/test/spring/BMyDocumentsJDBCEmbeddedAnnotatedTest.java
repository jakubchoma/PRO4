/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.i_db1.test.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.service.SearchEngine;

/**
 * @author Felipe Gutierrez
 * gradle -Dtest.single=MyDocumentsAnnotatedTest test
 * lepší způsob - vyhnutí se použití metody initialize()
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-jdbc-embedded-context.xml")
public class BMyDocumentsJDBCEmbeddedAnnotatedTest {
	
	@Autowired
	private SearchEngine engine;
	private Type webType = new Type("WEB",".url");
	
	@Test
	public void testJDBCEmbedded() {
		List<Document> documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}
}
