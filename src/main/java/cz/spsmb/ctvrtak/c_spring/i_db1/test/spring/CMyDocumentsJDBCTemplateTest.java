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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.i_db1.main.java.service.SearchEngine;

/**
 * @author Felipe Gutierrez
 * gradle -Dtest.single=MyDocumentsAnnotatedTest test
 * Další zjednodušení - třída JdbcTemplate pomůže spustit dotaz a namapuje výsledek na třídu
 * Document pomocí třídy RowMapper
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-jdbc-template-context.xml")
public class CMyDocumentsJDBCTemplateTest {
	
	@Autowired
	private SearchEngine engine;
	private Type webType = new Type("WEB",".url");
	
	@Test
	public void testJDBCTemplate() {	
		
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
