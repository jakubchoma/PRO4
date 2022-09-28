/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.main.annotated;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
@Repository("documentDAO")
public class AnnotatedDocumentRepository implements DocumentDAO {
	
	public Doc[] getAll() {
		return storage();
	}
	
	private Doc[] storage(){
		List<Doc> result = new ArrayList<Doc>();
		
		Type type = new Type();
		type.setName("PDF");
		type.setDesc("Portable Document Format");
		type.setExtension(".pdf");
		
		
		Doc document = new Doc();
		document.setName("Book Template");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
		
		result.add(document);
		
		document = new Doc();
		document.setName("Sample Contract");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
		
		result.add(document);
		
		type = new Type();
		type.setName("NOTE");
		type.setDesc("Text Notes");
		type.setExtension(".txt");
		
		document = new Doc();
		document.setName("Clustering with RabbitMQ");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
		
		result.add(document);
		
		type = new Type();
		type.setName("WEB");
		type.setDesc("Web Link");
		type.setExtension(".url");
		
		document = new Doc();
		document.setName("Pro Spring Security Book");
		document.setType(type);
		document.setLocation("http://www.apress.com/9781430248187");
		
		result.add(document);
		
		return result.toArray(new Doc[result.size()]);
	}
}
