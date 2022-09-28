/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.b_config2.main.annotated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author Felipe Gutierrez
 *
 */
@Service("engine")
public class AnnotatedSearchEngine implements SearchEngine {

	@Autowired
	private DocumentDAO documentDAO;
	
	public List<Doc> findByType(Type documentType) {
		List<Doc>  result = new ArrayList<Doc>();
		for(Doc doc : listAll()){
			if(doc.getType().getName().equals(documentType.getName()))
				result.add(doc);
		}
		return result;
	}
	
	public List<Doc> listAll() {
		return Arrays.asList(documentDAO.getAll());
	}
}
