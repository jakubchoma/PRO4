package cz.spsmb.ctvrtak.c_spring.a_config.test.java.java;

import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Doc;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.a_config.main.java.Type;

import java.util.ArrayList;
import java.util.List;

public class MySearchEngine implements SearchEngine {
    @Override
    public List<Doc> findByType(Type documentType) {
        return this.storage().stream().filter(doc -> doc.getType().getName().equals(documentType.getName())).toList();
    }

    @Override
    public List<Doc> listAll() {
        return this.storage();
    }

    private List<Doc> storage() {
        List<Doc> out = new ArrayList<>();
        Type type;
        type = new Type("PDF", "Portable Document Format", ".pdf");
        out.add(new Doc("Book Template", type, "/Users/felipeg/Documents/Random/Book Template.pdf"));
        out.add(new Doc("Book Template", type, "/Documents/Book Template.pdf"));

        type = new Type("NOTE", "Text Notes", ".txt");
        out.add(new Doc("Clustering with RabbitMQ", type, "/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt"));

        type = new Type("WEB", "Web Link", ".url");
        out.add(new Doc("Pro Spring Security Book", type, "http://www.apress.com/9781430248187"));
        return out;
    }
}
