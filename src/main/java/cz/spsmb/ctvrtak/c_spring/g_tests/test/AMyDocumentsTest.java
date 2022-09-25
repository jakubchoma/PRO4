/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.g_tests.test;

import java.util.List;

import groovy.util.logging.Slf4j;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
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
// zato vyžaduje toto - bohužel to ale zas odstaví nastavení logování pomocí setProperty:
@ExtendWith(SpringExtension.class)
/***
 * https://stackoverflow.com/questions/3387441/how-do-i-configure-spring-and-slf4j-so-that-i-can-get-logging
 * https://stackoverflow.com/questions/12532339/no-appenders-could-be-found-for-loggerlog4j
 * Anotace @ContextConfiguration je součástí balíčku org.springframework.test.context. Je dobrá k
 * rychlému načtení beanů do Spring kontrjneru pomocí zadaného konfiguračního xml. Zde
 * k beanům přistupujeme pomocí anotací @Autowired
 * */
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class AMyDocumentsTest {
	static {
		BasicConfigurator.configure();
	}
	private static final Logger log = LoggerFactory.getLogger(AMyDocumentsTest.class);
	
	@Autowired
	private SearchEngine engine;
	@Autowired
	private Type webType;
	
	@Test
	public void testUsingSpringTest() {

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
	@AfterAll
	public static void done(){
		log.debug("done");
	}
}
