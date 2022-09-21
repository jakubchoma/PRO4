/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.f_resource_files.test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.spsmb.ctvrtak.c_spring.f_resource_files.main.views.Menu;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author Felipe Gutierrez
 *
 * Načtení souboru z resources pomocí konfiguračního xml a třídy org.springframework.core.io.Resource.
 */
public class BMyDocumentsWithResourceInjectionTest {
	private static final Logger log = LoggerFactory.getLogger(BMyDocumentsWithResourceInjectionTest.class);
	private ClassPathXmlApplicationContext context;
	
	@BeforeEach
	public void setup(){
		System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-resource-injection-context.xml");
	}
	
	@Test
	public void testMenu() {	
		log.debug("Calling the Menu as Resource Injection:");
		Menu menu = context.getBean(Menu.class);
		Assertions.assertNotNull(menu);
		menu.printMenu();
	}
}
