package cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.service;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public interface TypeService {
    public void createNewType(Type type);
    public void updateType(Type type);
    public void removeTypeById(String id);
    public List<Type> getAllDefinedTypes();
    public Type getTypeById(String id);
}
