/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.g_tests.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;


/**
 * @author Felipe Gutierrez
 *
 */
// junit 5 toto nevyžaduje
//@RunWith(SpringJUnit4ClassRunner.class)
// zato vyžaduje toto:
@ExtendWith(SpringExtension.class)
/***
 * Anotace @ContextConfiguration je součástí balíčku org.springframework.test.context. Je dobrá k
 * rychlému načtení beanů do Spring kontrjneru pomocí zadaného konfiguračního xml. Zde
 * k beanům přistupujeme pomocí anotací @Autowired
 * */
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class AMyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(AMyDocumentsTest.class);
	
	@Autowired
	private SearchEngine engine;
	@Autowired
	private Type webType;
	
	@Test
	public void testUsingSpringTest() {
		System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
		log.debug("Using Spring Test fixtures:");
		Assertions.assertNotNull(engine);
		List<Doc> documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
		
		documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}
}
