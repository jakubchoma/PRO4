/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.g_tests.main.service;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;

/**
 * @author Felipe Gutierrez
 *
 */
@Component
@Profile("qa")
public class FileSearchEngineService implements SearchEngine {
	
	public List<Doc> findByType(Type documentType) {
		throw new UnsupportedOperationException("QA Environment. Not yet implemented operation.");
	}
	
	public List<Doc> listAll() {
		throw new UnsupportedOperationException("QA Environment. Not yet implemented operation.");
	}

}
