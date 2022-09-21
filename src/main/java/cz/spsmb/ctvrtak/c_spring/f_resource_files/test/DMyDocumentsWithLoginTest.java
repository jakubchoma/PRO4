/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.f_resource_files.test;

import static java.lang.System.out;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cz.spsmb.ctvrtak.c_spring.f_resource_files.main.service.Login;

/**
 * @author Felipe Gutierrez
 * Demonstrace použití propreties souboru pro ukládání citlivých dat (jméno, heslo)
 */
public class DMyDocumentsWithLoginTest {
	private static final Logger log = LoggerFactory.getLogger(DMyDocumentsWithLoginTest.class);
	private static final String EMAIL = "test@mydocuments.com";
	private static final String PASS = "test123";
	private static final String SUCCESS = "This user is authorized";
	private static final String FAILURE = "WARNING! This user is not authorized!";
	private ClassPathXmlApplicationContext context;
	
	@BeforeEach
	public void setup(){
		System.setProperty(org.slf4j.simple.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Debug");
		context = new ClassPathXmlApplicationContext("META-INF/spring/mydocuments-login-context.xml");
	}
	
	@Test
	public void testLogin() {	
		log.debug("Login test.");
		Login login = context.getBean(Login.class);
		Assertions.assertNotNull(login);
		if(login.isAuthorized(EMAIL, PASS))
			out.println(SUCCESS);
		else
			out.println(FAILURE);
	}
}
