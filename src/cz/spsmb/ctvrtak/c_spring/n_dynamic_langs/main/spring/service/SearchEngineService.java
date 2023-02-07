package cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Type;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.service.SearchEngine;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.spring.data.DocumentDAO;

/**
 * @author Felipe Gutierrez
 *
 */
@Component("searchEngine")
public class SearchEngineService implements SearchEngine {

    @Autowired
    private DocumentDAO documentDAO;

    public List<Document> findByType(Type documentType) {
        List<Document>  result = new ArrayList<Document>();
        for(Document doc : listAll()){
            if(doc.getType().getName().equals(documentType.getName()))
                result.add(doc);
        }
        return result;
    }

    public List<Document> listAll() {
        List<Document> result = documentDAO.getAll();
        return result;
    }

    public Document findById(String id){
        return documentDAO.findById(id);
    }

    public List<Document> findByLocation(String location) {
        throw new UnsupportedOperationException("findByLocation not yet implemented.");
    }
}
