package cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.service;

import java.util.List;

import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Document;
import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.model.Type;

/**
 * @author Felipe Gutierrez
 *
 */
public interface DocumentService {
    public List<Document> getAllDocuments();
    public Document findDocumentById(String id);
    public Document saveDocument(String id, Document document);
    public Document removeDocumentById(String id);
    public List<Document> findByType(Type type);
    public boolean updateLocationFromDocumentId(String documentId, String location);
}
