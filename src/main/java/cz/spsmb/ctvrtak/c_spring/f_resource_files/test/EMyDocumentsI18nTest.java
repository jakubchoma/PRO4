/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.f_resource_files.test;

import static java.lang.System.out;

import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Felipe Gutierrez
 * Možnost lokalizace
 */
public class EMyDocumentsI18nTest {
	private static final Logger log = LoggerFactory.getLogger(EMyDocumentsI18nTest.class);
	private ClassPathXmlApplicationContext context;
	
	@BeforeEach
	public void setup(){
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-i18n-context.xml");
	}
	
	@Test
	public void testMenu() {	
		log.debug("About to Translate...");
		
		String english = context.getMessage("main.title",null, Locale.ENGLISH);
		String spanish = context.getMessage("main.title",null, new Locale("es"));
		out.println("English: " + english);
		out.println("Spanish: " + spanish);
	}
}
