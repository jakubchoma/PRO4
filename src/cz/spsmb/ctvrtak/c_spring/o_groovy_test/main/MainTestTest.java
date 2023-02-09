package cz.spsmb.ctvrtak.c_spring.o_groovy_test.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class MainTestTest {
    private ClassPathXmlApplicationContext context;
    private MainTest test;

    @BeforeEach
    public void setup(){
        context = new ClassPathXmlApplicationContext("context.xml");
        test = context.getBean("test", MainTest.class);
    }
    @Test
    public void testTest(){
        Assertions.assertTrue(test.isValid());
    }



}