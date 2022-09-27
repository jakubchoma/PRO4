/**
 * 
 */
package cz.spsmb.ctvrtak.c_spring.m_email_scheduling.test.spring;


import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.spsmb.ctvrtak.c_spring.m_email_scheduling.main.spring.email.EmailService;

/**
 * @author Felipe Gutierrez
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	
	
	@Autowired
	EmailService email;
	
	@Test
	public void testScheduler() throws InterruptedException{
		Thread.sleep(45000);
	}
	
	@Test
	@Disabled
	public void testEmail() throws InterruptedException{
		log.debug("Testing Email...");
		Assertions.assertNotNull(email);
		
		long start = new Date().getTime();
		email.send("felipeg@gmail.com", "felipeg@gmail.com", "Hello World!", "Hello There!!");
		long end = new Date().getTime();
		long time = (end - start)/1000;
		log.debug("Sending email done. Took: " + time + " seconds.");
	}
	
	@Test
	@Disabled
	public void testAsyncEmail() throws InterruptedException{
		log.debug("Testing Async Email...");
		Assertions.assertNotNull(email);
		long start = new Date().getTime();
		email.sendAsync("felipeg@gmail.com", "felipeg@gmail.com", "Hello World!", "Hello There!!");
		long end = new Date().getTime();
		long time = (end - start)/1000;
		log.debug("Sending Async email done. Took: " + time + " seconds.");
	}
	
}
