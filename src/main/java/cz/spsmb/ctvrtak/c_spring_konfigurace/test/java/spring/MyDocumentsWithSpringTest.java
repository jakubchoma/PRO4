/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring_konfigurace.test.java.spring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cz.spsmb.ctvrtak.c_spring_konfigurace.main.java.*;

import java.util.List;

/**
 * @author Felipe Gutierrez
 *
 */
public class MyDocumentsWithSpringTest {
	
	private ClassPathXmlApplicationContext context;
	private SearchEngine engine;
	private Type documentType;

	@BeforeEach
	public void setup(){
		context = new ClassPathXmlApplicationContext("mydocuments-context.xml");
		engine = context.getBean(SearchEngine.class);
		documentType = context.getBean(Type.class);
	}
	
	@Test
	public void testWithSpringFindByType() {	
		List<Doc> documents = engine.findByType(documentType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(documentType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(documentType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(documentType.getExtension(),documents.get(0).getType().getExtension());
	}

	@Test
	public void testWithSpringListAll() {		
		List<Doc> documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}
}
