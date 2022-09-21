package cz.spsmb.ctvrtak.c_spring.f_resource_files.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cz.spsmb.ctvrtak.c_spring.f_resource_files.main.views.ResourceLoaderMenu;

/***
 * Možnost dynamického načítání resource souboru
 */
public class CMyDocumentsWithResourceLoaderInjectionTest {

    private static final Logger log = LoggerFactory.getLogger(CMyDocumentsWithResourceLoaderInjectionTest.class);
    private ClassPathXmlApplicationContext context;

    @BeforeEach
    public void setup(){
        context = new ClassPathXmlApplicationContext("spring/mydocuments-resourceloader-injection-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Calling the Menu as Resourceloader Injection:");
        ResourceLoaderMenu menu = context.getBean(ResourceLoaderMenu.class);
        Assertions.assertNotNull(menu);
        menu.printMenu("classpath:data/menu.txt");
    }
}
