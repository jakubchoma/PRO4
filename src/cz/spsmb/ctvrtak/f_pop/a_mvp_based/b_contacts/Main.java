package cz.spsmb.ctvrtak.f_pop.a_mvp_based.b_contacts;

import cz.spsmb.ctvrtak.f_pop.a_mvp_based.b_contacts.model.Person;
import cz.spsmb.ctvrtak.f_pop.a_mvp_based.b_contacts.model.PersonRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    private static PersonRepository model = context.getBean("personRepo", PersonRepository.class);

    public static void main(String[] args) {
        for (Person ps:model.getAll()
             ) {
            System.out.println(ps);

        }

    }
}
