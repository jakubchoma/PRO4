package cz.spsmb.ctvrtak.c_spring_konfigurace.main.java;

import java.util.List;

public interface SearchEngine {
    List<Doc> findByType(Type documentType);
    List<Doc> listAll();
}
