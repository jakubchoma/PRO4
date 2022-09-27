/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.g_tests.test;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;

/**
 * @author Felipe Gutierrez
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-custom-profiles-context.xml")
// Zdroj profilů. Pokud odebereme, vlastnosti se získají z System.getProperty(propertyKey), tj. z proměnných
// prostředí OS
@ProfileValueSourceConfiguration(CustomProfile.class)
public class CMyDocumentsWithCustomProfilesTest {
	private static final Logger log = LoggerFactory.getLogger(CMyDocumentsWithCustomProfilesTest.class);
	
	@Autowired
	private SearchEngine engine;
	@Autowired
	private Type webType;
	
	@IfProfileValue(name = "environment", values = "dev")
	@Test
	public void testUsingSpringTestWithCustomProfilesX() {	
		try{
		log.debug("Using Spring Test fixtures:");
				
			List<Doc> documents = engine.findByType(webType);
			Assertions.assertNotNull(documents);
			Assertions.assertTrue(documents.size() == 1);
			Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
			Assertions.assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
			Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
			
			documents = engine.listAll();
			Assertions.assertNotNull(documents);
			Assertions.assertTrue(documents.size() == 4);
		}catch(Exception ex){
			log.error(ex.getMessage());
		}
	}
	
	@IfProfileValue(name = "os.name", values = "Unix")
	@Test
	public void testUsingSpringTestWithCustomProfilesY() {	
		try{
			log.debug("Using Spring Test fixtures on Unix:");
				
			//More Testing
			
		}catch(Exception ex){
			log.error(ex.getMessage());
		}
	}
}
