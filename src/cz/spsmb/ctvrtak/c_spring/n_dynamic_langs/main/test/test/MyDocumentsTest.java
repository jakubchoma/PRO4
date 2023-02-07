package cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.test.test;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;
import org.junit.jupiter.api.Assertions;

//import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.spring.service.SecurityServiceFacade;

/**
 * @author Felipe Gutierrez
 * Build, execution, compiler -> compiler, remove groovy !
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring/mydocuments-context.xml")
public class MyDocumentsTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    private static String EMAIL = "john@email.com";
    private static String PASSWORD = "doe";
    private ClassPathXmlApplicationContext context;
    private SecurityServiceFacade security;

    //@Autowired
    //SecurityServiceFacade security;

    @BeforeEach
    public void setup(){
        context = new ClassPathXmlApplicationContext("spring/mydocuments-context.xml");
        security = context.getBean("security",SecurityServiceFacade.class);
    }
    @Test
    //@Ignore
    public void testGroovy(){
        log.debug("Testing Groovy...");
        Assertions.assertNotNull(security);

        Assertions.assertTrue(security.areCredentialsValid(EMAIL,PASSWORD));
    }
/*
    @Test
    //@Ignore
    public void testJRuby(){
        log.debug("Testing JRuby...");
        Assertions.assertNotNull(security);

        Assertions.assertTrue(security.areCredentialsValid(EMAIL,PASSWORD));
    }

    @Test
    public void testBeanShell(){
        log.debug("Testing BeanShell...");
        Assertions.assertNotNull(security);

        Assertions.assertTrue(security.areCredentialsValid(EMAIL,PASSWORD));
    }
*/
}
