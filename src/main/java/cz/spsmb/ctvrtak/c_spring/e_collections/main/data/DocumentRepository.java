/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.e_collections.main.data;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.b_config2.main.data.DocumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Felipe Gutierrez
 *
 */
public class DocumentRepository implements DocumentDAO {
	private static final Logger log = LoggerFactory.getLogger(DocumentRepository.class);
	private List<Doc> documents = null;
	
	public List<Doc> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Doc> documents) {
		this.documents = documents;
	}

	public Doc[] getAll() {
		if(log.isDebugEnabled())
			log.debug("Start <getAll> Params: ");
		Doc[] result = documents.toArray(new Doc[documents.size()]);
		
		if(log.isDebugEnabled())
			log.debug("End <getAll> Result:" + result);
		return result;
	}

}
