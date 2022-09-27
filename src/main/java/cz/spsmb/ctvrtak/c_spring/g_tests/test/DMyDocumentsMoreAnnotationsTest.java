/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.g_tests.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;

import java.util.List;


/**
 * @author Felipe Gutierrez
 * Použití anotací
 * @Timed   - test skončí neúspěchem, pokud bude trvat déle, než je v parametru anotace. Uváděno v ms.
 *
 * @Repeat  - opakuje test tolikrát, kolik je v parametru anotace specifikováno.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class DMyDocumentsMoreAnnotationsTest {
	private static final Logger log = LoggerFactory.getLogger(DMyDocumentsMoreAnnotationsTest.class);
	
	@Autowired
	private SearchEngine engine;
	@Autowired
	private Type webType;
	
	@Timed(millis=2000)
	@Test
	public void testUsingSpringTimedAnnotationTest() throws InterruptedException {	
		log.debug("Using Spring Test fixtures:");
				
		List<Doc> documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		Thread.sleep(5000);
		
		documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}
	
	@Repeat(10)
	@Test
	public void testUsingSpringRepeatedAnnotationTest() {
		log.debug("This message should be printed 10 times..");
	}
}
