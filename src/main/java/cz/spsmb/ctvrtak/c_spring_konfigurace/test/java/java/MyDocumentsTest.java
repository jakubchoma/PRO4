/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring_konfigurace.test.java.java;

import cz.spsmb.ctvrtak.c_spring_konfigurace.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring_konfigurace.main.java.Type;
import cz.spsmb.ctvrtak.c_spring_konfigurace.main.java.Doc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Felipe Gutierrez
 *
 */
public class MyDocumentsTest {
	
	private SearchEngine engine = new MySearchEngine();

	@Test
	public void testFindByType() {
		Type documentType = new Type();
		documentType.setName("WEB");
		documentType.setDesc("Web Link");
		documentType.setExtension(".url");
		
		List<Doc> documents = engine.findByType(documentType);
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 1);
		Assertions.assertEquals(documentType.getName(),documents.get(0).getType().getName());
		Assertions.assertEquals(documentType.getDesc(),documents.get(0).getType().getDesc());
		Assertions.assertEquals(documentType.getExtension(),documents.get(0).getType().getExtension());
	}
	
	@Test
	public void testListAll() {		
		List<Doc> documents = engine.listAll();
		Assertions.assertNotNull(documents);
		Assertions.assertTrue(documents.size() == 4);
	}

}
