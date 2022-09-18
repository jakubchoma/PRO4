/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.test;


import java.util.List;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * @author Felipe Gutierrez
 * Java bean konfigurace Springu
 *				- v dnešní době nejvíce preferovaný způsob konfigurace.
 *				  Dostupné od Spring v 3.0.
 */
public class CMyDocumentsBeanConfigurationTest {

	private ApplicationContext context;
	private SearchEngine engine;
	private Type webType;
	
	@BeforeEach
	public void setup(){
		context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
		engine = context.getBean(SearchEngine.class);
		webType = context.getBean(Type.class);
	}
	
	@Test
	public void testWithBeanConfigurationFindByType() {	
		List<Doc> documents = engine.findByType(webType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(webType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(webType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(webType.getExtension(),documents.get(0).getType().getExtension());
	}

	@Test
	public void testWithBeanConfigurationListAll() {		
		List<Doc> documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}

}
